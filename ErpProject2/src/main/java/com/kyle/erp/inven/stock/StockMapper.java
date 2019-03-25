package com.kyle.erp.inven.stock;

import java.util.List;

import com.kyle.erp.inven.container.Container;

public interface StockMapper {
	public abstract List<Stock> getSalesbyContainer(Container container);
	public abstract List<Stock> getPurchasebyContainer(Container container);
}
