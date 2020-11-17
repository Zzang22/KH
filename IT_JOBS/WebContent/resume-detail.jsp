<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="resources/js/resume_detail.js"></script>
<script>

function rsAcUpdate() {
	var updateAcTable = $('#ac_table').clone();
	$("#ac_table").hide();
	$("#ac_update_table").append(updateAcTable);


	var $ac_name = updateAcTable.find('.ac_name');
	var $ac_dept = updateAcTable.find('.ac_dept');
	for (var i = 0; i < $ac_name.length; i++) {
		var ac_name_val = $ac_name.eq(i).html();
		var ac_dept_val = $ac_dept.eq(i).html();


		$ac_name.eq(i).html('<input type="text" name="rs_ac_name" value="' + ac_name_val + '">');
		$ac_dept.eq(i).html('<input type="text" name="rs_ac_dept" value="' + ac_dept_val + '">');

	}


	var $ac_grad = updateAcTable.find('.ac_grad');
	var rs_ac_grad = updateAcTable.find('input[name=ac_grad_input]');

	for (var i = 0; i < rs_ac_grad.length; i++) {
		var val = rs_ac_grad.eq(i).val();
		if (val == 'G') {
			$ac_grad.eq(i).html('<select name="rs_ac_grad"><option value="G" selected>졸업</option><option value="P">졸업예정</option></select>');
		} else if (val == 'P') {
			$ac_grad.eq(i).html('<select name="rs_ac_grad"><option value="G" >졸업</option><option value="P" selected>졸업예정</option></select>');
		}
	}

	var $ac_date = updateAcTable.find('.ac_date');
	var ac_start_year = updateAcTable.find('.ac_start_year');
	var ac_start_month = updateAcTable.find('.ac_start_month');
	var ac_end_year = updateAcTable.find('.ac_end_year');
	var ac_end_month = updateAcTable.find('.ac_end_month');


	for (var i = 0; i < ac_start_year.length; i++) {
		var start_year = ac_start_year.eq(i).html();
		var start_month = ac_start_month.eq(i).html();
		var end_year = ac_end_year.eq(i).html();
		var end_month = ac_end_month.eq(i).html();


		$ac_date.eq(i).html('<select name="rs_ac_start_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }">${i }</option></c:forEach></select>년 <select name="rs_ac_start_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월 ~ <select name="rs_ac_end_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }">${i }</option></c:forEach></select>년 <select name="rs_ac_end_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월');

		$("select[name=rs_ac_start_year]").eq(i).val(start_year).prop("selected", true);
		$("select[name=rs_ac_start_month]").eq(i).val(start_month).prop("selected", true);
		$("select[name=rs_ac_end_year]").eq(i).val(end_year).prop("selected", true);
		$("select[name=rs_ac_end_month]").eq(i).val(end_month).prop("selected", true);

	}


	updateAcTable.append('<input type="submit" value="수정">');
	updateAcTable.append('<input type="button" value="학력추가" onclick="insertAcTr();">');

	for (var i = 1; i < updateAcTable.find('tr').length; i++) {
		updateAcTable.find('tr').eq(i).append($("<td>").append('<input type="button" value="지우기" onclick="delTr(this)">'));
	}


	$('#updateAcBtn').hide();
	$('#cancleAcBtn').show();

}

function insertAcTr() {

	var ac_table = $("#ac_update_table").children();
	var $tr = $("<tr class='ac_tr'>");

	$tr.append($("<td class='ac_name'>").append('<input type="text" name="rs_ac_name" />'));
	$tr.append($("<td class='ac_dept'>").append('<input type="text" name="rs_ac_dept" />'));
	$tr.append($("<td class='ac_grad'>").append('<select name="rs_ac_grad"><option value="G">졸업</option><option value="P">졸업예정</option></select>'));
	$tr.append($("<td class='ac_date'>").append('<select name="rs_ac_start_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }"<c:if test="${i  eq 2020}">selected</c:if>>${i }</option></c:forEach></select>년 <select name="rs_ac_start_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월 ~ <select name="rs_ac_end_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }"<c:if test="${i  eq 2020}">selected</c:if>>${i }</option></c:forEach></select>년 <select name="rs_ac_end_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월'));
	$tr.append($("<td>").append('<input type="button" value="지우기" onclick="delTr(this)">'));

	ac_table.append($tr);
}

