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
@import
   url('https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@500&family=Noto+Sans+KR:wght@700&display=swap');

body, html {
	height: 100%;
	margin: 0px;
	font-family: 'Noto Sans KR', sans-serif;
}
/*메뉴부분(채용공고,기업뉴스, 후기 게시판, 고객센터)*/
.cs_list :visited {text-decoration:none; color:#EFF8FB;}
.cs_list :link {text-decoration:none; color:#EFF8FB;}
.cs_list :active {text-decoration:none; color:#81BEF7;}
.cs_list :hover {text-decoration:none; color:#FFFFFF;}

/*logo 부분*/
.wrap-logo :visited{text-decoration:none; color:#EFF8FB;}
.wrap-logo :link{text-decoration:none; color:#EFF8FB;}
.wrap-logo :active{text-decoration:none; color:#EFF8FB;}
.wrap-logo :hover{text-decoration:none; color:#EFF8FB;}

/*로그인 부분*/
.login :visited{text-decoration:none; color:#EFF8FB;}
.login :link{text-decoration:none; color:#EFF8FB;}
.login :active{text-decoration:none; color:#EFF8FB;}
.login :hover{text-decoration:none; color:#EFF8FB;}

header{
	position: relative;
	position: fixed;
	top: 0;
	width: 100%;
	height: 100px;
	background-color: #819FF7;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5) ;
	z-index: 4;
	-webkit-transition: height 1s;
	transition: height 0.2s;
	color: #EFF8FB;
}

.header-div {
	-webkit-justify-content: space-between;
	justify-content: space-between;
	display: flex;
}

header:hover{
	height: 110px;
}
.wrap-logo{
	float: left;
	padding-left: 10%;
	line-height: 100px;
	
}


li{
	list-style: none;
	float: left;
	line-height: 3;
	font-weight: 400;
	letter-spacing: 0;
	padding:0 20px;
	font-size: 20px;
	color: #EFF8FB;
}
/*메뉴 위치 이동*/
li > a{
	position: relative;
	right: 500px;
}

.login{
	float: right;
	padding-right: 10%;
	line-height: 100px;
	
}
/*로그인 버튼 위치*/
.login > a{
	position: relative;
	right: 150px;
	top: -75px;
}
div{
	display: block;
}
</style>
</head>
<body>
	<header id="header">
		<div class="header-div">
	<!-- header를 박스로 잡기 위한 div -->
			<div class="wrap-logo">
				<a href="#">IT JOBS</a>
			</div>
		
			<div class="cs_main">
				<nav class="cs_menu">
					<ul class="cs_nav">
						<li class="cs_list">
						    <a href="" id="recruit-board">채용 공고</a>
						</li>
						<li class="cs_list">
						    <a href="" id="news-board">기업 뉴스</a>
						</li>
						<li class="cs_list">
						    <a href="" id="review-board">후기 게시판</a>
						</li>
						<li class="cs_list">
							<a id="cs-board" title="고객센터" href="">고객센터</a>
						</li>
					</ul>
				</nav>
				<div class="login">
					<a href="member.do?command=login">로그인</a>
				</div>
			</div>
	  </div>	
	</header><br/>




</body>
</html>