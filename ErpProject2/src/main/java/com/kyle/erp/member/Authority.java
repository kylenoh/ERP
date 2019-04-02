package com.kyle.erp.member;

public class Authority {
	private int auth_key;
	private String auth_name;
	
	public Authority() {
		// TODO Auto-generated constructor stub
	}

	public int getAuth_key() {
		return auth_key;
	}

	public void setAuth_key(int auth_key) {
		this.auth_key = auth_key;
	}

	public String getAuth_name() {
		return auth_name;
	}

	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}

	public Authority(int auth_key, String auth_name) {
		super();
		this.auth_key = auth_key;
		this.auth_name = auth_name;
	}
	
	
}
