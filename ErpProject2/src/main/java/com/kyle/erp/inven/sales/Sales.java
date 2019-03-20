package com.kyle.erp.inven.sales;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Sales {
	private BigDecimal s_no;
	private BigDecimal s_d_no;
	private Date s_date;
	private String s_cus;
	private String s_m_id;
	private String s_con;
	private String s_cur;
	private String s_type;
	private String s_note;
	
	private String cus_addr;
	private String cus_email;
	private String com_etel;
	private String com_eaddr;
	private String com_logo;
	private String com_email;
	
	private List<SubSales> s_subSales;
	
	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public Sales(BigDecimal s_no, BigDecimal s_d_no, Date s_date, String s_cus, String s_m_id, String s_con,
			String s_cur, String s_type, String s_note, String cus_addr, String cus_email, String com_etel,
			String com_eaddr, String com_logo, String com_email, List<SubSales> s_subSales) {
		super();
		this.s_no = s_no;
		this.s_d_no = s_d_no;
		this.s_date = s_date;
		this.s_cus = s_cus;
		this.s_m_id = s_m_id;
		this.s_con = s_con;
		this.s_cur = s_cur;
		this.s_type = s_type;
		this.s_note = s_note;
		this.cus_addr = cus_addr;
		this.cus_email = cus_email;
		this.com_etel = com_etel;
		this.com_eaddr = com_eaddr;
		this.com_logo = com_logo;
		this.com_email = com_email;
		this.s_subSales = s_subSales;
	}

	public BigDecimal getS_no() {
		return s_no;
	}

	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
	}

	public BigDecimal getS_d_no() {
		return s_d_no;
	}

	public void setS_d_no(BigDecimal s_d_no) {
		this.s_d_no = s_d_no;
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

	public String getCus_addr() {
		return cus_addr;
	}

	public void setCus_addr(String cus_addr) {
		this.cus_addr = cus_addr;
	}

	public String getCus_email() {
		return cus_email;
	}

	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}

	public String getCom_etel() {
		return com_etel;
	}

	public void setCom_etel(String com_etel) {
		this.com_etel = com_etel;
	}

	public String getCom_eaddr() {
		return com_eaddr;
	}

	public void setCom_eaddr(String com_eaddr) {
		this.com_eaddr = com_eaddr;
	}

	public String getCom_logo() {
		return com_logo;
	}

	public void setCom_logo(String com_logo) {
		this.com_logo = com_logo;
	}

	public String getCom_email() {
		return com_email;
	}

	public void setCom_email(String com_email) {
		this.com_email = com_email;
	}

	public List<SubSales> getS_subSales() {
		return s_subSales;
	}

	public void setS_subSales(List<SubSales> s_subSales) {
		this.s_subSales = s_subSales;
	}

	
	
}
