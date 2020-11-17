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

import com.bb.dto.ChatDto;
import com.bb.dto.ChatRoomDto;
import com.bb.dto.ChatUserDto;
import com.bb.dto.MemberDto;
import com.bb.dto.OpenChatDto;
import com.bb.model.biz.ChatBiz;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
    	
    	String command = request.getParameter("command");
		System.out.println("["+command+"]");

    	
    	ChatBiz biz = new ChatBiz();
    	
    	HttpSession httpSession = request.getSession();
    	
    	
    	if(command.equals("open_chat")) {
    		MemberDto login = (MemberDto)httpSession.getAttribute("login");
    		
    		List<OpenChatDto> list = biz.selectOpenChatList(login.getMember_no());
    		request.setAttribute("list", list);
    		dispatch("chat/open_chat.jsp", request, response);
    		
    	} else if(command.equals("my_chat")) {
    		
    		MemberDto login = (MemberDto) httpSession.getAttribute("login");
    		int member_no = login.getMember_no();
    		
    		List<ChatRoomDto> list = biz.selectMyChatList(member_no);
    		request.setAttribute("list", list);
    		
    		dispatch("chat/my_chat.jsp", request, response);
    		
    	} else if(command.equals("chat_room")) {
    		int member_no = Integer.parseInt(request.getParameter("member_no"));
    		int chat_room_no = Integer.parseInt(request.getParameter("chat_room_no"));
    		ChatUserDto dto = new ChatUserDto(chat_room_no, member_no);
    		
    		String chat_room_name = request.getParameter("chat_room_name");
    		
    		List<ChatDto> list = biz.selectChatContentList(dto);
    		int user_count = biz.selectUserCount(chat_room_no);
    		
    		request.setAttribute("chat_list", list);
    		request.setAttribute("chat_room_name", chat_room_name);
    		request.setAttribute("user_count", user_count);
    		request.setAttribute("chat_room_no", chat_room_no);
    		
    		dispatch("chat/chat_room.jsp", request, response);
    	
    	} else if(command.equals("insert_room")) {
    		String chat_room_name = request.getParameter("chat_room_name");
    		MemberDto login = (MemberDto)httpSession.getAttribute("login");
    		int member_no = login.getMember_no();

    		OpenChatDto dto = new OpenChatDto();
    		
    		dto.setChat_room_name(chat_room_name);
    		dto.setMember_no(member_no);
    		
    		int chat_room_no = biz.insertRoom(dto);
    		if(chat_room_no>0) {
    			String str = "ChatServlet?command=chat_room&chat_room_no="+chat_room_no+"&chat_room_name="+chat_room_name+"&member_no="+member_no;
    			dispatch(str , request, response);
    		} else {
    			System.out.println("db저장 실패 + "+chat_room_no); // alert('서버와 통신에 실패했습니다.');
    		}
    		
    	} else if(command.equals("insert_room_href")) {
    		response.sendRedirect("chat/insert_room.jsp");
    	
    	} else if(command.equals("get_room")) {
    		MemberDto login = (MemberDto)httpSession.getAttribute("login");
    		int member_no = login.getMember_no();
    		int chat_room_no = Integer.parseInt(request.getParameter("chat_room_no"));
    		
    		ChatUserDto dto = new ChatUserDto(chat_room_no, member_no);
    		String chat_room_name = request.getParameter("chat_room_name");
    		
    		if(biz.insertOpenChatUser(dto)>0) {
    			String str = "ChatServlet?command=chat_room&chat_room_no="+chat_room_no+"&chat_room_name="+chat_room_name+"&member_no="+member_no;
    			dispatch(str , request, response);
    			
    		} else {
    			jsResponse("서버와 연결에 실패했습니다.", "ChatServlet?command=open_chat", response);
    		}
    	} else if(command.equals("leave_chat_room")) {
    		MemberDto login = (MemberDto) httpSession.getAttribute("login");
    		int member_no = login.getMember_no();
    		int chat_room_no = Integer.parseInt(request.getParameter("chat_room_no")); 
    		ChatUserDto dto = new ChatUserDto(chat_room_no, member_no);
    		
    		if(biz.deleteUser(dto)>0) {
    			response.sendRedirect("ChatServlet?command=my_chat");
    		} else {
    			jsResponse("서버와 연결에 실패했습니다.", "ChatServlet?command=my_chat", response);
    		}
    	
    	} else if(command.equals("count_member")) {
    		int chat_room_no = Integer.parseInt(request.getParameter("chat_room_no"));
    		int res = biz.selectUserCount(chat_room_no);
    		response.getWriter().print(res);
    	}
    	
    		
    		
	}

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter(); 							
		out.print("<script>alert('"+msg+"'); location.href='"+url+"';</script>");
	}
}
