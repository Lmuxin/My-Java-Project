package muzi.muxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import muzi.muxin.pojo.SysLog;

public interface SysLogDao {

	
	
	@Insert("insert into syslog"
			+ "(visitTime,username,ip,url,executionTime,method) "
			+ "values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
	public void save(SysLog sysLog);

	
	
	@Select("select * from syslog")
	public List<SysLog> findAll();
	

}
