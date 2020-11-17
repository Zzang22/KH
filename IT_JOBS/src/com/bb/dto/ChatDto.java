package com.bb.dto;

public class ChatDto {
	
	private int chat_no;
	private int chat_room_no;
	private int member_no;
	private String member_id;
	private String chat_content;
	private String chat_regdate;
	
	public ChatDto() {
		
	}
	
	public ChatDto(int chat_room_no, int member_no, String member_id, String chat_content, String chat_regdate) {
		this.chat_room_no = chat_room_no;
		this.member_no = member_no;
		this.member_id = member_id;
		this.chat_content = chat_content;
		this.chat_regdate = chat_regdate;
	}

	public ChatDto(int chat_no, int member_no, int chat_room_no, String member_id, String chat_content, String chat_regdate) {
		super();
		this.chat_no = chat_no;
		this.member_no = member_no;
		this.chat_room_no = chat_room_no;
		this.member_id = member_id;
		this.chat_content = chat_content;
		this.chat_regdate = chat_regdate;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getChat_no() {
		return chat_no;
	}

	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}

	public int getChat_room_no() {
		return chat_room_no;
	}

	public void setChat_room_no(int chat_room_no) {
		this.chat_room_no = chat_room_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public String getChat_content() {
		return chat_content;
	}

	public void setChat_content(String chat_content) {
		this.chat_content = chat_content;
	}

	public String getChat_regdate() {
		return chat_regdate;
	}

	public void setChat_regdate(String chat_regdate) {
		this.chat_regdate = chat_regdate;
	}
	
	
}
