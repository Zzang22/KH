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

	<p>no.<%=dto.getJo_no() %></p>
	<p><h1><%=dto.getJo_title() %></h1></p>
	<hr/>
	<p><h4><%=dto.getMember_name() %></h4></p>
	
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

	</script>

	<p>
		<button onclick="toOffice()">기업 위치</button>
		<button onclick="toMe()">내 위치</button>
	</p>
	
	</fieldset>
	<fieldset>
	<p>담당자 이 름　 　 : <%=dto.getCorp_board_name() %></p>
	<p>담당자 이 메 일　 : <%=dto.getMember_email() %></p>
	<p>담당자 전화번호　: <%=dto.getMember_phone() %></p>
	</fieldset>
	<fieldset>
	<b><%=dto.getJo_hit() %></b><a>명의 회원이 이 공고를 열람하였습니다</a>
	<hr/>
	<a>마감일까지 </a><strong id="countdown" style="color:red;"></strong><a> 남았습니다</a>
	</fieldset>
	
	<fieldset>
	<a href="JDL.do?command=apply">지원하기</a>
	
	</fieldset>
	
	
	
	      <jsp:include page="chat/chat_aside.jsp"></jsp:include>
	

</body>
</html>