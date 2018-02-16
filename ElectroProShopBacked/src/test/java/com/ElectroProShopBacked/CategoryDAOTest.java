package com.ElectroProShopBacked;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ElectroProShopBacked.dao.CategoryDAO;
import com.ElectroProShopBacked.model.Category;

import junit.framework.Assert;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryDAOTest{
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
	}
	@Test
	public void test1_AddCategory() {
		Category category=(Category)context.getBean("category");
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category.setCid(0);
		category.setCategoryName("Watch");
		Assert.assertEquals(true, categoryDAO.addCategory(category));
	}
	@Test
	public void test2_UpdateCategory() {
		Category category=(Category)context.getBean("category");
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category.setCategoryName("Mens Watch");
		Assert.assertEquals(true, categoryDAO.updateCategory(category));
	}
	@Test
	public void test3_DeleteCategory() {
		Category category=(Category)context.getBean("category");
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		Assert.assertEquals(true, categoryDAO.deleteCategory(category));
	}
	@AfterClass
	public static void tearDown(){
		context.close();
	}
	
}
