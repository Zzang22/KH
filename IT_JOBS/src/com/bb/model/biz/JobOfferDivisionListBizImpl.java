package com.bb.model.biz;

import java.util.List;


import com.bb.dto.JobOfferDivisionListDto;
import com.bb.dto.RsDto;
import com.bb.model.dao.JobOfferDivisionListDao;
import com.bb.model.dao.JobOfferDivisionListDaoImpl;

public class JobOfferDivisionListBizImpl implements JobOfferDivisionListBiz {

	private JobOfferDivisionListDao dao = new JobOfferDivisionListDaoImpl();
	
	@Override
	public List<JobOfferDivisionListDto> selectList(JobOfferDivisionListDto dto) {
		return dao.selectList(dto);
	}
	
	@Override
	public JobOfferDivisionListDto selectOne(int jo_no) {
		return dao.selectOne(jo_no);
	}

	@Override
	public int hitUp(int jo_no) {
		return dao.hitUp(jo_no);
	}
	
	@Override
	public int interestCheck(int member_no, int jo_no) {
		return dao.interestCheck(member_no, jo_no);
	}

	@Override
	public int insertInterestJob(int member_no, int jo_no) {
		return dao.insertInterestJob(member_no, jo_no);
	}

	@Override
	public int deleteInterestJob(int member_no, int jo_no) {
		return dao.deleteInterestJob(member_no, jo_no);
	}
	
	@Override
	public List<RsDto> myResumeList(int member_no) {
		return dao.myResumeList(member_no);
	}
	@Override
	 public int applyResume(int rs_no, int jo_no) {
		return dao.applyResume(rs_no, jo_no);
	 }
	 
	
}
