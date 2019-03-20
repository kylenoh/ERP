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
                            <th scope="col">SALE</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="s" items="${stock }" varStatus="status">
		                        <tr>
		                            <th scope="row">${status.count}</th>
		                            <td class="text-left">${s.sb_pro_no }</td>
		                            <td class="name">${s.pro_name }</td>
		                            <td class="text-right">
		                            	<fmt:formatNumber value="${s.sum_company + s.sum_china }" pattern="#,###" />
		                            </td>
		                            <td class="COMPANY CON text-right">
		                           		<fmt:formatNumber value="${s.sum_company }" pattern="#,###" />
		                            </td>
		                            <td class="CHINA CON text-right">
		                            	<fmt:formatNumber value="${s.sum_china }" pattern="#,###" />
		                            </td>
		                            <td class="SALE text-right"><fmt:formatNumber value="0" pattern="#,###" /></td>
		                        </tr>
		                  </c:forEach>
                    </tbody>
                </table>
</div>


</body>
</html>