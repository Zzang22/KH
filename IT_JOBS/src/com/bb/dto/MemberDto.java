package com.bb.dto;

public class MemberDto {
	
	private int member_no;
	private String member_id;
	private String member_pw;
	private String member_name;
	private int member_birthday;
	private String member_postcode;
	private String member_addr;
	private String member_phone;
	private String member_email;
	private String member_enabled;
	private String member_role;

	public MemberDto() {
		
	}
	
	
	public MemberDto(String member_id, String member_pw, String member_name, int member_birthday, String member_postcode, String member_addr, String member_phone, String member_email) {
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_birthday = member_birthday;
		this.member_postcode = member_postcode;
		this.member_addr = member_addr;
		this.member_phone = member_phone;
		this.member_email = member_email;
		
	}
	
	public MemberDto(int member_no, String member_id, String member_pw, String member_name, int member_birthday,
			String member_postcode, String member_addr, String member_phone, String member_email, String member_enabled,
			String member_role) {
		
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_birthday = member_birthday;
		this.member_postcode = member_postcode;
		this.member_addr = member_addr;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.member_enabled = member_enabled;
		this.member_role = member_role;
	}

	public MemberDto(String member_id, String member_email, String member_name) {
		this.member_id = member_id;
		this.member_email = member_email;
		this.member_name = member_name;
	}
	//login
	public MemberDto(String member_id, String member_pw) {
		this.member_id = member_id;
		this.member_pw = member_pw;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
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

	@Override
	public String toString() {
		return "MemberDto [member_no=" + member_no + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_name=" + member_name + ", member_birthday=" + member_birthday + ", member_postcode="
				+ member_postcode + ", member_addr=" + member_addr + ", member_phone=" + member_phone
				+ ", member_email=" + member_email + ", member_enabled=" + member_enabled + ", member_role="
				+ member_role + "]";
	}
	
}
