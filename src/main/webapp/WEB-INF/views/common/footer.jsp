<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- 관리자 아닌 경우 -->
	<c:if test="${empty loginMember}">

		<footer class="ftco-footer">


			<div class="container-fluid px-0 py-5 bg-black">
				<div class="container">
					<div class="row">


						<div class="col-md-12">
							<p class="mb-0" style="color: rgba(255, 255, 255, .5);">
								<img
									src="${ pageContext.servletContext.contextPath }/resources/images/다운로드.png">
								<br> &nbsp; <a href="#">&nbsp;&nbsp;이용약관</a>&nbsp;|&nbsp;
								&nbsp; <a href="#">개인정보처리방침</a>&nbsp;|&nbsp; &nbsp; <a href="#">찾아오시는
									길</a><br> &nbsp; 고객센터 : 1234-567(평일 09:00~18:00, 점심시간
								13:00~14:00 주말/공휴일 휴무) <br>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								&nbsp; Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								All rights reserved | This template is made with <i
									class="fa fa-heart color-danger" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib.com</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
	
						</div>
					</div>
				</div>
			</div>
		</footer>
	</c:if>
	<c:if test="${!empty loginMember and loginMember.admin ne 'Y'}">

		<footer class="ftco-footer">


			<div class="container-fluid px-0 py-5 bg-black">
				<div class="container">
					<div class="row">


						<div class="col-md-12">
							<p class="mb-0" style="color: rgba(255, 255, 255, .5);">
								<img
									src="${ pageContext.servletContext.contextPath }/resources/images/다운로드.png">
								<br> &nbsp; <a href="#">&nbsp;&nbsp;이용약관</a>&nbsp;|&nbsp;
								&nbsp; <a href="#">개인정보처리방침</a>&nbsp;|&nbsp; &nbsp; <a href="#">찾아오시는
									길</a><br> &nbsp; 고객센터 : 1234-567(평일 09:00~18:00, 점심시간
								13:00~14:00 주말/공휴일 휴무) <br>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								&nbsp; Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								All rights reserved | This template is made with <i
									class="fa fa-heart color-danger" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib.com</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
						
						</div>
					</div>
				</div>
			</div>
		</footer>
	</c:if>
	<!-- 관리자용 -->
	<c:if test="${!empty loginMember and loginMember.admin ne 'Y'}">

		<footer>
			<div class="footer-copyright-area">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12">
							<div class="footer-copy-right">
								<p>
									Copyright © 2018 <a href="https://colorlib.com/wp/templates/">Colorlib</a>
									All rights reserved.
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</c:if>
</body>
</html>