package com.bionic.edu.bean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Income;
import com.bionic.edu.entity.Payment;
import com.bionic.edu.service.IncomeService;
import com.bionic.edu.service.PaymentService;

@Named
@Scope("session")
public class AccountantBean {
	
	private List<Payment> unregistered = null;
	private List<Income> incomes = null;
	
	@Inject
	private PaymentService paymentService;
	@Inject
	private IncomeService incomeService;
	
	public void refreshUnregistered(){
		unregistered = paymentService.getUnregisred();
	}
	
	public String showUnregistered(){	
		return "accountPayments";
	}

	public List<Payment> getUnregistered() {
		return unregistered;
	}
	
	public String register(String id){
		int n = Integer.valueOf(id);
		Payment p = paymentService.findById(n);
		p.setPayment_IsRegistred(!p.isPayment_IsRegistred());
		paymentService.update(p);
		return "accountPayments";
	}
	
	public String fishParcels(){
		return "accountantFish";
	}
	
	public void refreshIncomes(){
		incomes = incomeService.getAvailibleForSellFish();
	}
	
	public String setPreType(String id){
		int n = Integer.valueOf(id);
		return "";
	}

	public List<Income> getIncomes() {
		return incomes;
	}
	
	
	
}
