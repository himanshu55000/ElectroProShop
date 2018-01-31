package com.ElectroProShopBacked.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ElectroProShopBacked.dao.CategoryDAO;
import com.ElectroProShopBacked.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Transactional
	public boolean updateCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional
	public boolean deleteCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Category getCategoryById(int id) {
		Session session = sessionFactory.openSession();
		try {
			Category category=session.get(Category.class,id);
			session.close();
			return category;
		} catch (Exception e) {
			session.close();
			return null;
		}
		
	}

	public List<Category> getAllCategory() {
		Session session = sessionFactory.openSession();
		List<Category> list=session.createQuery("from Category").list();
		return list;
	}
}
