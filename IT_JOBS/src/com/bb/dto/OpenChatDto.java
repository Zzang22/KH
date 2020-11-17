package com.bb.dto;

public class OpenChatDto {
	
	private int member_no;
	private int chat_room_no;
	private String chat_room_name;
	private int count_member;
	private String last_date;
	
	public OpenChatDto() {
		
	}

	public OpenChatDto(int chat_room_no, String chat_room_name, int count_member, String last_date) {
		super();
		this.chat_room_no = chat_room_no;
		this.chat_room_name = chat_room_name;
		this.count_member = count_member;
		this.last_date = last_date;
	}
	
	public OpenChatDto(int member_no, int chat_room_no, String chat_room_name, int count_member, String last_date) {
		super();
		this.member_no = member_no;
		this.chat_room_no = chat_room_no;
		this.chat_room_name = chat_room_name;
		this.count_member = count_member;
		this.last_date = last_date;
	}

	public int getChat_room_no() {
		return chat_room_no;
	}

	public void setChat_room_no(int chat_room_no) {
		this.chat_room_no = chat_room_no;
	}

	public String getChat_room_name() {
		return chat_room_name;
	}

	public void setChat_room_name(String chat_room_name) {
		this.chat_room_name = chat_room_name;
	}

	public int getCount_member() {
		return count_member;
	}

	public void setCount_member(int count_member) {
		this.count_member = count_member;
	}

	public String getLast_date() {
		return last_date;
	}

	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	
	
	
}
