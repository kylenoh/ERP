package com.kyle.erp.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

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
							Member m = new Member(m_id, null, null, null, null, null, null, null); 
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

	public void join(Member member, HttpServletRequest req, HttpServletResponse res) {
		try {
			String m_addr = String.format("%s=%s=%s", req.getParameter("m_addr1"), req.getParameter("m_addr2"),
					req.getParameter("m_addr3"));
			member.setM_addr(m_addr);
			int result =  ss.getMapper(MemberMapper.class).join(member);	
			if (result==1) {
				req.setAttribute("messageType", "성공 메시지");
				req.setAttribute("messageContent", "회원가입에 성공했습니다.");
				req.setAttribute("contentPage", "member/login.jsp");
				return;
			}else{
				req.setAttribute("messageType", "오류메시지");
				req.setAttribute("messageContent", "이미 존재하는 회원입니다.");
				req.setAttribute("contentPage", "member/join.jsp");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("messageType", "오류메시지");
			req.setAttribute("messageContent", "데이터 베이스 오류");
			req.setAttribute("contentPage", "member/join.jsp");
			return;
		}
		
	}

	public void login(Member member, HttpServletRequest req, HttpServletResponse res) {
		try {
			Member dbM = ss.getMapper(MemberMapper.class).getMemberById(member);
			if (dbM != null) {
				if (member.getM_code().equals(dbM.getM_code())) {
					if (member.getM_pw().equals(dbM.getM_pw())) {
						req.getSession().setAttribute("loginMember", dbM);
						req.getSession().setMaxInactiveInterval(15 * 60);

						req.setAttribute("messageType", "성공 메시지");
						req.setAttribute("messageContent", "로그인 되었습니다.");
						
						String m_auto = req.getParameter("m_auto");
						if (m_auto != null) {
							Cookie autoLoginID = new Cookie("autoLoginID", dbM.getM_id());
							autoLoginID.setMaxAge(1 * 60 * 60 * 24);
							res.addCookie(autoLoginID);
						}
					} else {
						req.setAttribute("messageType", "오류 메시지");
						req.setAttribute("messageContent", "비밀번호 오류입니다.");
					}
				}else {
					req.setAttribute("messageType", "오류 메시지");
					req.setAttribute("messageContent", "회사코드를 확인해주세요");

				}
			} else {
				req.setAttribute("messageType", "오류 메시지");
				req.setAttribute("messageContent", "가입되지 않은 아이디입니다.");
			}

		} catch (Exception e) {
			req.setAttribute("messageType", "오류 메시지");
			req.setAttribute("messageContent", "DB관리자에게 문의 부탁드립니다.");
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

	public void update(Member member, HttpServletRequest req,HttpServletResponse res) {
		try {
			String m_addr = String.format("%s=%s=%s", req.getParameter("m_addr1"), req.getParameter("m_addr2"),
					req.getParameter("m_addr3"));
			member.setM_addr(m_addr);
			int result = ss.getMapper(MemberMapper.class).update(member);
			if (result == 1) {
				login(member, req, res);
				req.setAttribute("messageType", "성공 메시지");
				req.setAttribute("messageContent", "성공적으로 프로필이 변경되었습니다.");
				return;
			}else {
				req.setAttribute("messageType", "오류 메시지");
				req.setAttribute("messageContent", "프로필이 변경되지않았습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateProfile(Member member, HttpServletRequest req, HttpServletResponse res) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		try {
			mr = new MultipartRequest(req, path, 50 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("messageType", "오류메시지");
			req.setAttribute("messageContent", "파일 크기는 50MB를 초과할 수 없습니다.");
			return;
		}

		try {
			String m_id = mr.getParameter("m_id");
			member.setM_id(m_id);
			Member loginMember = (Member) req.getSession().getAttribute("loginMember");
			
			if (!m_id.equals(loginMember.getM_id())) {
				req.setAttribute("messageType", "오류메시지");
				req.setAttribute("messageContent", "접근할 수 없습니다.");
				return;
			}
			String m_photo = mr.getFilesystemName("m_photo");
			if (m_photo != null) {
				m_photo = URLEncoder.encode(m_photo, "utf-8");
				m_photo = m_photo.replace("+", " ");
			} else {
				m_photo = loginMember.getM_photo();
			}
			member.setM_photo(m_photo);
			int result = ss.getMapper(MemberMapper.class).updateProfile(member);
			String m_photo_before = loginMember.getM_photo();
			if (m_photo_before != null) {
				m_photo_before = URLDecoder.decode(m_photo_before, "utf-8");
				File file = new File(path + "/" + m_photo_before);
				file.delete();
			}
			if (result == 1) {
				login(loginMember, req, res);
				req.setAttribute("messageType", "성공 메시지");
				req.setAttribute("messageContent", "성공적으로 프로필이 변경되었습니다.");
				return;
			}else{
				req.setAttribute("messageType", "오류 메시지");
				req.setAttribute("messageContent", "프로필이 변경되지않았습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getMemberList(Member member, HttpServletRequest req, HttpServletResponse res){
		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		member.setM_code(loginMember.getM_code());
		List<Member>members = ss.getMapper(MemberMapper.class).getMemberList(member);
		req.setAttribute("membersList", members);
	}
}
