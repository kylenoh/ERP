package com.kyle.erp.inven.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CustomerController {

	@Autowired CustomerDAO CDAO;
	
	@RequestMapping(value = "/go.customer", method = RequestMethod.GET)
	public String goCustomer(HttpServletRequest req,HttpServletResponse res) {
		CDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/customer.jsp");
		return "index";
	}
	@RequestMapping(value = "/reg.customer", method = RequestMethod.POST)
	public String regCustomer(Customer customer,HttpServletRequest req,HttpServletResponse res) {
		CDAO.regCustomer(customer,req, res);
		CDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/customer.jsp");
		return "index";
	}
	@RequestMapping(value = "/Customerpage.change", method = RequestMethod.GET)
	public String pageChange(HttpServletRequest req, HttpServletResponse res) {
		CDAO.paging(Integer.parseInt(req.getParameter("p")), req, res);
		CDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/customer.jsp");
		return "index";
	}
	@RequestMapping(value = "/search.customer", method = RequestMethod.GET)
	public String searchCustomer(SearchType s,HttpServletRequest req, HttpServletResponse res) {
		CDAO.searchCustomer(s, req, res);
		CDAO.paging(1, req, res);
		CDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/customer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update.customer", method = RequestMethod.POST)
	public String updateCustomer(Customer c,HttpServletRequest req,HttpServletResponse res) {
		CDAO.update(c, req, res);
		CDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/customer.jsp");
		return "index";
	}
	@RequestMapping(value = "/delete.customer", method = RequestMethod.GET)
	public String deleteCustomer(Customer c,HttpServletRequest req,HttpServletResponse res) {
		CDAO.deleteProduct(c, req, res);
		CDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/customer.jsp");
		return "index";
	}
//	JSON
	@RequestMapping(value = "/customer.searchJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Customers searchCustomer(SearchType s) {
		return CDAO.searchCustomersJSON(s);
	}
	@RequestMapping(value = "/customer.pagingJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Customers pagingCustomer(Customer c,HttpServletRequest req) {
		return CDAO.pagingCustomersJSON(1, c);
	}
	@RequestMapping(value = "/customer.pageChangeJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Customers pageChangeCustomer(Customer c,HttpServletRequest req) {
		int pageNo = Integer.parseInt(req.getParameter("c"));
		return CDAO.pagingCustomersJSON(pageNo, c);
	}
}
