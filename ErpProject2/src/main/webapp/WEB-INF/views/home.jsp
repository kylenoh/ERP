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
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active" style="background-image: url('resources/file/startup.jpg'); width:100%; heieght:100%;">
        <div class="container">
          <div class="carousel-caption text-left">
          </div>
        </div>
      </div>
      <div class="carousel-item" style="background-image: url('resources/file/board.jpg'); width:100%; heieght:100%;">
        <div class="container">
          <div class="carousel-caption">
          </div>
        </div>
      </div>
      <div class="carousel-item" style="background-image: url('resources/file/books.jpg'); width:100%; heieght:100%;">
        <div class="container">
          <div class="carousel-caption text-right">
            <h1>Business Services</h1>
            <p>Transform your business faster with help from Coperation Business Services</p>
            <p><a class="btn btn-lg btn-primary" href="https://github.com/kylenoh/PersonalProject.git" role="button">View details</a></p>
          </div>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>


  <div class="container marketing">

    <div class="row">
      <div class="col-lg-4">
        <img src="resources/file/java.JPG" style="width:140px; height:140px;" class="rounded-square">
        <p>JAVA 1.8.0_181 을 사용하여 Controller와 비즈니스 로직을 작성 하였습니다.</p>
        <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
      <div class="col-lg-4">
        <img src="resources/file/oracle.JPG" style="width:140px; height:140px;" class="rounded-square">
        <p>다양한 사용자에게 입증된 Oracle 11g Express Edition으로 구성되었습니다.</p>
        <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
      <div class="col-lg-4">
        <img src="resources/file/Spring.JPG" style="width:140px; height:140px;" class="rounded-square">
        <p>개발 속도 향상과 유지보수를 위하여 전자 정부 표준 프레임 워크 3.7 버전으로 구성하였습니다.</p>
        <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">

    <div class="row featurette">
      <div class="col-md-7">
        <h2 class="featurette-heading">당신의 사업을 효율적으로 관리해드리겠습니다.</h2>
        <p class="lead">PC에 깔아서 혼자만 쓰거나 여럿이 쓰더라도 제한적이라면 불편할 수밖에 없습니다.
								구매팀은 엑셀로 관리하고 영업팀은 재고현황을 알지 못한 채, 업무에 투입된다면 
								같은 일을 두 번 세 번 하게 되고, 서로 가진 데이터가 달라지는 큰 문제가 생길 수 있습니다.</p>
      </div>
      <div class="col-md-5">
      	<img src="resources/file/marketing.jpg" class="bd-placeholder-img-lg featurette-image img-fluid mx-auto" style="width:500px; height:400px;">
      </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
      <div class="col-md-7 order-md-2">
        <h2 class="featurette-heading">ERP 도입의 중요성</h2>
        <p class="lead">ERP를 도입한 중소기업의 5년 뒤 모습을 보면, 대부분 다시 엑셀로 업무를 하고 있습니다. 업무 변화에 따른 커스터마이징의 한계, 개발사 폐업, 데이터 오류, 과다한 유지보수 비용 등이 주 원인입니다.</p>
      </div>
      <div class="col-md-5 order-md-1">
        <img src="resources/file/statistics.jpg" class="bd-placeholder-img-lg featurette-image img-fluid mx-auto" style="width:500px; height:400px;">
      </div>
    </div>

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->

  </div><!-- /.container -->


</body>
</html>