package com.bionic.edu.bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entity.Arrival;
import com.bionic.edu.entity.Customer;
import com.bionic.edu.entity.Income;
import com.bionic.edu.service.ArrivalService;
import com.bionic.edu.service.CustomerService;
import com.bionic.edu.service.IncomeService;

@Named
@Scope("session")
public class AdminBean {

	private List<Customer> customers = null;
	private Customer customer = null;
	private List<Income> order = null;
	private Arrival arrival = null;
	private Income income = null;
	private List<Income> incomes = null;
	private Income inForEdit = null;
	private Date date1;
	private Date date2;
	private List<Arrival> arrivals = null;

	@Inject
	private CustomerService customerService;
	@Inject
	private ArrivalService arrivalService;
	@Inject
	private IncomeService incomeService;

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

	public String editCustomer(String id) {
		int n = Integer.parseInt(id);
		customer = customerService.findById(n);
		return "adminEditCustomer";
	}

	public String deleteCustomer(String id) {
		int n = Integer.parseInt(id);
		Customer customer1 = customerService.findById(n);
		customer1.setCustomer_isDeleted(!customer1.isCustomer_isDeleted());
		customerService.update(customer1);
		return "allUsers";
	}

	public Customer getCustomer() {
		return customer;
	}

	public String savePrepaymentType() {
		customerService.update(customer);
		return "allUsers";
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
		return "fishOrdered";
	}
	
	public String lookIncomes(){
		return "incomeList";
	}
	
	public void refreshList(){
		incomes = incomeService.getUnregisteredIncomesList();
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
		refreshArrivals();
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
		refreshArrivals();
	}

	public List<Arrival> getArrivals() {
		return arrivals;
	}
	
	public String refreshArrivals(){
		arrivals = arrivalService.getArrivalsListInDuringPeriod(
				new Timestamp(date1.getTime()), new Timestamp(date2.getTime()));
		return "report";
	}
	
	
}
