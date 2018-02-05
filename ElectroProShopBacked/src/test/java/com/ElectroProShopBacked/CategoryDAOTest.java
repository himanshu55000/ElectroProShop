/*package com.ElectroProShopBacked;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ElectroProShopBacked.dao.CategoryDAO;
import com.ElectroProShopBacked.model.Category;

import junit.framework.Assert;

public class CategoryDAOTest{
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
	}
	@Test
	public void testAddCategory() {
		Category category=(Category)context.getBean("category");
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category.setCid(0);
		category.setCategoryName("Watch");
		Assert.assertEquals(true, categoryDAO.addCategory(category));
	}
	@Test
	public void testUpdateCategory() {
		Category category=(Category)context.getBean("category");
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category.setCid(1);
		category.setCategoryName("Mens Watch");
		Assert.assertEquals(true, categoryDAO.updateCategory(category));
	}
	@Test
	public void testDeleteCategory() {
		Category category=(Category)context.getBean("category");
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category.setCid(2);
		Assert.assertEquals(true, categoryDAO.deleteCategory(category));
	}
	@AfterClass
	public static void tearDown(){
		context.close();
	}
	
}
*/