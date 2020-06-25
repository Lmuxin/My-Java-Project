package muzi.muxin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import muzi.muxin.dao.PermissionDao;
import muzi.muxin.pojo.Permission;
import muzi.muxin.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl  implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;
	@Override
	public List<Permission> findAll() {
		return permissionDao.findAll();
	}
	@Override
	public void save(Permission permission) {
		permissionDao.save(permission);
	}
	
	

}
