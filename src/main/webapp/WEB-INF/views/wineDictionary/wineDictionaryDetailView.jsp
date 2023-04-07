<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>wineDictionary</title>


</head>
<body>

<c:import url="/WEB-INF/views/common/menubar.jsp" />
<hr>
<br>
    <h2 align="center">${ wineDictionary.grape_type } 상세정보</h2>
	<br>
	<hr>
    <center>
	<!-- 목록 출력 영역 -->
	<table>
		<tr>
			<th>포도품종 &nbsp; &nbsp; &nbsp; &nbsp; </th>
			<th>당도</th>
			<th>바디</th>
			<th>산도</th>
			<th>타닌</th>
		</tr>
			<tr>
				<td>${wineDictionary.grape_type}&nbsp; &nbsp; &nbsp; &nbsp; </td>
				<td><img src="resources/images/graph_${ wineDictionary.sweetness }.png"></td>
				<td><img src="resources/images/graph_${ wineDictionary.body }.png"></td>
				<td><img src="resources/images/graph_${ wineDictionary.acidity }.png"></td>
				<td><img src="resources/images/graph_${ wineDictionary.tannin }.png"></td>
				<th>&nbsp; &nbsp; &nbsp; &nbsp; 상세정보 &nbsp; &nbsp; &nbsp; &nbsp; </th><td>${ wineDictionary.wine_dictionary }</td>
			</tr>
	</table>
	</center>
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>