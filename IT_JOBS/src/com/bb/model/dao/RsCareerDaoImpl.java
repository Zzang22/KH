package com.bb.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.RsCareerDto;

public class RsCareerDaoImpl extends SqlMapConfig implements RsCareerDao {

	private String namespace = "com.bb.rsc.";

	@Override
	public List<RsCareerDto> selectCareerList(int rs_no) {
		
		List<RsCareerDto> list = new ArrayList<RsCareerDto>();
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace + "selectCareerList", rs_no);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		return list;
	}
	
	@Override
	public List<RsCareerDto> selectCrNo(int rs_no) {
		SqlSession session = null;
		List<RsCareerDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			
			list = session.selectList(namespace + "selectCrNo", rs_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public int insertCareer(List<RsCareerDto> list) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "insertCareer", list);
			
			if(res == list.size()) {
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

	@Override
	public int updateCareer(List<RsCareerDto> list) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"updateCareer", list);
			
			if(res == -1) {
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

	@Override
	public int deleteCareer(int rs_ca_no) {
		SqlSession session = null;
		
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession(false);
			
			res = session.delete(namespace + "deleteCareer", rs_ca_no);
			
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

	@Override
	public int deleteCareerAll(int rs_no) {
		SqlSession session = null;
		
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession(false);
			
			res = session.delete(namespace + "deleteCareerAll", rs_no);
			
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
