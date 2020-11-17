package com.bb.dto;

import java.util.Date;

public class CustomerServiceDto {

	private int cs_no;
	private String cs_title;
	private String cs_content;
	private Date cs_regdate;
	
	public CustomerServiceDto() {
		
	}
	public CustomerServiceDto(int cs_no, String cs_title, String cs_content, Date cs_regdate) {
		this.cs_no = cs_no;
		this.cs_title = cs_title;
		this.cs_content = cs_content;
		this.cs_regdate = cs_regdate;
	}
	// insert 용
	public CustomerServiceDto(String cs_title, String cs_content) {
		this.cs_title = cs_title;
		this.cs_content = cs_content;
	}
	
	//update 용
	public CustomerServiceDto(int cs_no, String cs_title, String cs_content) {
		this.cs_no = cs_no;
		this.cs_title = cs_title;
		this.cs_content = cs_content;
	}
	public int getCs_no() {
		return cs_no;
	}
	public void setCs_no(int cs_no) {
		this.cs_no = cs_no;
	}
	public String getCs_title() {
		return cs_title;
	}
	public void setCs_title(String cs_title) {
		this.cs_title = cs_title;
	}
	public String getCs_content() {
		return cs_content;
	}
	public void setCs_content(String cs_content) {
		this.cs_content = cs_content;
	}
	public Date getCs_regdate() {
		return cs_regdate;
	}
	public void setCs_regdate(Date cs_regdate) {
		this.cs_regdate = cs_regdate;
	}
	
}
