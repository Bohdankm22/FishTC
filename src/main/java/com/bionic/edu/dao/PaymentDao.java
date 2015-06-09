package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entity.Payment;

public interface PaymentDao {
	
	public Payment findById(int id);
	
	public List<Payment> findByCustomerId(int id);

	public void save(Payment payment);
	
	public void remove(int id);
	
	public List<Payment> findAll();

	double getPaymentSum();
	
	List<Payment> getSortedBySump();

}
