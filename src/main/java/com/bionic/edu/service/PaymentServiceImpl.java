package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.OutcomeDao;
import com.bionic.edu.dao.PaymentDao;
import com.bionic.edu.entity.Outcome;
import com.bionic.edu.entity.Payment;

@Named
public class PaymentServiceImpl implements PaymentService{
	@Inject
	private PaymentDao paymentDao;
	@Inject
	private OutcomeDao outcomeDao;
	
	@Override
	public Payment findById(int id) {
		return paymentDao.findById(id);
	}
	
	@Transactional
	public void save(Payment payment){
		paymentDao.save(payment);
	}
	
	@Transactional
	public void saveWithTheList(Payment payment){
		paymentDao.save(payment);
		for(Outcome o: payment.getListOfOutcome()){
			outcomeDao.save(o);
		}
	}
	
	@Transactional
	public void remove(int id){
		paymentDao.remove(id);
	}
	
	@Override
	public List<Payment> findAll(){
		return paymentDao.findAll();
	}
	
	@Override
	public List<Payment> findByCustomerId(int id){
		return paymentDao.findByCustomerId(id);
	}

	@Override
	public double getPaymentSum() {
		return paymentDao.getPaymentSum();
	}
	
	@Override
	public List<Payment> getSortedBySump(){
		return paymentDao.getSortedBySump();
	}

}
