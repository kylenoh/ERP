package com.kyle.erp.group.bbs;

import java.math.BigDecimal;

public class BBSNo {
	private BigDecimal start;
	private BigDecimal end;

	public BBSNo() {
		// TODO Auto-generated constructor stub
	}

	public BBSNo(BigDecimal start, BigDecimal end) {
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
