package com.kyle.erp.inven.product;

public class SearchProduct {
	private String searchProduct;
	private String search;
	
	public SearchProduct() {
		// TODO Auto-generated constructor stub
	}

	public SearchProduct(String searchProduct, String search) {
		super();
		this.searchProduct = searchProduct;
		this.search = search;
	}

	public String getSearchProduct() {
		return searchProduct;
	}

	public void setSearchProduct(String searchProduct) {
		this.searchProduct = searchProduct;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	
}
