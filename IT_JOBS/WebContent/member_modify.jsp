<%@page import="com.bb.dto.MemberDto"%>
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
@import url('https://fonts.googleapis.com/css2?family=Secular+One&display=swap');

*{
 box-sizing:border-box;
}

body{
	background-color: #FAFAFA;
	color: #424242;
}

/*input 박스를 감싸는 span태그들*/
.span{
	display: block;
    position: relative;
    width: 300px;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 110px 10px 14px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    vertical-align: top;

}

input{
	display : block;
	margin : 0 auto;
	width: 200px;
	height: 30px;
	border: white;
}

/*각 input박스 글자*/
h4{
	margin: 19px 0 8px;
    font-size: 14px;
    font-weight: 700;
}

/*input창 div박스*/
.user_modify{
	position:absolute;
	margin-top: 15%;
	left: 50%;
	margin-left: -150px;
	margin-bottom: 10%;

}

/*'다음으로'버튼*/
#submit{
	margin-top: 40px;
	width: 300px;
    height: 51px;
    background: #819FF7;
    border-style: none;
    color: white;
}

/*WELCOM TO IT_JOBS*/
#user_modifi_h1{
	display: block;
	margin: 0;
	font-family: 'Secular One', sans-serif;
	color: #819FF7;
}

#logo_div{
	position:absolute;
	height: 80px;
	left: 50%; 
	transform: translateX(-50%);


	margin-top: 10%;
</style>

</head>


<body>
<%@ include file="./form/nav_user.jsp" %>
	

	<div id="logo_div">
	<h1 id="user_modifi_h1">기업정보 수정</h1>
	</div>
	
	<form method="post" action="member.do">
	<input type="hidden" name="command" value="member_update"/>
	<input type="hidden" name="member_id" value="${dto.member_id }"/>
		
		<div class="user_modify">
			
			<div id="modify_id">
				<h4><label for="member_id">아이디</label></h4>
				<span class="span">${dto.member_id }</span>
			</div>
			
			<div id="modify_pw">
				<h4><label for="member_pw">비밀번호</label></h4>
				<span class="span"><input type="password" name ="member_pw" id ="member_pw" value="${dto.member_pw }"></span>
			</div>
			
			<div id="modify_corpname">
				<h4><label for="member_name">이름</label></h4>
				<span class="span"><input type="text" name="member_name" id="member_name" value="${dto.member_name }"/></span>
			</div>
			
			<div id="modify_id">
				<h4><label for="member_birthday">생년월일</label></h4>
				<span class="span">${dto.member_birthday }</span>
			</div>
			
			<div id="modify_postcode">	
				<h4><label for="member_postcode">우편번호</label></h4>
				<span class="span"><input type="text" name="member_postcode" id="member_postcode"  value="${dto.member_postcode }"/></span>
			</div>
			
			<div id="modify_member_addr">
				<h4><label for="member_addr">주소</label></h4>
				<span class="span"><input type="text" name="member_addr" id="member_addr" value="${dto.member_addr }"/></span>
			</div>
			
			<div id="modify_member_phone">
				<h4><label for="member_phone">연락처</label></h4>
				<span class="span"><input type="text" name="member_phone" id="member_phone" value="${dto.member_phone }"></span>
			</div>
			
			<div id="modify_member_email">	
				<h4><label for="member_email">이메일</label></h4>
				<span class="span"><input type="email" name="member_email" id="member_email" value="${dto.member_email }"></span>
			</div>
			
			
			<button type="submit" name="update" id="submit"><b>수정하기</b></button>
				
			
		</div>
	</form>
</body>
</html>