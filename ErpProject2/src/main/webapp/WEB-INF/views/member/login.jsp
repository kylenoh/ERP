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
<section class="container mt-5" style="max-width:560px;">
		<form method="post" action="member.login" name="loginForm" onsubmit="return loginCheck();">
			      <div class="text-center mb-4">
        			<h1 class="mt-3 font-weight-normal">Cooperation</h1>
      			</div>
		
			<div class="form-group">
				<label>Code</label>
				<input type="text" name="m_code" class="form-control" required autofocus placeholder="Input your CompanyCode" autocomplete="off">
			</div>
			
			<div class="form-group">
				<label>아이디</label>
				<input type="text" name="m_id" class="form-control" required autofocus placeholder="Input your ID" autocomplete="off">
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" name="m_pw" class="form-control" required placeholder="Input your Password" autocomplete="off">
			</div>
			<button type="submit" class="btn btn-success btn-block">로그인</button>
			<div class="checkbox mb-3 mt-3">		
				<input type="checkbox" aria-label="Checkbox for following text input" name="m_auto">자동 로그인
			</div>
		</form>
	
	<nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="go.join">회원가입</a></li>
	    <li class="breadcrumb-item"><a href="#">Library</a></li>
	    <li class="breadcrumb-item"><a href="#">Library</a></li>
	  </ol>
	</nav>
</section>


</body>
</html>