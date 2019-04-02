package com.kyle.erp.inven.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAO {

	private int ProductCount;
	
	@Autowired SqlSession ss;
	
	public void regProduct(Product product,HttpServletRequest req,HttpServletResponse res){
		try {
			if (ss.getMapper(ProductMapper.class).regProduct(product)==1) {
				ProductCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(Product product,HttpServletRequest req,HttpServletResponse res){
		ss.getMapper(ProductMapper.class).deleteProduct(product);
		ProductCount--;
	}
	
	public void getProductCount(HttpServletRequest req,HttpServletResponse res){
		ProductCount = ss.getMapper(ProductMapper.class).getProductCount();
	}
	
	public void paging(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		@SuppressWarnings("unchecked")
		List<Product> searchProducts = (List<Product>) req.getSession().getAttribute("searchProducts");

		double count = 5.0;
		req.setAttribute("curPage", pageNo);
		if (searchProducts != null && searchProducts.size()>0) {
			// 검색
			int pageCount = (int) Math.ceil(searchProducts.size()/count);
			req.setAttribute("pageCount", pageCount);
			
			int start = (searchProducts.size() - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			ArrayList<Product>Products = new ArrayList<Product>();
			Product p = null;

			for (int i = start - 1; i >= end - 1; i--) {
				p = searchProducts.get(i);
				Products.add(p);
			}
			req.setAttribute("products", Products);

		}else if (ProductCount >0) {
			// 검색없을때 그냥 조회
			int pageCount = (int) Math.ceil(ProductCount / count);
			req.setAttribute("pageCount", pageCount);

			int start = (ProductCount - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			ProductNo productno = new ProductNo(new BigDecimal(start),new BigDecimal(end));

			List<Product>Products = ss.getMapper(ProductMapper.class).getProduct(productno);
			req.setAttribute("products", Products);
		}
	}
	
	public void searchProduct(SearchProduct s,HttpServletRequest req,HttpServletResponse res){
		List<Product>searchProducts = ss.getMapper(ProductMapper.class).searchProduct(s);
		req.getSession().setAttribute("searchProducts", searchProducts);
	}
	
	public void clearSearch(HttpServletRequest req, HttpServletResponse res){
		req.getSession().setAttribute("searchProducts", null);
	}
	
	public void update(Product product,HttpServletRequest req, HttpServletResponse res){
			ss.getMapper(ProductMapper.class).updateProduct(product);
		
		
	}

//	JSON
	public Products pagingProductsJSON(int pageNo, Product c){
		double count = 5.0;
		int productCount = (int) Math.ceil(ProductCount / count);
		int start = (ProductCount - ((pageNo - 1) * (int) count));
		int end = (pageNo == productCount) ? 1 : (start - ((int) count - 1));
		ProductNo productno = new ProductNo(new BigDecimal(start),new BigDecimal(end));
		List<Product>c1 = ss.getMapper(ProductMapper.class).getProduct(productno);
		Products c2 = new Products(c1,productCount);
		return c2;
	}
	
}
