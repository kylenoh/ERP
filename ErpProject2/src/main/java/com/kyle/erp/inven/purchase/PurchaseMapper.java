package com.kyle.erp.inven.purchase;

import java.util.List;

public interface PurchaseMapper {
	public abstract int regPurchase(Purchase purchase);
	public abstract int getPurchaseCount();
	public abstract List<Purchase>getPurchase(PurchaseNo purchaseno);
	public abstract List<SubPurchase>getSubPurchase(Purchase purchase);
	public abstract Purchase getPurchaseVal(Purchase purchase);
	public abstract List<SubPurchase>getSubPurchaseVal(Purchase purchase);
	public abstract List<Purchase>searchPurchase(SearchPurchase s);
	public abstract int updatePurchase(Purchase purchase);
	public abstract int updateSubPurchase(SubPurchase subpurchase);
	public abstract int deletePurchase(Purchase purchase);
	public abstract int regSubPurchase(SubPurchase subpurchase);
	public abstract List<SubPurchase>getSubDetailPurchase(SubPurchase subpurchase);
	public abstract List<SubPurchase>getGraph2();
}
