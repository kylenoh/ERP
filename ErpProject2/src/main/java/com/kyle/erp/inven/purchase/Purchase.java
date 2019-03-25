package com.kyle.erp.inven.purchase;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Purchase {
	private BigDecimal ps_no;
	private BigDecimal ps_d_no;
	private Date ps_date;
	private String ps_cus;
	private String ps_m_id;
	private String ps_con;
	private String ps_cur;
	private String ps_type;
	private String ps_note;
	
	private String cus_addr;
	private String cus_email;
	private String com_etel;
	private String com_eaddr;
	private String com_logo;
	private String com_email;
	
	private List<SubPurchase> ps_subPurchase;
	
	public Purchase() {
		// TODO Auto-generated constructor stub
	}

	public Purchase(BigDecimal ps_no, BigDecimal ps_d_no, Date ps_date, String ps_cus, String ps_m_id, String ps_con,
			String ps_cur, String ps_type, String ps_note, String cus_addr, String cus_email, String com_etel,
			String com_eaddr, String com_logo, String com_email, List<SubPurchase> ps_subPurchase) {
		super();
		this.ps_no = ps_no;
		this.ps_d_no = ps_d_no;
		this.ps_date = ps_date;
		this.ps_cus = ps_cus;
		this.ps_m_id = ps_m_id;
		this.ps_con = ps_con;
		this.ps_cur = ps_cur;
		this.ps_type = ps_type;
		this.ps_note = ps_note;
		this.cus_addr = cus_addr;
		this.cus_email = cus_email;
		this.com_etel = com_etel;
		this.com_eaddr = com_eaddr;
		this.com_logo = com_logo;
		this.com_email = com_email;
		this.ps_subPurchase = ps_subPurchase;
	}

	public BigDecimal getPs_no() {
		return ps_no;
	}

	public void setPs_no(BigDecimal ps_no) {
		this.ps_no = ps_no;
	}

	public BigDecimal getPs_d_no() {
		return ps_d_no;
	}

	public void setPs_d_no(BigDecimal ps_d_no) {
		this.ps_d_no = ps_d_no;
	}

	public Date getPs_date() {
		return ps_date;
	}

	public void setPs_date(Date ps_date) {
		this.ps_date = ps_date;
	}

	public String getPs_cus() {
		return ps_cus;
	}

	public void setPs_cus(String ps_cus) {
		this.ps_cus = ps_cus;
	}

	public String getPs_m_id() {
		return ps_m_id;
	}

	public void setPs_m_id(String ps_m_id) {
		this.ps_m_id = ps_m_id;
	}

	public String getPs_con() {
		return ps_con;
	}

	public void setPs_con(String ps_con) {
		this.ps_con = ps_con;
	}

	public String getPs_cur() {
		return ps_cur;
	}

	public void setPs_cur(String ps_cur) {
		this.ps_cur = ps_cur;
	}

	public String getPs_type() {
		return ps_type;
	}

	public void setPs_type(String ps_type) {
		this.ps_type = ps_type;
	}

	public String getPs_note() {
		return ps_note;
	}

	public void setPs_note(String ps_note) {
		this.ps_note = ps_note;
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

	public List<SubPurchase> getPs_subPurchase() {
		return ps_subPurchase;
	}

	public void setPs_subPurchase(List<SubPurchase> ps_subPurchase) {
		this.ps_subPurchase = ps_subPurchase;
	}

	
	
	
}
