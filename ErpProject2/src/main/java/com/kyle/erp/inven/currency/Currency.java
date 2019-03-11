package com.kyle.erp.inven.currency;

import java.math.BigDecimal;

public class Currency {
	private String cur_no;
	private String cur_name;
	private BigDecimal cur_money;
	private String cur_note;
	
	public Currency() {
		// TODO Auto-generated constructor stub
	}

	public Currency(String cur_no, String cur_name, BigDecimal cur_money, String cur_note) {
		super();
		this.cur_no = cur_no;
		this.cur_name = cur_name;
		this.cur_money = cur_money;
		this.cur_note = cur_note;
	}

	public String getCur_no() {
		return cur_no;
	}

	public void setCur_no(String cur_no) {
		this.cur_no = cur_no;
	}

	public String getCur_name() {
		return cur_name;
	}

	public void setCur_name(String cur_name) {
		this.cur_name = cur_name;
	}

	public BigDecimal getCur_money() {
		return cur_money;
	}

	public void setCur_money(BigDecimal cur_money) {
		this.cur_money = cur_money;
	}

	public String getCur_note() {
		return cur_note;
	}

	public void setCur_note(String cur_note) {
		this.cur_note = cur_note;
	}


	
	
}
