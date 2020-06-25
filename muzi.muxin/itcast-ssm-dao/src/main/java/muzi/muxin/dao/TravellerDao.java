package muzi.muxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import muzi.muxin.pojo.Traveller;


public interface TravellerDao {
	
	
	@Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{orderId})")
	public List<Traveller> findByOrderId(int orderId);

}
