package com.bionic.edu.bean;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named("msgsCustomer")
@Scope("session")
public class MessageCustBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static final String emailRequired = "Email field could not be empty";
	private static final String emailNotFound = "User email is not exist";
	
	public MessageCustBean(){   }
	
	public String getEmailRequired(){
		return emailRequired;
	}
	
	public String getEmailNotFound(){
		return emailNotFound;
	}
	
}
