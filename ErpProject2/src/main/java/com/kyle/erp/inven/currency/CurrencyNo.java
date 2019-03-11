package com.kyle.erp.inven.currency;

import java.math.BigDecimal;

public class CurrencyNo {

	private BigDecimal start;
	private BigDecimal end;
	
	public CurrencyNo() {
		// TODO Auto-generated constructor stub
	}

	public CurrencyNo(BigDecimal start, BigDecimal end) {
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
