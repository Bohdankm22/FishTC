package com.bionic.edu.bean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Users;
import com.bionic.edu.service.UsersService;

@Named
@Scope("session")
public class SecurityOfficerBean {
	
	private List<Users> users = null;
	private Users user = null;
	
	@Inject
	private UsersService usersService;

	public List<Users> getUsers() {
		return users;
	}
	
	public void refreshList(){
		users = usersService.getAll();
	}
	
	public String userRole(Integer role){
		switch(role){
			case 1: return "General Manager";
			case 2: return "Cold Store Manager";
			case 3: return "Accountant";
			case 4: return "Security Officer";
			default: return "It's mistake";
			}
	}
	
	public String editUser(String role){
		int n = Integer.valueOf(role);
		user = usersService.findById(n);
		return "editUser";
	}
	
	public String deleteUser(String role){
		int n = Integer.valueOf(role);
		Users user1 = usersService.findById(n);
		user1.setUsers_isDeleted(!user1.isUsers_isDeleted());
		usersService.update(user1);
		return "security";
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	public String saveUser(){
		usersService.update(user);
		user = null;
		return "security";
	}
}
