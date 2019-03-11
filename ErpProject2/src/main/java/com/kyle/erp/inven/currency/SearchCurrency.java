package com.kyle.erp.inven.currency;

public class SearchCurrency {
	private String searchCurrency;
	private String search;
	
	public SearchCurrency() {
		// TODO Auto-generated constructor stub
	}

	public SearchCurrency(String searchCurrency, String search) {
		super();
		this.searchCurrency = searchCurrency;
		this.search = search;
	}

	public String getSearchCurrency() {
		return searchCurrency;
	}

	public void setSearchCurrency(String searchCurrency) {
		this.searchCurrency = searchCurrency;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	
}
