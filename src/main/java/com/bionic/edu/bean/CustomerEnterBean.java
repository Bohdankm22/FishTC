package com.bionic.edu.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Customer;
import com.bionic.edu.entity.Income;
import com.bionic.edu.service.CustomerService;
import com.bionic.edu.service.IncomeService;

@Named
@Scope("session")
public class CustomerEnterBean {
	private Customer customer = null;
	private String email = null;
	private String pass = null;
	private List<Income> incomes = null;
	private Map<Income, Double> bucket = new HashMap<>();
	private Income income = null;
	private double weight = 0.0d;
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Inject
	private CustomerService customerService;
	@Inject
	private IncomeService incomeService;
	
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
	
	public void RefreshList(){
		incomes = incomeService.getAvailibleForSellFish();
	}
	
	public String addToBucket(String id){
		int n = Integer.valueOf(id);
		Income in = incomeService.findById(n);
		bucket.put(in, 0.0d);
		income = in;
		return "bucket";
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

	public Income getIncome() {
		return income;
	}
	
	public String saveIncome(){
		bucket.put(income, weight);
		return "customerPage";
	}
	
	
	
}
