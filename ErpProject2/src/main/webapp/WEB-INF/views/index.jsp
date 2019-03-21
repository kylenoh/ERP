<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/custom.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<script type="text/javascript" src="resources/js//jQuery.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/popper.js"></script>
<script type="text/javascript" src="resources/js/custom.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jquery.canvasjs.min.js"></script>
<script type="text/javascript">
$(function(){
		connectSummonAddrInputEvent();
		connectIdCheckEvent();
		sales();
		sales2();

$.getJSON("http://openapi.seoul.go.kr:8088/4f6a6547456b6368333355736a714f/json/DailyAverageAirQuality/1/42/20190101", callback);
		
		$("select").change(function(e){
			var yy = $("#year").val();
			var mm = $("#month").val();
			if (mm < 10) {
				mm = 0 + mm;
			}
			var dd = $("#day").val();
			if (dd < 10) {
				dd = 0 + dd;
			}
			$.getJSON("http://openapi.seoul.go.kr:8088/4f6a6547456b6368333355736a714f/json/DailyAverageAirQuality/1/42/"+yy+mm+dd, callback);
		});
});
</script>

</head>
<body>
<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="go.index">Cooperation Project</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="go.purchase">구매관리<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="go.sales">판매관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="go.stock">재고관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="go.customer">고객관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="go.product">품목관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="go.bbs">게시판</a>
        </li>
        <li class="nav-item dropdown">
			<a	class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"	aria-expanded="false">기초등록 </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="go.company">자사관리</a>
					<a class="dropdown-item" href="go.container">창고관리</a> 
					<a class="dropdown-item" href="go.currency">환율관리</a>
				</div>
		</li>
      </ul>
      		<c:set var="result" value="${loginMember}" scope="session"/>
			<c:choose>
				<c:when test="${loginMember!=null}">
			       <div class="col-3 d-flex justify-content-end align-items-center">
			    		<img src="resources/file/${loginMember.m_photo }" class="rounded-circle" style="max-width: 40px;">
        				<a class="btn btn-outline-success my-2 my-sm-0 mx-1" href="member.update.go">My Page</a>
        				<a class="btn btn-outline-success my-2 my-sm-0" href="member.logout">Log Out</a>
					</div>
			    </c:when>         
		    <c:otherwise>
		        <div class="col-3 d-flex justify-content-end align-items-center">
        			<a class="btn btn-outline-success my-2 my-sm-0" href="go.member">Login</a>
				</div>
			</c:otherwise>
			</c:choose>
    </div>
  </nav>
</header>

<main role="main">
	<jsp:include page="${contentPage }"></jsp:include>
</main>

<footer class="footer">
		    <div class="container text-center">
		      <small class="text-muted">Copyright &copy; 2019 Kyle All Rights Reserved.</small>
		      <br>
		      <small class="text-muted"><a href="#">Back to top</a></small>
		    </div>
  	</footer>
</body>
</html>