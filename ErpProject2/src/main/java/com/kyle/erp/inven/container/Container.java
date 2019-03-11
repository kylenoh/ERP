package com.kyle.erp.inven.container;

public class Container {
	private String con_no;
	private String con_name;
	private String con_note;
	
	public Container() {
		// TODO Auto-generated constructor stub
	}

	public Container(String con_no, String con_name, String con_note) {
		super();
		this.con_no = con_no;
		this.con_name = con_name;
		this.con_note = con_note;
	}

	public String getCon_no() {
		return con_no;
	}

	public void setCon_no(String con_no) {
		this.con_no = con_no;
	}

	public String getCon_name() {
		return con_name;
	}

	public void setCon_name(String con_name) {
		this.con_name = con_name;
	}

	public String getCon_note() {
		return con_note;
	}

	public void setCon_note(String con_note) {
		this.con_note = con_note;
	}


	
}
