<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>wineDictionary</title>
<script type="text/javascript"
	src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>

</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp" />
<hr>
<br>
	<h1 align="center">와인사전</h1>
	<br>
	<hr>
    <center>

    <form action="wdsearchTitle.do" method="post">
         <label>검색할 포도품종을 입력하세요 :
              <input type="search" name="keyword">
         </label>
         <input type="submit" value="검색">
    </form>
	<hr>
	<!-- 목록 출력 영역 -->
	<table>
		<tr align="center">
			<th>포도품종</th>
			<th>당도</th>
			<th>바디</th>
			<th>산도</th>
			<th>타닌</th>
		</tr>
		<c:forEach items="${ requestScope.list }" var="wdt">
			<tr align="center">
				<c:url var="wddt" value="/wddetail.do">
                   <c:param name="wine" value="${wdt.grape_type}"></c:param>
               </c:url>
               <td><a href="${ wddt }">${wdt.grape_type}</a></td>
				<td><img src="resources/images/graph_${ wdt.sweetness }.png" width="80" height="80"></td>
				<td><img src="resources/images/graph_${ wdt.body }.png" width="80" height="80"></td>
				<td><img src="resources/images/graph_${ wdt.acidity }.png" width="80" height="80"></td>
				<td><img src="resources/images/graph_${ wdt.tannin }.png" width="80" height="80"></td>
			</tr>
		</c:forEach>
	</table>
	</center>
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>