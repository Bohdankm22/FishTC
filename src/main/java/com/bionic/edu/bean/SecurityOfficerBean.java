package com.bionic.edu.bean;

import java.util.List;

import com.bionic.edu.entity.Users;
import com.bionic.edu.service.UsersService;

public class SecurityOfficerBean extends UserRole{
	
	private List<Users> users = null;
	private Users user = null;
	private String name = null;
	private int role = 0;
	
	private UsersService usersService;

	public SecurityOfficerBean(UsersService usersService2) {
		this.usersService = usersService2;
	}

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
		System.out.println("I'm here");
		System.out.println(user);
		return "editUser";
	}
	
	public String deleteUser(String role){
		int n = Integer.valueOf(role);
		Users user1 = usersService.findById(n);
		user1.setUsers_isDeleted(!user1.isUsers_isDeleted());
		usersService.update(user1);
		System.out.println("I'm here");
		return "security";
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	public String saveUser(){
		user.setUsers_Name(name);
		user.setUsers_Role(role);
		usersService.update(user);
		return "security";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
}
