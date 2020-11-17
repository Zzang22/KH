package com.bb.model.dao;

import java.util.List;

import com.bb.dto.AnswerBoardDto;

public interface AnswerBoardDao {
	
	public List<AnswerBoardDto> selectAnswerList(int userboard_no);
	
	public int AnswerInsert(AnswerBoardDto dto);
	
	public int AnswerUpdate(AnswerBoardDto dto);
	
	public int AnswerDelete(int answer_no);
	
	//대댓글
	public int AnswerAnswerInsert(AnswerBoardDto dto);
}
