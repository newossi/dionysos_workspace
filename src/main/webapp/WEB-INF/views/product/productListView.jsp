<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/animate.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/magnific-popup.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-select.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/flaticon.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/menubar.jsp" />

	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<div class="row mb-4">
						<div
							class="col-md-12 d-flex justify-content-between align-items-center">
							<h4 class="product-select">Select Types of Products</h4>
							<select class="selectpicker" multiple>
								<option>Brandy</option>
								<option>Gin</option>
								<option>Rum</option>
								<option>Tequila</option>
								<option>Vodka</option>
								<option>Whiskey</option>
							</select>
						</div>
					</div>
					<div class="row">
						<c:forEach items="${list}" var="product">
							<div class="col-md-3 d-flex">
								<div class="product ftco-animate">
									<div
										class="img d-flex align-items-center justify-content-center"
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
									<a href="${pdetail}"><div class="text text-center">
											<span class="sale">${product.wine_type}</span> <span
												class="category">${product.product_ename}</span>
											<h2>${product.product_name}</h2>
											<p class="mb-0">
												<span class="price price-sale"><fmt:formatNumber
														type="currency" value="${product.product_price}"></fmt:formatNumber></span>
												<span class="price"><fmt:formatNumber type="currency"
														value="${product.product_price * 0.8}"></fmt:formatNumber></span>
											</p>
										</div></a>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="row mt-5">
						<div class="col text-center">
							<div class="block-27">
								<c:import url="/WEB-INF/views/common/paging.jsp" />
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<div class="sidebar-box ftco-animate">
						<div class="categories">
							<h3>Product Types</h3>
							<ul class="p-0">
								<c:url var="psearchType" value="/psearch.do">
									<c:param name="wine_type" value="레드" />
								</c:url>
								<li><a href="${psearchType}">레드와인 <span
										class="fa fa-chevron-right"></span></a></li>
								<c:url var="psearchType" value="/psearch.do">
									<c:param name="wine_type" value="화이트" />
								</c:url>
								<li><a href="${psearchType}">화이트와인 <span
										class="fa fa-chevron-right"></span></a></li>
								<c:url var="psearchType" value="/psearch.do">
									<c:param name="wine_type" value="스파클링" />
								</c:url>
								<li><a href="${psearchType}">스파클링 <span
										class="fa fa-chevron-right"></span></a></li>
								<c:url var="psearchType" value="/psearch.do">
									<c:param name="wine_type" value="로제" />
								</c:url>
								<li><a href="${psearchType}">로제 <span
										class="fa fa-chevron-right"></span></a></li>
								<c:url var="psearchType" value="/psearch.do">
									<c:param name="wine_type" value="주정강화" />
								</c:url>
								<li><a href="${psearchType}">주정강화 <span
										class="fa fa-chevron-right"></span></a></li>
								<c:url var="psearchType" value="/psearch.do">
									<c:param name="wine_type" value="기타" />
								</c:url>
								<li><a href="${psearchType}">기타 <span
										class="fa fa-chevron-right"></span></a></li>
							</ul>
						</div>
					</div>


				</div>
			</div>
		</div>
	</section>



	<footer>
		<c:import url="/WEB-INF/views/common/footer.jsp" />
	</footer>








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