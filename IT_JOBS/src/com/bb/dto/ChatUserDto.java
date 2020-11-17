package com.bb.dto;

public class ChatUserDto {
	
	private int chat_room_no;
	private int member_no;
	private int first_chat_no;
	private int last_chat_no;
	
	public ChatUserDto() {
		
	}
	
	public ChatUserDto(int chat_room_no, int member_no) {
		super();
		this.chat_room_no = chat_room_no;
		this.member_no = member_no;
	}

	public ChatUserDto(int chat_room_no, int member_no, int last_chat_no) {
		super();
		this.chat_room_no = chat_room_no;
		this.member_no = member_no;
		this.last_chat_no = last_chat_no;
	}

	public ChatUserDto(int chat_room_no, int member_no, int first_chat_no, int last_chat_no) {
		super();
		this.chat_room_no = chat_room_no;
		this.member_no = member_no;
		this.first_chat_no = first_chat_no;
		this.last_chat_no = last_chat_no;
	}
	
	public int getChat_room_no() {
		return chat_room_no;
	}


	public void setChat_room_no(int chat_room_no) {
		this.chat_room_no = chat_room_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getFirst_chat_no() {
		return first_chat_no;
	}

	public void setFirst_chat_no(int first_chat_no) {
		this.first_chat_no = first_chat_no;
	}

	public int getLast_chat_no() {
		return last_chat_no;
	}

	public void setLast_chat_no(int last_chat_no) {
		this.last_chat_no = last_chat_no;
	}
	
	

}
