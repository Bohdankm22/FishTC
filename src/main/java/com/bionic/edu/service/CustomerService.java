package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.TotalPayedForEveryCustomer;
import com.bionic.edu.entity.Customer;

public interface CustomerService {
	
	public Customer findById(int id);
	
	public void save(Customer customer);
	
	public List<Customer> findAll();
	
	public List<String> getNames(double sump);
	
	List<TotalPayedForEveryCustomer> getTotalPayedByEachCustomer();
	
	public void update(Customer customer);
	
	public boolean isEmailExist(String email);
}
