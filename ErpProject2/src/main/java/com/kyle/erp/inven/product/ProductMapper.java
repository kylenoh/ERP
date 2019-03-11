package com.kyle.erp.inven.product;

import java.util.List;

public interface ProductMapper {
	public abstract int regProduct(Product product);
	public abstract int getProductCount();
	public abstract List<Product>getProduct(ProductNo productno);
	public abstract List<Product>searchProduct(SearchProduct s);
	public abstract int updateProduct(Product product);
	public abstract int deleteProduct(Product product);
}
