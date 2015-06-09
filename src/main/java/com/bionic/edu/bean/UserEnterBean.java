package com.bionic.edu.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Customer;
import com.bionic.edu.service.CustomerService;

@Named
@Scope("session")
public class UserEnterBean {
	public Customer customer = null;
	
	@Inject
	private CustomerService customerService;
	
	public UserEnterBean(){
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String findCustomer(){
		customer = customerService.findByEmail(customer.getCustomer_email());
		if(customer.getCustomer_id() != 0)
			return "customerPage";
		else
			return "";
	}
}
