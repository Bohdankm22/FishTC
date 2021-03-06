package com.bionic.edu.service;

import java.sql.Timestamp;
import java.util.List;

import com.bionic.edu.entity.Payment;

public interface PaymentService {

	public Payment findById(int id);
	
	public List<Payment> findByCustomerId(int id);
	
	public void save(Payment payment);
	
	public void saveWithTheList(Payment payment);
	
	public void remove(int id);
	
	public List<Payment> findAll();
	
	double getPaymentSum();
	
	List<Payment> getSortedBySump();

	List<Payment> getPaymentsListInDuringPeriod(Timestamp start, Timestamp end);

	public List<Payment> getUnregisred();

	public void update(Payment p);


}
