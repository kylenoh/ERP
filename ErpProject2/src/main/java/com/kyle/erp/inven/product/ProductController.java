package com.kyle.erp.inven.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProductController {

	@Autowired ProductDAO PDAO;
	
	@RequestMapping(value = "/go.product", method = RequestMethod.GET)
	public String goProduct(HttpServletRequest req,HttpServletResponse res) {
		PDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/product.jsp");
		return "index";
	}
	@RequestMapping(value = "/reg.product", method = RequestMethod.POST)
	public String regProduct(Product product,HttpServletRequest req,HttpServletResponse res) {
		PDAO.regProduct(product, req, res);
		PDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/product.jsp");
		return "index";
	}
	@RequestMapping(value = "/Productpage.change", method = RequestMethod.GET)
	public String pageChange(HttpServletRequest req, HttpServletResponse res) {
		PDAO.paging(Integer.parseInt(req.getParameter("p")), req, res);
		PDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/product.jsp");
		return "index";
	}
	@RequestMapping(value = "/search.product", method = RequestMethod.GET)
	public String searchProduct(SearchProduct s,HttpServletRequest req, HttpServletResponse res) {
		PDAO.searchProduct(s, req, res);
		PDAO.paging(1, req, res);
		PDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/product.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update.product", method = RequestMethod.POST)
	public String updateProduct(Product c,HttpServletRequest req,HttpServletResponse res) {
		PDAO.update(c, req, res);
		PDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/product.jsp");
		return "index";
	}
	@RequestMapping(value = "/delete.product", method = RequestMethod.GET)
	public String deleteProduct(Product c,HttpServletRequest req,HttpServletResponse res) {
		PDAO.deleteProduct(c, req, res);
		PDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/product.jsp");
		return "index";
	}
//	JSON
	@RequestMapping(value = "/product.searchJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Products searchProduct(SearchProduct s) {
		return PDAO.searchProductsJSON(s);
	}
	@RequestMapping(value = "/product.pagingJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Products pagingProduct(Product c,HttpServletRequest req) {
		return PDAO.pagingProductsJSON(1, c);
	}
	@RequestMapping(value = "/product.pageChangeJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Products pageChangeProduct(Product c,HttpServletRequest req) {
		int pageNo = Integer.parseInt(req.getParameter("c"));
		return PDAO.pagingProductsJSON(pageNo, c);
	}
}
