package com.kyle.erp.inven.currency;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CurrencyController {

	@Autowired CurrencyDAO CURDAO;
	
	@RequestMapping(value = "/go.currency", method = RequestMethod.GET)
	public String goCurrency(HttpServletRequest req,HttpServletResponse res) {
		CURDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/currency.jsp");
		return "index";
	}
	@RequestMapping(value = "/reg.currency", method = RequestMethod.POST)
	public String regCurrency(Currency currency,HttpServletRequest req,HttpServletResponse res) {
		CURDAO.regCurrency(currency, req, res);
		CURDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/currency.jsp");
		return "index";
	}
	@RequestMapping(value = "/Currencypage.change", method = RequestMethod.GET)
	public String pageChange(HttpServletRequest req, HttpServletResponse res) {
		CURDAO.paging(Integer.parseInt(req.getParameter("p")), req, res);
		CURDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/currency.jsp");
		return "index";
	}
	@RequestMapping(value = "/search.currency", method = RequestMethod.GET)
	public String searchCurrency(SearchCurrency s,HttpServletRequest req, HttpServletResponse res) {
		CURDAO.searchCurrency(s, req, res);
		CURDAO.paging(1, req, res);
		CURDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/currency.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update.currency", method = RequestMethod.POST)
	public String updateCurrency(Currency currency,HttpServletRequest req,HttpServletResponse res) {
		CURDAO.update(currency, req, res);
		CURDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/currency.jsp");
		return "index";
	}
	@RequestMapping(value = "/delete.currency", method = RequestMethod.GET)
	public String deleteCurrency(Currency currency,HttpServletRequest req,HttpServletResponse res) {
		CURDAO.deleteCurrency(currency, req, res);
		CURDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/currency.jsp");
		return "index";
	}
//	JSON
	@RequestMapping(value = "/currency.searchJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Currencys searchCurrency(SearchCurrency s) {
		return CURDAO.searchCurrencysJSON(s);
	}
	@RequestMapping(value = "/currency.pagingJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Currencys pagingCurrency(Currency currency,HttpServletRequest req) {
		return CURDAO.pagingCurrencysJSON(1, currency);
	}
	@RequestMapping(value = "/currency.pageChangeJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Currencys pageChangeCurrency(Currency currency,HttpServletRequest req) {
		int pageNo = Integer.parseInt(req.getParameter("c"));
		return CURDAO.pagingCurrencysJSON(pageNo, currency);
	}
}
