package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	@PersistenceContext
	private EntityManager em;

	public void save(Users user){
		em.persist(user);
	}
	
	@Override
	public Users findByName(String name){
		Users user = null;
		String txt = "SELECT u FROM Users u WHERE u.Users_Name='" + name + "'";
		TypedQuery<Users> querry = em.createQuery(txt, Users.class);
		try{
			user = querry.getSingleResult();
		}
		catch(NoResultException e){
		}
		return user;	
	}
}
