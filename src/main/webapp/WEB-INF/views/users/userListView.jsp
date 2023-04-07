<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
form.sform {
	display: none; /* 안 보이게 설정 */
	background: lightgray;
}
</style>
<script type="text/javascript"
	src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('input[name=item]').on('change', function() {
			//change 이벤트가 발생한 radio 와 연결된 폼만
			//보여지게 하고, 나머지 폼들은 안보이게 처리함
			$('input[name=item]').each(function(index) {
				//해당 index번째 radio 가 checked 인지 확인하고
				if ($(this).is(':checked')) {
					$('form.sform').eq(index).css('display', 'block');
				} else {
					$('form.sform').eq(index).css('display', 'none');
				}
			}); //each
		}); //on

	}); //document.ready
</script>
</head>
<body>
	<c:import url="/WEB-INF/views/common/menubar.jsp" />
	<hr>
	<h3 align="center">회원 관리 페이지</h3>
	<h2 align="center">현재 회원수 : ${ requestScope.list.size() } 명</h2>
	<center>
		<button
			onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/mlist.do';">전체
			보기</button>
		<br> <br>
		<!-- 항목별 검색 기능 추가 -->
		<fieldset id="ss">
			<legend>검색할 항목을 선택하세요.</legend>
			<input type="radio" name="item" id="uid"> 회원아이디 &nbsp; <input
				type="radio" name="item" id="uemail"> 이메일 &nbsp; <input
				type="radio" name="item" id="ubirth"> 연령대 &nbsp;

		</fieldset>
		<!-- 검색 항목 제공 끝 -->
		<br>
		<!-- 회원아이디로 검색 폼 -->
		<form action="${ pageContext.servletContext.contextPath }/msearch.do"
			method="post" id="idform" class="sform">
			<input type="hidden" name="action" value="id"> <input
				type="search" name="keyword"> &nbsp; <input type="submit"
				value="검색">
		</form>

		<!-- 이메일로 검색 폼 -->
		<form action="${ pageContext.servletContext.contextPath }/msearch.do"
			method="post" id="emailform" class="sform">
			<input type="hidden" name="action" value="email"> <input
				type="search" name="keyword"> &nbsp; <input type="submit"
				value="검색">
		</form>


		<!-- 생년월일로 검색 폼 -->
		<form action="${ pageContext.servletContext.contextPath }/msearch.do"
			method="post" id="birthdayform" class="sform">
			<input type="hidden" name="action" value="birth"> <input
				type="date" name="begin"> ~ <input type="date" name="end">
			&nbsp; <input type="submit" value="검색">
		</form>



	</center>
	<br>
	<br>
	<!-- 조회해 온 회원 리스트 출력 처리 -->
	<table align="center" border="1" cellspacing="0" cellpadding="3">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>생년월일</th>
			<th>회원관리</th>
		</tr>
		<c:forEach items="${ list }" var="m">
			<tr>
				<td>${ m.user_id }</td>
				<td>${ m.name }</td>
				<td>${ m.phone }</td>
				<td>${ m.email }</td>
				<td><fmt:formatDate value="${ m.birthday }" type="date"
						dateStyle="medium" /></td>
				<td>
				<c:url var="eviction" value="/eviction.do">
					<c:param name="user_id" value="${ m.user_id }" />
				</c:url>
				<a href="${eviction}" >탈퇴</a>
				</td>
			</tr>
		</c:forEach>
	</table>
<script type="text/javascript">
	function fnChange(pageUrl){
		
	}
</script>
	<hr>
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>







