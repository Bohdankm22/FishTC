package com.bionic.edu.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Payment_id;
	private Timestamp Payment_date;
	private double Payment_sum;
	@ManyToOne
	@JoinColumn(name="Payment_customerid")
	private Customer customer;
	@OneToMany(mappedBy="payment")
	private List<Outcome> listOfOutcome;
	
	public int getPayment_id() {
		return Payment_id;
	}
	public void setPayment_id(int payment_id) {
		Payment_id = payment_id;
	}
	public Timestamp getPayment_date() {
		return Payment_date;
	}
	public void setPayment_date(Timestamp payment_date) {
		Payment_date = payment_date;
	}
	public double getPayment_sum() {
		return Payment_sum;
	}
	public void setPayment_sum(double payment_sum) {
		Payment_sum = payment_sum;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Outcome> getListOfOutcome() {
		return listOfOutcome;
	}
	public void setListOfOutcome(List<Outcome> listOfOutcome) {
		this.listOfOutcome = listOfOutcome;
	}
	
	

}
