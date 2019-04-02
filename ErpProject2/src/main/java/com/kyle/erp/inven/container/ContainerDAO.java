package com.kyle.erp.inven.container;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContainerDAO {

	private int ContainerCount;
	
	@Autowired SqlSession ss;
	
	public void regContainer(Container container,HttpServletRequest req,HttpServletResponse res){
		try {
			if (ss.getMapper(ContainerMapper.class).regContainer(container)==1) {
				ContainerCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteContainer(Container container,HttpServletRequest req,HttpServletResponse res){
		ss.getMapper(ContainerMapper.class).deleteContainer(container);
		ContainerCount--;
	}
	
	public void getContainerCount(HttpServletRequest req,HttpServletResponse res){
		ContainerCount = ss.getMapper(ContainerMapper.class).getContainerCount();
	}
	
	public void paging(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		@SuppressWarnings("unchecked")
		List<Container> searchContainers = (List<Container>) req.getSession().getAttribute("searchContainers");

		double count = 5.0;
		req.setAttribute("curPage", pageNo);
		if (searchContainers != null && searchContainers.size()>0) {
			// 검색
			int pageCount = (int) Math.ceil(searchContainers.size()/count);
			req.setAttribute("pageCount", pageCount);
			
			int start = (searchContainers.size() - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			ArrayList<Container>Containers = new ArrayList<Container>();
			Container c = null;

			for (int i = start - 1; i >= end - 1; i--) {
				c = searchContainers.get(i);
				Containers.add(c);
			}
			req.setAttribute("containers", Containers);

		}else if (ContainerCount >0) {
			// 검색없을때 그냥 조회
			int pageCount = (int) Math.ceil(ContainerCount / count);
			req.setAttribute("pageCount", pageCount);

			int start = (ContainerCount - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			
			ContainerNo containerno = new ContainerNo(new BigDecimal(start),new BigDecimal(end));

			List<Container>Containers = ss.getMapper(ContainerMapper.class).getContainer(containerno);
			req.setAttribute("containers", Containers);
		}
	}
	
	public void searchContainer(SearchContainer s,HttpServletRequest req,HttpServletResponse res){
		List<Container>searchContainers = ss.getMapper(ContainerMapper.class).searchContainer(s);
		req.getSession().setAttribute("searchContainers", searchContainers);
	}
	
	public void clearSearch(HttpServletRequest req, HttpServletResponse res){
		req.getSession().setAttribute("searchContainers", null);
	}
	
	public void update(Container container,HttpServletRequest req, HttpServletResponse res){
			ss.getMapper(ContainerMapper.class).updateContainer(container);
	}

//	JSON
	public Containers pagingContainersJSON(int pageNo, Container c){
		double count = 5.0;
		int containerCount = (int) Math.ceil(ContainerCount / count);
		int start = (ContainerCount - ((pageNo - 1) * (int) count));
		int end = (pageNo == containerCount) ? 1 : (start - ((int) count - 1));
		ContainerNo containerno = new ContainerNo(new BigDecimal(start),new BigDecimal(end));
		List<Container>c1 = ss.getMapper(ContainerMapper.class).getContainer(containerno);
		Containers c2 = new Containers(c1,containerCount);
		return c2;
	}
	
}
