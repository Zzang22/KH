package com.bb.dto;

public class ApplicantDto {

	private int member_no;
	private int jo_no;
	private String rs_title;
	private String jo_title;
	private int rs_no;

	public ApplicantDto() {

	}

	public String getRs_title() {
		return rs_title;
	}

	public void setRs_title(String rs_title) {
		this.rs_title = rs_title;
	}

	public String getJo_title() {
		return jo_title;
	}

	public void setJo_title(String jo_title) {
		this.jo_title = jo_title;
	}

	public int getRs_no() {
		return rs_no;
	}

	public void setRs_no(int rs_no) {
		this.rs_no = rs_no;
	}

	public ApplicantDto(int member_no, int jo_no) {
		this.member_no = member_no;
		this.jo_no = jo_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getJo_no() {
		return jo_no;
	}

	public void setJo_no(int jo_no) {
		this.jo_no = jo_no;
	}

}
