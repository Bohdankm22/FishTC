package com.bionic.edu.bean;


import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named("msgs")
@Scope("session")
public class MessageBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private final String itemRequired = "Item field could not be empty";
	private final String orderWeightRequired = "Order weight field could not be empty";
	private final String weightRange = "Weight field is not between the expected values of 0.10 and 10 000.0";
	private final String weightRange1 = "Weight field is not between the expected values of 0.10 and availible weight";
	private final String prepaymentTypeRequired = "Prepayment type field could not be empty";
	private final String prepaymentTypeRange = "Prepayment type field is not between the expected values between 1 and 3";
	private final String priceRequired = "Price field could not be empty";
	private final String priceRange = "Price field is not between the expected values between 1 and 3";

	
	public MessageBean(){   }
	
	public String getItemRequired(){
		return itemRequired;
	}
	
	public String getOrderWeightRequired(){
		return orderWeightRequired;
	}

	public String getWeightRange() {
		return weightRange;
	}
	
	public String getWeightRange1(){
		return weightRange1;
	}
	public String getPrepaymentTypeRequired(){
		return prepaymentTypeRequired;
	}
	public String getPrepaymentTypeRange(){
		return prepaymentTypeRange;
	}
	public String getPriceRequired(){
		return priceRequired;
	}
	public String getPriceRange(){
		return priceRange;
	}
	
}
