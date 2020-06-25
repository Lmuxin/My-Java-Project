package muzi.muxin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import muzi.muxin.pojo.SysLog;

@Service
public interface SysLogService {
	
	
	public void save(SysLog sysLog);

	public List<SysLog> findAll();

}
