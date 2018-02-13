package com.electroproshop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ElectroProShopBacked.dao.CartDAO;
import com.ElectroProShopBacked.dao.OrdersDAO;
import com.ElectroProShopBacked.model.Cart;
import com.ElectroProShopBacked.model.Orders;
import com.ElectroProShopBacked.model.ShippingAddress;
import com.ElectroProShopBacked.model.UserDetails;

@Controller
public class OrdersController {
	@Autowired
	CartDAO cartDAO;
	@Autowired
	OrdersDAO ordersDAO;
	@Autowired
	Orders orders;
	
	@RequestMapping("/myOrders")
	public ModelAndView myOrders() {
		ModelAndView m = new ModelAndView("orders");
		List<Orders> list=ordersDAO.getOrdersByUser(SecurityContextHolder.getContext().getAuthentication().getName());
		m.addObject("orderList", list);
		return m;
	}
	@RequestMapping(value="/placeOrder",method=RequestMethod.POST)
	public ModelAndView placeOrder(@RequestParam Map<String,String> data) {
		ModelAndView m = new ModelAndView("redirect:/myOrders");
		ShippingAddress shippingAddress=new ShippingAddress();
		shippingAddress.setHouse_locality(data.get("locality"));
		shippingAddress.setCity(data.get("city"));
		shippingAddress.setPincode(Integer.parseInt(data.get("pincode")));
		shippingAddress.setState(data.get("state"));
		ordersDAO.insertShippingAddress(shippingAddress);
		orders.setShippingAddress(shippingAddress);
		UserDetails userDetails=new UserDetails();
		userDetails.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		orders.setOrderUserDetails(userDetails);
		orders.setOrderId((long)Math.random()*100000000);
		List<Cart> list=cartDAO.getCartByUser(SecurityContextHolder.getContext().getAuthentication().getName());
		for(Cart c:list){
			orders.setId(0);
			orders.setOrderImage(c.getCartImage());
			orders.setOrderPrice(c.getCartPrice()*c.getCartQuantity());
			orders.setOrderQuantity(c.getCartQuantity());
			orders.setOrderProductName(c.getCartProductName());
			orders.setPayMode(data.get("payMode"));
			ordersDAO.insertOrders(orders);
			cartDAO.deleteCart(c.getCartId());
		}
		return m;
	}
	

}
