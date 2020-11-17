<%@page import="com.bb.dto.MemberDto"%>
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
<style type="text/css">
       @import url('https://fonts.googleapis.com/css2?family=Secular+One&display=swap');
 *{
   box-sizing:border-box;
        }
 .questionlist a{
	cursor: pointer;
	color: black;

}

.select1{
	position: relative;
	left: 100px;
	top: 50px;
    border-bottom: black dotted 3px;
    border-width: 30%;
    width: 50%

}
.select2{
	 position: relative;
	 left: 100px;
	 top: 70px;
	 border-bottom: black dotted 3px;
     border-width: 30%;
     width: 50%
}
.select3{
	position: relative;
	left: 100px;
	top: 100px;
	 border-bottom: black dotted 3px;
     border-width: 30%;
     width: 50%
}
.select4{
	position: relative;
	left: 100px;
	top: 130px;
	 border-bottom: black dotted 3px;
     border-width: 30%;
     width: 50%
}
h2{
	color: white;
	position: relative;
	top: -50px;
	left: 40px;
	font-size: 30px;
}
#upper_body{
   padding-top: 130px;
   width: 100%;
   height: 200px;
   position: relative;
   top: -50px;
   background-image: url('resources/images/working.jpg');
   background-repeat: no-repeat;
   background-position: center;
   
}
.hide{
	display: none;
	color: 	black;
	font-size: 11px;
	
} 	
 	
 	/*더 궁금하신게 있으신가요*/
.plus-box{
	clear:left;
	border: 2px;
	background-color:#819FF7;
	width: 400px;
	height: 150px;
	position: relative;
	left: 1000px;
	top: 20px;
	box-shadow: 0 3px 6px rgba(0,0,0,0.2);
	margin-bottom: 50px;
}
#plus-btn h4{
	position: relative;
	left: 110px;
	top: 40px;
	color: white;
}
#plus-btn a{
	text-align: center;
	position: relative;
	left: 30px;
	top: 50px;
	font-size: 14pt;
	font-weight: bold;
	color: white;
	text-decoration: none;
}
#cs{
  padding-bottom: 300px;
}
 	
</style>
<!--<link rel="stylesheet" href="resources/css/csboard.css">-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
	  	
<script type="text/javascript">
	
$(document).ready(function(){
		$(".questionlist a").click(function(){
			var submenu = $(this).next("div");
			if(submenu.is(":visible")){
				submenu.slideUp();
			}else{
				submenu.slideDown();
			}
		});
		
	});
	
</script>  
</head>
<body>
<%@ include file="./form/nav_user.jsp" %>
<%
	MemberDto dto = (MemberDto)session.getAttribute("login");
    String member_role = request.getParameter("member_role");
