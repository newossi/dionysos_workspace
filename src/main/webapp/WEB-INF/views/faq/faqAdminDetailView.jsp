<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<!-- 절대경로로 대상 파일의 위치를 지정한 경우  -->
<c:import url="/WEB-INF/views/common/menubar.jsp" />
<hr>
<h2 align="center">${requestScope.faq.faq_no} 번 공지글 상세보기 (관리자용)</h2>
<br>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th>작성자</th><td>${faq.user_id}</td>
	</tr>
	<tr>
		<th>날 짜</th><td>${faq.registration_date}</td>
	</tr>
	<tr>
		<th>질 문</th><td>${faq.question}</td>
	</tr>
	<tr>
		<th>답 변</th><td>${faq.answer}</td>
	</tr>
	<tr>
		<th colspan="2">
			<button onclick="javascript:history.go(-1);">목록</button>
			<!-- 수정 페이지로 이동 버튼 -->
			<c:url var="moveup" value="/fupview.do">
				<c:param name="faqno" value="${faq.faq_no}" />
			</c:url>
			<button onclick="javascript:location.href='${moveup}';">수정페이지로 이동</button>
			<!-- 삭제하기 버튼 -->
			<c:url var="fdel" value="/fdel.do">
				<c:param name="faqno" value="${faq.faq_no}" />
			</c:url>
			<button onclick="javascript:location.href='${fdel}';">공지글 삭제</button>
		</th>
	</tr>
</table>
<hr>
<br>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>