package com.kyle.erp.inven.stock;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.erp.inven.container.Container;
import com.kyle.erp.inven.container.ContainerMapper;

@Service
public class StockDAO {

	@Autowired SqlSession ss;

	public void getPurchaseStock(HttpServletResponse res, HttpServletRequest req){
		List<Container>container = ss.getMapper(ContainerMapper.class).getAllContainer();
		List<Stock> purchase = new ArrayList<Stock>();
		Stock s = null;
		for (int i = 0; i < container.size(); i++) {
			List<Stock> stock = ss.getMapper(StockMapper.class).getPurchasebyContainer(container.get(i));
			List<Stock> stock2 = ss.getMapper(StockMapper.class).getSalesbyContainer(container.get(i));
			if (stock.size() == 0) {
				break;
			}
			if (i == 0) {
				for (int j = 0; j < stock.size(); j++) {
					s = new Stock();
					s.setPsb_pro_no(stock.get(j).getPsb_pro_no());
					s.setPro_name(stock.get(j).getPro_name());
					s.setSum_company(stock.get(j).getSum());
					s.setOut_company(stock2.get(j).getOut());
					purchase.add(s);
				}
			} else if (i == 1) {
				for (int j = 0; j < stock.size(); j++) {
					s = purchase.get(j);
					s.setSum_china(stock.get(j).getSum());
					s.setOut_china(stock2.get(j).getOut());
					purchase.set(j, s);
				}
			}
		}
		req.setAttribute("Purchasestock", purchase);
	}
	
}
