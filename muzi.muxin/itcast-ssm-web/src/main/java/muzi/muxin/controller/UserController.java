package muzi.muxin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import muzi.muxin.pojo.Role;
import muzi.muxin.pojo.UserInfo;
import muzi.muxin.service.UsersService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/findAll.do")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView();
		List<UserInfo>  userList=usersService.findAll();
		mv.addObject("userList",userList);
		mv.setViewName("user-list");
		return mv;
		
	}
	
	@RequestMapping("/save.do")
	public String  save(UserInfo userinfo) {

		usersService.save(userinfo);
		
		return "redirect:findAll.do";
		
	}
	
	
	@RequestMapping("/findById.do")
	public ModelAndView  findById(Integer id) throws Exception {
		ModelAndView mv = new ModelAndView();
		UserInfo userInfo = usersService.findById(id);
		mv.addObject("user",userInfo);
		mv.setViewName("user-show");
		
		return mv;
		
	}
	
	
	//查询用户可以添加的角色
	@RequestMapping("/findUserByIdAndAllRole.do")
	public ModelAndView  findUserByIdAndAllRole(@RequestParam(name="id",required=true)Integer userId) throws Exception {
		ModelAndView mv = new ModelAndView();
		//根据用户id查询用户 
		UserInfo userInfo = usersService.findById(userId);
		
		//根据用户id查询可以添加的角色
		List<Role> otherRoles = usersService.findOtherRole(userId);
		
		mv.addObject("user", userInfo);
		mv.addObject("roleList",otherRoles);
		mv.setViewName("user-role-add");
		
		return mv;
		
	}
	
	
	
		//给用户添加角色
		@RequestMapping("/addRoleToUser.do")
		public String  addRoleToUser(@RequestParam(name="userId",required=true)Integer userId,@RequestParam(name="ids",required=true)Integer[] roleIds) throws Exception {
			ModelAndView mv = new ModelAndView();
			//根据用户id查询用户 
			  usersService.addRoleToUser(userId,roleIds);
			  return "redirect:findAll.do";
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
