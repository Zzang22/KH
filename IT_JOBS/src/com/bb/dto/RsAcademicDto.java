package com.bb.dto;

public class RsAcademicDto {

	private int rs_ac_no;
	private int rs_no;
	private String rs_ac_name;
	private String rs_ac_dept;
	private String rs_ac_grad;
	private int rs_ac_start_year;
	private int rs_ac_start_month;
	private int rs_ac_end_year;
	private int rs_ac_end_month;

	public RsAcademicDto() {

	}
	
	public RsAcademicDto(String rs_ac_name, String rs_ac_dept, String rs_ac_grad,
			int rs_ac_start_year, int rs_ac_start_month, int rs_ac_end_year, int rs_ac_end_month) {
		
		this.rs_ac_name = rs_ac_name;
		this.rs_ac_dept = rs_ac_dept;
		this.rs_ac_grad = rs_ac_grad;
		this.rs_ac_start_year = rs_ac_start_year;
		this.rs_ac_start_month = rs_ac_start_month;
		this.rs_ac_end_year = rs_ac_end_year;
		this.rs_ac_end_month = rs_ac_end_month;
	}
	
	public RsAcademicDto(int rs_no, String rs_ac_name, String rs_ac_dept, String rs_ac_grad, int rs_ac_start_year,
			int rs_ac_start_month, int rs_ac_end_year, int rs_ac_end_month) {
		this.rs_no = rs_no;
		this.rs_ac_name = rs_ac_name;
		this.rs_ac_dept = rs_ac_dept;
		this.rs_ac_grad = rs_ac_grad;
		this.rs_ac_start_year = rs_ac_start_year;
		this.rs_ac_start_month = rs_ac_start_month;
		this.rs_ac_end_year = rs_ac_end_year;
		this.rs_ac_end_month = rs_ac_end_month;
	}

	public RsAcademicDto(int rs_ac_no, int rs_no, String rs_ac_name, String rs_ac_dept, String rs_ac_grad,
			int rs_ac_start_year, int rs_ac_start_month, int rs_ac_end_year, int rs_ac_end_month) {
		this.rs_ac_no = rs_ac_no;
		this.rs_no = rs_no;
		this.rs_ac_name = rs_ac_name;
		this.rs_ac_dept = rs_ac_dept;
		this.rs_ac_grad = rs_ac_grad;
		this.rs_ac_start_year = rs_ac_start_year;
		this.rs_ac_start_month = rs_ac_start_month;
		this.rs_ac_end_year = rs_ac_end_year;
		this.rs_ac_end_month = rs_ac_end_month;
	}

	public int getRs_ac_no() {
		return rs_ac_no;
	}

	public void setRs_ac_no(int rs_ac_no) {
		this.rs_ac_no = rs_ac_no;
	}

	public int getRs_no() {
		return rs_no;
	}

	public void setRs_no(int rs_no) {
		this.rs_no = rs_no;
	}

	public String getRs_ac_name() {
		return rs_ac_name;
	}

	public void setRs_ac_name(String rs_ac_name) {
		this.rs_ac_name = rs_ac_name;
	}

	public String getRs_ac_dept() {
		return rs_ac_dept;
	}

	public void setRs_ac_dept(String rs_ac_dept) {
		this.rs_ac_dept = rs_ac_dept;
	}

	public String getRs_ac_grad() {
		return rs_ac_grad;
	}

	public void setRs_ac_grad(String rs_ac_grad) {
		this.rs_ac_grad = rs_ac_grad;
	}

	public int getRs_ac_start_year() {
		return rs_ac_start_year;
	}

	public void setRs_ac_start_year(int rs_ac_start_year) {
		this.rs_ac_start_year = rs_ac_start_year;
	}

	public int getRs_ac_start_month() {
		return rs_ac_start_month;
	}

	public void setRs_ac_start_month(int rs_ac_start_month) {
		this.rs_ac_start_month = rs_ac_start_month;
	}

	public int getRs_ac_end_year() {
		return rs_ac_end_year;
	}

	public void setRs_ac_end_year(int rs_ac_end_year) {
		this.rs_ac_end_year = rs_ac_end_year;
	}

	public int getRs_ac_end_month() {
		return rs_ac_end_month;
	}

	public void setRs_ac_end_month(int rs_ac_end_month) {
		this.rs_ac_end_month = rs_ac_end_month;
	}

	@Override
	public String toString() {
		return "RsAcademicDto [rs_ac_no=" + rs_ac_no + ", rs_no=" + rs_no + ", rs_ac_name=" + rs_ac_name
				+ ", rs_ac_dept=" + rs_ac_dept + ", rs_ac_grad=" + rs_ac_grad + ", rs_ac_start_year=" + rs_ac_start_year
				+ ", rs_ac_start_month=" + rs_ac_start_month + ", rs_ac_end_year=" + rs_ac_end_year
				+ ", rs_ac_end_month=" + rs_ac_end_month + "]";
	}
	
	

}