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
	url('https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@500&family=Noto+Sans+KR:wght@700&display=swap')
	;

body, html {
	height: 100%;
	margin: 0px;
	font-family: 'Noto Sans KR', sans-serif;
}

.user_list :visited{text-decoration:none; color:#EFF8FB;}

.user_list :link {text-decoration:none; color:#EFF8FB;}

.user_list :active {text-decoration:none; color:#81BEF7;}

.user_list :hover {text-decoration:none; color:#FFFFFF;}

.IT_JOBS :visited{text-decoration:none; color:#EFF8FB;}
.IT_JOBS :link{text-decoration:none; color:#EFF8FB;}
.IT_JOBS :active{text-decoration:none; color:#EFF8FB;}
.IT_JOBS :hover{text-decoration:none; color:#EFF8FB;}

.user_info_modi :visited{text-decoration:none; color:#EFF8FB;}
.user_info_modi :link{text-decoration:none; color:#EFF8FB;}
.user_info_modi :active{text-decoration:none; color:#EFF8FB;}
.user_info_modi :hover{text-decoration:none; color:#EFF8FB;}

header:hover{
	height: 110px;
}

.IT_JOBS {
	float: left;
	padding-left: 10%;
	line-height: 100px;
}

li {
	list-style: none;
	float: left;
	line-height: 3;
	font-weight: 400;
	letter-spacing: 0;
	padding:0 20px;
	font-size: 20px;
	color: #EFF8FB;
}


.user_info_modi {
	float: right;
	padding-right: 10%;
	line-height: 100px;
	font-size: 20px;
}

header {
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

div{
	display: block;
}
</style>

</head>
<body>
<!-- header를 박스로 잡기 위한 div -->
	<header>
		<div class="header-div">
			<!-- 기업 로고 IT JOBS -->
			<div class="IT_JOBS">
				<a href="member.do?command=user_main"><img height="100" width="150" src="resources/images/logo_main.png" /></a>
			</div>

			<div class="user_main">
				<!-- 기업메뉴 -->
				<nav class="user_manu">
					<ul class="user_nav">
						<li class="user_list"><a
							href="JDL.do?command=joboffer_division">채용공고</a>
						<li class="user_list"><a href="news.do?command=news">IT 뉴스</a>
						<li class="user_list"><a
							href="userboard.do?command=userboard-list">후기 게시판</a>
						<li class="user_list"><a href="CustomerService.do?command=csboard">고객센터</a>
					</ul>
				</nav>
			</div>
			
			<div class="user_info_modi">
				<a href="member.do?command=member_logout">로그아웃</a> 
			</div>
		</div>
	</header>


</body>
</html>