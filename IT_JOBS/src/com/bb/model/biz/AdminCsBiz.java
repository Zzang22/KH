package com.bb.model.biz;

import java.util.List;

import com.bb.dto.CustomerServiceDto;
import com.bb.model.dao.AdminCsDao;

public class AdminCsBiz {

	private AdminCsDao csdao = new AdminCsDao();
	
	public int insert(CustomerServiceDto dto) {
		return csdao.insert(dto);
	}
	
	public List<CustomerServiceDto> listBoard(){
		return csdao.listBoard();
	}
	
	public CustomerServiceDto selectOne(int cs_no) {
		
		return csdao.selectOne(cs_no);
	}
	
	public int update(CustomerServiceDto dto) {
		return csdao.update(dto);
		
	}
	
	public int delete(int cs_no) {
		return csdao.delete(cs_no);
	}
}
