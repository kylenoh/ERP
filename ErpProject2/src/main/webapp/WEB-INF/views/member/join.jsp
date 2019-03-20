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
	<form method="post" action="reg.member" enctype="multipart/form-data" name="joinForm" onsubmit="return calculateQty2();">
		<div class="form-group">
			<label>아이디</label>
			<div class="input-group mb-3">
  				<input type="text" class="form-control" placeholder="아이디" aria-describedby="basic-addon2" id="m_id"name="m_id" required="required">
  					<div class="input-group-append">
					    <span class="input-group-text" id="joinIdOk">ID확인</span>
  					</div>
			</div>
		</div>
		<div class="form-group">
			<label>회사코드</label>
			<div class="input-group mb-3">
  				<input type="text" class="form-control" placeholder="회사코드" aria-describedby="basic-addon2" id="m_code"name="m_code">
			</div>
		</div>
		<div class="form-group">
			<label>비밀번호</label>
			<input type="password" name="m_pw" class="form-control" placeholder="PW, 숫자/영어소문자 조합" required="required">
		</div>
		<div class="form-group">
			<label>비밀번호확인</label>
			<input type="password" name="m_pwChk" class="form-control" placeholder="PW, 숫자/영어소문자 조합" required="required">
		</div>
		<div class="form-group">
			<label>이름</label>
			<input type="text" name="m_name" class="form-control">
		</div>
		<div class="form-group">
			<label>이메일</label>
			<input type="email" name="m_email" class="form-control" maxlength="20" placeholder="이메일">
		</div>
		<div class="form-group">
			<label>우편번호</label>
			<div class="input-group mb-3">
  				<input type="text" class="form-control" placeholder="우편번호" name="m_addr3" id="m_addr3" readonly="readonly">
  					<div class="input-group-append">
  						<button class="btn btn-outline-secondary" type="button" id="joinAddrSearchBtn"><i class="fas fa-search"></i></button>
  					</div>
			</div>
		</div>
		<div class="form-group">
			<label>주소</label>
			<input type="text" name="m_addr1" id="m_addr1" class="form-control" maxlength="20" placeholder="주소" readonly="readonly">
		</div>
		<div class="form-group">
			<label>상세주소</label>
			<input type="text" name="m_addr2" class="form-control" maxlength="20" placeholder="상세주소">
		</div>
		<div class="form-group">
			<label>프로필</label>
			<input type="file" name="m_photo" class="form-control" autocomplete="off">
		</div>
		<button type="submit" class="btn btn-success btn-block">회원가입</button>		
	</form>
</section>
</body>
</html>