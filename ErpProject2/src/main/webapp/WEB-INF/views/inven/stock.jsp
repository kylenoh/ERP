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
<div class="container mt-9">
	<div class="container mt-3">
		<div id="selectContainer" class="form-inline">
			<select id="year" class="form-control mr-2">
				<c:forEach var="y" begin="0" end="7">
					<option>${2019 - y }</option>
				</c:forEach>
			</select>
			<select id="month" class="form-control mr-2">
				<c:forEach var="m" begin="1" end="12">
					<option>${m }</option>
				</c:forEach>
			</select>
			<select id="day" class="form-control mr-2">
				<c:forEach var="d" begin="1" end="31">
					<option>${d }</option>
				</c:forEach>
			</select>
		</div>
		<div id="chartContainer" style="height: 320px; width: 100%;"></div>
	</div>
	<div class="container mt-3">
		<h2>재고관리</h2>
	</div>
                
                 <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th scope="col">품목코드</th>
                            <th scope="col">품목명</th>
                            <th scope="col">TOTAL</th>
                            <th scope="col">회사창고</th>
                            <th scope="col">중국창고</th>
                            <th scope="col">입고수량</th>
                            <th scope="col">출고수량</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="p" items="${Purchasestock }" varStatus="status">
		                        <tr>
		                            <th scope="row">${status.count}</th>
		                            <td class="text-left">${p.psb_pro_no }</td>
		                            <td class="name">${p.pro_name }</td>
		                            <td class="text-right">
		                            	<fmt:formatNumber value="${(p.sum_company + p.sum_china) - (p.out_company + p.out_china) }" pattern="#,###" />
		                            </td>
		                            <td class="COMPANY CON text-right">
		                           		<fmt:formatNumber value="${p.sum_company }" pattern="#,###" />
		                            </td>
		                            <td class="CHINA CON text-right">
		                            	<fmt:formatNumber value="${p.sum_china }" pattern="#,###" />
		                            </td>
		                            <td class="SALE text-right"><fmt:formatNumber value="${p.sum_company + p.sum_china }" pattern="#,###" /></td>
		                            <td class="SALE text-right"><fmt:formatNumber value="${p.out_company + p.out_china }" pattern="#,###" /></td>
		                        </tr>
		                        </c:forEach>
                    </tbody>
                </table>
                
</div>


</body>
</html>