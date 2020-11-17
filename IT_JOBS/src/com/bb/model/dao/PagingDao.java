package com.bb.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.JobofferDto;
import com.bb.dto.Paging_Criteria;

public class PagingDao extends SqlMapConfig {
	
	private String namespace="pagingmapper.";
	
	
	//페이징 처리를 위한 메서드
	public List<JobofferDto> listCriteria(Paging_Criteria cri){

		List<JobofferDto> list = new ArrayList<JobofferDto>();
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace + "listCriteria",cri);
		} catch (Exception e) {
			System.out.println("[error]listCriteria");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	
	//전체 게시글 수 구하기
	public Integer ToTalCount() {
		SqlSession session = null;
		Integer res = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.selectOne(namespace + "getTotalCount");
		} catch (Exception e) {
			System.out.println("[error]ToTalCount");
			e.printStackTrace();
		}
		
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
