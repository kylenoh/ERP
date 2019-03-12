package com.kyle.erp.inven.sales;

import java.math.BigDecimal;

public class SubSales {
	private BigDecimal sb_no;
	private BigDecimal sb_s_no;
	private String sb_pro_no;
	private BigDecimal sb_qty;
	private BigDecimal sb_pro_price;
	private BigDecimal sb_price;
	private BigDecimal sb_tax;
	private BigDecimal sb_sum;
	
	public SubSales() {
		// TODO Auto-generated constructor stub
	}

	public SubSales(BigDecimal sb_no, BigDecimal sb_s_no, String sb_pro_no, BigDecimal sb_qty, BigDecimal sb_pro_price,
			BigDecimal sb_price, BigDecimal sb_tax, BigDecimal sb_sum) {
		super();
		this.sb_no = sb_no;
		this.sb_s_no = sb_s_no;
		this.sb_pro_no = sb_pro_no;
		this.sb_qty = sb_qty;
		this.sb_pro_price = sb_pro_price;
		this.sb_price = sb_price;
		this.sb_tax = sb_tax;
		this.sb_sum = sb_sum;
	}

	public BigDecimal getSb_no() {
		return sb_no;
	}

	public void setSb_no(BigDecimal sb_no) {
		this.sb_no = sb_no;
	}

	public BigDecimal getSb_s_no() {
		return sb_s_no;
	}

	public void setSb_s_no(BigDecimal sb_s_no) {
		this.sb_s_no = sb_s_no;
	}

	public String getSb_pro_no() {
		return sb_pro_no;
	}

	public void setSb_pro_no(String sb_pro_no) {
		this.sb_pro_no = sb_pro_no;
	}

	public BigDecimal getSb_qty() {
		return sb_qty;
	}

	public void setSb_qty(BigDecimal sb_qty) {
		this.sb_qty = sb_qty;
	}

	public BigDecimal getSb_pro_price() {
		return sb_pro_price;
	}

	public void setSb_pro_price(BigDecimal sb_pro_price) {
		this.sb_pro_price = sb_pro_price;
	}

	public BigDecimal getSb_price() {
		return sb_price;
	}

	public void setSb_price(BigDecimal sb_price) {
		this.sb_price = sb_price;
	}

	public BigDecimal getSb_tax() {
		return sb_tax;
	}

	public void setSb_tax(BigDecimal sb_tax) {
		this.sb_tax = sb_tax;
	}

	public BigDecimal getSb_sum() {
		return sb_sum;
	}

	public void setSb_sum(BigDecimal sb_sum) {
		this.sb_sum = sb_sum;
	}



	
}
