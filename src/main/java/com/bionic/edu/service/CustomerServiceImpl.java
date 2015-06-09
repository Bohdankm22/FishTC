package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.TotalPayedForEveryCustomer;
import com.bionic.edu.dao.CustomerDao;
import com.bionic.edu.entity.Customer;

@Named
public class CustomerServiceImpl implements CustomerService {
	
	@Inject
	private CustomerDao customerDao;
	
	@Override
	public Customer findById(int id) {
		return customerDao.findById(id);
	}
	
	@Override
	public Customer findByEmail(String email){
		return customerDao.findByEmail(email);
	}

	@Transactional
	public void save(Customer customer) {
		customerDao.save(customer);		
	}
	
	@Override
	public List<Customer> findAll(){
		return customerDao.findAll();
	}
	
	@Override
	public List<String> getNames(double sump){
		return customerDao.getNames(sump);
	}

	@Override
	public List<TotalPayedForEveryCustomer> getTotalPayedByEachCustomer() {
		return customerDao.getTotalPayedByEachCustomer();
	}
	
	@Override
	@Transactional
	public void update(Customer customer){
		customerDao.update(customer);
	}
	
	@Override
	public boolean isEmailExist(String email){
		return customerDao.isEmailExist(email);
	}

}
