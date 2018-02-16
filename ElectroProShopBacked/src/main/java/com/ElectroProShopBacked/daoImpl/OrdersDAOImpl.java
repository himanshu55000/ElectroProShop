package com.ElectroProShopBacked.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ElectroProShopBacked.dao.OrdersDAO;
import com.ElectroProShopBacked.model.Orders;
import com.ElectroProShopBacked.model.ShippingAddress;
@Repository("ordersDAO")
public class OrdersDAOImpl implements OrdersDAO{
	@Autowired
	SessionFactory sessionFactory;

	public OrdersDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional
	public boolean insertOrders(Orders orders)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(orders);
		return true;
	}
		
	public List<Orders> getOrdersByUser(String username)
	{
		Session session=sessionFactory.openSession();
		List<Orders> list=session.createQuery("from Orders where orderUserDetails.username=:username").setParameter("username", username).list();
		session.close();
		return list;
	}


	@Transactional
	public boolean insertShippingAddress(ShippingAddress address) {
		Session session=sessionFactory.getCurrentSession();
		session.save(address);
		return true;
	}
	
}
