package com.bionic.edu.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Users;
import com.bionic.edu.service.UsersService;

@Named
@Scope("session")
public class UserEnterBean {
	private String name = null;
	private String pass = null;
	private Users userPers = null;
	private AdminBean admin = null;
	private AccountantBean accountant = null;
	private SecurityOfficerBean security = null;
	private ColdStoreManagerBean coldStore = null;
	
	@Inject
	private UsersService usersService;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String findUser(){
		userPers = usersService.findByNamePass(name, pass);
		if(userPers != null){
			switch(userPers.getUsers_Role()){
				case 1: 
					admin = new AdminBean(userPers.getUsers_Name());
					return "adminPage";
				case 2: 
					coldStore = new ColdStoreManagerBean();
					return "coldStore";
				case 3:
					accountant = new AccountantBean();
					return "accountant";
				case 4:
					security = new SecurityOfficerBean();
					return "security";
				default: return "error";
			}
		}
		else
			return "error403";
	}
	
	public Users getUserPers() {
		return userPers;
	}
	
	public void userNull(){
		admin = null;
		accountant = null;
		security = null;
		coldStore = null;
	}
	public AccountantBean getAccountant() {
		return accountant;
	}
	public SecurityOfficerBean getSecurity() {
		return security;
	}
	public ColdStoreManagerBean getColdStore() {
		return coldStore;
	}
	public AdminBean getAdmin() {
		return admin;
	}
	
	
	
	

}
