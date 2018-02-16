package com.ElectroProShopBacked;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ElectroProShopBacked.dao.SupplierDAO;
import com.ElectroProShopBacked.model.Supplier;

import junit.framework.Assert;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupplerDAOTest{
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
	}
	@Test
	public void test1_AddSupplier() {
		Supplier supplier=(Supplier)context.getBean("supplier");
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		supplier.setSid(0);
		supplier.setSupplierName("Ajay");
		Assert.assertEquals(true, supplierDAO.addSupplier(supplier));
	}
	@Test
	public void test2_UpdateSupplier() {
		Supplier supplier=(Supplier)context.getBean("supplier");
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		supplier.setSupplierName("Vijay");
		Assert.assertEquals(true, supplierDAO.updateSupplier(supplier));
	}
	@Test
	public void test3_DeleteSupplier() {
		Supplier supplier=(Supplier)context.getBean("supplier");
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		Assert.assertEquals(true, supplierDAO.deleteSupplier(supplier));
	}
	@AfterClass
	public static void tearDown(){
		context.close();
	}
}