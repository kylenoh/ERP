package com.kyle.erp.inven.currency;

import java.util.List;

public interface CurrencyMapper {
	public abstract int regCurrency(Currency currency);
	public abstract int getCurrencyCount();
	public abstract List<Currency>getCurrency(CurrencyNo currencyno);
	public abstract List<Currency>searchCurrency(SearchCurrency s);
	public abstract int updateCurrency(Currency currency);
	public abstract int deleteCurrency(Currency currency);
}
