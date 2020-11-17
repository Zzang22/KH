package com.bb.dto;

public class RsDto {
	
	private int rs_no;
	private int member_no;
	private String rs_img_name;
	private String rs_img_path;
	private String rs_selfintro;
	private String rs_title;
	
	 private int jo_no;
	

	public int getJo_no() {
		return jo_no;
	}

	public void setJo_no(int jo_no) {
		this.jo_no = jo_no;
	}

	public RsDto() {
		
	}
	
	public RsDto(int rs_no, String rs_selfintro) {
		super();
		this.rs_no = rs_no;
		this.rs_selfintro = rs_selfintro;
	}

	public RsDto(int rs_no, String rs_img_name, String rs_img_path, String rs_title) {
		super();
		this.rs_no = rs_no;
		this.rs_img_name = rs_img_name;
		this.rs_img_path = rs_img_path;
		this.rs_title = rs_title;
	}

	public RsDto(int member_no, String rs_img_name, String rs_img_path, String rs_selfintro, String rs_title) {
		
		this.member_no = member_no;
		this.rs_img_name = rs_img_name;
		this.rs_img_path = rs_img_path;
		this.rs_selfintro = rs_selfintro;
		this.rs_title=rs_title;
		
	}
	
	public RsDto(int rs_no, int member_no, String rs_img_name, String rs_img_path, String rs_selfintro, String rs_title) {
		this.rs_no = rs_no;
		this.member_no = member_no;
		this.rs_img_name = rs_img_name;
		this.rs_img_path = rs_img_path;
		this.rs_selfintro = rs_selfintro;
		this.rs_title=rs_title;
	}
	public int getRs_no() {
		return rs_no;
	}
	public void setRs_no(int rs_no) {
		this.rs_no = rs_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getRs_img_name() {
		return rs_img_name;
	}
	public void setRs_img_name(String rs_img_name) {
		this.rs_img_name = rs_img_name;
	}
	public String getRs_img_path() {
		return rs_img_path;
	}
	public void setRs_img_path(String rs_img_path) {
		this.rs_img_path=rs_img_path;
	}
	public String getRs_selfintro() {
		return rs_selfintro;
	}
	public void setRs_selfintro(String rs_selfintro) {
		this.rs_selfintro=rs_selfintro;
	}
	
	public String getRs_title() {
		return rs_title;
	}
	
	public void setRs_title(String rs_title) {
		this.rs_title = rs_title;
	}
	

}
