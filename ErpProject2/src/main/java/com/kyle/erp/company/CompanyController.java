package com.kyle.erp.company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {

	@Autowired CompanyDAO COMDAO;
	
	@RequestMapping(value = "/go.company", method = RequestMethod.GET)
	public String goCompany(HttpServletRequest req,HttpServletResponse res) {
		COMDAO.getCompany(req, res);
		req.setAttribute("contentPage", "company.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/reg.company", method = RequestMethod.POST)
	public String regCompany(Company company,HttpServletRequest req,HttpServletResponse res) {
		COMDAO.regCompany(company, req, res);
		COMDAO.getCompany(req, res);
		req.setAttribute("contentPage", "company.jsp");
		return "index";
	}
	@RequestMapping(value = "/update.company", method = RequestMethod.POST)
	public String updateCompany(Company company,HttpServletRequest req,HttpServletResponse res) {
		COMDAO.updateCompany(company, req, res);
		COMDAO.getCompany(req, res);
		req.setAttribute("contentPage", "company.jsp");
		return "index";
	}
	
}
