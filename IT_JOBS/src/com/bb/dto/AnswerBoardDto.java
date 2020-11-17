package com.bb.dto;

import java.util.Date;

public class AnswerBoardDto {
	
	private int answer_no;
	private int userboard_no;
	private int member_no;
	private int answer_groupno;
	private int answer_groupseq;
	private int answer_titletab;
	private String answer_content;
	private Date answer_regdate;
	private String answer_delflag;
	private String member_id;
	
	public AnswerBoardDto() {
		
	}
	
	
	public AnswerBoardDto(int answer_no, int userboard_no, int member_no, int answer_groupno, int answer_groupseq,
			int answer_titletab, String answer_content, Date answer_regdate, String answer_delflag, String member_id) {
		super();
		this.answer_no = answer_no;
		this.userboard_no = userboard_no;
		this.member_no = member_no;
		this.answer_groupno = answer_groupno;
		this.answer_groupseq = answer_groupseq;
		this.answer_titletab = answer_titletab;
		this.answer_content = answer_content;
		this.answer_regdate = answer_regdate;
		this.answer_delflag = answer_delflag;
		this.member_id= member_id;
	}
	public int getAnswer_no() {
		return answer_no;
	}
	public void setAnswer_no(int answer_no) {
		this.answer_no = answer_no;
	}
	public int getUserboard_no() {
		return userboard_no;
	}
	public void setUserboard_no(int userboard_no) {
		this.userboard_no = userboard_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getAnswer_groupno() {
		return answer_groupno;
	}
	public void setAnswer_groupno(int answer_groupno) {
		this.answer_groupno = answer_groupno;
	}
	public int getAnswer_groupseq() {
		return answer_groupseq;
	}
	public void setAnswer_groupseq(int answer_groupseq) {
		this.answer_groupseq = answer_groupseq;
	}
	public int getAnswer_titletab() {
		return answer_titletab;
	}
	public void setAnswer_titletab(int answer_titletab) {
		this.answer_titletab = answer_titletab;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public Date getAnswer_regdate() {
		return answer_regdate;
	}
	public void setAnswer_regdate(Date answer_regdate) {
		this.answer_regdate = answer_regdate;
	}
	public String getAnswer_delflag() {
		return answer_delflag;
	}
	public void setAnswer_delflag(String answer_delflag) {
		this.answer_delflag = answer_delflag;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	

	
}
