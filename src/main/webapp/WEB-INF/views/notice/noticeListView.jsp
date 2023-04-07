<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
			$('#dateDiv').css('display', 'none');
		}
		if($('input[name=item]').eq(1).is(':checked')){
			$('#titleDiv').css('display', 'none');
			$('#dateDiv').css('display', 'block');
		}
	}
	
</script>

</head>
<body>
<!-- 상대경로로 대상 파일의 위치를 지정한 경우 -->
<c:import url="../common/menubar.jsp" />
<!-- jstl 에서 절대경로 표기 : "/WEB-INF/views/common/menubar.jsp -->
<hr>
<h1 align="center">공지사항</h1>
<!-- 관리자만 공지글 등록할 수 있도록 처리 
	=> 관리자가 로그인하면 '공지글 등록' 버튼이 보이게 함 -->
<center>
<div>
	<c:if test="${sessionScope.loginUsers.admin eq 'Y'}">
		<button onclick="javascript:location.href='nwform.do';">새 공지글 등록</button>
	</c:if>
</center>
<br>
<!-- 검색 항목 영역 -->
<center>
	<h2>검색할 항목을 선택하세요.</h2>
	<input type="radio" name="item" value="title" checked> 제목
	&nbsp; &nbsp;
	<input type="radio" name="item" value="date"> 날짜
</div>
<div id="titleDiv">
	<form action="nsearchTitle.do" method="post">
		<input type="search" name="title" placeholder="검색어를 입력하세요.">&nbsp;
		<input type="submit" value="검색">
	</form>
</div>
<div id="dateDiv">
	<form action="nsearchDate.do" method="post">
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
<h3 align="center">총 게시글 수 : ${listCount} 개</h3>
	<button onclick="javascript:location.href='${pageContext.servletContext.contextPath}/nplist.do';">
	목록</button>
</center>
<br>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${requestScope.list}" var="n">
		<tr align="center">
			<td align="center">${n.notice_no}</td>
			<!-- 공지 제목 클릭시 해당 공지의 상세보기로 넘어가게 함 -->
			<c:url var="ndt" value="/ndetail.do">
				<c:param name="noticeno" value="${n.notice_no}" />
			</c:url>
			<td align="center"><a href="${ndt}">${n.title}</a></td>
			<td>${n.user_id}</td>
			<td align="center">
				<fmt:formatDate value="${n.created_at}" pattern="yyyy-MM-dd" />
			</td>
			<td align="center">
				${n.read_count}
			</td>
		</tr>
	</c:forEach>
</table>
<!-- 페이징 처리 -->
<c:import url="/WEB-INF/views/common/paging.jsp" />
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp"></c:import>
</body>
</html>




