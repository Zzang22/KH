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
	body{
	background-color: #FAFAFA;
	color: #424242;
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
    left: 600px;
    top: 370px;
}
#wrap_title > img{
  width: 40px;
  height: 40px;
  position: relative;
  top: 150px;
  left: 520px;
}
table{
 position: relative;
 left: 450px;
 top: 100px;
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
th, td {
    border-bottom: 2px solid #444444;
    border-top:  2px solid #444444;
    padding: 10px;
  }
  td{
   border-left: 1px solid #444444;
   
  }
  #cal_update{padding-bottom: 350px;}

</style>
</head>
<body>
<%@ include file="./form/nav_user.jsp" %>
<%
	CalendarDto dto = (CalendarDto)request.getAttribute("dto");
%>
	<div class="content">
  			<div id="wrap_title">
  			<img src="resources/images/check.png" alt="checklist"/>
  			<h3>개인 회원 >> 일정 관리 >></h3>
  			<div id="sub_title">
   				<h3>일정 세부사항 수정</h3>
   			</div>
   			</div>
  	</div>

	
	<form action="CalendarController.do" method="post">
	<input type="hidden" name="command" value="updateCalendarRes" />
	<input type="hidden" name="cal_no" value="<%=dto.getCal_no() %>"/>
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="cal_title" value="<%=dto.getCal_title() %>"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="cal_content"><%=dto.getCal_content() %></textarea></td>
			</tr>
            <div class="button">		
					<input type="submit" value="일정수정"/>
					<input type="button" value="취소" onclick="location.href='CalendarController.do?command=detail&cal_no=<%=dto.getCal_no() %>'"/>
			</div>
		</table>	
	</form>
	<div id="cal_update">
	</div>
	         <jsp:include page="chat/chat_aside.jsp"></jsp:include>
	
<%@ include file="./form/footer.jsp" %>	
</body>
</html>