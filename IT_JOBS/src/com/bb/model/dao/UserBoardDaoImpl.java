package com.bb.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.UserBoardDto;

public class UserBoardDaoImpl extends SqlMapConfig implements UserBoardDao {

	private String namespace="com.bb.userboard.";
	
	@Override
	public List<UserBoardDto> selectUserList() {
		SqlSession session = null;
		List<UserBoardDto> list = new ArrayList<UserBoardDto>();
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace+"selectUserList");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return list;
	}

	@Override
	public UserBoardDto selectUserOne(int userboard_no) {
		SqlSession session = null;
		UserBoardDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			dto = session.selectOne(namespace+"selectUserOne", userboard_no);
		} catch (Exception e) {
			System.out.println("[error] + selectUserOne");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return dto;
	}

	@Override
	public int UserBoardInsert(UserBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"UserInsert", dto);
			System.out.println(res);
			
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			System.out.println("[error] userboard insert");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}

	@Override
	public int UserBoardUpdate(UserBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"UserUpdate", dto);
			System.out.println(res);
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			System.out.println("[error] UserBoardUpdate dao");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int UserBoardDelete(int userboard_no) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace+"UserDelete", userboard_no);
			
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}


	

}
