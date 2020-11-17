<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

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

#field {
	position: absolute;
	top: 470px;
	left: 53.4%;
	margin-left: -400px;
}

#field table {
	border-spacing: 45px;
}

#career table {
	border-spacing: 50px;
}

#career table tr td {
	width: fit-content;
}

#career {
	position: absolute;
	top: 1137px;
	left: 41%;
	margin-left: -420px;
}

#salary {
	position: absolute;
	top: 1681px;
	left: 29.6%;
	margin-left: -120px;
	width: 876px;
	height: 170px;
}

fieldset {
	border: none;
}
</style>

<style>
input[type="text"] {
	width: 300px;
	height: 50px;
	line-height: normal;
	font-family: inherit;
	outline-style: none;
	appearance: none;
	border: 2px solid #aaa;
	border-radius: 4px;
	margin: 8px 0;
	outline: none;
	padding: 8px;
	box-sizing: border-box;
	transition: .3s;
}

input[type=text]:focus {
	border-color: dodgerBlue;
	box-shadow: 0 0 8px 0 dodgerBlue;
}
</style>

<style>
#career table tr td label span {
	width: 140px;
	height: 91px;
}

label {
	cursor: pointer;
}

input[type="checkbox"] {
	display: none;
}

input[type="checkbox"]+label span {
	display: inline-block;
	width: 24px;
	height: 24px;
	margin: -2px 10px 0 0;
	vertical-align: middle;
	background: url(resources/images/checkbox.svg) left top no-repeat;
	cursor: pointer;
	background-size: cover;
}

input[type="checkbox"]:checked+label span {
	background: url(resources/images/checkbox.svg) -26px top no-repeat;
	background-size: cover;
}
</style>

<style>
input[type="radio"] {
	display: none;
}

input[type="radio"]+span {
	margin: 10px;
	display: inline-block;
	width: 75px;
	height: 75px;
	position: relative;
	background-color: #ecf2f9;
	border-radius: 10%;
	color: #a6aa9c;
	text-align: center;
	overflow: hidden;
}

input[type="radio"]:checked+span {
	background: #7595e6;
	color: #fff;
}
</style>

<style>
#stepOne {
	position: absolute;
	top: 320px;
	left: 56%;
	margin-left: -540px;
}

#stepTwo {
	position: absolute;
	top: 975px;
	left: 56%;
	margin-left: -540px;
}

#stepThree {
	position: absolute;
	top: 1490px;
	left: 56%;
	margin-left: -540px;
}
</style>

<style>
#airOne {
	position: absolute;
	top: 700px;
	left: 2%;
}

#airTwo {
	position: absolute;
	top: 1690px;
	left: 72%;
}

#sky {
	width: 100%;
}
</style>

<style>
.button {
	display: none;
}

#search label {
	position: absolute;
	width: 50%;
	border-radius: 9px;
	background-color: #7595e6;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 28px;
	padding: 20px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
}

#search label span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

#search label span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

#search label:hover span {
	padding-right: 25px;
}

#search label:hover span:after {
	opacity: 1;
	right: 0;
}

#search {
    position: absolute;
    top: 2130px;
    left: 34%;
    width: 876px;
    height: 260px;
}
</style>

</head>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script type="text/javascript">

	function search(){
	
		var jof = document.JobOfferDivisionListForm;
		var min = parseInt(jof.min_salary.value.replace(/,/g,""));
		var max = parseInt(jof.max_salary.value.replace(/,/g,""));
	    var field = jof.field;
	    var career = jof.career;
	  
	    var salary_chk = 0;
	    var field_chk = 0;
	    var career_chk = 0;
	  
		if (min > max) {
			salary_chk++;
		}

		for (var i = 0 ; i < field.length ; i++) {
			if (jof.field[i].checked) {
				field_chk++;
			}
		}
	  
		for (var i = 0 ; i < career.length ; i++) {
			if (jof.career[i].checked) {
				career_chk++;
			}
		}
		
		if (field_chk == 0) {
			alert("직무를 최소한 한 개 이상 선택해주세요");
		} else if(career_chk == 0) {
			alert("경력을 최소한 한 개 이상 선택해주세요");
		} else if(!min || !max) {
			alert("최소 연봉과 최대 연봉을 모두 입력해주세요");
		} else if (salary_chk == 1) {
			alert("최대연봉을 최소연봉 보다 크게 입력해주세요");
		} else if (max > 1000000000) {
			alert("최대연봉은 10억원을 넘지 못합니다");
		} else {
			JobOfferDivisionListForm.submit();
		}
			
	}

	$(document).ready(function() {

		$("input[name=field]").click(function() {
			if ($("input[name=field]").length == $("input[name=field]:checked").length) {
				$("input[name=fieldAll]").prop("checked", true);
			} else {
				$("input[name=fieldAll]").prop("checked", false);
			}
		});
		
	    $("#checkall").click(function(){
	        if($("#checkall").prop("checked")){
	            $("input[name=field]").prop("checked",true);
	        }else{
	            $("input[name=field]").prop("checked",false);
	        }
	    })

	});

	function inputNumberFormat(obj) {
    	obj.value = comma(uncomma(obj.value));
	}

	function comma(str) {
 	   str = String(str);
 	   return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	}

	function uncomma(str) {
		str = String(str);
		return str.replace(/[^\d]+/g, '');
	}
	
