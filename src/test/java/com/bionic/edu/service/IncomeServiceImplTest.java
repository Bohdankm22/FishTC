package com.bionic.edu.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Income;

public class IncomeServiceImplTest {
	
	private static ApplicationContext context;
	private static IncomeService incomeService;
//	private static ArrivalService arrivalService;
	
	@BeforeClass
	public static void beforeClass(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	    incomeService = context.getBean(IncomeService.class);
//	    arrivalService = context.getBean(ArrivalService.class);
	}
	
//	@Test
//	public void saveTest(){
//		Income income = new Income();
//		int id = 1;
//		income.setArrival(arrivalService.findById(id));
//		income.setIncome_Availibleweight(123);
//		income.setIncome_DeliveredWeight(123);
//		income.setIncome_isselling(true);
//		income.setIncome_Itemname("Salmon");
//		income.setIncome_OrderWeight(125);
//		income.setIncome_price(12.5);
//		income.setIncome_registredbygm(true);
//		income.setIncome_SellPrice(25);
//		incomeService.save(income);
//		assertTrue(incomeService.findById(income.getIncome_id()) != null);
//	}
	
	@Test
	public void findAllIncomeByArrivalIdTest(){
		int arrivalId = 1;
		List<Income> list = incomeService.findAllIncomeByArrivalId(arrivalId);
		assertNotNull(list);
		assertTrue(list.get(0).getArrival().getArrival_id() == 1);
	}
	
	@Test
	public void getAvailibleForSellFishTest(){
		List<Income> list = incomeService.getAvailibleForSellFish();
		assertTrue(list != null);
	}
	
	@Test
	public void updateTest(){
		Income income = incomeService.findById(1);
		assertTrue(income.getIncome_Itemname().equals("Salmon"));
		income.setIncome_Itemname("Bacon");
		assertTrue(incomeService.findById(1).getIncome_Itemname().equals("Salmon"));
		incomeService.update(income);
		assertTrue(incomeService.findById(1).getIncome_Itemname().equals("Bacon"));
		income.setIncome_Itemname("Salmon");
		incomeService.update(income);
		assertTrue(incomeService.findById(1).getIncome_Itemname().equals("Salmon"));
	}
	
	@Test
	public void getUnregisteredIncomesListTest(){
		List<Income> list= incomeService.getUnregisteredIncomesList();
		assertNotNull(list);
		assertFalse(list.get(0).isIncome_registredbygm());
	}
}
