package muzi.muxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import muzi.muxin.pojo.Permission;
import muzi.muxin.pojo.Role;

public interface RoleDao {
	
	@Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
	@Results({
				@Result(id = true,property="id",column="id"),
				@Result(property="roleName",column="roleName"),
				@Result(property="roleDesc",column="roleDesc"),
				@Result(property="permissions",column="id",javaType=java.util.List.class,many=@Many(select="muzi.muxin.dao.PermissionDao.findPermissionByRoleId"))
	})
	public List<Role>  findRoleByUserId(int userId);

	
	@Select("select * from role")
	public List<Role> findAll();


	@Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
	public void save(Role role);

	@Select("select * from role where id = #{roleId}")
	public Role findById(int roleId);

	@Select("select * from permission where id not in(select permissionId from role_permission where roleId =  #{roleId})")
	public List<Permission> findOtherPermission(int roleId);

	@Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
	public void addPermissionToRole(@Param("roleId")int roleId, @Param("permissionId")int permissionId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
