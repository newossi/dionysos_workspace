<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<title>Dionysos</title>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.6.3.min.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/common/menubar.jsp" />


	<div align="center" class="main-filter-layer">
		<div class='main-filter clear'>
			<form action="avdsearch.do" method="post">
				<fieldset>
					<legend>와인 종류</legend>
					<input name='wine_type' type='checkbox' value='red'> 레드
					&nbsp; &nbsp; <input name='wine_type' type='checkbox' value='white'>
					화이트 &nbsp; &nbsp; <input name='wine_type' type='checkbox'
						value='sparkling'> 스파클링 &nbsp; &nbsp; <input
						name='wine_type' type='checkbox' value='rose'>로제 &nbsp;
					&nbsp; <input name='wine_type' type='checkbox' value='fortified'>주정강화
					&nbsp; &nbsp;
				</fieldset>
				<br>
				<fieldset>
					<legend>와인 원산지</legend>
					<input name='wine_origin' type='checkbox' value="프랑스">
					프랑스&nbsp; &nbsp; <input name='wine_origin' type='checkbox'
						value="이탈리아"> 이탈리아&nbsp; &nbsp; <input name='wine_origin'
						type='checkbox' value="스페인"> 스페인&nbsp; &nbsp; <input
						name='wine_origin' type='checkbox' value="포르투갈">
					포르투갈&nbsp; &nbsp; <input name='wine_origin' type='checkbox'
						value="독일"> 독일&nbsp; &nbsp; <input name='wine_origin'
						type='checkbox' value="오스트리아"> 오스트리아&nbsp; &nbsp; <input
						name='wine_origin' type='checkbox' value="미국"> 미국&nbsp;
					&nbsp; <input name='wine_origin' type='checkbox' value="호주">
					호주&nbsp; &nbsp; <input name='wine_origin' type='checkbox'
						value="뉴질랜드"> 뉴질랜드&nbsp; &nbsp; <input name='wine_origin'
						type='checkbox' value="칠레"> 칠레&nbsp; &nbsp; <input
						name='wine_origin' type='checkbox' value="아르헨티나">
					아르헨티나&nbsp; &nbsp; <input name='wine_origin' type='checkbox'
						value="남아프리카"> 남아프리카&nbsp; &nbsp;
				</fieldset>
				<br>
				<fieldset>
					<legend>가격대</legend>
					<input name='product_price' type='radio' value="10000"> 1만원
					이하&nbsp;&nbsp; <input name='radio' type='radio' value="30000">
					3만원 이하&nbsp;&nbsp; <input name='product_price' type='radio'
						value="50000"> 5만원 이하&nbsp;&nbsp; <input
						name='product_price' type='radio' value="70000"> 7만원
					이하&nbsp;&nbsp; <input name='product_price' type='radio'
						value="100000"> 10만원 이하&nbsp;&nbsp; <input
						name='product_price' type='radio' value="200000"> 20만원
					이하&nbsp;&nbsp; <input name='product_price' type='radio'
						value="500000"> 50만원 이하&nbsp;&nbsp; <input
						name='product_price' type='radio' value="1000000"> 100만원
					이하&nbsp;&nbsp; <input name='product_price' type='radio'
						value="9999999"> 100만원 이상&nbsp;&nbsp;
				</fieldset>
				<br>
				<fieldset>
					<legend>음식</legend>
					<input name='food_id' type='checkbox' value=""> 스테이크
					(소)&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					삼겹살 (돼지)&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					치킨 (닭)&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					생선회 (생선)&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					해산물 (조개)&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					샐러드&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					튀김&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					치즈&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					과일&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					디저트&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					족발 (한식)&nbsp;&nbsp; <input name='food_id' type='checkbox' value="">
					피자 (양식)&nbsp;&nbsp;
				</fieldset>
				<br>
				<fieldset>
					<legend>와인 특성</legend>
					당도&nbsp;&nbsp; <input type="checkbox" id="checkbox"
						onclick="sweetness.disabled=!this.checked;"> <input
						type="range" id="sweetness" name="sweetness" min="0" max="5"
						step="1" list="tick" disabled> &nbsp;&nbsp;산도&nbsp;&nbsp;
					<input type="checkbox" id="checkbox"
						onclick="acidity.disabled=!this.checked;"> <input
						type="range" id="acidity" name="acidity" min="0" max="5" step="1"
						disabled> &nbsp;&nbsp;바디&nbsp;&nbsp; <input
						type="checkbox" id="checkbox"
						onclick="wbody.disabled=!this.checked;"> <input
						type="range" id="body" name="body" min="0" max="5" step="1"
						disabled> &nbsp;&nbsp;타닌&nbsp;&nbsp; <input
						type="checkbox" id="checkbox"
						onclick="tannin.disabled=!this.checked;"> <input
						type="range" id="tannin" name="tannin" min="0" max="5" step="1"
						disabled> <br>
					<button type='reset' onclick="mainCategoryInit();">초기화</button>
					<button type='submit' onclick="mainCategoryGo();">검색</button>
				</fieldset>
			</form>
		</div>
	</div>

	<!-- end .main-filter -->


	<section class="ftco-section">
		<div class="container">
			<hr>
			<div class="row justify-content-center pb-5">
				<div class="col-md-7 heading-section text-center ftco-animate">
					<span class="subheading"><h3>베스트 상품</h3></span>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${list1}" var="product">
					<div class="col-md-3 d-flex">
						<div class="product ftco-animate">
							<div class="img d-flex align-items-center justify-content-center"
								style="background-image: url(${product.product_image});">
								<div class="desc">
									<p class="meta-prod d-flex">
										<a href="#"
											class="d-flex align-items-center justify-content-center"><span
											class="flaticon-shopping-bag"></span></a> <a href="#"
											class="d-flex align-items-center justify-content-center"><span
											class="flaticon-heart"></span></a> <a href="#"
											class="d-flex align-items-center justify-content-center"><span
											class="flaticon-visibility"></span></a>
									</p>
								</div>
							</div>
							<c:url var="pdetail" value="pdetail.do">
								<c:param name="product_id" value="${product.product_id }" />
							</c:url>
							<a href="${pdetail}">
								<div class="text text-center">
									<span class="sale">${product.wine_type}</span> <span
										class="category">${product.product_ename}</span>
									<h2>${product.product_name}</h2>
									<p class="mb-0">
										<span class="price price-sale"><fmt:formatNumber
												type="currency" value="${product.product_price}"></fmt:formatNumber></span>
										<span class="price"><fmt:formatNumber type="currency"
												value="${product.product_price * 0.8}"></fmt:formatNumber></span>
									</p>
								</div>
							</a>
						</div>
					</div>
				</c:forEach>
			</div>
			<hr>
			<div class="row justify-content-center pb-5">
				<div class="col-md-7 heading-section text-center ftco-animate">
					<span class="subheading"><h3>신상품</h3></span>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${list2}" var="product">
					<div class="col-md-3 d-flex">
						<div class="product ftco-animate">
							<div class="img d-flex align-items-center justify-content-center"
								style="background-image: url(${product.product_image});">
								<div class="desc">
									<p class="meta-prod d-flex">
										<a href="#"
											class="d-flex align-items-center justify-content-center"><span
											class="flaticon-shopping-bag"></span></a> <a href="#"
											class="d-flex align-items-center justify-content-center"><span
											class="flaticon-heart"></span></a> <a href="#"
											class="d-flex align-items-center justify-content-center"><span
											class="flaticon-visibility"></span></a>
									</p>
								</div>
							</div>
							<c:url var="pdetail" value="pdetail.do">
								<c:param name="product_id" value="${product.product_id }" />
							</c:url>
							<a href="${pdetail}">
								<div class="text text-center">
									<span class="sale">${product.wine_type}</span> <span
										class="category">${product.product_ename}</span>
									<h2>${product.product_name}</h2>
									<p class="mb-0">
										<span class="price price-sale"><fmt:formatNumber
												type="currency" value="${product.product_price}"></fmt:formatNumber></span>
										<span class="price"><fmt:formatNumber type="currency"
												value="${product.product_price * 0.8}"></fmt:formatNumber></span>
									</p>
								</div>
							</a>
						</div>
					</div>
				</c:forEach>

				<div class="row justify-content-center">
					<div class="col-md-4">
						<c:url var="plistView" value="/plistView.do">
						</c:url>
						<a href="${plistView}" class="btn btn-primary d-block">모든 상품
							보러 가기<span class="fa fa-long-arrow-right"></span>
						</a>
					</div>
				</div>
			</div>
	</section>



	<footer>
		<c:import url="/WEB-INF/views/common/footer.jsp" />
	</footer>

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-migrate-3.0.1.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/popper.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.easing.1.3.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.waypoints.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.stellar.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/owl.carousel.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.animateNumber.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/scrollax.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/main.js"></script>
</body>
</html>