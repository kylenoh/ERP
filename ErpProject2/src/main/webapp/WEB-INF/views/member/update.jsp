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
	<form method="post" action="member.update" enctype="multipart/form-data" name="joinForm" onsubmit="return joinCheck();">
		<div class="form-group">
			<label>아이디</label>
			<div class="input-group mb-3">
  				<input type="text" class="form-control" value="${sessionScope.loginMember.m_id }" aria-describedby="basic-addon2" name="m_id" readonly="readonly">
  					<div class="input-group-append">
					    <span class="input-group-text" id="joinIdOk">ID확인</span>
  					</div>
			</div>
		</div>
		<div class="form-group">
			<label>회사코드</label>
			<input type="text" name="m_code" class="form-control" value="${sessionScope.loginMember.m_code }" required="required" readonly="readonly">
		</div>
		<div class="form-group">
			<label>비밀번호</label>
			<input type="password" name="m_pw" class="form-control" value="${sessionScope.loginMember.m_pw }" required="required">
		</div>
		<div class="form-group">
			<label>비밀번호확인</label>
			<input type="password" name="m_pwChk" class="form-control" value="${sessionScope.loginMember.m_pw }" required="required">
		</div>
		<div class="form-group">
			<label>이름</label>
			<input type="text" name="m_name" value="${sessionScope.loginMember.m_name }" class="form-control">
		</div>
		<div class="form-group">
			<label>이메일</label>
			<input type="email" name="m_email" class="form-control"  value="${sessionScope.loginMember.m_email }" maxlength="20" placeholder="이메일">
		</div>
		<div class="form-group">
			<label>우편번호</label>
			<div class="input-group mb-3">
  				<input type="text" class="form-control" value="${addr3 }" name="m_addr3" id="m_addr3" readonly="readonly">
  					<div class="input-group-append">
  						<button class="btn btn-outline-secondary" type="button" id="joinAddrSearchBtn"><i class="fas fa-search"></i></button>
  					</div>
			</div>
		</div>
		<div class="form-group">
			<label>주소</label>
			<input type="text" name="m_addr1" id="m_addr1" class="form-control" maxlength="20" value="${addr1 }" readonly="readonly">
		</div>
		<div class="form-group">
			<label>상세주소</label>
			<input type="text" name="m_addr2" class="form-control" maxlength="20" value="${addr2 }">
		</div>
		<div class="form-group">
			<label>프로필</label>
			<img src="resources/file/${sessionScope.loginMember.m_photo }" class="rounded-circle" style="max-width: 40px;">
			<input type="file" name="m_photo" class="form-control" autocomplete="off">
		</div>
		<div class="form-group">
					<button type="submit" class="btn btn-success">정보 수정</button>
					<button type="button" class="btn btn-danger" onclick="deleteMember()">탈퇴</button>
		</div>
	</form>
</section>
</body>
</html>