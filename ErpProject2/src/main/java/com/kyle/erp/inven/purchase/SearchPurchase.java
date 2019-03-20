package com.kyle.erp.inven.purchase;

public class SearchPurchase {
	private String searchSales;
	private String search;
	
	public SearchPurchase() {
		// TODO Auto-generated constructor stub
	}

	public SearchPurchase(String searchSales, String search) {
		super();
		this.searchSales = searchSales;
		this.search = search;
	}

	public String getSearchSales() {
		return searchSales;
	}

	public void setSearchSales(String searchSales) {
		this.searchSales = searchSales;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	
	
}
