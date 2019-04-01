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
		<div class="container mt-4">
			<table class="table">
				<thead>
					<tr>
						<th>UserId</th>
						<th>Name</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Edit</th>
					</tr>
				</thead>
					<tbody>
						<c:forEach var="i" items="${membersList }">
							<tr>
								<td align="center">${i.m_id }</td>
								<td align="center">${i.m_name }</td>
								<td align="center">${i.m_email }</td>
								<td align="center">${i.auth_name }</td>
								<td align="center">
									<a href="#"><i class="fa fa-pencil-square-o"></i></a>
	                                <a href="#"><i class="fa fa-eye"></i></a>
	                                <a href="#"><i class="fa fa-trash"></i></a>
	                            </td>
							</tr>
                        </c:forEach>
					</tbody>
			</table>
			
			<nav aria-label="Page navigation">
				  <ul class="pagination">
				  	<li class="page-item">
							<a href="Containerpage.change?p=${curPage-1 }" class="page-link">Previous</a>
					</li>
				    	<li class="page-item"><a class="page-link" href="Containerpage.change?p=${z }">${z }</a></li>
				    <li class="page-item">
						<a href="Containerpage.change?p=${curPage+1 }" class="page-link">Next</a>
				    </li>
				  </ul>
			</nav>
		</div>
	</section>
	
</body>
</html>