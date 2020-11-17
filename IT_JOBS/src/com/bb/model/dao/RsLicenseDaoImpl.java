package com.bb.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.RsAcademicDto;
import com.bb.dto.RsCareerDto;
import com.bb.dto.RsLicenseDto;

public class RsLicenseDaoImpl extends SqlMapConfig implements RsLicenseDao {

	private String namespace = "com.bb.rsl.";

	@Override
	public List<RsLicenseDto> selectLicenseList(int rs_no) {
		
		List<RsLicenseDto> list = new ArrayList<RsLicenseDto>();
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace + "selectLicenseList", rs_no);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		return list;
	}
	
	@Override
	public List<RsLicenseDto> selectLcNo(int rs_no) {
		SqlSession session = null;
		List<RsLicenseDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace + "selectLcNo", rs_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public int insertLicense(List<RsLicenseDto> list) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "insertLicense", list);
			
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
	public int updateLicense(List<RsLicenseDto> list) {

		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"updateLicense", list);
			
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
	public int deleteLicense(int rs_lc_no) {
		SqlSession session = null;
		
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession(false);
			
			res = session.delete(namespace + "deleteLicense", rs_lc_no);
			
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
	public int deleteLicenseAll(int rs_no) {
		SqlSession session = null;
		
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession(false);
			
			res = session.delete(namespace + "deleteLicenseAll", rs_no);
			
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
