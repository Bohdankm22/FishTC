package com.bionic.edu.service;

import java.sql.Timestamp;
import java.util.List;

import com.bionic.edu.entity.Arrival;

public interface ArrivalService {
	
	public void save(Arrival arrival);
	
	public void saveWithTheList(Arrival arrival);
	
	public void remove(int id);
	
	public Arrival findById(int id);

	public Arrival update(Arrival arrival);
	
	public List<Arrival> getListOfUndeliveredArrivals();
	
	public List<Arrival> getArrivalsListInDuringPeriod(Timestamp start, Timestamp end);

	void updateWithTheList(Arrival arrival);

	

}
