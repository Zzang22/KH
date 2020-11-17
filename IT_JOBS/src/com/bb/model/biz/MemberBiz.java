package com.bb.model.biz;

import java.util.List;

import com.bb.dto.ApplicantDto;
import com.bb.dto.MemberDto;
import com.bb.model.dao.MemberDao;

public class MemberBiz {
	
	private MemberDao dao = new MemberDao();

	public MemberDto login(String member_id, String member_pw) {
		return dao.login(member_id, member_pw);
	}
	
	public int MemberJoinInsert(MemberDto dto) {
		return dao.MemberJoinInsert(dto);
	}
	
	public int MemberidCheck(String member_id) {
		return dao.MemberidCheck(member_id);
	}
	
	public int snslogin(MemberDto dto) {
		return dao.snslogin(dto);
	}
	
	public MemberDto check(String member_id) {
		return dao.check(member_id);
	}
	
	 public List<ApplicantDto> myApply(int member_no) {
	      return dao.myApply(member_no);
	   }


	 public int memberUpdate(MemberDto dto) {
		 return dao.memberUpdate(dto);
	 }

}

