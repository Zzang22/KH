<%@page import="java.util.List"%>
<%@page import="com.bb.model.dao.NewsDao"%>
<%@page import="com.bb.dto.NewsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
body {
	background-color: #FAFAFA;
	color: #424242;
}

/*제목 위치*/
#title {
	position: absolute;
	top: 130px;
	left: 53%;
	margin-left: -90px;
}

#itnews_list {
	position: absolute;
	top: 280px;
	left: 50%;
	margin-left: -450px;
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
<%

NewsDao dao = new NewsDao();
List<NewsDto> list = dao.itnews();

%>
<body>
	<%@ include file="./form/nav_user.jsp"%>



	<div id="title">
		<h1>오늘의 기사</h1>
	</div>

	<div id="itnews_list">
		<form action="news.do" action="post">
			<table>
				<col width="100" />
				<col width="800" />

				<tr>
					<th>회사명</th>
					<th>기사 제목</th>

				</tr>
				<%
      for(NewsDto dto : list){
	%>
				<tr>
					<td style="text-align: center;"><%=dto.getNews_writer() %></td>
					<td style="text-align: center;"><a href="<%=dto.getNews_link() %>"><%=dto.getNews_title() %></a></td>
					
					<!-- <td><%=dto.getNews_link() %></td> -->
					<!-- <td><input type="text" name="news_title" value=<%=dto.getNews_title() %> /></td> -->
					<!-- <a href="#" target="_blank" -->
				</tr>

				<%
					}
				%>
			</table>

		</form>
	</div>
	
		      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
	

</body>
</html>