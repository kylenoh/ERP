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
	
	@RequestMapping(value = "/go.memberList", method = RequestMethod.GET)
	public String goMemberList(Member member,HttpServletRequest req, HttpServletResponse res) {
		MDAO.getMemberList(member, req, res);
		req.setAttribute("contentPage", "member/list.jsp");
		return "index";
	}

	@RequestMapping(value = "/go.join", method = RequestMethod.GET)
	public String goJoin(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.profile", method = RequestMethod.GET)
	public String goProfile(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("contentPage", "member/profileUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.bye", method = RequestMethod.GET)
	public String bye(HttpServletRequest req, HttpServletResponse res) {
		MDAO.bye(req, res);
		MDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.id.check", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody Members idCheck(Member m) {
		return MDAO.idCheck(m);
	}

	@RequestMapping(value = "/reg.member", method = RequestMethod.POST)
	public String join(Member member, HttpServletRequest req, HttpServletResponse res) {
		MDAO.loginCheck(req);
		MDAO.join(member, req, res);
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
	public String update(Member member, HttpServletRequest req,HttpServletResponse res) {
		MDAO.loginCheck(req);
		MDAO.update(member, req, res);
		MDAO.divideAddr(req);
		req.setAttribute("contentPage", "member/update.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update.profile", method = RequestMethod.POST)
	public String updateProfile(Member member,HttpServletRequest req,HttpServletResponse res) {
		MDAO.updateProfile(member, req, res);
		MDAO.loginCheck(req);
		req.setAttribute("contentPage", "member/profileUpdate.jsp");
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
