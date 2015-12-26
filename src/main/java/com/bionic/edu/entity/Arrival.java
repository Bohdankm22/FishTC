package com.bionic.edu.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Arrival {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Arrival_id;
	private double Arrival_sum;
	private double Arrival_deliveryprice;
	private Timestamp Arrival_OrderDate;
	private Timestamp Arrival_Deliverydate;
	private String Arrival_RefrigeratorShipName;
	@OneToMany(mappedBy="arrival")
	private List<Income> listOfIncome;
	
	public int getArrival_id() {
		return Arrival_id;
	}
	public void setArrival_id(int arrival_id) {
		Arrival_id = arrival_id;
	}
	public double getArrival_sum() {
		return Arrival_sum;
	}
	public void setArrival_sum(double arrival_sum) {
		Arrival_sum = arrival_sum;
	}
	public double getArrival_deliveryprice() {
		return Arrival_deliveryprice;
	}
	public void setArrival_deliveryprice(double arrival_deliveryprice) {
		Arrival_deliveryprice = arrival_deliveryprice;
	}
	public Timestamp getArrival_OrderDate() {
		return Arrival_OrderDate;
	}
	public void setArrival_OrderDate(Timestamp arrival_OrderDate) {
		Arrival_OrderDate = arrival_OrderDate;
	}
	public Timestamp getArrival_Deliverydate() {
		return Arrival_Deliverydate;
	}
	public void setArrival_Deliverydate(Timestamp arrival_Deliverydate) {
		Arrival_Deliverydate = arrival_Deliverydate;
	}
	public String getArrival_RefrigeratorShipName() {
		return Arrival_RefrigeratorShipName;
	}
	public void setArrival_RefrigeratorShipName(String arrival_RefrigeratorShipName) {
		Arrival_RefrigeratorShipName = arrival_RefrigeratorShipName;
	}
	public List<Income> getListOfIncome() {
		return listOfIncome;
	}
	public void setListOfIncome(List<Income> listOfIncome) {
		this.listOfIncome = listOfIncome;
	}	
	

}
