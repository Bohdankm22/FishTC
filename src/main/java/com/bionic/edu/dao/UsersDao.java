package com.bionic.edu.dao;

import com.bionic.edu.entity.Users;

public interface UsersDao {
	
	public void save(Users user);
	
	public Users findByName(String name);
}
