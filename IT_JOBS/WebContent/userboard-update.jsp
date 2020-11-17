
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.button>input {
	margin-top: 40px;
	width: 100px;
	height: 20px;
	background: #819FF7;
	border-style: none;
	color: white;
	font-size: 10pt;
	position: relative;
	right: -1400px;
	top: -440px;
}

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

table {
	width: 100%;
	border-top: 1px solid #444444;
	border-collapse: collapse;
}

th, td {
	border-bottom: 1px solid #444444;
	padding: 10px;
}

#userboard_update {
	position: absolute;
	top: 280px;
	left: 50%;
	margin-left: -750px;
}
</style>
</head>
<body>
	<jsp:include page="form/nav_user.jsp"></jsp:include>

	<div id="title">
		<h1>수정 페이지</h1>
	</div>
	<div id="userboard_update">

		<form action="userboard.do" method="post" >
			<input type="hidden" name="command" value="userboard-updateform" /> <input
				type="hidden" name="userboard_no" value="${userdto.userboard_no }" />
			<table border="1" style="margin-left: 430px; width: 700px;">
				<tr>
					<th>제목</th>
					<td colspan="2"><input type="text" name="userboard_title"
						value="${userdto.userboard_title }" style="width: 450px;"/></td>
				</tr>
				<tr>
					<th>작성자</th>
					
					<td style="text-align: left;">${userdto.member_id }<td td style="text-align:center; width: 100px;"><fmt:formatDate value="${userdto.userboard_regdate }" type="both" pattern="yyyy-MM-dd"/></td></td>
					

				</tr>
				<tr>
					<th>내용</th>
					<td colspan="2"><textarea rows="40" cols="60" style="margin: 0px;width: 550px; height: 560px; resize: none;" name="userboard_content">${userdto.userboard_content }</textarea></td>
				</tr>

			</table>
			<p style="margin-left: 430px;">
			<input type="submit" value="수정 완료" /> <input type="button"
				value="수정 취소"
				onclick="location.href='userboard.do?command=userboard-detail&userboard_no=${userdto.userboard_no}'" />
	</p>
		</form>

		<br /> <br /> <br /> <br /> <br />
	</div>

</body>
</html>