package com.kyle.erp.inven.customer;

import java.math.BigDecimal;

public class Customer {
	private BigDecimal tbl_no;
	private String cus_no;
	private String cus_name;
	private String cus_regno;
	private String cus_owner;
	private String cus_addr;
	private BigDecimal cus_division;
	private String cus_note;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(BigDecimal tbl_no, String cus_no, String cus_name, String cus_regno, String cus_owner,
			String cus_addr, BigDecimal cus_division, String cus_note) {
		super();
		this.tbl_no = tbl_no;
		this.cus_no = cus_no;
		this.cus_name = cus_name;
		this.cus_regno = cus_regno;
		this.cus_owner = cus_owner;
		this.cus_addr = cus_addr;
		this.cus_division = cus_division;
		this.cus_note = cus_note;
	}

	public BigDecimal getTbl_no() {
		return tbl_no;
	}

	public void setTbl_no(BigDecimal tbl_no) {
		this.tbl_no = tbl_no;
	}

	public String getCus_no() {
		return cus_no;
	}

	public void setCus_no(String cus_no) {
		this.cus_no = cus_no;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCus_regno() {
		return cus_regno;
	}

	public void setCus_regno(String cus_regno) {
		this.cus_regno = cus_regno;
	}

	public String getCus_owner() {
		return cus_owner;
	}

	public void setCus_owner(String cus_owner) {
		this.cus_owner = cus_owner;
	}

	public String getCus_addr() {
		return cus_addr;
	}

	public void setCus_addr(String cus_addr) {
		this.cus_addr = cus_addr;
	}

	public BigDecimal getCus_division() {
		return cus_division;
	}

	public void setCus_division(BigDecimal cus_division) {
		this.cus_division = cus_division;
	}

	public String getCus_note() {
		return cus_note;
	}

	public void setCus_note(String cus_note) {
		this.cus_note = cus_note;
	}
	
	
	
}
