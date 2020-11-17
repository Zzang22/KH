<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/resume.css"> 

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$(".removeBtn").on("click", function() {
		$(this).closest("tr").remove();
	})
	
	function appendAc() {
		$("#ac_table tbody").append('<tr class="ac_tr"><td><input type="text" name="rs_ac_name" /></td><td><input type="text" name="rs_ac_dept" /></td><td><select name="rs_ac_grad"><option value="G">졸업</option><option value="P">졸업예정</option></select></td><td><select name="rs_ac_start_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }"<c:if test="${i  eq 2020}">selected</c:if>>${i }</option></c:forEach></select>년 <select name="rs_ac_start_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월 ~ <select name="rs_ac_end_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }"<c:if test="${i  eq 2020}">selected</c:if>>${i }</option></c:forEach></select>년 <select name="rs_ac_end_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월</td><td><input type="button" value="지우기" onclick="delTr(this)"></td></tr>');
	}
	
	function appendCr() {
		$("#cr_table tbody").append('<tr class="cr_tr"><td><input type="text" name="rs_cr_name" /></td><td><input type="text" name="rs_cr_duty" /></td><td><select name="rs_cr_dept"><option value="사원">사원</option><option value="대리">대리</option><option value="주임">주임</option><option value="과장">과장</option><option value="차장">차장</option><option value="부장">부장</option><option value="상무">상무</option><option value="전무">전무</option><option value="대표">대표</option></select></td><td><select name="rs_cr_start_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }"<c:if test="${i  eq 2020}">selected</c:if>>${i }</option></c:forEach></select>년 <select name="rs_cr_start_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월 ~ <select name="rs_cr_end_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }"<c:if test="${i  eq 2020}">selected</c:if>>${i }</option></c:forEach></select>년 <select name="rs_cr_end_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월</td><td><input type="button" value="지우기" onclick="delTr(this)"></td></tr>');
	}
	
	function appendLc() {
		$("#lc_table tbody").append('<tr class="lc_tr"><td><input type="text" name="rs_lc_name" /></td><td><input type="text" name="rs_lc_inst" /></td><td><select name="rs_lc_date_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }" <c:if test="${i  eq 2020}">selected</c:if>>${i }</option></c:forEach></select>년					<select name="rs_lc_date_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월 <select name="rs_lc_date_day"><c:forEach var="i" begin="1" end="31"><option value="${i }">${i }</option></c:forEach></select>일</td><td><input type="button" value="지우기" onclick="delTr(this)"></td></tr>');
	}
	
	function delTr(obj) {
	
		var tr = $(obj).parent().parent();
		tr.remove();
	}
</script>
<style>
	#main-form{
		margin-top: 10%;
	}
	#resume-insert-form {
	position: absolute;
	top: 10%;
	left: 25%;
	margin-bottom: 15%;
	margin-top: 5%;
	
}

fieldset {
	margin: 50px;
	margin-left: 0;
	margin-bottom: 10px;
	border: 1px solid #cccccc;
}

input[type=text] {
	width: 95%;
}


#mainBtn {
	float: right;
    margin: 20px;
}

#updateBtn{
	margin-right: 50px;
    float: right;
}

