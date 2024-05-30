package com.shinhan.dto;

import java.sql.Date;

public class MemberDTO {
	int member_code;
	String authority;
	String name;
	String id;
	String pw;
	String contact;
	Date join_date;
	
	public MemberDTO() {
	}
	
	public MemberDTO(int member_code, String authority, String name, String id, String pw, String contact,
			Date join_date) {
		this.member_code = member_code;
		this.authority = authority;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.contact = contact;
		this.join_date = join_date;
	}



	public int getMember_code() {
		return member_code;
	}



	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}



	public String getAuthority() {
		return authority;
	}



	public void setAuthority(String authority) {
		this.authority = authority;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public Date getJoin_date() {
		return join_date;
	}



	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}





	@Override
	public String toString() {
		return "MemberDTO [member_code=" + member_code + ", authority=" + authority + ", name=" + name + ", id=" + id
				+ ", pw=" + pw + ", contact=" + contact + ", join_date=" + join_date+ "]";
	}
	
	
}
