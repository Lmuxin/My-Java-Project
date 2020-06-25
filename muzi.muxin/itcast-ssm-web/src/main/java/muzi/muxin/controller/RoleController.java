package muzi.muxin.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import muzi.muxin.pojo.Permission;
import muzi.muxin.pojo.Role;
import muzi.muxin.service.RoleService;


@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/findAll.do")
	//@RolesAllowed("ADMIN")
	public ModelAndView findAll()  throws Exception {
		ModelAndView mv =new ModelAndView();
		List<Role>  roleList = roleService.findAll();
		mv.addObject("roleList",roleList);
		mv.setViewName("role-list");
		return mv;
		
	}
	
	//根据roleid查询role，并查询可以添加的权限
	
	@RequestMapping("/findRoleByIdAndAllPermission.do")
	public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name="id",required=true)Integer roleId)  throws Exception {
		Role role  = roleService.findById(roleId);
		ModelAndView mv =new ModelAndView();
		List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
		mv.addObject("role",role);
		mv.addObject("permissionList",otherPermissions);
		mv.setViewName("role-permission-add");
		
		return mv;
		
	}
	
	
	
	
	@RequestMapping("/save.do")
	public String save(Role role)  throws Exception {
		roleService.save(role);
		return "redirect:findAll.do";
		
	}
	
	
	
	//给角色添加权限
	
		
	@RequestMapping("/addPermissionToRole.do")
	public String addPermissionToRole(@RequestParam(name="roleId",required=true)int roleId,@RequestParam(name="ids",required=true)int[] permissionIds)  throws Exception {
		roleService.addPermissionToRole(roleId,permissionIds);
		return "redirect:findAll.do";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
