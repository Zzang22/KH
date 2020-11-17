package com.bb.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JobOfferDivisionListDto {

	private int member_no;
	private String member_name;
	private String member_addr;
	private String member_phone;
	private String member_email;
	private String corp_ceo_name;
	private String corp_board_name;
	private int corp_countemp;
	private int jo_no;
	private String jo_title;
	private String jo_content;
	private int jo_field_no;
	private int jo_career_no;
	private int jo_salary;
	private Date jo_deadline;
	private int jo_hit;
	private String jo_field_name;
	private String jo_career_name;

	private int field1;
	private int field2;
	private int field3;
	private int field4;
	private int field5;
	private int field6;
	private int field7;
	private int field8;
	private int field9;
	private int field10;
	private int field11;
	private int field12;
	private int career;
	private int min_salary;
	private int max_salary;

	public JobOfferDivisionListDto() {

	}

	public JobOfferDivisionListDto(int member_no, String member_name, String member_addr, String member_phone, String member_email,
			String corp_ceo_name, String corp_board_name, int corp_countemp, int jo_no, String jo_title,
			String jo_content, int jo_field_no, int jo_career_no, int jo_salary, Date jo_deadline, int jo_hit,
			int field_no, String field_name, int career_no, String career_name, int field1, int field2, int field3,
			int field4, int field5, int field6, int field7, int field8, int field9, int field10, int field11,
			int field12, int career, int min_salary, int max_salary) {
		this.member_no = member_no;
		this.member_name = member_name;
		this.member_addr = member_addr;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.corp_ceo_name = corp_ceo_name;
		this.corp_board_name = corp_board_name;
		this.corp_countemp = corp_countemp;
		this.jo_no = jo_no;
		this.jo_title = jo_title;
		this.jo_content = jo_content;
		this.jo_field_no = jo_field_no;
		this.jo_career_no = jo_career_no;
		this.jo_salary = jo_salary;
		this.jo_deadline = jo_deadline;
		this.jo_hit = jo_hit;
		this.jo_field_name = field_name;
		this.jo_career_name = career_name;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.field6 = field6;
		this.field7 = field7;
		this.field8 = field8;
		this.field9 = field9;
		this.field10 = field10;
		this.field11 = field11;
		this.field12 = field12;
		this.career = career;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
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

	public int getJo_no() {
		return jo_no;
	}

	public void setJo_no(int jo_no) {
		this.jo_no = jo_no;
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

	public String getJo_deadline() {

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String dd = sdf.format(jo_deadline);

		return dd;
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


	public String getJo_field_name() {
		return jo_field_name;
	}

	public void setJo_field_name(String jo_field_name) {
		this.jo_field_name = jo_field_name;
	}


	public String getJo_career_name() {
		return jo_career_name;
	}

	public void setCareer_name(String jo_career_name) {
		this.jo_career_name = jo_career_name;
	}

	public int getField1() {
		return field1;
	}

	public void setField1(int field1) {
		this.field1 = field1;
	}

	public int getField2() {
		return field2;
	}

	public void setField2(int field2) {
		this.field2 = field2;
	}

	public int getField3() {
		return field3;
	}

	public void setField3(int field3) {
		this.field3 = field3;
	}

	public int getField4() {
		return field4;
	}

	public void setField4(int field4) {
		this.field4 = field4;
	}

	public int getField5() {
		return field5;
	}

	public void setField5(int field5) {
		this.field5 = field5;
	}

	public int getField6() {
		return field6;
	}

	public void setField6(int field6) {
		this.field6 = field6;
	}

	public int getField7() {
		return field7;
	}

	public void setField7(int field7) {
		this.field7 = field7;
	}

	public int getField8() {
		return field8;
	}

	public void setField8(int field8) {
		this.field8 = field8;
	}

	public int getField9() {
		return field9;
	}

	public void setField9(int field9) {
		this.field9 = field9;
	}

	public int getField10() {
		return field10;
	}

	public void setField10(int field10) {
		this.field10 = field10;
	}

	public int getField11() {
		return field11;
	}

	public void setField11(int field11) {
		this.field11 = field11;
	}

	public int getField12() {
		return field12;
	}

	public void setField12(int field12) {
		this.field12 = field12;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	public int getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}

	public int getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}

	@Override
	public String toString() {
		return "JobOfferDivisionListDto [member_no=" + member_no + ", member_name=" + member_name + ", member_addr=" + member_addr
				+ ", member_phone=" + member_phone + ", member_email=" + member_email + ", corp_ceo_name="
				+ corp_ceo_name + ", corp_board_name=" + corp_board_name + ", corp_countemp=" + corp_countemp
				+ ", jo_no=" + jo_no + ", jo_title=" + jo_title + ", jo_content=" + jo_content + ", jo_field_no="
				+ jo_field_no + ", jo_career_no=" + jo_career_no + ", jo_salary=" + jo_salary + ", jo_deadline="
				+ jo_deadline + ", jo_hit=" + jo_hit + ", jo_field_name=" + jo_field_name + ", jo_career_name="
				+ jo_career_name + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + ", field4="
				+ field4 + ", field5=" + field5 + ", field6=" + field6 + ", field7=" + field7 + ", field8=" + field8
				+ ", field9=" + field9 + ", field10=" + field10 + ", field11=" + field11 + ", field12=" + field12
				+ ", career=" + career + ", min_salary=" + min_salary + ", max_salary=" + max_salary + "]";
	}

}