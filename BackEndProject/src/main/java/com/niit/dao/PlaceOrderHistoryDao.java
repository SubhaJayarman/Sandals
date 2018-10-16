package com.niit.dao;

import java.util.List;

import com.niit.model.PlaceOrderHistory;

public interface PlaceOrderHistoryDao {	
	void addPlaceOrderHistory(PlaceOrderHistory placeOrderHistory);
	List<PlaceOrderHistory> getAllPlaceOrderHistory(String email);
}
