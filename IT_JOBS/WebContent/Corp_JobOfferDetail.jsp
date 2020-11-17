<%@page import="com.bb.model.biz.JobOfferDivisionListBiz"%>
<%@page import="com.bb.model.biz.JobOfferDivisionListBizImpl"%>
<%@page import="com.bb.dto.JobOfferDivisionListDto"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

/* 디테일 전체 박스 */
.offer_detail_body{
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

hr{
	margin-right: 50px;
	border: none;
}

fieldset{

	margin-right: 50px;
	border: none;
	border-top: 1px solid #E6E6E6;
}

/* '수정하기', '삭제하기'버튼 디자인*/
.button_class {
	width:200px;
	background-color:#819FF7;
	border-radius:28px;
	border:1px solid #5882FA;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family: 'Noto Sans KR', sans-serif;
	font-size:17px;
	padding:16px 31px;
	text-decoration:none;
	text-shadow:0px 1px 0px #2f6627;
}

/* '내 위치', '기업 위치' 버튼 디자인 */
.button_log{
	width:100px;
	background-color:#adbae0;
	border-radius: 10px;
	border: none;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family: 'Noto Sans KR', sans-serif;
	font-size:13px;
	padding:7px 20px;
	text-decoration:none;
	text-shadow:0px 1px 0px #2f6627;

}

/* 수정하기, 삭제하기 버튼 중앙정렬 및 패딩*/
.corp_button{
	display: block;
	padding-top: 50px;
	padding-bottom: 50px;
	width: 420px;
	margin: 0 auto;
    left: 0;
    right: 0;
}

#button_field{
	border:none;
	background: #FAFAFA;
}

/* 버튼 hover */
.button_log:hover {
	background-color:#9facd4;
}
.button_log:active {
	position:relative;
	top:1px;
}

.button_class:hover {
	background-color:#5882FA;
}
.button_class:active {
	position:relative;
	top:1px;
}

</style>

</head>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-latest.js"></script>
		
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ac070aef0dd3d3c99c9947820a79ce05"></script>

<%
	int jo_no = Integer.parseInt(request.getParameter("jo_no"));
	JobOfferDivisionListDto dto = new JobOfferDivisionListDto();
	JobOfferDivisionListBiz biz = new JobOfferDivisionListBizImpl();
	dto = biz.selectOne(jo_no);
	
	String fullAddr = dto.getMember_addr();
	int until = fullAddr.indexOf(",");
	
	String partAddr = fullAddr.substring(0, until);
%>

<script type="text/javascript">

CountDownTimer('<%=dto.getJo_deadline()%>', 'countdown');

	function CountDownTimer(dt, id) {

		var end = new Date(dt);
		var _second = 1000;
		var _minute = _second * 60;
		var _hour = _minute * 60;
		var _day = _hour * 24;
		var timer;
	
	function showRemaining() {

		var now = new Date();
		var distance = end - now - (_hour*9);
		
		if (distance < 0) {
			clearInterval(timer);
			document.getElementById(id).innerHTML = '0일 0시간 0분 0초';
			return;
		}
		
		var days = Math.floor(distance / _day);
		var hours = Math.floor((distance % _day) / _hour);
		var minutes = Math.floor((distance % _hour) / _minute);
		var seconds = Math.floor((distance % _minute) / _second);

		document.getElementById(id).innerHTML = days + '일 ';
		document.getElementById(id).innerHTML += hours + '시간 ';
		document.getElementById(id).innerHTML += minutes + '분 ';
		document.getElementById(id).innerHTML += seconds + '초';
	}

	timer = setInterval(showRemaining, 1000);
	
}

</script>

<body>

