package com.ElectroProShopBacked.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ElectroProShopBacked.dao.SupplierDAO;
import com.ElectroProShopBacked.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addSupplier(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional
	public boolean deleteSupplier(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Supplier getSupplierById(int id) {
		Session session = sessionFactory.openSession();
		try {
			Supplier supplier=session.get(Supplier.class,id);
			session.close();
			return supplier;
		} catch (Exception e) {
			session.close();
			return null;
		}
		
	}

	public List<Supplier> getAllSupplier() {
		Session session = sessionFactory.openSession();
		List<Supplier> list=session.createQuery("from Supplier").list();
		return list;
	}
}
