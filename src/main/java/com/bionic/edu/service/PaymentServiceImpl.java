package com.bionic.edu.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.IncomeDao;
import com.bionic.edu.dao.OutcomeDao;
import com.bionic.edu.dao.PaymentDao;
import com.bionic.edu.entity.Income;
import com.bionic.edu.entity.Outcome;
import com.bionic.edu.entity.Payment;

@Named
public class PaymentServiceImpl implements PaymentService{
	@Inject
	private PaymentDao paymentDao;
	@Inject
	private OutcomeDao outcomeDao;
	@Inject
	private IncomeDao incomeDao;
	
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
			Income in = o.getIncome();
			in.setIncome_Availibleweight(in.getIncome_Availibleweight() -
					o.getOutcome_weight());
			incomeDao.update(in);
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
	
	@Override
	public List<Payment> getPaymentsListInDuringPeriod(Timestamp start, Timestamp end){
		return paymentDao.getPaymentsListInDuringPeriod(start, end);
	}

	@Override
	public List<Payment> getUnregisred() {
		return paymentDao.getUnregistred();
	}

	@Override
	@Transactional
	public void update(Payment p) {
		paymentDao.update(p);
		
	}

}
