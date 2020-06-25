package muzi.muxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import muzi.muxin.pojo.Product;


@Repository
public interface ProductDao{
	
	//查询所有产品
	@Select("select * from  product")
	public List<Product> findAll() throws Exception;
	
	//新增产品
																																																								
	@Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(default,#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})") 
	public void save(Product product); 
	
	
	//根据id查询产品
	
	@Select("select * from product where id =#{id}")
	public Product findById(int id);
																																																								    
}
