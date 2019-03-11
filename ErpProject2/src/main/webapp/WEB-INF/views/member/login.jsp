<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
<section class="container mt-3" style="max-width:560px;">
	<div class="container mt-2">

		<form method="post" action="member.login" name="loginForm" onsubmit="return loginCheck();">
			<div class="form-group">
				<label>아이디</label>
				<input type="text" name="m_id" class="form-control">
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" name="m_pw" class="form-control">
			</div>
			<button type="submit" class="btn btn-success btn-block">로그인</button>		
			<input type="checkbox" aria-label="Checkbox for following text input" name="m_auto">자동 로그인
		</form>
	
	
	<nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="go.join">회원가입</a></li>
	    <li class="breadcrumb-item"><a href="#">Library</a></li>
	    <li class="breadcrumb-item"><a href="#">Library</a></li>
	  </ol>
	</nav>
	</div>
	
</section>
</body>
</html>