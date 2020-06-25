package muzi.muxin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import muzi.muxin.pojo.Orders;
import muzi.muxin.service.OrderService;


@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//查询全部订单  未分页
	/*@RequestMapping("/findAll.do")
	public ModelAndView findAll() throws Exception {
		ModelAndView mv =new ModelAndView();
		List<Orders> orderList = orderService.findAll();
		mv.addObject("ordersList",orderList);
		mv.setViewName("orders-list");
		return mv;
	}
	*/
	
	@RequestMapping("/findAll.do")
	public ModelAndView findAll(@RequestParam(name="page",required=true,defaultValue="1") Integer page,
			@RequestParam(name="size",required=true,defaultValue="4") Integer size)  throws Exception {
		ModelAndView mv =new ModelAndView();
		List<Orders> orderList = orderService.findAll(page,size);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		PageInfo pageInfo = new PageInfo(orderList);
		mv.addObject("pageInfo",pageInfo);
		mv.setViewName("orders-page-list");
		return mv;
		
	}
	
	@RequestMapping("/findById.do")
	public ModelAndView findById(@RequestParam(name="id",required=true) Integer ordersId)  throws Exception {
		ModelAndView mv =new ModelAndView();
		Orders  orders = orderService.findById(ordersId);
		mv.addObject("orders",orders);
		mv.setViewName("orders-show");
		return mv;
		
	}
		
}
