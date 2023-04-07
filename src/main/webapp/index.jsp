<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
.pc_hidden {
	display: block !important
}

.btn_txt {
	display: block;
	width: 100%;
	height: 50px;
	line-height: 50px;
	border: 1px solid #ac8b68;
	border-radius: 4px;
	color: #ac8b68
}

.btn_txt.btn_black {
	background: #ac8b68;
	border: 1px solid #ac8b68;
	color: #fff
}

.btn_area {
	text-align: center
}

.btn_area.col2::after, .btn_area.col3::after {
	content: "";
	display: block;
	clear: both
}

.btn_area.col2 .btn_txt {
	float: left;
	width: 49%;
	margin-right: 2%
}

.btn_area.col3 .btn_txt {
	float: left;
	width: 32%;
	margin-right: 2%
}

.btn_area.col2 .btn_txt:last-child, .btn_area.col3 .btn_txt:last-child {
	margin-right: 0
}

.btn_txt:disabled {
	background: #999 !important;
	border: 1px solid #999 !important;
	cursor: default
}

.h0 {
	font-size: 32px;
	font-weight: 500
}

.h1 {
	font-size: 24px;
	font-weight: 500
}

.h2 {
	font-size: 20px;
	font-weight: 500
}

.content {
	padding: 40px 20px
}

.pc_hidden {
	display: none !important
}

.btn_txt {
	display: inline-block;
	width: 180px
}

.btn_area.col2 .btn_txt, .btn_area.col3 .btn_txt {
	float: none;
	width: 260px;
	margin-right: 7px
}

.content {
	max-width: 1200px;
	margin: 0 auto;
	padding: 65px 60px 60px
}

.btn_txt {
	text-align: center
}

.content.intro_page {
	display: table;
	padding: 0 20px;
	width: 100%;
	height: 100vh;
	background: url(resources/images/bg_6.jpg) center no-repeat;
	background-size: 100% 100%
}

.intro_page .intro_area {
	display: table-cell;
	vertical-align: middle
}

.intro_page .intro_area .txt_area .inner_box {
	padding: 20px;
	box-sizing: border-box;
	background: rgba(255, 255, 255, .8);
	border: 1px solid #ac8b68
}

.intro_page .intro_area .txt_area .inner_box h2.logo {
	margin: 0 auto;
	width: 200px
}

.intro_page .intro_area .txt_area .inner_box h2.logo a {
	display: block
}

.intro_page .intro_area .txt_area .inner_box h2.logo a img {
	width: 100%
}

.intro_page .intro_area .txt_area .inner_box .txt {
	margin-top: 20px;
	color: #000;
	font-size: 24px;
	font-weight: 500;
	line-height: 34px;
	text-align: center
}

.intro_page .intro_area .txt_area .inner_box .btn_area {
	margin-top: 30px
}

.intro_page .intro_area .txt_area .inner_box .btn_area .btn_txt.btn_black
	{
	background: #ac8b68
}

.intro_page .intro_area .txt_area .inner_box .btn_area .btn_txt {
	background: #fff
}

.intro_page .intro_area .txt_area .inner_box .sub_area {
	text-align: center
}

.intro_page .intro_area .txt_area .inner_box .sub_area .sub_txt {
	display: inline-block;
	padding-left: 22px;
	margin-top: 20px;
	text-align: center;
	color: #000;
	font-size: 14px;
	line-height: 20px;
	/* background: url(../../images/shop/default/ico_nineteen.png) 0 center
		no-repeat; */
	background-size: 20px
}
</style>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.6.3.min.js">
	
</script>
<script>
	/**
	 * 성인 인증 세션
	 */
	function setAdult() {

		//Csrf.Set(_CSRF_NAME_); //토큰 초기화
		$.ajax({
			type : "POST",
			url : "main.do",
			data : {},
			success : function(res) {
				location.href = 'main.do';
			},
			error : function(res) {
				console.log(res.responseText);
			}
		});

	}
</script>
</head>
<body>
	<div class="content intro_page">
		<div class="intro_area">
			<div class="txt_area">
				<div class="inner_box">
					<h2 class="logo">
						<a href="#"><img src="resources/images/logo.png"></a>
					</h2>
					<p class="txt">
						만 19세 이상 <br class="pc_hidden">음주 가능한 연령입니까 ?
					</p>
					<div class="btn_area col2">
						<a href="javascript:setAdult();" class="btn_txt btn_black">예</a>
						<button type="button" onclick="alert('19세 미만은 이용하실 수 없습니다.')"
							class="btn_txt">아니오</button>
					</div>
					<div class="sub_area">
						<p class="sub_txt">이 사이트는 만 19세 이상만 입장 가능합니다.</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- <h1>spring first project</h1>  -->
	<!-- 첫페이지 접속 요청이 오면, 실제 보여질 메인 페이지를 포워딩함 -->
	<%-- <%
	RequestDispatcher view = request.getRequestDispatcher("main.do");
	view.forward(request, response);
%> --%>
	<%-- <jsp:forward page="main.do" /> --%>
</body>
</html>