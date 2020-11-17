package com.bb.dto;

public class MemberDto_ForCorp {
	
	private int member_no;
	private String member_id;
	private String member_pw;
	private String member_name;
	private int member_birthday;
	private int member_postcode;
	private String member_addr;
	private String member_phone;
	private String member_email;
	private String member_enabled;
	private String member_role;
	//기업테이블
	private String corp_countemp;
	private String corp_membership;
	private String corp_ceo_name;	//대표자명
	private String corp_board_name;	//담당자명
	private int corp_businessno;	
	



	public MemberDto_ForCorp() {
		
	}
	
	public MemberDto_ForCorp(int member_no, String member_id, String member_pw, String member_name, int member_birthday,
			int member_postcode, String member_addr, String member_phone, String member_email, String member_enabled,
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

	//login
	public MemberDto_ForCorp(String member_id, String member_pw) {
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

	public int getMember_postcode() {
		return member_postcode;
	}

	public void setMember_postcode(int member_postcode) {
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

	public String getCorp_countemp() {
		return corp_countemp;
	}

	public void setCorp_countemp(String corp_countemp) {
		this.corp_countemp = corp_countemp;
	}

	public String getCorp_membership() {
		return corp_membership;
	}

	public void setCorp_membership(String corp_membership) {
		this.corp_membership = corp_membership;
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

	public int getCorp_businessno() {
		return corp_businessno;
	}

	public void setCorp_businessno(int corp_businessno) {
		this.corp_businessno = corp_businessno;
	}
	
	
}
