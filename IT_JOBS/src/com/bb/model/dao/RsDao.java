package com.bb.model.dao;

import java.util.List;

import com.bb.dto.RsDto;

public interface RsDao {
	
	public List<RsDto> selectResumeList(int member_no);
	public RsDto selectResumeDetail(int rs_no);
	public int insertResume(RsDto dto);
	public int updateResume(RsDto dto);
	public int updateSelfintro(RsDto dto);
	public int deleteResume(int rs_no);

}
