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
	public void getStock(HttpServletResponse res, HttpServletRequest req){
		List<Container>container = ss.getMapper(ContainerMapper.class).getAllContainer();
		List<Stock> stock2 = new ArrayList<Stock>();
		Stock s = null;
		for (int i = 0; i < container.size(); i++) {
			List<Stock> stock = ss.getMapper(StockMapper.class).getSumQtybyContainer(container.get(i));
			if (stock.size() == 0) {
				break;
			}
			if (i == 0) {
				for (int j = 0; j < stock.size(); j++) {
					s = new Stock();
					s.setSb_pro_no(stock.get(j).getSb_pro_no());
					s.setPro_name(stock.get(j).getPro_name());
					s.setSum_company(stock.get(j).getSum());
					stock2.add(s);
				}
			} else if (i == 1) {
				for (int j = 0; j < stock.size(); j++) {
					s = stock2.get(j);
					s.setSum_china(stock.get(j).getSum());
					stock2.set(j, s);
				}
			}
		}
		req.setAttribute("stock", stock2);
	}
	
}
