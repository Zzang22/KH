<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;500;700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Secular+One&display=swap');

body{
	background-color: #FAFAFA;
	color: #424242;
}

/* 전체 박스 */
.offer_reg_body{
	padding-left: 50px;
	font-family: 'Noto Sans KR', sans-serif;
	width: 80%;
	height: 100%;
	border: 1px solid #E6E6E6;
	background: white;
 	margin: 0 auto;
    left: 0;
    right: 0;

}


/* 테이블 위치 및 디자인 */
.offer_reg_table{

	margin-right: 50px;
	border-top: 1px solid #E6E6E6;
	margin-bottom: 100px;

}

/* 인풋박스를 감싸는 스판태그 디자인 및 위치 */
span{
	display: block;
    position: relative;
    width: 634px;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 110px 10px 14px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    vertical-align: top;

}

/* 인풋 박스 디자인*/
.input{
	display : block;
	margin-left: 5px;
	width: 200px;
	height: 30px;
	border: white;
}

/* th 바탕 색 및 크기 */
th{
	background: #FAFAFA;
	width: 100px;
}

/* 체크박스 td부분 색 */
.check_box{
	background: #FAFAFA;

}
.check_box:hover{
	background: white;
} 


/*'등록하기' 버튼 */
.reg_button {
	margin-top: 10px;
	margin-bottom:10px;
	
	width: 100px;
    height: 30px;
    background: #819FF7;
    font-family: 'Noto Sans KR', sans-serif;
    
    box-shadow:inset 0px 1px 0px 0px #d7dafa;
	background:linear-gradient(to bottom, #a1b9ff 5%, #819FF7 100%);
	background-color:#85bdf5;
	border-radius:3px;
	border:1px solid #398cde;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:13px;
	font-weight:bold;
	
	text-decoration:none;
	text-shadow:0px 1px 0px #0818ff;
	margin-right: 20px;


}

/* 맨 마지막 공백 */
#reg_button_div{
	width: 80%;
	height: 200px;

}

/* 맨 위에 h1 공백 및 세로중앙정렬 */
#title{
	height: 150px;
	line-height: 150px;
}

/* '등록하기'버튼 들어있는 td 색깔*/
#reg_button_td{
	border:solid 1px #dadada;
}

</style>

<script src="//cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>

</head>
<body>

	<form method="post" action="offer.do">
	<input type="hidden" name="member_id" value="${login.member_id }"/>
	<input type="hidden" name="command" value="joboffer_reg_res"/>
	<div class="offer_reg_body">
	<div id="title">
	<h2>${login.member_id }님 공고 등록</h2>
	</div>
	<table class="offer_reg_table">
		<tr>
			<th>직업명</th> 
			<td><span><input class="input" type="text" name="jo_title" required="required" placeholder="ex) 개발자"></span></td>
		</tr>
		
		<tr>
			<th>직무</th>
			<td class="check_box">
			<br/>
			<c:forEach items="${list }" var="dto">
			<input type="radio" name="field_name" value="${dto.field_name }">${dto.field_name }<br/>
			</c:forEach>	
			<br/>
			</td>		
		</tr> 
		
		<tr>
			<th>경력</th>
				<td class="check_box">
				<br/>
				<c:forEach items="${list2 }" var="dto">
				<input type="radio" name="career_name" value="${dto.career_name }">${dto.career_name }<br/><br/>
				</c:forEach>
				</td>
		</tr>
		
		<tr>
			<th>연봉</th>
			<td><span><input class="input" type="text" name="jo_salary" placeholder="ex) 2200"/></span></td>
		</tr>
		
		<tr>
			<th>직무내용</th>
			<td><textarea name="jo_content" id="editor4"></textarea>
			<script type="text/javascript">CKEDITOR.replace('editor4',{filebrowserUploadUrl: '${pageContext.request.contextPath }/adm/fileupload.do'});</script>
			</td>

		</tr>
		
		<tr>
			<th>기한</th>
			<td><span><input class="input" type="date" name="jo_deadline"></span></td>
		</tr>
		
		<tr>
			<td id="reg_button_td" colspan="2" align="right"><button class="reg_button" type="submit" value="등록">등록하기</button></td>
		</tr>
	</table>
	</div>
	
	<div id="reg_button_div">
	</div>
	</form>
	
	
	      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
	

</body>
</html>