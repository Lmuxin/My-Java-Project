package muzi.muxin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import muzi.muxin.dao.SysLogDao;
import muzi.muxin.pojo.SysLog;
import muzi.muxin.service.SysLogService;


@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
	
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public void save(SysLog sysLog) {
		sysLogDao.save(sysLog);
	}

	@Override
	public List<SysLog> findAll() {
		// TODO Auto-generated method stub
		return sysLogDao.findAll();
	}

}
