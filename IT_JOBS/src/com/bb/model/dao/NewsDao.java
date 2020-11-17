package com.bb.model.dao;

import java.util.ArrayList; 
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.NewsDto;

public class NewsDao extends Mariadb_SqlMapConfig{
	
	private String namespace = "newsMapper.";
	

	public List<NewsDto> itnews() {
		
		List <NewsDto> list = new ArrayList<NewsDto>();
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace + "itnews");
			
			
		} catch (Exception e) {
			System.out.println("[error] newsselect");
			e.printStackTrace();
			
		}finally {
			session.close();
		}	
		
		return list;

		
	}
		
}
