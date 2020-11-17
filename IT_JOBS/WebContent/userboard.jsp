<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

body{
background-color: #FAFAFA;
color: #424242;
}

#title{
position:absolute;
top:130px;
left:50%;
margin-left: -90px;
}

#list{
position:absolute;
top:280px;
left:50%;
margin-left: -300px;
}

table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
}

th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
}



/* 맨 마지막 공백 */
#reg_button_div{
   width: 80%;
   height: 200px;
}

.reg_button {
   margin-top: 10px;
   margin-bottom:10px;
   
   width: 100px;
    height: 30px;
    background: #819FF7;
    font-family: 'Noto Sans KR', sans-serif;
    
    box-shadow:inset 0px 1px 0px 0px #d7dafa;
   background:linear-gradient(to bottom, #a1b9ff 5%, #819FF7 100%);
   background-color:#85bdf5;
   border-radius:3px;
   border:1px solid #398cde;
   display:inline-block;
   cursor:pointer;
   color:#ffffff;
   font-family:Arial;
   font-size:13px;
   font-weight:bold;
   
   text-decoration:none;
   text-shadow:0px 1px 0px #0818ff;
}

/* '등록하기'버튼 들어있는 td 색깔*/
#reg_button_td{
   border:solid 1px #FAFAFA;
}
</style>
</head>
<body>

   <%@ include file="./form/nav_user.jsp"%>
   <div id="title">
      <h1>후기 게시판</h1>
   </div>
   
   <div id="list">
   <table style="text-align:center;">
      <col width="100" />
      <col width="100" />
      <col width="300" />
      <col width="150" />
      <tr>
         <th>번  호</th>
         <th>작성자</th>
         <th>제  목</th>
         <th>작성일</th>
      </tr>
      <c:choose>
         <c:when test="${empty user }">
            <tr>
               <th colspan="4">----------작성된 글이 존재하지 않습니다----------</th>
            </tr>
         </c:when>
         <c:otherwise>
            <c:forEach items="${user }" var="dto" >
               <tr style="text-align:center;">
                  <td>${dto.userboard_no }</td>
                  <td>${dto.member_id }</td>
                  <td>
                     <a href="userboard.do?command=userboard-detail&userboard_no=${dto.userboard_no }">${dto.userboard_title }</a>
                  </td>
                  <td><fmt:formatDate value="${dto.userboard_regdate }" type="both" pattern="yyyy-MM-dd"/></td>
   
               </tr>
            </c:forEach>
         </c:otherwise>
      </c:choose>
      
      <tr>
      <td id="reg_button_td" colspan="4"><button class="reg_button" type="button" onclick="location.href='userboard.do?command=userboard-insert'" value="글작성">글작성</button></td>
      </tr>
      
   </table>
   <div id="reg_button_div">
   </div>
   </div>
   
   	      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
   
   


</body>
</html>