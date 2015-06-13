package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entity.Income;

public interface IncomeDao {
	
	public void save(Income income);
	
	public Income findById(int id);
	
	public List<Income> findAllIncomeByArrivalId(int id);
	
	public List<Income> getUnregisteredIncomesList();
	
	public List<Income> getAvailibleForSellFish();
	
	public Income update(Income income);

}
