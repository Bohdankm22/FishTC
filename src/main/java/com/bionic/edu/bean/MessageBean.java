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
	private final String weightRange = "Weight field is not between the expected values of 0.10 and availible weight";
	private final String weightRange1 = "Weight field is not between the expected values of 0.10 and availible weight";
	private final String prepaymentTypeRequired = "Prepayment type field could not be empty";
	private final String prepaymentTypeRange = "Prepayment type field is not between the expected values between 1 and 3";
	private final String priceRequired = "Price field could not be empty";
	private final String priceRange = "Price field is not between the expected values between 1 and 3";
	private final String delWeightRequired = "Delivered weight field could not be empty";
	private final String shipNameRequired = "Ship name field could not be empty";
	private final String delWeightRange = "Weight field is not between the expected values of 0.10 and ordered weight + 100";
	private final String priceRange1 = "Price field can't be more then 1000. Talk to General manager otherwise!";
	private final String nameRequired = "Item field could not be empty";
	private final String nameLenght = "Name lenght should be between 4 and 127 symbols";
	private final String roleRequired = "Role field could not be empty";
	private final String roleNumb = "Role field should be number between 1 and 4";
	
	public String getRoleRequired() {
		return roleRequired;
	}

	public String getRoleNumb() {
		return roleNumb;
	}

	public String getNameRequired() {
		return nameRequired;
	}

	public String getNameLenght() {
		return nameLenght;
	}

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
	public String getDelWeightRequired(){
		return delWeightRequired;
	}
	public String getShipNameRequired(){
		return shipNameRequired;
	}
	public String getDelWeightRange(){
		return delWeightRange;
	}
	public String getPriceRange1(){
		return priceRange1;
	}
}
