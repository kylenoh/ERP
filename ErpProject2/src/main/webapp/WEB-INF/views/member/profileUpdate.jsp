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
<div class="container mt-3">
		<form method="post" action="update.profile" enctype="multipart/form-data">
			<table class="table table-bordered table-hover" style="text-align:center; border:1px solid #dddddd;">
				<thead>
					<tr>
						<th colspan="2"><h4>프로필 사진 수정 양식</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:110px;"><h5>아이디</h5></td>
						<td><h5>${sessionScope.loginMember.m_id }</h5>
						<input type="hidden" name="m_id" value="${sessionScope.loginMember.m_id }"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h5>사진 업로드</h5></td>
						<td colspan="2">
							<div class="filebox">
  								<label for="m_photo">이미지를 업로드하세요.</label>
								<input type="file" class="form-control" id="m_photo" placeholder="이미지를 업로드하세요." name="m_photo">
							</div>
						</td>
					</tr>
					<tr>
						<td style="text-align:left;" colspan="3"><button class="btn btn-dark float-right" type="submit"><small>등록</small></button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>