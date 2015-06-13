package com.bionic.edu;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bionic.edu.entity.Income;

public class OrderTest {
	
	@Test
	public void addTest(){
		Order order = new Order();
		Income income = new Income();
		order.add(income);
		assertNotNull(order.getArrival().getListOfIncome());
	}
	
	@Test
	public void removeTest(){
		Order order = new Order();
		Income income = new Income();
		order.add(income);
		assertNotNull(order.getArrival().getListOfIncome());
		order.remove(income);
		assertTrue(order.getArrival().getListOfIncome().size() == 0);
	}
	
	@Test
	public void getTotalSumOfOrderTest(){
		Order order = new Order();
		Income income = new Income();
		income.setIncome_OrderWeight(12);
		income.setIncome_price(2);
		order.add(income);
//		System.out.println(order.getTotalSumOfOrder());
		assertTrue(order.getTotalSumOfOrder() == 24);
	}
	
//	@Test
//	public void saveTest(){
//		Order order = new Order();
//		Income income = new Income();
//		Income income2 = new Income();
//		income.setArrival(order.getArrival());
//		income.setIncome_Itemname("Karas");
//		income.setIncome_OrderWeight(43);
//		income.setIncome_price(19.25);
//		income2.setArrival(order.getArrival());
//		income2.setIncome_Itemname("Shuka");
//		income2.setIncome_OrderWeight(132);
//		income2.setIncome_price(52.72);
//		order.add(income);
//		order.add(income2);
//		assertTrue(order.getArrival().getListOfIncome().size() == 2);
//		LocalDateTime ldt = LocalDateTime.of(2014, 9, 12, 8, 43);
//		order.getArrival().setArrival_OrderDate(Timestamp.valueOf(ldt));
//		order.getArrival().setArrival_sum(order.getTotalSumOfOrder());
//		order.save();
//	}
}
