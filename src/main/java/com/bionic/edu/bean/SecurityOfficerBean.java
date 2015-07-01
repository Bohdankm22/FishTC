package com.bionic.edu.bean;

import java.util.List;

import com.bionic.edu.entity.Users;
import com.bionic.edu.service.UsersService;

public class SecurityOfficerBean extends UserRole{
	
	private List<Users> users = null;
	private Users user = null;
	private String name = null;
	private int role = 0;
	private Users newUser = null;
	
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
		return "editUser";
	}
	
	public String deleteUser(String role){
		int n = Integer.valueOf(role);
		Users user1 = usersService.findById(n);
		user1.setUsers_isDeleted(!user1.isUsers_isDeleted());
		usersService.update(user1);
		refreshList();
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
	
	public String addNew(){
		newUser = new Users();
		return "addNewUser";
	}

	public Users getNewUser() {
		return newUser;
	}

	public void setNewUser(Users newUser) {
		this.newUser = newUser;
	}
	
	public String saveUser1(){
		usersService.save(newUser);
		newUser = null;
		return "security";
	}
	
}
