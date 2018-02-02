package com.ElectroProShopBacked.dao;

import java.util.List;

import com.ElectroProShopBacked.model.Product;

public interface ProductDAO {
	public void insertOrUpdateProduct(Product product);
	public Product getProduct(int prod_id);
	public List<Product> getAllProduct();
	public void deleteProduct(Product product);
}
