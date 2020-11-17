<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-control", "no-store");
	response.setHeader("Expires", "0");%>       
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/chat_main_css.css"> 
<link rel="stylesheet" type="text/css" href="resources/css/chat_my_css.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	
	$(function(){
		$('hr').last().remove();
		
	})
	
</script>
</head>
<body>

	<div id="main-container" style="background-color: white;">
		<nav id="chat-nav">
			<ul>
				<li><a href="ChatServlet?command=open_chat">오픈 채팅</a></li>
				<li id="select-li"><a href="ChatServlet?command=my_chat">나의 채팅</a></li>
			</ul>
		</nav>
		
		<main id="list-container">
			<section id="openchat_section">
				<c:forEach items="${list }" var="dto">
					<input type="hidden" name="chat_room_no" value="${dto.chat_room_no }">
					<div id="openchat_info">
						<table>
							<col width="350">
							<col width="50">
							<tr>
								<td class="chat_title">
									<a href="ChatServlet?command=chat_room&chat_room_no=${dto.chat_room_no}&chat_room_name=${dto.chat_room_name }&member_no=${login.member_no }">${dto.chat_room_name }</a>
								</td>
								<td>
									<c:if test="${dto.chat_count != 0 }">
										<div class="chat_num">${dto.chat_count }</div>
									</c:if>
								</td>
							</tr>
							<tr>
								<c:choose>
								<c:when test="${dto.member_no == 2 }">
									<td class="chat_info">${dto.member_id }님이 ${dto.chat_content }하였습니다.</td>
									<td class="chat_date"></td>
								</c:when>
								<c:otherwise>
									<td class="chat_info">${dto.member_id } : ${dto.chat_content }</td>
									<td class="chat_date">${dto.chat_regdate }</td>
								</c:otherwise>
								</c:choose>
							</tr>
						</table>
					</div>
					<hr align="center" style="border: solid 1px #BDBDBD; width: 95%;">
				</c:forEach>
			</section>
		</main>
		
	</div>
</body>

</html>