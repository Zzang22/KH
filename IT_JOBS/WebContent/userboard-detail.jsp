
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	

	
	function appendTaInsert(count){
		$("#answeranswer"+count).append('<th><input type="hidden" name="command" value="answeranswer-insert"/><input type="hidden" id="userboard_no'+count+'" name="userboard_no" value="${userdto.userboard_no }"/><textarea id="answer_content'+count+'" name="answer_content" rows="3" cols="50" style="width:537px; resize: vertical;"></textarea></th><th vertical-align: middle;><input type="submit" value="답글 등록" /><input type="button" value="취소" onclick="removeInsert('+count+')"/></th>');
		$("#answeranswer"+count).append($("#answer_groupno"+count));
		$("#answeranswer"+count).append($("#answer_groupseq"+count));
		$("#answeranswer"+count).append($("#answer_titletab"+count));
			
			
	}

	
	
	function ModiTaUpdate(count){
		$("#answer-update"+count).html('<form action="userboard.do" method="post" id="update'+count+'"><input type="hidden" name="userboard_no" value="${userdto.userboard_no }"/><input type="hidden" name="command" value="answer-update"/><textarea rows="5" cols="60" name="answer_content" style="margin: 0px; width:410px; height:31px; resize:none;"></textarea><input type="submit" value="수정 완료"/><input type="button" name="" value="취소"/></form>');
		$("#update"+count).append($("#answer_no"+count));
	
	}
	function removeInsert(count){
		$("#answeranswer"+count).toggle();
	}

	
	

	
	
</script>

<style type="text/css">
 .button > input{ 	margin-top: 40px; 	width: 100px;     height: 20px;     background: #819FF7;     border-style: none;     color: white;     font-size: 10pt;     position: relative;     right: -1400px;     top: -440px; }

 body { 	background-color: #FAFAFA; 	color: #424242; } 
  /*제목 위치*/ 
  #title { 	position: absolute; 	top: 130px; 	left: 53%; 	margin-left: -90px; }
  
  table { 	width: 100%; 	border-top: 1px solid #444444; 	border-collapse: collapse; } 
   th, td { 	border-bottom: 1px solid #444444; 	padding: 10px; }

#userboard_list { 	position: absolute; 	top: 280px; 	left: 50%; 	margin-left: -750px; }
</style>
</head>
<body>
<jsp:include page="form/nav_user.jsp"></jsp:include>

	<div id="title"> 
		<h1>후기게시판</h1> 
	</div>
	<div id="userboard_list">
	
	<form action="userboard.do" method="post" id="userboard" >
	
		<fieldset form="userboard" style="align-self: center; margin-left:420px; width: 655px; " >
			<table border="1" style=" height: 100px; margin: 5px; text-align: center;">
				<tr>
					<th style="width:100px;">제목</th>
					<td style="text-align: left;" colspan="2">${userdto.userboard_title }</td>
					
				</tr>
				<tr>
					<th>작성자</th>
					<td style="text-align: left;">${userdto.member_id }<td style="text-align:center; width: 100px;"><fmt:formatDate value="${userdto.userboard_regdate }" type="both" pattern="yyyy-MM-dd"/></td></td>
					
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="2"><textarea rows="40" cols="60" style="margin: 0px;width: 550px; height: 560px; resize: none;" readonly="readonly">${userdto.userboard_content }</textarea></td>
				</tr>

			</table>
			<input type="button" value="수정" class="button"
				onclick="location.href='userboard.do?command=userboard-update&member_no=${userdto.member_no}&userboard_no=${userdto.userboard_no }'" />
			<input type="button" value="삭제"
				onclick="location.href='userboard.do?command=userboard-delete&member_no=${userdto.member_no}&userboard_no=${userdto.userboard_no }'" />
			<input type="button" value="돌아가기"
				onclick="location.href='userboard.do?command=userboard-list'" />
		</fieldset>
		</form>
		<table id="answer_table" style="width: 683px; height: 100px; margin-left: 420px;">
		
			<c:choose>
				<c:when test="${empty answerdto }">
					<tr>
						<th width="400">----------작성된 댓글이 존재하지 않습니다----------</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${answerdto }" var="answerdto" varStatus="status">
						<tr>
							<td style="width: 100px; ">${answerdto.member_id }</td>
							<td id="answer-update${status.count }" style="width: 350px; resize: none; font-family: sans-serif; ">
							<c:forEach begin="1" end="${answerdto.answer_titletab }">
								&nbsp;
							</c:forEach>
							<c:if test="${answerdto.answer_titletab != 0 }">ㄴ</c:if>
							${answerdto.answer_content }<input type="hidden" name="answer_no" value="${answerdto.answer_no }"/>
							</td>
							
							<td style="text-align: right; width: 48px;">
							<input type="button" value="답글" onclick="appendTaInsert('${status.count }')" />
							<input type="hidden" id="answer_no${status.count }" name="answer_no" value="${answerdto.answer_no }"/>
									<input type="hidden" id="answer_groupno${status.count }" name="answer_groupno" value="${answerdto.answer_groupno }"/>
									<input type="hidden" id="answer_groupseq${status.count }" name="answer_groupseq" value="${answerdto.answer_groupseq }"/>
									<input type="hidden" id="answer_titletab${status.count }" name="answer_titletab" value="${answerdto.answer_titletab }"/><a style="display: none;">${answerdto.answer_no },${answerdto.answer_groupno },${answerdto.answer_groupseq },${answerdto.answer_titletab }</a>
							</td>
							<c:if test="${answerdto.member_no == login.member_no }">
							
								<td style="text-align: right; width: 90px; border-bottom: 1px solid #444444;">
									<input type="button" id="TA" value="수정" onclick="ModiTaUpdate('${status.count }')" /> 
									<input type="button" value="삭제" onclick="location.href='userboard.do?command=answer-delete&answer_no=${answerdto.answer_no}&userboard_no=${answerdto.userboard_no }'" />
									<input type="hidden" name="status_count" value="${status.count }"/>
									
								</td>
							</c:if>
						</tr>
						<tr>
						<th colspan="4">
						<form id="answeranswer${status.count }" action="userboard.do" method="post">
						
						
						</form>
						</th>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<form action="userboard.do" method="post" id="answerboardinsertupdate">
			
			
			<input type="hidden" name="command" value="answer-insert" /> 
			<input type="hidden" name="userboard_no" value="${userdto.userboard_no }" />

			<table border="1" style="width: 653px; height: 100px; margin-left:420px; text-align: center;" >
				<tr>
					<c:choose>
						<c:when test="${empty login.member_id }">
						<td colspan="5"><textarea name="answer_content" rows="4" cols="75" style="margin: 0px; width: 590px; height: 88px; resize: none;"></textarea></td>
						</c:when>
						<c:otherwise>
							<th>${login.member_id }</th><td colspan="1"><textarea name="answer_content" rows="4" cols="75" style="margin: 0px; width: 495px; height: 72px; resize: none;"></textarea></td>
						</c:otherwise>
					</c:choose>
					<td><input type="submit" value="댓글 등록" /></td>
				</tr>
			</table>
		</form>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		</div>
		
		
	      <jsp:include page="chat/chat_aside.jsp"></jsp:include>

		
</body>
</html>