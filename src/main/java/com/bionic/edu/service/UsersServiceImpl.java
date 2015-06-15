package com.bionic.edu.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.UsersDao;
import com.bionic.edu.entity.Users;

@Named
public class UsersServiceImpl implements UsersService{
	@Inject
	private UsersDao usersDao;
	
	@Override
	@Transactional
	public void save(Users user){
		usersDao.save(user);
	}
	
	@Override
	public Users findByNamePass(String name, String pass){
		Users u = usersDao.findByName(name);
		if(u != null && u.getUsers_password().equals(pass))
			return u;
		return null;
	}
}
