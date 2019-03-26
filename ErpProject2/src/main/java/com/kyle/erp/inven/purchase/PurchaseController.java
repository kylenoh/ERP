package com.kyle.erp.inven.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyle.erp.DateManager;


@Controller
public class PurchaseController {

	@Autowired PurchaseDAO PURDAO;
	
	@RequestMapping(value = "/go.purchase", method = RequestMethod.GET)
	public String goPurchase(HttpServletRequest req,HttpServletResponse res) {
		PURDAO.clearSearch(req, res);
		PURDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/purchase.jsp");
		DateManager.getToday(req, res);
		return "index";
	}
	@RequestMapping(value = "/reg.purchase", method = RequestMethod.GET)
	public String regPurchase(HttpServletRequest req,HttpServletResponse res) {
		PURDAO.clearSearch(req, res);
		PURDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/purchase.jsp");
		DateManager.getToday(req, res);
		return "index";
	}
	@RequestMapping(value = "/Purchasepage.change", method = RequestMethod.GET)
	public String pageChange(HttpServletRequest req, HttpServletResponse res) {
		PURDAO.paging(Integer.parseInt(req.getParameter("p")), req, res);
		PURDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/purchase.jsp");
		DateManager.getToday(req, res);
		return "index";
	}
	@RequestMapping(value = "/search.purchase", method = RequestMethod.GET)
	public String searchPurchase(SearchPurchase s,HttpServletRequest req, HttpServletResponse res) {
		PURDAO.searchPurchase(s, req, res);
		PURDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/purchase.jsp");
		DateManager.getToday(req, res);
		return "index";
	}
	
	@RequestMapping(value = "/update.purchase", method = RequestMethod.GET)
	public String updatePurchase(Purchase purchase,HttpServletRequest req,HttpServletResponse res) {
		PURDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/purchase.jsp");
		DateManager.getToday(req, res);
		return "index";
	}
	@RequestMapping(value = "/delete.purchase", method = RequestMethod.GET)
	public String deletePurchase(Purchase purchase,HttpServletRequest req,HttpServletResponse res) {
		PURDAO.deletePurchase(purchase, req, res);
		PURDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/purchase.jsp");
		DateManager.getToday(req, res);
		return "index";
	}
//	JSON
	@RequestMapping(value = "/purchase.searchJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Purchases searchPurchase(SearchPurchase s) {
		return PURDAO.searchPurchaseJSON(s);
	}
	@RequestMapping(value = "/purchase.pagingJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Purchases pagingPurchase(Purchase purchase,HttpServletRequest req) {
		return PURDAO.pagingPurchaseJSON(1, purchase);
	}
	@RequestMapping(value = "/purchase.pageChangeJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Purchases pageChangePurchase(Purchase purchase,HttpServletRequest req) {
		int pageNo = Integer.parseInt(req.getParameter("c"));
		return PURDAO.pagingPurchaseJSON(pageNo, purchase);
	}
	@RequestMapping(value = "/purchase.getGraphJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody SubPurchases getGraphJSON2() {
		return PURDAO.getGraph2();  
	}
	@RequestMapping(value = "/purchase.regJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String purchaseRegJSON(Purchase purchase) {
		return PURDAO.regJSON(purchase);  
	}
	@RequestMapping(value = "/purchase.regSubJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String purchaseRegSubJSON(SubPurchase subpurchase) {
		return PURDAO.regSubJSON(subpurchase);  
	}
	@RequestMapping(value = "/purchase.detailJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody SubPurchases purchaseDetailJSON( SubPurchase subpurchase) {
		return PURDAO.getDetailPurchase(subpurchase);
	}
	@RequestMapping(value = "/purchase.updateJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String purchaseUpdateJSON(Purchase purchase) {
		return PURDAO.updateJSON(purchase);  
	}
	@RequestMapping(value = "/purchase.updateSubJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String purchaseUpdateSubJSON(SubPurchase subpurchase) {
		return PURDAO.updateSubJSON(subpurchase);  
	}
}
