package muzi.muxin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import muzi.muxin.pojo.Permission;
import muzi.muxin.service.PermissionService;


@Controller
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/findAll.do")
	public ModelAndView findAll() throws Exception {
		ModelAndView mv =new ModelAndView();
		List<Permission> permissionList = permissionService.findAll();
		mv.addObject("permissionList",permissionList);
		mv.setViewName("permission-list");
		return mv;
	}
	
	

	@RequestMapping("/save.do")
	public String save(Permission permission) throws Exception {
		permissionService.save(permission);
		return "redirect:findAll.do";
	}
}
