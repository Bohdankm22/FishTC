package com.bionic.edu.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.OutcomeDao;
import com.bionic.edu.entity.Outcome;

@Named
public class OutcomeServiceImpl implements OutcomeService{
	@Inject
	private OutcomeDao outcomeDao;
	
	@Override
	@Transactional
	public void save(Outcome outcome){
		outcomeDao.save(outcome);
	}
	
	@Override
	public Outcome findById(int id){
		return outcomeDao.findById(id);
	}
}
