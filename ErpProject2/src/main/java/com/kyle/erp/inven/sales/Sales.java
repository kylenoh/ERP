package com.kyle.erp.inven.sales;

import java.math.BigDecimal;
import java.sql.Date;

public class Sales {
	private String s_no;
	private Date s_date;
	private String s_cus;
	private String s_m_id;
	private String s_con;
	private String s_cur;
	private String s_type;
	private String s_pro_no;
	private BigDecimal s_qty;
	private BigDecimal s_pro_price;
	private BigDecimal s_price;
	private BigDecimal s_tax;
	private BigDecimal s_sum;
	
	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public Sales(String s_no, Date s_date, String s_cus, String s_m_id, String s_con, String s_cur, String s_type,
			String s_pro_no, BigDecimal s_qty, BigDecimal s_pro_price, BigDecimal s_price, BigDecimal s_tax,
			BigDecimal s_sum) {
		super();
		this.s_no = s_no;
		this.s_date = s_date;
		this.s_cus = s_cus;
		this.s_m_id = s_m_id;
		this.s_con = s_con;
		this.s_cur = s_cur;
		this.s_type = s_type;
		this.s_pro_no = s_pro_no;
		this.s_qty = s_qty;
		this.s_pro_price = s_pro_price;
		this.s_price = s_price;
		this.s_tax = s_tax;
		this.s_sum = s_sum;
	}

	public String getS_no() {
		return s_no;
	}

	public void setS_no(String s_no) {
		this.s_no = s_no;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public String getS_cus() {
		return s_cus;
	}

	public void setS_cus(String s_cus) {
		this.s_cus = s_cus;
	}

	public String getS_m_id() {
		return s_m_id;
	}

	public void setS_m_id(String s_m_id) {
		this.s_m_id = s_m_id;
	}

	public String getS_con() {
		return s_con;
	}

	public void setS_con(String s_con) {
		this.s_con = s_con;
	}

	public String getS_cur() {
		return s_cur;
	}

	public void setS_cur(String s_cur) {
		this.s_cur = s_cur;
	}

	public String getS_type() {
		return s_type;
	}

	public void setS_type(String s_type) {
		this.s_type = s_type;
	}

	public String getS_pro_no() {
		return s_pro_no;
	}

	public void setS_pro_no(String s_pro_no) {
		this.s_pro_no = s_pro_no;
	}

	public BigDecimal getS_qty() {
		return s_qty;
	}

	public void setS_qty(BigDecimal s_qty) {
		this.s_qty = s_qty;
	}

	public BigDecimal getS_pro_price() {
		return s_pro_price;
	}

	public void setS_pro_price(BigDecimal s_pro_price) {
		this.s_pro_price = s_pro_price;
	}

	public BigDecimal getS_price() {
		return s_price;
	}

	public void setS_price(BigDecimal s_price) {
		this.s_price = s_price;
	}

	public BigDecimal getS_tax() {
		return s_tax;
	}

	public void setS_tax(BigDecimal s_tax) {
		this.s_tax = s_tax;
	}

	public BigDecimal getS_sum() {
		return s_sum;
	}

	public void setS_sum(BigDecimal s_sum) {
		this.s_sum = s_sum;
	}


	
	
}
