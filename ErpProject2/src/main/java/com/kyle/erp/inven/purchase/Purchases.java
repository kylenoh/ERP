package com.kyle.erp.inven.purchase;

import java.util.List;

public class Purchases {
	private List<Purchase>purchases;
	
	public Purchases() {
		// TODO Auto-generated constructor stub
	}

	public Purchases(List<Purchase> purchases) {
		super();
		this.purchases = purchases;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

}
