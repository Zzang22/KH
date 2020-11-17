package com.bb.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.RsDto;

public class RsDaoImpl extends SqlMapConfig implements RsDao {

	private String namespace = "com.bb.rs.";
	
	@Override
	public List<RsDto> selectResumeList(int member_no) {
		
		List<RsDto> list = new ArrayList<RsDto>();
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace + "selectResumeList", member_no);
			
			
		} catch (Exception e) {
			System.out.println("[error] selectList");
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		return list;
	}
	@Override
	public RsDto selectResumeDetail(int rs_no) {
		
		RsDto dto = null;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			dto = session.selectOne(namespace + "selectResumeDetail", rs_no);
			
			
		} catch (Exception e) {
			System.out.println("[error] selectDto");
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		return dto;
		
	}
	@Override
	public int insertResume(RsDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"insertResume", dto);
			
			if(res>0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return dto.getRs_no();
	}
	@Override
	public int updateResume(RsDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"updateResume", dto);
			
			if(res>0) {
				session.commit();
			} else {
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
	public int updateSelfintro(RsDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"updateSelfintro", dto);
			
			if(res>0) {
				session.commit();
			} else {
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
	public int deleteResume(int rs_no) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace+"deleteResume", rs_no);
			
			if(res>0) {
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
