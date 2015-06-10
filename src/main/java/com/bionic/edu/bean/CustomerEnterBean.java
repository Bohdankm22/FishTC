package com.bionic.edu.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Customer;
import com.bionic.edu.service.CustomerService;

@Named
@Scope("session")
public class CustomerEnterBean {
	public Customer customer = null;
	public String email = null;
	public String pass = null;
	
	@Inject
	private CustomerService customerService;
	
	public CustomerEnterBean(){	
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String findCustomer(){
		customer = customerService.findByEmail(email);
		if(customer != null && customer.getCustomer_password().equals(pass))
			return "customerPage";
		else
			return "error404";
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
}
