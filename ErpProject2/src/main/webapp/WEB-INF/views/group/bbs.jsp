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
	<form method="get" action="#" class="form-inline mt-3">
		<select name ="lectureDivide" class="form-control mx-1 mt-2">
			<option value="먹자">고객관리</option>
		</select>
		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
		<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
		<a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a> 
		<a class="btn btn-danger mx-1 mt-2" data-toggle="modal" href="#reportModal">신고하기</a>
	</form>
	
	<div class="card bg-light mt-3">
		<div class="card-header bg-light">
			<div class="row">
				<div class="col-8 text-left">컴퓨터개론&nbsp;<small>kyle</small></div>
				<div class="col-4 text-right">
					종합<span style="color: red;">A</span>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title">
				좋은강의 &nbsp;<small>(가을학기)</small>
			</h5>
			<p class="card-text">강으 ㅣ널널</p>
			<div class="row">
				<div class="col-9 text-left">
					성적<span style="color:red;">A</span>
					널널<span style="color:red;">A</span>
					강의<span style="color:red;">B</span>
					<span style="color:green;">(추천:15)</span>
				</div>
				<div class="col-3 text-right">
					<a href="./likeAction.jsp?evluationID=" onclick="return confirm('추천하시겠습니까?')">추천 </a>
					<a href="./deleteAction.jsp?evluationID=" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
				</div>
			</div>
		</div>
	</div>
	
		<div class="card bg-light mt-3">
		<div class="card-header bg-light">
			<div class="row">
				<div class="col-8 text-left">컴퓨터개론&nbsp;<small>kyle</small></div>
				<div class="col-4 text-right">
					종합<span style="color: red;">A</span>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title">
				좋은강의 &nbsp;<small>(가을학기)</small>
			</h5>
			<p class="card-text">강으 ㅣ널널</p>
			<div class="row">
				<div class="col-9 text-left">
					성적<span style="color:red;">A</span>
					널널<span style="color:red;">A</span>
					강의<span style="color:red;">B</span>
					<span style="color:green;">(추천:15)</span>
				</div>
				<div class="col-3 text-right">
					<a href="./likeAction.jsp?evluationID=" onclick="return confirm('추천하시겠습니까?')">추천 </a>
					<a href="./deleteAction.jsp?evluationID=" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
				</div>
			</div>
		</div>
	</div>
	
		<div class="card bg-light mt-3">
		<div class="card-header bg-light">
			<div class="row">
				<div class="col-8 text-left">컴퓨터개론&nbsp;<small>kyle</small></div>
				<div class="col-4 text-right">
					종합<span style="color: red;">A</span>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title">
				좋은강의 &nbsp;<small>(가을학기)</small>
			</h5>
			<p class="card-text">강으 ㅣ널널</p>
			<div class="row">
				<div class="col-9 text-left">
					성적<span style="color:red;">A</span>
					널널<span style="color:red;">A</span>
					강의<span style="color:red;">B</span>
					<span style="color:green;">(추천:15)</span>
				</div>
				<div class="col-3 text-right">
					<a href="./likeAction.jsp?evluationID=" onclick="return confirm('추천하시겠습니까?')">추천 </a>
					<a href="./deleteAction.jsp?evluationID=" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
				</div>
			</div>
		</div>
	</div>
</section>	
	
	<!-- 등록하기 -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">평가등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>		
				<div class="modal-body">
					<form action="reg.chat" method="post">
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="chatTitle" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="chatContent" class="form-control" maxlength="2048" style="height:180px;"></textarea>
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
<!-- 신고하기 -->
	<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">신고하기</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>		
				<div class="modal-body">
					<form action="./reportAction.jsp" method="post">
						<div class="form-group">
							<label>신고 제목</label>
							<input type="text" name="reportTitle" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>신고 내용</label>
							<textarea name="reportContent" class="form-control" maxlength="2048" style="height:180px;"></textarea>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-danger">신고하기</button>
						</div>
					</form>
				</div>		
			</div>
		</div>
	</div>

</body>
</html>