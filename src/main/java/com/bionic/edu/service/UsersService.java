package com.bionic.edu.service;

import com.bionic.edu.entity.Users;

public interface UsersService {

	public void save(Users user);
	
	public Users findByNamePass(String name, String pass);
}
