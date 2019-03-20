package com.kyle.erp.inven.purchase;

import java.math.BigDecimal;

public class PurchaseNo {

	private BigDecimal start;
	private BigDecimal end;
	
	public PurchaseNo() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseNo(BigDecimal start, BigDecimal end) {
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
