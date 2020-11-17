<%@page import="com.bb.dto.CalendarDto"%>
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

.button> input{
	margin-top: 40px;
	width: 100px;
    height: 20px;
    background: #819FF7;
    border-style: none;
    color: white;
    font-size: 10pt;
    position: relative;
    left: 200px;
    top: 30px;
}
#wrap_title > img{
  width: 40px;
  height: 40px;
  position: relative;
  top: 150px;
  left: 485px;
}
table{
 position: relative;
 left: 650px;
 top: 120px;
 z-index: 4
}
#wrap_title > h3{
	position: relative;
	left: 150px;
	top: 100px; 
	color: gray;
}      
#sub_title > h3{
	position: relative;
	left: 370px;
	top: 53px;
	color: green;
}
#table_content{
 position: relative;
 top: -100px;
}
#div_content, #table_title, #table_no{
 position: relative;
 left: 40px;
}
#div_content{
  position: relative;
  top: 40px;
  whitd-space: normal;
}
#note_img{
width: 470px;
height: 600px;
background-image: url('resources/images/note.jpg'); 
background-repeat: no-repeat;
position: relative;
left: 550px;
top: -350px;
z-index: 1;
}
td{
 color: gray;
}
.title{
  position: relative;
  top: 20px;
}
#cal_detail{padding-bottom: 50px;}
</style>
</head>
<body>
<%@ include file="./form/nav_user.jsp" %>
<%
	CalendarDto dto = (CalendarDto)request.getAttribute("dto");
	//System.out.println("detailpage-dto확인:"+dto);
%>
	<div class="content">
  			<div id="wrap_title">
  			<img src="resources/images/check.png" alt="checklist"/>
  			<h3>개인 회원 >> 일정 관리 >></h3>
  			<div id="sub_title">
   				<h3>일정 세부사항</h3>
   			</div>
   			</div>
  		</div>
	
		<table>
			<tr>
				<th>번호 </th>
				<td id="table_no"><%=dto.getCal_no() %></td>
			</tr>
			<tr>
				<th class="title">제목 </th>
				<td id="table_title" class="title"><%=dto.getCal_title() %></td>
			</tr>
	        <tr>
				<th id="table_content">내용 </th>
				<td><div id="div_content" style="border: none; width:200px; height:300px;"><%=dto.getCal_content() %></div></td>
			</tr>
			  <div class="button">
				<input type="button" onclick="location.href='CalendarController.do?command=schedule'" value="일정보기"/>
				<input type="button" onclick="location.href='CalendarController.do?command=updateCalendar&cal_no=<%=dto.getCal_no() %>'" value="수정하기"/>
		      </div>
		</table>
		<div id="note_img"></div>
		<div id="cal_detail">
		</div>
		
		         <jsp:include page="chat/chat_aside.jsp"></jsp:include>
		
<%@ include file="./form/footer.jsp" %>		
</body>
</html>