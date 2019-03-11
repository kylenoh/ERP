package com.kyle.erp.group.bbs;

import java.math.BigDecimal;
import java.util.Date;

public class BBSReply {
	private BigDecimal br_no;
	private BigDecimal br_b_no;
	private String br_owner;
	private String br_txt;
	private Date br_date;
	
	public BBSReply() {
		// TODO Auto-generated constructor stub
	}

	public BBSReply(BigDecimal br_no, BigDecimal br_b_no, String br_owner, String br_txt, Date br_date) {
		super();
		this.br_no = br_no;
		this.br_b_no = br_b_no;
		this.br_owner = br_owner;
		this.br_txt = br_txt;
		this.br_date = br_date;
	}

	public BigDecimal getBr_no() {
		return br_no;
	}

	public void setBr_no(BigDecimal br_no) {
		this.br_no = br_no;
	}

	public BigDecimal getBr_b_no() {
		return br_b_no;
	}

	public void setBr_b_no(BigDecimal br_b_no) {
		this.br_b_no = br_b_no;
	}

	public String getBr_owner() {
		return br_owner;
	}

	public void setBr_owner(String br_owner) {
		this.br_owner = br_owner;
	}

	public String getBr_txt() {
		return br_txt;
	}

	public void setBr_txt(String br_txt) {
		this.br_txt = br_txt;
	}

	public Date getBr_date() {
		return br_date;
	}

	public void setBr_date(Date br_date) {
		this.br_date = br_date;
	}

	
	
}
