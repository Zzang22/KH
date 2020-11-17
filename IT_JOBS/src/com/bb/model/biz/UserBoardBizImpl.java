package com.bb.model.biz;

import java.util.List;

import com.bb.dto.AnswerBoardDto;
import com.bb.dto.UserBoardDto;
import com.bb.model.dao.UserBoardDaoImpl;


public class UserBoardBizImpl implements UserBoardBiz {
	
		UserBoardDaoImpl dao = new UserBoardDaoImpl();
	@Override
	public List<UserBoardDto> selectUserList() {
		return dao.selectUserList();
	}


	@Override
	public UserBoardDto selectUserOne(int userboard_no) {
		
		return dao.selectUserOne(userboard_no);
	}

	@Override
	public int UserBoardInsert(UserBoardDto dto) {
		return dao.UserBoardInsert(dto);
	}
	
	
	@Override
	public int UserBoardUpdate(UserBoardDto dto) {
		return dao.UserBoardUpdate(dto);
	}

	@Override
	public int UserBoardDelete(int userboard_no) {
		return dao.UserBoardDelete(userboard_no);
	}
	


}
