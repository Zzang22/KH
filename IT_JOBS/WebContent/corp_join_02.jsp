<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

@import url('https://fonts.googleapis.com/css2?family=Secular+One&display=swap');

*{
 box-sizing:border-box;
}

body{
	background-color: #FAFAFA;
	color: #424242;
}

/*input 박스를 감싸는 span태그들*/
span{
	display: block;
    position: relative;
    width: 300px;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 110px 10px 14px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    vertical-align: top;

}

input{
	display : block;
	margin : 0 auto;
	width: 200px;
	height: 30px;
	border: white;
}

/*각 input박스 글자*/
h4{
	margin: 19px 0 8px;
    font-size: 14px;
    font-weight: 700;
}

/*input창 div박스*/
.join_corp02{
	position:absolute;
	margin-top: 10%;
	left: 50%;
	margin-left: -150px;
	margin-bottom: 10%;

}

/* 중복확인 버튼 */
#idcheck{
	width: 300px;
	margin: 10px 0 8px;

}

/*비밀번호 유효성검사 경고문*/
#input_pw p{
	margin : 5 auto;
	color: red;
}

/*'다음으로'버튼*/
#submit{
	margin-top: 40px;
	width: 300px;
    height: 51px;
    background: #819FF7;
    border-style: none;
    color: white;
}

/*WELCOM TO IT_JOBS*/
#IT_JOBS{
	display: block;
	margin: 0;
	font-family: 'Secular One', sans-serif;
	color: #819FF7;
}

#logo_div{
	position:absolute;
	width: 352px;
	height: 80px;
	left: 50%; 
	transform: translateX(-50%);


	margin-top: 10%;
}
</style>

<script type="text/javascript">
	//사업자 중복체크
	function BNoChk(){
		var doc = document.getElementsByName("corp_businessno")[0];
		if(doc.value == null || doc.value.trim() == ""){
			alert("사업자 번호를 먼저 입력해주세요!");
		}else{
			open("corp.do?command=b_nochk&corp_businessno="+doc.value,"","width=300, height=300");
		}
	}
	
	function B_NoChkConfirm(){
		var chk = document.getElementsByName("corp_businessno")[0].title;
		if(chk == "f"){
			alert("사업자 번호 중복확인을 먼저해주세요");
			document.getElementsByName("corp_businessno")[0].focus();
		}
	}
	
	function nullable(isnull){
		if(this == null || this == ""){
			
		}
	}

	
</script>

</head>
<body>
<%@ include file="./form/nav_corp.jsp" %>
<form action="corp.do" method="post">  
<input type="hidden" name="command" value="corp_join_02"/>
<input type="hidden" name="member_id" value=${member_id }/>
	<div class="join_corp02">
			
			<div>
			<h4><label for="corp_businessno">사업자번호</label></h4>
			<span>
			<input type="text" id="corp_businessno" name="corp_businessno" required="required" title="f">
			</span>
			<input id="idcheck" type="button" value="중복확인" onclick="BNoChk();">
			</div>
			
			<div>
			<h4><label for="corp_ceo_name">대표자명</label></h4>
			<span>
			<input type="text" id="corp_ceo_name" name="corp_ceo_name" onclick="B_NoChkConfirm();" required="required">
			</span>
			</div>
			
			<div>
			<h4><label for="corp_board_name">담당자명</label></h4>
			<span>
			<input type="text" id="corp_board_name" name="corp_board_name" onclick="B_NoChkConfirm();" required="required">
			</span>
			</div>
			
			<div>
			<h4><label for="corp_countemp">회사원 수</label></h4>
			<span>
			<input type="number" id="corp_countemp" name="corp_countemp" onclick="B_NoChkConfirm();" onsubmit="nullable(this);">
			</span>
			</div>

		<button id="submit" type="submit" name="regist">가입하기</button>
	</div>
</form>

</body>
</html>