package com.bb.model.biz;

import java.util.List;

import com.bb.dto.AnswerBoardDto;

public interface AnswerBoardBiz {
	
	public List<AnswerBoardDto> selectAnswerList(int userboard_no);
	
	public int AnswerInsert(AnswerBoardDto dto);
	
	public int AnswerUpdate(AnswerBoardDto dto);
	
	public int AnswerDelete(int answer_no);
	
	public int AnswerAnswerInsert(AnswerBoardDto dto);
	

}
