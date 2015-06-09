package com.bionic.edu;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Arrival;
import com.bionic.edu.entity.Income;
import com.bionic.edu.service.ArrivalService;

public class Order {
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private static ArrivalService arrivalService = context.getBean(ArrivalService.class);
	
	private Arrival arrival = new Arrival();
	
	public Order(){
		arrival.setListOfIncome(new ArrayList<Income>());
	}

	public Arrival getArrival() {
		return arrival;
	}

	public void setArrival(Arrival arrival) {
		this.arrival = arrival;
	}
	
	public void add(Income income){
		arrival.getListOfIncome().add(income);
	}
	
	public void remove(Income income){
		arrival.getListOfIncome().remove(income);
	}
	
	public double getTotalSumOfOrder(){
		double sum = 0;
		for(Income in: arrival.getListOfIncome()){
			sum += in.getIncome_price() * in.getIncome_OrderWeight();
		}
		return sum;
	}
	
	public void save(){
		arrivalService.saveWithTheList(arrival);
	}

}
