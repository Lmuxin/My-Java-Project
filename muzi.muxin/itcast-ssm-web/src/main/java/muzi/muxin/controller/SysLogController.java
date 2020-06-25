package muzi.muxin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import muzi.muxin.pojo.SysLog;
import muzi.muxin.service.SysLogService;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
	
	
	
	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping("findAll.do")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView();
		
		List<SysLog> sysLogList = sysLogService.findAll();
		
		
		mv.addObject("sysLogs",sysLogList);
		mv.setViewName("syslog-list");
		
		return mv;
		
		
		
		
	}

}
