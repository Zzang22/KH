package com.bb.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bb.dto.AnswerBoardDto;
import com.bb.dto.MemberDto;
import com.bb.dto.UserBoardDto;
import com.bb.model.biz.AnswerBoardBiz;
import com.bb.model.biz.AnswerBoardBizImpl;
import com.bb.model.biz.UserBoardBiz;
import com.bb.model.biz.UserBoardBizImpl;
import com.sun.org.apache.bcel.internal.generic.JSR;

@WebServlet("/userboard.do")
public class UserBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");

		UserBoardBiz biz = new UserBoardBizImpl();
		AnswerBoardBiz answerbiz = new AnswerBoardBizImpl();

		HttpSession session = request.getSession();

		if (command.equals("userboard-list")) {

			List<UserBoardDto> user = biz.selectUserList();
			System.out.println(user);
			request.setAttribute("user", user);

			dispatch("userboard.jsp", request, response);

		} else if (command.equals("userboard-insert")) {
			MemberDto login = (MemberDto) session.getAttribute("login");

			if (login == null) {
				jsResponse("로그인이 필요합니다", "loginpopup.jsp", response);
			} else {

				response.sendRedirect("userboard-insert.jsp");
			}

		} else if (command.equals("userboard-detail")) {
			int userboard_no = Integer.parseInt(request.getParameter("userboard_no"));
			MemberDto login = (MemberDto) session.getAttribute("login");

			System.out.println(userboard_no);
			
			UserBoardDto userdto = biz.selectUserOne(userboard_no);
			List<AnswerBoardDto> answerdto = answerbiz.selectAnswerList(userboard_no);
			
			System.out.println(userdto + "userdto");
			
			request.setAttribute("userdto", userdto);
			request.setAttribute("answerdto", answerdto);

			dispatch("userboard-detail.jsp", request, response);

		} else if (command.equals("userboard-insertform")) {
			MemberDto login = (MemberDto) session.getAttribute("login");

			int member_no = Integer.parseInt(request.getParameter("member_no"));
			System.out.println(member_no);
			String userboard_title = request.getParameter("userboard_title");
			String userboard_content = request.getParameter("userboard_content");
			UserBoardDto userdto = new UserBoardDto();
			userdto.setMember_no(member_no);
			userdto.setUserboard_title(userboard_title);
			userdto.setUserboard_content(userboard_content);
			
			int user_res = biz.UserBoardInsert(userdto);
			System.out.println(user_res);
			if (user_res > 0) {
				jsResponse("userboard", "userboard.do?command=userboard-list", response);

			}
			jsResponse("게시글 작성에 실패하였습니다.", "userboard.do?command=userboard-insert", response);

		} else if (command.equals("userboard-update")) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			int member_no = Integer.parseInt(request.getParameter("member_no"));
			int userboard_no = Integer.parseInt(request.getParameter("userboard_no"));

			if (login == null) {
				jsResponse("로그인이 필요합니다", "loginpopup.jsp", response);
			} else if (login.getMember_no() != member_no) {
				jsResponse("수정 권한이 없습니다", "userboard.do?command=userboard-detail&userboard_no=" + userboard_no,
						response);
			} else {
				UserBoardDto userdto = biz.selectUserOne(userboard_no);
				request.setAttribute("userdto", userdto);
				dispatch("userboard-update.jsp", request, response);
			}
		} else if (command.equals("userboard-updateform")) {
			int userboard_no = Integer.parseInt(request.getParameter("userboard_no"));
			String userboard_title = request.getParameter("userboard_title");
			String userboard_content = request.getParameter("userboard_content");
			System.out.println(userboard_no);
			System.out.println(userboard_title);
			System.out.println(userboard_content);
			UserBoardDto userdto = new UserBoardDto();
			userdto.setUserboard_no(userboard_no);
			userdto.setUserboard_title(userboard_title);
			userdto.setUserboard_content(userboard_content);

			int user_res = biz.UserBoardUpdate(userdto);
			System.out.println(user_res);
			if (user_res > 0) {
				jsResponse("게시글 수정이 완료되었습니다.", "userboard.do?command=userboard-list", response);
			} else {
				jsResponse("게시글 수정을 실패하였습니다.", "userboard.do?command=userboard-detail&userboard_no=" + userboard_no, response);
			}

		} else if (command.equals("userboard-delete")) {
			int userboard_no = Integer.parseInt(request.getParameter("userboard_no"));
			int member_no = Integer.parseInt(request.getParameter("member_no"));
			MemberDto login = (MemberDto) session.getAttribute("login");

			if (login == null) {
				jsResponse("로그인이 필요합니다", "loginpopup.jsp", response);
			} else if (login.getMember_no() != member_no) {
				jsResponse("수정할 권한이 없습니다.", "userboard.do?command=userboard-detail&userboard_no=" + userboard_no,
						response);
			} else {

				int user_res = biz.UserBoardDelete(userboard_no);
				if (user_res > 0) {
					jsResponse("게시글 삭제가 완료되었습니다.", "userboard.do?command=userboard-list", response);
				} else {
					jsResponse("게시글 삭제를 실패하였습니다.", "userboard.do?command=userboard-detail&userboard_no=" + userboard_no,
							response);
				}
			}
//--------------------------------------------------------------AnswerBoard-----------------------------------------------------------
		}else if(command.equals("answer-insert")) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			System.out.println(login +"login");

			if (login == null) {
				jsResponse("로그인이 필요합니다", "loginpopup.jsp", response);
			}  else {
				int userboard_no = Integer.parseInt(request.getParameter("userboard_no"));
				System.out.println(userboard_no +"userboard_no");
				int member_no = login.getMember_no();
				System.out.println(member_no+"member_no");
				String answer_content = request.getParameter("answer_content");
				System.out.println(answer_content+"answer_content");
				AnswerBoardDto answerdto = new AnswerBoardDto();
				answerdto.setUserboard_no(userboard_no);
				answerdto.setMember_no(member_no);
				answerdto.setAnswer_content(answer_content);
				
				int user_res = answerbiz.AnswerInsert(answerdto);
				if(user_res>0) {
					jsResponse("댓글 작성이 완료되었습니다.", "userboard.do?command=userboard-detail&userboard_no=" + userboard_no, response);
				}else {
					jsResponse("댓글 작성을 실패하였습니다.", "userboard.do?command=userboard-detail&userboard_no=" + userboard_no, response);	
				}
			}
		}else if(command.equals("answer-update")) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			int userboard_no = Integer.parseInt(request.getParameter("userboard_no"));
			System.out.println(userboard_no+"useboard_no answer-update");
			String answer_content = request.getParameter("answer_content");
			System.out.println(answer_content+"answer_content user-update");
			
			
			AnswerBoardDto answerdto = new AnswerBoardDto();
			answerdto.setUserboard_no(userboard_no);
			answerdto.setAnswer_content(answer_content);
			
			int answer_res = answerbiz.AnswerUpdate(answerdto);
			if(answer_res>0) {
				jsResponse("댓글 수정이 완료되었습니다.", "userboard.do?command=userboard-detail&userboard_no=" + userboard_no, response);
			}else {
				jsResponse("댓글 수정을 실패하였습니다.", "userboard.do?command=userboard-detail&userboard_no=" + userboard_no, response);
			}
			
		}else if(command.equals("answer-delete")) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			int answer_no = Integer.parseInt(request.getParameter("answer_no"));
			int userboard_no = Integer.parseInt(request.getParameter("userboard_no"));
			
			int answer_res = answerbiz.AnswerDelete(answer_no);
			System.out.println(answer_res+"answer_res");
			if(answer_res>0) {
				jsResponse("댓글 삭제를 완료하였습니다.", "userboard.do?command=userboard-detail&userboard_no=" + userboard_no, response);
			}else {
				jsResponse("댓글 삭제를 실패하였습니다.", "userboard.do?command=userboard-detail&userboard_no=" + userboard_no, response);
			}
			
		}else if(command.equals("AnswerAnswerInsert")) {

	
		}

	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String result = "<script> alert(\"" + msg + "\"); location.href=\"" + url + "\"; </script> ";
		response.getWriter().append(result);
	}

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

}
