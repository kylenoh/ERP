package com.kyle.erp.inven.container;

import java.math.BigDecimal;

public class ContainerNo {

	private BigDecimal start;
	private BigDecimal end;
	
	public ContainerNo() {
		// TODO Auto-generated constructor stub
	}

	public ContainerNo(BigDecimal start, BigDecimal end) {
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
