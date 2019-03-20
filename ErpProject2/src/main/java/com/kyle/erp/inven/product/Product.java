package com.kyle.erp.inven.product;

import java.math.BigDecimal;

public class Product {
	private String pro_no;
	private String pro_name;
	private String pro_unit;
	private String pro_buy;
	private BigDecimal pro_sell;
	private String pro_weight;
	private String pro_hscode;
	private String pro_note;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String pro_no, String pro_name, String pro_unit, String pro_buy, BigDecimal pro_sell,
			String pro_weight, String pro_hscode, String pro_note) {
		super();
		this.pro_no = pro_no;
		this.pro_name = pro_name;
		this.pro_unit = pro_unit;
		this.pro_buy = pro_buy;
		this.pro_sell = pro_sell;
		this.pro_weight = pro_weight;
		this.pro_hscode = pro_hscode;
		this.pro_note = pro_note;
	}

	public String getPro_no() {
		return pro_no;
	}

	public void setPro_no(String pro_no) {
		this.pro_no = pro_no;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_unit() {
		return pro_unit;
	}

	public void setPro_unit(String pro_unit) {
		this.pro_unit = pro_unit;
	}

	public String getPro_buy() {
		return pro_buy;
	}

	public void setPro_buy(String pro_buy) {
		this.pro_buy = pro_buy;
	}

	public BigDecimal getPro_sell() {
		return pro_sell;
	}

	public void setPro_sell(BigDecimal pro_sell) {
		this.pro_sell = pro_sell;
	}

	public String getPro_weight() {
		return pro_weight;
	}

	public void setPro_weight(String pro_weight) {
		this.pro_weight = pro_weight;
	}

	public String getPro_hscode() {
		return pro_hscode;
	}

	public void setPro_hscode(String pro_hscode) {
		this.pro_hscode = pro_hscode;
	}

	public String getPro_note() {
		return pro_note;
	}

	public void setPro_note(String pro_note) {
		this.pro_note = pro_note;
	}

	
	
}
