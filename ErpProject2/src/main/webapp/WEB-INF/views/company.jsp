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
                        <div class="profile-img">
                            <img src="resources/file/profile.jpg" alt=""/>
                            <div class="file btn btn-lg btn-primary">
                                Change Logo
                                <input type="file" name="file"/>
                            </div>
                        </div>
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
                        <a class="btn btn-outline-success my-2 my-sm-0"  data-toggle="modal" href="#registerModal">Edit Information</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>상호명</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><input type="text" class="form-control"></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>등록자 번호</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><input type="text" class="form-control"></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><input type="text" class="form-control"></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>대표번호</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><input type="text" class="form-control"></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>주소</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><input type="text" class="form-control"></p>
                                            </div>
                                        </div>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Company Name</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><input type="text" class="form-control"></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Register Number</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><input type="text" class="form-control"></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><input type="text" class="form-control"></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Phone</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><input type="text" class="form-control"></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Address</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><input type="text" class="form-control"></p>
                                            </div>
                                        </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>
        
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
									<input type="text" name="com_Ename" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>TEL</label>
									<input type="text" name="com_Etel" class="form-control" maxlength="30">
								</div>
								<div class="form-group">
									<label>Address</label>
									<input type="text" name="com_Eaddr" class="form-control" maxlength="30">
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
        
        
</body>
</html>