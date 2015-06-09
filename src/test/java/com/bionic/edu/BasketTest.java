package com.bionic.edu;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import com.bionic.edu.entity.Outcome;

public class BasketTest {
	
	private static Basket basket;
	
	
	@BeforeClass
	public static void before(){
		basket = new Basket();
	}
	
	@Test
	public void addTest(){	
		Outcome out = new Outcome();
		out.setOutcome_price(12);
		out.setOutcome_weight(1);
		basket.add(out);
		assertNotNull(basket.getPayment().getListOfOutcome().get(0));
	}
	
	@Test
	public void removeTest(){
		Outcome out = new Outcome();
		int startSize = basket.payment.getListOfOutcome().size();
		basket.add(out);
		basket.remove(out);
		assertTrue(basket.getPayment().getListOfOutcome().size() == startSize);
	}
	
	@Test
	public void getTotalSumOfBasketTest(){
		assertTrue(basket.getTotalSumOfBasket() == 12);
	}

}
