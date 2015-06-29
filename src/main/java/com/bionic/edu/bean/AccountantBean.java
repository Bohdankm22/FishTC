package com.bionic.edu.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.bionic.edu.entity.Income;
import com.bionic.edu.entity.Payment;
import com.bionic.edu.service.IncomeService;
import com.bionic.edu.service.PaymentService;

public class AccountantBean extends UserRole{
	
	private List<Payment> unregistered = null;
	private List<Income> incomes = null;
	
	private PaymentService paymentService;
	private IncomeService incomeService;
	
	public AccountantBean(PaymentService paymentService2,
			IncomeService incomeService2) {
		this.paymentService = paymentService2;
		this.incomeService = incomeService2;
	}

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

	public List<Income> getIncomes() {
		return incomes;
	}

	
	public void onRowEdit(RowEditEvent event) {
		Income i = (Income) event.getObject();
		if(incomeService.findById(i.getIncome_id()) != null){
			incomeService.update(i);
		}
        FacesMessage msg = new FacesMessage("Income edited", i.getIncome_Itemname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Income) event.getObject()).getIncome_Itemname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public String type(String tp){
		int n = Integer.valueOf(tp);
		switch(n){
		case 1: return "Half prepayment(50%)";
		case 2: return "Partial prepayment (75%)";
		case 3: return "Full prepayment (100%)";
		default: return "It's mistake";
		}
	}
	
}
