package com.bb.model.dao;

import java.util.List;


import com.bb.dto.RsCareerDto;

public interface RsCareerDao {
	

	public List<RsCareerDto> selectCareerList(int rs_no);
	public int insertCareer(List<RsCareerDto> list);
	public int updateCareer(List<RsCareerDto> list);
	public List<RsCareerDto> selectCrNo(int rs_no);
	public int deleteCareer(int rs_ca_no);
 	public int deleteCareerAll(int rs_no);
	
}
