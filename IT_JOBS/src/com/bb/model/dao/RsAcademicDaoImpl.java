package com.bb.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.RsAcademicDto;

public class RsAcademicDaoImpl extends SqlMapConfig implements RsAcademicDao {
	
	private String namespace = "com.bb.rsa.";

	@Override
	public List<RsAcademicDto> selectAcademicList(int rs_no) {
		
		List<RsAcademicDto> list = new ArrayList<RsAcademicDto>();
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace + "selectAcademicList", rs_no);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}
	
	@Override
	public List<RsAcademicDto> selectAcNo(int rs_no) {
		SqlSession session = null;
		List<RsAcademicDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			
			list = session.selectList(namespace + "selectAcNo", rs_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public int insertAcademic(List<RsAcademicDto> list) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "insertAcademic", list);
			
			if(res==list.size()) {
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
	public int updateAcademic(List<RsAcademicDto> list) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace + "updateAcademic", list);
			
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
	public int deleteAcademic(int rs_ac_no) {
		SqlSession session = null;
		
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession(false);
			
			res = session.delete(namespace + "deleteAcademic", rs_ac_no);
			
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
	public int deleteAcademicAll(int rs_no) {
		SqlSession session = null;
		
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession(false);
			
			res = session.delete(namespace + "deleteAcademicAll", rs_no);
			
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
