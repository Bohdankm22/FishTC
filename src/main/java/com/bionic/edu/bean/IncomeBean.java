package com.bionic.edu.bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Arrival;
import com.bionic.edu.entity.Income;
import com.bionic.edu.service.ArrivalService;
import com.bionic.edu.service.IncomeService;

@Named
@Scope("session")
public class IncomeBean {
	private List<Income> incomes = null;
	public Income income = null;
	
	@Inject
	private IncomeService incomeService;
	@Inject
	private ArrivalService arrivalService;
	
	public IncomeBean(){
		income = new Income();
		income.setArrival(new ArrivalBean().getArrival());
	}
	
	public void RefreshList(){
		incomes = incomeService.getAvailibleForSellFish();
	}
	
	public String SaveIncome(){
		Arrival arrival = new Arrival();
		LocalDateTime ldt1 = LocalDateTime.now();
		arrival.setArrival_OrderDate(Timestamp.valueOf(ldt1));
		income.setArrival(arrival);
		arrivalService.save(arrival);
		incomeService.save(income);
		return "incomeList";
	}
	
	public String addIncome(){
		income = new Income();
		return "newIncome";
	}
	
	public String editIncome(String id){
	    int n = Integer.valueOf(id);
	    income = incomeService.findById(n);
	    return "newIncome";
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public List<Income> getIncomes() {
		return incomes;
	}
	
	
	
	
}
