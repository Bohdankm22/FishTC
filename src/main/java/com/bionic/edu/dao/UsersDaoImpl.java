package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	@PersistenceContext
	private EntityManager em;

	public void save(Users user){
		em.persist(user);
	}
}
