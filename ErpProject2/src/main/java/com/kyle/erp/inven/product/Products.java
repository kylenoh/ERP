package com.kyle.erp.inven.product;

import java.util.List;

public class Products {
	private List<Product>products;
	private int productCount;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(List<Product> products, int productCount) {
		super();
		this.products = products;
		this.productCount = productCount;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	

		
}
