package com.niit.dao;

import com.niit.model.Customer;

public interface CustomerDao {
	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email); // input from the user [email is unique]
}
