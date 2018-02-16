package com.ElectroProShopBacked;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ElectroProShopBacked.dao.CartDAO;
import com.ElectroProShopBacked.model.Cart;

import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartDAOTest {
	
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void setup() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
	}

	@Test
	public void test1_InsertOrUpdateCart() {
		Cart cart=(Cart)context.getBean("cart");
		CartDAO cartDAO=(CartDAO)context.getBean("cartDAO");
		cart.setCartId(0);
		cart.setCartImage("image.jpg");
		cart.setCartPrice(12000.12);
		cart.setCartProductId(10);
		cart.setCartQuantity(10);
		cart.setCartProductName("test product");
		Assert.assertEquals(true, cartDAO.insertOrUpdateCart(cart));
	}

	@Test
	public void test2_DeleteCart() {
		Cart cart=(Cart)context.getBean("cart");
		CartDAO cartDAO=(CartDAO)context.getBean("cartDAO");
		Assert.assertEquals(true, cartDAO.deleteCart(cart.getCartId()));
	}
	
	@AfterClass
	public static void tearDown(){
		context.close();
	}
	
}
