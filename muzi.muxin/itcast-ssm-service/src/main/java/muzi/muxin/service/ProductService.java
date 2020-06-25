package muzi.muxin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import muzi.muxin.pojo.Product;


@Service
public interface ProductService {
	
		//查询所有产品
		public List<Product> findAll() throws Exception;
		
		
		//新增产品
		public void save(Product product);
		
		
	}
