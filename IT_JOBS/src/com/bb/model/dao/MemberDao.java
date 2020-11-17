package com.bb.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.ApplicantDto;
import com.bb.dto.MemberDto;

public class MemberDao extends SqlMapConfig{

	private String namespace = "memberMapper." ;
	
	// 개인회원가입
	public int MemberJoinInsert(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "MemberJoinInsert", dto);
			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		
			System.out.println("insert 결과 추적 : " + res);
		} catch (Exception e) {
			System.out.println("[error] MemberJoinInsert");
			session.rollback();
			e.printStackTrace();
		}
		
		session.close();
		
		return res;
	}
	
	//sns login
	public int snslogin(MemberDto dto) {
		SqlSession session = null;
		Integer res = 0;
		//세션
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace + "snslogin", dto);
		} catch (Exception e) {
			System.out.println("[error]snslogin");
			e.printStackTrace();
		}
		session.close();
		
		return res;
	}
	
	//아이디 중복체크
	public int MemberidCheck(String member_id) {
		SqlSession session = null;
		
		Integer res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.selectOne(namespace + "selectId", member_id);
		} catch (Exception e) {
			System.out.println("[error]selectId");
			e.printStackTrace();
		}

		session.close();
		
		return res;
	}
	
	// 로그인
	public MemberDto login(String member_id, String member_pw) {
		SqlSession session = null;
		
		MemberDto dto = null;
		MemberDto duo = new MemberDto();
		
		duo.setMember_id(member_id);
		duo.setMember_pw(member_pw);
		
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace + "login", duo);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error]login");
		} finally {
			session.close();
		}
		return dto;
	}
	
	public MemberDto check(String member_id) {
		SqlSession session = null;
		MemberDto dto = new MemberDto();
		
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+ "check",member_id);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error]check");
		} finally {
			session.close();
		}
		return dto;
	}	
	//지원한 이력서 보기
	public List<ApplicantDto> myApply(int member_no) {
	      SqlSession session = null;
	      List<ApplicantDto> list = new ArrayList<ApplicantDto>();
	      try {
	         session = getSqlSessionFactory().openSession();
	         list = session.selectList(namespace + "myApply", member_no);
	      
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("[error]myApply");
	      } finally {
	         session.close();
	      }
	      return list;
	   }
	
	// 개인회원정보수정
	public int memberUpdate(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "memberUpdate", dto);
			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		
			System.out.println("memberUpdate 결과 추적 : " + res);
		} catch (Exception e) {
			System.out.println("[error] memberUpdate");
			session.rollback();
			e.printStackTrace();
		}
		
		session.close();
		
		return res;
	}
}
