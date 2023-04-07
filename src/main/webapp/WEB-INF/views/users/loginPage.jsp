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

.input_row {
	position: relative;
	display: block;
	height: 100%;
	padding: 16px 18px 15px;
	border-radius: 6px;
	box-sizing: border-box;
	text-align: center;
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

.find_text {
	display: inline-block;
	text-decoration: none;
	color: #888
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

.content.login_page {
	display: table;
	padding: 0 20px;
	width: 100vh;
	height: 100vh;
	background: url(resources/images/bg_6.jpg) center no-repeat;
	background-size: 100% 100%;
}

.login_page .login_area {
	display: table-cell;
	vertical-align: middle
}

.login_page .login_area .txt_area .inner_box {
	padding: 20px;
	box-sizing: border-box;
	background: rgba(255, 255, 255, .8);
	border: 1px solid #ac8b68;
	text-size: 30;
}

.login_page .login_area .txt_area .inner_box h2.logo {
	margin: 0 auto;
	width: 200px
}

.login_page .login_area .txt_area .inner_box h2.logo a {
	display: block
}

.login_page .login_area .txt_area .inner_box h2.logo a img {
	width: 100%
}

.login_page .login_area .txt_area .inner_box .btn_area {
	margin-top: 30px
}

.login_page .login_area .txt_area .inner_box .btn_area .btn_txt.btn_black
	{
	background: #ac8b68
}

.login_page .login_area .txt_area .inner_box .btn_area .btn_txt {
	background: #fff
}
</style>
</head>
<body>
	<div class="content login_page">
		<div class="login_area">
			<div class="txt_area">
				<div class="inner_box" id="loginForm">
					<h2 class="logo">
						<a href="#"><img src="resources/images/logo.jpg"></a>
					</h2>
					<div class="btn_area col2">
						<form action="login.do" method="post" class="input_row">
							<input type="text" name="user_id" id="user_id" class="pos" placeholder="아이디"
								title="아이디" style="width: 250px; height: 50px;"><br>
							<input type="password" name="password" class="pos"
								placeholder="비밀번호" title="비밀번호"
								style="width: 250px; height: 50px;"> <br> <input
								type="submit" value="로그인" class="btn_txt btn_black">
						</form>
						<a href="${pageContext.servletContext.contextPath}/findpw_form.do" class="find_text">비밀번호 찾기</a> 
						<a href="${pageContext.servletContext.contextPath}/findid_form.do" class="find_text">아이디 찾기</a> 
						<a href="${pageContext.servletContext.contextPath}/enrollPage.do" class="find_text">회원가입</a>
					</div>

				</div>
			</div>
		</div>
	</div>

	<hr>

</body>
</html>