<div class="offer_detail_body">	
	<p style="color:#819FF7;">no.<%=dto.getJo_no() %></p>
	<h1 style="font-size: 50px;"><%=dto.getJo_title() %></h1>
	<hr/>
	<h4 style="color:#A4A4A4;"><%=dto.getMember_name() %> 님의 공고를 보고 계십니다.</h4>
	
	<fieldset>
	<img src="resources/images/field.png" width="30" height="30"/><a>　직 　 무 :　<%=dto.getJo_field_name() %></a><br/>
	<img src="resources/images/career.png" width="30" height="30"/><a>　경 　 력 :　<%=dto.getJo_career_name() %></a><br/>
	<img src="resources/images/salary.png" width="30" height="30"/><a>　연 　 봉 :　<fmt:formatNumber type="number" value="<%=dto.getJo_salary() %>"/>원</a><br/>
	<img src="resources/images/countemp.png" width="30" height="30"/><a>　사 원 수 :　<%=dto.getCorp_countemp() %>명</a><br/>
	<img src="resources/images/dday.png" width="30" height="30"/><a>　마 감 일 :　<%=dto.getJo_deadline() %></a><br/>
	<img src="resources/images/addr.png" width="30" height="30"/><a>　주 　 소 :　<%=dto.getMember_addr() %></a><br/>
	</fieldset>
	<fieldset>
	<p>내 　 용 :</p>
	<p><%=dto.getJo_content() %></p>
	</fieldset>
	<fieldset>
	<p>기　업　명 :　<%=dto.getMember_name() %></p>
	<p>대표자이름 :　<%=dto.getCorp_ceo_name() %></p>
	<hr/>


	<div id="map" style="width: 50%; height: 350px;"></div>
	
	<script type="text/javascript">
	
		var corp_latitude;
		var corp_longitude;
		var my_latitude;
		var my_longitude;

		$.ajax({
			type : "GET",
			url : "https://dapi.kakao.com/v2/local/search/address.json",
			data : {query : "<%=partAddr%>"},
			async: false,
			headers : {Authorization : "KakaoAK e524d46f1f18a6a0be2977706f8edcc1"},
			success: function(msg){
				corp_latitude = msg.documents[0].y;
				corp_longitude = msg.documents[0].x;
			},
			error: function(){
						alert("통신 실패");
			}
		});
		
		var mapContainer = document.getElementById('map');
		var mapOption = {
			center : new kakao.maps.LatLng(corp_latitude, corp_longitude),
			level : 3
		};
		var map = new kakao.maps.Map(mapContainer, mapOption);
		
		window.onload = function(){
			navigator.geolocation.getCurrentPosition(function(position) {  
				window.my_latitude = position.coords.latitude;
				window.my_longitude = position.coords.longitude;
				toMe();
			});
		}

		function toMe() {
			var moveLatLon = new kakao.maps.LatLng(my_latitude, my_longitude);
			map.panTo(moveLatLon);

			var positions = [
				{
					title: '내 위치', 
					latlng: new kakao.maps.LatLng(my_latitude, my_longitude)
				}
			];
			var imageSrc = "resources/images/marker.png";
			for (var i = 0 ; i < positions.length ; i++) {
				var imageSize = new kakao.maps.Size(45, 40); 
				var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
				var marker = new kakao.maps.Marker({
					map: map,
					position: positions[i].latlng,
					title : positions[i].title,
					image : markerImage 
				});
			}
			
			var iwContent = '<div style="padding:5px; text-align:center;">내 위치</div>',
			iwPosition = new kakao.maps.LatLng(my_latitude, my_longitude);
			var infowindow = new kakao.maps.InfoWindow({
				position : iwPosition, 
				content : iwContent 
			});
			infowindow.open(map, marker); 
			
		}
		
		function toOffice() {
			var moveLatLon = new kakao.maps.LatLng(corp_latitude, corp_longitude);
			map.panTo(moveLatLon);

			var positions = [
				{
					title: '기업 위치', 
					latlng: new kakao.maps.LatLng(corp_latitude, corp_longitude)
				}
			];
			var imageSrc = "resources/images/marker.png";
			for (var i = 0 ; i < positions.length ; i++) {

				var imageSize = new kakao.maps.Size(45, 40); 
			    
				var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
			    
				var marker = new kakao.maps.Marker({
					map: map,
					position: positions[i].latlng,
					title : positions[i].title,
					image : markerImage
				});
			}
			
			var iwContent = '<div style="padding:5px; text-align:center;"><%=dto.getMember_name() %></div>',
			iwPosition = new kakao.maps.LatLng(corp_latitude, corp_longitude);
			var infowindow = new kakao.maps.InfoWindow({
				position : iwPosition, 
				content : iwContent 
			});
			infowindow.open(map, marker); 

		}
		
		function update(){
			location.href="offer.do?command=joboffer_update&jo_no=<%=dto.getJo_no() %>";
		}
		
		function del(){
			location.href="offer.do?command=joboffer_del&jo_no=<%=dto.getJo_no() %>";
		}

	</script>

	<p>
		<button class="button_log" onclick="toOffice()">기업 위치</button>&nbsp;
		<button class="button_log" onclick="toMe()">내 위치</button>
	</p>
	
	</fieldset>
	<fieldset>
	<p>담당자 이 름　 　 : <%=dto.getCorp_board_name() %></p>
	<p>담당자 이 메 일　 : <%=dto.getMember_email() %></p>
	<p>담당자 전화번호　: <%=dto.getMember_phone() %></p>
	</fieldset>
	<fieldset>
	<br/>
	<b><%=dto.getJo_hit() %></b><a>명의 회원이 이 공고를 열람하였습니다</a>
	<hr/>
	<a>마감일까지 </a><strong id="countdown" style="color:#819FF7;"></strong><a> 남았습니다</a>
	</fieldset>
	<br/>
	<fieldset id="button_field">
	<div class="corp_button">
	<button class="button_class" type="button" onclick="update();">수정하기</button> &nbsp;&nbsp;
	<button class="button_class" type="button" onclick="del();">삭제하기</button>
	</div>
	</fieldset>
	
</div>
</body>
</html>