package com.bb.dto;

public class RsCareerDto {

	private int rs_cr_no;
	private int rs_no;
	private String rs_cr_name;
	private String rs_cr_duty;
	private String rs_cr_dept;
	private int rs_cr_start_year;
	private int rs_cr_start_month;
	private int rs_cr_end_year;
	private int rs_cr_end_month;
	
	
	public RsCareerDto() {
		
	}
	
	public RsCareerDto(String rs_cr_name, String rs_cr_duty, String rs_cr_dept, int rs_cr_start_year,
			int rs_cr_start_month, int rs_cr_end_year, int rs_cr_end_month) {
		this.rs_cr_name = rs_cr_name;
		this.rs_cr_duty = rs_cr_duty;
		this.rs_cr_dept = rs_cr_dept;
		this.rs_cr_start_year = rs_cr_start_year;
		this.rs_cr_start_month = rs_cr_start_month;
		this.rs_cr_end_year = rs_cr_end_year;
		this.rs_cr_end_month = rs_cr_end_month;
	}

	public RsCareerDto(int rs_no, String rs_cr_name, String rs_cr_duty, String rs_cr_dept, int rs_cr_start_year,
			int rs_cr_start_month, int rs_cr_end_year, int rs_cr_end_month) {
		this.rs_no = rs_no;
		this.rs_cr_name = rs_cr_name;
		this.rs_cr_duty = rs_cr_duty;
		this.rs_cr_dept = rs_cr_dept;
		this.rs_cr_start_year = rs_cr_start_year;
		this.rs_cr_start_month = rs_cr_start_month;
		this.rs_cr_end_year = rs_cr_end_year;
		this.rs_cr_end_month = rs_cr_end_month;
	}

	public RsCareerDto(int rs_cr_no, int rs_no, String rs_cr_name, String rs_cr_duty, String rs_cr_dept,
			int rs_cr_start_year, int rs_cr_start_month, int rs_cr_end_year, int rs_cr_end_month) {
		this.rs_cr_no = rs_cr_no;
		this.rs_no = rs_no;
		this.rs_cr_name = rs_cr_name;
		this.rs_cr_duty = rs_cr_duty;
		this.rs_cr_dept = rs_cr_dept;
		this.rs_cr_start_year = rs_cr_start_year;
		this.rs_cr_start_month = rs_cr_start_month;
		this.rs_cr_end_year = rs_cr_end_year;
		this.rs_cr_end_month = rs_cr_end_month;
	}

	public int getRs_cr_no() {
		return rs_cr_no;
	}

	public void setRs_cr_no(int rs_cr_no) {
		this.rs_cr_no = rs_cr_no;
	}

	public int getRs_no() {
		return rs_no;
	}

	public void setRs_no(int rs_no) {
		this.rs_no = rs_no;
	}

	public String getRs_cr_name() {
		return rs_cr_name;
	}

	public void setRs_cr_name(String rs_cr_name) {
		this.rs_cr_name = rs_cr_name;
	}

	public String getRs_cr_duty() {
		return rs_cr_duty;
	}

	public void setRs_cr_duty(String rs_cr_duty) {
		this.rs_cr_duty = rs_cr_duty;
	}

	public String getRs_cr_dept() {
		return rs_cr_dept;
	}

	public void setRs_cr_dept(String rs_cr_dept) {
		this.rs_cr_dept = rs_cr_dept;
	}

	public int getRs_cr_start_year() {
		return rs_cr_start_year;
	}

	public void setRs_cr_start_year(int rs_cr_start_year) {
		this.rs_cr_start_year = rs_cr_start_year;
	}

	public int getRs_cr_start_month() {
		return rs_cr_start_month;
	}

	public void setRs_cr_start_month(int rs_cr_start_month) {
		this.rs_cr_start_month = rs_cr_start_month;
	}

	public int getRs_cr_end_year() {
		return rs_cr_end_year;
	}

	public void setRs_cr_end_year(int rs_cr_end_year) {
		this.rs_cr_end_year = rs_cr_end_year;
	}

	public int getRs_cr_end_month() {
		return rs_cr_end_month;
	}

	public void setRs_cr_end_month(int rs_cr_end_month) {
		this.rs_cr_end_month = rs_cr_end_month;
	}
	

}