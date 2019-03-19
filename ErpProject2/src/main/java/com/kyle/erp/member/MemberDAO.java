package com.kyle.erp.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {
	@Autowired
	private SqlSession ss;

	public void autologin(HttpServletRequest req) {Cookie[] cookies=req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					String m_id = c.getValue();
					if (m_id != null && m_id != "") {
						try {
							Member m = new Member(m_id, null, null, null, null, null); 
							Member dbM = ss.getMapper(MemberMapper.class).getMemberById(m);
							if (dbM != null) {
								req.getSession().setAttribute("loginMember", dbM);
								req.getSession().setMaxInactiveInterval(15 * 60);
							} else {
								req.setAttribute("r", "미가입ID");
							}
						} catch (Exception e) {
							req.setAttribute("r", "DB서버오류");
						}
					}
					break;
				}
			}
		}
	}

	public void bye(HttpServletRequest req, HttpServletResponse res) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				req.setAttribute("r", "탈퇴 성공");
				String m_photo = m.getM_photo();
				m_photo = URLDecoder.decode(m_photo, "utf-8");
				String path = req.getSession().getServletContext().getRealPath("resources/file");
				File f = new File(path + "/" + m_photo);
				f.delete();
				logout(req, res);
			}
		} catch (Exception e) {
			req.setAttribute("r", "탈퇴 실패");
		}
	}

	public void divideAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String[] addr = m.getM_addr().split("=");
		req.setAttribute("addr1", addr[0]);
		req.setAttribute("addr2", addr[1]);
		req.setAttribute("addr3", addr[2]);
	}

	public Members idCheck(Member m) {
		Member dbM = ss.getMapper(MemberMapper.class).getMemberById(m);
		ArrayList<Member> al = new ArrayList<Member>();
		al.add(dbM);
		Members ms = new Members(al);
		return ms;
	}

	public void join(Member m, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		try {
			mr = new MultipartRequest(req, path, 50 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "가입 실패");
			return;
		}

		try {
			m.setM_id(mr.getParameter("m_id"));
			m.setM_pw(mr.getParameter("m_pw"));
			m.setM_name(mr.getParameter("m_name"));
			m.setM_email(mr.getParameter("m_email"));
			String m_addr = String.format("%s=%s=%s", mr.getParameter("m_addr1"), mr.getParameter("m_addr2"),
					mr.getParameter("m_addr3"));
			m.setM_addr(m_addr);
			String m_photo = mr.getFilesystemName("m_photo");
			m_photo = URLEncoder.encode(m_photo, "utf-8");
			m_photo = m_photo.replace("+", " ");
			m.setM_photo(m_photo);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("r", "가입 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "가입 실패");
			File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
			f.delete();
		}
	}

	public void login(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			Member dbM = ss.getMapper(MemberMapper.class).getMemberById(m);
			if (dbM != null) {
				if (m.getM_pw().equals(dbM.getM_pw())) {
					req.getSession().setAttribute("loginMember", dbM);
					req.getSession().setMaxInactiveInterval(15 * 60);

					String m_auto = req.getParameter("m_auto");
					if (m_auto != null) {
						Cookie autoLoginID = new Cookie("autoLoginID", dbM.getM_id());
						autoLoginID.setMaxAge(1 * 60 * 60 * 24);
						res.addCookie(autoLoginID);
					}
				} else {
					req.setAttribute("r", "비번오류");
				}
			} else {
				req.setAttribute("r", "미가입ID");
			}

		} catch (Exception e) {
			req.setAttribute("r", "DB서버오류");
		}
	}

	public void loginCheck(HttpServletRequest req) {
		autologin(req);
		req.getSession().getAttribute("loginMember");
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("loginMember", null);

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					c.setValue(null);
					res.addCookie(c);
				}
			}
		}
	}

	public void update(Member m, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		try {
			mr = new MultipartRequest(req, path, 50 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "수정 실패");
			return;
		}

		try {
			m.setM_id(mr.getParameter("m_id"));
			m.setM_pw(mr.getParameter("m_pw"));
			m.setM_name(mr.getParameter("m_name"));
			m.setM_email(mr.getParameter("m_email"));
			String m_addr = String.format("%s=%s=%s", mr.getParameter("m_addr1"), mr.getParameter("m_addr2"),
					mr.getParameter("m_addr3"));
			m.setM_addr(m_addr);
			String m_photo = mr.getFilesystemName("m_photo");

			Member loginMember = (Member) req.getSession().getAttribute("loginMember");
			if (m_photo != null) {
				m_photo = URLEncoder.encode(m_photo, "utf-8");
				m_photo = m_photo.replace("+", " ");

				String m_photo_before = loginMember.getM_photo();
				m_photo_before = URLDecoder.decode(m_photo_before, "utf-8");

				File f = new File(path + "/" + m_photo_before);
				f.delete();
			} else {
				m_photo = loginMember.getM_photo();
			}
			m.setM_photo(m_photo);
			if (ss.getMapper(MemberMapper.class).update(m) == 1) {
				req.setAttribute("r", "수정 성공");
				req.getSession().setAttribute("loginMember", m);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "수정 실패");
			File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
			f.delete();
		}
	}
}
