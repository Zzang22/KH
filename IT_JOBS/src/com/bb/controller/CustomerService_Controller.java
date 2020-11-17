package com.bb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bb.dto.CustomerServiceDto;
import com.bb.dto.MemberDto;
import com.bb.model.biz.AdminCsBiz;


@WebServlet("/CustomerService.do")
public class CustomerService_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CustomerService_Controller() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		//System.out.println("["+command+"]");
		HttpSession session = request.getSession();
		AdminCsBiz csbiz = new AdminCsBiz();
		
		if(command.equals("csboard")) {
//---------------고객센터 들어갔을 때 --------			

			response.sendRedirect("csboard.jsp");
			
		}else if(command.equals("plus_csboard")) {
//-----------------더 많은 안내사항 확인하는 페이지 넘어갔을 떼-------------			
			List<CustomerServiceDto> list = csbiz.listBoard();
			request.setAttribute("list", list);
		
			dispatch("plus_csboard.jsp", request, response);

		}else if(command.equals("insert")) {
//------------------글작성 버튼 눌렀을 때 admin만 화면 넘어가기---------------		
			MemberDto login = (MemberDto)session.getAttribute("login");
			
			if(login == null) {
				jsResponse("먼저 로그인 해주세요.","loginpopup.jsp",response);
			}else {
				String member_role = login.getMember_role();
				System.out.println("member_role확인:"+member_role);
				if(member_role.equals("USER")) {
					jsResponse("관리자만 가능합니다.", "CustomerService.do?command=plus_csboard",response);
				}else if(member_role.equals("CORP")) {
					jsResponse("관리자만 가능합니다.", "CustomerService.do?command=plus_csboard",response);
				}else if(member_role.equals("ADMIN")) {
					response.sendRedirect("csboard_insert.jsp");
				}
			}
		}else if(command.equals("insertres")) {
//-----------------------관리자가 공지 작성하는 페이지-----------			
			String cs_title = request.getParameter("cs_title");
			String cs_content = request.getParameter("cs_content");
			CustomerServiceDto dto = new CustomerServiceDto(cs_title,cs_content);
			//System.out.println("cs_title값확인: "+cs_title+"cs_content확인:"+ cs_content);
			int res = csbiz.insert(dto);
			//System.out.println("res값전달: "+res);
			if(res>0) {
				jsResponse("공지 작성 성공!", "CustomerService.do?command=plus_csboard",response);
			}else {
				jsResponse("공지 작성 실패 ㅜㅜ","CustomerService.do?command=insert",response);
			}
//------------------------selectOne-------------------------------			
		}else if(command.equals("detail")) {
			int cs_no = Integer.parseInt(request.getParameter("cs_no"));
			
			CustomerServiceDto dto = csbiz.selectOne(cs_no);
			request.setAttribute("dto", dto);
		//	System.out.println("debug확인-controller:"+dto);
			dispatch("csboard_detail.jsp", request, response);
			
		}else if(command.equals("update")) {
//-----------------------수정버튼 눌렀을 때 값 넘어온거-----------			
			int cs_no = Integer.parseInt(request.getParameter("cs_no"));
			//로그인 정보 가져오기
			MemberDto login = (MemberDto)session.getAttribute("login");
			
			if(login == null) {
				jsResponse("먼저 로그인 해주세요.","loginpopup.jsp",response);
			}else {
				String member_role = login.getMember_role();
				if(member_role.equals("USER")) {
					jsResponse("관리자만 가능합니다.", "CustomerService.do?command=detail&cs_no="+cs_no,response);
				}else if(member_role.equals("CORP")) {
					jsResponse("관리자만 가능합니다.", "CustomerService.do?command=detail&cs_no="+cs_no,response);
				}else if(member_role.equals("ADMIN")) {
					CustomerServiceDto dto = csbiz.selectOne(cs_no);
					request.setAttribute("dto", dto);
					dispatch("csboard_update.jsp",request, response);
				}
			}

		}else if(command.equals("updateres")) {
			int cs_no = Integer.parseInt(request.getParameter("cs_no"));
			String cs_title = request.getParameter("cs_title");
			String cs_content = request.getParameter("cs_content");
			CustomerServiceDto dto = new CustomerServiceDto(cs_no, cs_title, cs_content);
			int res = csbiz.update(dto);
			//System.out.println("res값 확인 : "+ res);
			
			if(res>0) {
				jsResponse("수정 성공!!", "CustomerService.do?command=detail&cs_no="+cs_no, response);
			}else {
				jsResponse("수정 실패 ㅠㅠ", "CustomerService.do?command=update&cs_no="+cs_no, response);
			}
			
		}else if(command.equals("delete")) {
			int cs_no = Integer.parseInt(request.getParameter("cs_no"));
			//login 정보 가져오기
			MemberDto login = (MemberDto)session.getAttribute("login");
			
			if(login == null) {
				jsResponse("먼저 로그인 해주세요.","loginpopup.jsp",response);
			}else {
				String member_role = login.getMember_role();
				if(member_role.equals("USER")) {
					jsResponse("관리자만 가능합니다.", "CustomerService.do?command=detail&cs_no="+cs_no,response);
				}else if(member_role.equals("CORP")) {
					jsResponse("관리자만 가능합니다.", "CustomerService.do?command=detail&cs_no="+cs_no,response);
				}else if(member_role.equals("ADMIN")) {
					int res = csbiz.delete(cs_no);
					if(res>0) {
						jsResponse("삭제 성공", "CustomerService.do?command=plus_csboard", response); // 처음에는 cs_no안보내본다.
					}else {
						jsResponse("삭제 실패", "CustomerService.do?command=detail&cs_no="+cs_no, response);
					}		
				}
			}
		}
	}

	
	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

	// alert 찍기
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter(); 							
		String res = "<script>alert('"+msg+"'); location.href='"+url+"';</script>";
		
		out.print(res);
	}
}