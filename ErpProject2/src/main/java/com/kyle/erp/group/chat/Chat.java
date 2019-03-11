package com.kyle.erp.group.chat;

import java.math.BigDecimal;

public class Chat {
	private BigDecimal chatID;
	private String fromID;
	private String toID;
	private String chatContent;
	private Integer chatTime;
	
	public Chat() {
		// TODO Auto-generated constructor stub
	}

	public Chat(BigDecimal chatID, String fromID, String toID, String chatContent, Integer chatTime) {
		super();
		this.chatID = chatID;
		this.fromID = fromID;
		this.toID = toID;
		this.chatContent = chatContent;
		this.chatTime = chatTime;
	}

	public BigDecimal getChatID() {
		return chatID;
	}

	public void setChatID(BigDecimal chatID) {
		this.chatID = chatID;
	}

	public String getFromID() {
		return fromID;
	}

	public void setFromID(String fromID) {
		this.fromID = fromID;
	}

	public String getToID() {
		return toID;
	}

	public void setToID(String toID) {
		this.toID = toID;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public Integer getChatTime() {
		return chatTime;
	}

	public void setChatTime(Integer chatTime) {
		this.chatTime = chatTime;
	}

	
}
