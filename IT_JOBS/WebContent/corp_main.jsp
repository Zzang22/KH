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
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;500;700&display=swap');

@import url('https://fonts.googleapis.com/css2?family=Secular+One&display=swap');

body{
	background-color: #D8D8D8;
}

#upper_body{
	padding-top: 90px;
	width:100%;
	height:600px;
	background-color:#D8D8D8;
	background-image: url('resources/images/corp_img03.jpg'); background-repeat: no-repeat;
	background-position: center;
}

#content{

	text-align:center;
	padding-top: 30px;
	font-size:30px;;
	color: white;
	
}

#button {
	width:200px;
	background-color:#819FF7;
	border-radius:28px;
	border:1px solid #5882FA;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:17px;
	padding:16px 31px;
	text-decoration:none;
	text-shadow:0px 1px 0px #2f6627;
}
#button:hover {
	background-color:#5882FA;
}
#button:active {
	position:relative;
	top:1px;
}


#button :visited{text-decoration:none; color:#EFF8FB;}
#button :link{text-decoration:none; color:#EFF8FB;}
#button :active{text-decoration:none; color:#EFF8FB;}


</style>
</head>
<body>
<%@ include file="./form/nav_corp.jsp" %>

<div id="corp_main">
		<div id="upper_body">
		<div id="content">
		<h1>더 많은 기회를 <br/>IT JOBS와 누리세요</h1>
		<h3>IT JOBS를 지금 시작하세요.</h3>
		<div id="button">
		<a href="offer.do?command=joboffer_main"><b>시작하기</b></a>
		</div>
	</div>

	</div>
</div>
<%@ include file="./form/footer.jsp" %>
</body>
</html>




