package com.bb.model.biz;

import java.util.List;

import com.bb.dto.AnswerBoardDto;
import com.bb.model.dao.AnswerBoardDaoImpl;

public class AnswerBoardBizImpl implements AnswerBoardBiz {
	private AnswerBoardDaoImpl dao = new AnswerBoardDaoImpl();
	@Override
	public List<AnswerBoardDto> selectAnswerList(int userboard_no) {
		return dao.selectAnswerList(userboard_no);
	}
	@Override
	public int AnswerInsert(AnswerBoardDto dto) {
		return dao.AnswerInsert(dto);
	}
	@Override
	public int AnswerUpdate(AnswerBoardDto dto) {
		return dao.AnswerUpdate(dto);
	}
	@Override
	public int AnswerDelete(int answer_no) {
		return dao.AnswerDelete(answer_no);
	}
	@Override
	public int AnswerAnswerInsert(AnswerBoardDto dto) {
		return dao.AnswerAnswerInsert(dto);
	}


}
