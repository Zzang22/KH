package com.bb.model.biz;

import java.util.List;

import com.bb.dto.UserBoardDto;
import com.bb.dto.AnswerBoardDto;

public interface UserBoardBiz {
	
	
	//UserBoard
	public List<UserBoardDto> selectUserList();
	
	public UserBoardDto selectUserOne(int userboard_no);
	
	public int UserBoardInsert(UserBoardDto dto);
	
	public int UserBoardUpdate(UserBoardDto dto);
	
	public int UserBoardDelete(int userboard_no);
	
	
	

}
