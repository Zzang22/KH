<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body {
   background-color: #FAFAFA;
   color: #424242;
}

#title {
   position: absolute;
   top: 130px;
   left: 38%
}

#list {
   position: absolute;
   top: 280px;
   left: 30%;
}

#button {
   position: absolute;
   top: 640px;
   left: 46%;
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

#last{
   position: absolute;
   top: 640px;
   left: 46%;
}

#bt{
   display:none;
}

#apply {
   width: 200px;
   background-color: #819FF7;
   border-radius: 28px;
   border: 1px solid #5882FA;
   display: inline-block;
   cursor: pointer;
   color: #ffffff;
   font-family: Arial;
   font-size: 17px;
   padding: 16px 31px;
   text-decoration: none;
   text-shadow: 0px 1px 0px #2f6627;
}

#apply:hover {
   background-color: #5882FA;
}

#apply:active {
   position: relative;
   top: 1px;
}

#apply :visited {
   text-decoration: none;
   color: #EFF8FB;
}

#apply :link {
   text-decoration: none;
   color: #EFF8FB;
}

#apply :active {
   text-decoration: none;
   color: #EFF8FB;
}
</style>


</head>
<body>

   <%@ include file="./form/nav_user.jsp"%>

   <%
      int jo_no = Integer.parseInt(request.getParameter("jo_no"));
   %>

   <form action="JDL.do" method="post">

      <input type="hidden" name="command" value="applyRes" /> <input type="hidden" name="jo_no" value="<%=jo_no%>" />


      <div id="title">
         <h1>지원가능한 이력서 리스트</h1>
      </div>

      <div id="list">
         <table>

            <col width="50" />
            <col width="600" />


            <c:choose>

               <c:when test="${empty list }">
                  <tr>
                     <th colspan="2">-------------------- 작성하신 이력서가 존재하지 않습니다 --------------------</th>
                  </tr>
               </c:when>

               <c:otherwise>
                  <c:forEach items="${list }" var="dto">
                     <tr>
                        <td><input type="radio" name="selectedResume" value="${dto.rs_no}"></td>
                        <td><a href="indimember.do?command=resume-detail&rs_no=${dto.rs_no }">${dto.rs_title }</a></td>
                     </tr>
                  </c:forEach>
               </c:otherwise>

            </c:choose>

         </table>

      </div>

      <div id="last">
         <label id="apply" for="bt"><span>지원하기</span></label>
         <input type="submit" id="bt" />
      </div>
   </form>
   
   
   	      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
   
</body>

</html>