function rsCrUpdate(){
	var updateCrTable = $('#cr_table').clone();
	$("#cr_table").hide();
	$("#cr_update_table").append(updateCrTable);


	var $cr_name = updateCrTable.find('.cr_name');
	var $cr_duty = updateCrTable.find('.cr_duty');
	var $cr_dept = updateCrTable.find('.cr_dept');
	
	for (var i = 0; i < $cr_name.length; i++) {
		var cr_name_val = $cr_name.eq(i).html();
		var cr_duty_val = $cr_duty.eq(i).html();
		var cr_dept_val = $cr_dept.eq(i).html();

		$cr_name.eq(i).html('<input type="text" name="rs_cr_name" value="' + cr_name_val + '">');
		$cr_duty.eq(i).html('<input type="text" name="rs_cr_duty" value="' + cr_duty_val + '">');
	
		$cr_dept.eq(i).html('<select name="rs_cr_dept"><option value="사원">사원</option><option value="대리">대리</option><option value="주임">주임</option><option value="과장">과장</option><option value="차장">차장</option><option value="부장">부장</option><option value="상무">상무</option><option value="전무">전무</option><option value="대표">대표</option></select>');
		$("select[name=rs_cr_dept]").eq(i).val(cr_dept_val).prop("selected", true);

	}
	

	var $cr_date = updateCrTable.find('.cr_date');
	var cr_start_year = updateCrTable.find('.cr_start_year');
	var cr_start_month = updateCrTable.find('.cr_start_month');
	var cr_end_year = updateCrTable.find('.cr_end_year');
	var cr_end_month = updateCrTable.find('.cr_end_month');


	for (var i = 0; i < cr_start_year.length; i++) {
		var start_year = cr_start_year.eq(i).html();
		var start_month = cr_start_month.eq(i).html();
		var end_year = cr_end_year.eq(i).html();
		var end_month = cr_end_month.eq(i).html();


		$cr_date.eq(i).html('<select name="rs_cr_start_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }">${i }</option></c:forEach></select>년 <select name="rs_cr_start_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월 ~ <select name="rs_cr_end_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }">${i }</option></c:forEach></select>년 <select name="rs_cr_end_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월');

		$("select[name=rs_cr_start_year]").eq(i).val(start_year).prop("selected", true);
		$("select[name=rs_cr_start_month]").eq(i).val(start_month).prop("selected", true);
		$("select[name=rs_cr_end_year]").eq(i).val(end_year).prop("selected", true);
		$("select[name=rs_cr_end_month]").eq(i).val(end_month).prop("selected", true);

	}


	updateCrTable.append('<input type="submit" value="수정">');
	updateCrTable.append('<input type="button" value="경력추가" onclick="insertCrTr();">');

	for (var i = 1; i < updateCrTable.find('tr').length; i++) {
		updateCrTable.find('tr').eq(i).append($("<td>").append('<input type="button" value="지우기" onclick="delCrTr(this)">'));
	}


	$('#updateCrBtn').hide();
	$('#cancleCrBtn').show();	

}

function insertCrTr(){
	var cr_table = $("#cr_update_table").children();
	var $tr = $("<tr class='cr_tr'>");

	$tr.append($("<td class='cr_name'>").append('<input type="text" name="rs_cr_name" />'));
	$tr.append($("<td class='cr_duty'>").append('<input type="text" name="rs_cr_duty" />'));
	$tr.append($("<td class='cr_dept'>").append('<select name="rs_cr_dept"><option value="사원">사원</option><option value="대리">대리</option><option value="주임">주임</option><option value="과장">과장</option><option value="차장">차장</option><option value="부장">부장</option><option value="상무">상무</option><option value="전무">전무</option><option value="대표">대표</option></select>'));
	$tr.append($("<td class='cr_date'>").append('<select name="rs_cr_start_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }">${i }</option></c:forEach></select>년 <select name="rs_cr_start_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월 ~ <select name="rs_cr_end_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }">${i }</option></c:forEach></select>년 <select name="rs_cr_end_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월'));
	$tr.append($("<td>").append('<input type="button" value="지우기" onclick="delCrTr(this)">'));

	cr_table.append($tr);
}

