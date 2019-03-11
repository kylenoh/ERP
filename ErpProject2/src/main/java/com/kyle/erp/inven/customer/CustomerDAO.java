package com.kyle.erp.inven.customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDAO {

	private int CustomerCount;
	
	@Autowired SqlSession ss;
	
	public void regCustomer(Customer customer,HttpServletRequest req,HttpServletResponse res){
		try {
			if (ss.getMapper(CustomerMapper.class).regCustomer(customer)==1) {
				CustomerCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(Customer customer,HttpServletRequest req,HttpServletResponse res){
		ss.getMapper(CustomerMapper.class).deleteCustomer(customer);
		CustomerCount--;
	}
	
	public void getCustomerCount(HttpServletRequest req,HttpServletResponse res){
		CustomerCount = ss.getMapper(CustomerMapper.class).getCustomerCount();
	}
	
	public void paging(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		@SuppressWarnings("unchecked")
		List<Customer> searchCustomers = (List<Customer>) req.getSession().getAttribute("searchCustomers");

		double count = 5.0;
		req.setAttribute("curPage", pageNo);
		if (searchCustomers != null && searchCustomers.size()>0) {
			// 검색
			int pageCount = (int) Math.ceil(searchCustomers.size()/count);
			req.setAttribute("pageCount", pageCount);
			
			int start = (searchCustomers.size() - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			ArrayList<Customer>Customers = new ArrayList<Customer>();
			Customer c = null;

			for (int i = start - 1; i >= end - 1; i--) {
				c = searchCustomers.get(i);
				Customers.add(c);
			}
			req.setAttribute("customers", Customers);

		}else if (CustomerCount >0) {
			// 검색없을때 그냥 조회
			int pageCount = (int) Math.ceil(CustomerCount / count);
			req.setAttribute("pageCount", pageCount);

			int start = (CustomerCount - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			CustomerNo customerno = new CustomerNo(new BigDecimal(start),new BigDecimal(end));

			List<Customer>Customers = ss.getMapper(CustomerMapper.class).getCustomer(customerno);
			req.setAttribute("customers", Customers);
		}
	}
	
	public void searchCustomer(SearchType s,HttpServletRequest req,HttpServletResponse res){
		List<Customer>searchCustomers = ss.getMapper(CustomerMapper.class).searchCustomer(s);
		req.getSession().setAttribute("searchCustomers", searchCustomers);
	}
	
	public void clearSearch(HttpServletRequest req, HttpServletResponse res){
		req.getSession().setAttribute("searchCustomers", null);
	}
	
	public void update(Customer customer,HttpServletRequest req, HttpServletResponse res){
			ss.getMapper(CustomerMapper.class).updateCustomer(customer);
		
		
	}

//	JSON
	public Customers searchCustomersJSON(SearchType s) {
		List<Customer> c1 = ss.getMapper(CustomerMapper.class).searchCustomer(s);
		Customers c2 = new Customers(c1);
		return c2;
	}
	public Customers pagingCustomersJSON(int pageNo, Customer c){
		double count = 5.0;
		int pageCount = (int) Math.ceil(CustomerCount / count);
		int start = (CustomerCount - ((pageNo - 1) * (int) count));
		int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
		CustomerNo customerno = new CustomerNo(new BigDecimal(start),new BigDecimal(end));
		List<Customer>c1 = ss.getMapper(CustomerMapper.class).getCustomer(customerno);
		Customers c2 = new Customers(c1);
		return c2;
	}
	
}
