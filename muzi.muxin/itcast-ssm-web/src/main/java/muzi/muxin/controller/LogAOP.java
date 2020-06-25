package muzi.muxin.controller;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import muzi.muxin.pojo.SysLog;
import muzi.muxin.service.SysLogService;

@Component
@Aspect
public class LogAOP {
	
	private Date visitTime;//访问开始时间
	private Class clazz;//访问哪个类
	private Method method;//访问哪个方法
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private SysLogService sysLogService;
	
	
	//前置
	@Before("execution(* muzi.muxin.controller.*.*(..))")
	public void doBefore(JoinPoint jp) throws NoSuchMethodException, SecurityException {
		
		visitTime = new Date();
		clazz = jp.getTarget().getClass();//访问的类
		String methodName = jp.getSignature().getName();//方法名
		
		Object[] args = jp.getArgs();
		
		if(args==null||args.length==0) {
			method=clazz.getMethod(methodName);
		}else {
			Class[] classArgs = new Class[args.length];
			for(int i=0;i<args.length ;i++) {
				classArgs[i]=args[i].getClass();
			}
			method = clazz.getMethod(methodName, classArgs);
		}
	
		
		
	}
	
	//后置
	@After("execution(* muzi.muxin.controller.*.*(..))")
	public void doAfter(JoinPoint jp) {
		long time = new Date().getTime()-visitTime.getTime();
		
		//获取url
		
		String url = "";
		if(clazz!=null&&method!=null&&clazz!=LogAOP.class) {
			RequestMapping classAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
			if(classAnnotation!=null) {
				String[] classValue = classAnnotation.value();
				RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
				if(methodAnnotation!=null) {
					String[] methodValue = methodAnnotation.value();
					url = classValue[0]+methodValue[0];
					
					String ip =  request.getRemoteAddr();
					SecurityContext context = SecurityContextHolder.getContext();
					User user = (User) context.getAuthentication().getPrincipal();
					
					String username = user.getUsername();
					
					//日志信息封装都syslog
					
					SysLog syslog = new SysLog();
					syslog.setExecutionTime(time);
					syslog.setIp(ip);
					syslog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
					syslog.setUrl(url);
					syslog.setUsername(username);
					syslog.setVisitTime(visitTime);
					
					//调用service 完成保存
					sysLogService.save(syslog);
				}
			}
		}
		
		
	
	}
	
	
	

}
