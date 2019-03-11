package com.kyle.erp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyle.erp.group.bbs.BBSDAO;
import com.kyle.erp.inven.container.ContainerDAO;
import com.kyle.erp.inven.currency.CurrencyDAO;
import com.kyle.erp.inven.customer.CustomerDAO;
import com.kyle.erp.inven.product.ProductDAO;
import com.kyle.erp.inven.sales.SalesDAO;
import com.kyle.erp.member.MemberDAO;

@Controller
public class HomeController {

	@Autowired CustomerDAO CDAO;
	@Autowired ProductDAO PDAO;
	@Autowired ContainerDAO CONDAO;
	@Autowired CurrencyDAO CURDAO;
	@Autowired SalesDAO SDAO;
	@Autowired MemberDAO MDAO;
	@Autowired BBSDAO BDAO;
	
	private boolean firstReq;
	
	public HomeController() {
		firstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest req,HttpServletResponse res) {
		if (firstReq) {
			CDAO.getCustomerCount(req, res);
			PDAO.getProductCount(req, res);
			CONDAO.getContainerCount(req, res);
			CURDAO.getCurrencyCount(req, res);
			SDAO.getSalesCount(req, res);
			BDAO.getAllMsgsCount(req, res);
			firstReq = false;
		}
		
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.index", method = RequestMethod.GET)
	public String goIndex(HttpServletRequest req,HttpServletResponse res) {
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
}
