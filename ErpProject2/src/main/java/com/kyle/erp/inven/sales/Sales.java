package com.kyle.erp.inven.sales;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Sales {
	private BigDecimal s_no;
	private Date s_date;
	private String s_cus;
	private String s_m_id;
	private String s_con;
	private String s_cur;
	private String s_type;
	private String s_note;
	
	private List<SubSales> s_subSales;
	
	public Sales() {
		// TODO Auto-generated constructor stub
	}
	public Sales(BigDecimal s_no, Date s_date, String s_cus, String s_m_id, String s_con, String s_cur, String s_type,
			String s_note, List<SubSales> s_subSales) {
		super();
		this.s_no = s_no;
		this.s_date = s_date;
		this.s_cus = s_cus;
		this.s_m_id = s_m_id;
		this.s_con = s_con;
		this.s_cur = s_cur;
		this.s_type = s_type;
		this.s_note = s_note;
		this.s_subSales = s_subSales;
	}
	public BigDecimal getS_no() {
		return s_no;
	}
	public void setS_no(BigDecimal s_no) {
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
	public String getS_note() {
		return s_note;
	}
	public void setS_note(String s_note) {
		this.s_note = s_note;
	}
	public List<SubSales> getS_subSales() {
		return s_subSales;
	}
	public void setS_subSales(List<SubSales> s_subSales) {
		this.s_subSales = s_subSales;
	}

	
	
}
