<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.6.3.min.js"></script>  
    <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/animate.css">
	<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/owl.carousel.min.css">
	<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/owl.theme.default.min.css">
	<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/magnific-popup.css">
	<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
	<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/flaticon.css">
	<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/style.css">
<style type="text/css">
	table th {
		text-align: center;
	}
</style>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp" />
	
  <section class="ftco-section">
	    <div class="overlay"></div>
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate mb-5 text-center">
          	<p class="breadcrumbs mb-0"><span class="mr-2"><a href="main.do">Home <i class="fa fa-chevron-right"></i></a></span> <span>Review<i class="fa fa-chevron-right"></i></span></p>
            <h2 class="mb-0 bread">리뷰 작성</h2>
          </div>
        </div> 
		&nbsp;&nbsp;
<form action="rwrite.do" method="post" enctype="multipart/form-data">
<table align="center" width="600"n border="1" cellspacing="0" cellpadding="5" text-color="black";>
	<tr><th>제 목</th>
			<td><input type="text" name="review_title"></td>
	</tr>
	<tr><th>별 점</th>
		<td>
			<form class="mb-3" name="myform" id="myform" method="post">
				<fieldset>
					<span class="text-bold">별점을 선택해주세요</span>
					<input type="radio" name="reviewStar" value="5" id="rate1"><label
						for="rate1">★</label>
					<input type="radio" name="reviewStar" value="4" id="rate2"><label
						for="rate2">★</label>
					<input type="radio" name="reviewStar" value="3" id="rate3"><label
						for="rate3">★</label>
					<input type="radio" name="reviewStar" value="2" id="rate4"><label
						for="rate4">★</label>
					<input type="radio" name="reviewStar" value="1" id="rate5"><label
						for="rate5">★</label>
				</fieldset>
			</form>		
		</td>
	</tr>
	<tr>
		<th>작성자</th>
			<td><input type="text" name="user_id" readonly value="${ sessionScope.loginMember.userid }"></td>
	</tr>
	<tr>
		<th>첨부파일</th>
			<td><input type="file" name="upfile"></td>
	</tr>
	<tr>
		<th>내 용</th>
			<td><textarea name="review_content" rows="5" cols="60"></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
		<button onclick="javascript:history.go(-1); return false;">목록</button> &nbsp;
		<input type="submit" value="등록하기"> &nbsp;
		<input type="reset" value="작성취소">
		</th>
	</tr>
</table>
</form>
</section>
<br>

<hr>
  <footer>
     	<c:import url="/WEB-INF/views/common/footer.jsp" />
    </footer>
 <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-migrate-3.0.1.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/popper.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.easing.1.3.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.waypoints.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.stellar.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/owl.carousel.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.animateNumber.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/scrollax.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/main.js"></script>		
  </body>
</html>