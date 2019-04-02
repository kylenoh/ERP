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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<script type="text/javascript" src="resources/js//jQuery.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/popper.js"></script>
<script type="text/javascript" src="resources/js/custom.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/direct.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jquery.canvasjs.min.js"></script>
<script type="text/javascript">
$(function(){
		setSalesReg();
		setSalesDetail();
		stockChart();
		callCurrency();
});
</script>
<c:if test="${messageType != null }">
	<script type="text/javascript">
	$(function(){
		var title = $('.modal-title').val();
		if (title = '성공 메시지') {
			$('#messageType').css('background-color','#dff0d8');
			$('#messageModal').modal("show");
		}else {
			$('#messageType').css('background-color','#faebcc');
			$('#messageModal').modal("show");
		}
	});
	</script>
</c:if>

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
      <c:if test="${loginMember!=null}">
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
					<a class="dropdown-item" href="go.memberList">직원관리</a>
				</div>
		</li>
		</c:if>
      </ul>
      		<c:set var="result" value="${loginMember}" scope="session"/>
			<c:choose>
				<c:when test="${loginMember!=null}">
			       <div class="col-3 d-flex justify-content-end align-items-center">
			       	<c:choose>
						<c:when test="${sessionScope.loginMember.m_photo ==null }">
							<img src="resources/file/profile.jpg" class="rounded-circle" style="max-width: 40px;">
						</c:when>
						<c:otherwise>
			    			<img src="resources/file/${loginMember.m_photo }" class="rounded-circle" style="max-width: 40px;">
						</c:otherwise>			       		
			       	</c:choose>
			    		<div class="dropdown">
							  <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    회원 관리
							  </button>
							  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							    <a class="dropdown-item" href="member.update.go">회원정보수정</a>
							    <a class="dropdown-item" href="member.profile">프로필수정</a>
							    <a class="dropdown-item" href="member.logout">로그아웃</a>
							  </div>
						</div>
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

<div class="main">
	<jsp:include page="${contentPage }"></jsp:include>
</div>

	<footer class="footer">
		    <div class="container text-center">
		      <small class="text-muted">Copyright &copy; 2019 Kyle All Rights Reserved.</small>
		      <br>
		      <small class="text-muted"><a href="#">Back to top</a></small>
		    </div>
  	</footer>
  	
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
			    <div class="modal-content">
			 	      <div class="modal-header" id="messageType">
						<h5 class="modal-title">${messageType}</h5>
				        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          		<span aria-hidden="true">&times;</span>
				        	</button>
			      	  </div>
				      <div class="modal-body">${messageContent}</div>
				      <div class="modal-footer">
				        	<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
				      </div>
				</div>
			</div>
		</div>
  	
</body>
</html>