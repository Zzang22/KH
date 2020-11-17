<%@page import="com.bb.dto.CustomerServiceDto"%>
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
<script type="text/javascript" src="//cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>
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
    border-top: 1px solid #dadada;
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
 	left: 700px;
 	top: 650px;
 	
}
th{
	border-right: 1px solid #dadada;
}
 th, td {
        border-bottom: 1px solid #dadada;
        padding: 10px;

      }
#title{
	position: relative;
	left: 5px;
    display : block;
	
	width: 500px;
	height: 40px;
	border: solid 1px #dadada;
	/*width: 100%;  원하는 너비 설정 */ 
	line-height : normal; /* line-height 초기화 */
	
}      
#cs_admin{
 padding-bottom: 350px;
}

</style>
</head>
<body>
<%@ include file="./form/nav_user.jsp" %>
	<%
		CustomerServiceDto dto = (CustomerServiceDto) request.getAttribute("dto");
	%>
  <div id="cs_admin">
	<h1>고객센터 >></h1><h3> 관리자</h3>

	<form action="CustomerService.do" method="post">
		<input type="hidden" name="command" value="updateres" /> 
		<input type="hidden" name="cs_no" value="<%=dto.getCs_no()%>" />
		<table>
			<tr>
				<th>글번호</th>
				<td><%=dto.getCs_no()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" id="title" name="cs_title" value="<%=dto.getCs_title()%>" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" id="ckeditor" name="cs_content"><%=dto.getCs_content()%></textarea></td>
				<script>
 								CKEDITOR.replace('ckeditor'
                					, {width: 800});
 								CKEDITOR.replace('ckeditor'
 	                					, {height: 400});
 								
				</script>
			</tr>
			
			<div class="button">		
				<input type="submit" value="수정" /> 
				<input type="button" value="취소" onclick="location.href='CustomerService.do?command=plus_csboard'" />
			</div>	
		</table>
		<br/>
		<br/>

	</form>
   </div>	
   
   	      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
   
	<%@ include file="./form/footer.jsp" %>
</body>
</html>