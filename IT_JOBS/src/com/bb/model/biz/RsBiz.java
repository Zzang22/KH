package com.bb.model.biz;

import java.util.List;

import com.bb.dto.RsAcademicDto;
import com.bb.dto.RsCareerDto;
import com.bb.dto.RsDto;
import com.bb.dto.RsLicenseDto;

public interface RsBiz {
	
	//rs
	public List<RsDto> selectResumeList(int member_no);
	public RsDto selectResumeDetail(int rs_no);
	public int insertResume(RsDto dto);
	public int updateResume(RsDto dto);
	public int updateSelfintro(RsDto dto);
	public int deleteResume(int rs_no);
	
	//rs_ac
	public List<RsAcademicDto> selectAcademicList(int rs_no);
	public List<RsAcademicDto> selectAcNo(int rs_no);
	public int insertAcademic(List<RsAcademicDto> list);
	public int updateAcademic(List<RsAcademicDto> list);
	public int deleteAcademic(int rs_ac_no);
	public int deleteAcademicAll(int rs_no);
	
	//rs_cr
	public List<RsCareerDto> selectCareerList(int rs_no);
	public List<RsCareerDto> selectCrNo(int rs_no);
	public int insertCareer(List<RsCareerDto> list);
	public int updateCareer(List<RsCareerDto> list);
	public int deleteCareer(int rs_ca_no);
	public int deleteCareerAll(int rs_no);
 	
	//rs_lc
	public List<RsLicenseDto> selectLicenseList(int rs_no);
	public List<RsLicenseDto> selectLcNo(int rs_no);
	public int insertLicense(List<RsLicenseDto> list);
	public int updateLicense(List<RsLicenseDto> list);
	public int deleteLicense(int rs_lc_no);
	public int deleteLicenseAll(int rs_no);
	

}
