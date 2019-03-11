package com.kyle.erp.inven.container;

public class SearchContainer {
	private String searchContainer;
	private String search;
	
	public SearchContainer() {
		// TODO Auto-generated constructor stub
	}

	public SearchContainer(String searchContainer, String search) {
		super();
		this.searchContainer = searchContainer;
		this.search = search;
	}

	public String getSearchContainer() {
		return searchContainer;
	}

	public void setSearchContainer(String searchContainer) {
		this.searchContainer = searchContainer;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
