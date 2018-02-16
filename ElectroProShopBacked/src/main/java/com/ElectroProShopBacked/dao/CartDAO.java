package com.ElectroProShopBacked.dao;

import java.util.List;

import com.ElectroProShopBacked.model.Cart;

public interface CartDAO {
	public boolean insertOrUpdateCart(Cart cart);
	public Cart getCart(int id,String username);
	public Cart getCartItemByUser(int id,String username);
	public List<Cart> getCartByUser(String username);
	public boolean deleteCart(int cartId);
}
