<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>

</head>
<body>
<!-- 직업명, 직무, 경력, 연봉, 기한,조회수(이건null) (보내져올 값은 member_no, jo_no) -->
	<form method="post" action="offer.do">
	<input type="hidden" name="command" value="${member.member_id }"/>
	   
	
	<h2>공고 등록</h2>
	<table border="1">
		<tr>
			<th>직업명</th>
			<td><input type="text" name="jo_title" required="required"></td>
		</tr>
		
		<tr>
			<th>직무</th>
			<c:forEach items="${list }" var="dto">
			<c:choose>
			<c:when test="${fn:length(list) == 4}">
			<br>
			</c:when>
			</c:choose>
			<td><input type="radio" name="field_name" value="field_name">${dto.field_name }</td>

			</c:forEach>			
		</tr>
		
		<tr>
			<th>경력</th>
				<c:forEach items="${list2 }" var="dto">
				<td><input type="radio" name="career_name" value="career_name">${dto.career_name }</td>
				</c:forEach>
		</tr>
		
		<tr>
			<th>연봉</th>
			<td><input type="text" name="jo_salary"/></td>
		</tr>
		
		<tr>
			<th>직무내용</th>
			<td><textarea name="jo_content" id="editor1"></textarea></td>

		</tr>
		
		<tr>
			<th>기한</th>
			<td><input type="text" name="jo_deadline"></td>
		</tr>
		
		
	</table>
	
	</form>

</body>
</html>