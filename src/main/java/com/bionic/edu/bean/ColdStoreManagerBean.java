package com.bionic.edu.bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Arrival;
import com.bionic.edu.entity.Income;
import com.bionic.edu.service.ArrivalService;

@Named
@Scope("session")
public class ColdStoreManagerBean extends UserRole{
	
	private List<Arrival> orders = null;
	private Arrival arrival = null;
	private String shipName = "";
	
	@Inject
	private ArrivalService arrivalService;

	
	public void refreshListOfOrders(){
		orders = arrivalService.getListOfUndeliveredArrivals();
	}

	public List<Arrival> getOrders() {
		return orders;
	}
	
	public String editArrival(String id){
		int n = Integer.parseInt(id);
		arrival = arrivalService.findById(n);
		return "coldStoreEdit";
	}

	public Arrival getArrival() {
		return arrival;
	}
	
	public String registerIncome(){
		arrival.setArrival_Deliverydate(Timestamp.valueOf(LocalDateTime.now()));
		arrival.setArrival_sum(0.0);
		for(Income i : arrival.getListOfIncome()){
			arrival.setArrival_sum(arrival.getArrival_sum() + 
					i.getIncome_DeliveredWeight() * i.getIncome_price());
		}
		arrivalService.updateWithTheList(arrival);
		System.out.println("Arrival order date:" + arrival.getArrival_OrderDate() + 
				"/n delivery date: " + arrival.getArrival_Deliverydate() + 
				"/n sum: " + arrival.getArrival_sum() +
				"/n ship name" + arrival.getArrival_RefrigeratorShipName() + 
				"/n list" + arrival.getListOfIncome());
		return "coldStore";
	}

	public String getShipName() {
		if(arrival.getArrival_RefrigeratorShipName() != null)
			shipName = arrival.getArrival_RefrigeratorShipName();
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
	
}
