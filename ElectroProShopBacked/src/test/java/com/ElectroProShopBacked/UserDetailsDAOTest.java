package com.ElectroProShopBacked;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ElectroProShopBacked.dao.UserDetailsDAO;
import com.ElectroProShopBacked.model.UserDetails;

import junit.framework.Assert;

public class UserDetailsDAOTest{
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void beforeTest(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
	}
	@Test
	public void testAddUserDetails() {
		UserDetails userDetails=(UserDetails)context.getBean("userDetails");
		UserDetailsDAO userDetailsDAO=(UserDetailsDAO)context.getBean("userDetailsDAO");
		userDetails.setUsername("admin3");
		userDetails.setFull_name("admin");
		userDetails.setEnabled(true);
		userDetails.setAddress("None");
		userDetails.setMobile(0000000000);
		userDetails.setPassword("admin");
		userDetails.setEmail("admin@test.com");
		userDetails.setRole("ROLE_ADMIN");
		Assert.assertEquals(true, userDetailsDAO.addUserDetails(userDetails));
	}
	@Test
	public void testValidateUser() {
		UserDetailsDAO userDetailsDAO=(UserDetailsDAO)context.getBean("userDetailsDAO");
		Assert.assertEquals(true, userDetailsDAO.validateUser("admin", "admin"));
	}
	
	@AfterClass
	public static void afterTest(){
		context.close();
	}
	
}