function rsLcUpdate(){
	var updateLcTable = $('#lc_table').clone();
	$("#lc_table").hide();
	$("#lc_update_table").append(updateLcTable);
	

	var $lc_name = updateLcTable.find('.lc_name');
	var $lc_inst = updateLcTable.find('.lc_inst');
	
	for (var i = 0; i < $lc_name.length; i++) {
		var lc_name_val = $lc_name.eq(i).html();
		var lc_inst_val = $lc_inst.eq(i).html();

		$lc_name.eq(i).html('<input type="text" name="rs_lc_name" value="' + lc_name_val + '">');
		$lc_inst.eq(i).html('<input type="text" name="rs_lc_inst" value="' + lc_inst_val + '">');
	}
	

	var $lc_date = updateLcTable.find('.lc_date');
	var lc_date_year = updateLcTable.find('.lc_date_year');
	var lc_date_month = updateLcTable.find('.lc_date_month');
	var lc_date_day = updateLcTable.find('.lc_date_day');

	for (var i = 0; i < lc_date_year.length; i++) {
		var year = lc_date_year.eq(i).html();
		var month = lc_date_month.eq(i).html();
		var day = lc_date_day.eq(i).html();
		
		$lc_date.eq(i).html('<select name="rs_lc_date_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }" <c:if test="${i  eq 2020}">selected</c:if>>${i }</option></c:forEach></select>년<select name="rs_lc_date_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월<select name="rs_lc_date_day"><c:forEach var="i" begin="1" end="31"><option value="${i }">${i }</option></c:forEach></select>일');

		$("select[name=rs_lc_date_year]").eq(i).val(year).prop("selected", true);
		$("select[name=rs_lc_date_month]").eq(i).val(month).prop("selected", true);
		$("select[name=rs_lc_date_day]").eq(i).val(day).prop("selected", true);
	}	

	updateLcTable.append('<input type="submit" value="수정">');
	updateLcTable.append('<input type="button" value="자격증추가" onclick="insertLcTr();">');

	for (var i = 1; i < updateLcTable.find('tr').length; i++) {
		updateLcTable.find('tr').eq(i).append($("<td>").append('<input type="button" value="지우기" onclick="delLcTr(this)">'));
	}


	$('#updateLcBtn').hide();
	$('#cancleLcBtn').show();

}


function insertLcTr(){
	var lc_table = $("#lc_update_table").children();
	var $tr = $("<tr class='lc_tr'>");

	$tr.append($("<td class='lc_name'>").append('<input type="text" name="rs_lc_name" />'));
	$tr.append($("<td class='lc_inst'>").append('<input type="text" name="rs_lc_inst" />'));
	$tr.append($("<td class='lc_date'>").append('<select name="rs_lc_date_year"><c:forEach var="i" begin="1980" end="2021"><option value="${i }" <c:if test="${i  eq 2020}">selected</c:if>>${i }</option></c:forEach></select>년<select name="rs_lc_date_month"><c:forEach var="i" begin="1" end="12"><option value="${i }">${i }</option></c:forEach></select>월<select name="rs_lc_date_day"><c:forEach var="i" begin="1" end="31"><option value="${i }">${i }</option></c:forEach></select>일'));
	$tr.append($("<td>").append('<input type="button" value="지우기" onclick="delLcTr(this)">'));

	lc_table.append($tr);
}


function rsUpdate(){
	var title = $('.rs_title').html();
	$('.rs_title').html('<input type="text" name="rs_title" value="'+title+'">');
	
	$('#appendTr').append('<td colspan="3" align="right">증명사진 수정 : <input type="file" value="증명사진수정" name="rs_img"></td>');
	$('#rs_table').append('<input type="submit" value="수정">');
	
	$('#updateRsBtn').hide();
	$('#cancleRsBtn').show();
}

