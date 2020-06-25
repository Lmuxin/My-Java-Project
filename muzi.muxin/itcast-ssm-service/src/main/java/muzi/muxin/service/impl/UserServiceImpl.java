package muzi.muxin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import muzi.muxin.dao.UserDao;
import muzi.muxin.pojo.Role;
import muzi.muxin.pojo.UserInfo;
import muzi.muxin.service.UsersService;
import muzi.muxin.utils.BCryptPasswordEncoderUtils;


@Service("userService")
@Transactional
public class UserServiceImpl  implements UsersService{
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void save(UserInfo userinfo) {
		//对密码加密
		userinfo.setPassword(BCryptPasswordEncoderUtils.encodePassword(userinfo.getPassword()));
		userDao.save(userinfo);
		
	}

	@Override
	public UserInfo findById(Integer id) throws Exception {
		return  userDao.findById(id);
	}
	
    
	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		UserInfo userInfo = null;
		try {
			userInfo = userDao.findByUsername(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		List<Role> roles = userInfo.getRoles(); 
		List<SimpleGrantedAuthority> authoritys = getAuthority(roles);
		User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, authoritys); 
		return user; 
		
	}

	private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) { 
		List<SimpleGrantedAuthority> authoritys = new ArrayList(); 
		for (Role role : roles) { 
			authoritys.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName())); 
			}
		return authoritys; 
		}

	@Override
	public List<Role> findOtherRole(int userId) {
		return userDao.findOtherRole(userId);
	}

	@Override
	public void addRoleToUser(Integer userId, Integer[] roleIds) {
		for(int roleId:roleIds)
		{
			userDao.addRoleToUser(userId,roleId);
		}
	
	}
}
        
        
        
        
        
        
        
        
        
        
        
        
