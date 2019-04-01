<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
<section class="container mt-3">
		<form method="get" action="sns.search" class="form-inline mt-3">
		<input type="text" name="b_owner" class="form-control mx-1 mt-2" placeholder="작성자">
		<button type="submit" class="btn btn-success mx-1 mt-2">검색</button>
		<c:if test="${sessionScope.loginMember.m_id != null }">
			<a class="btn btn-dark mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a> 
		</c:if>
	</form>
	
	
	<c:forEach var="bm" items="${msgs }">
	<div class="card bg-light mt-3">
		<div class="card-header bg-light">
			<div class="row">
				<div class="col-8 text-left">${bm.b_type }&nbsp;<small>${bm.b_owner }</small></div>
				<div class="col-4 text-right">
					작성일자:&nbsp;<span style="color: red;"><fmt:formatDate value="${bm.b_date }" pattern="yyyy/MM/dd(E) a hh:mm" /></span>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title">
				${bm.b_title }
			</h5>
			<p class="card-text">${bm.b_txt}</p>
			<div class="row">
				<div class="col-12 text-right">
					<c:if test="${bm.b_owner == sessionScope.loginMember.m_id }">
					<a href="./deleteAction.jsp?evluationID=" onclick="return confirm('수정하시겠습니까?')">수정</a>
					<a href="#" onclick="bbsDelete(${bm.b_no })">삭제</a>
					</c:if>
				</div>
			</div>
			<c:forEach var="br" items="${bm.b_reply }">
				<small>${br.br_owner }</small>
				<small>${br.br_txt }</small> -
				<small> <fmt:formatDate value="${br.br_date }" type="both" dateStyle="short"	timeStyle="short" /></small>
				<c:if test="${br.br_owner == sessionScope.loginMember.m_id }">
					<button onclick="bbsReplDelete(${br.br_no});" style="border:none; background-color: transparent; width: 15%; cursor: pointer;"><small>삭제</small></button>
				</c:if>
				<br>
			</c:forEach>
			
			<c:if test="${sessionScope.loginMember != null }">
				<div class="row">
					<div class="col-12">
							<form action="sns.reply.write" onsubmit="return snsReplWriteCheck(this);">
								<input value="${bm.b_no }" name="br_b_no" type="hidden">
								<small>${sessionScope.loginMember.m_id }</small>
								<input name="br_txt" class="br_txt" autocomplete="off" maxlength="100" style="border:none; border-bottom:2px solid #dddddd; background-color: transparent;">
								<button style="border:none; background-color: transparent; width: 15%; cursor: pointer;"><small>쓰기</small></button>
							</form>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	</c:forEach>
	
	<nav aria-label="Page navigation">
			  <ul class="pagination">
			  	<li class="page-item">
			  	<c:if test="${curPage != 1 && curPage != null}">
					<a href="bbs.page.change?p=${curPage-1 }" class="page-link">Previous</a>
				</c:if>
				</li>
			    <c:forEach var="z" begin="1" end="${pageCount }">
			    	<li class="page-item"><a class="page-link" href="bbs.page.change?p=${z }">${z }</a></li>
			    </c:forEach>  
			    <li class="page-item">
			    <c:if test="${curPage != pageCount }">
					<a href="bbs.page.change?p=${curPage+1 }" class="page-link">Next</a>
				</c:if>
			    </li>
			  </ul>
		</nav>
	
	
	
</section>	
	
	<!-- 등록하기 -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">방명록등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>		
				<div class="modal-body">
					<form action="bbs.write" method="POST" enctype="multipart/form-data">
						<div class="form-row">
							<div class="form-group col-sm-6">
								<label>게시글 타입</label>
								<select class="form-control" name="b_type">
									<option value="공지사항">공지사항</option>
									<option value="자료">자료</option>
									<option value="건의사항">건의사항</option>
								</select>							
							</div>
						</div>
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="b_title" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="b_txt" class="form-control" maxlength="2048" style="height:180px;"></textarea>
						</div>
						<div class="input-group">
						  <div class="custom-file">
						    <input type="file" name = "b_img" class="custom-file-input" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04">
						    <label class="custom-file-label" for="inputGroupFile04">Choose file</label>
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

</body>
</html>