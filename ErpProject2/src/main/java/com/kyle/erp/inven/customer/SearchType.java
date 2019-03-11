package com.kyle.erp.inven.customer;

public class SearchType {
	private String searchType;
	private String search;
	
	public SearchType() {
		// TODO Auto-generated constructor stub
	}

	public SearchType(String searchType, String search) {
		super();
		this.searchType = searchType;
		this.search = search;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
