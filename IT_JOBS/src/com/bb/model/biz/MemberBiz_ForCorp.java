package com.bb.model.biz;

import com.bb.dto.MemberDto_ForCorp;
import com.bb.model.dao.MemberDao_ForCorp;

public class MemberBiz_ForCorp {
	
	private MemberDao_ForCorp dao = new MemberDao_ForCorp();

	public MemberDto_ForCorp member_login(String member_id, String member_pw) {
		return dao.member_login(member_id, member_pw);
	}
	
}
