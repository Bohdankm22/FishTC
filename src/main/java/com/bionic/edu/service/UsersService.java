package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entity.Users;

public interface UsersService {

	public void save(Users user);
	
	public Users findByNamePass(String name, String pass);

	public List<Users> getAll();

	public Users findById(int n);

	public void update(Users user1);
}
