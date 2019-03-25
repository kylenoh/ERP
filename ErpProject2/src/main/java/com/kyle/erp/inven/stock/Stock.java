package com.kyle.erp.inven.stock;

import java.math.BigDecimal;

public class Stock {
	private String psb_pro_no;
	private String pro_name;
	private BigDecimal sum_company;
	private BigDecimal sum_china;
	private BigDecimal sum;
	private BigDecimal out_company;
	private BigDecimal out_china;
	private BigDecimal out;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(String psb_pro_no, String pro_name, BigDecimal sum_company, BigDecimal sum_china, BigDecimal sum,
			BigDecimal out_company, BigDecimal out_china, BigDecimal out) {
		super();
		this.psb_pro_no = psb_pro_no;
		this.pro_name = pro_name;
		this.sum_company = sum_company;
		this.sum_china = sum_china;
		this.sum = sum;
		this.out_company = out_company;
		this.out_china = out_china;
		this.out = out;
	}

	public String getPsb_pro_no() {
		return psb_pro_no;
	}

	public void setPsb_pro_no(String psb_pro_no) {
		this.psb_pro_no = psb_pro_no;
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

	public BigDecimal getOut_company() {
		return out_company;
	}

	public void setOut_company(BigDecimal out_company) {
		this.out_company = out_company;
	}

	public BigDecimal getOut_china() {
		return out_china;
	}

	public void setOut_china(BigDecimal out_china) {
		this.out_china = out_china;
	}

	public BigDecimal getOut() {
		return out;
	}

	public void setOut(BigDecimal out) {
		this.out = out;
	}

	
	
	
	
}
