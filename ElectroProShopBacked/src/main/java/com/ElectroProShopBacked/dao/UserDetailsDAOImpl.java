package com.ElectroProShopBacked.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ElectroProShopBacked.config.DBConfig;
import com.ElectroProShopBacked.model.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired
	SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addUserDetails(UserDetails userDetails) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(userDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateUser(String username, String password) {
		Session session = sessionFactory.openSession();
		Query<UserDetails> query=session.createQuery("from UserDetails where username=:user and password=:pass");
		query.setParameter("user", username);
		query.setParameter("pass",password);
		List<UserDetails> list=query.list();
		session.close();
		for(UserDetails user:list)
			if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
					return true;
		return false;
	}

}
