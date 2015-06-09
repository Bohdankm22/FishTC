package com.bionic.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Income {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int income_id;
	private String income_Itemname;
	private double income_OrderWeight;
	private double income_DeliveredWeight;
	private double income_price;
	private double income_SellPrice;
	private boolean income_registredbygm;
	private double income_Availibleweight;
	private boolean income_isselling;
	@ManyToOne
	@JoinColumn(name="arrival_id")
	private Arrival arrival;
	
	public int getIncome_id() {
		return income_id;
	}
	public void setIncome_id(int income_id) {
		this.income_id = income_id;
	}
	public String getIncome_Itemname() {
		return income_Itemname;
	}
	public void setIncome_Itemname(String income_Itemname) {
		this.income_Itemname = income_Itemname;
	}
	public double getIncome_OrderWeight() {
		return income_OrderWeight;
	}
	public void setIncome_OrderWeight(double income_OrderWeight) {
		this.income_OrderWeight = income_OrderWeight;
	}
	public double getIncome_DeliveredWeight() {
		return income_DeliveredWeight;
	}
	public void setIncome_DeliveredWeight(double income_DeliveredWeight) {
		this.income_DeliveredWeight = income_DeliveredWeight;
	}
	public double getIncome_price() {
		return income_price;
	}
	public void setIncome_price(double income_price) {
		this.income_price = income_price;
	}
	public double getIncome_SellPrice() {
		return income_SellPrice;
	}
	public void setIncome_SellPrice(double income_SellPrice) {
		this.income_SellPrice = income_SellPrice;
	}
	public boolean isIncome_registredbygm() {
		return income_registredbygm;
	}
	public void setIncome_registredbygm(boolean income_registredbygm) {
		this.income_registredbygm = income_registredbygm;
	}
	public Arrival getArrival() {
		return arrival;
	}
	public void setArrival(Arrival arrival) {
		this.arrival = arrival;
	}	
	public double getIncome_Availibleweight() {
		return income_Availibleweight;
	}
	public void setIncome_Availibleweight(double income_Availibleweight) {
		this.income_Availibleweight = income_Availibleweight;
	}
	public boolean isIncome_isselling() {
		return income_isselling;
	}
	public void setIncome_isselling(boolean income_isselling) {
		this.income_isselling = income_isselling;
	}
}
