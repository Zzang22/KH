<%@page import="com.bb.dto.CustomerServiceDto"%>
<%@page import="java.util.List"%>
<%@page import="com.bb.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
	<% response.setContentType("text/html; charset=UTF-8"); %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#upper_body{
	padding-top: 90px;
	margin-bottom: 100px;
	width:500px;
	height: 60%;
	background-image: url('resources/images/Cs3.jpg'); background-repeat: no-repeat;
	background-position: center;
	position: relative;
	top: 100px;
	left: 700px;
}
a{
	text-decoration: none;
	align: left;
	color: gray;
	font-family:'Noto Sans KR', sans-serif;
	
}
#content{
	text-align:left;
	padding-top: 30px;
	color: black;
}
#content > h1{
 	position: relative;
 	color: black;
 	font-weight: 800;
 	left: -550px;
 	top: -50px;
 	font-size: 20pt;
}
#content > h4{
  color: black;
  position: relative;
  left: -550px;
  top: -40px;
}
  button{
  position: relative;
  top: -330px;
  left: 160px;
  width: 200px;
  background-color: #ffffff;
  border: 2px solid	gray;
  color:gray;
  padding: 10px 0;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 11px;
  margin: 4px;
  margin-bottom: 20p;
  cursor: pointer;
  border-radius:10px;
  }
  table{
	position: relative;
	left: 250px;
	top: 20px;
	text-decoration: none;
	}
th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
 #plus_board{padding-bottom: 350px;}
</style>

</head>
<body>
<%@ include file="./form/nav_user.jsp" %>
<%

   List<CustomerServiceDto> list =(List<CustomerServiceDto>) request.getAttribute("list");
   //System.out.println("넘어온list값:"+list);

%>
	
	  <div id="upper_body">
	    <div id="content">
			<h1>IT JOBS 고객센터 >> 개인 회원, 기업 회원 </h1>
			<h4>IT JOBS에 대해 궁금한 점을 알려드립니다.</h4>
		</div>
	  </div>
	  	
		<table class="noti">
			<col width="200"/>
			<col width="600"/>
			<col width="300"/>
			<thead>	  
			<tr align="center">
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			</thead>
	<%
				for(CustomerServiceDto dto : list){
	%>		
			<tbody>
			<tr align="center">
				<td><%=dto.getCs_no() %></td>
				<td><a href="CustomerService.do?command=detail&cs_no=<%=dto.getCs_no()%>"><%=dto.getCs_title() %></a></td>
				<!-- <td><%=dto.getCs_regdate() %></td> -->
				<td><fmt:formatDate value="<%=dto.getCs_regdate() %>" type="both" pattern="yyyy-MM-dd"/></td>
			</tr>
			</tbody>
	<%
				}
	%>		
	        <tr colspan="3" align="right">
			    <button onclick="location.href='CustomerService.do?command=insert'">글작성</button>
			</tr>
		</table>
	<div id="plus_board">
	</div>
	
		      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
	
<%@ include file="./form/footer.jsp" %>	
</body>
</html>