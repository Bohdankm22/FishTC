package com.bionic.edu.bean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Users;

@Named
@Scope("session")
public class AdminBean {
	
	public List<Users> showAllUsers(){
		return new ArrayList<Users>();
	}

}
