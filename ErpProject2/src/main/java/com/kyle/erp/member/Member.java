package com.kyle.erp.member;

import java.math.BigDecimal;

public class Member {
	private String m_id;
	private BigDecimal m_code;
	private String m_pw;
	private String m_name;
	private String m_email;
	private String m_addr;
	private String m_photo;

	private String auth_name;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String m_id, BigDecimal m_code, String m_pw, String m_name, String m_email, String m_addr,
			String m_photo, String auth_name) {
		super();
		this.m_id = m_id;
		this.m_code = m_code;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_addr = m_addr;
		this.m_photo = m_photo;
		this.auth_name = auth_name;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public BigDecimal getM_code() {
		return m_code;
	}

	public void setM_code(BigDecimal m_code) {
		this.m_code = m_code;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	public String getAuth_name() {
		return auth_name;
	}

	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}

	
}
