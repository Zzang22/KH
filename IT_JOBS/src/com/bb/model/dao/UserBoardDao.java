package com.bb.model.dao;

import java.util.List;

import com.bb.dto.UserBoardDto;

public interface UserBoardDao {
	
	public List<UserBoardDto> selectUserList();
	
	public UserBoardDto selectUserOne(int userboard_no);
	
	public int UserBoardInsert(UserBoardDto dto);
	
	public int UserBoardUpdate(UserBoardDto dto);
	
	public int UserBoardDelete(int userboard_no);
	

}
