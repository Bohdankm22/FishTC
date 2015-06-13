package com.bionic.edu.bean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Customer;
import com.bionic.edu.service.CustomerService;

@Named
@Scope("session")
public class CustomerRegBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Customer customer = null;
	
	@Inject
	private CustomerService customerService;
	
	public CustomerRegBean(){
		customer = new Customer();
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public String SaveCust(){
		customer.setCustomer_prepaymenttype(1);
		customerService.save(customer);
		return "customerEnter";
	}
	
	
}