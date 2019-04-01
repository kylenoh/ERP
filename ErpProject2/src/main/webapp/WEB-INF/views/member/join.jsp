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
		<form method="post" action="reg.member" name="joinForm" onsubmit="return joinCheck();">
			<table class="table table-bordered table-hover" style="text-align:center; border:1px solid #dddddd;">
				<thead>
					<tr>
						<th colspan="3"><h4>회원 등록 양식</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:110px;"><h5>아이디 *</h5></td>
						<td><input class="form-control" type="text" id="m_id" name="m_id" maxlength="20" placeholder="아이디를 입력하세요" required="required"></td>
						<td style="width:110px;"><button class="btn btn-dark" onclick="registerCheck()" type="button"><small>중복체크</small></button></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>비밀번호 *</h5></td>
						<td colspan="2"><input class="form-control" onkeyup="passwordCheck();" type="password" id="userPassword1" name="m_pw" maxlength="20" placeholder="비밀번호를 입력하세요" required="required"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>비밀번호<br>확인 *</h5></td>
						<td colspan="2"><input class="form-control" onkeyup="passwordCheck();" type="password" id="userPassword2" name="m_pwChk" maxlength="20" placeholder="비밀번호 확인을 입력하세요" required="required"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>이름</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="userName" name="m_name" maxlength="20" placeholder="이름을 입력하세요"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>이메일</h5></td>
						<td colspan="2"><input class="form-control" type="email" id="userEmail" name="m_email" maxlength="20" placeholder="이메일을 입력하세요"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>우편번호</h5></td>
						<td><input class="form-control m_addr3" type="text" id="m_addr3" name="m_addr3" maxlength="20" readonly="readonly" placeholder="주소찾기 버튼을 이용하세요"></td>
						<td style="width:110px;"><button class="btn btn-dark" onclick="registerAddress()" type="button"><small>주소찾기</small></button></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>주소</h5></td>
						<td colspan="2"><input class="form-control m_addr1" type="text" id="m_addr1" name="m_addr1" maxlength="20" readonly="readonly"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>상세주소</h5></td>
						<td colspan="2"><input class="form-control" type="text" id="userEmail" name="m_addr2" maxlength="20" placeholder="상세주소를 입력하세요">
											   <input class="form-control" type="hidden" id="m_code" name="m_code" maxlength="20" value="1">
						</td>
					</tr>
					<tr>
						<td style="text-align:left;" colspan="3"><h5 style="color:red;" id="passwordCheckMessage"></h5><button type="submit" class="btn btn-dark float-right"><small>회원가입</small></button></td>
					</tr>
				</tbody>
			</table>
		</form>
</section>


		<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
			    <div class="modal-content">
			 	      <div class="modal-header" id="checkType">
						<h5 class="modal-title" id="checkTitle"></h5>
				        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          		<span aria-hidden="true">&times;</span>
				        	</button>
			      	  </div>
				      <div class="modal-body" id="checkMessage"></div>
				      <div class="modal-footer">
				        	<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
				      </div>
				</div>
			</div>
		</div>
		
		
</body>
</html>