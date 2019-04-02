package com.kyle.erp.inven.container;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ContainerController {

	@Autowired ContainerDAO CONDAO;
	
	@RequestMapping(value = "/go.container", method = RequestMethod.GET)
	public String goContainer(HttpServletRequest req,HttpServletResponse res) {
		CONDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/container.jsp");
		return "index";
	}
	@RequestMapping(value = "/reg.container", method = RequestMethod.POST)
	public String regContainer(Container container,HttpServletRequest req,HttpServletResponse res) {
		CONDAO.regContainer(container, req, res);
		CONDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/container.jsp");
		return "index";
	}
	@RequestMapping(value = "/Containerpage.change", method = RequestMethod.GET)
	public String pageChange(HttpServletRequest req, HttpServletResponse res) {
		CONDAO.paging(Integer.parseInt(req.getParameter("p")), req, res);
		CONDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/container.jsp");
		return "index";
	}
	@RequestMapping(value = "/search.container", method = RequestMethod.GET)
	public String searchContainer(SearchContainer s,HttpServletRequest req, HttpServletResponse res) {
		CONDAO.searchContainer(s, req, res);
		CONDAO.paging(1, req, res);
		CONDAO.clearSearch(req, res);
		req.setAttribute("contentPage", "inven/container.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update.container", method = RequestMethod.POST)
	public String updateContainer(Container container,HttpServletRequest req,HttpServletResponse res) {
		CONDAO.update(container, req, res);
		CONDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/container.jsp");
		return "index";
	}
	@RequestMapping(value = "/delete.container", method = RequestMethod.GET)
	public String deleteContainer(Container container,HttpServletRequest req,HttpServletResponse res) {
		CONDAO.deleteContainer(container, req, res);
		CONDAO.paging(1, req, res);
		req.setAttribute("contentPage", "inven/container.jsp");
		return "index";
	}
//	JSON
	@RequestMapping(value = "/container.pagingJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Containers pagingContainer(Container container,HttpServletRequest req) {
		return CONDAO.pagingContainersJSON(1, container);
	}
	@RequestMapping(value = "/container.pageChangeJSON", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Containers pageChangeContainer(Container container,HttpServletRequest req) {
		int pageNo = Integer.parseInt(req.getParameter("c"));
		return CONDAO.pagingContainersJSON(pageNo, container);
	}
}
