package com.kyle.erp.inven.currency;

import java.util.List;

public class Currencys {
	private List<Currency>currencys;
	
	public Currencys() {
		// TODO Auto-generated constructor stub
	}

	public Currencys(List<Currency> currencys) {
		super();
		this.currencys = currencys;
	}

	public List<Currency> getCurrencys() {
		return currencys;
	}

	public void setCurrencys(List<Currency> currencys) {
		this.currencys = currencys;
	}


}
