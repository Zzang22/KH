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

import com.bb.dto.CalendarDto;
import com.bb.dto.MemberDto;
import com.bb.model.biz.CalendarBiz;

@WebServlet("/CalendarController.do")
public class CalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CalendarController() {
    

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
		CalendarBiz calbiz = new CalendarBiz();
		
		
		if(command.equals("schedule")) {
			MemberDto login = (MemberDto) request.getSession().getAttribute("login");
			request.setAttribute("login", login);
			int member_no = login.getMember_no();
		//	System.out.println("Controller-login확인 :"+member_no);
			dispatch("Calendar.jsp?member_no="+member_no, request,response);		
			
		}else if(command.equals("insertcal")) {
//----------------일정추가--------------------------------------------------			
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			String hour = request.getParameter("hour");
			String min = request.getParameter("min");
			// 202009202227 , 한자리 숫자가 들어오면 두자리 숫자로 바꿔준다. 
			String cal_mdate = year + calbiz.isTwo(month) + calbiz.isTwo(date) + calbiz.isTwo(hour) + calbiz.isTwo(min);
		//	System.out.println("cal_mdate확인 :" + cal_mdate);
			
			int member_no = Integer.parseInt(request.getParameter("member_no"));
			//System.out.println("member_no확인 : "+member_no);
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			CalendarDto dto = new CalendarDto(0,member_no, title, content, cal_mdate, null);
			
			int res = calbiz.insertCalBoard(dto);
			if(res>0) {
				response.sendRedirect("CalendarController.do?command=schedule"); //왜 이건 되고, jsResponse는 안될까..?
			}else {
				request.setAttribute("msg","일정 추가 실패" );
				dispatch("calendar_error.jsp", request, response);
			}
		}else if(command.equals("list")) {
//--------------------------리스트(근데 detail에서 list로 바로 못옴.. list로 오려면 year, month, date, member_no  다 가져와야해서...바로 못옴.. 방법 생각해보겠음...--------------			
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			String yyyyMMdd = year + calbiz.isTwo(month) + calbiz.isTwo(date);
			int member_no = Integer.parseInt(request.getParameter("member_no"));
			//System.out.println("member_no확인 : "+member_no);
			
			List<CalendarDto> list = calbiz.selectCalendarList(yyyyMMdd, member_no);
			request.setAttribute("list", list);
			dispatch("calendar_list.jsp", request, response);
			
		}else if(command.equals("detail")) {
//------------------날짜 누르면 등록된 list로 넘어가는데 그때 등록된 일정들 세부사항 보는거. selectOne------------------------------------------			
			int cal_no = Integer.parseInt(request.getParameter("cal_no"));
			//System.out.println("controller-cal_no확인:"+cal_no);
			CalendarDto dto = calbiz.selectOneBoard(cal_no);
			request.setAttribute("dto", dto);
			dispatch("calendar_detail.jsp",request,response);
		}else if(command.equals("muldel")) {
//--------------------------------체크한거 삭제하기-----------------------------			
			String[] cal_nos = (String[])request.getParameterValues("chk"); // getParameterValues!!
			int res = calbiz.multiDelete(cal_nos);
			if(res == cal_nos.length) {
				// 모두 삭제 되었다.
				jsResponse("선택된 글들을 삭제 완료하였습니다.", "CalendarController.do?command=schedule",response);
			}else {
				jsResponse("삭제 실패하였습니다.","CalendarController.do?command=schedule",response);
			}
		}else if(command.equals("updateCalendar")) {
			int cal_no = Integer.parseInt(request.getParameter("cal_no"));
		    CalendarDto dto = calbiz.selectOneBoard(cal_no);
		    request.setAttribute("dto", dto);
		    dispatch("calendar_update.jsp",request, response);
		}else if(command.equals("updateCalendarRes")) {
			int cal_no = Integer.parseInt(request.getParameter("cal_no"));
			String cal_title = request.getParameter("cal_title");
			String cal_content = request.getParameter("cal_content");
			CalendarDto dto = new CalendarDto(cal_no, cal_title, cal_content);
			int res = calbiz.updateCalendar(dto);
			
			if(res>0) {
				jsResponse("수정 성공!!", "CalendarController.do?command=detail&cal_no="+cal_no, response);
			}else {
				jsResponse("수정실패 ㅠㅠ", "CalendarController.do?command=updateCalendar&cal_no="+cal_no,response);
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

