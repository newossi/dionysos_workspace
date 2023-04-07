<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h2 align="center">${faq.noticeno}번 공지글 수정페이지</h2>
<br>
<!-- 
	form 태그에서 input에 입력된 값(문자열)들과 첨부파일을 같이 전송하려면
	반드시 enctype 속성을 form 태그에 추가해야 함
	enctype="multipart/form-data" 값을 지정해야 함
	이때는 method="post" 로 지정해야 함
 -->
<form action="fupdate.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="faqno" value="${faq.faq_no}">
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th>작성자</th>
		<td><input name="user_id" value="${sessionScope.faq.user_id}" readonly></td>
	</tr>
	<tr>
		<th>날 짜</th><td>${faq.registration_date}</td>
	</tr>
	<tr>
		<th>질 문</th>
		<td><input type="text" name="question" value="${sessionScope.faq.question}"></td>
	</tr>
	<tr>
		<th>답 변</th>
		<td><textarea name="answer" rows="5" cols="50">${sessionScope.faq.answer}</textarea></td>
	</tr>
	<tr>
		<th colspan="2">
			<button onclick="javascript:history.go(-1); return false;">이전 페이지로 이동</button>
			&nbsp;
			<input type="submit" value="수정하기"> &nbsp;
			<input type="reset" value="수정취소">			
		</th>
	</tr>
</table>
</form>

<hr>
<br>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>