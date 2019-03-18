package com.kyle.erp.company;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class CompanyDAO {

	@Autowired SqlSession ss;
	
	public void regCompany(Company company,HttpServletRequest req, HttpServletResponse res){
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		try {
			mr = new MultipartRequest(req, path, 50 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "가입 실패");
			return;
		}
		try {
			company.setCom_name(mr.getParameter("com_name"));
			company.setCom_no(mr.getParameter("com_no"));
			company.setCom_email(mr.getParameter("com_email"));
			company.setCom_tel(mr.getParameter("com_tel"));
			company.setCom_addr(mr.getParameter("com_addr"));
			company.setCom_ename(mr.getParameter("com_ename"));
			company.setCom_etel(mr.getParameter("com_etel"));
			company.setCom_eaddr(mr.getParameter("com_eaddr"));
			String com_logo = mr.getFilesystemName("m_photo");
			com_logo = URLEncoder.encode(com_logo, "utf-8");
			com_logo = com_logo.replace("+", " ");
			company.setCom_logo(com_logo);

			if (ss.getMapper(CompanyMapper.class).regCompany(company) == 1) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			File f = new File(path + "/" + mr.getFilesystemName("com_logo"));
			f.delete();
		}
		
		
	}
}
