<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp" />
<hr>
<br>

<h3><a href="${ pageContext.servletContext.contextPath }/moveRouletteGame.do">룰렛 게임</a></h3>


<h3><a href="${ pageContext.servletContext.contextPath }/moveDrawGame.do">뽑기 게임</a></h3>


<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>