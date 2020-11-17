<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/chat_main_css.css"> 
<style>
	body{
		height: 700px;
    	background-color: #F2F2F2;
	}
	#open_text{
		text-align: center;
	    font-size: 25px;
	    margin-top: 15%;
	}
	#main_container{
		height: 700px;
	}
	input[name=chat_room_name]{
		border-bottom: 2px solid #848484;
	    border-left: none;
	    border-right: none;
	    border-top: none;
	    background-color: #F2F2F2;
	    font-size: 22px;
	    text-align: center;
	    position: absolute;
	    left: 10%;
	    top: 30%;
	}
	#insertBtn{
		left: 45%;
	    position: absolute;
	    top: 45%;
	    right: 13px;
	    background: #045FB4;
	    width: 75px;
	    height: 40px;
	    color: white;
	    border: none;
	    border-radius: 8px 8px 8px 8px;
	    font-size: 18px;
	}
	
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	
	function title_chk(){
		var target = $('input[name=chat_room_name]');
		if(target.val() == null|| target.val().trim() == ''){
			alert('오픈채팅방 이름을 입력해주세요.');
			return false;
		}
	}
</script>
</head>
<body> 

	<div id="main-container">
		
		<main id="list-container">
			<div id="insert_room_container">
			<section>
			
				<a href="javascript:history.back();" style="font-size: 50px; text-decoration: none; color: #585858; font-weight: bold; margin:20px">&#60;	</a>
				
			</section>
			<section>
				<form action="../ChatServlet" method="post" id="insert_form" onsubmit="title_chk();">
					<input type="hidden" name="command" value="insert_room">
					<p id="open_text">오픈채팅방 이름을 입력해 주세요.</p>
					<div><input type="text" name="chat_room_name" size=35><br/></div>
					<div><input id="insertBtn" type="submit" value="만들기"></div>
				</form>
			</section>
			</div>
		</main>
		
	</div>
</body>
</html>