table, td, th {
    border: 1px solid #cccccc;
}
th{
	color: #585858;
}
legend{
	color: #848484;
}
</style>
</head>
<body>

	<jsp:include page="form/nav_user.jsp"></jsp:include>
	
	
	<div id="main-form">
	<div id="main-title"><h1 align="center">이력서 작성</h1></div>
	
	<form action="resumecontroller.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="command" value="resume-insertform">


	
		<div id="resume-insert-form">
			<fieldset>
				<legend>개인정보</legend>
				<table border="1">
					<col width="100">
					<col width="800">
					<tr>
						<th>이력서 제목</th>
						<td><input type="text" name="rs_title"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${login.member_name }</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${login.member_addr }</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td>${login.member_phone }</td>
					</tr>
		
					<tr>
						<th>이메일</th>
						<td>${login.member_email }</td>
					</tr>
					<tr>
						<th>증명사진</th>
						<td>
							<input type="file" value="파일 선택" name="rs_img"/>
						</td>
					</tr>
				</table>
			</fieldset>
	
	
			<fieldset>
				<legend>학력</legend>
				<table border="1" id="ac_table">
					<col width="200">
					<col width="200">
					<col width="100">
					<col width="350">
					<col width="50">
					<tbody id="ac_body">
						<tr>
							<th>학교명</th>
							<th>학과명</th>
							<th>졸업여부</th>
							<th>재학 기간</th>
							<th></th>
						</tr>
	
						<tr class="ac_tr">
							<td><input type="text" name="rs_ac_name" /></td>
							<td><input type="text" name="rs_ac_dept" /></td>
							<td><select name="rs_ac_grad">
									<option value="G">졸업</option>
									<option value="P">졸업예정</option>
							</select></td>
							<td><select name="rs_ac_start_year">
									<c:forEach var="i" begin="1980" end="2021">
										<option value="${i }"
											<c:if test="${i  eq 2020}">selected</c:if>>${i }</option>
									</c:forEach>
							</select>년 <select name="rs_ac_start_month">
									<c:forEach var="i" begin="1" end="12">
										<option value="${i }">${i }</option>
									</c:forEach>
							</select>월 ~ <select name="rs_ac_end_year">
									<c:forEach var="i" begin="1980" end="2021">
										<option value="${i }"
											<c:if test="${i  eq 2020}">selected</c:if>>${i }</option>
									</c:forEach>
							</select>년 <select name="rs_ac_end_month">
									<c:forEach var="i" begin="1" end="12">
										<option value="${i }">${i }</option>
									</c:forEach>
							</select>월</td>
	
							<td><input type="button" value="지우기" onclick="delTr(this)">
							</td>
						</tr>
					</tbody>
				</table>
				<input type="button" value="학력추가" onclick="appendAc();">
			</fieldset>
	
			<!-- 경력 -->
			<fieldset>
				<legend>경력</legend>
				<table border="1" id="cr_table">
					<col width="200">
					<col width="200">
					<col width="100">
					<col width="350">
					<col width="50">
					<tbody id="cr_body">
						<tr>
							<th>회사명</th>
							<th>담당업무</th>
							<th>직급</th>
							<th>근무 기간</th>
							<th></th>
						</tr>
	
						<tr class="cr_tr">
							<td><input type="text" name="rs_cr_name" /></td>
							<td><input type="text" name="rs_cr_duty" /></td>
							<td><select name="rs_cr_dept">
									<option value="사원">사원</option>
									<option value="대리">대리</option>
									<option value="주임">주임</option>
									<option value="과장">과장</option>
									<option value="차장">차장</option>
									<option value="부장">부장</option>
									<option value="상무">상무</option>
									<option value="전무">전무</option>
									<option value="대표">대표</option>
							</select></td>
							<td><select name="rs_cr_start_year">
									<c:forEach var="i" begin="1980" end="2021">
										<option value="${i }"
											<c:if test="${i  eq 2020}">selected</c:if>>${i }</option>
									</c:forEach>
							</select>년 <select name="rs_cr_start_month">
									<c:forEach var="i" begin="1" end="12">
										<option value="${i }">${i }</option>
									</c:forEach>
							</select>월 ~ <select name="rs_cr_end_year">
									<c:forEach var="i" begin="1980" end="2021">
										<option value="${i }"
											<c:if test="${i  eq 2020}">selected</c:if>>${i }</option>
									</c:forEach>
							</select>년 <select name="rs_cr_end_month">
									<c:forEach var="i" begin="1" end="12">
										<option value="${i }">${i }</option>
									</c:forEach>
							</select>월</td>
	
							<td><input type="button" value="지우기" onclick="delTr(this)">
							</td>
						</tr>
					</tbody>
				</table>
				<input type="button" value="경력추가" onclick="appendCr();">
			</fieldset>
	
	
			<!-- 자격증 -->
			<fieldset>
				<legend>자격증</legend>
				<table border="1" id="lc_table">
					<col width="250">
					<col width="250">
					<col width="350">
					<col width="50">
					<tbody id="lc_body">
						<tr>
							<th>자격증명</th>
							<th>발행처/기관</th>
							<th>취득일</th>
							<th></th>
						</tr>
						
						<tr class="lc_tr">
							<td><input type="text" name="rs_lc_name" /></td>
							<td><input type="text" name="rs_lc_inst" /></td>
							<td>
								<select name="rs_lc_date_year">
									<c:forEach var="i" begin="1980" end="2021">
										<option value="${i }" <c:if test="${i  eq 2020}">selected</c:if>>${i }</option>
									</c:forEach>
								</select>년
								
								<select name="rs_lc_date_month">
									<c:forEach var="i" begin="1" end="12">
										<option value="${i }">${i }</option>
									</c:forEach>
								</select>월 
								
								<select name="rs_lc_date_day">
									<c:forEach var="i" begin="1" end="31">
										<option value="${i }">${i }</option>
									</c:forEach>
								</select>일
							</td>
							<td>
								<input type="button" value="지우기" onclick="delTr(this)">
							</td>
						</tr>
					</tbody>
				</table>
				<input type="button" value="자격증추가" onclick="appendLc();">
			</fieldset>
	
	
			<!-- 자소서 -->
			<fieldset>
				<legend>자기소개서</legend>
				<table border="1" id="self_table">
					<col width="100">
					<col width="800">
					<tbody id="self_body">
						<tr>
							<th>자기소개서</th>
							<td><textarea rows="20" cols="90" name="rs_selfintro"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			
			<div id="submitBtn">
				<input type="submit" value="이력서 제출"/>
				<input type="button" value="취소" onclick="location.href='indimember.do?command=resume'">		
			</div>
		</div>
		
	</form>
	</div>
	
	         <jsp:include page="chat/chat_aside.jsp"></jsp:include>
	
</body>
</html>