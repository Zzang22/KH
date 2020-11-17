package com.bb.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.JobofferDto;
import com.bb.dto.RsDto;

public class JobOfferDao extends SqlMapConfig {


	private String namespace = "jobofferMapper.";

//----직업분야 이름 조회(공고등록할때)----------------------------------------
	public List<JobofferDto> Jo_Field_name_list() {

		List<JobofferDto> list = new ArrayList<JobofferDto>();
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace + "Jo_Field_name_list");
		} catch (Exception e) {
			System.out.println("[error]Jo_Field_name_list");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

//-----경력 조회(공고등록할때)-----------------------------------------------------
	public List<JobofferDto> Jo_Career_name_list() {
		List<JobofferDto> list = new ArrayList<JobofferDto>();
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace + "Jo_Career_name_list");

		} catch (Exception e) {
			System.out.println("[error]Jo_Career_name_list");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;

	}
	
//-----공고 등록-----------------------------------------------------------
	public int JobOfferInsert(JobofferDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "JobOfferInsert", dto);
			System.out.println(namespace + "JobOfferInsert" + dto);
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			System.out.println("[error] JobOfferInsert");
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
	
//공고 등록 리스트 ---------------------------------------------------------------------------------------	
	public List<JobofferDto> JobOfferList(String member_id){
		
		SqlSession session = null;
		List<JobofferDto> list = new ArrayList<JobofferDto>();
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace + "JobOfferList", member_id);
		} catch (Exception e) {
			System.out.println("[error]JobOfferList");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}
	
	//공고 삭제----------------------------------------------------------------------------
		public int JobOfferDel(int jo_no) {
			SqlSession session = null;
			int res = 0;
			
			try {
				session = getSqlSessionFactory().openSession(false);
				res = session.delete(namespace + "JobOfferDel", jo_no);
				if(res>0) {
					session.commit();
				}else {
					session.rollback();
				}
			} catch (Exception e) {
				System.out.println("[error]JobOfferDel");
				session.rollback();
				e.printStackTrace();
			}finally {
				session.close();
			}
			return res;
		}
	
	//공고 수정 --------------------------------------------------------------------------
		public int JobOfferUpdate(JobofferDto dto) {
			SqlSession session = null;
			int res = 0;
			
			try {
				session = getSqlSessionFactory().openSession(false);
				res = session.update(namespace+ "JobOfferUpdate", dto);
				if(res>0) {
					session.commit();
				}else {
					session.rollback();
				}
				
			} catch (Exception e) {
				System.out.println("[error]JobOfferUpdate");
				session.rollback();
				e.printStackTrace();
			}finally {
				session.close();
			}
			
			return res;
		}
		
		//지원자리스트 보기--------------------------------------
	      public List<RsDto> applicantList(int jo_no) {
	         List<RsDto> list = new ArrayList<RsDto>();
	         SqlSession session = null;

	         try {
	            session = getSqlSessionFactory().openSession();
	            list = session.selectList(namespace + "applicantList", jo_no);
	         } catch (Exception e) {
	            System.out.println("[error] applicantList");
	            e.printStackTrace();
	         } finally {
	            session.close();
	         }

	         return list;
	         
	      }
	

}




