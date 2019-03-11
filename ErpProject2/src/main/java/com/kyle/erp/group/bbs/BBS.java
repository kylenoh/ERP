package com.kyle.erp.group.bbs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BBS {
	private BigDecimal b_no;
	private String b_owner;
	private String b_type;
	private String b_title;
	private String b_txt;
	private Date b_date;
	private String b_img;

	private String b_name;
	private String b_photo;
	
	private List<BBSReply> b_reply;
	
	
	public BBS() {
		// TODO Auto-generated constructor stub
	}


	public BBS(BigDecimal b_no, String b_owner, String b_type, String b_title, String b_txt, Date b_date, String b_img,
			String b_name, String b_photo, List<BBSReply> b_reply) {
		super();
		this.b_no = b_no;
		this.b_owner = b_owner;
		this.b_type = b_type;
		this.b_title = b_title;
		this.b_txt = b_txt;
		this.b_date = b_date;
		this.b_img = b_img;
		this.b_name = b_name;
		this.b_photo = b_photo;
		this.b_reply = b_reply;
	}


	public BigDecimal getB_no() {
		return b_no;
	}


	public void setB_no(BigDecimal b_no) {
		this.b_no = b_no;
	}


	public String getB_owner() {
		return b_owner;
	}


	public void setB_owner(String b_owner) {
		this.b_owner = b_owner;
	}


	public String getB_type() {
		return b_type;
	}


	public void setB_type(String b_type) {
		this.b_type = b_type;
	}


	public String getB_title() {
		return b_title;
	}


	public void setB_title(String b_title) {
		this.b_title = b_title;
	}


	public String getB_txt() {
		return b_txt;
	}


	public void setB_txt(String b_txt) {
		this.b_txt = b_txt;
	}


	public Date getB_date() {
		return b_date;
	}


	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}


	public String getB_img() {
		return b_img;
	}


	public void setB_img(String b_img) {
		this.b_img = b_img;
	}


	public String getB_name() {
		return b_name;
	}


	public void setB_name(String b_name) {
		this.b_name = b_name;
	}


	public String getB_photo() {
		return b_photo;
	}


	public void setB_photo(String b_photo) {
		this.b_photo = b_photo;
	}


	public List<BBSReply> getB_reply() {
		return b_reply;
	}


	public void setB_reply(List<BBSReply> b_reply) {
		this.b_reply = b_reply;
	}


	
	
}
