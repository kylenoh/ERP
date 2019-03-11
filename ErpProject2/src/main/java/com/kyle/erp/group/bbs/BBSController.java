package com.kyle.erp.group.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyle.erp.member.MemberDAO;
@Controller
public class BBSController {

	@Autowired MemberDAO MDAO;
	@Autowired BBSDAO BDAO;
	
	@RequestMapping(value = "/go.bbs", method = RequestMethod.GET)
	public String goBBS(HttpServletRequest req,HttpServletResponse res) {
		BDAO.paging(req);
		req.setAttribute("contentPage", "group/bbs.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/bbs.delete", method = RequestMethod.GET)
	public String deleteBBSMsg(BBS bm, HttpServletRequest req, HttpServletResponse res) {
		BDAO.deleteBBSMsg(bm, req,res);
		BDAO.paging(req);
		req.setAttribute("contentPage", "group/bbs.jsp");
		return "index";
	}

	@RequestMapping(value = "/bbs.reply.delete", method = RequestMethod.GET)
	public String deleteSNSReply(BBSReply br, HttpServletRequest req, HttpServletResponse res) {
		BDAO.deleteBBSReply(br, req, res);
		BDAO.paging(req);
		req.setAttribute("contentPage", "group/bbs.jsp");
		return "index";
	}

	@RequestMapping(value = "/bbs.page.change", method = RequestMethod.GET)
	public String pageChange(HttpServletRequest req, HttpServletResponse res) {
		BDAO.setPage(Integer.parseInt(req.getParameter("p")), req);
		BDAO.paging(req);
		req.setAttribute("contentPage", "group/bbs.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.search", method = RequestMethod.GET)
	public String searchSNSMsg(BBS bm, HttpServletRequest req, HttpServletResponse res) {
		BDAO.searchBBSMsg(bm, req);
		BDAO.setPage(1, req);
		BDAO.paging(req);
		req.setAttribute("contentPage", "group/bbs.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.update", method = RequestMethod.GET)
	public String updateSNSMsg(BBS bm, HttpServletRequest req, HttpServletResponse res) {
		BDAO.updateBBSMsg(bm, req);
		BDAO.paging(req);
		req.setAttribute("contentPage", "group/bbs.jsp");
		return "index";
	}

	@RequestMapping(value = "/bbs.write", method = RequestMethod.POST)
	public String writeSNSMsg(BBS bm, HttpServletRequest req, HttpServletResponse res) {
		BDAO.writeBBSMsg(bm, req);
		BDAO.setPage(1, req);
		BDAO.paging(req);
		req.setAttribute("contentPage", "group/bbs.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.reply.write", method = RequestMethod.GET)
	public String writeSNSReply(BBSReply br, HttpServletRequest req, HttpServletResponse res) {
		BDAO.writeBBSReply(br, req);
		BDAO.paging(req);
		req.setAttribute("contentPage", "group/bbs.jsp");
		return "index";
	}
}
