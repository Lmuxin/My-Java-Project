package muzi.muxin.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import muzi.muxin.pojo.Role;
import muzi.muxin.pojo.UserInfo;




public interface UsersService extends UserDetailsService{
	
	
	public List<UserInfo>  findAll();

	public void save(UserInfo userinfo);
	
	
	public UserInfo findById(Integer id) throws Exception;

	public List<Role> findOtherRole(int userId);

	public void addRoleToUser(Integer userId, Integer[] roleIds);

}
