package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entity.Income;

public interface IncomeService {
	
	public void save(Income income);
	
	public Income findById(int id);
	
	public List<Income> findAllIncomeByArrivalId(int id);
	
	public List<Income> getUnregisteredIncomesList();
	
	public List<Income> getAvailibleForSellFish();
	
	public Income update(Income income);
	
	public List<Income> getAvailibleFish();

	public List<Income> getAdminIncomes();
	

}
