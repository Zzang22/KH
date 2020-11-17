<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bb.dto.Interest_JobDto"%>
<%@page import="com.bb.model.biz.CalendarBiz"%>
<%@page import="com.bb.dto.MemberDto"%>
<%@page import="com.bb.dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.Integer"%>
<%@page import="com.bb.model.dao.CalendarDao"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style type="text/css">
		@import url("resources/css/calendar.css");
	#cal{padding-bottom: 350px;}
	#content> h3{
	 position: relative;
	 font-size: 20pt;
	 left: 50px;
	 top: 50px;
	}
</style>
<link href='https://fonts.googleapis.com/css?family=Noto+Sans+KR' rel='stylesheet' type='text/css'>


</head>
<%
	Calendar cal = Calendar.getInstance();

	int year = cal.get(Calendar.YEAR); // year에 calaendar class에서 year의 int값을 가져왔다. year는 field 
	int month = cal.get(Calendar.MONTH) + 1; // month의 int 값을 가져왔는데, 이때 month field가 0부터 시작해서 11까지 이므로 +1을 해준다. 

	String paramYear = request.getParameter("year"); // param이 영어 뜻으로 매개변라는 뜻. 이 값을 문자열로 가져와서 받아주고
	String paramMonth = request.getParameter("month");

	if (paramYear != null) { // year의 값이 null이 아니라면 
		year = Integer.parseInt(paramYear); // year에 다시 string을 int로 파싱 해준다. 
	}
	if (paramMonth != null) {
		month = Integer.parseInt(paramMonth); // month에 다시 paramMonth안에 있는 string 값을 int로 파싱 해준다. 
	}
	if (month > 12) { // month가 12 이상이면 13이 되면 다시 1월부터 시작 year는 ++ 해준다. 위에 부분 만들어 준다. 
		month = 1;
		year++;
	}
	if (month < 1) {
		month = 12;
		year--;
	}
	CalendarBiz calbiz = new CalendarBiz();

	// 현재 년도, 현재월, 해당 월의 1일   
	cal.set(year, month - 1, 1);

	// 1일의 요일
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	// 현재 월의 마지막 일
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	// 달력에 일정 표현 
	CalendarDao dao = new CalendarDao();

	String yyyyMM = year + calbiz.isTwo(month + "");
	 

	//login에서 member_no 가져오기
	int member_no = Integer.parseInt(request.getParameter("member_no"));
	//System.out.println("member_no확인:"+ member_no);
	//int member_no = 784;//Integer.parseInt(request.getParameter("member_no"));  //잡았다 요놈.파라미터든 setAttribute든 다 안됌. 여기서 생성해야함.
	List<CalendarDto> clist = calbiz.calendarViewList(member_no, yyyyMM); //member_no를 넣으면 해당 회원의 일정이 리스트로 나온다.
	//System.out.println("Calendar확인:"+yyyyMM);
	//즐겨찾기한 기업 deadline 가져오기
	List<Interest_JobDto> ilist = calbiz.interestJobDeadline(member_no);


