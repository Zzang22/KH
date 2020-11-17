<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-control", "no-store");
response.setHeader("Expires", "0");
%>	
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Secular+One&display=swap');

html, body {
	margin:0;
	padding:0;
}

h1, p {
	margin:0;
}

a{
	color: inherit;
	text-decoration: none;
	
}
#main {
	background: url('resources/images/new_york.png') no-repeat;
	background-size: cover;
	background-position: center center;
	width: 100vw;
	height: 100vh;
	font-family: font-family : 'Secular One', sans-serif; 
}

#contents{
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
	width: 100%;
	color: white;
	text-align: center;
	
}

#contents h1{
	font-size: 70px;
	margin-bottom : 16px;
}

#contents p{
	font-size: 23px;
	margin-bottom : 16px;
}

#contents a{
	display: inline-block;
	border:2px solid white;
	border-radius: 20px;
	padding: 10px 20px;
	font-size:17px;
	font-weight: bold;
}

@media(max-width:769px){
	#contents h1{
	font-size: 50px;
	
	}

	#contents p{
	font-size: 20px;
	}
	
	#contents a{
	font-size:14px;
	}
}

</style>

</head>
<body>
	<div id="main">
		<div id="contents">
			<h1>Invent the future!</h1>
			<p>Apply privately to 59,345 jobs with one application</p>
			<a href="member.do?command=member_login">Get started</a>
			
		</div>
	</div>
<%@ include file="./form/footer.jsp" %>
</body>
</html>