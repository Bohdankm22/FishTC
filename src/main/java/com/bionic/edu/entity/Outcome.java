package com.bionic.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class Outcome {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Outcome_id;
	private double Outcome_weight;
	private double Outcome_price;
	@ManyToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
	@ManyToOne
	@JoinColumn(name="Income_id")
	private Income income;
	
	public int getOutcome_id() {
		return Outcome_id;
	}
	public void setOutcome_id(int outcome_id) {
		Outcome_id = outcome_id;
	}
	public double getOutcome_weight() {
		return Outcome_weight;
	}
	public void setOutcome_weight(double outcome_weight) {
		Outcome_weight = outcome_weight;
	}
	public double getOutcome_price() {
		return Outcome_price;
	}
	public void setOutcome_price(double outcome_price) {
		Outcome_price = outcome_price;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Income getIncome() {
		return income;
	}
	public void setIncome(Income income) {
		this.income = income;
	}
	
	@Override
	public String toString() {
		return "Outcome [Outcome_id=" + Outcome_id + ", Outcome_weight="
				+ Outcome_weight + ", Outcome_price=" + Outcome_price
				+ ", payment=" + payment + ", income=" + income + "]";
	}

	
}
