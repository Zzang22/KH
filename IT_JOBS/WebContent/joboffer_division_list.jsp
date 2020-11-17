<%@page import="java.util.List"%>
<%@page import="com.bb.model.biz.JobOfferDivisionListBizImpl"%>
<%@page import="com.bb.model.biz.JobOfferDivisionListBiz"%>
<%@page import="com.bb.dto.JobOfferDivisionListDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script type="text/javascript"
   src="https://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript"
   src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ac070aef0dd3d3c99c9947820a79ce05"></script>

</head>
<body>

   <%@ include file="./form/nav_user.jsp"%>

   <div id="title">
      <h1>검색 결과</h1>
   </div>

   <div id="list">
      <table>
         <col width="100" />
         <col width="200" />
         <col width="600" />
         <col width="150" />
         <col width="100" />

         <tr>
            <th>번 호</th>
            <th>기업명</th>
            <th>제 목</th>
            <th>마감일</th>
            <th>조회수</th>
         </tr>

         <c:choose>

            <c:when test="${empty list }">
               <tr>
                  <th colspan="5">-------------------- 죄송합니다. 설정하신 분류의 채용공고는
                     존재하지 않습니다 다시 입력해주세요. --------------------</th>
               </tr>
            </c:when>

            <c:otherwise>
               <c:forEach items="${list }" var="dto">
                  <tr>
                     <td style="text-align:center;">${dto.jo_no }</td>
                     <td>${dto.member_name }</td>
                     <td><a href="JDL.do?command=joboffer_division_detail&jo_no=${dto.jo_no }">${dto.jo_title }</a></td>
                     <td style="text-align:center;">${dto.jo_deadline }</td>
                     <td style="text-align:center;">${dto.jo_hit }</td>
                  </tr>
               </c:forEach>
            </c:otherwise>

         </c:choose>
      </table>
   </div>
   
   
         <jsp:include page="chat/chat_aside.jsp"></jsp:include>
   

</body>
</html>