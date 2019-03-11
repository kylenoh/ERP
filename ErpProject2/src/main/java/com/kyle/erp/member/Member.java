package com.kyle.erp.member;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Member {
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_email;
	private String m_addr;
	private String m_photo;

	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String m_id, String m_pw, String m_name, String m_email, String m_addr, String m_photo) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_addr = m_addr;
		this.m_photo = m_photo;
	}

	public String getM_id() {
		return m_id;
	}
	@XmlElement
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	@XmlElement
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	@XmlElement
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_email() {
		return m_email;
	}
	@XmlElement
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_addr() {
		return m_addr;
	}
	@XmlElement
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public String getM_photo() {
		return m_photo;
	}
	@XmlElement
	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}
}
