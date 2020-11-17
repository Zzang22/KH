package com.bb.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.ChatDto;
import com.bb.dto.ChatRoomDto;
import com.bb.dto.ChatUserDto;
import com.bb.dto.OpenChatDto;

public class ChatDao extends SqlMapConfig {

	private String namespace = "chatMapper.";

	public List<ChatRoomDto> selectMyChatList(int member_no) {

		SqlSession session = null;
		List<ChatRoomDto> list = new ArrayList<ChatRoomDto>();

		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace + "selectMyChatList", member_no);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public List<ChatDto> selectChatContentList(ChatUserDto dto) {

		SqlSession session = null;
		List<ChatDto> list = new ArrayList<ChatDto>();

		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace + "selectChatContentList", dto);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public List<OpenChatDto> selectOpenChatList(int member_no) {
		SqlSession session = null;
		List<OpenChatDto> list = new ArrayList<OpenChatDto>();

		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace + "selectOpenChatList", member_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public int selectLastChat(int chat_room_no) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.selectOne(namespace + "selectLastChat", chat_room_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public int selectUserCount(int chat_room_no) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.selectOne(namespace + "selectUserCount", chat_room_no);

			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public int selectPrevChk(ChatUserDto dto) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.selectOne(namespace + "selectPrevChk", dto);

			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public int insertChat(List<ChatDto> list) {

		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "insertChat", list);

			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

		return res;
	}

	public int insertRoom(OpenChatDto dto) {

		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "insertRoom", dto);

			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto.getChat_room_no();
	}

	public int insertOpenChatUser(ChatUserDto dto) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "insertOpenChatUser", dto);

			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public int updateLastChat(ChatUserDto dto) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace + "updateLastChat", dto);

			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public int updateLastChatData(ChatUserDto dto) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace + "updateLastChatData", dto);

			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public int deleteUser(ChatUserDto dto) {

		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace + "deleteUser", dto);

			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public int deleteChatRoom(int chat_room_no) {
		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace + "deleteChatRoom", chat_room_no);

			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}
}
