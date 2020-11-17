package com.bb.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.Interest_JobDto;

public class CalendarInterDao extends SqlMapConfig{

	private String namespace="interestjobmapper.";
	
	public List<Interest_JobDto> interestJobDeadline(int member_no){
		SqlSession session = null;
		List<Interest_JobDto> ilist = null;
		session = getSqlSessionFactory().openSession();
		ilist = session.selectList(namespace+"selectdeadline", member_no);
		session.close();
		return ilist;
	}
	
	

}
