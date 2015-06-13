package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Income;

@Repository
public class IncomeDaoImpl implements IncomeDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Income income){
		em.persist(income);
	}
	
	@Override
	public Income findById(int id){
		return em.find(Income.class, id);
	}
	
	@Override
	public List<Income> findAllIncomeByArrivalId(int id){
		String txt = "SELECT i FROM Income i WHERE i.arrival.Arrival_id = " + id;
		TypedQuery<Income> q = em.createQuery(txt, Income.class);
		List<Income> list = q.getResultList();
		return list;
	}

	@Override
	public List<Income> getUnregisteredIncomesList() {
		boolean a = false;
		String txt = "SELECT i FROM Income i WHERE i.income_registredbygm = " + a;
		TypedQuery<Income> q = em.createQuery(txt, Income.class);
		List<Income> list =q.getResultList();
//		for(Income i: list){
//			String txt1 = "SELECT a From Arrival a,Income i WHERE i.arrival_id=a.Arrival_id";
//			TypedQuery<Arrival> m = em.createQuery(txt1, Arrival.class);
//			m.getSingleResult();
//		}
		return list;
	}
	
	@Override
	public List<Income> getAvailibleForSellFish(){
		List<Income> list;
		String txt = "SELECT i From Income i WHERE i.income_isselling=true and"
				+ " i.income_Availibleweight>0";
		TypedQuery<Income> q = em.createQuery(txt, Income.class);
		list = q.getResultList();
		return list;
	}
	
	@Override
	public Income update(Income income){
		Income income1 = em.find(Income.class, income.getIncome_id());
		if(income1 != null){
			income1 = em.merge(income);
		}
		return income1;
	}
	
}
