package com.kyle.erp.inven.purchase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDAO {

	private int PurchaseCount;
	
	@Autowired SqlSession ss;
	
	public void deletePurchase(Purchase purchase,HttpServletRequest req,HttpServletResponse res){
		ss.getMapper(PurchaseMapper.class).deletePurchase(purchase);
		PurchaseCount--;
	}
	
	public void getPurchaseCount(HttpServletRequest req,HttpServletResponse res){
		PurchaseCount = ss.getMapper(PurchaseMapper.class).getPurchaseCount();
	}
	
	public void paging(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		@SuppressWarnings("unchecked")
		List<Purchase> searchPurchase = (List<Purchase>) req.getSession().getAttribute("searchPurchase");

		double count = 5.0;
		req.setAttribute("curPage", pageNo);
		if (searchPurchase != null && searchPurchase.size()>0) {
			// 검색
			int pageCount = (int) Math.ceil(searchPurchase.size()/count);
			req.setAttribute("pageCount", pageCount);
			
			int start = (searchPurchase.size() - ((pageNo - 1) * (int) count));  
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			////////////////////////////////////////////////////
			ArrayList<Purchase>Purchases = new ArrayList<Purchase>(); //배열만들기
			Purchase p = null;		// 안에 내용을 p

			for (int i = start - 1; i >= end - 1; i--) {
				p = searchPurchase.get(i);
				Purchases.add(p);
			}
			for (Purchase purchase : Purchases) {
				purchase.setPs_subPurchase(ss.getMapper(PurchaseMapper.class).getSubPurchase(purchase));
			}
			
			req.setAttribute("purchase2", Purchases);

		}else if (PurchaseCount >0) {
			// 검색없을때 그냥 조회
			int pageCount = (int) Math.ceil(PurchaseCount / count);
			req.setAttribute("pageCount", pageCount);

			int start = (PurchaseCount - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			PurchaseNo purchaseno = new PurchaseNo(new BigDecimal(start),new BigDecimal(end));

			List<Purchase>Purchases = ss.getMapper(PurchaseMapper.class).getPurchase(purchaseno);
			for (Purchase purchase : Purchases) {
				purchase.setPs_subPurchase(ss.getMapper(PurchaseMapper.class).getSubPurchase(purchase));
			}
			req.setAttribute("purchase2", Purchases);
		}
	}
	
	public void searchPurchase(SearchPurchase s,HttpServletRequest req,HttpServletResponse res){
		List<Purchase>searchPurchase = ss.getMapper(PurchaseMapper.class).searchPurchase(s);
		req.getSession().setAttribute("searchPurchase", searchPurchase);
		
	}
	
	public void clearSearch(HttpServletRequest req, HttpServletResponse res){
		req.getSession().setAttribute("searchPurchase", null);
	}
	
	public void update(Purchase purchase,HttpServletRequest req, HttpServletResponse res){
			ss.getMapper(PurchaseMapper.class).updatePurchase(purchase);
	}

	public void goInvoice(HttpServletRequest req, HttpServletResponse res){
		BigDecimal d_no = new BigDecimal(req.getParameter("d_no"));
		Purchase purchase = new Purchase(d_no, null,null,null,null,null,null, null, null, null, null, null, null, null, null, null);
		Purchase purchaseVal = ss.getMapper(PurchaseMapper.class).getPurchaseVal(purchase);
		purchaseVal.setPs_subPurchase(ss.getMapper(PurchaseMapper.class).getSubPurchaseVal(purchaseVal));

		req.setAttribute("purchaseVal", purchaseVal);
		
	}

//	JSON
	public Purchases searchPurchaseJSON(SearchPurchase s) {
		List<Purchase> c1 = ss.getMapper(PurchaseMapper.class).searchPurchase(s);
		Purchases c2 = new Purchases(c1);
		return c2;
	}
	public Purchases pagingPurchaseJSON(int pageNo, Purchase c){
		double count = 5.0;
		int pageCount = (int) Math.ceil(PurchaseCount / count);
		int start = (PurchaseCount - ((pageNo - 1) * (int) count));
		int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
		PurchaseNo purchaseno = new PurchaseNo(new BigDecimal(start),new BigDecimal(end));
		List<Purchase>c1 = ss.getMapper(PurchaseMapper.class).getPurchase(purchaseno);
		Purchases c2 = new Purchases(c1);
		return c2;
	}
	public SubPurchases getDetailPurchase(SubPurchase subpurchase){
		List<SubPurchase>s1 = ss.getMapper(PurchaseMapper.class).getSubDetailPurchase(subpurchase);
		SubPurchases s2 = new SubPurchases(s1);
		return s2;
	}
	
	public String regJSON(Purchase purchase) {
		try {
			if (ss.getMapper(PurchaseMapper.class).regPurchase(purchase)==1) {
				PurchaseCount++;
				return "{\"result\":1}";
			}
			return "{\"result\":0}";
			
		} catch (Exception e) {
			return "{\"result\":0}";
		}
	}
	public String regSubJSON(SubPurchase subpurchase) {
		try {
			if (ss.getMapper(PurchaseMapper.class).regSubPurchase(subpurchase)==1) {
				return "{\"result\":1}";
			}
			return "{\"result\":0}";
			
		} catch (Exception e) {
			return "{\"result\":0}";
		}
	}
	
	public String updateJSON(Purchase purchase) {
		try {
			if (ss.getMapper(PurchaseMapper.class).updatePurchase(purchase)==1) {
				return "{\"result\":1}";
			}
			return "{\"result\":0}";
			
		} catch (Exception e) {
			return "{\"result\":0}";
		}
	}
	public String updateSubJSON(SubPurchase subpurchase) {
		try {
			if (ss.getMapper(PurchaseMapper.class).updateSubPurchase(subpurchase)==1) {
				return "{\"result\":1}";
			}
			return "{\"result\":0}";
			
		} catch (Exception e) {
			return "{\"result\":0}";
		}
	}
}
