package muzi.muxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import muzi.muxin.pojo.Permission;

public interface PermissionDao {

	@Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
	public List<Permission> findPermissionByRoleId(int id);

	@Select("select * from permission")
	public List<Permission> findAll();
	
	@Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")

	public void save(Permission permission);
}	
