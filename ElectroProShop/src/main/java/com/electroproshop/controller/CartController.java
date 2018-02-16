package com.electroproshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ElectroProShopBacked.dao.CartDAO;
import com.ElectroProShopBacked.dao.ProductDAO;
import com.ElectroProShopBacked.model.Cart;
import com.ElectroProShopBacked.model.Product;
import com.ElectroProShopBacked.model.UserDetails;

@Controller
public class CartController {
	@Autowired
	CartDAO cartDAO;
	@Autowired
	ProductDAO producDAO;
	@RequestMapping("/user/cart")
	public ModelAndView addToCart() {
		ModelAndView m = new ModelAndView("cart");
		List<Cart> list=cartDAO.getCartByUser(SecurityContextHolder.getContext().getAuthentication().getName());
		m.addObject("cartList", list);
		return m;
	}
	@RequestMapping("/user/checkout")
	public ModelAndView checkout() {
		ModelAndView m = new ModelAndView("checkout");
		return m;
	}
	@RequestMapping("/user/addToCart/{pid}")
	public ModelAndView addToCart(@PathVariable int pid) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		ModelAndView m = new ModelAndView("redirect:/user/cart");
		Product product=producDAO.getProduct(pid);
		UserDetails user=new UserDetails();
		user.setUsername(authentication.getName());
		Cart cart=cartDAO.getCartItemByUser(pid,authentication.getName());
		if(cart!=null)
		{
			cart.setCartQuantity(cart.getCartQuantity()+1);
		}
		else{
		cart=new Cart();
		cart.setCartImage(product.getImageName());
		cart.setCartPrice((double)product.getProPrice());
		cart.setCartProductId(pid);
		cart.setCartQuantity(1);
		cart.setCartProductName(product.getProName());
		cart.setCartUserDetails(user);
		//cart.setOrdered(false);
		}
		cartDAO.insertOrUpdateCart(cart);
		return m;
	}
	@RequestMapping("/user/deleteCart/{cartId}")
	public ModelAndView deleteCart(@PathVariable int cartId) {
		ModelAndView m = new ModelAndView("redirect:/user/cart");
		cartDAO.deleteCart(cartId);
		return m;
	}
	@RequestMapping("/user/updateCart/{cartId}/{flag}")
	public ModelAndView deleteCart(@PathVariable int cartId,@PathVariable char flag) {
		ModelAndView m = new ModelAndView("redirect:/user/cart");
		Cart cart=cartDAO.getCart(cartId,SecurityContextHolder.getContext().getAuthentication().getName());
		switch(flag){
		case '+':
			cart.setCartQuantity(cart.getCartQuantity()+1);
			break;
		case '-':
			if(cart.getCartQuantity()>1)
				cart.setCartQuantity(cart.getCartQuantity()-1);
			break;
		}
		cartDAO.insertOrUpdateCart(cart);
		return m;
	}
	
}
