package com.bionic.edu.bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.bionic.edu.entity.Arrival;
import com.bionic.edu.entity.Customer;
import com.bionic.edu.entity.Income;
import com.bionic.edu.entity.Payment;
import com.bionic.edu.service.ArrivalService;
import com.bionic.edu.service.CustomerService;
import com.bionic.edu.service.IncomeService;
import com.bionic.edu.service.PaymentService;

public class AdminBean extends UserRole{

	private List<Customer> customers = null;
	private List<Income> order = null;
	private Arrival arrival = null;
	private Income income = null;
	private List<Income> incomes = null;
	private Income inForEdit = null;
	private Date date1;
	private Date date2;
	private List<Arrival> arrivals = null;
	private List<Payment> payments = null;
	private double totalSumIn = 0;
	private double totalSumOut = 0;
	private String userName = null;
	private double write = 0;

	private CustomerService customerService;
	private ArrivalService arrivalService;
	private IncomeService incomeService;
	private PaymentService paymentService;
	

	public AdminBean(CustomerService customerService2, ArrivalService arrivalService2, IncomeService incomeService2, PaymentService paymentService2) {
		this.paymentService = paymentService2;
		this.customerService = customerService2;
		this.incomeService = incomeService2;
		this.arrivalService = arrivalService2;
	}

	public String showAllUsers() {
		return "allUsers";
	}

	public String makeOrder() {
		order = new ArrayList<Income>();
		arrival = new Arrival();
		return "makeOrder";
	}

	public void refreshListOfUsers() {
		customers = customerService.findAll();
	}

	public List<Customer> getUsers() {
		return customers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Income> getOrder() {
		return order;
	}

	public Arrival getArrival() {
		return arrival;
	}

	public String addItem() {
		income = new Income();
		income.setArrival(arrival);
		return "addItemToOrder";
	}

	public String deleteItem(String id) {
		Iterator<Income> i = order.iterator();
		while(i.hasNext()){
			if(i.next().getIncome_Itemname().equals(id)){
				i.remove();
				System.err.println("DELETED");
				break;
			}
		}
		return "makeOrder";
	}
	
	public String saveIncome(){
		order.add(income);
		return "makeOrder";
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}
	
	public String orderList(){
		arrival.setArrival_OrderDate(Timestamp.valueOf(LocalDateTime.now()));
		arrival.setListOfIncome(order);
		arrivalService.saveWithTheList(arrival);
		arrival = null;
		return "fishOrdered";
	}
	
	public String lookIncomes(){
		return "incomeList";
	}
	
	public void refreshList(){
		incomes = incomeService.getAdminIncomes();
	}

	public List<Income> getIncomes() {
		return incomes;
	}
	
	public String editIncome(String id){
		int n = Integer.parseInt(id);
		inForEdit = incomeService.findById(n);
		return "editIncome";
	}
	public String editIncome(){
		incomeService.update(inForEdit);
		inForEdit = null;
		return "incomeList";
	}

	public Income getInForEdit() {
		return inForEdit;
	}

	public void setInForEdit(Income inForEdit) {
		this.inForEdit = inForEdit;
	}
	
	public String registerIncome(String id){
		int n = Integer.parseInt(id);
		Income in = incomeService.findById(n);
		in.setIncome_registredbygm(!in.isIncome_registredbygm());
		in.setIncome_Availibleweight(in.getIncome_DeliveredWeight());
		incomeService.update(in);
		return "incomeList";
	}
	
	public String putForSaleIncome(String id){
		int n = Integer.parseInt(id);
		Income in = incomeService.findById(n);
		in.setIncome_isselling(!in.isIncome_isselling());
		incomeService.update(in);
		return "incomeList";
	}
	
	public String lookColdStoreIncomes(){
		return "incomeColdStoreList";
	}
	
	public void refreshList1(){
		incomes = incomeService.getAvailibleFish();
	}
	
	public String registerIncome1(String id){
		int n = Integer.parseInt(id);
		Income in = incomeService.findById(n);
		in.setIncome_registredbygm(!in.isIncome_registredbygm());
		incomeService.update(in);
		return "incomeColdStoreList";
	}
	
	public String putForSaleIncome1(String id){
		int n = Integer.parseInt(id);
		Income in = incomeService.findById(n);
		in.setIncome_isselling(!in.isIncome_isselling());
		incomeService.update(in);
		return "incomeColdStoreList";
	}
	
	public String editSellPrice(String id){
		int n = Integer.parseInt(id);
		inForEdit = incomeService.findById(n);
		return "editIncomeSellPrice";
	}
	public String editSellPrice(){
		incomeService.update(inForEdit);
		inForEdit = null;
		return "incomeColdStoreList";
	}
	public String takeReport(){
		date1 = new Date();
		date2 = new Date();
		return "report";
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public List<Arrival> getArrivals() {
		return arrivals;
	}
	
	public List<Payment> getPayments() {
		return payments;
	}

	public String refreshReport(){
		arrivals = arrivalService.getArrivalsListInDuringPeriod(
				new Timestamp(date1.getTime()), new Timestamp(date2.getTime()));
		payments = paymentService.getPaymentsListInDuringPeriod(
				new Timestamp(date1.getTime()), new Timestamp(date2.getTime()));
		totalSumIn = totalSumOut = 0.0d;
		for(Arrival a: arrivals)
			totalSumIn += a.getArrival_sum();
		totalSumIn = Math.round(totalSumIn * 100.0) / 100.0d;
		for(Payment p: payments)
			totalSumOut += p.getPayment_sum();
		totalSumOut = Math.round(totalSumOut * 100.0) / 100.0d;
		return "report";
	}

	public double getTotalSumIn() {
		return totalSumIn;
	}

	public double getTotalSumOut() {
		return totalSumOut;
	}
	
	public void addMessage(String id){
		int n = Integer.valueOf(id);
		String summary = customerService.findById(n).isCustomer_isDeleted() ? "Deleted" : "Undeleted";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}
	
	public void onRowEdit(RowEditEvent event) {
		Customer i = (Customer) event.getObject();
		if(customerService.findById(i.getCustomer_id()) != null){
			customerService.update(i);
		}
        FacesMessage msg = new FacesMessage("Customer edited", i.getCustomer_Name());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Customer) event.getObject()).getCustomer_Name());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public String type(String tp){
		int n = Integer.valueOf(tp);
		switch(n){
		case 1: return "Half prepayment(50%)";
		case 2: return "Partial prepayment (75%)";
		case 3: return "Full prepayment (100%)";
		default: return "It's mistake";
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getWrite() {
		return write;
	}

	public void setWrite(double write) {
		this.write = write;
	}
	
	public String writeOff(String id){
		int n = Integer.parseInt(id);
		inForEdit = incomeService.findById(n);	
		return "writeOff";
	}
	
	public String writeOff(){
		inForEdit.setIncome_Availibleweight(inForEdit.getIncome_Availibleweight() - write);
		incomeService.update(inForEdit);
		inForEdit = null;
		write = 0.0;
		System.err.println("IDSFKJSDFKJSDKLFJSDKLFJSDKLJFLKDSFJLKDFJ  " + write);
		return "fishOrdered";
	}
	
	
	
}
