package com.bb.dto;

public class ChatRoomDto {
	
	private int chat_room_no;
	private String chat_room_name;
	private int member_no;
	private String member_id;
	private String chat_content;
	private String chat_regdate;
	private int chat_count;
	
	public ChatRoomDto() {
		
	}

	public ChatRoomDto(int chat_room_no, String chat_room_name) {
		this.chat_room_no = chat_room_no;
		this.chat_room_name = chat_room_name;
	}

	
	public ChatRoomDto(int chat_room_no, String chat_room_name, String member_id, String chat_content, String chat_regdate,
			int chat_count) {
		super();
		this.chat_room_no = chat_room_no;
		this.chat_room_name = chat_room_name;
		this.member_id = member_id;
		this.chat_content = chat_content;
		this.chat_regdate = chat_regdate;
		this.chat_count = chat_count;
	}

	
	public ChatRoomDto(int chat_room_no, String chat_room_name, int member_no, String member_id, String chat_content,
			String chat_regdate, int chat_count) {
		super();
		this.chat_room_no = chat_room_no;
		this.chat_room_name = chat_room_name;
		this.member_no = member_no;
		this.member_id = member_id;
		this.chat_content = chat_content;
		this.chat_regdate = chat_regdate;
		this.chat_count = chat_count;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
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

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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

	public int getChat_count() {
		return chat_count;
	}

	public void setChat_count(int chat_count) {
		this.chat_count = chat_count;
	}
	
	
}
