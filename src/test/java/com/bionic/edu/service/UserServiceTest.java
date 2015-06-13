package com.bionic.edu.service;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Users;

public class UserServiceTest {
	
	private static ApplicationContext context;
	private static UsersService usersService;
	
	@BeforeClass
	public static void beforeClass(){
		context = new ClassPathXmlApplicationContext("beans.xml");
		usersService = context.getBean(UsersService.class);
	}
	
	@Test
	public void save(){
		Users user = new Users();
		user.setUsers_Name("Bohdan");
		user.setUsers_Role(1);
		usersService.save(user);
	}
}
