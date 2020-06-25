package muzi.muxin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import muzi.muxin.pojo.Permission;

@Service
public interface PermissionService {
	
	
	
	public List<Permission> findAll();

	public void save(Permission permission);

}
