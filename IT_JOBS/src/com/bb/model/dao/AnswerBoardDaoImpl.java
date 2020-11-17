package com.bb.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.AnswerBoardDto;

public class AnswerBoardDaoImpl extends SqlMapConfig implements AnswerBoardDao {
	private String namespace="com.bb.answerboard.";
	@Override
	public List<AnswerBoardDto> selectAnswerList(int userboard_no) {
		SqlSession session = null;
		List<AnswerBoardDto> list = new ArrayList<AnswerBoardDto>();
		
		session = getSqlSessionFactory().openSession(false);
		list = session.selectList(namespace+"AnswerList", userboard_no);
		
		return list;
	}
	@Override
	public int AnswerInsert(AnswerBoardDto dto) {
		SqlSession session = null;

		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"AnswerInsert", dto);
			System.out.println(res+"res");
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
	@Override
	public int AnswerUpdate(AnswerBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"AnswerUpdate", dto);
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
	
	@Override
	public int AnswerDelete(int answer_no) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace+"AnswerDelete", answer_no);
			System.out.println(res+"res");
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			System.out.println("[error] AnswerDelete");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
	@Override
	public int AnswerAnswerInsert(AnswerBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"AnswerAnswerInsert", dto);
			
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