</script>

<body>

	<%@ include file="./form/nav_user.jsp"%>

	<form name="JobOfferDivisionListForm" action="JDL.do" method="get">

		<input type="hidden" name="command" value="joboffer_division_list" />

		<div id="field">
			<table>
				<tr>
					<td><input type="checkbox" name="fieldAll" id="checkall" /><label
						for="checkall"><span></span>전체선택</label></td>
				</tr>

				<tr>
					<td><input type="checkbox" name="field" id="c1" value="1" /><label
						for="c1"><span></span>프론트엔드</label></td>
					<td><input type="checkbox" name="field" id="c2" value="2" /><label
						for="c2"><span></span>백엔드</label></td>
					<td><input type="checkbox" name="field" id="c3" value="3" /><label
						for="c3"><span></span>풀스택</label></td>
					<td><input type="checkbox" name="field" id="c4" value="4" /><label
						for="c4"><span></span>모바일앱</label></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="field" id="c5" value="5" /><label
						for="c5"><span></span>빅데이터</label></td>
					<td><input type="checkbox" name="field" id="c6" value="6" /><label
						for="c6"><span></span>머신러닝</label></td>
					<td><input type="checkbox" name="field" id="c7" value="7" /><label
						for="c7"><span></span>인공지능</label></td>
					<td><input type="checkbox" name="field" id="c8" value="8" /><label
						for="c8"><span></span>게임</label></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="field" id="c9" value="9" /><label
						for="c9"><span></span>네트워크</label></td>
					<td><input type="checkbox" name="field" id="c10" value="10" /><label
						for="c10"><span></span>보안</label></td>
					<td><input type="checkbox" name="field" id="c11" value="11" /><label
						for="c11"><span></span>사물인터넷</label></td>
					<td><input type="checkbox" name="field" id="c12" value="12" /><label
						for="c12"><span></span>블록체인</label></td>
				</tr>
			</table>
		</div>

		<div id="career">
			<table>
				<tr>
					<td><label for="r1"><input type="radio" name="career"
							id="r1" value="1" /><span><br />신입</span></label></td>
					<td><label for="r2"><input type="radio" name="career"
							id="r2" value="2" /><span><br />1년 ~ 3년</span></label></td>
					<td><label for="r3"><input type="radio" name="career"
							id="r3" value="3" /><span><br />3년 ~ 6년</span></label></td>
					<td><label for="r4"><input type="radio" name="career"
							id="r4" value="4" /><span><br />6년 ~ 10년</span></label></td>
					<td><label for="r5"><input type="radio" name="career"
							id="r5" value="5" /><span><br />10년 이상</span></label></td>
				</tr>
			</table>
		</div>

		<div id="salary">
			<input type="text" placeholder="최소 금액" name="min_salary"
				value="25,000,000" onkeyup="inputNumberFormat(this)" /> <span>&emsp;원&emsp;&emsp;&emsp;&emsp;~&emsp;&emsp;&emsp;&emsp;</span>
			<input type="text" placeholder="최대 금액" name="max_salary"
				value="150,000,000" onkeyup="inputNumberFormat(this)" /> <span>&emsp;원</span>

		</div>

		<div id="search">
			<input class="button" id="button" type="button" onclick="search()">
			<label for="button"><span>검색하기</span></label>
		</div>
	</form>

	<div id="stepOne">
		<img id="one" src="resources/images/stepOne.png" width="80"
			height="80"><span>&emsp;직무를 선택해주세요</span>
	</div>
	<div id="stepTwo">
		<img id="two" src="resources/images/stepTwo.png" width="80"
			height="80"><span>&emsp;경력을 선택해주세요</span>
	</div>
	<div id="stepThree">
		<img id="three" src="resources/images/stepThree.png" width="80"
			height="80"><span>&emsp;연봉을 입력해주세요</span>
	</div>

	<img id="airOne" src="resources/images/airOne.png" width="280px"
		height="280px">
	<img id="airTwo" src="resources/images/airTwo.png" width="450px"
		height="450px">
	<img id="sky" src="resources/images/sky.png">
	
	      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
	

</body>
</html>