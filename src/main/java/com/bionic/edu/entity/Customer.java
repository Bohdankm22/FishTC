package com.bionic.edu.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Customer_id;
	private String Customer_Name;
	private String Customer_email;
	private String Customer_bancAccount;
	private int Customer_prepaymenttype;
	private boolean Customer_isDeleted;
	private String Customer_password;
	@OneToMany(mappedBy="customer")
	private List<Payment> listOfPayment;
	

	//getters & setters
	public List<Payment> getListOfPayment() {
		return listOfPayment;
	}
	public void setListOfPayment(List<Payment> listOfPayment) {
		this.listOfPayment = listOfPayment;
	}
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getCustomer_email() {
		return Customer_email;
	}
	public void setCustomer_email(String customer_email) {
		Customer_email = customer_email;
	}
	public String getCustomer_bancAccount() {
		return Customer_bancAccount;
	}
	public void setCustomer_bancAccount(String customer_bancAccount) {
		Customer_bancAccount = customer_bancAccount;
	}
	public int getCustomer_prepaymenttype() {
		return Customer_prepaymenttype;
	}
	public void setCustomer_prepaymenttype(int customer_prepaymenttype) {
		Customer_prepaymenttype = customer_prepaymenttype;
	}
	public boolean isCustomer_isDeleted() {
		return Customer_isDeleted;
	}
	public void setCustomer_isDeleted(boolean customer_isDeleted) {
		Customer_isDeleted = customer_isDeleted;
	}
	public String getCustomer_password() {
		return Customer_password;
	}
	public void setCustomer_password(String customer_password) {
		Customer_password = customer_password;
	}
	
	
	
}
