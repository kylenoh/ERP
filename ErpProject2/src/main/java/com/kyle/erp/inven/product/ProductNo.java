package com.kyle.erp.inven.product;

import java.math.BigDecimal;

public class ProductNo {

	private BigDecimal start;
	private BigDecimal end;
	
	public ProductNo() {
		// TODO Auto-generated constructor stub
	}

	public ProductNo(BigDecimal start, BigDecimal end) {
		super();
		this.start = start;
		this.end = end;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}
}
