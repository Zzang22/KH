<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	#resume_form{    
		position: absolute;
	    top: 10%;
	    left: 25%;
	    margin-bottom: 15%;
	}
	table, td, th {
 	   border: 1px solid #cccccc;
	}
</style>
</head>
<body>
	<jsp:include page="form/nav_user.jsp"></jsp:include>

	<div id="resume_form">
	<h1 align="center">내 이력서</h1>

	<table border="1">
		<col width="30">
		<col width="550"/>
		<tr>
			<th>no</th>
			<th>이력서 제목</th>
		</tr>
		<c:choose>
			<c:when test="${empty resumes }">
				<tr>
					<th colspan="2">------------작성된 이력서가 존재하지 않습니다---------------------</th>
				</tr>
			</c:when>
			<c:otherwise>
			<% int i = 1; %>
				<c:forEach items="${resumes }" var="dto">
					<tr>
						<td><%=i %></td>
						<td>
							<a href="indimember.do?command=resume-detail&rs_no=${dto.rs_no }">${dto.rs_title }</a>
						</td>
					</tr>
					<%i++; %>
			</c:forEach>
		</c:otherwise>
		</c:choose>
		
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="이력서 작성" onclick="location.href='indimember.do?command=resume-insert&member_no=${dto.member_no}'"/>
			</td>
		</tr>
	</table>
	</div>
		
		         <jsp:include page="chat/chat_aside.jsp"></jsp:include>
		

</body>
</html>