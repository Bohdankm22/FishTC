package com.bionic.edu.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Customer;

public class CustomerServiceImplTest {
	
	private static ApplicationContext context;
	private static CustomerService customerService;
	
	
	@BeforeClass
	public static void beforeClass(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	    customerService = context.getBean(CustomerService.class);
	}
	
	@Test
	public void findByIdTest(){		
		int id = 1;
		String custName = customerService.findById(id).getCustomer_Name();
		assertTrue("", custName.equals("Vadya"));
	}
	
//	@Test
//	public void SaveAndRemoveTest(){
//		Customer customer = new Customer();
//	    customer.setCustomer_Name("Vadya");
//	    customer.setCustomer_bancAccount("012dfss");
//	    customer.setCustomer_email("bohda.asdfQ1");
//	    customer.setCustomer_prepaymenttype(1);
//	    customerService.save(customer);
//	    assertTrue(customer.getCustomer_id() > 0);
//	    assertTrue(!customer.isCustomer_isDeleted());
//	    customer.setCustomer_isDeleted(true);
//	    assertTrue(customerService.findById(customer.getCustomer_id()).isCustomer_isDeleted());
//	}
	
	@Test
	public void updateTest(){
		Customer customer = customerService.findById(1);
		assertTrue(customer.getCustomer_prepaymenttype() == 1);
		customer.setCustomer_prepaymenttype(2);
		assertTrue(customerService.findById(1).getCustomer_prepaymenttype() == 1);
		customerService.update(customer);
		assertTrue(customerService.findById(1).getCustomer_prepaymenttype() == 2);
		customer.setCustomer_prepaymenttype(1);
		customerService.update(customer);
		assertTrue(customerService.findById(1).getCustomer_prepaymenttype() == 1);
	}
	
	@Test
	public void isEmailExistTest(){
		String email = "bohda.asdfQ1";
		String email1 = "bohdan";
		assertTrue(customerService.isEmailExist(email));
		assertFalse(customerService.isEmailExist(email1));
	}
	
	@Test
	public void findByEmailTest(){
		String email = "bohda.asdfQ1";
		Customer customer = customerService.findByEmail(email);
		assertNotNull(customer);
		Customer customer1 = customerService.findByEmail("fadf");
		assertNull(customer1);
	}
}
