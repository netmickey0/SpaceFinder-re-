<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>shopping Admin</title>
	
<script src="/resources/jquery/jquery-3.5.1.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/resources/bootstrap/bootstrap-theme.min.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.js"></script>
<script src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=rebzhg9z1c"></script>
	
<style>
	body { font-family:'맑은 고딕', verdana; padding:0; margin:0; }
	ul { padding:0; margin:0; list-style:none;  }
 
	div#root { width:90%; margin:0 auto; }
	
	header#header { font-size:60px; padding:20px 0; }
	header#header h1 a { color:#000; font-weight:bold; }
	
	nav#nav { padding:10px; text-align:right; }
	nav#nav ul li { display:inline-block; margin-left:10px; }
 
 		section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:2px solid #eee; }
	section#container::after { content:""; display:block; clear:both; }
	aside { float:left; width:200px; }
	div#container_box { float:right; width:calc(100% - 200px - 20px); }
	
	aside ul li { text-align:center; margin-bottom:10px; }
	aside ul li a { display:block; width:100%; padding:10px 0;}
	aside ul li a:hover { background:#eee; }
	
	footer#footer { background:#f9f9f9; padding:20px; }
	footer#footer ul li { display:inline-block; margin-right:10px; } 
</style>


<style>
.inputArea { margin:10px 0; }
select { width:100px; }
label { display:inline-block; width:70px; padding:5px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
textarea#gdsDes { width:400px; height:180px; }

.select_img img {margin:20px 0;}
</style>
</head>
<body>
<div id="root">
	<header id="header">
		<div id="header_box">
			<%@ include file="../include/header.jsp" %>
		</div>
	</header>

	<nav id="nav">
		<div id="nav_box">
			<%@ include file="../include/nav.jsp" %>
		</div>
	</nav>
	
	<section id="container">
		<aside>
			<%@ include file="../include/aside.jsp" %>
		</aside>
		<div id="container_box">
			<h2>굿플 등록</h2>
			
<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">

 <div class="inputArea">
	<label>1차 분류</label>
	<select class="category1">
		<option value="">전체</option>
	</select>

	<label>2차 분류</label>
	<select class="category2" name="cateCode">
		<option value="">전체</option>
	</select>
</div>

<div class="inputArea">
<label for="writer">작성자</label><input type="text"
id="userId" name="userId" value="${member.userId}" />
</div>


<div id="wrap" class="section">
    <div id="map" style="width:50%;height:600px;"></div>
    <code id="snippet" class="snippet"></code>
</div>

<div class="inputArea">
	<label for="GP_name">굿플 이름</label><!-- 상품명 -->
	<input type="text" id="GP_name" name="GP_name" />
</div>

<div class="inputArea">
	<label for="GP_lat">위도</label><!-- 상품가격 -->
	<input type="text" id="GP_lat" name="GP_lat" />
</div>

<div class="inputArea">
	<label for="GP_long">경도</label><!-- 수량 -->
	<input type="text" id="GP_long" name="GP_long" />
</div>

<div class="inputArea">
	<label for="GP_Runtime">영업시간</label><!-- 수량 -->
	<input type="text" id="GP_Runtime" name="GP_Runtime" />
</div>

<div class="inputArea">
	<label for="GP_content">내용</label>
	<textarea rows="5" cols="50" id="GP_content" name="GP_content"></textarea>
</div>

<div class="inputArea">
 <label for="GP_image">이미지</label>
 <input type="file" id="GP_image" name="file" />
 <div class="select_img"><img src="" /></div>
 
 <div class="inputArea">
	<label for="GP_restday">정기 휴무일</label><!-- 수량 -->
	<input type="text" id="GP_restday" name="GP_restday" />
</div>

 <div class="inputArea">
	<label for="GP_parking">주차 가능</label><!-- 수량 -->
	<input type="text" id="GP_parking" name="GP_parking" />
</div>

 <script>
  $("#GP_image").change(function(){
	  var image = $("#GP_image").val();
	  if(image.includes(".png") || image.includes(".jpg") || image.includes(".jpeg")) {
		  if(this.files && this.files[0]) {
			  
			    var reader = new FileReader;
			    reader.onload = function(data) {
			     $(".select_img img").attr("src", data.target.result).width(500);        
			    }
		  		reader.readAsDataURL(this.files[0]);
		  }
	  } else {
		  alert("이미지 확장자를 png,jpeg,jpg 로 해주세요");
		  $(".select_img img").removeAttr("src");
		  $("#GP_image").val("");
	  }
  
  });
 </script>
 
<%--  <%=request.getRealPath("/") %> --%>
</div>


   
    <script id="code">
      //지도를 삽입할 HTML 요소 또는 HTML 요소의 id를 지정합니다.
      /* var mapDiv = document.getElementById('map'); // 'map'으로 선언해도 동일
      
      //옵션 없이 지도 객체를 생성하면 서울 시청을 중심으로 하는 16 레벨의 지도가 생성됩니다.
      var map = new naver.maps.Map(mapDiv); */
      var map = new naver.maps.Map('map', {
          center: new naver.maps.LatLng(35.896061, 128.621659),
          zoom: 16,
          mapTypeId: naver.maps.MapTypeId.NORMAL
      });

      var infowindow = new naver.maps.InfoWindow();

      function onSuccessGeolocation(position) {
          /* var location = new naver.maps.LatLng(position.coords.latitude,
                                               position.coords.longitude); */
          var location = new naver.maps.LatLng(35.896061, 128.621659);

          map.setCenter(location); // 얻은 좌표를 지도의 중심으로 설정합니다.
          map.setZoom(16); // 지도의 줌 레벨을 변경합니다.

          /* infowindow.setContent('<div style="padding:20px;">' + 'geolocation.getCurrentPosition() 위치' + '</div>');

          infowindow.open(map, location); */
          console.log('Coordinates: ' + location.toString());
      }
      
      //지오로케이션 안내문
      /* function onErrorGeolocation() {
          var center = map.getCenter();

          infowindow.setContent('<div style="padding:20px;">' +
              '<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');

          infowindow.open(map, center);
      } */
      
      $(window).on("load", function() {
          if (navigator.geolocation) {
              /**
               * navigator.geolocation 은 Chrome 50 버젼 이후로 HTTP 환경에서 사용이 Deprecate 되어 HTTPS 환경에서만 사용 가능 합니다.
               * http://localhost 에서는 사용이 가능하며, 테스트 목적으로, Chrome 의 바로가기를 만들어서 아래와 같이 설정하면 접속은 가능합니다.
               * chrome.exe --unsafely-treat-insecure-origin-as-secure="http://example.com"
               */
              navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
          } else {
              var center = map.getCenter();
              infowindow.setContent('<div style="padding:20px;"><h5 style="margin-bottom:5px;color:#f00;">Geolocation not supported</h5></div>');
              infowindow.open(map, center);
          }
      });
      var marker = new naver.maps.Marker();
      naver.maps.Event.addListener(map, 'click', function(e) {
            marker.setPosition(e.coord);
            marker.setMap(map);
            console.log("위도 경도"+e.coord);
            $('input#GP_lat').val(e.coord.y);
            $('input#GP_long').val(e.coord.x);
        });
   </script>

<div class="inputArea">
	<button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
</div>

</form>
			
		</div>
	</section>

	<footer id="footer">
		<div id="footer_box">
			<%@ include file="../include/footer.jsp" %>
		</div>		
	</footer>

</div>

</body>
</html>