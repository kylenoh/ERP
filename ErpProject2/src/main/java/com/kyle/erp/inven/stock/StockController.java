package com.kyle.erp.inven.stock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StockController {
	
	@Autowired StockDAO STODAO;
	@RequestMapping(value = "/go.stock", method = RequestMethod.GET)
	public String goStock(HttpServletRequest req, HttpServletResponse res) {
		STODAO.getPurchaseStock(res, req);
		req.setAttribute("contentPage", "inven/stock.jsp");
		return "index";
	}
}
