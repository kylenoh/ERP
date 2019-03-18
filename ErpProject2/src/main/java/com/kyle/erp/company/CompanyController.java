package com.kyle.erp.company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {

	@RequestMapping(value = "/go.company", method = RequestMethod.GET)
	public String goCompany(HttpServletRequest req,HttpServletResponse res) {
		req.setAttribute("contentPage", "company.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/reg.company", method = RequestMethod.GET)
	public String regCompany(HttpServletRequest req,HttpServletResponse res) {
		req.setAttribute("contentPage", "company.jsp");
		return "index";
	}
	
}
