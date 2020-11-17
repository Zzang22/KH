package com.bb.model.biz;

import java.util.List;

import com.bb.dto.CorporationDto;
import com.bb.dto.MemberDto;
import com.bb.model.dao.AdminCorporDao;


public class AdminCorpBiz {

    AdminCorporDao cdao = new AdminCorporDao();
	
	public List<CorporationDto> corporationList(int startCount, int endCount){
		return cdao.corporationList(startCount, endCount);
		
	}

	//기업회원 게시물 갯수
	public int getCorporationTotal() {
		return cdao.getCorporationTotal();
	}
	
}
