package muzi.muxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import muzi.muxin.pojo.Member;
import muzi.muxin.pojo.Orders;
import muzi.muxin.pojo.Product;


@Repository
public interface OrderDao {

	@Select("select *  from orders")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="orderNum",column="orderNum"),
		@Result(property="orderTime",column="orderTime"),
		@Result(property="orderStatus",column="orderStatus"),
		@Result(property="peopleCount",column="peopleCount"),
		@Result(property="payType",column="payType"),
		@Result(property="orderDesc",column="orderDesc"),
		@Result(property="product",column="productId",javaType=Product.class,one=@One(select="muzi.muxin.dao.ProductDao.findById"))
	})
	public List<Orders> findAll() throws Exception;

	
	//多表操作
	@Select("select *  from orders where id=#{ordersId} ")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="orderNum",column="orderNum"),
		@Result(property="orderTime",column="orderTime"),
		@Result(property="orderStatus",column="orderStatus"),
		@Result(property="peopleCount",column="peopleCount"),
		@Result(property="payType",column="payType"),
		@Result(property="orderDesc",column="orderDesc"),
		@Result(property="product",column="productId",javaType=Product.class,one=@One(select="muzi.muxin.dao.ProductDao.findById")),
		@Result(property="member",column="memberId",javaType=Member.class,one=@One(select="muzi.muxin.dao.MemberDao.findById")),
		@Result(property="travellers",column="id",javaType=java.util.List.class,many= @Many(select="muzi.muxin.dao.TravellerDao.findByOrderId"))
	})
	public Orders findById(int ordersId);
	
}
