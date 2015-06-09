package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.IncomeDao;
import com.bionic.edu.entity.Income;

@Named
public class IncomeServiceImpl implements IncomeService {
	@Inject
	private IncomeDao incomeDao;

	@Override
	@Transactional
	public void save(Income income) {
		incomeDao.save(income);
	}

	@Override
	public Income findById(int id) {
		return incomeDao.findById(id);
	}

	@Override
	public List<Income> findAllIncomeByArrivalId(int id) {
		return incomeDao.findAllIncomeByArrivalId(id);
	}


	@Override
	public List<Income> getUnregisteredIncomesList() {
		return incomeDao.getUnregisteredIncomesList();
	}
	
	@Override
	public List<Income> getAvailibleForSellFish(){
		return incomeDao.getAvailibleForSellFish();
	}
	
	@Override
	@Transactional
	public Income update(Income income){
		return incomeDao.update(income);
	}

}
