package com.kyle.erp.inven.sales;

import java.util.List;

public interface SalesMapper {
	public abstract int regSales(Sales sales);
	public abstract int getSalesCount();
	public abstract List<Sales>getSales(SalesNo salesno);
	public abstract List<SubSales>getSubSales(Sales sales);
	public abstract Sales getSalesVal(Sales sales);
	public abstract List<SubSales>getSubSalesVal(Sales sales);
	public abstract List<Sales>searchSales(SearchSales s);
	public abstract int updateSales(Sales sales);
	public abstract int updateSubSales(SubSales subsales);
	public abstract int deleteSales(Sales sales);
	public abstract int regSubSales(SubSales subsales);
	public abstract List<SubSales>getSubDetail(SubSales subsales);
}
