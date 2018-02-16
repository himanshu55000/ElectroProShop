package com.ElectroProShopBacked;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ElectroProShopBacked.dao.OrdersDAO;
import com.ElectroProShopBacked.model.Orders;
import com.ElectroProShopBacked.model.ShippingAddress;

import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdersDAOTest {

	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void setup() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
	}

	@Test
	public void test1_InsertShippingAddress() {
		ShippingAddress shippingAddress=(ShippingAddress)context.getBean("shippingAddress");
		OrdersDAO ordersDAO=(OrdersDAO)context.getBean("ordersDAO");
		shippingAddress.setId(0);
		shippingAddress.setHouse_locality("test");
		shippingAddress.setCity("test");
		shippingAddress.setPincode(111111);
		shippingAddress.setState("test");
		Assert.assertEquals(true, ordersDAO.insertShippingAddress(shippingAddress));
	}

	@Test
	public void test2_InsertOrders() {
		Orders orders=(Orders)context.getBean("orders");
		OrdersDAO ordersDAO=(OrdersDAO)context.getBean("ordersDAO");
		orders.setId(0);
		orders.setOrderId(111111);
		orders.setOrderImage("image.jpg");
		orders.setOrderPrice(12000.00);
		orders.setOrderProductId(10);
		orders.setOrderProductName("Test Product");
		orders.setOrderQuantity(10);
		orders.setPayMode("test");
		orders.setShippingAddress((ShippingAddress)context.getBean("shippingAddress"));
		Assert.assertEquals(true, ordersDAO.insertOrders(orders));
	}
	@AfterClass
	public static void tearDown(){
		context.close();
	}

}
