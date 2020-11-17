<%@page import="com.bb.dto.MemberDto"%>
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
<style>


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
   text-align: center;
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
   width: 200px;
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


.whole {
   height:150px;
   padding:15px 10px;
   position:relative;
   bottom:30px;
}
.whole div, ul {
   overflow:hidden;
   margin:0;
   padding:0;
}
.whole .title {
   font-size:16px;
   font-weight:bold;
   margin-bottom:9px;
}
.whole ul {
   width:140px;
}
.whole li {
   margin-bottom:2px;
   padding:5px 10px;
   color:#aaabaf;
   line-height: 1;
}
.whole li .size {
font-size:14px;
font-weight:bold;
}
.whole li span {
display:inline-block;
}
.whole li .info {
font-size:11px;
}
.whole li:hover {
color:#fff;
background:#819FF7;
}

#like_img:hover, #liked_img:hover {
cursor:pointer;

}
</style>

</head>

   <script type="text/javascript"
      src="https://code.jquery.com/jquery-latest.js"></script>
      
   <script type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ac070aef0dd3d3c99c9947820a79ce05"></script>
      
      
<%
   JobOfferDivisionListDto dto = (JobOfferDivisionListDto) request.getAttribute("jo_dto");
   
   StringBuffer partAddr = new StringBuffer(dto.getMember_addr());
   
   int from = partAddr.indexOf(",");
   int end = partAddr.length();
   
   System.out.println(from);
   
   if (from > 0) {
      partAddr.replace(from, end, "");
   }
%>

<%
   int chk_res = (int) request.getAttribute("chk_res");
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
   
   
   function likeImg(res){
      if(res===2){
          alert('로그인이 필요합니다.');
          return;
      } else{
         $('#like_img').css('display', 'none');
         $('#liked_img').css('display', 'block');
         
         
         //insert
         $.ajax({
            url : "JobOffer_Division_List_Controller?command=insert_interest_job&jo_no=<%=dto.getJo_no()%>",
            method: "post",
            success: function(msg){
            },
            error: function(){
                  alert("통신 실패");
            }
         });
      }
   }
   
   function unlikeImg(){
      
      $('#liked_img').css('display', 'none');
      $('#like_img').css('display', 'block');
      
      //delete
      $.ajax({
         url : "JobOffer_Division_List_Controller?command=delete_interest_job&jo_no=<%=dto.getJo_no()%>",
         method: "post",
         success: function(msg){
         },
         error: function(){
               alert("통신 실패");
         }         
      });
      
      
   }
   
   
</script>

<body>
<div class="offer_detail_body">   
<br/>
<span style="color:#819FF7;"><a> No.${jo_dto.jo_no }</a></span>
<hr/>
   
   <span><img <%=chk_res==1? "style='display: none;'": "" %> id="like_img" src="resources/images/mylike.png" width="25" height="25" onclick="likeImg(<%=chk_res%>)"></span>
   <span><img <%=chk_res==0 || chk_res==2? "style='display: none;'": "" %> id="liked_img" src="resources/images/myliked.png" width="25" height="25" onclick="unlikeImg()"></span>
   
      

   <hr/>
   <h1 style="font-size: 50px;">${jo_dto.jo_title }</h1>
   <hr/>
   <h4 style="color:#A4A4A4;">${jo_dto.member_name } 님의 공고를 보고 계십니다.</h4>
   
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
   <p>${jo_dto.jo_content }</p>
   </fieldset>
   <fieldset>
   <p>기　업　명 :　${jo_dto.member_name }</p>
   <p>대표자이름 :　${jo_dto.corp_ceo_name }</p>
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
            distanceInfo();
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
      
      function distanceInfo() {
         
         // 선객체
         var polyline = new kakao.maps.Polyline({
             map: map,
             path: [
                 new kakao.maps.LatLng(my_latitude, my_longitude),
                 new kakao.maps.LatLng(corp_latitude, corp_longitude) 
             ],
             strokeWeight: 4,
             strokeColor: '#819FF7',
             strokeOpacity: 1,
             strokeStyle: 'solid',
             endArrow: true
         });
         
         // 내위치원객체
         var myCircle = new kakao.maps.Circle({
             center : new kakao.maps.LatLng(my_latitude, my_longitude),
             radius: 12, 
             strokeWeight: 4,
             strokeColor: '#819FF7',
             strokeOpacity: 1,
             strokeStyle: 'solid',
             fillColor: '#819FF7',
             fillOpacity: 0.5   
         });
         
         // 기업위치원객체
         var corpCircle = new kakao.maps.Circle({
             center : new kakao.maps.LatLng(corp_latitude, corp_longitude), 
             radius: 12, 
             strokeWeight: 4, 
             strokeColor: '#819FF7',
             strokeOpacity: 1,
             strokeStyle: 'solid',
             fillColor: '#819FF7',
             fillOpacity: 0.5   
         }); 
         
         // 선표시
         polyline.setMap(map);

         // 원표시 각각
         myCircle.setMap(map);
         corpCircle.setMap(map);
         
         var length = polyline.getLength();
         var distance = Math.floor(length);
         var walk = Math.floor((length / 70));
         var bike = Math.floor(length / 180);
         var vehicle = Math.floor(length / 450);

         document.getElementById("distance").innerHTML = distance+"m";
         document.getElementById("walk").innerHTML = walk+"분";
         document.getElementById("bike").innerHTML = bike+"분";
         document.getElementById("vehicle").innerHTML = vehicle+"분";
         
      }

   </script>

   <p>
      <button class="button_log" onclick="toOffice()">기업 위치</button>
      <button class="button_log" onclick="toMe()">내 위치</button>
   </p>
   <hr/>
   <br/>
   <div class="whole">
      <div class="title">거리 정보</div>
      <ul>
         <li>
            <span class="info">총 거리　</span>
            <span class="size" id="distance"></span>
         </li>
         <li>
            <span class="info">도보　</span>
            <span class="size" id="walk"></span>
         </li>
         <li>
            <span class="info">자전거　</span>
            <span class="size" id="bike"></span>
         </li>
         <li>
            <span class="info">자동차　</span>
            <span class="size" id="vehicle"></span>
         </li>
      </ul>
   </div>
   
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
   <a class="button_class" href="JDL.do?command=apply&jo_no=<%=dto.getJo_no() %>">지원하기</a>
   </div>
   </fieldset>
   
   
         <jsp:include page="chat/chat_aside.jsp"></jsp:include>
   
   
</div>
</body>
</html>