package com.bb.dto;

public class CorporationDto {
	//-- 아이디, 패스워드, 이름(회사명), 우편번호, 회사주소(주소)
	//대표자명, 담당자 연락처, 담당자 이메일
	/*table member
	 * 	MEMBER_NO NUMBER NOT NULL,
	MEMBER_ID VARCHAR2(20) NOT NULL,
	MEMBER_PW VARCHAR2(20) NOT NULL,
	MEMBER_NAME VARCHAR2(20) NOT NULL,
	MEMBER_POSTCODE NUMBER,
	MEMBER_ADDR VARCHAR2(500),
	MEMBER_PHONE VARCHAR2(20),
	MEMBER_EMAIL VARCHAR2(50) NOT NULL,
	MEMBER_ENABLED VARCHAR2(2) NOT NULL,
	MEMBER_ROLE VARCHAR2(10) NOT NULL,
	
	
	CREATE TABLE CORPORATION(
	MEMBER_NO NUMBER NOT NULL,
	CORP_BUSINESSNO NUMBER,
	CORP_CEO_NAME VARCHAR2(20),
	CORP_BOARD_NAME VARCHAR2(20),
	CORP_BOARD_PHONE VARCHAR2(20),
	CORP_MEMBERSHIP VARCHAR2(50),
	
	CONSTRAINT CORP_FK_MEMBER_NO FOREIGN KEY(MEMBER_NO)
	REFERENCES MEMBER(MEMBER_NO) ON DELETE CASCADE,
	CONSTRAINT CORP_UQ_BUSINESSNO UNIQUE(CORP_BUSINESSNO)
);
	
	 */
	
	private int member_no;	//멤버번호
	private String member_id;		//아이디
	private String member_pw;		//패스워드
	private String member_name;	//회사명
	private String corp_ceo_name;	//대표자명
	private String corp_board_name;	//담당자명
	private int corp_businessno;	//사업자번호
	private String member_postcode;	//우편번호
	private String member_addr;		//회사주소
	private String member_phone;		//회사연락처
	private String member_email;		//담당자이메일
	private String member_enabled;	//가입여부
	private String member_role;		//기업
	private String corp_countemp;
	private String corp_membership;

	
	public CorporationDto() {
		
	}
	//--Member : member_no, id, pw, name, postcode, addr, phone, email, enabled, role
	//-- corp : corp_businessno, corp_ceo_name, corp_board_name,
	
	//회원가입01
	public CorporationDto(int member_no, String member_id, String member_pw, String member_name, String member_postcode, String member_addr,
			String member_phone, String member_email, String member_enabled, String member_role) {
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_postcode = member_postcode;
		this.member_addr = member_addr;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.member_enabled = member_enabled;
		this.member_role = member_role;
	}
	
	//회원가입02 - 기업정보입력 
	public CorporationDto(String member_id, int corp_businessno, String corp_ceo_name, String corp_board_name,String corp_countemp) {
		this.member_id = member_id;
		this.corp_businessno = corp_businessno;
		this.corp_ceo_name = corp_ceo_name;
		this.corp_board_name = corp_board_name;
		this.corp_countemp = corp_countemp;
	}
	
	//MEMBER_ID, MEMBER_PW, MEMBER_NAME, CORP_CEO_NAME, CORP_BOARD_NAME,
  	//CORP_BUSINESSNO, MEMBER_POSTCODE, MEMBER_ADDR, MEMBER_PHONE, MEMBER_EMAIL
	//기업정보 조회 
	public CorporationDto(String member_id, String member_pw, String member_name, String corp_ceo_name, String corp_board_name,
			int corp_businessno, String member_postcode, String member_addr, String member_phone, String member_email) {
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.corp_ceo_name = corp_ceo_name;
		this.corp_board_name = corp_board_name;
		this.corp_businessno = corp_businessno;
		this.member_postcode = member_postcode;
		this.member_addr = member_addr;
		this.member_phone = member_phone;
		this.member_email = member_email;
		
	}
	
	//기업정보수정
	public CorporationDto(String member_id, String member_pw, String member_name, String corp_ceo_name, String corp_board_name, 
			String member_postcode, String member_addr, String member_phone,String member_email) {
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.corp_ceo_name = corp_ceo_name;
		this.corp_board_name = corp_board_name;
		this.member_postcode = member_postcode;
		this.member_addr = member_addr;
		this.member_phone = member_phone;
		this.member_email = member_email;
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

	
	
	
}
