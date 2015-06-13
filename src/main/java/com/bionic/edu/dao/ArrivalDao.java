package com.bionic.edu.dao;

import java.sql.Timestamp;
import java.util.List;

import com.bionic.edu.entity.Arrival;
				
public interface ArrivalDao {
	
	public void save(Arrival arrival);
	
	public void remove(int id);
	
	public Arrival findById(int id);
	
	public Arrival update(Arrival arrival);
	
	public List<Arrival> getListOfUndeliveredArrivals();
	
	public List<Arrival> getArrivalsListInDuringPeriod(Timestamp start, Timestamp end); 
	
//	public Arrival findByIncome(Income income);

}
