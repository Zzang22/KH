package com.bb.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.CorporationDto;


public class AdminCorporDao extends SqlMapConfig {

	private String namespace = "corporationmapper.";
	
	public List<CorporationDto> corporationList(int startCount, int endCount){
		SqlSession session = null;
		List<CorporationDto> corplist = new ArrayList<CorporationDto>();
		session = getSqlSessionFactory().openSession();
		//System.out.println("session확인 ");
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		//System.out.println("params : "+ params);
		
		//SQL이 오류 나서 값이 안넘어 가지는 중 
		corplist = session.selectList(namespace+"selectCorpList", params);
		//System.out.println("값도착");
		
		
		session.close();
		return corplist;
	}
	
	public int getCorporationTotal() {
		int cnt = 0;
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		
		cnt = session.selectOne(namespace+"selectCorpTotal");
		session.close();
		//System.out.println("총 게시물 : "+cnt);
		
		return cnt;
	}
}
