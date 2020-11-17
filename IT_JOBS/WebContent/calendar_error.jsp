<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
	<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./form/nav_user.jsp" %>
	<h1 style="color:red;">Error!!</h1>
	<%=request.getAttribute("msg") %><br/>
	<a href="CalendarController.do?command=schedule">처음으로...</a>

         <jsp:include page="chat/chat_aside.jsp"></jsp:include>


<%@ include file="./form/footer.jsp" %>
</body>
</html>