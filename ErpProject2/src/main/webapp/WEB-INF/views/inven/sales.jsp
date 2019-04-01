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
	<form method="get" action="search.sales" class="form-inline mt-3">
		<select name ="searchSales" class="form-control mx-1 mt-2">
			<option value="s_no">전표코드</option>
			<option value="s_cus">거래처명</option>
		</select>
		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
		<button type="submit" class="btn btn-success mx-1 mt-2">검색</button>
		<a class="btn btn-dark mx-1 mt-2" data-toggle="modal" href="#registerModal-xl">등록하기</a> 
		<a class="btn btn-dark mx-1 mt-2" data-toggle="modal" href="#detailModal" hidden="">상세보기</a> 
	</form>
	<div class="container mt-4">
		<h2>판매관리</h2>
		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th>전표코드</th>
					<th>전표일자</th>
					<th>거래처명</th>
					<th>품목명</th>
					<th>금액</th>
					<th>비고</th>
				</tr>
			</thead>
			<c:forEach var="i" items="${sales2 }">
				<c:forEach var="j" items="${i.s_subSales }">
					<tbody>
						<tr onclick="getSalesDetail('${i.s_no }','${i.s_date }','${i.s_cus }','${i.s_m_id }','${i.s_con }','${i.s_cur }','${i.s_type }','${i.s_note }')">
							<td><input type="checkbox" class="checked"></td>
							<td>${i.s_no }</td>
							<td>${i.s_date }</td>
							<td>${i.s_cus }</td>
							<td><c:if test="${j.sb_pro_count >= 0}"> ${j.sb_pro_no } 외 ${j.sb_pro_count } 건</c:if></td>
							<td><fmt:formatNumber value="${j.sb_sum }" pattern="#,###" /></td>
							<td>${i.s_note }</td>
							
						</tr>
					</tbody>
				</c:forEach>
			</c:forEach>
		</table>
		
		<nav aria-label="Page navigation">
			  <ul class="pagination">
			  	<li class="page-item">
				   	<c:if test="${curPage != 1 && curPage != null}">
						<a href="Salespage.change?p=${curPage-1 }" class="page-link">Previous</a>
					</c:if>
				</li>
			    <c:forEach var="z" begin="1" end="${pageCount }">
			    	<li class="page-item"><a class="page-link" href="Salespage.change?p=${z }">${z }</a></li>
			    </c:forEach>  
			    <li class="page-item">
			    <c:if test="${curPage != pageCount }">
					<a href="Salespage.change?p=${curPage+1 }" class="page-link">Next</a>
				</c:if>
			    </li>
			  </ul>
		</nav>
		
	</div>
