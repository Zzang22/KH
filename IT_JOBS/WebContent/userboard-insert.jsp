
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .button > input{ 	margin-top: 40px; 	width: 100px;     height: 20px;     background: #819FF7;     border-style: none;     color: white;     font-size: 10pt;     position: relative;     right: -1400px;     top: -440px; }

 body { 	background-color: #FAFAFA; 	color: #424242; } 
  /*제목 위치*/ 
  #title { 	position: absolute; 	top: 130px; 	left: 53%; 	margin-left: -90px; }
  
  table { 	width: 100%; 	border-top: 1px solid #444444; 	border-collapse: collapse; } 
   th, td { 	border-bottom: 1px solid #444444; 	padding: 10px; }

#userboard_insert { 	position: absolute; 	top: 280px; 	left: 50%; 	margin-left: -750px; }
</style>
</head>
<body>
 <jsp:include page="form/nav_user.jsp"></jsp:include>
 	<div id="title"> 
		<h1>글 작성</h1> 
	</div>
	<div id="userboard_insert">

	<form action="userboard.do" method="post">
	<input type="hidden" name="command" value="userboard-insertform"/>
	<input type="hidden" name="member_no" value="${login.member_no }"/>
	<input type="hidden" name="member_id" value="${login.member_id }"/>
			<table border="1" style="margin-left: 440px; width: 600px; height: 500px;" >
			<tr>
				<th>제목</th>
				<td><input type="text" name="userboard_title" style="width: 480px; font-size: large;"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${login.member_id }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="40" cols="60" name="userboard_content" style="width: 480px; height: 582px;"></textarea></td>
			</tr>
			<tr>
			<th></th>
				<td colspan="1" align="right">
				<input type="submit"  value="완료"/>
				<input type="button" value="돌아가기"  onclick="location.href='userboard.do?command=userboard-list'"/>
				</td>
			</tr>
		</table>
	</form>	
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	</div>
	
	
		      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
	
</body>
</html>