package com.kyle.erp.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@Autowired
	MemberDAO MDAO;

	@RequestMapping(value = "/go.member", method = RequestMethod.GET)
	public String goMember(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("contentPage", "member/login.jsp");
		return "index";
	}

	@RequestMapping(value = "/go.join", method = RequestMethod.GET)
	public String goJoin(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.bye", method = RequestMethod.GET)
	public String bye(HttpServletRequest req, HttpServletResponse res) {
		MDAO.bye(req, res);
		MDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Members idCheck(Member m) {
		return MDAO.idCheck(m);
	}

	@RequestMapping(value = "/reg.member", method = RequestMethod.POST)
	public String join(Member m, HttpServletRequest req) {
		MDAO.join(m, req);
		MDAO.loginCheck(req);
		req.setAttribute("contentPage", "member/login.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String login(Member m, HttpServletRequest req, HttpServletResponse res) {
		MDAO.login(m, req, res);
		MDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		MDAO.logout(req, res);
		MDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String update(Member m, HttpServletRequest req) {
		MDAO.loginCheck(req);
		MDAO.update(m, req);
		MDAO.divideAddr(req);
		req.setAttribute("contentPage", "member/update.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.update.go", method = RequestMethod.GET)
	public String updateGo(Member m, HttpServletRequest req) {
		MDAO.loginCheck(req);
		MDAO.divideAddr(req);
		req.setAttribute("contentPage", "member/update.jsp");
		return "index";
	}

}
