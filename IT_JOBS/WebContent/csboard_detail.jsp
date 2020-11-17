<%@page import="com.bb.dto.MemberDto"%>
<%@page import="com.bb.dto.CustomerServiceDto"%>
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
/*제목위치*/
h1{
	position: relative;
	color: gray;
	left: 300px;
	top: 150px;
}
h3{
	position: absolute;
	left: 480px;
	top: 165px;
}
/*배경색*/
	*{
	box-sizing: border-box;
	}
/*전체 배경색*/	
	body{
	background-color: #FAFAFA;
	color: #424242;
	}
 table{
    position: relative;
	left: 350px;
	top: 150px;
    border-top: 1px solid #444444;
    border-collapse: collapse;
 }	
.button> input{
	margin-top: 40px;
	width: 100px;
    height: 20px;
    background: #819FF7;
    border-style: none;
    color: white;
    font-size: 10pt;
    position: relative;
    left: 930px;
    top: 130px;
}
th{
	border-right: 1px solid #dadada;
}
 th, td {
        border-bottom: 1px solid black;
        padding: 10px;

      }
#cs_member{padding-bottom: 400px;}
</style>
</head>
<body>
<%@ include file="./form/nav_user.jsp" %>
<%
	//System.out.println("값도착");
	CustomerServiceDto dto  = (CustomerServiceDto)request.getAttribute("dto");

%>
           <div id="cs_member">
				<h1>고객센터 >></h1><h3>개인 회원, 기업 회원</h3>
						
				<table>
					<col width="100"/>
					<col width="800" height="300"/>
					<col width="800"/>
					<tr>
						<th>글번호</th>
						<td><%=dto.getCs_no() %></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><%=dto.getCs_title() %></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><div readonly="readonly"><%=dto.getCs_content() %></div></td>
					</tr>
						<div class="button">
							<input type="button" onclick="location.href='CustomerService.do?command=update&cs_no=<%=dto.getCs_no() %>'" value="수정"/>
							<input type="button" onclick="location.href='CustomerService.do?command=delete&cs_no=<%=dto.getCs_no() %>'" value="삭제"/>
							<input type="button" onclick="location.href='CustomerService.do?command=plus_csboard'" value="목록"/>
						</div>
					
				</table>
			</div>	
			
				      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
			
<%@ include file="./form/footer.jsp" %>
</body>
</html>