package com.ElectroProShopBacked.dao;

import java.util.List;

import com.ElectroProShopBacked.model.Category;

public interface CategoryDAO {
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategoryById(int id);
	public List<Category> getAllCategory();
}
