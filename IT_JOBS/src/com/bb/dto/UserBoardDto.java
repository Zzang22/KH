package com.bb.dto;

import java.util.Date;

public class UserBoardDto {
	
	private int userboard_no;
	private int member_no;
	private String userboard_title;
	private String userboard_content;
	private Date userboard_regdate;
	private String member_id;
	
	public UserBoardDto() {
		
	}
	
	public UserBoardDto(int userboard_no, int member_no, String userboard_title, String userboard_content,
			Date userboard_regdate, String member_id) {
		super();
		this.userboard_no = userboard_no;
		this.member_no = member_no;
		this.userboard_title = userboard_title;
		this.userboard_content = userboard_content;
		this.userboard_regdate = userboard_regdate;
		this.member_id = member_id;
	}
	public int getUserboard_no() {
		return userboard_no;
	}
	public void setUserboard_no(int userboard_no) {
		this.userboard_no = userboard_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getUserboard_title() {
		return userboard_title;
	}
	public void setUserboard_title(String userboard_title) {
		this.userboard_title = userboard_title;
	}
	public String getUserboard_content() {
		return userboard_content;
	}
	public void setUserboard_content(String userboard_content) {
		this.userboard_content = userboard_content;
	}
	public Date getUserboard_regdate() {
		return userboard_regdate;
	}
	public void setUserboard_regdate(Date userboard_regdate) {
		this.userboard_regdate = userboard_regdate;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
	
	
	
	

}
