package muzi.muxin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import muzi.muxin.pojo.Permission;
import muzi.muxin.pojo.Role;

@Service
public interface RoleService {
	
	public List<Role> findAll();

	public void save(Role role);

	public Role findById(int roleId);

	public List<Permission> findOtherPermissions(int roleId);

	public void addPermissionToRole(int roleId, int[] permissionIds);

}
