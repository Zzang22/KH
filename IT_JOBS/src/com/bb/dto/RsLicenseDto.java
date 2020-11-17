package com.bb.dto;

public class RsLicenseDto {
	
	private int rs_lc_no;
	private int rs_no;
	private String rs_lc_name;
	private String rs_lc_inst;
	private String rs_lc_date;
	private String rs_lc_date_year;
	private String rs_lc_date_month;
	private String rs_lc_date_day;
	

	public RsLicenseDto() {
		
	}
	
	public RsLicenseDto(int rs_no, String rs_lc_name, String rs_lc_inst, String rs_lc_date) {
		this.rs_no = rs_no;
		this.rs_lc_name = rs_lc_name;
		this.rs_lc_inst = rs_lc_inst;
		this.rs_lc_date = rs_lc_date;
	}
	
	public RsLicenseDto(int rs_lc_no, int rs_no, String rs_lc_name, String rs_lc_inst, String rs_lc_date) {
		this.rs_lc_no = rs_lc_no;
		this.rs_no = rs_no;
		this.rs_lc_name = rs_lc_name;
		this.rs_lc_inst = rs_lc_inst;
		this.rs_lc_date = rs_lc_date;
	}

	public RsLicenseDto(String rs_lc_name, String rs_lc_inst, String rs_lc_date, String rs_lc_date_year,
			String rs_lc_date_month, String rs_lc_date_day) {
		this.rs_lc_name = rs_lc_name;
		this.rs_lc_inst = rs_lc_inst;
		this.rs_lc_date = rs_lc_date;
		this.rs_lc_date_year = rs_lc_date_year;
		this.rs_lc_date_month = rs_lc_date_month;
		this.rs_lc_date_day = rs_lc_date_day;
	}

	public RsLicenseDto(int rs_no, String rs_lc_name, String rs_lc_inst, String rs_lc_date, String rs_lc_date_year,
			String rs_lc_date_month, String rs_lc_date_day) {
		this.rs_no = rs_no;
		this.rs_lc_name = rs_lc_name;
		this.rs_lc_inst = rs_lc_inst;
		this.rs_lc_date = rs_lc_date;
		this.rs_lc_date_year = rs_lc_date_year;
		this.rs_lc_date_month = rs_lc_date_month;
		this.rs_lc_date_day = rs_lc_date_day;
	}

	public RsLicenseDto(int rs_lc_no, int rs_no, String rs_lc_name, String rs_lc_inst, String rs_lc_date,
			String rs_lc_date_year, String rs_lc_date_month, String rs_lc_date_day) {
		this.rs_lc_no = rs_lc_no;
		this.rs_no = rs_no;
		this.rs_lc_name = rs_lc_name;
		this.rs_lc_inst = rs_lc_inst;
		this.rs_lc_date = rs_lc_date;
		this.rs_lc_date_year = rs_lc_date_year;
		this.rs_lc_date_month = rs_lc_date_month;
		this.rs_lc_date_day = rs_lc_date_day;
	}

	public String getRs_lc_date_year() {
		return rs_lc_date_year;
	}

	public void setRs_lc_date_year(String rs_lc_date_year) {
		this.rs_lc_date_year = rs_lc_date_year;
	}

	public String getRs_lc_date_month() {
		return rs_lc_date_month;
	}

	public void setRs_lc_date_month(String rs_lc_date_month) {
		this.rs_lc_date_month = rs_lc_date_month;
	}

	public String getRs_lc_date_day() {
		return rs_lc_date_day;
	}

	public void setRs_lc_date_day(String rs_lc_date_day) {
		this.rs_lc_date_day = rs_lc_date_day;
	}

	public int getRs_lc_no() {
		return rs_lc_no;
	}

	public void setRs_lc_no(int rs_lc_no) {
		this.rs_lc_no = rs_lc_no;
	}

	public int getRs_no() {
		return rs_no;
	}

	public void setRs_no(int rs_no) {
		this.rs_no = rs_no;
	}

	public String getRs_lc_name() {
		return rs_lc_name;
	}

	public void setRs_lc_name(String rs_lc_name) {
		this.rs_lc_name = rs_lc_name;
	}

	public String getRs_lc_inst() {
		return rs_lc_inst;
	}

	public void setRs_lc_inst(String rs_lc_inst) {
		this.rs_lc_inst = rs_lc_inst;
	}

	public String getRs_lc_date() {
		return rs_lc_date;
	}

	public void setRs_lc_date(String rs_lc_date) {
		this.rs_lc_date = rs_lc_date;
	}
	
	
	
	


}
