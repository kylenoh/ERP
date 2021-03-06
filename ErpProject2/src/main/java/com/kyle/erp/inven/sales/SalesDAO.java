package com.kyle.erp.inven.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesDAO {

	private int SalesCount;
	
	@Autowired SqlSession ss;
	
	public void deleteSales(Sales sales,HttpServletRequest req,HttpServletResponse res){
		ss.getMapper(SalesMapper.class).deleteSales(sales);
		SalesCount--;
	}
	
	public void getSalesCount(HttpServletRequest req,HttpServletResponse res){
		SalesCount = ss.getMapper(SalesMapper.class).getSalesCount();
	}
	
	public void paging(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		@SuppressWarnings("unchecked")
		List<Sales> searchSales = (List<Sales>) req.getSession().getAttribute("searchSales");

		double count = 5.0;
		req.setAttribute("curPage", pageNo);
		if (searchSales != null && searchSales.size()>0) {
			// 검색
			int pageCount = (int) Math.ceil(searchSales.size()/count);
			req.setAttribute("pageCount", pageCount);
			
			int start = (searchSales.size() - ((pageNo - 1) * (int) count));  
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			////////////////////////////////////////////////////
			ArrayList<Sales>Saleses = new ArrayList<Sales>(); //배열만들기
			Sales p = null;		// 안에 내용을 p

			for (int i = start - 1; i >= end - 1; i--) {
				p = searchSales.get(i);
				Saleses.add(p);
			}
			for (Sales sales : Saleses) {
				sales.setS_subSales(ss.getMapper(SalesMapper.class).getSubSales(sales));
			}
			
			req.setAttribute("sales2", Saleses);

		}else if (SalesCount >0) {
			// 검색없을때 그냥 조회
			int pageCount = (int) Math.ceil(SalesCount / count);
			req.setAttribute("pageCount", pageCount);

			int start = (SalesCount - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			SalesNo salesno = new SalesNo(new BigDecimal(start),new BigDecimal(end));

			List<Sales>Saleses = ss.getMapper(SalesMapper.class).getSales(salesno);
			for (Sales sales : Saleses) {
				sales.setS_subSales(ss.getMapper(SalesMapper.class).getSubSales(sales));
			}
			req.setAttribute("sales2", Saleses);
		}
	}
	
	public void searchSales(SearchSales s,HttpServletRequest req,HttpServletResponse res){
		List<Sales>searchSales = ss.getMapper(SalesMapper.class).searchSales(s);
		req.getSession().setAttribute("searchSales", searchSales);
		
	}
	
	public void clearSearch(HttpServletRequest req, HttpServletResponse res){
		req.getSession().setAttribute("searchSales", null);
	}
	
	public void update(Sales sales,HttpServletRequest req, HttpServletResponse res){
			ss.getMapper(SalesMapper.class).updateSales(sales);
	}

	public void goInvoice(HttpServletRequest req, HttpServletResponse res){
		BigDecimal d_no = new BigDecimal(req.getParameter("d_no"));
		Sales sales = new Sales(d_no, null,null,null,null,null,null, null, null, null, null, null, null, null, null, null);
		Sales salesVal = ss.getMapper(SalesMapper.class).getSalesVal(sales);
		salesVal.setS_subSales(ss.getMapper(SalesMapper.class).getSubSalesVal(salesVal));

		req.setAttribute("salesVal", salesVal);
		
	}

//	JSON
	public Saleses searchSalesJSON(SearchSales s) {
		List<Sales> c1 = ss.getMapper(SalesMapper.class).searchSales(s);
		Saleses c2 = new Saleses(c1);
		return c2;
	}
	public Saleses pagingSalesJSON(int pageNo, Sales c){
		double count = 5.0;
		int pageCount = (int) Math.ceil(SalesCount / count);
		int start = (SalesCount - ((pageNo - 1) * (int) count));
		int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
		SalesNo salesno = new SalesNo(new BigDecimal(start),new BigDecimal(end));
		List<Sales>c1 = ss.getMapper(SalesMapper.class).getSales(salesno);
		Saleses c2 = new Saleses(c1);
		return c2;
	}
	public SubSaleses getDetailSales(SubSales subsales){
		List<SubSales>s1 = ss.getMapper(SalesMapper.class).getSubDetail(subsales);
		SubSaleses s2 = new SubSaleses(s1);
		return s2;
	}
	
	public SubSaleses getGraph(){
		List<SubSales>subsales = ss.getMapper(SalesMapper.class).getGraph();
		SubSaleses subsaleses = new SubSaleses(subsales);
		return subsaleses;
	}
	
	public String regJSON(Sales sales) {
		try {
			if (ss.getMapper(SalesMapper.class).regSales(sales)==1) {
				SalesCount++;
				return "{\"result\":1}";
			}
			return "{\"result\":0}";
			
		} catch (Exception e) {
			return "{\"result\":0}";
		}
	}
	public String regSubJSON(SubSales subsales) {
		try {
			if (ss.getMapper(SalesMapper.class).regSubSales(subsales)==1) {
				return "{\"result\":1}";
			}
			return "{\"result\":0}";
			
		} catch (Exception e) {
			return "{\"result\":0}";
		}
	}
	
	public String updateJSON(Sales sales) {
		try {
			if (ss.getMapper(SalesMapper.class).updateSales(sales)==1) {
				return "{\"result\":1}";
			}
			return "{\"result\":0}";
			
		} catch (Exception e) {
			return "{\"result\":0}";
		}
	}
	public String updateSubJSON(SubSales subsales) {
		try {
			if (ss.getMapper(SalesMapper.class).updateSubSales(subsales)==1) {
				return "{\"result\":1}";
			}
			return "{\"result\":0}";
			
		} catch (Exception e) {
			return "{\"result\":0}";
		}
	}
}