</section>	
	
	
	
	<!-- 등록하기 -->
	<div class="modal fade" id="registerModal-xl" tabindex="-1" role="dialog" aria-hidden="true">
		  <div class="modal-dialog modal-xl" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">전표 등록</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close" tabindex="-1">
		          <span aria-hidden="true" tabindex="-1">&times;</span>
		        </button>
		      </div>
		      
      	<form action="reg.sales" method="post" class="form-horizontal" name="regSaleForm">
		      <div class="modal-body">
		      		<div class="form-group row">
		      			<div class="col-sm-12">
		      				<input type="text" class="form-control" name="s_d_no" value="2" id="s_d_no" hidden="">
		      			</div>
		      		</div>
					<div class="form-group row">
					    	<label for="salesDate" class="col-sm-1 col-form-label">전표일자</label>
					    	<div class="col-sm-5">
					      		<input type="date" class="form-control" id="salesDate" name="s_date" value="${y}-${m}-${d}" tabindex=1>
					    	</div>
					    	<label for="customer" class="col-sm-1 col-form-label">거래처</label>
					    	<div class="col-sm-5">
						    	<div class="input-group mb-3">
									<input type="text" class="form-control customer" id="customer" placeholder="Choose your Customer" aria-describedby="button-addon2" name="s_cus" tabindex=2>
									  <div class="input-group-append">
									 	   <button class="btn btn-outline-secondary" type="button" id="button-addon2" data-toggle="modal" data-target=".SelectCustomer-modal-lg" onclick="findCustomer()"><i class="fas fa-search"></i></button>
									  </div>
								</div>
					    	</div>
					</div>
					
					<div class="form-group row">
					    <label for="member" class="col-sm-1 col-form-label">담당자</label>
					    	<div class="col-sm-5">
					      		<div class="input-group mb-3">
									<input type="text" class="form-control" id="member" placeholder="Recipient's username" value="${sessionScope.loginMember.m_id }" aria-describedby="button-addon2" name="s_m_id" tabindex=3>
									  <div class="input-group-append">
									 	   <button class="btn btn-outline-secondary" type="button" id="button-addon2"><i class="fas fa-search"></i></button>
									  </div>
								</div>
					    	</div>
					    	<label for="container" class="col-sm-1 col-form-label">출하창고</label>
					    	<div class="col-sm-5">
					      		<div class="input-group mb-3">
									<input type="text" class="form-control container" id="container" placeholder="Choose your Container" aria-describedby="button-addon2" name="s_con" tabindex=4>
									  <div class="input-group-append">
									 	   <button class="btn btn-outline-secondary" type="button" id="button-addon2" data-toggle="modal" data-target=".SelectContainer-modal-lg" onclick="findContainer()"><i class="fas fa-search"></i></button>
									  </div>
								</div>
					    	</div>
					</div>
					
					<div class="form-group row">
					    <label for="division" class="col-sm-1 col-form-label">거래유형</label>
					    	<div class="col-sm-5">
					      		<select id="division" class="form-control" name="s_type" tabindex=5>
										<option value="1" selected>부가세율 적용</option>
										<option value="2">부가세율 미 적용</option>
										<option value="3">해외 매출</option>
									</select>
					    	</div>
					    	<label for="currency" class="col-sm-1 col-form-label">통화</label>
					    	<div class="col-sm-5">
									<select id="currency" class="form-control" name="s_cur" tabindex=6>
										<option value="cur01" selected>원 화</option>
										<option value="cur02">달러</option>
										<option value="cur03">중국돈</option>
									</select>
					    	</div>
					</div>
					<div class="form-row">
						<label for="note" class="col-sm-1 col-form-label">비고</label>
						<div class="col-sm-11">
							<textarea class="form-control" name="s_note" maxlength="1024" style="height:80px;" id="note" tabindex=7></textarea>
						</div>
					</div>
					
					<div class="container mt-2">
					<div class="form-group row">
						<table class="table">
							<thead>
								<tr>
									<th>순서</th>
									<th>품목코드</th>
									<th>품목명</th>
									<th>규격</th>
									<th>수량</th>
									<th>단가</th>
									<th>공급가액</th>
									<th>부가세</th>
									<th>합계금액</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="i" begin="1" end="4">
									<tr>
										<td><input class="form-control ConnectNo" value="${i }" id ="s_no${i }"></td>
										<td><input class="form-control s_pro_no${i } ConnectJS" id ="s_pro_no${i }" name="sb_pro_no" tabindex=8 autocomplete="off"></td>
										<td><input class="form-control s_pro_name${i }" id ="s_pro_name${i }" readonly="readonly"></td>
										<td><input class="form-control s_pro_unit${i }" id ="s_pro_unit${i }" readonly="readonly"></td>
										<td><input class="form-control s_qty QtyJS" id ="s_qty${i }" name="sb_qty"tabindex=9 autocomplete="off"></td>
										<td><input class="form-control s_pro_price${i }" id ="s_pro_price${i }" name="sb_pro_price" autocomplete="off"></td>
										<td><input class="form-control s_price${i }" id ="s_price${i }" name="sb_price" autocomplete="off"></td>
										<td><input class="form-control s_tax${i }" id ="s_tax${i }" name="sb_tax" autocomplete="off"></td>
										<td><input class="form-control s_sum${i }" id ="s_sum${i }" name="sb_sum" autocomplete="off"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
		       </div>
			</div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" id="salesReg" class="btn btn-primary" onclick="salesSubmit();">Save</button>
		      </div>
			</form>
        
    </div>
  </div>
</div>

