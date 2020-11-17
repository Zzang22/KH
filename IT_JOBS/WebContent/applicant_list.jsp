<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

body{
background-color: #FAFAFA;
color: #424242;
}

#title{
position:absolute;
top:130px;
left:42%;
margin-left: -90px;
}

#list{
position:absolute;   
top:280px;
left:50%;
margin-left: -610px;
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

</style>

</head>
<body>

   <%@ include file="./form/nav_user.jsp"%>

   <div id="title">
      <h1>지원자 이력서 리스트</h1>
   </div>

   <div id="list">
      <table>

         <col width="1150px">

         <c:choose>
            <c:when test="${empty list }">
               <tr>
                  <th colspan="1">----------- 지원한 이력서가 없습니다 ------------</th>
               </tr>
            </c:when>
            <c:otherwise>
               <c:forEach items="${list }" var="dto">
                  <tr> 
                     <td align="center"><a href="indimember.do?command=resume-detail&rs_no=${dto.rs_no}">${dto.rs_title }</a></td>
                  </tr>
               </c:forEach>
            </c:otherwise>
         </c:choose>

      </table>
   </div>
   
         <jsp:include page="chat/chat_aside.jsp"></jsp:include>
   
</body>
</html>