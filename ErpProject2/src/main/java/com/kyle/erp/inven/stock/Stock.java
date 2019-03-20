package com.kyle.erp.inven.stock;

import java.math.BigDecimal;

public class Stock {
	private String sb_pro_no;
	private String pro_name;
	private BigDecimal sum_company;
	private BigDecimal sum_china;
	private BigDecimal sum;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(String sb_pro_no, String pro_name, BigDecimal sum_company, BigDecimal sum_china, BigDecimal sum) {
		super();
		this.sb_pro_no = sb_pro_no;
		this.pro_name = pro_name;
		this.sum_company = sum_company;
		this.sum_china = sum_china;
		this.sum = sum;
	}

	public String getSb_pro_no() {
		return sb_pro_no;
	}

	public void setSb_pro_no(String sb_pro_no) {
		this.sb_pro_no = sb_pro_no;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public BigDecimal getSum_company() {
		return sum_company;
	}

	public void setSum_company(BigDecimal sum_company) {
		this.sum_company = sum_company;
	}

	public BigDecimal getSum_china() {
		return sum_china;
	}

	public void setSum_china(BigDecimal sum_china) {
		this.sum_china = sum_china;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	
	
}
