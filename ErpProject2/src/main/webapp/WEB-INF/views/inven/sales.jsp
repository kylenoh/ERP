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
			<option value="s_name">전표명</option>
		</select>
		<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
		<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
		<a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal-xl">등록하기</a> 
		<a class="btn btn-success mx-1 mt-2" data-toggle="modal" href="#detailModal" hidden="">상세보기</a> 
	</form>
	
	<div class="container mt-4">
		<h2>구매관리</h2>
		<p>상세설명합니다.</p>
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
				<tbody>
					<tr onclick="getSalesDetail('${i.s_date }','${i.s_cus }','${i.s_m_id }','${i.s_con }','${i.s_cur }','${i.s_type }','${i.s_pro_no }','${i.s_qty }','${i.s_pro_price }','${i.s_price }','${i.s_tax }','${i.s_sum }')">
						<td><input type="checkbox" class="checked"></td>
						<td>${i.s_no }</td>
						<td>${i.s_date }</td>
						<td>${i.s_cus }</td>
						<td>${i.s_pro_no }</td>
						<td>${i.s_sum }</td>
						<td>${i.s_pro_no }</td>
					</tr>
				</tbody>
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
	
	
	<!-- 상세페이지 -->
	<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">상세보기</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>		
				
			<form action="update.sales" method="post" class="form-horizontal">
		      <div class="modal-body">
					<div class="form-group row">
					    	<label for="salesDate" class="col-sm-1 col-form-label">전표일자</label>
					    	<div class="col-sm-5">
					      		<input type="date" class="form-control" id="salesDate d_date" name="s_date">
					    	</div>
					    	<label for="customer" class="col-sm-1 col-form-label">거래처</label>
					    	<div class="col-sm-5">
						    	<div class="input-group mb-3">
									<input type="text" class="form-control" id="customer d_cus" placeholder="Choose your Customer" aria-describedby="button-addon2" name="s_cus">
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
									<input type="text" class="form-control" id="member d_m_id" value="${sessionScope.loginMember.m_id }" aria-describedby="button-addon2" name="s_m_id">
									  <div class="input-group-append">
									 	   <button class="btn btn-outline-secondary" type="button" id="button-addon2"><i class="fas fa-search"></i></button>
									  </div>
								</div>
					    	</div>
					    	<label for="container" class="col-sm-1 col-form-label">출하창고</label>
					    	<div class="col-sm-5">
					      		<div class="input-group mb-3">
									<input type="text" class="form-control" id="container d_con" placeholder="Choose your Container" aria-describedby="button-addon2" name="s_con">
									  <div class="input-group-append">
									 	   <button class="btn btn-outline-secondary" type="button" id="button-addon2" data-toggle="modal" data-target=".SelectContainer-modal-lg" onclick="findContainer()"><i class="fas fa-search"></i></button>
									  </div>
								</div>
					    	</div>
					</div>
					
					<div class="form-group row">
					    <label for="division" class="col-sm-1 col-form-label">거래유형</label>
					    	<div class="col-sm-5">
					      		<select id="division" class="form-control" name="s_type">
										<option value="1" selected>부가세율 적용</option>
										<option value="2">부가세율 미 적용</option>
										<option value="3">해외 매출</option>
									</select>
					    	</div>
					    	<label for="currency" class="col-sm-1 col-form-label">통화</label>
					    	<div class="col-sm-5">
									<select id="currency d_cur" class="form-control" name="s_cur">
										<option value="cur01" selected>원 화</option>
										<option value="cur02">달러</option>
										<option value="cur03">중국돈</option>
									</select>
					    	</div>
					</div>
					
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
									<tr>
										<td><input class="form-control"></td>
										<td><input class="form-control s_pro_no" id ="d_pro_no" name="s_pro_no"></td>
										<td><input class="form-control s_pro_name" id ="d_pro_name" readonly="readonly"></td>
										<td><input class="form-control s_pro_unit" id ="d_pro_unit" readonly="readonly"></td>
										<td><input class="form-control s_qty" id ="d_qty" name="s_qty">	</td>
										<td><input class="form-control s_pro_price" id ="d_pro_price" name="s_pro_price"></td>
										<td><input class="form-control s_price" id ="d_price" name="s_price"></td>
										<td><input class="form-control s_tax" id ="d_tax" name="s_tax"></td>
										<td><input class="form-control s_sum" id ="d_sum" name="s_sum"></td>
									</tr>
							</tbody>
						</table>
					</div>
		       </div>

		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save</button>
		      </div>
			</form>
			</div>
		</div>
	</div>
	<!-- 등록하기 -->
	<div class="modal fade" id="registerModal-xl" tabindex="-1" role="dialog" aria-hidden="true">
		  <div class="modal-dialog modal-xl" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">전표 등록</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      
      	<form action="reg.sales" method="post" class="form-horizontal">
		      <div class="modal-body">
					<div class="form-group row">
					    	<label for="salesDate" class="col-sm-1 col-form-label">전표일자</label>
					    	<div class="col-sm-5">
					      		<input type="date" class="form-control" id="salesDate" name="s_date" value="${y}-${m}-${d}">
					    	</div>
					    	<label for="customer" class="col-sm-1 col-form-label">거래처</label>
					    	<div class="col-sm-5">
						    	<div class="input-group mb-3">
									<input type="text" class="form-control" id="customer" placeholder="Choose your Customer" aria-describedby="button-addon2" name="s_cus">
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
									<input type="text" class="form-control" id="member" placeholder="Recipient's username" value="${sessionScope.loginMember.m_id }" aria-describedby="button-addon2" name="s_m_id">
									  <div class="input-group-append">
									 	   <button class="btn btn-outline-secondary" type="button" id="button-addon2"><i class="fas fa-search"></i></button>
									  </div>
								</div>
					    	</div>
					    	<label for="container" class="col-sm-1 col-form-label">출하창고</label>
					    	<div class="col-sm-5">
					      		<div class="input-group mb-3">
									<input type="text" class="form-control" id="container" placeholder="Choose your Container" aria-describedby="button-addon2" name="s_con">
									  <div class="input-group-append">
									 	   <button class="btn btn-outline-secondary" type="button" id="button-addon2" data-toggle="modal" data-target=".SelectContainer-modal-lg" onclick="findContainer()"><i class="fas fa-search"></i></button>
									  </div>
								</div>
					    	</div>
					</div>
					
					<div class="form-group row">
					    <label for="division" class="col-sm-1 col-form-label">거래유형</label>
					    	<div class="col-sm-5">
					      		<select id="division" class="form-control" name="s_type">
										<option value="1" selected>부가세율 적용</option>
										<option value="2">부가세율 미 적용</option>
										<option value="3">해외 매출</option>
									</select>
					    	</div>
					    	<label for="currency" class="col-sm-1 col-form-label">통화</label>
					    	<div class="col-sm-5">
									<select id="currency" class="form-control" name="s_cur">
										<option value="cur01" selected>원 화</option>
										<option value="cur02">달러</option>
										<option value="cur03">중국돈</option>
									</select>
					    	</div>
					</div>
					
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
									<tr>
										<td><input class="form-control" value="1"></td>
										<td><input class="form-control s_pro_no " id ="s_pro_no" name="s_pro_no" ></td>
										<td><input class="form-control s_pro_name" id ="s_pro_name" readonly="readonly"></td>
										<td><input class="form-control s_pro_unit" id ="s_pro_unit" readonly="readonly"></td>
										<td><input class="form-control s_qty QtyJS" id ="s_qty" name="s_qty"></td>
										<td><input class="form-control s_pro_price" id ="s_pro_price" name="s_pro_price"></td>
										<td><input class="form-control s_price" id ="s_price" name="s_price"></td>
										<td><input class="form-control s_tax" id ="s_tax" name="s_tax"></td>
										<td><input class="form-control s_sum" id ="s_sum" name="s_sum"></td>
									</tr>
							</tbody>
						</table>
					</div>
		       </div>

		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" id="salesReg" class="btn btn-primary">Save</button>
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