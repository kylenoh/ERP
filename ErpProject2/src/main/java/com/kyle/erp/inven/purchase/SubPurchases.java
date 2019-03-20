package com.kyle.erp.inven.purchase;

import java.util.List;

public class SubPurchases {
	private List<SubPurchase>subpurchase;
	
	public SubPurchases() {
		// TODO Auto-generated constructor stub
	}

	public SubPurchases(List<SubPurchase> subpurchase) {
		super();
		this.subpurchase = subpurchase;
	}

	public List<SubPurchase> getSubpurchase() {
		return subpurchase;
	}

	public void setSubpurchase(List<SubPurchase> subpurchase) {
		this.subpurchase = subpurchase;
	}

	
	
}
