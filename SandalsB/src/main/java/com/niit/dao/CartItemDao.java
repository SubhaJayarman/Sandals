package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;
import com.niit.model.User;

public interface CartItemDao {
	User getUser(String Email);
	void saveOrUpdateCartItem(CartItem cartItem);
	List<CartItem> getCartItem(String email);
	void removeCartItem(int itemId);
	CartItem getCartItemId(int itemId);
}
