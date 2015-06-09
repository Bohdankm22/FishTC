package com.bionic.edu.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Payment;
import com.bionic.edu.service.CustomerService;
import com.bionic.edu.service.PaymentService;

public class PaymentServiceImplTest {
	
	private static ApplicationContext context;
	private static PaymentService paymentService;
	private static CustomerService customerService;
	
	@BeforeClass
	public static void beforeClassTest(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	    paymentService = context.getBean(PaymentService.class);
	    customerService = context.getBean(CustomerService.class);
	}
	
//	@Test
//	public void findByIdTest(){
//		int id = 1;
//		Payment payment = paymentService.findById(id);
////		assertTrue(payment.getId() == id);
//	}
//	
//	@Test
//	public void findByCustomerIdTest(){
//		int customerId = 1;
//		List<Payment> list = paymentService.findByCustomerId(customerId);
////		assertTrue(list.get(0).getCustomer().getId() == customerId);		
//	}
	
	@Test
	public void saveTest(){
		Payment payment = new Payment();
		int costumerId = 1;
		payment.setCustomer(customerService.findById(costumerId));
		payment.setPayment_sum(12255);
		LocalDateTime ldt = LocalDateTime.of(2015, 4, 12, 8, 43);
		payment.setPayment_date(Timestamp.valueOf(ldt));
//		paymentService.save(payment);
//		assertNotNull(paymentService.findById(payment.getPayment_id()));
	}
	
	@Test
	public void findByIdTest(){
		int id = 1;
		Payment payment = paymentService.findById(id);
		assertNotNull(payment);
	}
	
	
	

}
