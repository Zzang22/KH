<%@page import="com.bb.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
	<% response.setContentType("text/html; charset=UTF-8"); %>
<%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-control", "no-store");
response.setHeader("Expires", "0");
/*
데이터가 변경되었을 때, 이전 내용을 화면에 보여주지 않게 함.
브라우저가 캐시에 응답결과를 저장하지 않도록 설정.
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#upper_body{
	padding-top: 90px;
	width: 100%;
	height: 500px;
	background-image: url('resources/images/building.jpg');
	background-repeat: no-repeat;
	background-position: center;
}	
.button{
	width:200px;
	background-color:#819FF7;
	border-radius:28px;
	border: none;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:17px;
	padding:16px 31px;
	text-shadow:0px 1px 0px #2f6627;
	box-shadow:10px 10px 20px #000;
	
}
.button a{
	text-decoration: none;
	color: white;

}
h1{
 color: white;
 position: relative;
 left: 100px;
 top: 100px;
 
}
h3{
  color: white;
  position: relative;
  left: 100px;
  top: 110px;
}
#member_btn{
  position: relative;
  left: 100px;
  top: 150px;
  text-align: center;
}
#corp_btn{
  position: relative;
  left: 150px;
  top: 150px;
  text-align: center;
}

</style>
</head>
<body>
<%@ include file="./form/nav_user.jsp" %>

	  <div id="admin_main">
	    <div id="upper_body">
			<div id="content">
			<h1>IT JOBS ADMIN</h1>
			<h3>직장인의 커리어 여정을 IT JOBS와 함께 하세요.</h3>
				<div class="button" id="member_btn">
					<a href="paging.do?command=memberlist&curPage=1"><b>일반 회원 조회</b></a>
				</div>
				<div class="button" id="corp_btn">
					<a href="paging.do?command=corporationlist&curPage=1"><b>기업 회원 조회</b></a>
				</div>
			</div>
		</div>
	  </div>	

		
<%@ include file="./form/footer.jsp" %>
</body>
</html>