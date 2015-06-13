package com.bionic.edu.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Arrival;

@Repository
public class ArrivalDaoImpl implements ArrivalDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Arrival arrival){
		em.persist(arrival);
	}
	
	@Override
	public void remove(int id){
		Arrival arrival = em.find(Arrival.class, id);
		if(arrival != null){
			em.remove(arrival);
		}
	}
	
	@Override
	public Arrival findById(int id){
		return em.find(Arrival.class, id);
	}
	
//	@Override
//	public List<Arrival> getArrivalsListInDuringPeriod(LocalDateTime start, LocalDateTime finish){
//		Timestamp start1 = Timestamp.valueOf(start);
//		Timestamp finish1 = Timestamp.valueOf(finish);
//		String txt = "SELECT a From Arrival a WHERE a.arrivaldate > '" + start1 
//				+ "' AND a.arrivaldate < '" + finish1 + "'";
//		TypedQuery<Arrival> q = em.createQuery(txt, Arrival.class);
//		return q.getResultList();
//	}
	
	@Override
	public Arrival update(Arrival arrival){
		Arrival arrival1 = em.find(Arrival.class, arrival.getArrival_id());
		if(arrival1 != null){
			arrival1 = em.merge(arrival);
		}
		return arrival1;
	}
	
	@Override
	public List<Arrival> getListOfUndeliveredArrivals(){
		String txt = "SELECT a FROM Arrival a WHERE a.Arrival_Deliverydate=NULL";
		TypedQuery<Arrival> q = em.createQuery(txt, Arrival.class);
		List<Arrival> list = q.getResultList();
		return list;
	}
	
	@Override
	public List<Arrival> getArrivalsListInDuringPeriod(Timestamp start, Timestamp end){
		String txt = "SELECT a From Arrival a WHERE a.Arrival_Deliverydate > '" + start 
				+ "' AND a.Arrival_Deliverydate < '" + end + "'";
		TypedQuery<Arrival> q = em.createQuery(txt, Arrival.class);
		return q.getResultList();
	}
	

}
