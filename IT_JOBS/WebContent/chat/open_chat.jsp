<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/chat_main_css.css"> 
<style>
	#insertBtn{
		position: absolute;
		top: 60px;
		right: 13px;
		background: #045FB4;
		width: 80px;
		height: 42px;
		color: white;
		border: none;
		border-radius: 8px 8px 8px 8px;
		font-size: 18px;
	}
	#openchat_section{
		position: relative;
	    top: 55px;
	    padding: 7%;
	    padding-top: 0;
	    background-color: #F2F2F2;
	}
	.openchat_info{
		margin-top: 4%;
		margin-bottom: 4%;
	}
	.chat_title{
		font-size: 25px;
    	margin: 2%;
    	font-weight: bold;
	}
	.chat_info{
	    margin: 2%;
	}
	.chat_title a{
		color: black;
    	text-decoration: none;
	}
</style>
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
				<li id="select-li"><a href="#">오픈 채팅</a></li>
				<li><a href="ChatServlet?command=my_chat">나의 채팅</a></li>
			</ul>
		</nav>
		
		
		<main id="list-container">
			<section>
				<input type="button" value="+ 만들기" onclick="location.href='ChatServlet?command=insert_room_href'" id="insertBtn">
			</section>
			
			<section id="openchat_section">
				<c:forEach items="${list }" var="dto">
					<div class="openchat_info">
						<div class="chat_title"><a href="ChatServlet?command=get_room&chat_room_no=${dto.chat_room_no }&chat_room_name=${dto.chat_room_name }">${dto.chat_room_name }</a></div>
						<div class="chat_info">${dto.count_member }명  |  ${dto.last_date }</div>
					</div>
					<hr align="center" style="border: solid 1px #BDBDBD; width: 95%;">
				</c:forEach>
				

			</section>
		</main>
	</div>
</body>
</html>