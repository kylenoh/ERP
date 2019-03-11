package com.kyle.erp.inven.currency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyDAO {

	private int CurrencyCount;
	
	@Autowired SqlSession ss;
	
	public void regCurrency(Currency currency,HttpServletRequest req,HttpServletResponse res){
		try {
			if (ss.getMapper(CurrencyMapper.class).regCurrency(currency)==1) {
				CurrencyCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCurrency(Currency currency,HttpServletRequest req,HttpServletResponse res){
		ss.getMapper(CurrencyMapper.class).deleteCurrency(currency);
		CurrencyCount--;
	}
	
	public void getCurrencyCount(HttpServletRequest req,HttpServletResponse res){
		CurrencyCount = ss.getMapper(CurrencyMapper.class).getCurrencyCount();
	}
	
	public void paging(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		@SuppressWarnings("unchecked")
		List<Currency> searchCurrencys = (List<Currency>) req.getSession().getAttribute("searchCurrencys");

		double count = 5.0;
		req.setAttribute("curPage", pageNo);
		if (searchCurrencys != null && searchCurrencys.size()>0) {
			// 검색
			int pageCount = (int) Math.ceil(searchCurrencys.size()/count);
			req.setAttribute("pageCount", pageCount);
			
			int start = (searchCurrencys.size() - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			ArrayList<Currency>Currencys = new ArrayList<Currency>();
			Currency c = null;

			for (int i = start - 1; i >= end - 1; i--) {
				c = searchCurrencys.get(i);
				Currencys.add(c);
			}
			req.setAttribute("currencys", Currencys);

		}else if (CurrencyCount >0) {
			// 검색없을때 그냥 조회
			int pageCount = (int) Math.ceil(CurrencyCount / count);
			req.setAttribute("pageCount", pageCount);

			int start = (CurrencyCount - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			CurrencyNo currencyno = new CurrencyNo(new BigDecimal(start),new BigDecimal(end));

			List<Currency>Currencys = ss.getMapper(CurrencyMapper.class).getCurrency(currencyno);
			req.setAttribute("currencys", Currencys);
		}
	}
	
	public void searchCurrency(SearchCurrency s,HttpServletRequest req,HttpServletResponse res){
		List<Currency>searchCurrencys = ss.getMapper(CurrencyMapper.class).searchCurrency(s);
		req.getSession().setAttribute("searchCurrencys", searchCurrencys);
	}
	
	public void clearSearch(HttpServletRequest req, HttpServletResponse res){
		req.getSession().setAttribute("searchCurrencys", null);
	}
	
	public void update(Currency currency,HttpServletRequest req, HttpServletResponse res){
			ss.getMapper(CurrencyMapper.class).updateCurrency(currency);
	}

//	JSON
	public Currencys searchCurrencysJSON(SearchCurrency s) {
		List<Currency> c1 = ss.getMapper(CurrencyMapper.class).searchCurrency(s);
		Currencys c2 = new Currencys(c1);
		return c2;
	}
	public Currencys pagingCurrencysJSON(int pageNo, Currency c){
		double count = 5.0;
		int pageCount = (int) Math.ceil(CurrencyCount / count);
		int start = (CurrencyCount - ((pageNo - 1) * (int) count));
		int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
		CurrencyNo currencyno = new CurrencyNo(new BigDecimal(start),new BigDecimal(end));
		List<Currency>c1 = ss.getMapper(CurrencyMapper.class).getCurrency(currencyno);
		Currencys c2 = new Currencys(c1);
		return c2;
	}
	
}
