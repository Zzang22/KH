<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-control", "no-store");
response.setHeader("Expires", "0");
%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 네이버 로그인 API -->
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>
<%
	String clientId = "D3Kx4mjlM0CX8U8Is2DW"; //애플리케이션 클라이언트 아이디값";
String redirectURI = URLEncoder.encode("http://localhost:8787/IT_JOBS_before(1.0)/member.do?command=naver_login",
		"UTF-8");
SecureRandom random = new SecureRandom();
String state = new BigInteger(130, random).toString();
String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
apiURL += "&client_id=" + clientId;
apiURL += "&redirect_uri=" + redirectURI;
apiURL += "&state=" + state;
session.setAttribute("state", state);
%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="./resources/css/loginpopup.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript">
	function idpwCheck() {
		var f = document.myForm;
		if (!f.member_id.value) {
			alert("아이디를 입력하세요!");
			f.member_id.focus();
			return;
		}

		if (!f.member_pw.value) {
			alert("비밀번호를 입력하세요!")
			f.member_pw.focus();
			return;
		}
		function idCheck() {
			var idReg = /^[A-za-z0-9]$/g;
			//영문자와 숫자
			//정규표현식. test(입력값) 규칙에 맞으면 true

			if (!idReg.test($("input[id=member_id]").val())) {
				alert("아이디는 영문자와 숫자만 가능합니다.");
				return;
			}
		}
	}
</script>
</head>
<body>
	<%@ include file="./form/nav_user.jsp"%>
	<br/>
	<br/>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<img height="200" width="250" src="resources/images/logo_main.png" />
			</div>

			<!-- Login Form -->
			<form action="member.do" method="post" name="myForm">
				<input type="hidden" name="command" value="member_login" /> 
				<input type="text" id="member_id" name="member_id" class="fadeIn second" placeholder="아이디"> 
				<input type="password" id="member_pw" name="member_pw" class="fadeIn third" placeholder="비밀번호"> 
				<input type="submit" class="fadeIn fourth" value="로그인" onclick="javascript:idpwCheck();idCheck();">
			</form>
			
			<div id="naver_logo">
			<a href="<%=apiURL%>">
			<img height="43" src="resources/images/naver_White.PNG" /></a>
			</div>

			<div id="formFooter">
			
				<a class="underlineHover"
					onclick="location.href='corp.do?command=join'">기업회원가입</a>
				<a class="underlineHover"
					onclick="location.href='member.do?command=join'">개인회원가입</a>
			</div>

		</div>
	</div>

</body>
</html>