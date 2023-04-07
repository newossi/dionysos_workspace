<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="listCount" value="${requestScope.paging.listCount}" />
<c:set var="currentPage" value="${ requestScope.paging.currentPage }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script>
	$(function(){
		showDiv();
		
		$('input[name=item]').on('change', function(){
			showDiv();
		});
		
	});  //document.ready
	
	function showDiv(){
		if($('input[name=item]').eq(0).is(':checked')){
			$('#titleDiv').css('display', 'block');
			$('#writerDiv').css('display', 'none');
			$('#dateDiv').css('display', 'none');
		}
		if($('input[name=item]').eq(1).is(':checked')){
			$('#titleDiv').css('display', 'none');
			$('#writerDiv').css('display', 'block');
			$('#dateDiv').css('display', 'none');
		}
		if($('input[name=item]').eq(2).is(':checked')){
			$('#titleDiv').css('display', 'none');
			$('#writerDiv').css('display', 'none');
			$('#dateDiv').css('display', 'block');
		}
	}
	
	function showWriteForm(){
		//게시 원글 쓰기 페이지로 이동 처리
		location.href = "${pageContext.servletContext.contextPath}/qwform.do";
	}
	
</script>
</head>
<body>
<!-- 상대경로로 대상 파일의 위치를 지정한 경우 -->
<c:import url="../common/menubar.jsp" />
<hr>
<h1 align="center">1:1문의</h1>
<!-- 로그인한 회원만 게시글 등록(글쓰기) 버튼이 보이게 함 -->
<center>
	<c:if test="${!empty sessionScope.loginUsers}">
		<button onclick="showWriteForm();">글쓰기</button>
	</c:if>
</center>
<!-- 검색 항목 영역 -->
<center>
	<h2>검색할 항목을 선택하세요.</h2>
	<input type="radio" name="item" value="title" checked> 제목
	&nbsp; &nbsp;
	<input type="radio" name="item" value="user_id"> 작성자
	&nbsp; &nbsp;
	<input type="radio" name="item" value="date"> 날짜
</div>
<div id="titleDiv">
	<form action="qsearchTitle.do" method="post">
		<input type="search" name="title" placeholder="검색어를 입력하세요.">
		<input type="submit" value="검색">
	</form>
</div>
<div id="writerDiv">
	<form action="qsearchId.do" method="post">
		<input type="search" name="user_id" placeholder="검색어를 입력하세요.">
		<input type="submit" value="검색">
	</form>
</div>
<div id="dateDiv">
	<form action="qsearchDate.do" method="post">
		<label>검색할 등록날짜를 입력하세요 : 
			<input type="date" name="begin"> ~ 
			<input type="date" name="end">
		</label>
		<input type="submit" value="검색">
	</form>
</div>
</center>
<br>

<!-- 목록 출력 영역 -->
<center>
<h4 align="center">총 게시글 수 : ${listCount} 개</h4>
	<button onclick="javascript:location.href='${pageContext.servletContext.contextPath}/qlist.do?page=${currentPage}';">
	목록</button>
</center>
<br>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>문의상태</th>
		<th>날짜</th>
	</tr>
	<c:forEach items="${requestScope.list}" var="q">
		<tr align="center">
			<td>${q.qna_no}</td>
			<!-- 게시글 제목 클릭시 해당 게시글의 상세보기로 넘어가게 함 -->
			<c:url var="qdt" value="/qdetail.do">
				<c:param name="qnano" value="${q.qna_no}" />
				<c:param name="page" value="${currentPage}" />
			</c:url>
			<td align="left">
				<!-- 제목 글자 앞에 댓글과 대댓글 표시 기호 붙임, 들여쓰기 처리 : 원글과 구분지음 -->
				<c:if test="${q.qna_lev eq 2}">&nbsp; &nbsp; ▶ </c:if>
				<!-- 내 문의글만 상세보기 가능 -->
				<c:if test="${q.user_id eq sessionScope.loginUsers.user_id}">
					<a href="${qdt}">${q.title}</a>
				</c:if>
				<!-- 비회원 또는 내 글이 아니면 제목만 볼 수 있음 -->
				<c:if test="${q.user_id ne sessionScope.loginUsers.user_id || empty sessionScope.loginUsers}">
					${q.title}
				</c:if>
			</td>
			<td>${q.user_id}</td>
			<td>
				<c:if test="${q.inquiry_state == 0}">처리 중</c:if>
				<c:if test="${q.inquiry_state == 1}">처리 완료</c:if>
			</td>
			<td>
				<fmt:formatDate value="${q.created_at}" pattern="yyyy-MM-dd" />
			</td>
		</tr>
	</c:forEach>
</table>
<br>

<br>
<!-- 페이징 처리 -->
<c:import url="/WEB-INF/views/common/paging.jsp" />
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>





