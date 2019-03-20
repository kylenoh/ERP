package com.kyle.erp.company;

import java.math.BigDecimal;

public class Company {
	private BigDecimal com_key;
	private String com_name;
	private String com_no;
	private String com_email;
	private String com_tel;
	private String com_addr;
	private String com_logo;
	private String com_ename;
	private String com_etel;
	private String com_eaddr;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(BigDecimal com_key, String com_name, String com_no, String com_email, String com_tel,
			String com_addr, String com_logo, String com_ename, String com_etel, String com_eaddr) {
		super();
		this.com_key = com_key;
		this.com_name = com_name;
		this.com_no = com_no;
		this.com_email = com_email;
		this.com_tel = com_tel;
		this.com_addr = com_addr;
		this.com_logo = com_logo;
		this.com_ename = com_ename;
		this.com_etel = com_etel;
		this.com_eaddr = com_eaddr;
	}

	public BigDecimal getCom_key() {
		return com_key;
	}

	public void setCom_key(BigDecimal com_key) {
		this.com_key = com_key;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public String getCom_no() {
		return com_no;
	}

	public void setCom_no(String com_no) {
		this.com_no = com_no;
	}

	public String getCom_email() {
		return com_email;
	}

	public void setCom_email(String com_email) {
		this.com_email = com_email;
	}

	public String getCom_tel() {
		return com_tel;
	}

	public void setCom_tel(String com_tel) {
		this.com_tel = com_tel;
	}

	public String getCom_addr() {
		return com_addr;
	}

	public void setCom_addr(String com_addr) {
		this.com_addr = com_addr;
	}

	public String getCom_logo() {
		return com_logo;
	}

	public void setCom_logo(String com_logo) {
		this.com_logo = com_logo;
	}

	public String getCom_ename() {
		return com_ename;
	}

	public void setCom_ename(String com_ename) {
		this.com_ename = com_ename;
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

	
}
