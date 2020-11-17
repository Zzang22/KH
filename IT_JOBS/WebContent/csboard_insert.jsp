<%@page import="com.bb.dto.CustomerServiceDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
	<% response.setContentType("text/html; charset=UTF-8"); %>
	<%@ taglib prefix ="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="//cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>
<style type="text/css">
	*{
	box-sizing: border-box;
	}
/*전체 배경색*/	
	body{
	background-color: #FAFAFA;
	color: #424242;
	}
/*input 박스를 감싸는 span 태그들*/	
#title> label{
	display: block;
    position: relative;
    width: 800px;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 110px 10px 14px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    vertical-align: top;
}

/*제목 박스*/
#title > input{
	position: relative;
	left: -510px;
	top: 10px;
	display : block;
	margin : 0 auto;
	width: 500px;
	height: 40px;
	border: solid 1px #dadada;
	/*width: 100%;  원하는 너비 설정 */ 
	line-height : normal; /* line-height 초기화 */
}
h4{
	margin: 19px 0 8px;
    font-size: 14px;
    font-weight: 700;
}
#button1 > input{
	margin-top: 40px;
	width: 150px;
    height: 30px;
    background: #819FF7;
    border-style: none;
    color: white;
    position: relative;
    left: 370px;
    font-size: 12pt;
    top: -1px;
	
}
#button2> input{
	margin-top: 20px;
	width: 150px;
    height: 30px;
    background: #819FF7;
    border-style: none;
    color: white;
    font-size: 12pt;
    position: relative;
    left: 550px;
    top: -50px;
	
}
/*전체 테이블 위치*/
.cs_insert{
	position: relative;
	left: 350px;
	top: 200px;
}
/*제목 위치*/
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
#cs_admin_insert{padding-bottom: 250px;}
</style>
</head>


<body>
<%@ include file="./form/nav_user.jsp" %>
         <div id="cs_admin_insert">
			<h1>고객센터 >></h1><h3> 관리자</h3>
		
		
			<form method="post" action="CustomerService.do" >
				<input type="hidden" name="command" value="insertres"/>
					<div class="cs_insert">
						<div class="table" id="title">
							<h4><label for="cs_title">제목</label></h4>
									<input type="text" name="cs_title" id="cs_title"/>
						</div>
						<div class="table" id="content">
							<h4><label>내용</label></h4>
							<span>
							<textarea id="ckeditor" name="cs_content"></textarea>
							</span>
							<script type="text/javascript">
		 								CKEDITOR.replace('ckeditor'
		                					, {width: 800},
		                					{height: 600});
		 								
							</script>
						</div>
						<div>
							<div id="button1">
							<input type="submit" value="작성"/>
							</div>
							<div id="button2">	
						    <input type="button" value="취소" onclick="location.href='CustomerService.do?command=plus_csboard'"/>
							</div>
						</div>
					</div>
		
			</form>
         </div>

	      <jsp:include page="chat/chat_aside.jsp"></jsp:include>

<%@ include file="./form/footer.jsp" %>
</body>
</html>