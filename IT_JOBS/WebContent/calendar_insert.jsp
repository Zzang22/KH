<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
	<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
	box-sizing: border-box;
	}
/*전체 배경색*/	
	body{
	background-color: #FAFAFA;
	color: #424242;
	}
	table{
	position: relative;
	left: 500px;
	top: 100px;
	border-bottom: 3px solid #dadada;
	}
.button> input{
	margin-top: 40px;
	width: 100px;
    height: 20px;
    background: #819FF7;
    border-style: none;
    color: white;
    font-size: 10pt;
    position: relative;
    left: 670px;
    top: 450px;
}
th{
	border-right: 1px solid #dadada;
}
 th, td {
 		border-top: 3px solid #dadada;
        padding: 10px;

      }
#wrap_title > h3{
	position: relative;
	left: 150px;
	top: 120px; 
	color: gray;
}      
#sub_title > h3{
	position: relative;
	left: 400px;
	top: 75px;
	color: green;
}
img{
	width: 50px;
	height: 50px;
	position: relative;
	top: 180px;
	left: 360px;
}
#cal_insert{padding-bottom: 350px;}
</style>
</head>
<body>
<%@ include file="./form/nav_user.jsp" %>
<%
   int year = Integer.parseInt(request.getParameter("year"));
   int month = Integer.parseInt(request.getParameter("month"));
   int date = Integer.parseInt(request.getParameter("date"));
   int lastDay = Integer.parseInt(request.getParameter("lastDay")); // 현재 월의 마지막 일(몇일)
   int member_no = Integer.parseInt(request.getParameter("member_no"));
   
   Calendar cal = Calendar.getInstance();
   int hour = cal.get(Calendar.HOUR_OF_DAY);
   int min = cal.get(Calendar.MINUTE);
   
%>
  <div class="content">
  	<div id="wrap_title">
  		<img src="resources/images/cal.jpg" alt="calendar"/>
  		<h3>개인 회원 >> 일정 관리 >></h3>
  		<div id="sub_title">
   		<h3>일정 작성하기</h3>
   		</div>
   </div>
  </div> 
   <form action="CalendarController.do" method="post">
      <input type="hidden" name="command" value="insertcal" />
      <input type="hidden" name="member_no" value="<%=member_no %>"/>
      
      <table>
         <tr>
            <th>일정</th>
            <td>
               <select name="year">
<%
                  for (int i = year-5; i <= year+5; i++){
%>               
                  <option value="<%=i%>" <%=(year == i)?"selected" : "" %> ><%=i %></option>
                  <!-- year 즉 현재 년도와 i의 년도가 같다면! selected 속성을 추가한다. selected 속성은 따로 태그를 주지 않아도 selected만 넣으면 선택자 선택이 된다. -->
<%
                  }
%>
               </select> 년
               <select name="month">
<%
					for(int i = 1; i < 13; i++){
%>               	
						<option value="<%=i%>" <%=(month == i)?"selected":"" %>><%=i %></option>
<%
					}
%>
               </select>월
               <select name="date">
<%
				for(int i = 1; i <= lastDay; i++){
%>               
					<option value="<%=i%>" <%=(date == i)?"selected":"" %>><%=i %></option>
<%
				}
%>
               </select>일
               <select name="hour">
<%
					for(int i = 0; i < 24; i++){
%>               
					<option value="<%=i%>" <%=(hour == i) ? "selected":"" %>><%=i %></option>
<%
					}
%>
               </select>시
               <select name="min">
<%
					for(int i = 0; i < 60; i++){
%>               
					<option value="<%=i%>" <%=(min == i) ? "selected" : "" %>><%=i %></option>
<%
					}
%>
               </select>분
            </td>
         </tr>
         <tr>
         	<th>제목</th>
         	<td><input type="text" name="title"/></td>
         </tr>
         <tr>
         	<th>내용</th>
         	<td><textarea rows="10" cols="60" name="content"></textarea></td>
         </tr>
       
       <div class="button">  
         		<input type="button" value="돌아가기" onclick="location.href='CalendarController.do?command=schedule&member_no=<%=member_no%>'"/>
         		<input type="submit" value="일정작성"/>
       </div>
      </table>
   	  <div id="cal_insert">
   	  </div>
   </form>
            <jsp:include page="chat/chat_aside.jsp"></jsp:include>
   
<%@ include file="./form/footer.jsp" %>
</body>
</html>