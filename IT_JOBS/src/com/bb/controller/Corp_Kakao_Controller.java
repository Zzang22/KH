package com.bb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bb.dto.MemberDto;
import com.bb.dto.MemberDto_ForCorp;
import com.bb.model.dao.CorporationDao;

@WebServlet("/Corp_Kakao_Controller")
public class Corp_Kakao_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		HttpSession session = request.getSession();
		CorporationDao dao = new CorporationDao();
		
//----------<결제 상품페이지>-----------------------------------------------------
		if(command.equals("premiumProduct")) {
			MemberDto login = (MemberDto)session.getAttribute("login");
			//String id = login.getMember_id();
			Integer corp_membership = dao.IsMemberShip(login.getMember_id());
			corp_membership = corp_membership == null? 0: corp_membership;
			System.out.println(login.getMember_id());
			System.out.println("디티오 : " + corp_membership);

			boolean membership = true;
			if(corp_membership>0) {
				membership = false;
			}else {
				membership = true;
			}

			request.setAttribute("login", login);
			request.setAttribute("corp_membership", corp_membership);
			request.setAttribute("membership", membership);
			dispatch("kakaoPay_main.jsp", request, response);
			
			
			
		}else if(command.equals("kakaopay")) {
			String member_id = request.getParameter("member_id");
			int cost = Integer.parseInt(request.getParameter("cost"));
			String product = request.getParameter("product");
			
			request.setAttribute("member_id", member_id);
			request.setAttribute("cost", cost);
			request.setAttribute("product", product);
			dispatch("kakaoPay.jsp", request, response);

//----<결제 후 멤버쉽 변경>---------------------------------------------------------------------------------------
		}else if(command.equals("pay_succeed")) {
			String member_id = request.getParameter("member_id");
			System.out.println("멤버아이디 컨트롤러 : " + member_id);
			int res = dao.ChangeMemberShip(member_id);
			System.out.println("컨트롤러 res : " + res);
			if(res>0) {
				response.sendRedirect("corp_main.jsp");
			}else {
				jsResponse("멤버쉽 구매 실패", "kakao.do?command=premiumProduct&member_id="+member_id, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispach = request.getRequestDispatcher(path);
		dispach.forward(request, response);
	}
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String res = "<script>alert('"+ msg +"'); location.href='" + url +"';</script>";
		out.print(res);
	}


}
