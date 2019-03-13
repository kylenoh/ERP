package com.kyle.erp.group.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class BBSController {

	@RequestMapping(value = "/go.bbs", method = RequestMethod.GET)
	public String goBBS(HttpServletRequest req,HttpServletResponse res) {
		req.setAttribute("contentPage", "group/bbs.jsp");
		return "index";
	}
}
