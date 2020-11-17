<%response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-control", "no-store");
response.setHeader("Expires", "0");%>   
<%@page import="com.bb.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");
%>
<%
   response.setContentType("text/html; charset=UTF-8");
%>

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

input {
   display:none;
}


</style>
</head>
<%
   MemberDto dto =  (MemberDto)session.getAttribute("login");
%>
<body>
<%@ include file="./form/nav_user.jsp"%>

   <div id="user_main">
      <div id="upper_body">
      <div id="content">
      <h1>더 많은 기회를 <br/>IT JOBS와 누리세요</h1>
      <h3><%=dto.getMember_id() %> 님 환영합니다.</h3>
      
      <label id="button" for="one">
      <input type="button" id="one" onclick="location.href='member.do?command=my_apply'"><b>지원한 공고 보기</b>
      </label>
      
      <label id="button" for="two">
      <input type="button" id="two" onclick="location.href='CalendarController.do?command=schedule'"><b>일정관리</b>
      </label>
      
      <label id="button" for="three">
      <input type="button" id="three" onclick="location.href='indimember.do?command=resume'"><b>이력서</b>
      </label>
      
      <label id="button" for="four">
      <input type="button" id="four" onclick="location.href='member.do?command=memberUpdate'"><b>내 정보 수정</b>
      </label>
      
   </div>

   </div>
</div>
      
      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
      

<%@ include file="./form/footer.jsp" %>
</body>
</html>