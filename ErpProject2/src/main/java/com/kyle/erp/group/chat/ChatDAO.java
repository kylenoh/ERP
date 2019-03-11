package com.kyle.erp.group.chat;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatDAO {

	@Autowired SqlSession ss;
	
	public ArrayList<Chat> getChatListById(Chat chat,HttpServletRequest req,HttpServletResponse res){
		ArrayList<Chat> chatList = null;
		String fromID = req.getParameter("fromID");
		fromID.replace(" ","&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>");
		chat.setFromID(fromID);
		String toID = req.getParameter("toID");
		toID.replace(" ","&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>");
		chat.setToID(toID);
		String chatContent = req.getParameter("chatContent");
		chatContent.replace(" ","&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>");
		chat.setChatContent(chatContent);
		int chatTime = Integer.parseInt("chatTime".substring(11, 13));
		String timeType = "오전";
		if (chatTime>=12) {
			timeType = "오후";
			chatTime -= 12;
		}
		chat.setChatTime(Integer.parseInt(req.getParameter("chatTime").substring(0,11)+" "+timeType+" "+chatTime+":"+req.getParameter("chatTime").substring(14,16)+"")  );
		chatList.add(chat);
		
		
		
		chatList = (ArrayList<Chat>) ss.getMapper(ChatMapper.class).getChatListByID(chat);
		chatList = new ArrayList<Chat>();
		
		return chatList;
	}
	
	public ArrayList<Chat> getChatListByRecent(Chat chat,HttpServletRequest req,HttpServletResponse res){
		ArrayList<Chat> chatList = null;
		String fromID = req.getParameter("fromID");
		fromID.replace(" ","&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>");
		chat.setFromID(fromID);
		String toID = req.getParameter("toID");
		toID.replace(" ","&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>");
		chat.setToID(toID);
		String chatContent = req.getParameter("chatContent");
		chatContent.replace(" ","&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>");
		chat.setChatContent(chatContent);
		int chatTime = Integer.parseInt("chatTime".substring(11, 13));
		String timeType = "오전";
		if (chatTime>=12) {
			timeType = "오후";
			chatTime -= 12;
		}
		chat.setChatTime(Integer.parseInt(req.getParameter("chatTime").substring(0,11)+" "+timeType+" "+chatTime+":"+req.getParameter("chatTime").substring(14,16)+"")  );
		chatList.add(chat);
		
		chatList = (ArrayList<Chat>) ss.getMapper(ChatMapper.class).getChatListByID(chat);
		chatList = new ArrayList<Chat>();
		
		return chatList;
	}
	
	public int submit(Chat chat,HttpServletRequest req,HttpServletResponse res){
		return ss.getMapper(ChatMapper.class).regChat(chat);
	}
	
}
