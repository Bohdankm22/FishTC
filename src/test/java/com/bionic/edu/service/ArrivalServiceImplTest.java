package com.bionic.edu.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Arrival;
import com.bionic.edu.entity.Income;

public class ArrivalServiceImplTest {
	
	private static ApplicationContext context;
	private static ArrivalService arrivalService;
	private static IncomeService incomeService;
	
	@BeforeClass
	public static void beforeClass(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	    arrivalService = context.getBean(ArrivalService.class);
	    incomeService = context.getBean(IncomeService.class);
	}
	
	@Test
	public void saveTest(){
//		LocalDateTime ld1 = LocalDateTime.of(2000,Month.MARCH,12,12,12);
//		LocalDateTime ld2 = LocalDateTime.now();
//		List<Arrival> list = arrivalService.getArrivalsListInDuringPeriod(Timestamp.valueOf(ld1), 
//				Timestamp.valueOf(ld2));
//		for(Arrival a : list){
//			try{
//				if(a.getArrival_Deliverydate() != null && a.getArrival_sum() == 0.0){
//					List<Income> list1 = incomeService.findAllIncomeByArrivalId(a.getArrival_id());
//					for(Income i : list1){
//						a.setArrival_sum(a.getArrival_sum() +
//								i.getIncome_DeliveredWeight() * i.getIncome_price());
//					}
//					a.setArrival_deliveryprice(111.1);
//					a.setArrival_RefrigeratorShipName("Smile");
//					arrivalService.update(a);
//				}
//			}
//			catch (Exception e) {
//			}
//		}
//		
//	}
//	
//	@Test
//	public void findByIdTest(){
//		int id = 1;
//		Arrival arrival = arrivalService.findById(id);
//		assertTrue(arrival.getArrival_sum() == 12423.23);
//	}
//	
//	@Test
//	public void updateTest(){
//		Arrival arrival = arrivalService.findById(1);
//		double startSum = arrival.getArrival_sum();
//		assertTrue(startSum != 550.0d);
//		arrival.setArrival_sum(550.0d);
//		assertTrue(arrivalService.findById(1).getArrival_sum() == startSum);
//		arrivalService.update(arrival);
//		assertTrue(arrivalService.findById(1).getArrival_sum() == 550.0d);
//		arrival.setArrival_sum(startSum);
//		arrivalService.update(arrival);
//		assertTrue(arrivalService.findById(1).getArrival_sum() == startSum);
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
