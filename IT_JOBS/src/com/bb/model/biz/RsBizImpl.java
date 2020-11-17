package com.bb.model.biz;

import java.util.List;

import com.bb.dto.RsAcademicDto;
import com.bb.dto.RsCareerDto;
import com.bb.dto.RsDto;
import com.bb.dto.RsLicenseDto;
import com.bb.model.dao.RsAcademicDao;
import com.bb.model.dao.RsAcademicDaoImpl;
import com.bb.model.dao.RsCareerDao;
import com.bb.model.dao.RsCareerDaoImpl;
import com.bb.model.dao.RsDao;
import com.bb.model.dao.RsDaoImpl;
import com.bb.model.dao.RsLicenseDao;
import com.bb.model.dao.RsLicenseDaoImpl;

public class RsBizImpl implements RsBiz {
	RsDao rsDao = new RsDaoImpl();
	RsAcademicDao rsAcademicDao = new RsAcademicDaoImpl();
	RsCareerDao rsCareerDao = new RsCareerDaoImpl();
	RsLicenseDao rsLicenseDao = new RsLicenseDaoImpl();

	//rs
	@Override
	public List<RsDto> selectResumeList(int member_no) {
		return rsDao.selectResumeList(member_no);
	}
	@Override
	public RsDto selectResumeDetail(int rs_no) {
		return rsDao.selectResumeDetail(rs_no);
	}
	@Override
	public int insertResume(RsDto dto) {
		return rsDao.insertResume(dto);
	}
	@Override
	public int updateSelfintro(RsDto dto) {
		return rsDao.updateSelfintro(dto);
	}
	@Override
	public int updateResume(RsDto dto) {
		return rsDao.updateResume(dto);
	}
	@Override
	public int deleteResume(int rs_no) {
		return rsDao.deleteResume(rs_no);
	}

	
	
	//rs_ac
	@Override
	public List<RsAcademicDto> selectAcademicList(int rs_no) {
		
		return rsAcademicDao.selectAcademicList(rs_no);
	}
	@Override
	public List<RsAcademicDto> selectAcNo(int rs_no) {
		return rsAcademicDao.selectAcNo(rs_no);
	}
	@Override
	public int insertAcademic(List<RsAcademicDto> list) {
		return rsAcademicDao.insertAcademic(list);
	}
	@Override
	public int updateAcademic(List<RsAcademicDto> list) {
		return rsAcademicDao.updateAcademic(list);
	}
	@Override
	public int deleteAcademic(int rs_ac_no) {
		return rsAcademicDao.deleteAcademic(rs_ac_no);
	}
	@Override
	public int deleteAcademicAll(int rs_no) {
		return rsAcademicDao.deleteAcademicAll(rs_no);
	}
	
	
	
	//rs_cr
	@Override
	public List<RsCareerDto> selectCareerList(int rs_no) {
		return rsCareerDao.selectCareerList(rs_no);
	}
	@Override
	public List<RsCareerDto> selectCrNo(int rs_no) {
		return rsCareerDao.selectCrNo(rs_no);
	}
	@Override
	public int insertCareer(List<RsCareerDto> list) {
		
		return rsCareerDao.insertCareer(list);
	}
	@Override
	public int updateCareer(List<RsCareerDto> list) {
		return rsCareerDao.updateCareer(list);
	}
	@Override
	public int deleteCareer(int rs_ca_no) {
		return rsCareerDao.deleteCareer(rs_ca_no);
	}
	@Override
	public int deleteCareerAll(int rs_no) {
		return rsCareerDao.deleteCareerAll(rs_no);
	}

	
	
	//rs_lc
	@Override
	public List<RsLicenseDto> selectLicenseList(int rs_no) {
		
		List<RsLicenseDto> list = rsLicenseDao.selectLicenseList(rs_no);
		for(int i=0; i<list.size(); i++) {
			RsLicenseDto dto = list.get(i);
			String date = dto.getRs_lc_date();
			
			String month = date.substring(5, 7);
			String day = date.substring(8, 10);
			if(month.substring(0, 1).equals("0")) {
				month = month.substring(1, 2);
			}
			if(day.substring(0, 1).equals("0")) {
				day = day.substring(1, 2);
			}
			
			dto.setRs_lc_date_year(date.substring(0, 4));
			dto.setRs_lc_date_month(month);
			dto.setRs_lc_date_day(day);
			
		}

		return list;
	}
	@Override
	public int insertLicense(List<RsLicenseDto> list) {
		return rsLicenseDao.insertLicense(list);
	}
	@Override
	public int updateLicense(List<RsLicenseDto> list) {
		return rsLicenseDao.updateLicense(list);
	}
	@Override
	public List<RsLicenseDto> selectLcNo(int rs_no) {
		return rsLicenseDao.selectLcNo(rs_no);
	}
	@Override
	public int deleteLicense(int rs_lc_no) {
		return rsLicenseDao.deleteLicense(rs_lc_no);
	}
	@Override
	public int deleteLicenseAll(int rs_no) {
		return rsLicenseDao.deleteLicenseAll(rs_no);
	}

	

}
