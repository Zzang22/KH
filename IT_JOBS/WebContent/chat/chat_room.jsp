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
<style>
.admin-info{
	text-align: center;
    padding: 10px;
}

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>


	<div id="main-container" style="background-color: white;">
		<nav id="chat-nav">
			<ul>
				<li><a href="ChatServlet?command=open_chat" onclick="disconnect()">오픈 채팅</a></li>
				<li id="select-li"><a href="ChatServlet?command=my_chat" onclick="disconnect()">나의 채팅</a></li>
			</ul>
		</nav>
		
		<main id="list-container">
			<input type="hidden" name="chat_room_no" value="${chat_room_no}">
			<input type="hidden" name="member_no" value="${login.member_no }">
			
			<section>
				<div id="room-name">
					<a href="ChatServlet?command=my_chat" id="prev-page" onclick="disconnect()">&#60;	</a>
					${chat_room_name } 
					<span id="member-count">${user_count }</span>
					<input type="button" value="나가기" id="leave-btn" onclick="disconnect(); location.href='ChatServlet?command=leave_chat_room&chat_room_no=${chat_room_no}';" >					
				</div>
			</section>
			
			<section>
				<div id="chat-container">
					<c:forEach items="${chat_list }" var="dto">
						<c:choose>
							<c:when test="${dto.member_no eq 2 }">
								<div class='admin-info'>${dto.member_id }님이 ${dto.chat_content }하였습니다.</div>
							</c:when>
							<c:when test="${dto.member_no eq login.member_no }">
								<div class='my-chat-area'>
									<div class='chat-writer'>${login.member_id}님</div>
									<div class='chat-content'>${dto.chat_content }</div>
									<div class='chat-date'>${dto.chat_regdate }</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class='chat-area'>
									<div class='chat-writer' style='text-align: left;'>${dto.member_id }님</div>
									<div class='chat-content' style='background-color: #F2F2F2; text-align: left;'>${dto.chat_content }</div>
									<div class='chat-date' style='text-align: left;'>${dto.chat_regdate }</div>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
			</section>
			
			<section>
				<div id="input-container">
					<input type="text" id="input-msg" onkeypress="enterKey()"/>
					<input type="button" id="send-btn" value="전송" onclick="sendMsg()"/>
				</div>
			</section>
		</main> 
		
	</div>
	
</body>

<script>
	$(function(){
		$('#chat-container').scrollTop($('#chat-container')[0].scrollHeight+20);
	
	})

	// WebSocket 객체 생성 (자동으로 접속 - onopen 함수 호출)
	var webSocket = new WebSocket("ws://localhost:8787/IT_JOBS/chatsocket");
	
	// WebSocket 서버와 접속이 되면 호출되는 함수
	webSocket.onopen = function(event) {
		var val = $('input[name=chat_room_no]').val();
		webSocket.send(val);
		
	};
	
	// WebSocket 서버와 접속이 끊기면 호출되는 함수
	webSocket.onclose = function(event) {
		
	};
	
	// WebSocket 서버와 통신 중에 에러가 발생하면 요청되는 함수
	webSocket.onerror = function(event) {
		
		$.ajax({
			url: 'ChatServlet?command=leave_chat_room&chat_room_no='+room_no,
			success: function(msg){
				alert('서버와 연결에 실패했습니다.');
			},
			error: function(){
				alert('서버와 연결에 실패했습니다.');
			}
		})
		
	};
	
	webSocket.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var $chat = "";
		
		if(data.member_no == 2){
			$chat = $("<div class='admin-info'>"+data.member_id+"님이 "+data.content+"하였습니다.</div>");
			countMember();
			
		} else {
			if(data.member_no == $('input[name=member_no]').val()){
				$chat = $("<div class='my-chat-area'><div class='chat-writer'>"+data.member_id+"님</div><div class='chat-content'>"
						+data.content+"</div><div class='chat-date'>"+data.data
						+"</div></div>");
			} else{
				$chat = $("<div class='chat-area'><div class='chat-writer' style='text-align: left;'>"+data.member_id+"님</div><div class='chat-content' style='background-color: #F2F2F2; text-align: left;'>"
						+data.content+"</div><div class='chat-date' style='text-align: left;'>"+data.data
						+"</div></div>");
			}
		}
		
		$("#chat-container").append($chat);
		$('#chat-container').scrollTop($('#chat-container')[0].scrollHeight+20);
		
	};
	
	function sendMsg() {
		
		var inputMsg = $("#input-msg").val();
		
		if(inputMsg == '' || inputMsg.trim() == ''){
			return;
		}
		
		var date = new Date();
		var hhmi = date.getHours() + ":" + ((date.getMinutes().length == 1)? "0"+date.getMinutes(): date.getMinutes());
		
		var $chat = $("<div class='my-chat-area'><div class='chat-writer'>${login.member_id}님</div><div class='chat-content'>"
				+inputMsg+"</div><div class='chat-date'>"+hhmi
				+"</div></div>");
		$("#chat-container").append($chat);
		$('#chat-container').scrollTop($('#chat-container')[0].scrollHeight+20);

		
		var chat_regdate = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()
		 +" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		 
		var sendMsg = {
				room_no: $("input[name=chat_room_no]").val(),
				content: inputMsg,
				regdate: chat_regdate,
				data: hhmi
		}
		webSocket.send(JSON.stringify(sendMsg));
		
		
		$("#input-msg").val("");
		$("#input-msg").focus();
	
	
	}
	
	
	function disconnect() {
		// WebSocket 연결 종료
		webSocket.close();
	}
	
	function enterKey() {
		if (event.keyCode == 13) {
			sendMsg();
		}
	}
	
	function countMember(){
		var room_no = $('input[name=chat_room_no]').val();
		$.ajax({
			url: 'ChatServlet?command=count_member&chat_room_no='+room_no,
			success: function(msg){
				 $('#member-count').html(msg);
			},
			error: function(){
				
			}
		})
	}
	

</script>
</html>