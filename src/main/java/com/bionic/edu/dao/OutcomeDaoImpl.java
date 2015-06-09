package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Outcome;

@Repository
public class OutcomeDaoImpl implements OutcomeDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Outcome outcome){
		em.persist(outcome);
	}
	
	@Override
	public Outcome findById(int id){
		Outcome outcome = em.find(Outcome.class, id);
//		em.detach(outcome);
		return outcome;
	}

}
