package com.bionic.edu.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Arrival;
import com.bionic.edu.service.ArrivalService;

public class ArrivalServiceImplTest {
	
	private static ApplicationContext context;
	private static ArrivalService arrivalService;
	
	@BeforeClass
	public static void beforeClass(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	    arrivalService = context.getBean(ArrivalService.class);
	}
	
	@Test
	public void saveTest(){
//		Arrival arrival = new Arrival();
//		LocalDateTime ldt1 = LocalDateTime.of(2015, 2, 3, 12, 34);
//		arrival.setArrival_OrderDate(Timestamp.valueOf(ldt1));
//		arrival.setArrival_sum(12423.23);
//		arrivalService.save(arrival);
		
	}
	
	@Test
	public void findByIdTest(){
		int id = 1;
		Arrival arrival = arrivalService.findById(id);
		assertTrue(arrival.getArrival_sum() == 12423.23);
	}
	
	@Test
	public void updateTest(){
		Arrival arrival = arrivalService.findById(1);
		double startSum = arrival.getArrival_sum();
		assertTrue(startSum != 550.0d);
		arrival.setArrival_sum(550.0d);
		assertTrue(arrivalService.findById(1).getArrival_sum() == startSum);
		arrivalService.update(arrival);
		assertTrue(arrivalService.findById(1).getArrival_sum() == 550.0d);
		arrival.setArrival_sum(startSum);
		arrivalService.update(arrival);
		assertTrue(arrivalService.findById(1).getArrival_sum() == startSum);
	}
	
	@Test
	public void getListOfUndeliveredArrivalsTest(){
		List<Arrival> list = arrivalService.getListOfUndeliveredArrivals();
		assertNotNull(list);
	}
	
	@Test
	public void getArrivalsListInDuringPeriod(){
		LocalDateTime ldt = LocalDateTime.of(2015, 5, 5, 4, 1);
		LocalDateTime ldt2 = LocalDateTime.of(2015, 5, 7, 2, 4);
		List<Arrival> list = arrivalService.getArrivalsListInDuringPeriod(Timestamp.valueOf(ldt), Timestamp.valueOf(ldt2));
		assertNotNull(list);	
	}
}
