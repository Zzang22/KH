package com.bb.model.dao;

import java.util.List;

import com.bb.dto.RsLicenseDto;

public interface RsLicenseDao {

	public List<RsLicenseDto> selectLicenseList(int rs_no);
	public List<RsLicenseDto> selectLcNo(int rs_no);
	public int insertLicense(List<RsLicenseDto> list);
	public int updateLicense(List<RsLicenseDto> list);
	public int deleteLicense(int rs_lc_no);
	public int deleteLicenseAll(int rs_no);
	
	
}