<!-- 상세페이지 -->
	<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">상세보기</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close" tabindex="-1">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>		
				
			<form action="update.sales" method="post" class="form-horizontal" onsubmit="return calculateQty2();">
		      <div class="modal-body">
					<div class="form-group row">
					    	<label for="salesDate" class="col-sm-1 col-form-label">전표일자</label>
					    	<div class="col-sm-5">
					      		<input type="date" class="form-control" id="d_date" name="s_date" tabindex=1>
					    	</div>
					    	<label for="customer" class="col-sm-1 col-form-label">거래처</label>
					    	<div class="col-sm-5">
						    	<div class="input-group mb-3">
									<input type="text" class="form-control customer" id="d_cus" placeholder="Choose your Customer" aria-describedby="button-addon2" name="s_cus" tabindex=2>
									  <div class="input-group-append">
									 	   <button class="btn btn-outline-secondary" type="button" id="button-addon2" data-toggle="modal" data-target=".SelectCustomer-modal-lg" onclick="findCustomer()"><i class="fas fa-search"></i></button>
									  </div>
								</div>
					    	</div>
					</div>
					
					<div class="form-group row">
					    <label for="member" class="col-sm-1 col-form-label">담당자</label>
					    	<div class="col-sm-5">
					      		<div class="input-group mb-3">
									<input type="text" class="form-control" id="d_m_id" value="${sessionScope.loginMember.m_id }" aria-describedby="button-addon2" name="s_m_id" tabindex=3>
									  <div class="input-group-append">
									 	   <button class="btn btn-outline-secondary" type="button" id="button-addon2"><i class="fas fa-search"></i></button>
									  </div>
								</div>
					    	</div>
					    	<label for="container" class="col-sm-1 col-form-label">출하창고</label>
					    	<div class="col-sm-5">
					      		<div class="input-group mb-3">
									<input type="text" class="form-control container" id="d_con" placeholder="Choose your Container" aria-describedby="button-addon2" name="s_con" tabindex=4>
									  <div class="input-group-append">
									 	   <button class="btn btn-outline-secondary" type="button" id="button-addon2" data-toggle="modal" data-target=".SelectContainer-modal-lg" onclick="findContainer()"><i class="fas fa-search"></i></button>
									  </div>
								</div>
					    	</div>
					</div>
					
					<div class="form-group row">
					    <label for="division" class="col-sm-1 col-form-label">거래유형</label>
					    	<div class="col-sm-5">
					      		<select id="d_type" class="form-control" name="s_type" tabindex=5>
										<option value="1" selected>부가세율 적용</option>
										<option value="2">부가세율 미 적용</option>
										<option value="3">해외 매출</option>
									</select>
					    	</div>
					    	<label for="currency" class="col-sm-1 col-form-label">통화</label>
					    	<div class="col-sm-5">
									<select id="d_cur" class="form-control" name="s_cur" tabindex=6>
										<option value="cur01" selected>원 화</option>
										<option value="cur02">달러</option>
										<option value="cur03">중국돈</option>
									</select>
					    	</div>
					</div>
					<div class="form-row">
						<label for="note" class="col-sm-1 col-form-label">비고</label>
						<div class="col-sm-11">
							<textarea class="form-control" name="s_note" maxlength="1024" style="height:80px;" id="d_note" tabindex=7></textarea>
						</div>
					</div>
					<div class="form-row">
						<div class="col-sm-12">
							<input id="d_no" class="form-control" hidden="">
						</div>
					</div>
					<div class="container mt-2">
					<div class="form-group row">
						<table class="table">
							<thead>
								<tr>
									<th>순서</th>
									<th>품목코드</th>
									<th>품목명</th>
									<th>규격</th>
									<th>수량</th>
									<th>단가</th>
									<th>공급가액</th>
									<th>부가세</th>
									<th>합계금액</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="i" begin="1" end="4">
									<input class="form-control s_no" id ="d_sb_no${i }" name="s_no" autocomplete="off" hidden="">
									<tr>
										<td><input class="form-control DetailNo" value="${i }"></td>
										<td><input class="form-control d_pro_no${i } ConnectJS2" id ="d_pro_no${i }" name="s_pro_no" autocomplete="off" tabindex=8></td>
										<td><input class="form-control d_pro_name${i }" id ="d_pro_name${i }" readonly="readonly"></td>
										<td><input class="form-control d_pro_unit${i }" id ="d_pro_unit${i }" readonly="readonly"></td>
										<td><input class="form-control d_qty${i } QtyJS2" id ="d_qty${i }" name="s_qty" autocomplete="off" tabindex=9></td>
										<td><input class="form-control s_pro_price${i }" id ="d_pro_price${i }" name="s_pro_price"></td>
										<td><input class="form-control d_price${i }" id ="d_price${i }" name="s_price"></td>
										<td><input class="form-control d_tax${i }" id ="d_tax${i }" name="s_tax"></td>
										<td><input class="form-control d_sum${i }" id ="d_sum${i }" name="s_sum"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
		       </div>
			</div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteSales()">삭제</button>
				<button type="button" class="btn btn-success my-2 my-sm-0" onclick="goInvoice()">Invoice 출력</button>
				<button type="button" class="btn btn-primary" onclick="salesUpdate();">수정</button>
		      </div>
			</form>
			</div>
		</div>
	</div>




