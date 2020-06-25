package muzi.muxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import muzi.muxin.pojo.Role;
import muzi.muxin.pojo.UserInfo;


@Repository
public interface UserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "muzi.muxin.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    @Select("select * from users")
	public List<UserInfo> findAll();

    
    @Insert("insert into users(id,email,username,password,phonenum,status) values(default,#{email},#{username},#{password},#{phoneNum},#{status})")
	public void save(UserInfo userinfo);

	
	
	@Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phonenum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "muzi.muxin.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findById(int id) throws Exception;

	
	
	@Select("select * from role where id not in(select roleId from users_role where userId=#{userId})")
	public List<Role> findOtherRole(int userId);

	
	 
	
	
	@Insert("insert into users_role(userId,roleId) values (#{userId},#{roleId})")
	public void addRoleToUser(@Param("userId")int userId, @Param("roleId")int roleId);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
