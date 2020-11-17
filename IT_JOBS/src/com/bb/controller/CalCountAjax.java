package com.bb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bb.dto.Interest_JobDto;
import com.bb.dto.MemberDto;
import com.bb.model.biz.CalendarBiz;
import com.bb.model.dao.CalendarDao;


import net.sf.json.JSONObject;

@WebServlet("/CalCountAjax.do")
public class CalCountAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CalCountAjax() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		
	    int member_no = Integer.parseInt(request.getParameter("member_no"));
	    String yyyyMMdd = request.getParameter("yyyyMMdd");  // 값이 갑자기 년과 월이 붙어서 넘어오게 됨.. trim이 되지 않음, css하면서 이상해짐..
	  //  System.out.println("ajax-member_no : "+ member_no);
	    System.out.println("ajax-yyyyMMdd : "+yyyyMMdd);
	  //값이 년,월,일이 붙어서 넘어와서 다 잘랐다. 
	    CalendarBiz calbiz = new CalendarBiz();
	    if(yyyyMMdd.length()>9) {
	    	//MM (월)이 두글자일 때(11,12월)
	    	String yyyy = yyyyMMdd.substring(0, 4);
	    	String MM = yyyyMMdd.substring(5, 7);
	    	String dd = yyyyMMdd.substring(8, 10);
	    	System.out.println("ajax-두글자확인:"+MM+dd);
	    	yyyyMMdd = yyyy+ MM + dd;
	    	System.out.println("ajax-두글자 확인:"+yyyyMMdd);
	    	
	    }else {
	    	// MM (월)이 한글자일 때(1~9월)
	    	String yyyy= yyyyMMdd.substring(0, 4);
	 	    String MM = yyyyMMdd.substring(5,6);
	 	    String dd = yyyyMMdd.substring(7, 9);
	 	   // System.out.println("ajax-한글자 확인:"+MM + dd);
	 	    yyyyMMdd = yyyy+ calbiz.isTwo(MM+"") + dd;
	 	   // System.out.println("ajax-한글자 확인:"+yyyyMMdd);
	    }
	    
	    
	  /*  
	    String yyyy= yyyyMMdd.substring(0, 4);
	    String MM = yyyyMMdd.substring(5,6);
	    String dd = yyyyMMdd.substring(7, 9);
	    System.out.println("ajax-mmdd확인:"+MM + dd);
	    yyyyMMdd = yyyy+ calbiz.isTwo(MM+"") + dd;
	    System.out.println("ajax-yyyyMMdd확인:"+yyyyMMdd);
	    */
	    //System.out.println("최종ajax-yyyyMMdd:"+yyyyMMdd);
	    int count = calbiz.calendarViewCount(member_no, yyyyMMdd); //해당일에 몇개가 있는지 알려준다
	    //System.out.println("ajaxcontroller-일정 갯수 : "+ count); //여기까지 왔다. 근데 이 값이 잘못됐다..
	    List<Interest_JobDto> dto = calbiz.interestJobDeadline(member_no);
	 
	    
	    Map<String, Integer> map = new HashMap<String, Integer>();  
	    //원래 Map<String, Integer> map = new HashMap<String, Integer>();
	    map.put("calCount",count);
	  //  System.out.println("map확인:"+map);
	    // map을 json 객체로 변환
	    JSONObject obj = JSONObject.fromObject(map);
	    //응답할 객체에 값 저장할 준비
	    PrintWriter out = response.getWriter();
	    //json객체에 구현되어 있는 write 메소드를 사용하여
	    //json객체를 응답 
	    obj.write(out);
	   // System.out.println("obj:"+obj);
	}

}