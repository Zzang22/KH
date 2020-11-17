package com.bb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bb.dto.NewsDto;
import com.bb.model.dao.NewsDao;


@WebServlet("/news.do")
public class News_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println("[" + command + "]");
		NewsDao dao = new NewsDao();
		
		if (command.equals("news")) {
			
			List<NewsDto> list = dao.itnews();
			request.setAttribute("list", list);
			response.sendRedirect("itnewspage.jsp");
			
		}
		
		
		
		
		
		
		
	}
	
	public void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispach = request.getRequestDispatcher(path);
		dispach.forward(request, response);
	}
	

}
