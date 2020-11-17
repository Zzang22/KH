package com.bb.dto;

import java.util.Date;

public class Interest_JobDto {

	private int member_no;
	private int jo_no;
	
	private String member_id;//member_ table 꺼
	private String member_pw;
	private String member_name;
	private int member_birthday;
	private String member_postcode;
	private String member_addr;
	private String member_phone;
	private String member_email;
	private String member_enabled;
	private String member_role;//member_table꺼
	
	   private String corp_ceo_name;//joboffer table꺼
	   private String corp_board_name;
	   private int corp_countemp;
	   private String jo_title;
	   private String jo_content;
	   private int jo_field_no;
	   private int jo_career_no;
	   private int jo_salary;
	   private Date jo_deadline;
	   private int jo_hit;
	   private int field_no;
	   private String field_name;
	   private int career_no;
	   private String career_name;
	
	public Interest_JobDto() {
		
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

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getMember_birthday() {
		return member_birthday;
	}

	public void setMember_birthday(int member_birthday) {
		this.member_birthday = member_birthday;
	}

	public String getMember_postcode() {
		return member_postcode;
	}

	public void setMember_postcode(String member_postcode) {
		this.member_postcode = member_postcode;
	}

	public String getMember_addr() {
		return member_addr;
	}

	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_enabled() {
		return member_enabled;
	}

	public void setMember_enabled(String member_enabled) {
		this.member_enabled = member_enabled;
	}

	public String getMember_role() {
		return member_role;
	}

	public void setMember_role(String member_role) {
		this.member_role = member_role;
	}

	public String getCorp_ceo_name() {
		return corp_ceo_name;
	}

	public void setCorp_ceo_name(String corp_ceo_name) {
		this.corp_ceo_name = corp_ceo_name;
	}

	public String getCorp_board_name() {
		return corp_board_name;
	}

	public void setCorp_board_name(String corp_board_name) {
		this.corp_board_name = corp_board_name;
	}

	public int getCorp_countemp() {
		return corp_countemp;
	}

	public void setCorp_countemp(int corp_countemp) {
		this.corp_countemp = corp_countemp;
	}

	public String getJo_title() {
		return jo_title;
	}

	public void setJo_title(String jo_title) {
		this.jo_title = jo_title;
	}

	public String getJo_content() {
		return jo_content;
	}

	public void setJo_content(String jo_content) {
		this.jo_content = jo_content;
	}

	public int getJo_field_no() {
		return jo_field_no;
	}

	public void setJo_field_no(int jo_field_no) {
		this.jo_field_no = jo_field_no;
	}

	public int getJo_career_no() {
		return jo_career_no;
	}

	public void setJo_career_no(int jo_career_no) {
		this.jo_career_no = jo_career_no;
	}

	public int getJo_salary() {
		return jo_salary;
	}

	public void setJo_salary(int jo_salary) {
		this.jo_salary = jo_salary;
	}

	public Date getJo_deadline() {
		return jo_deadline;
	}

	public void setJo_deadline(Date jo_deadline) {
		this.jo_deadline = jo_deadline;
	}

	public int getJo_hit() {
		return jo_hit;
	}

	public void setJo_hit(int jo_hit) {
		this.jo_hit = jo_hit;
	}

	public int getField_no() {
		return field_no;
	}

	public void setField_no(int field_no) {
		this.field_no = field_no;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public int getCareer_no() {
		return career_no;
	}

	public void setCareer_no(int career_no) {
		this.career_no = career_no;
	}

	public String getCareer_name() {
		return career_name;
	}

	public void setCareer_name(String career_name) {
		this.career_name = career_name;
	}

	
}
