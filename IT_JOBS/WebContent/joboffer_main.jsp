<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

body{
background-color: #FAFAFA;
color: #424242;
}

a:visited{text-decoration:none; color:#424242;}

a:link {text-decoration:none; color:#424242;}

a:active {text-decoration:none; color:#424242;}

a:hover {text-decoration:none; color:#424242;}


/*테이블 중앙 배치*/
#joboffer_list{
    
    position:absolute;
 	margin-top: 10%;
 	left: 50%;
 	margin-left: -680px;

}

/*'공고등록' 버튼*/
.offer_reg{

	margin-top: 40px;
	margin-bottom:40px;
	
	width: 300px;
    height: 50px;
    background: #819FF7;
    font-family: 'Noto Sans KR', sans-serif;
    letter-spacing: 5px;
    
    box-shadow:inset 0px 1px 0px 0px #d7dafa;
	background:linear-gradient(to bottom, #a1b9ff 5%, #819FF7 100%);
	background-color:#85bdf5;
	border-radius:6px;
	border:1px solid #398cde;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:6px 24px;
	text-decoration:none;
	text-shadow:0px 1px 0px #0818ff;
	position:relative;
	left: 50%;
	margin-left: -150px;

}


.offer_reg :hover {
	background:linear-gradient(to bottom, #819FF7 5%, #a1b9ff 100%);
	background-color:#378de5;
}

.offer_reg :active {
	position:relative;
	top:1px;
}

/*테이블 디자인*/
table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;

  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
  
  th{
  	background: #E6E6E6;
  }
  
  tr:hover{
  	background: #E6E6E6;
  }
  
  #watch{
    text-align: center;
    font-style: italic;
    font-size: small;
    font-family: fangsong;
 }

</style>

<script type="text/javascript">

	function move(){
		location.href="offer.do?command=joboffer_reg";
	}
	
	function job_offer_detail(jo_no){
		open("offer.do?command=detail&jo_no="+jo_no,"","width=1200px, height=700px");
		
	}

</script>

</head>
<body>
<%@ include file="./form/nav_corp.jsp" %>
<div id="joboffer_list">
	<input class="offer_reg" type="button" value="공고등록" onclick="move();"/>
	<input type="hidden" value="${dto.jo_no }" id="jo_no"/>
	<table>
		<col width="150px">
		<col width="300px">
		<col width="150px">
		<col width="150px">
		<col width="150px">
		<col width="150px">
		<col width="300px">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>직업명</th>
			<th>경력</th>
			<th>연봉</th>
			<th>기한</th>
			<th></th>
		</tr>
		
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="7">----------아직 등록된 공고가 없습니다.</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr> 
						<td align="center">${dto.jo_no }</td>
						<td align="center" onclick="job_offer_detail(${dto.jo_no });"><a href="#">${dto.jo_title }</a></td>
						<td align="center">${dto.field_name }</td>
						<td align="center">${dto.career_name }</td>
						<td align="center">${dto.jo_salary }</td>
						<td align="center">${dto.jo_deadline }</td>
						<td align="center" id="watch"><a href="offer.do?command=applicantList&jo_no=${dto.jo_no}">지원자 보기</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>	

	</table>
	
	
	      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
	
</div>
</body>
</html>