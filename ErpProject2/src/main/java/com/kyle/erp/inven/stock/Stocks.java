package com.kyle.erp.inven.stock;

import java.util.List;

public class Stocks {
	private List<Stock>stocks;
	
	public Stocks() {
		// TODO Auto-generated constructor stub
	}

	public Stocks(List<Stock> stocks) {
		super();
		this.stocks = stocks;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	
}
