package muzi.muxin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import muzi.muxin.dao.RoleDao;
import muzi.muxin.pojo.Permission;
import muzi.muxin.pojo.Role;
import muzi.muxin.service.RoleService;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}
	@Override
	public void save(Role role) {
		roleDao.save(role)	;	
	}
	@Override
	public Role findById(int roleId) {
		// TODO Auto-generated method stub
		return roleDao.findById(roleId);
	}
	@Override
	public List<Permission> findOtherPermissions(int roleId) {
		// TODO Auto-generated method stub
		return roleDao.findOtherPermission(roleId);
	}
	@Override
	public void addPermissionToRole(int roleId, int[] permissionIds) {

		for(int permissionId:permissionIds) {
			roleDao.addPermissionToRole(roleId,permissionId);
		}
		
		
	}

}
