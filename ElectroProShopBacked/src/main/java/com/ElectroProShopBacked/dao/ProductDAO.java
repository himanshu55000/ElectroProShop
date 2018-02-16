package com.ElectroProShopBacked.dao;

import java.util.List;

import com.ElectroProShopBacked.model.Product;

public interface ProductDAO {
	public boolean insertOrUpdateProduct(Product product);
	public Product getProduct(int prod_id);
	public List<Product> getAllProduct();
	public boolean deleteProduct(Product product);
}
