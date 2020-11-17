package com.bb.model.biz;

import java.util.List;

import com.bb.dto.JobOfferDivisionListDto;
import com.bb.dto.RsDto;

public interface JobOfferDivisionListBiz {
	
	public List<JobOfferDivisionListDto> selectList(JobOfferDivisionListDto dto);
	public JobOfferDivisionListDto selectOne(int jo_no);
	public int hitUp(int jo_no);
	public int interestCheck(int member_no, int jo_no);
	public int insertInterestJob(int member_no, int jo_no);
	public int deleteInterestJob(int member_no, int jo_no);
	public List<RsDto> myResumeList(int member_no);
	public int applyResume(int rs_no, int jo_no);
	
}
