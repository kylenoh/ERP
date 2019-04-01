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
<section class="container mt-3">
	<form method="POST" name="updateForm" action="member.update" onsubmit="return updateMemberCheck();">
			<table class="table table-bordered table-hover" style="text-align:center; border:1px solid #dddddd;">
				<thead>
					<tr>
						<th colspan="3"><h4>회원 등록 양식</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:110px;"><h5>아이디</h5></td>
						<td colspan="2"><h5>${sessionScope.loginMember.m_id }</h5>
						<input type="hidden" name="m_id" value="${sessionScope.loginMember.m_id }"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>비밀번호 *</h5></td>
						<td colspan="2"><input class="form-control" onkeyup="passwordCheck();" type="password" id="userPassword1" name="m_pw" maxlength="20" placeholder="비밀번호를 입력하세요" required="required" value="${sessionScope.loginMember.m_pw }"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>비밀번호<br>확인 *</h5></td>
						<td colspan="2"><input class="form-control" onkeyup="passwordCheck();" type="password" id="userPassword2" name="m_pwChk" maxlength="20" placeholder="비밀번호 확인을 입력하세요" required="required" value="${sessionScope.loginMember.m_pw }"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>이름</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="m_name" name="m_name" maxlength="20" placeholder="이름을 입력하세요" value="${sessionScope.loginMember.m_name }"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>이메일</h5></td>
						<td colspan="2"><input class="form-control" type="email" id="m_email" name="m_email" maxlength="20" placeholder="이메일을 입력하세요" value="${sessionScope.loginMember.m_email }"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>우편번호</h5></td>
						<td><input class="form-control m_addr3" type="text" id="m_addr3" name="m_addr3" maxlength="20" readonly="readonly" placeholder="주소찾기 버튼을 이용하세요" value="${addr3 }"></td>
						<td style="width:110px;"><button class="btn btn-dark" onclick="registerAddress()" type="button"><small>주소찾기</small></button></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>주소</h5></td>
						<td colspan="2"><input class="form-control m_addr1" type="text" id="m_addr1" name="m_addr1" maxlength="20" readonly="readonly" value="${addr1 }"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>상세주소</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="m_addr2" name="m_addr2" maxlength="20" placeholder="상세주소를 입력하세요" value="${addr2 }">
											   <input class="form-control" type="hidden" id="m_code" name="m_code" maxlength="20" value="${sessionScope.loginMember.m_code }">
						</td>
					</tr>
					<tr>
						
						<td style="text-align:left;" colspan="3"><h5 style="color:red;" id="passwordCheckMessage"></h5>
							<button type="button" class="btn btn-danger float-right" onclick="deleteMember()">탈퇴</button>
							<button type="submit" class="btn btn-dark float-right mr-2"><small>정보 수정</small></button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
</section>
</body>
</html>