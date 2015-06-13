package com.bionic.edu.bean;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named("msgsReg")
@Scope("session")
public class MessageCustRegBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private final String nameRequired = "Name field could not be empty";
	private final String emailRequired = "Email field could not be empty";
	private final String passwordRequired = "Password field could not be empty";
	private final String bankAccRequired = "Bank account field could not be empty";
	private final String bankAccLength = "Bank account length should be from 4 to 25 letters";
	private final String nameLength = "Name length should be from 5 to 25 letters";
	private final String passwordLength = "Password length should be from 4 to 128 letters";
	
	
	public MessageCustRegBean(){}
	
	public String getNameRequired(){
		return nameRequired;
	}
	
	public String getEmailRequired(){
		return emailRequired;
	}
	
	public String getPasswordRequired(){
		return passwordRequired;
	}
	
	public String getBankAccRequired(){
		return bankAccRequired;
	}
	
	public String getBankAccLength(){
		return bankAccLength;
	}
	
	public String getPasswordLength(){
		return passwordLength;
	}
	
	public String getNameLength(){
		return nameLength;
	}
}
