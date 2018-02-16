package com.ElectroProShopBacked.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ElectroProShopBacked.dao.UserDetailsDAO;
import com.ElectroProShopBacked.model.UserDetails;

@Repository("userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired
	SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addUserDetails(UserDetails userDetails) {
		Session session = sessionFactory.getCurrentSession();
			session.save(userDetails);
			return true;
	}
}