<!-- Customer Modal Line -->

<div class="modal fade SelectCustomer-modal-lg" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">거래처 리스트</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      	<form method="get" action="search.customer" class="form-inline mt-3">
		<select name ="searchType" class="form-control mx-1 mt-2">
			<option value="cus_no">거래처코드</option>
			<option value="cus_name">거래처명</option>
		</select>
		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
		<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
	</form>
      
      <div class="container mt-3">
        <table class="table">
			<thead>
				<tr>
					<th>거래처코드</th>
					<th>상호명</th>
					<th>등록번호</th>
					<th>대표자</th>
					<th>주소</th>
					<th>거래처구분</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody class="CustomerList">
			</tbody>        
        </table>
        
        <nav aria-label="Page navigation">
			  <ul class="pagination">
			    <c:forEach var="z" begin="1" end="${pageCount }">
			    	<li class="page-item"><a class="page-link" href="#" onclick="getCustomerPaging(${z})">${z }</a></li>
			    </c:forEach>  
			  </ul>
		</nav>
       </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
	
	
<!-- Container Modal Line -->

<div class="modal fade SelectContainer-modal-lg" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">창고 리스트</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      	<form method="get" action="search.customer" class="form-inline mt-3">
		<select name ="searchType" class="form-control mx-1 mt-2">
			<option value="cus_no">창고코드</option>
			<option value="cus_name">창고명</option>
		</select>
		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
		<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
	</form>
      
      <div class="container mt-3">
        <table class="table">
			<thead>
				<tr>
					<th>창고코드</th>
					<th>창고명</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody class="ContainerList">
			</tbody>        
        </table>
        
         <nav aria-label="Page navigation">
			  <ul class="pagination">
			    <c:forEach var="z" begin="1" end="${pageCount }">
			    	<li class="page-item"><a class="page-link" href="#" onclick="getContainerPaging(${z})">${z }</a></li>
			    </c:forEach>  
			  </ul>
		</nav>
       </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<!-- Product Modal Line -->

<div class="modal fade SelectProduct-modal-lg" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">품목 리스트</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      	<form method="get" action="search.customer" class="form-inline mt-3">
		<select name ="searchType" class="form-control mx-1 mt-2">
			<option value="pro_no">제품코드</option>
			<option value="pro_name">제품명</option>
		</select>
		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
		<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
	</form>
      
      <div class="container mt-3">
        <table class="table">
			<thead>
				<tr>
					<th>제품코드</th>
					<th>제품명</th>
					<th>규격</th>
					<th>무게</th>
					<th>구매단가</th>
					<th>판매단가</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody class="ProductList">
			</tbody>        
        </table>
        
         <nav aria-label="Page navigation">
			  <ul class="pagination">
			    <c:forEach var="z" begin="1" end="${pageCount }">
			    	<li class="page-item"><a class="page-link" href="#" onclick="getProductPaging(${z})">${z }</a></li>
			    </c:forEach>  
			  </ul>
		</nav>
       </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>	




	
	
	
</body>
</html>