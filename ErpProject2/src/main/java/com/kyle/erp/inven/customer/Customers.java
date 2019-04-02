package com.kyle.erp.inven.customer;

import java.util.List;

public class Customers {
	private List<Customer>customers;
	private int customerCount;
	
	public Customers() {
		// TODO Auto-generated constructor stub
	}

	public Customers(List<Customer> customers, int customerCount) {
		super();
		this.customers = customers;
		this.customerCount = customerCount;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public int getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(int customerCount) {
		this.customerCount = customerCount;
	}

	



		
}