%>
<body>
<%@ include file="./form/nav_user.jsp" %>


	<table id="calendar">
		<caption>
		<div class="content" style="position: relative; left: -400px; top: 50px; color:black; font-size: 13pt;">
  			<h3>개인 회원 >> 일정 관리</h3>
		</div>
		<div id="header">
			<a href="Calendar.jsp?&member_no=<%=member_no %>&year=<%=year - 1%>&month=<%=month%>"> 
				<img alt="prev_year_month" src="resources/images/left-triangle2.png" style="width: 35px; height: 35px; position:relaive; top:-30px;" />	
			</a> 
			&nbsp;
			<a href="Calendar.jsp?member_no=<%=member_no %>&year=<%=year%>&month=<%=month - 1%>"> 
			<img alt="prev_month" src="resources/images/left-triangle2.png" style="width: 35px; height: 35px; position:relaive; top:-30px;" />
			</a> 
			
			 	<span class="y"><%=year%>년 </span> 
				<span class="m"><%=month%>월</span>	
		
			<a href="Calendar.jsp?member_no=<%=member_no %>&year=<%=year%>&month=<%=month + 1%>"> 
				<img alt="next_month" src="resources/images/right-triangle2.png" style="width: 35px; height: 35px; position:relaive; top:-30px;" />
			</a> 
			&nbsp;
			<a href="Calendar.jsp?member_no=<%=member_no %>&year=<%=year + 1%>&month=<%=month%>"> 
				<img alt="next_month" src="resources/images/right-triangle2.png" style="width: 35px; height: 35px; position:relaive; top:-30px;" />
			</a>
		  </div>
		</caption>

		<tr id="dayOf">
			<th>Sun</th>
			<th>Mon</th>
			<th>Tue</th>
			<th>Wed</th>
			<th>Thu</th>
			<th>Fri</th>
			<th>Sat</th>
		</tr>
	
		<tr class="day">
			<%
				for (int i = 0; i < dayOfWeek - 1; i++) { //dayOfWeek : 1일의 요일
				out.print("<td>&nbsp;</td>"); //공백
			}
			for (int i = 1; i <= lastDay; i++) { //lastDay : 해당 월의 마지막 일
				
				
			%>
			<td>
				<a class="countView" style="color:<%=calbiz.fontColor(i, dayOfWeek)%>" href="CalendarController.do?command=list&year=<%=year%>&month=<%=month%>&date=<%=i%>&member_no=<%=member_no%>"><%=i%></a>

				<a href="calendar_insert.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastDay=<%=lastDay%>&member_no=<%=member_no%>">
					<img alt="일정추가" src="resources/images/calendar.png" style="width: 20px; height: 20px; position:relative; top:10px; left: 10px;" />
				</a>

				<div id="clist"><!-- 등록한 일정 제목 표시 -->
					<%=calbiz.getCalView(i, clist)%>
				</div>
			<%
			//즐겨찾기한 기업공고의 deadline 표시하기
			for(Interest_JobDto dto : ilist){
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
				String deadline = transFormat.format(dto.getJo_deadline());
				//System.out.println("cal-deadline확인:"+deadline);
				String deadlineyy = deadline.substring(0,6);
			//	System.out.println("daadline확인:"+deadlineyy);
				if(deadlineyy.equals(yyyyMM)){
					
			%>
				<div id="ilist"><!-- deadline 표시 -->
					<%=calbiz.getDeadline(i, ilist,yyyyMM)%>
				</div>
<%
				 }
			}
	
%>				
			</td>

<%
				if ((dayOfWeek - 1 + i) % 7 == 0) { // 1일의 요일 - 1+ 요일 인덱스가 1부터 시작하니까 1을 빼고 date를 더한 숫자에서 일주일 간격으로 줄바꿈 해주고, 해당날짜의 요일을 말한다. 
					out.print("<tr></tr>");
					}
				
			}	
			for (int i = 0; i < (7 - (dayOfWeek - 1 + lastDay) % 7) % 7; i++) {
				out.print("<td>&nbsp;</td>"); // 공백
			}
%>
		 </tr>
<%
 
%>

	</table>
	<div id="cal">
	</div>
<script>
 $(function(){
	$(".countView").hover(function(){
	      var aCountView = $(this);
	      var year = $(".y").text().trim();
	      var month = $(".m").text().trim();
	      var cDate = aCountView.text().trim();
	      var member_no = "<%=request.getParameter("member_no")%>";
	      var yyyyMMdd = year + isTwo(month) + isTwo(cDate);
	      var MMdd = isTwo(month) + isTwo(cDate)+"일";
					$.ajax({
						type : "POST",
						url : "CalCountAjax.do",
						data : "member_no=" + member_no + "&yyyyMMdd="+ yyyyMMdd, 
						dataType : "json",
						success : function(msg) {
							var count = msg.calCount;
							var parameter_noti = {
									title:MMdd+'[일정관리]',
									icon:"resources/images/schedule.png",
									body:'등록된 일정이 "'+count+'" 개 있습니다.'+'날짜를 클릭해 일정을 확인해보세요.'
								  };
							//알람 기능
						  if(count > 3){	
							if (!"Notification" in window) {
							    alert("이 브라우저는 'desktop notification(알림이벤트)'를 허용하지 않습니다.");
							  }
							  else if (Notification.permission === "granted") {
							    var notification = new Notification(parameter_noti.title,{
							    	icon:parameter_noti.icon,
							    	body:parameter_noti.body
							    });
							  }
							  // 사용자가 Notification 사용을 허락했는지 체크합니다.
							  else if (Notification.permission !== 'denied') {
							    Notification.requestPermission(function (permission) {
							      if(!('permission' in Notification)) {
							        Notification.permission = permission;
							      }
							      if (permission === "granted") {
							    	  // 허락했다면 Notification을 생성합니다.
							        var notification = new Notification(parameter_noti.title,{
							        	icon:parameter_noti.icon,
							        	body:parameter_noti.body
							        });
							      }
							    });
							  }
							setTimeout(notification.close.bind(notification), 4000);
						//	aCountView.after("<div class='cPreview'>" + count+ "</div>");
						  }
						},
						error : function() {
							alert("서버 통신 실패");
						}
					});

				}, function() {
					$(".cPreview").remove();
				});
	});

	function isTwo(n) {
		return (n.length < 2) ? "0" + n : n;
	}
	
	setInterval(function(){
		$(".blink").toggle();
	},700);
</script>	

         <jsp:include page="chat/chat_aside.jsp"></jsp:include>

	
<%@ include file="./form/footer.jsp" %>	
</body>
</html>