package com.bionic.edu;

public class TotalPayedForEveryCustomer {
	
	private int custromerId;
	private String name;
	private double totalSumPayed;
	
	public TotalPayedForEveryCustomer() {}
	
	public TotalPayedForEveryCustomer(String name, double totalSumPayed) {
		super();
		this.name = name;
		this.totalSumPayed = totalSumPayed;
	}



	public TotalPayedForEveryCustomer(int custromerId, String name,
			double totalSumPayed) {
		super();
		this.custromerId = custromerId;
		this.name = name;
		this.totalSumPayed = totalSumPayed;
	}

	public int getCustromerId() {
		return custromerId;
	}

	public void setCustromerId(int custromerId) {
		this.custromerId = custromerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalSumPayed() {
		return totalSumPayed;
	}

	public void setTotalSumPayed(double totalSumPayed) {
		this.totalSumPayed = totalSumPayed;
	}
	
	@Override
	public String toString(){
		String result = "Customer " + name + " has payed " + totalSumPayed + " in total.";
		return result;
	}
}
