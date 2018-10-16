package com.niit.dao;

import com.niit.model.PaymentMode;

public interface PaymentModeDao {
	PaymentMode getPayment(String digi16);
	boolean updatePayment(PaymentMode paymentMode);
}
