package com.bionic.edu.bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Arrival;
import com.bionic.edu.service.ArrivalService;

@Named
@Scope("session")
public class ArrivalBean {
	public Arrival arrival = null;
	@Inject
	private ArrivalService arrivalService;
	
	public ArrivalBean(){
		arrival = new Arrival();
		LocalDateTime ldt1 = LocalDateTime.now();
		arrival.setArrival_OrderDate(Timestamp.valueOf(ldt1));
	}

	public Arrival getArrival() {
		return arrival;
	}

	public void setArrival(Arrival arrival) {
		this.arrival = arrival;
	}
	
	public void saveArrival(Arrival arr){
		arrivalService.save(arr);
	}
	
	
}
