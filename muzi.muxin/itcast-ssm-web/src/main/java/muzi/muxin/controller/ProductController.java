package muzi.muxin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import muzi.muxin.pojo.Product;
import muzi.muxin.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	//查询所有产品
	@RequestMapping("/findAll.do")
	public ModelAndView findALL() throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Product> ps = productService.findAll();
		mav.addObject("productList",ps);
		mav.setViewName("product-list1");
		return mav;
	}
	
	
	
	//添加产品
	
	@RequestMapping("/save.do")
	public String save(Product product) throws Exception{
		productService.save(product);
		return "redirect:findAll.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
