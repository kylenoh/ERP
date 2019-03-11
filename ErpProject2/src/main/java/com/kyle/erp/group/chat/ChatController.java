package com.kyle.erp.group.chat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

	@Autowired ChatDAO CDAO;
	
	@RequestMapping(value = "/go.chat", method = RequestMethod.GET)
	public String goChat(HttpServletRequest req,HttpServletResponse res) {
		req.setAttribute("contentPage", "group/chat.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/reg.chat", method = RequestMethod.GET)
	public String regChat(Chat chat,HttpServletRequest req,HttpServletResponse res) {
		CDAO.submit(chat, req, res);
		req.setAttribute("contentPage", "group/chat.jsp");
		return "index";
	}
	
}
