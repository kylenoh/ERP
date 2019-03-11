package com.kyle.erp.member;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Members {
	private ArrayList<Member> member;

	public Members() {
		// TODO Auto-generated constructor stub
	}

	public Members(ArrayList<Member> member) {
		super();
		this.member = member;
	}

	public ArrayList<Member> getMember() {
		return member;
	}
	@XmlElement
	public void setMember(ArrayList<Member> member) {
		this.member = member;
	}

}