%>

	
  
	<div class="wrpa-title">
		<h1 class="title-content">Q & A</h1>
	</div>
	<br/>
	<br/>
	<div id="upper_body">
	<section class="article">
		<div class="category-member">
		  <div class="title-wrap">
			<h2>개인 회원, 기업 회원 자주 묻는 질문</h2>
		  </div>
			<div class="questionlist">
			  <div class="box">
				<div class="select1">
				  <a class="question" id="question1">Q.[개인 회원] 이력서 등록 방법</a>
					<div class="hide" id="hide1">
							<p>
							 '이력서 등록하는 방법’을 안내하겠습니다. 
							  IT JOBS 이력서 양식은 [필수항목]과 [추가항목]이 있습니다.
						   <br/>[필수항목]은 상시 오픈되어있는 필수 작성항목들이고
                           <br/>[추가항목]은 작성을 원하는 항목을 선택해서 생성 및 작성이 가능한 항목들입니다. 항목순서 변경도 가능합니다.
                           <br/>- 필수항목(5) : 기본정보, 학력사항, 경력사항, 이력서 제목, 희망 근무조건
                           <br/>- 추가항목(8) : 대외활동, 자격증/어학/수상 내역, 보유기술 및 능력, 취업 우대사항, 포트폴리오 및 기타문서, 경력기술서, 자기소개서, 사람인인적성검사
                           <br/>※ '자기소개서' 항목은 [추가항목]이지만 가능하면 반드시 작성하는 것을 권장드립니다^^ 
                           <br/>인사담당자가 중요하게 생각하는 항목 중 하나랍니다. 참고로, 지원하는 방법에 따라 필수, 추가항목이 상이할 수 있습니다.
						   <br/>먼저 Part1에서는 이력서 [필수항목] 작성하는 방법을 알아보겠습니다. 
                           <br/>※  이력서는 최대 10개까지 등록하실 수 있습니다. 
                           <br/>이력서 내용을 정확하게 작성할수록 취업성공! 합격과 가까워질 수 있다는 점 꼭! 기억해주세요. 
							</p>
							<br />
					</div>	
                </div>  
			  </div>
			   <div class="box">
				<div class="select2">
				  <a class="question" id="question2">Q.[개인 회원] 아이디와 비밀번호를 잊어버렸는데 어떻게 알 수 있을까요?</a>
					<div class="hide" id="hide2">
							<p>
							 [아이디 찾기]
						<br/>1. 휴대폰 번호로 찾기 : IT JOBS에 등록된 이름 휴대폰 번호 입력 > [인증번호 발송] 후 '인증번호' 입력 > [인증확인] 클릭
						<br/>2. 이메일 주소로 찾기 : IT JOBS에 등록된 이름 이메일 주소 입력 > [인증번호 발송] 후 '인증번호' 입력 > [인증확인] 클릭	 
						<br/>
						<br/>[비밀번호 찾기]
						<br/>1. 휴대폰 번호로 찾기 : IT JOBS에 등록된 ID 이름 휴대폰 번호 입력 > [인증번호 발송] 후 '인증번호' 입력 > [인증확인] 클릭
						<br/>2. 이메일 주소로 찾기 : IT JOBS에 등록된 ID  이름  이메일 주소 입력 > [인증번호 발송] 후 '인증번호' 입력 > [인증확인] 클릭
							</p>
							<br />
					</div>		
				</div>
			   </div>
			   <div class="box">	
				<div class="select3">
				  <a class="question" id="question3">Q.[기업 회원] 일반 채용 공고는 어떻게 하나요?</a>
					<div class="hide" id="hide3">
							<p>
							1. 유형선택: 진행할 채용의 유형(일반/자사양식/블라인드) 선택

						<br/>2. 채용등록: 공고 내용(담당자정보, 모집분야 등) 입력

						<br/>3. 지원서 설정(일반채용은 제공되지 않음): 입사지원 받을 이력서 내용 설정

						<br/>4. 효과 높이기: 유료 상품 적용
							</p>
							<br />
					</div>		
				</div>
			   </div>
			   <div class="box">	
				<div class="select4">
				  <a class="question" id="question4">Q.[기업 회원] 무료 채용공고와 유료 채용공고의 차이는 무엇인가요?</a>
					<div class="hide" id="hide4">
							<p>
							 IT JOBS 기업회원으로 가입하시면 채용공고를 무료로 등록하실 수 있습니다.
						<br/>-무료 채용공고 특징

					   <br/>1. 사람인 기업회원이면 공고 등록 가능
					   <br/>2. 최대 5개까지 동시게재 가능(진행중 공고)
					   <br/>3. 공고기반 인재추천(20명) 서비스 제공
							
					   <br/>-유료 채용공고 특징 

					   <br/>1. 무료로 등록한 채용공고에 유료 상품(실시간 노출상품, 로고/배너상품)을 구매 후 적용
					   <br/>2. 무제한 동시게재 가능(진행중 공고)
					   <br/>3. 게재 후 즉시 추천공고 서비스에 적용
					   <br/>4. 공고기반 인재추천(20명) 서비스 제공 - 5명 무료열람 가능(유료 상품 적용 후 10일 이내)						
							</p>
							<br />
					</div>		
				</div>
			</div>
		</div>
	</section>
	<br/>
	<br/>
	</div>
	
	<section>
	
			  <div class="plus-box">
			  	<span id="plus-btn">
			  		<h4>더 궁금하신게 있으신가요?</h4>
			  		<a href="CustomerService.do?command=plus_csboard">
			  		개인회원/기업회원을 위한 이용 안내입니다.
			  		</a>
			  	</span>
			  </div>
			
	 </section>
   <div id="cs">
   </div>	
			
			      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
		

<%@ include file="./form/footer.jsp" %>
</body>
</html>