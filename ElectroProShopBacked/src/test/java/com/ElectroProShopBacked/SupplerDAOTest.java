package com.ElectroProShopBacked;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ElectroProShopBacked.dao.SupplierDAO;
import com.ElectroProShopBacked.model.Supplier;

import junit.framework.Assert;

public class SupplerDAOTest{
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
	}
	@Test
	public void testAddSupplier() {
		Supplier supplier=(Supplier)context.getBean("supplier");
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		supplier.setSid(0);
		supplier.setSupplierName("Ajay");
		Assert.assertEquals(true, supplierDAO.addSupplier(supplier));
	}
	@Test
	public void testUpdateSupplier() {
		Supplier supplier=(Supplier)context.getBean("supplier");
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		supplier.setSid(1);
		supplier.setSupplierName("Vijay");
		Assert.assertEquals(true, supplierDAO.updateSupplier(supplier));
	}
	@Test
	public void testDeleteSupplier() {
		Supplier supplier=(Supplier)context.getBean("supplier");
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		supplier.setSid(2);
		Assert.assertEquals(true, supplierDAO.deleteSupplier(supplier));
	}
	@AfterClass
	public static void tearDown(){
		context.close();
	}
	
}
