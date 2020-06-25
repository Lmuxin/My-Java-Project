package muzi.muxin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import muzi.muxin.dao.OrderDao;
import muzi.muxin.pojo.Orders;
import muzi.muxin.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	/*@Override
	public List<Orders> findAll() throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}*/

	@Override
	public List<Orders> findAll(int page, int size) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return orderDao.findAll();
	}

	@Override
	public Orders findById(int ordersId) {
		return orderDao.findById(ordersId);
	}
	

}
