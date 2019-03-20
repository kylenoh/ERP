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
	<div class="container com-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                       
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">회사 정보</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">영문 회사 정보</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                    <c:choose>
						<c:when test="${company.com_name!=null}">
							<a class="btn btn-outline-success my-2 my-sm-0"  data-toggle="modal" href="#detailModal">Edit Information</a>
						</c:when>
						<c:otherwise>
							<a class="btn btn-outline-success my-2 my-sm-0"  data-toggle="modal" href="#registerModal">Edit Information</a>
						</c:otherwise>
					</c:choose>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                    	 <div class="profile-img">
                            <img src="resources/file/${company.com_logo}" alt=""/>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>상호명</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${company.com_name}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>등록자 번호</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${company.com_no}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${company.com_email}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>대표번호</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${company.com_tel}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>주소</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${company.com_addr}</p>
                                            </div>
                                        </div>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Company Name</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${company.com_ename}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Phone</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${company.com_etel}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Address</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${company.com_eaddr}</p>
                                            </div>
                                        </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>
        
        <!-- 등록모달 -->
        <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">자사등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					 
				</div>		
				<div class="modal-body">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab2" data-toggle="tab" href="#home2" role="tab" aria-controls="home" aria-selected="true">회사 정보</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab2" data-toggle="tab" href="#profile2" role="tab" aria-controls="profile" aria-selected="false">영문 회사 정보</a>
                                </li>
                </ul>
					<form action="reg.company" method="post" enctype="multipart/form-data">
					<div class="tab-content profile-tab" id="myTabContent">
						<div class="tab-pane fade show active" id="home2" role="tabpanel" aria-labelledby="home-tab2">
								<div class="form-group">
									<label>회사명</label>
									<input type="text" name="com_name" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>사업자 등록번호</label>
									<input type="text" name="com_no" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>Email</label>
									<input type="text" name="com_email" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>대표번호</label>
									<input type="text" name="com_tel" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>주소</label>
									<input type="text" name="com_addr" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>회사 로고</label>
									<input type="file" name="com_logo" class="form-control" autocomplete="off">
								</div>
						</div>
						<div class="tab-pane fade" id="profile2" role="tabpanel" aria-labelledby="profile-tab2">
								<div class="form-group">
									<label>Company Name</label>
									<input type="text" name="com_ename" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>TEL</label>
									<input type="text" name="com_etel" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>Address</label>
									<input type="text" name="com_eaddr" class="form-control" maxlength="30">
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
        
        
         <!-- 수정 -->
        <div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">자사정보수정</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					 
				</div>		
				<div class="modal-body">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab3" data-toggle="tab" href="#home3" role="tab" aria-controls="home" aria-selected="true">회사 정보</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab3" data-toggle="tab" href="#profile3" role="tab" aria-controls="profile" aria-selected="false">영문 회사 정보</a>
                                </li>
                </ul>
					<form action="update.company" method="post" enctype="multipart/form-data">
					<div class="tab-content profile-tab" id="myTabContent">
						<div class="tab-pane fade show active" id="home3" role="tabpanel" aria-labelledby="home-tab3">
								<div class="form-group">
									<label>회사코드</label>
									<input type="text" name="com_key" class="form-control" maxlength="30" value="${company.com_key}" readonly="readonly">
								</div>
								<div class="form-group">
									<label>회사명</label>
									<input type="text" name="com_name" class="form-control" maxlength="30" value="${company.com_name}">
								</div>
								<div class="form-group">
									<label>사업자 등록번호</label>
									<input type="text" name="com_no" class="form-control" maxlength="30" value="${company.com_no}">
								</div>
								<div class="form-group">
									<label>Email</label>
									<input type="text" name="com_email" class="form-control" maxlength="30" value="${company.com_email}">
								</div>
								<div class="form-group">
									<label>대표번호</label>
									<input type="text" name="com_tel" class="form-control" maxlength="30" value="${company.com_tel}">
								</div>
								<div class="form-group">
									<label>주소</label>
									<input type="text" name="com_addr" class="form-control" maxlength="30" value="${company.com_addr}">
								</div>
								<div class="form-group">
									<label>회사 로고</label>
									<input type="file" name="com_logo" class="form-control" autocomplete="off" value="${company.com_logo}">
								</div>
						</div>
						<div class="tab-pane fade" id="profile3" role="tabpanel" aria-labelledby="profile-tab3">
								<div class="form-group">
									<label>Company Name</label>
									<input type="text" name="com_ename" class="form-control" maxlength="30" value="${company.com_ename}">
								</div>
								<div class="form-group">
									<label>TEL</label>
									<input type="text" name="com_etel" class="form-control" maxlength="30" value="${company.com_etel}">
								</div>
								<div class="form-group">
									<label>Address</label>
									<input type="text" name="com_eaddr" class="form-control" maxlength="30" value="${company.com_eaddr}">
								</div>
						</div>
				</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-primary">수정하기</button>
						</div>
					</form>
				</div>		
			</div>
		</div>
	</div>
        
</body>
</html>