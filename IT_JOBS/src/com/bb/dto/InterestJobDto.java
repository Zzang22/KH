package com.bb.dto;

public class InterestJobDto {
	private int member_no;
	private int jo_no;
	
	public InterestJobDto() {
		
	}
	
	public InterestJobDto(int member_no, int jo_no) {
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
