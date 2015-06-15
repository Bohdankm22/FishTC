package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.TotalPayedForEveryCustomer;
import com.bionic.edu.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Customer findById(int id) {
		Customer customer = null;
		customer = em.find(Customer.class, id);
		return customer;
	}
	
	@Override
	public Customer findByEmail(String email){
		Customer customer = null;
		String txt = "SELECT c FROM Customer c WHERE c.Customer_email='" + email + "'";
		TypedQuery<Customer> querry = em.createQuery(txt, Customer.class);
		try{
			customer = querry.getSingleResult();
		}
		catch(NoResultException e){
		}
		return customer;	
	}

	@Override
	public void save(Customer customer) {
		em.persist(customer);
	}

	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> tq = em.createQuery("SELECT c FROM Customer c",
				Customer.class);
		List<Customer> list = null;
		list = tq.getResultList();
		return list;
	}

	@Override
	public List<String> getNames(double sump) {
		String txt = "SELECT DISTINCT p.customer.name FROM ";
		txt += "Payment p ";
		txt += "WHERE p.sump > ?1";
		TypedQuery<String> query = em.createQuery(txt, String.class);
		query.setParameter(1, sump);
		return query.getResultList();
	}

	@Override
	public List<TotalPayedForEveryCustomer> getTotalPayedByEachCustomer() {
		String txt = "SELECT new com.bionic.edu.TotalPayedForEveryCustomer (p.customer.name, SUM(p.sump)) ";
		txt += "FROM Payment p GROUP BY p.customer.name";
		TypedQuery<TotalPayedForEveryCustomer> query = em.createQuery(txt,
				TotalPayedForEveryCustomer.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Customer customer) {
		Customer customer2 = em.find(Customer.class, customer.getCustomer_id());
		if (customer2 != null) {
			em.merge(customer);
		}
	}

	@Override
	public boolean isEmailExist(String email){
		String txt = "SELECT c FROM Customer c WHERE c.Customer_email='" + email + "'";
		TypedQuery<Customer> querry = em.createQuery(txt, Customer.class);
		try{
			Customer customer = querry.getSingleResult();
			if(customer != null)
				return true;
		}
		catch(NoResultException e){
			return false;
		}
		return false;
	}
}
