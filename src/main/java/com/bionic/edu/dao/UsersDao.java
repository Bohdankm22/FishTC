package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entity.Users;

public interface UsersDao {
	
	public void save(Users user);
	
	public Users findByName(String name);

	public List<Users> getAll();

	Users findById(int id);

	public void update(Users user1);
}
