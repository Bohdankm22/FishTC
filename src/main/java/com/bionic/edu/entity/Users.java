package com.bionic.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Users_id;
	private String Users_Name;
	private int Users_Role;
	private boolean Users_isDeleted;
	private String Users_password;
	
	public String getUsers_password() {
		return Users_password;
	}
	public void setUsers_password(String users_password) {
		Users_password = users_password;
	}
	public int getUsers_id() {
		return Users_id;
	}
	public void setUsers_id(int users_id) {
		Users_id = users_id;
	}
	public String getUsers_Name() {
		return Users_Name;
	}
	public void setUsers_Name(String users_Name) {
		Users_Name = users_Name;
	}
	public int getUsers_Role() {
		return Users_Role;
	}
	public void setUsers_Role(int users_Role) {
		Users_Role = users_Role;
	}
	public boolean isUsers_isDeleted() {
		return Users_isDeleted;
	}
	public void setUsers_isDeleted(boolean users_isDeleted) {
		Users_isDeleted = users_isDeleted;
	}

	@Override
	public String toString() {
		return "Users{" +
				"Users_Name='" + Users_Name + '\'' +
				", Users_Role=" + Users_Role +
				", Users_isDeleted=" + Users_isDeleted +
				", Users_password='" + Users_password + '\'' +
				'}';
	}
}
