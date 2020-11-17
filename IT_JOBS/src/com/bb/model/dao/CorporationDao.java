package com.bb.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.CorporationDto;


public class CorporationDao extends SqlMapConfig {

	private String namespace = "corporationMapper.";

	// 기업회원가입 part1 ----------------------------------------------------------------
	public int CorpJoinInsertPartOne(CorporationDto dto) {

		SqlSession session = null;
		int res = 0;

		try {

			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "CorpJoinInsertPartOne", dto);
			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}

			System.out.println("insert 결과 추적 : " + res);
		} catch (Exception e) {
			System.out.println("[error] CorpJoinInsertPartOne");
			session.rollback();
			e.printStackTrace();
		}

		session.close();

		return res;
	}

	// 기업회원가입 part 2----------------------------------------------------------
	public int CorpJoinInsertPartTwo(CorporationDto dto) {

		SqlSession session = null;
		int res = 0;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "CorpJoinInsertPartTwo", dto);

			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}

		} catch (Exception e) {
			System.out.println("[error] CorpJoinInsertPartTwo");
			session.rollback();
			e.printStackTrace();
		}

		session.close();

		return res;
	}
	

	// 아이디 중복체크-----------------------------------------------
	public int CorpidCheck(String member_id) {

		SqlSession session = null;
		// CorporationDto dto = null;
		Integer res = 0;

		try {
			session = getSqlSessionFactory().openSession();
			res = session.selectOne(namespace + "selectId", member_id);
		} catch (Exception e) {
			System.out.println("[error]selectId");
			e.printStackTrace();
		}

		session.close();

		return res;
	}
	
	// 사업자번호 중복체크---------------------------------------------
	public int CorpB_NoCheck(String corp_businessno) {
		
		SqlSession session = null;
		Integer res = 0;
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.selectOne(namespace + "selectB_No", corp_businessno);
			System.out.println("b_no 추적 : "+res);
		} catch (Exception e) {
			System.out.println("[error]selectB_No");
			e.printStackTrace();
		}
		
		session.close();
		
		return res;
	}
	
	//	//--Member : member_no, id, pw, name, postcode, addr, phone, email, enabled, role
	//-- corp : corp_businessno, corp_ceo_name, corp_board_name,
	//기업정보 수정을 위한 selectone-----------------------------------------------------
	public CorporationDto ShowCorpInfo(String member_id){
		
		SqlSession session = null;
		CorporationDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace + "ShowCorpInfo", member_id);
		} catch (Exception e) {
			System.out.println("[error]ShowCorpInfo");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return dto;
		
	}
	
	//---기업정보 수정-----------------------------------------------------------------------------------
	public int CorpInfo_Update(CorporationDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace + "CorpInfo_Update", dto);
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			System.out.println("[error]CorpInfo_Update");
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return res;
	}
	
	public int CorpInfo_Update02(CorporationDto dto) {
		SqlSession session = null;
		int res =0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+ "CorpInfo_Update02", dto);
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
			
		} catch (Exception e) {
			System.out.println("[error] CorpInfo_Update02");
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	
	
	//결제 후 멤버쉽 컬럼 변경---------------------------------------
	public int ChangeMemberShip(String member_id) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace + "ChangeMemberShip", member_id);
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			System.out.println("[error]ChangeMemberShip");
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		System.out.println("멤버쉽변경 : " + res);
		System.out.println("다오 멤버아이디 : " + member_id);
		return res;
	}
	
	//결제 한 회원인지 유무 
	public int IsMemberShip(String member_id) {
		SqlSession session = null;
		Integer res = 0;
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.selectOne(namespace + "IsMemberShip", member_id);
		} catch (Exception e) {
			System.out.println("[error]IsMemberShip");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	
	//게시글 수 제한
	public int jobofferlimit(String member_id) {
		SqlSession session = null;
		Integer res = 0;
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.selectOne(namespace + "jobofferlimit", member_id);
		} catch (Exception e) {
			System.out.println("[error]jobofferlimit");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
		
	}
	

}
