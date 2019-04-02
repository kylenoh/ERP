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
	<form method="get" action="search.container" class="form-inline mt-3">
		<select name ="searchContainer" class="form-control mx-1 mt-2">
			<option value="con_no">창고코드</option>
			<option value="con_name">창고명</option>
		</select>
		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
		<button type="submit" class="btn btn-success mx-1 mt-2">검색</button>
		<a class="btn btn-dark mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a> 
		<a class="btn btn-dark mx-1 mt-2" data-toggle="modal" href="#detailModal" hidden="">상세보기</a> 
	</form>
	
	<div class="container mt-4">
		<h2>창고관리</h2>
		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th>창고코드</th>
					<th>창고명</th>
					<th>비고</th>
				</tr>
			</thead>
			<c:forEach var="i" items="${containers }">
				<tbody>
					<tr onclick="getContainerDetail('${i.con_no }','${i.con_name }','${i.con_note }')">
						<td align="center"><input type="checkbox" class="checked" value="${i.con_no }" ></td>
						<td align="center">${i.con_no }</td>
						<td align="center">${i.con_name }</td>
						<td align="center">${i.con_note }</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		
		<nav aria-label="Page navigation">
			  <ul class="pagination">
			  	<li class="page-item">
				   	<c:if test="${curPage != 1 && curPage != null}">
						<a href="Containerpage.change?p=${curPage-1 }" class="page-link">Previous</a>
					</c:if>
				</li>
			    <c:forEach var="z" begin="1" end="${pageCount }">
			    	<li class="page-item"><a class="page-link" href="Containerpage.change?p=${z }">${z }</a></li>
			    </c:forEach>  
			    <li class="page-item">
			    <c:if test="${curPage != pageCount }">
					<a href="Containerpage.change?p=${curPage+1 }" class="page-link">Next</a>
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
					<h5 class="modal-title" id="modal">창고등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>		
				<div class="modal-body">
					<form action="reg.container" method="post">
						<div class="form-group">
							<label>창고코드</label>
							<input type="text" name="con_no" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>창고명</label>
							<input type="text" name="con_name" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>비고</label>
							<textarea name="con_note" class="form-control" maxlength="2048" style="height:180px;"></textarea>
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
					<form action="update.container" method="post">
						<div class="form-group">
							<label>창고코드</label>
							<input type="text" name="con_no" class="form-control" maxlength="30" id="d_no" readonly="readonly">
						</div>
						<div class="form-group">
							<label>창고명</label>
							<input type="text" name="con_name" class="form-control" maxlength="30" id="d_name">
						</div>
						<div class="form-group">
							<label>비고</label>
							<textarea name="con_note" class="form-control" maxlength="2048" style="height:180px;" id="d_note"></textarea>
						</div>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteContainer(con_no)">삭제</button>
							<button type="submit" class="btn btn-primary">수정</button>
						</div>
					</form>
				</div>		
			</div>
		</div>
	</div>
	
</body>
</html>