package com.bb.model.biz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bb.dto.ChatDto;
import com.bb.dto.ChatRoomDto;
import com.bb.dto.ChatUserDto;
import com.bb.dto.OpenChatDto;
import com.bb.model.dao.ChatDao;

public class ChatBiz {
	private ChatDao dao = new ChatDao();
	public static final int SEC = 60;
	public static final int MIN = 60;
	public static final int HOUR = 24;
	public static final int DAY = 30;
	public static final int MONTH = 12;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	
	public List<ChatRoomDto> selectMyChatList(int member_no) {
		// regdate -> HHmi
		List<ChatRoomDto> list = dao.selectMyChatList(member_no);

		for (ChatRoomDto dto : list) {
			String date = dto.getChat_regdate();
			try {
				String tempDate = formatTimeString(format.parse(date));
				dto.setChat_regdate(tempDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public List<ChatDto> selectChatContentList(ChatUserDto userDto) {
		List<ChatDto> list = dao.selectChatContentList(userDto);

		for (ChatDto dto : list) {
			String HHmi = dto.getChat_regdate().substring(11, 16);
			dto.setChat_regdate(HHmi);
		}

		return list;
	}

	public int insertRoom(OpenChatDto dto) {

		return dao.insertRoom(dto);
	}

	public List<OpenChatDto> selectOpenChatList(int member_no) {
		List<OpenChatDto> list = dao.selectOpenChatList(member_no);

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getLast_date() != null) {
				String date = list.get(i).getLast_date();
				try {
					String tempDate = formatTimeString(format.parse(date));
					list.get(i).setLast_date(tempDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

	public int selectUserCount(int chat_room_no) {
		return dao.selectUserCount(chat_room_no);
	}

	public int selectPrevChk(ChatUserDto dto) {
		return dao.selectPrevChk(dto);
	}

	public int insertOpenChatUser(ChatUserDto dto) {
		return dao.insertOpenChatUser(dto);
	}

	public int selectLastChat(int chat_room_no) {
		return dao.selectLastChat(chat_room_no);
	}

	public int insertChat(List<ChatDto> list) {

		return dao.insertChat(list);
	}

	public int updateLastChat(ChatUserDto dto) {
		return dao.updateLastChat(dto);
	}

	public int updateLastChatData(ChatUserDto dto) {
		return dao.updateLastChatData(dto);
	}

	public int deleteUser(ChatUserDto dto) {
		int res = dao.deleteUser(dto);

		int chat_room_no = dto.getChat_room_no();
		if (dao.selectUserCount(chat_room_no) == 0) {
			dao.deleteChatRoom(chat_room_no);
		}
		return res;
	}

	public static String formatTimeString(Date tempDate) {

		long curTime = System.currentTimeMillis();
		long regTime = tempDate.getTime();
		long diffTime = (curTime - regTime) / 1000;

		String msg = null;

		if (diffTime < SEC) {
			msg = "방금 전";

		} else if ((diffTime /= SEC) < MIN) {
			msg = diffTime + "분 전";

		} else if ((diffTime /= MIN) < HOUR) {
			msg = (diffTime) + "시간 전";

		} else if ((diffTime /= HOUR) < DAY) {
			msg = (diffTime) + "일 전";

		} else if ((diffTime /= DAY) < MONTH) {
			msg = (diffTime) + "달 전";

		} else {
			msg = (diffTime) + "년 전";
		}

		return msg;
	}

}
