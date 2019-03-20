package com.kyle.erp.company;

public interface CompanyMapper {
	public abstract int regCompany(Company company);
	public abstract Company getCompany();
	public abstract int updateCompany(Company company);
}