function cancleRs(){
	$('.rs_title').html('${resume.rs_title }');
	$('#appendTr').children().remove();
	$('#rs_table').children().last().remove();

	
	$('#updateRsBtn').show();
	$('#cancleRsBtn').hide();
}

function selfUpdate(){
	$('textarea[name=rs_selfintro]').removeAttr('readonly');
	$('#self_table').append('<input type="submit" value="수정">');
	
	$('#updateSelfBtn').hide();
	$('#cancleSelfBtn').show();
}

function cancleSelf(){
	$('#selfTd').html('<textarea rows="20" cols="90" name="rs_selfintro" readonly="readonly">${resume.rs_selfintro }</textarea>');
	$('#self_table').children().last().remove();
	
	$('#updateSelfBtn').show();
	$('#cancleSelfBtn').hide();
}
</script>
<style>
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
#delBtn{
	margin-top: 100px;
    position: absolute;
    right: 50%;
}
</style>
</head>
<body>

	<jsp:include page="form/nav_user.jsp"></jsp:include>
	
	
		
		
	<div id="resume-insert-form">
	<h1 align="center">이력서 상세보기</h1>
			
			<!-- 개인정보 -->
		
			<fieldset id="rs_form">
				<legend>개인정보</legend>
			
			<form action="resumecontroller.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name="command" value="rs_update">
				<input type="hidden" name="rs_no" value="${resume.rs_no }">
					
				<table border="1" id="rs_table">
					<col width="100">
					<col width="650">
					<col width="150">
					<tr>
						<th>이력서 제목</th>
						<td class="rs_title">${resume.rs_title }</td>
						<td rowspan="5" class="rs_img">
							<img alt="img" src="resources/upload_img/${resume.rs_img_name }" style="width: 100px; height: 100px;">
						</td>
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
					<tr id="appendTr">
					</tr>
					
				</table>
			</form>
				
			</fieldset>
			
			
			<div id="updateBtn">
				<input type="button" value="수정" onclick="rsUpdate();" id="updateRsBtn"/>
				<input type="button" value="취소" onclick="cancleRs();" id="cancleRsBtn" style="display: none;"/> 
			</div>
		
		
			<!-- 학력 -->
		
			<fieldset id="ac_form">
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
						</tr>
	
					<c:forEach items="${ac_list }" var="ac_dto"> 
						<input type="hidden" name="rs_ac_no" value="${ac_dto.rs_ac_no }">
						<tr class="ac_tr">
							
							<td class="ac_name">${ac_dto.rs_ac_name }</td>
							<td class="ac_dept">${ac_dto.rs_ac_dept }</td>
							<td class="ac_grad">
								<c:choose>
									<c:when test="${ac_dto.rs_ac_grad eq 'G' }">
										<input type="hidden" name="ac_grad_input" value="G"/>
										졸업
									</c:when>
									<c:when test="${ac_dto.rs_ac_grad eq 'P' }">
										<input type="hidden" name="ac_grad_input" value="P"/>
										졸업예정
									</c:when>
								</c:choose>
							</td>
							<td class="ac_date">
								<span class="ac_start_year">${ac_dto.rs_ac_start_year }</span>년
								<span class="ac_start_month">${ac_dto.rs_ac_start_month }</span>월 ~
								<span class="ac_end_year">${ac_dto.rs_ac_end_year }</span>년
								<span class="ac_end_month">${ac_dto.rs_ac_end_month }</span>월
							</td>
						</tr>
					</c:forEach>
					
					
					</tbody>
				</table>
				
				<form onsubmit="submitTable('#ac_update_form');" id="ac_update_form" method="post">
					<input type="hidden" name="command" value="rs_ac_update">
					<input type="hidden" name="rs_no" value="${resume.rs_no }">
					<div id="ac_update_table"></div>
				</form>
						
			</fieldset>
			
			
		
		<div id="updateBtn">
			<input type="button" value="수정" onclick="rsAcUpdate();" id="updateAcBtn"/>
			<input type="button" value="취소" onclick="cancleAc();" id="cancleAcBtn" style="display: none;"/> 
		</div>
			
			<!-- 경력 -->
		
			<fieldset id="cr_form">
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
						</tr>
					
						<c:forEach items="${cr_list }" var="cr_dto"> 
							<input type="hidden" name="rs_cr_no" value="${cr_dto.rs_cr_no }">
							<tr class="cr_tr">
								
								<td class="cr_name">${cr_dto.rs_cr_name }</td>
								<td class="cr_duty">${cr_dto.rs_cr_duty }</td>
								<td class="cr_dept">${cr_dto.rs_cr_dept }</td>
								<td class="cr_date">
									<span class="cr_start_year">${cr_dto.rs_cr_start_year }</span>년
									<span class="cr_start_month">${cr_dto.rs_cr_start_month }</span>월 ~
									<span class="cr_end_year">${cr_dto.rs_cr_end_year }</span>년
									<span class="cr_end_month">${cr_dto.rs_cr_end_month }</span>월
								</td>
							</tr>
						</c:forEach>
					
					
					
					
					</tbody>
				</table>
				
				<form onsubmit="submitTable('#cr_update_form');" id="cr_update_form" method="post">
					<input type="hidden" name="command" value="rs_cr_update">
					<input type="hidden" name="rs_no" value="${resume.rs_no }">
					<div id="cr_update_table"></div>
				</form>
										
			</fieldset>
			
			<div id="updateBtn">
				<input type="button" value="수정" onclick="rsCrUpdate();" id="updateCrBtn"/>
				<input type="button" value="취소" onclick="cancleCr();" id="cancleCrBtn" style="display: none;"/> 
			</div>
	
	
			<!-- 자격증 -->
			<fieldset id="lc_form">
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
						</tr>
						<c:forEach items="${lc_list }" var="lc_dto"> 
							<input type="hidden" name="rs_lc_no" value="${lc_dto.rs_lc_no }">
							<tr class="lc_tr">
								
								<td class="lc_name">${lc_dto.rs_lc_name }</td>
								<td class="lc_inst">${lc_dto.rs_lc_inst }</td>
								<td class="lc_date">
									<span class="lc_date_year">${lc_dto.rs_lc_date_year }</span>년
									<span class="lc_date_month">${lc_dto.rs_lc_date_month }</span>월
									<span class="lc_date_day">${lc_dto.rs_lc_date_day }</span>일
								</td>
							</tr>
						</c:forEach>
						
						
					</tbody>
				</table>
				
				<form onsubmit="submitTable('#lc_update_form');" id="lc_update_form" method="post">
					<input type="hidden" name="command" value="rs_lc_update">
					<input type="hidden" name="rs_no" value="${resume.rs_no }">
					<div id="lc_update_table"></div>
				</form>
				
			</fieldset>
			
			<div id="updateBtn">
				<input type="button" value="수정" onclick="rsLcUpdate();" id="updateLcBtn"/>
				<input type="button" value="취소" onclick="cancleLc();" id="cancleLcBtn" style="display: none;"/> 
			</div>
	
			<!-- 자소서 -->
		
			<fieldset id="self_form">
				<legend>자기소개서</legend>
			
			<form action="indimember.do" method="post">
				<input type="hidden" name="command" value="self_update">
				<input type="hidden" name="rs_no" value="${resume.rs_no }">
				
				<table border="1" id="self_table">
					<col width="100">
					<col width="800">
					<tbody id="self_body">
						<tr>
							<th>자기소개서</th>
							<td id="selfTd">
								<textarea rows="20" cols="90" name="rs_selfintro" readonly="readonly">${resume.rs_selfintro }</textarea>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			
			</fieldset>
			
			<div id="updateBtn">
				<input type="button" value="수정" onclick="selfUpdate();" id="updateSelfBtn"/>
				<input type="button" value="취소" onclick="cancleSelf();" id="cancleSelfBtn" style="display: none;"/> 
			</div>
		
		
		<div>
			<input id="delBtn" type="button" value="이력서 삭제" onclick="location.href='indimember.do?command=delete_resume&rs_no=${resume.rs_no}'">
		</div>
	
	</div>
		
		         <jsp:include page="chat/chat_aside.jsp"></jsp:include>
		
		
</body>
</html>