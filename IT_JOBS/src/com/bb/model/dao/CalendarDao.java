package com.bb.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.CalendarDto;
import com.bb.dto.Interest_JobDto;

public class CalendarDao extends SqlMapConfig{
	
	private String namespace="calendarmapper.";
	
	//일정 추가
	public int insertCalBoard(CalendarDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace + "insert", dto);
		
		session.close();
		return res;
	}
	
	// 등록 일정 리스트 
	public List<CalendarDto> selectCalendarList(String yyyyMMdd, int member_no){
		SqlSession session = null;
		List<CalendarDto> calendarlist = new ArrayList<CalendarDto>();
		session = getSqlSessionFactory().openSession();
		//System.out.println("session확인:"+session);
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("yyyyMMdd", yyyyMMdd);
		params.put("member_no", member_no);
		//System.out.println("params확인:"+params);
		
		calendarlist = session.selectList(namespace + "selectList",params);
		//System.out.println("dao-값도착");  //여기까지는 괜춘
		session.close();
		
		return calendarlist;
	}
	
	// 달력에 보이는 list 
	public List<CalendarDto> calendarViewList(int member_no, String yyyyMM){
		
		SqlSession session = null;
		List<CalendarDto> calViewList = new ArrayList<CalendarDto>();
		session = getSqlSessionFactory().openSession();
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("member_no", member_no);
		parameters.put("yyyyMM", yyyyMM);
		//System.out.println("parameters확인: " + parameters);
		
		calViewList = session.selectList(namespace+"calViewList", parameters);
		session.close();
		//System.out.println("calViewList 확인:"+calViewList);
		
		return calViewList;
	}
	
	// 일정 하루에 일정 몇개인지 
	public int calendarViewCount(int member_no, String yyyyMMdd) {
		SqlSession session = null;
		int count = 0;
	//	System.out.println("dao-member_no:"+member_no);
		//System.out.println("dao-yyyyMMdd:"+yyyyMMdd);
		
		session = getSqlSessionFactory().openSession(true);
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("yyyyMMdd", yyyyMMdd);
		param.put("member_no", member_no);
		
		
		count = session.selectOne(namespace+"calViewCount",param);
		
	//	System.out.println("dao-count확인:"+count);
		session.close();
		
		return count;
	}

	public CalendarDto selectOneBoard(int cal_no) {
		SqlSession session = null;
		CalendarDto dto = null;
		session = getSqlSessionFactory().openSession(true);
		dto = session.selectOne(namespace+"selectOne", cal_no);
		session.close();
		return dto;
	}
	//선택 한번에 삭제
	public int multiDelete(String[] cal_nos) {
		int count = 0;
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("cal_nos", cal_nos);  // 값을 cal_nos에 담음
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(false); //Auto commit 안한다
		count = session.delete(namespace + "muldel", map);
		if(count == cal_nos.length) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return count;
	}

	//등록한 일정 수정하기 
	public int updateCalendar(CalendarDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.update(namespace+ "update", dto);
		
		session.close();
		return res;
	}

	
}
