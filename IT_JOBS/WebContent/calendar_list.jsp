<%@page import="com.bb.dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
	<% response.setContentType("text/html; charset=UTF-8"); %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style type="text/css">
	*{
	box-sizing: border-box;
	}
/*전체 배경색*/	

	.button> input{
	margin-top: 40px;
	width: 100px;
    height: 20px;
    background: #819FF7;
    border-style: none;
    color: white;
    font-size: 10pt;
    position: relative;
    left: 1000px;
    top: 130px;
}
#wrap_title > img{
  width: 300px;
  height: 200px;
  position: relative;
  top: 300px;
  left: 98px;
}
table{
 position: relative;
 left: 400px;
 top: -50px;
}
#wrap_title > h3{
	position: relative;
	left: 150px;
	top: -30px; 
	color: gray;
}      
#sub_title > h3{
	position: relative;
	left: 370px;
	top: -75px;
	color: green;
}
a{
	text-decoration: none;
	color: black;
}
#cal_list{padding-bottom: 350px;}

</style>
</head>
<body>
<%@ include file="./form/nav_user.jsp" %>
<%
	List<CalendarDto> list = (List<CalendarDto>)request.getAttribute("list");
	//System.out.println("list값 도착:"+list); //여기까지는 도착!!
%>
		<div class="content">
  			<div id="wrap_title">
  			<img src="resources/images/checklist.jpg" alt="list"/>
  			<h3>개인 회원 >> 일정 관리 >></h3>
  			<div id="sub_title">
   				<h3>일정 목록 보기</h3>
   			</div>
   			</div>
  		</div>
		
		<form action="CalendarController.do" method="post" id="muldelform">
			<input type="hidden" name="command" value="muldel"/>
			
			<jsp:useBean id="biz" class="com.bb.model.biz.CalendarBiz"></jsp:useBean>
			
			<table border="1">
				<col width="50"/>
				<col width="50"/>
				<col width="300"/>
				<col width="200"/>
				<col width="100"/>
				
				<tr align="center">
					<th><input type="checkbox" name="all" onclick="allChk(this.checked);"/></th>
					<th>번호</th>
					<th>제목</th>
					<th>일정</th>
					<th>작성일</th>
				</tr>
	
				
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="5">---------작성된 일정이 존재하지 않습니다----------</td>	
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list }" var="dto">
							<tr align="center">
								<th><input type="checkbox" name="chk" value="${dto.cal_no }"></th>
								<td>${dto.cal_no }</td>
								<td><a href="CalendarController.do?command=detail&cal_no=${dto.cal_no}">${dto.cal_title }</a></td>
								<td>
									<jsp:setProperty property="toDates" name="biz" value="${dto.cal_mdate }"/>
									<jsp:getProperty property="toDates" name="biz"/>
								</td>
								<td>
									<fmt:formatDate value="${dto.cal_regdate }" pattern="yyyy:MM:dd"/>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				  <div class="button">
						<input type="submit" value="선택삭제"/>
				  </div>
			</table>
		</form>
		<div id="cal_list">
		</div>
<script>
	$(document).ready(function(){
		$("input[name=chk]").click(function(){
			if($("input[name=chk]").length == $("input[name=chk]:checked").length){
				$("input[name=all]").prop("checked",true);
			}else{
				$("input[name=all]").prop("checked",false);
			}
		});
	});
	
	function allChk(bool){
		$("input[name=chk]").each(function(){
			$(this).prop("checked",bool);
		});
	}
	//유효성 검사
	$(function(){
		$("#muldelform").submit(function(){
			if($("#muldelform input:checked").length == 0){
				alert("하나 이상 체크해 주세요");
				return false;   // 이벤트가 전파되는 것을 막는다.!!
			}
		});
	});

</script>	
         <jsp:include page="chat/chat_aside.jsp"></jsp:include>

<%@ include file="./form/footer.jsp" %>	
</body>
</html>