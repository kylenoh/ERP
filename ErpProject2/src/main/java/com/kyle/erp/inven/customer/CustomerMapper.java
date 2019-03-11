package com.kyle.erp.inven.customer;

import java.util.List;

public interface CustomerMapper {
	public abstract int regCustomer(Customer customer);
	public abstract int getCustomerCount();
	public abstract List<Customer>getCustomer(CustomerNo customerno);
	public abstract List<Customer>searchCustomer(SearchType s);
	public abstract int updateCustomer(Customer customer);
	public abstract int deleteCustomer(Customer customer);
}
