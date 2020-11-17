package com.bb.model.dao;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.CustomerServiceDto;

public class AdminCsDao extends SqlMapConfig {

	private String namespace = "csboardmapper.";
			
	public int insert(CustomerServiceDto dto) {
		SqlSession session = null;
		
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace + "insert", dto); // 파라미터 하나 더 바꼈다.
		
		session.close();
		return res;
	}

	public List<CustomerServiceDto> listBoard(){
		SqlSession session = null;
		
		List<CustomerServiceDto> list = new ArrayList<CustomerServiceDto>();
		session = getSqlSessionFactory().openSession();
		list = session.selectList(namespace + "selectList");
		
		session.close();
		
		return list;
	}
	
	public CustomerServiceDto selectOne(int cs_no) {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession();
		CustomerServiceDto dto = new CustomerServiceDto();
		dto = session.selectOne(namespace+"selectOne", cs_no);
		
		session.close();
		return dto;
	}
	
	public int update(CustomerServiceDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.update(namespace + "update", dto);
		
		session.close();
		return res;
	}
	
	public int delete(int cs_no) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.delete(namespace + "delete", cs_no);
		
		session.close();
		return res;
	}
}
