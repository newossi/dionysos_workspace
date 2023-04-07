<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="qnano" value="${requestScope.qna.qna_no}" />
<c:set var="currentPage" value="${requestScope.paging.currentPage}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!-- 상대경로로 대상 파일의 위치를 지정한 경우 -->
<c:import url="../common/menubar.jsp" />
<hr>
<h2 align="center">${qna.qna_no} 번 1:1문의 수정</h2>
<br>
<!-- 원글 수정 폼 -->

<form action="qoriginup.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="qnano" value="${qna.qna_no}">
	<input type="hidden" name="page" value="${currentPage}">
	<!-- 첨부파일이 있는 게시글이라면  -->
	<c:if test="${!empty qna.qna_original_filename}">
		<input type="hidden" name="qna_original_filename" value="${qna.qna_original_filename}">
		<input type="hidden" name="qna_rename_filename" value="${qna.qna_rename_filename}">
	</c:if>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
	<tr><th>제목</th>
		<td><input type="text" name="title" value="${qna.title}"></td>
	</tr>
	<tr><th>작성자</th>
		<td><input type="text" name="user_id" value="${sessionScope.loginUsers.user_id}" readonly></td>
	</tr>
	<tr><th>문의유형</th>
		<td>
		<select name="inquiry_type">
			<option value="" disabled selected>--선택해주세요--</option>
			<option value="${qna.inquiry_type == 0}">상품문의</option>
			<option value="${qna.inquiry_type == 1}">픽업문의</option>
			<option value="${qna.inquiry_type == 2}">교환문의</option>
			<option value="${qna.inquiry_type == 3}">환불문의</option>
			<option value="${qna.inquiry_type == 4}">기타문의</option>
		</select>
		</td>
	</tr>		
	<tr><th>첨부파일</th>
		<td>
			<!-- 첨부파일이 있는 경우 파일 삭제 기능 추가 -->
			<c:if test="${!empty qna.qna_original_filename}">
				${qna.qna_original_filename} &nbsp; 
				<input type="checkbox" name="delflag" value="yes">파일삭제
				<br>
			</c:if>
			새로 첨부 : <input type="file" name="upfile">
		</td>
	</tr>
	<tr><th>내용</th>
		<td><textarea name="content" rows="5" cols="50">${qna.content}</textarea></td>
	</tr>
	<tr><th colspan="2">
		<button onclick="javascript:history.go(-1); return false;">이전 페이지로 이동</button>
		&nbsp;
		<input type="submit" value="수정하기"> &nbsp;
		<input type="reset" value="수정취소">
	</th></tr>
</table>
</form>

<br>
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>