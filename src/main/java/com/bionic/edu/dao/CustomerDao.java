package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.TotalPayedForEveryCustomer;
import com.bionic.edu.entity.Customer;

public interface CustomerDao {
	
	public Customer findById(int id);
	
	public Customer findByEmail(String email);
	
	public void save(Customer customer);
	
	public List<Customer> findAll();

	public List<String> getNames(double sump);
	
	List<TotalPayedForEveryCustomer> getTotalPayedByEachCustomer();
	
	public void update(Customer customer);
	
	public boolean isEmailExist(String email);
	
}
