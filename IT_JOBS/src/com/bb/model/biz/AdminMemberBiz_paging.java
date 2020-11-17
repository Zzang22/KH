package com.bb.model.biz;

import java.util.List;

import com.bb.dto.CorporationDto;
import com.bb.dto.MemberDto;
import com.bb.model.dao.AdminCorporDao;
import com.bb.model.dao.AdminMemberDao_paging;


public class AdminMemberBiz_paging {
	AdminMemberDao_paging mdao = new AdminMemberDao_paging();
    AdminCorporDao cdao = new AdminCorporDao();
	
	// 일반 회원 조회
	public List<MemberDto> memberList(int startCount, int endCount){
		return mdao.memberList(startCount, endCount);
	}
	// 일반 회원의 게시물  총 갯수
	public int getMemberTotal(){
		return mdao.getMemberTotal();
	}
	
	
	/*
	public List<CorporationDto> corporationList(int begin, int end){
		return cdao.corporationList(begin, end);
		
	}
	
	public List<CorporationDto> corporationList(){
		return  cdao.corporationList();
	}
	
	//기업회원 게시물 갯수
	public int getCorporationTotal() {
		return cdao.getCorporationTotal();
	}
	*/
}
