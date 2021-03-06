package com.bionic.edu.bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Customer;
import com.bionic.edu.entity.Income;
import com.bionic.edu.entity.Outcome;
import com.bionic.edu.entity.Payment;
import com.bionic.edu.service.CustomerService;
import com.bionic.edu.service.IncomeService;
import com.bionic.edu.service.PaymentService;

@Named
@Scope("session")
public class CustomerEnterBean {
	private Customer customer = null;
	private String email = null;
	private String pass = null;
	private List<Income> incomes = null;
	private double weight = 0.0d;
	private Payment pay = null;
	private Outcome outcome = null;
	private List<Outcome> bucket = new ArrayList<>();
	private double paySum = 0.0;
	


	@Inject
	private CustomerService customerService;
	@Inject
	private IncomeService incomeService;
	@Inject
	private PaymentService paymentService;
	
	public CustomerEnterBean(){	
		 pay = new Payment();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String findCustomer(){
		customer = customerService.findByEmail(email);
		if(customer != null && customer.getCustomer_password().equals(pass) && !customer.isCustomer_isDeleted())
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
		List<Income> list = incomeService.getAvailibleForSellFish();
		List<Income> out = new ArrayList<>();
		for(Income i : list){
			boolean a = true;
			for(Outcome o : bucket){
				if(o.getIncome().getIncome_id() == i.getIncome_id()){
					a = false;
					break;
				}
			}
			if(a)
				out.add(i);
		}
		for(Income i: out){
			i.setIncome_Availibleweight(Math.round(i.getIncome_Availibleweight() * 100.0) / 100.0d);
		}
		incomes = out;
	}
	
	public String addToBucket(String id){
		int n = Integer.valueOf(id);
		Income in = incomeService.findById(n);
		outcome = new Outcome();
		outcome.setIncome(in);
		outcome.setPayment(pay);
		outcome.setOutcome_price(in.getIncome_SellPrice());
		countTotal();
		return "bucket";
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}
	
	public String saveIncome(){
		weight = Math.round(weight*100.0)/100.0;
		outcome.setOutcome_weight(weight);
		double p = Math.round(outcome.getIncome().getIncome_SellPrice() * weight * 100) / 100.0;
		outcome.setOutcome_price(p);
		bucket.add(outcome);
		outcome = null;
		weight = 0.0;
		countTotal();
		return "customerPage";
	}

	public List<Outcome> getBucket() {
		return bucket;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String buy(){
		countTotal();
		return "buy";
	}
	
	public String buyAll(){
		pay.setCustomer(customer);
		LocalDateTime ldt = LocalDateTime.now();
		pay.setPayment_date(Timestamp.valueOf(ldt));
		pay.setListOfOutcome(bucket);
		paymentService.saveWithTheList(pay);
		bucket = new ArrayList<Outcome>();
		outcome = new Outcome();
		return "success";
	}
	
	public Outcome getOutcome(){
		return outcome;
	}
	
	public Payment getPay(){
		return pay;
	}
	
	public String editOutcome(String id){
		int n = Integer.valueOf(id);
		Iterator<Outcome> i = bucket.iterator();
		while(i.hasNext()){
			Outcome o = i.next();
			Income j = o.getIncome();
			if(j.getIncome_id() == n){
				outcome = o;
				i.remove();
				break;
			}
		}
		return "bucket";
	}
	
	public String deleteOutcome(String id){
		int n = Integer.valueOf(id);
		Iterator<Outcome> i = bucket.iterator();
		while(i.hasNext()){
			if(i.next().getIncome().getIncome_id() == n){
				i.remove();
				System.err.println("DELETED");
				break;
			}
		}
		countTotal();
		return "customerPage";
	}
	
	public double getTotal(){
		pay.setPayment_sum(0.0);
		for(Outcome o: bucket){		
			pay.setPayment_sum(pay.getPayment_sum() + o.getOutcome_price());
		}
		pay.setPayment_sum(Math.round(pay.getPayment_sum()*100)/100.0);
		return pay.getPayment_sum();
	}
	
	private void countTotal(){
		pay.setPayment_sum(0.0);
		for(Outcome o: bucket){		
			pay.setPayment_sum(pay.getPayment_sum() + o.getOutcome_price());
		}
		pay.setPayment_sum(Math.round(pay.getPayment_sum()*100)/100.0);
		switch(customer.getCustomer_prepaymenttype()){
			case 1: 
				paySum = pay.getPayment_sum() / 2;
				break;
			case 2: 
				paySum = pay.getPayment_sum() * 3 / 4;
				break;
			case 3: 
			default: paySum = pay.getPayment_sum();
		}
		
	}
	
	public void toNull(){
		customer = null;
		email = null;
		pass = null;
	}

	public double getPaySum() {
		return paySum;
	}
	
}
