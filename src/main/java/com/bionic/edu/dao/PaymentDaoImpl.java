package com.bionic.edu.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Payment payment) {
		em.persist(payment);		
	}
	
	@Override
	public void remove(int id){
		Payment payment = em.find(Payment.class, id);
		if(payment != null){
			em.remove(payment);
		}
	}
	
	@Override
	public Payment findById(int id){
		Payment payment = em.find(Payment.class, id);
		return payment;
	}
	
	@Override
	public List<Payment> findAll(){
		TypedQuery<Payment> typedQuery = em.createQuery("SELECT p FROM Payment p", Payment.class);
		List<Payment> list = typedQuery.getResultList();
		return list;
	}
	
	@Override
	public List<Payment> findByCustomerId(int id){
		TypedQuery<Payment> typedQuery = em.createQuery("SELECT p FROM Payment p "
				+ "WHERE p.customer.id = " + id, Payment.class);
		List<Payment> list = typedQuery.getResultList();
		return list;
	}
	
	@Override
	public double getPaymentSum(){
	    TypedQuery<Double> query = em.createQuery ("SELECT SUM(p.sump) FROM Payment p", Double.class);
	    return query.getSingleResult();
	}
	
	@Override
	public List<Payment> getSortedBySump(){
		TypedQuery<Payment> query = em.createQuery("SELECT p FROM Payment p ORDER BY p.sump", Payment.class);
		return query.getResultList();
	}

	@Override
	public List<Payment> getPaymentsListInDuringPeriod(Timestamp start,
			Timestamp end) {
		String txt = "SELECT a From Payment a WHERE a.Payment_date > '" + start 
				+ "' AND a.Payment_date < '" + end + "'";
		TypedQuery<Payment> q = em.createQuery(txt, Payment.class);
		return q.getResultList();
	}

	@Override
	public List<Payment> getUnregistred() {
		return em.createQuery("SELECT p FROM Payment p WHERE p.payment_IsRegistred=false ORDER BY p.Payment_date", Payment.class).getResultList();
	}

	@Override
	public void update(Payment p) {
		Payment pay = em.find(Payment.class, p.getPayment_id());
		if (pay != null) {
			em.merge(p);
		}
	}
	
	

}
