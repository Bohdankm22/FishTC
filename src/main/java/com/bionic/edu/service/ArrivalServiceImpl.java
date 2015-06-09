package com.bionic.edu.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.ArrivalDao;
import com.bionic.edu.dao.IncomeDao;
import com.bionic.edu.entity.Arrival;
import com.bionic.edu.entity.Income;

@Named
public class ArrivalServiceImpl implements ArrivalService{
	@Inject
	private ArrivalDao arrivalDao;
	@Inject
	private IncomeDao incomeDao;
	
	@Override
	@Transactional
	public void save(Arrival arrival){
		arrivalDao.save(arrival);
	}
	
	@Override
	@Transactional
	public void saveWithTheList(Arrival arrival){
//		System.out.println(arrival);
		arrivalDao.save(arrival);
		for(Income i: arrival.getListOfIncome()){
			incomeDao.save(i);
		}
	}
	
	@Override
	@Transactional
	public void remove(int id){
		arrivalDao.remove(id);
	}
	
	@Override
	public Arrival findById(int id){
		Arrival arrival = arrivalDao.findById(id);
//		arrival.setListOfIncome(listOfIncome);
		return arrival;
	}
	
	@Override
	@Transactional
	public Arrival update(Arrival arrival){
		return arrivalDao.update(arrival);
	}
	
	@Override
	public List<Arrival> getListOfUndeliveredArrivals(){
		return arrivalDao.getListOfUndeliveredArrivals();
	}
	
	@Override
	public List<Arrival> getArrivalsListInDuringPeriod(Timestamp start, Timestamp end){
		return arrivalDao.getArrivalsListInDuringPeriod(start, end);
	}

}
