package com.bionic.edu;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bionic.edu.entity.Outcome;
import com.bionic.edu.entity.Payment;
import com.bionic.edu.service.PaymentService;

public class Basket {
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private static PaymentService paymentService = context.getBean(PaymentService.class);
	
	Payment payment = new Payment();
	
	public Basket(){
		payment.setListOfOutcome(new ArrayList<Outcome>());
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void add(Outcome out){
		payment.getListOfOutcome().add(out);
	}
	
	public void remove(Outcome out){
		payment.getListOfOutcome().remove(out);
	}
	
	public double getTotalSumOfBasket(){
		double sum = 0;
		for(Outcome out: payment.getListOfOutcome()){
			sum += out.getOutcome_price() * out.getOutcome_weight();
		}
		return sum;
	}
	
	public void save(){
		paymentService.saveWithTheList(payment);
	}
}
