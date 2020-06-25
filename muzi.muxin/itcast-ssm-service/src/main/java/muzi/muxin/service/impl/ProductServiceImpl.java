package muzi.muxin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import muzi.muxin.dao.ProductDao;
import muzi.muxin.pojo.Product;
import muzi.muxin.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	//查询所有产品
	@Override
	public List<Product> findAll() throws Exception {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	
	//新增产品
	@Override
	public void save(Product product) {
		productDao.save(product);
	}
	

}
