package com.bionic.edu.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Users;
import com.bionic.edu.service.UsersService;

@Named
@Scope("request")
public class UserEnterBean {
	private String name = null;
	private String pass = null;
	private Users user = null;
	
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
		user = usersService.findByNamePass(name, pass);
		if(user != null){
			switch(user.getUsers_Role()){
				case 1: return "adminPage";
				case 2: return "coldStore";
				case 3: return "accountent";
				case 4: return "security";
				default: return "error";
			}
		}
		else
			return "error403";
	}
	
	
	

}
