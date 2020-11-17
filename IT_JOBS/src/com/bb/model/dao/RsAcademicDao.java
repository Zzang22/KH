package com.bb.model.dao;

import java.util.List;

import com.bb.dto.RsAcademicDto;

public interface RsAcademicDao {
	

	public List<RsAcademicDto> selectAcademicList(int rs_no);
	public int insertAcademic(List<RsAcademicDto> list);
	public int updateAcademic(List<RsAcademicDto> list);
	public List<RsAcademicDto> selectAcNo(int rs_no);
	public int deleteAcademic(int rs_ac_no);
	public int deleteAcademicAll(int rs_no);
}
