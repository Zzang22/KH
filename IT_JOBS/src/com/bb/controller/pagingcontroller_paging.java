package com.bb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bb.dto.CorporationDto;
import com.bb.dto.MemberDto;
import com.bb.dto.Paging;
import com.bb.model.biz.AdminCorpBiz;
import com.bb.model.biz.AdminMemberBiz_paging;



@WebServlet("/paging.do")
public class pagingcontroller_paging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public pagingcontroller_paging() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		//System.out.println("<"+command+">");
        AdminMemberBiz_paging mbiz = new AdminMemberBiz_paging(); 
        AdminCorpBiz cbiz = new AdminCorpBiz();
        
		if(command.equals("memberlist")) {
			//main에서 현재 페이지 수를 받아온다.
			int curPage = Integer.parseInt(request.getParameter("curPage"));
			// 전체 페이지 수를 받아온다. 
			int totalCount = mbiz.getMemberTotal();
			// 한 페이지에 보일 게시글 수 
			int countList = 6;  
			
			// 위에 두 변수로 시작 게시글 번호와 끝 게시글 번호를 계산한다. 
			Paging pg = new Paging();
			
			// 게시판에 보이는 게시글의 첫번째부터 마지막(1~5, 6~10..)
			int startCount = (curPage -1) * countList + 1;
			int endCount = curPage * countList;
			
		//	System.out.println("startCount(컨트):"+startCount);
		//	System.out.println("endCount(컨트):"+endCount);
		//	System.out.println("totalCount(컨트):"+totalCount);
			// 두 번호 사이의 모든 게시글을 가져온다.
			List<MemberDto> list = mbiz.memberList(startCount, endCount);
		//	System.out.println("list값(controller)"+list);
			// 현재 페이지, 가져온 게시글, 전체 게시글 수를 request에 담는다. 
			request.setAttribute("curPage", curPage);
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("list", list);
			
			dispatch("admin_memberlist_paging.jsp",request, response);
			
			
		}else if(command.equals("corporationlist")){
			//현재페이지(main에서 받아옴)
			int curPage = Integer.parseInt(request.getParameter("curPage"));
			
			//전체 페이지 수 
			int totalCount = cbiz.getCorporationTotal();
			//한 페이지에 보일 게시글 수 
			int countList = 6;
			Paging pg = new Paging();
			
			// 게시판에 보이는 게시글의 첫번째 부터 마지막(1~6, 7~12), curPage 현재 페이지가 페이징 그룹 1, 2를 뜻하는 것 같다.(현재 보이는 페이지가 아니라) 
			int startCount = (curPage -1) * countList +1;
			int endCount = curPage * countList;
			List<CorporationDto> list = cbiz.corporationList(startCount, endCount);
			
			request.setAttribute("curPage", curPage);
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("list", list);
			
			dispatch("admin_corporationlist.jsp", request, response);
		}else if(command.equals("admin_main")) {
			response.sendRedirect("adminmain.jsp");
		}


		
	}
	
	//알림창 뜨고 페이지 이동시키는 메소드
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String result = ("<script>alert('"+msg+"'); location.href=\""+url+"\"; </script>");
		response.getWriter().append(result);
		
	}
	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
}
