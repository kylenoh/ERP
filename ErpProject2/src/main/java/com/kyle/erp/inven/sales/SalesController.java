package com.kyle.erp.inven.sales;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyle.erp.DateManager;


@Controller
public class SalesController {

	@Autowired SalesDAO SDAO;
	
	@RequestMapping(value = "/go.sales", method = RequestMethod.GET)
	public String goSales(HttpServletRequest req,HttpServletResponse res) {
		SDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/sales.jsp");
		DateManager.getToday(req, res);
		return "index";
	}
	@RequestMapping(value = "/reg.sales", method = RequestMethod.POST)
	public String regSales(Sales sales,HttpServletRequest req,HttpServletResponse res) {
		//파라미터 개수를 세서 count 변수를 만들어서 if문에서 값이 있을 때 1씩 증가 시켜서
		//객체 생성
		//포문이나 와일문으로 반복을
		//아래에 잇는 함수들들 그 개수 실행
		SDAO.regSales(sales, req, res);
		SDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/sales.jsp");
		return "index";
	}
	@RequestMapping(value = "/Salespage.change", method = RequestMethod.GET)
	public String pageChange(HttpServletRequest req, HttpServletResponse res) {
		SDAO.paging(Integer.parseInt(req.getParameter("p")), req, res);
		SDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/sales.jsp");
		return "index";
	}
	@RequestMapping(value = "/search.sales", method = RequestMethod.GET)
	public String searchSales(SearchSales s,HttpServletRequest req, HttpServletResponse res) {
		SDAO.searchCurrency(s, req, res);
		SDAO.paging(1, req, res);
		SDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/sales.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update.sales", method = RequestMethod.POST)
	public String updateSales(Sales sales,HttpServletRequest req,HttpServletResponse res) {
		SDAO.update(sales, req, res);
		SDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/sales.jsp");
		return "index";
	}
	@RequestMapping(value = "/delete.sales", method = RequestMethod.GET)
	public String deleteSales(Sales sales,HttpServletRequest req,HttpServletResponse res) {
		SDAO.deleteSales(sales, req, res);
		SDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/sales.jsp");
		return "index";
	}
//	JSON
	@RequestMapping(value = "/sales.searchJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Saleses searchSales(SearchSales s) {
		return SDAO.searchSalesJSON(s);
	}
	@RequestMapping(value = "/sales.pagingJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Saleses pagingSales(Sales sales,HttpServletRequest req) {
		return SDAO.pagingSalesJSON(1, sales);
	}
	@RequestMapping(value = "/sales.pageChangeJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Saleses pageChangeSales(Sales sales,HttpServletRequest req) {
		int pageNo = Integer.parseInt(req.getParameter("c"));
		return SDAO.pagingSalesJSON(pageNo, sales);
	}
}
