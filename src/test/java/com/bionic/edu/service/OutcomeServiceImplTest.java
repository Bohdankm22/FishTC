package com.bionic.edu.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Income;
import com.bionic.edu.entity.Outcome;

public class OutcomeServiceImplTest {

	private static ApplicationContext context;
//	private static OutcomeService outcomeService;
	private static IncomeService incomeService;
	private static PaymentService paymentService;
	
	@BeforeClass
	public static void beforeClass(){
		context = new ClassPathXmlApplicationContext("beans.xml");
//		outcomeService = context.getBean(OutcomeService.class);
		incomeService = context.getBean(IncomeService.class);
		paymentService = context.getBean(PaymentService.class);
	}
	
	@Test
	public void saveTest(){
		Outcome outcome = new Outcome();
		int incomeId = 1;
		Income income = incomeService.findById(incomeId);
		outcome.setIncome(income);
		outcome.setOutcome_price(income.getIncome_SellPrice());
		outcome.setOutcome_weight(12);
		int paymentId = 1;
		outcome.setPayment(paymentService.findById(paymentId));
//		outcomeService.save(outcome);
//		assertNotNull(outcomeService.findById(outcome.getOutcome_id()));
	}

}
