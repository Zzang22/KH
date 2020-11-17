package com.bb.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bb.dto.CorporationDto;
import com.bb.dto.MemberDto;

public class AdminMemberDao_paging extends SqlMapConfig {

	private String namespace = "paging.";
	

	
		public List<MemberDto> memberList(int startCount, int endCount){
			SqlSession session = null;
			
			List<MemberDto> list = new ArrayList<MemberDto>();
			session = getSqlSessionFactory().openSession(true);
			//System.out.println("session 확인");
			
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("startCount", startCount);
			parameters.put("endCount", endCount);
			//System.out.println("parameters:"+parameters);
			
			list = session.selectList(namespace+"selectList", parameters);
			//System.out.println("값도착");
			session.close();
			
			return list;
		}
		
		public int getMemberTotal() {
			int cnt = 0;
			SqlSession session = null;
			session = getSqlSessionFactory().openSession(true);
			
			cnt = session.selectOne(namespace+"selectMemberTotal");
			session.close();
			//System.out.println("총 게시물 : "+cnt);
			
			return cnt;
		}
     
      /*
		public int getTotal() {
	       int cnt = 0;
	       
	       String sql = " SELECT COUNT(*) cnt FROM MEMBER ";
	       try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	        
	        String url = "jdbc:oracle:thin:@qclass.iptime.org:1521:xe";
			String user = "master04_semi";
			String password="semi";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, user, password);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				pstm = con.prepareStatement(sql);
				rs = pstm.executeQuery();
				if(rs.next()) {
					cnt = rs.getInt("cnt");
					System.out.println("총게시물수 : "+ cnt);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstm.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			return cnt;
		}
       */	
	
}
