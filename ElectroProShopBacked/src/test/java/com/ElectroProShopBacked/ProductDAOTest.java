package com.ElectroProShopBacked;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ElectroProShopBacked.dao.ProductDAO;
import com.ElectroProShopBacked.model.Product;

import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDAOTest {
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void setup() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
	}
	
	@Test
	public void test1_InsertOrUpdateProduct() {
		Product product=(Product)context.getBean("product");
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		product.setProId(0);
		product.setProName("Test Product");
		product.setImageName("image.jpg");
		product.setProPrice(12000f);
		product.setProDesc("test");
		product.setProQuantity(5);
		Assert.assertEquals(true, productDAO.insertOrUpdateProduct(product));
	}

	@Test
	public void test2_DeleteProduct() {
		Product product=(Product)context.getBean("product");
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		Assert.assertEquals(true, productDAO.deleteProduct(product));
	}
	@AfterClass
	public static void tearDown(){
		context.close();
	}
	
}
