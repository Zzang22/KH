package com.bb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bb.dto.CorporationDto;
import com.bb.dto.MemberDto;
import com.bb.dto.MemberDto_ForCorp;
import com.bb.model.dao.CorporationDao;

@WebServlet("/Corp_Controller")
public class Corp_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		CorporationDao dao = new CorporationDao();
		
		
		
//-----------<기업 회원가입 페이지로 이동>----------------------------		
		if(command.equals("join")) {
			response.sendRedirect("corp_join.jsp");
//----------<기업회원 아이디 중복확인>---------------------------------
		}else if(command.equals("corp_idchk")) {
			String member_id = request.getParameter("member_id");
			//request.setAttribute("member_id", member_id);
			//int res = dao.CorpidCheck(member_id);
			
			Integer res = dao.CorpidCheck(member_id);
			res = res == null? 0: res;
		
			boolean idnotused = true;
			if(res>0) {
				idnotused = false;
			}else {
				idnotused = true;
			}

			System.out.println(idnotused);
			
			response.sendRedirect("corp_idchk.jsp?idnotused="+idnotused);
			
//------------<기업회원 가입 양식 페이지 01>-----------------------------------------			
		}else if(command.equals("corp_join_01")) {
			//받은 정보들 dao로 보내고, 다시 결과 중 member_no받아서 form태그 안에 hidden으로 넣기
			//member_no, member_id, member_pw, member_name, member_postcode, member_addr, member_phone, member_email
			String member_id = request.getParameter("member_id");
			String member_pw = request.getParameter("member_pw");
			String member_name = request.getParameter("member_name");
			String member_postcode = request.getParameter("member_postcode");
			String member_addr = request.getParameter("member_addr");
			String member_phone = request.getParameter("member_phone");
			String member_email = request.getParameter("member_email");
			
			CorporationDto dto = new CorporationDto(0,member_id, member_pw, member_name,member_postcode, member_addr, member_phone,
					member_email,null,null);
			
			int res = dao.CorpJoinInsertPartOne(dto);
			if(res>0) {
				jsResponse("다음페이지를 작성해주세요", "corp.do?command=join02&member_id="+member_id, response);
			}else {
				jsResponse("전송실패", "corp.do?command=join", response);
			}
			
//------------<기업회원 가입양식02 페이지로 이동>------------------------------------------------------			
		}else if(command.equals("join02")) {
			String member_id = request.getParameter("member_id");
			request.setAttribute("member_id", member_id);
			dispatch("corp_join_02.jsp", request, response);
				
//------------<사업자번호 중복확인>----------------------------------------------------------		
		}else if(command.equals("b_nochk")) {
			
			String corp_businessno = request.getParameter("corp_businessno");
			Integer res = dao.CorpB_NoCheck(corp_businessno);
			
			res = res == null? 0: res;
		
			boolean b_no_notused = true;
			if(res>0) {
				b_no_notused = false;
			}else {
				b_no_notused = true;
			}

			System.out.println(b_no_notused);
			
			response.sendRedirect("corp_bnochk.jsp?b_no_notused="+b_no_notused);
			
//----------<기업회원가입 양식 02>---------------------------------------------
		}else if(command.equals("corp_join_02")) {
		//corp_businessno,corp_ceo_name,corp_board_name,corp_countemp
			String member_id_before_substring = request.getParameter("member_id");
			System.out.println("member_id : " + member_id_before_substring);
			String member_id = member_id_before_substring.substring(0, member_id_before_substring.length()-1);
			System.out.println("member_id after substring : " + member_id);
			int corp_businessno = Integer.parseInt(request.getParameter("corp_businessno"));
			String corp_ceo_name = request.getParameter("corp_ceo_name");
			String corp_board_name = request.getParameter("corp_board_name");
			String corp_countemp = request.getParameter("corp_countemp");
			
			CorporationDto dto = new CorporationDto(member_id,corp_businessno, corp_ceo_name, corp_board_name, corp_countemp);
			int res = dao.CorpJoinInsertPartTwo(dto);
			if(res>0) {
				jsResponse("가입이 완료되었습니다.", "index.jsp", response);
			}else {
				jsResponse("가입정보 전송 실패!", "corp.do?command=join02", response);
			}
			
//--------------<기업정보 수정 페이지>----------------------------------------------------
		}else if(command.equals("corp_modify")) {
			//MEMBER_ID, MEMBER_PW, MEMBER_NAME, CORP_CEO_NAME, CORP_BOARD_NAME,
		  	//CORP_BUSINESSNO, MEMBER_POSTCODE, MEMBER_ADDR, MEMBER_PHONE, MEMBER_EMAIL
			
			
			//SELECT MEMBER_ID, MEMBER_PW, MEMBER_NAME, CORP_CEO_NAME, CORP_BOARD_NAME,
		  	//CORP_BUSINESSNO, MEMBER_POSTCODE, MEMBER_ADDR, MEMBER_PHONE, MEMBER_EMAIL
		  	//FROM MDBOARD JOIN CORPORATION USING(MEMBER_ID)
		  	//WHERE MEMBER_ID = #{member_id}
			
			MemberDto login = (MemberDto)request.getSession().getAttribute("login");
			String member_id = login.getMember_id();
			CorporationDto dto = dao.ShowCorpInfo(member_id);
			System.out.println("멤버아이디"+login.getMember_id());
			request.setAttribute("dto", dto);
			dispatch("corp_modify.jsp", request, response);
			
			
		}else if(command.equals("corp_modify_res")) { 
			//member_pw,member_name, member_postcode, member_addr, member_phone, member_email,member_id
			String member_id = request.getParameter("member_id");
			String member_pw = request.getParameter("member_pw");
			String member_name = request.getParameter("member_name");
			String corp_ceo_name = request.getParameter("corp_ceo_name");
			String corp_board_name = request.getParameter("corp_board_name");
			String member_postcode = request.getParameter("member_postcode");
			String member_addr = request.getParameter("member_addr");
			String member_phone = request.getParameter("member_phone");
			String member_email = request.getParameter("member_email");
			
			
			CorporationDto dto = new CorporationDto(member_id, member_pw, member_name, corp_ceo_name, corp_board_name, member_postcode, member_addr, member_phone, member_email);
			int res = dao.CorpInfo_Update(dto);
			//CorporationDto dto = new CorporationDto(member_id, member_pw, member_name, null, null, member_postcode, member_addr, member_phone, member_email);
			//int res = dao.CorpInfo_Update(dto);
			CorporationDto dto2 = new CorporationDto(member_id, null, null, corp_ceo_name, corp_board_name, null, null, null, null);
			int res2 = dao.CorpInfo_Update02(dto2);
			if(res>0 && res2>0) {
				jsResponse("수정 성공", "corp_main.jsp", response);
			}else {
				jsResponse("수정 실패", "corp.do?command=corp_modify&member_id="+member_id, response);
			}
			// 로고 클릭 시 메인으로 이동 --------------------------------------------------------------------------------			
					}else if(command.equals("corp_main")) {
						response.sendRedirect("corp_main.jsp");

					}
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
