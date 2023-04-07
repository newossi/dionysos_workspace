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
<h2 align="center">${notice.notice_no}번 공지글 수정페이지</h2>
<br>
<!-- 
	form 태그에서 input에 입력된 값(문자열)들과 첨부파일을 같이 전송하려면
	반드시 enctype 속성을 form 태그에 추가해야 함
	enctype="multipart/form-data" 값을 지정해야 함
	이때는 method="post" 로 지정해야 함
 -->
<form action="nupdate.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="noticeno" value="${notice.notice_no}">
	<!-- 첨부파일이 있다면 수정 전 파일로 함께 전송이 필요 -->
	<c:if test="${!empty notice.notice_original_filename}">
		<input type="hidden" name="notice_original_filename" value="${notice.notice_original_filename}">
		<input type="hidden" name="notice_rename_filename" value="${notice.notice_rename_filename}">
	</c:if>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th>제 목</th>
		<td><input name="title" value="${notice.title}"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input name="user_id" value="${notice.user_id}" readonly></td>
	</tr>
	<tr>
		<th>날 짜</th><td>${notice.created_at}</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
			<!-- 첨부파일이 있는 경우 파일 삭제 기능 추가 -->
			<c:if test="${!empty notice.notice_original_filename}">
				${notice.notice_original_filename} &nbsp; 
				<input type="checkbox" name="delflag" value="yes">파일삭제
				<br>
			</c:if>
			새로 첨부 : <input type="file" name="upfile">   <!-- multiple 여러개 파일 첨부 -->
		</td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea name="content" rows="5" cols="50">${notice.content}</textarea></td>
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