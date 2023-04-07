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
<h2 align="center">${requestScope.qna.qna_no} 번 게시글 상세보기</h2>
<br>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
	<tr><th>제목</th><td>${qna.title}</td></tr>
	<tr><th>작성자</th><td>${qna.user_id}</td></tr>
	<tr><th>날짜</th>
		<td><fmt:formatDate value="${qna.created_at}" type="date" pattern="yyyy-MM-dd"/></td>
	</tr>
	<tr><th>문의유형</th>
		<td>
				<c:if test="${qna.inquiry_type == 0}">상품문의</c:if>
				<c:if test="${qna.inquiry_type == 1}">픽업문의</c:if>
				<c:if test="${qna.inquiry_type == 2}">교환문의</c:if>
				<c:if test="${qna.inquiry_type == 3}">환불문의</c:if>
				<c:if test="${qna.inquiry_type == 4}">기타문의</c:if>
			</td>
	</tr>
	<tr><th>첨부파일</th>
		<td>
			<!-- 첨부파일이 있다면 파일명 클릭시 다운로드 실행 처리 -->
			<c:if test="${!empty qna.qna_original_filename}">
				<c:url var="qfd" value="qfdown.do">
					<c:param name="ofile" value="${qna.qna_original_filename}" />
					<c:param name="rfile" value="${qna.qna_rename_filename}" />
				</c:url>
				<a href="${qfd}">${qna.qna_original_filename}</a>
			</c:if>
			<!-- 첨부파일이 없다면 공백 처리 -->
			<c:if test="${empty qna.qna_original_filename}">
				&nbsp;
			</c:if>
		</td>
	</tr>
	<tr><th>내용</th><td>${qna.content}</td></tr>
	<tr><th colspan="2">
		<button onclick="javascript:location.href='qalist.do?page=${currentPage}';">목록</button>
		&nbsp;
		<!-- 관리자일 경우 댓글달기 버튼 -->
		<c:if test="${sessionScope.loginUsers.admin eq 'Y'}">
			<c:url var="qrf" value="/qreplyform.do">
				<c:param name="qnano" value="${qna.qna_no}" />
				<c:param name="page" value="${currentPage}" />
			</c:url>
			<a href="${qrf}">[댓글달기]</a> &nbsp;
		</c:if>
		<!-- 관리자일 경우 수정과 삭제 기능 제공 -->
		
		<!-- 본인이 등록한 게시글일 때는 수정과 삭제 기능 제공 -->
			<c:url var="qup" value="/qupview.do">
				<c:param name="qnano" value="${qna.qna_no}" />
				<c:param name="page" value="${currentPage}" />
			</c:url>
			<a href="${qup}">[수정페이지로 이동]</a> &nbsp;
			
			<c:url var="qdel" value="/qdel.do">
				<c:param name="qnano" value="${qna.qna_no}" />
				<c:param name="qna_lev" value="${qna.qna_lev}" />
				<c:param name="qna_rename_filename" value="${qna.qna_rename_filename}" />
			</c:url>
			<a href="${qdel}">[글삭제]</a> &nbsp;

	</th></tr>
</table>
<br>
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>





