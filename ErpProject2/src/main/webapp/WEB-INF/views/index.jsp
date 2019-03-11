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
<script type="text/javascript">
$(function(){
		connectSummonAddrInputEvent();
		connectIdCheckEvent();
		sales();
});
</script>

</head>
<body>
	<div class="container">
		<header class="header py-3">
			<div
				class="row flex-nowrap justify-content-between align-items-center">
				<div class="col-4 pt-1">
					<a class="header-logo text-dark" href="go.index">Cooperation Project</a>
				</div>
			    <c:set var="result" value="${loginMember}" scope="session"/>
			    <c:choose>
			        <c:when test="${loginMember!=null}">
			            <div class="col-3 d-flex justify-content-end align-items-center">
			            	<img src="resources/file/${loginMember.m_photo }" class="rounded-circle" style="max-width: 40px;">
        						<a class="btn btn-sm btn-outline-secondary mx-1" href="member.update.go">My Page</a>
        					<a class="btn btn-sm btn-outline-secondary" href="member.logout">Log Out</a>
						</div>
			        </c:when>         
			        <c:otherwise>
			            <div class="col-3 d-flex justify-content-end align-items-center">
        					<a class="btn btn-sm btn-outline-secondary" href="go.member">Login</a>
						</div>
			         </c:otherwise>
			    </c:choose>
			</div>
		</header>
	<nav class="navbar navbar-expand-lg justify-content-between d-flex">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown">
					<a	class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">기초등록 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="go.container">창고관리</a> 
						<a class="dropdown-item" href="go.currency">환율관리</a>
					</div></li>
				
				<li class="nav-item">
					<a class="nav-link" href="go.sales">구매관리<span class="sr-only">(current)</span></a>
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
			</ul>
		</div>
	</nav>
</div>

	<jsp:include page="${contentPage }"></jsp:include>

	<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
	    <div class="container text-center">
	      <small>Copyright &copy; 2019 Kyle All Rights Reserved.</small>
	      <br>
	      <small><a href="#">Back to top</a></small>
	    </div>
  	</footer>
	
	
</body>
</html>