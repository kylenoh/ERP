package com.kyle.erp.inven.purchase;

import java.math.BigDecimal;

public class SubPurchase {
	private BigDecimal psb_no;
	private BigDecimal psb_s_no;
	private String psb_pro_no;
	private BigDecimal psb_qty;
	private BigDecimal psb_pro_price;
	private BigDecimal psb_price;
	private BigDecimal psb_tax;
	private BigDecimal psb_sum;
	
	private String sb_pro_count;
	private String pro_name;
	private String pro_unit;
	
	
	public SubPurchase() {
		// TODO Auto-generated constructor stub
	}


	public SubPurchase(BigDecimal psb_no, BigDecimal psb_s_no, String psb_pro_no, BigDecimal psb_qty,
			BigDecimal psb_pro_price, BigDecimal psb_price, BigDecimal psb_tax, BigDecimal psb_sum, String sb_pro_count,
			String pro_name, String pro_unit) {
		super();
		this.psb_no = psb_no;
		this.psb_s_no = psb_s_no;
		this.psb_pro_no = psb_pro_no;
		this.psb_qty = psb_qty;
		this.psb_pro_price = psb_pro_price;
		this.psb_price = psb_price;
		this.psb_tax = psb_tax;
		this.psb_sum = psb_sum;
		this.sb_pro_count = sb_pro_count;
		this.pro_name = pro_name;
		this.pro_unit = pro_unit;
	}


	public BigDecimal getPsb_no() {
		return psb_no;
	}


	public void setPsb_no(BigDecimal psb_no) {
		this.psb_no = psb_no;
	}


	public BigDecimal getPsb_s_no() {
		return psb_s_no;
	}


	public void setPsb_s_no(BigDecimal psb_s_no) {
		this.psb_s_no = psb_s_no;
	}


	public String getPsb_pro_no() {
		return psb_pro_no;
	}


	public void setPsb_pro_no(String psb_pro_no) {
		this.psb_pro_no = psb_pro_no;
	}


	public BigDecimal getPsb_qty() {
		return psb_qty;
	}


	public void setPsb_qty(BigDecimal psb_qty) {
		this.psb_qty = psb_qty;
	}


	public BigDecimal getPsb_pro_price() {
		return psb_pro_price;
	}


	public void setPsb_pro_price(BigDecimal psb_pro_price) {
		this.psb_pro_price = psb_pro_price;
	}


	public BigDecimal getPsb_price() {
		return psb_price;
	}


	public void setPsb_price(BigDecimal psb_price) {
		this.psb_price = psb_price;
	}


	public BigDecimal getPsb_tax() {
		return psb_tax;
	}


	public void setPsb_tax(BigDecimal psb_tax) {
		this.psb_tax = psb_tax;
	}


	public BigDecimal getPsb_sum() {
		return psb_sum;
	}


	public void setPsb_sum(BigDecimal psb_sum) {
		this.psb_sum = psb_sum;
	}


	public String getSb_pro_count() {
		return sb_pro_count;
	}


	public void setSb_pro_count(String sb_pro_count) {
		this.sb_pro_count = sb_pro_count;
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




	
	
}
