package muzi.muxin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import muzi.muxin.pojo.Orders;


@Service
public interface OrderService {

	//查询全部订单 未分页
	//List<Orders> findAll() throws Exception;
	
	//查询全部订单 分页
	public List<Orders> findAll(int page,int size) throws Exception;

	public Orders findById(int ordersId);
}
