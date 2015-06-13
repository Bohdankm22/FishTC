package com.bionic.edu.bean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Income;
import com.bionic.edu.service.IncomeService;

@Named
@Scope("session")
public class AvailibleIncomeBean {
	private List<Income> incomes = null;
	public Income income = null;
	private List<Income> bucket = new ArrayList<Income>();
	
	@Inject
	private IncomeService incomeService;	
	
	public AvailibleIncomeBean(){
	}
	
	public void RefreshList(){
		incomes = incomeService.getAvailibleForSellFish();
	}

	public Income getIncome() {
		return income;
	}

	public List<Income> getIncomes() {
		return incomes;
	}
	
	public String addToBucket(String id){
		int n = Integer.valueOf(id);
		bucket.add(incomeService.findById(n));
		return "bucket";
	}
	
	
		
}
