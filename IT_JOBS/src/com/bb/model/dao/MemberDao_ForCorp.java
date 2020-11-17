package com.bb.model.dao;

import org.apache.ibatis.session.SqlSession; 

import com.bb.dto.MemberDto_ForCorp;

public class MemberDao_ForCorp extends SqlMapConfig{

	private String namespace = "com.bb.memberdao." ;
	
	// 개인 로그인
	public MemberDto_ForCorp member_login(String member_id, String member_pw) {
		SqlSession session = null;
		MemberDto_ForCorp dto = null;
		MemberDto_ForCorp duo = new MemberDto_ForCorp();
		duo.setMember_id(member_id);
		duo.setMember_pw(member_pw);
		
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"login", duo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
}
