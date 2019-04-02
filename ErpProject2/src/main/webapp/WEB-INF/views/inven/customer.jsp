<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
<section class="container mt-3">
	<form method="get" action="search.customer" class="form-inline mt-3">
		<select name ="searchType" class="form-control mx-1 mt-2">
			<option value="cus_no">거래처코드</option>
			<option value="cus_name">거래처명</option>
		</select>
		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
		<button type="submit" class="btn btn-success mx-1 mt-2">검색</button>
		<a class="btn btn-dark mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a> 
		<a class="btn btn-dark mx-1 mt-2" data-toggle="modal" href="#detailModal" hidden="">상세보기</a> 
		<a class="btn btn-danger mx-1 mt-2" data-toggle="modal" href="#reportModal" hidden="">삭제하기</a> 
	</form>
	
	<div class="container mt-4">
		<h2>고객관리</h2>
		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th>거래처코드</th>
					<th>상호명</th>
					<th>등록번호</th>
					<th>대표자</th>
					<th>주소</th>
					<th>거래처구분</th>
					<th>비고</th>
				</tr>
			</thead>
			<c:forEach var="i" items="${customers }">
				<tbody>
					<tr onclick="getDetailCustomer('${i.cus_no }','${i.cus_name }','${i.cus_regno }','${i.cus_owner }','${i.cus_addr }','${i.cus_division }','${i.cus_email }','${i.cus_note }')">
						<td align="center"><input type="checkbox" class="checked" value="${i.cus_no }" ></td>
						<td align="center">${i.cus_no }</td>
						<td align="center">${i.cus_name }</td>
						<td align="center">${i.cus_regno }</td>
						<td align="center">${i.cus_owner }</td>
						<td align="center">${i.cus_addr }</td>
						<td align="center">${i.cus_division }</td>
						<td align="center">${i.cus_note }</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		
		<nav aria-label="Page navigation">
			  <ul class="pagination">
			  	<li class="page-item">
				   	<c:if test="${curPage != 1 && curPage != null}">
						<a href="Customerpage.change?p=${curPage-1 }" class="page-link">Previous</a>
					</c:if>
				</li>
			    <c:forEach var="z" begin="1" end="${pageCount }">
			    	<li class="page-item"><a class="page-link" href="Customerpage.change?p=${z }">${z }</a></li>
			    </c:forEach>  
			    <li class="page-item">
			    <c:if test="${curPage != pageCount }">
					<a href="Customerpage.change?p=${curPage+1 }" class="page-link">Next</a>
				</c:if>
			    </li>
			  </ul>
		</nav>
		
	</div>
</section>	
	
	<!-- 등록하기 -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">고객등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>		
				<div class="modal-body">
					<ul class="nav nav-tabs" id="myTab" role="tablist">
                    	<li class="nav-item">
                           <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#customer-necessary" role="tab" aria-controls="home" aria-selected="true">필수 항목</a>
                        </li>
                        <li class="nav-item">
                           <a class="nav-link" id="profile-tab2" data-toggle="tab" href="#customer-detail" role="tab" aria-controls="profile" aria-selected="false">상세 등록</a>
                        </li>
                	</ul>
					<form action="reg.customer" method="post">
					<div class="tab-content profile-tab" id="myTabContent">
							<div class="tab-pane fade show active" id="customer-necessary" role="tabpanel" aria-labelledby="profile-tab">
								<div class="form-group">
									<label>거래처코드</label>
									<input type="text" name="cus_no" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>상호명</label>
									<input type="text" name="cus_name" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>등록번호</label>
									<input type="text" name="cus_regno" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>대표자</label>
									<input type="text" name="cus_owner" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>주소</label>
									<input type="text" name="cus_addr" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>구분</label>
									<select class="form-control" name="cus_division">
										<option value="구매처">구매처</option>
										<option value="판매처">판매처</option>
										<option value="구매처 판매처">구매처 판매처</option>
									</select>
								</div>
							</div>
							<div class="tab-pane fade" id="customer-detail" role="tabpanel" aria-labelledby="profile-tab2">
								<div class="form-group">
									<label>이메일</label>
									<input type="text" name="cus_email" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>비고</label>
									<textarea name="cus_note" class="form-control" maxlength="2048" style="height:180px;"></textarea>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-primary">등록하기</button>
						</div>
					</form>
				</div>		
			</div>
		</div>
	</div>
	
	<!-- 상세페이지 -->
	<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">상세보기</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>		
				<div class="modal-body">
					<ul class="nav nav-tabs" id="myTab" role="tablist">
                    	<li class="nav-item">
                           <a class="nav-link active" id="profile-tab3" data-toggle="tab" href="#customer2-necessary" role="tab" aria-controls="home" aria-selected="true">필수 항목</a>
                        </li>
                        <li class="nav-item">
                           <a class="nav-link" id="profile-tab4" data-toggle="tab" href="#customer2-detail" role="tab" aria-controls="profile" aria-selected="false">상세 등록</a>
                        </li>
                	</ul>
					<form action="update.customer" method="post">
					<div class="tab-content profile-tab" id="myTabContent">
							<div class="tab-pane fade show active" id="customer2-necessary" role="tabpanel" aria-labelledby="profile-tab3">
								<div class="form-group">
									<label>거래처코드</label>
									<input type="text" name="cus_no" id="d_no" class="form-control" maxlength="30" readonly="readonly">
								</div>
								<div class="form-group">
									<label>상호명</label>
									<input type="text" name="cus_name" class="form-control" maxlength="30" id="d_name">
								</div>
								<div class="form-group">
									<label>등록번호</label>
									<input type="text" name="cus_regno" class="form-control" maxlength="30" id="d_regno">
								</div>
								<div class="form-group">
									<label>대표자</label>
									<input type="text" name="cus_owner" class="form-control" maxlength="30" id="d_owner">
								</div>
								<div class="form-group">
									<label>주소</label>
									<input type="text" name="cus_addr" class="form-control" maxlength="30" id="d_addr">
								</div>
								<div class="form-group">
									<label>구분</label>
									<select class="form-control" name="cus_division" id="d_division">
										<option value="구매처">구매처</option>
										<option value="판매처">판매처</option>
										<option value="구매처 판매처">구매처 판매처</option>
									</select>
								</div>
							</div>
							<div class="tab-pane fade" id="customer2-detail" role="tabpanel" aria-labelledby="profile-tab4">
								<div class="form-group">
									<label>이메일</label>
									<input type="text" name="cus_email" class="form-control" maxlength="30" id="d_email">
								</div>
								<div class="form-group">
									<label>비고</label>
									<textarea name="cus_note" class="form-control" maxlength="2048" style="height:180px;" id="d_note"></textarea>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteCustomer(cus_no)">삭제</button>
							<button type="submit" class="btn btn-primary">수정</button>
						</div>
					</form>
				</div>		
			</div>
		</div>
	</div>
	
	

</body>
</html>