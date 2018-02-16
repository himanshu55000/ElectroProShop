package com.ElectroProShopBacked.dao;

import java.util.List;

import com.ElectroProShopBacked.model.Orders;
import com.ElectroProShopBacked.model.ShippingAddress;

public interface OrdersDAO {
	public boolean insertOrders(Orders orders);
	public boolean insertShippingAddress(ShippingAddress address);
	public List<Orders> getOrdersByUser(String username);
}
