package com.bb.model.dao;

import java.util.ArrayList;



import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.InterestJobDto;
import com.bb.dto.JobOfferDivisionListDto;
import com.bb.dto.RsDto;


public class JobOfferDivisionListDaoImpl extends SqlMapConfig implements JobOfferDivisionListDao {

	private String namespace = "JobOfferDivisionListMapper.";
	
	@Override
	public List<JobOfferDivisionListDto> selectList(JobOfferDivisionListDto dto) {
		SqlSession session = null; // db랑 연결해주는 session
		List<JobOfferDivisionListDto> list = new ArrayList<JobOfferDivisionListDto>();
		session = getSqlSessionFactory().openSession();
		list = session.selectList(namespace + "selectList", dto);
		session.close();
		return list;
	}
	
	@Override
	public JobOfferDivisionListDto selectOne(int jo_no) {
		SqlSession session = null;
		JobOfferDivisionListDto dto = null;
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace + "selectOne", jo_no);
		session.close();
		return dto;
	}
	
	@Override
	public int hitUp(int jo_no) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace + "hitUp", jo_no);
		session.close();
		return res;
	}
	
	@Override
	public int interestCheck(int member_no, int jo_no) {
		
		InterestJobDto dto = new InterestJobDto(member_no, jo_no);
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.selectOne("interestJobMapper.interestCheck", dto);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		return res;	
	}

	@Override
	public int insertInterestJob(int member_no, int jo_no) {
		
		InterestJobDto dto = new InterestJobDto(member_no, jo_no);
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert("interestJobMapper.insertInterestJob", dto);
			
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
	public int deleteInterestJob(int member_no, int jo_no) {
		InterestJobDto dto = new InterestJobDto(member_no, jo_no);
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete("interestJobMapper.deleteInterestJob", dto);
			
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

	public List<RsDto> myResumeList(int member_no) {
	      SqlSession session = null;
	      List<RsDto> list = new ArrayList<RsDto>();
	      session = getSqlSessionFactory().openSession();
	      list = session.selectList(namespace + "myResumeList", member_no);
	      session.close();
	      return list;
	   }
	   
	   public int applyResume(int rs_no, int jo_no) {
	      
	      RsDto dto = new RsDto();
	      SqlSession session = null;
	      int res = 0;
	      dto.setRs_no(rs_no);
	      dto.setJo_no(jo_no);
	      session = getSqlSessionFactory().openSession(true);
	      res = session.insert(namespace + "applyResume", dto);
	      session.close();
	      return res;
	   }
}
