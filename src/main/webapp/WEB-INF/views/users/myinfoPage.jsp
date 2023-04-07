<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.content.myinfo_page {
	display: table;
	padding: 0 20px;
	width: 100vh;
	height: 100vh;
}

.myinfo_page .myinfo_area {
	display: table-cell;
	vertical-align: middle
}

.myinfo_page .myinfo_area .txt_area .inner_box {
	padding: 20px;
	box-sizing: border-box;
	background: rgba(255, 255, 255, .8);
	border: 1px solid #ac8b68;
	text-size: 30;
}

.myinfo_page .myinfo_area .txt_area .inner_box h2.logo {
	margin: 0 auto;
	width: 200px
}

.myinfo_page .myinfo_area .txt_area .inner_box h2.logo a {
	display: block
}

.myinfo_page .myinfo_area .txt_area .inner_box h2.logo a img {
	width: 100%
}

.myinfo_page .myinfo_area .txt_area .inner_box .btn_area {
	margin-top: 30px
}

.myinfo_page .myinfo_area .txt_area .inner_box .btn_area .btn_txt.btn_black
	{
	background: #ac8b68
}

.myinfo_page .myinfo_area .txt_area .inner_box .btn_area .btn_txt {
	background: #fff
}
</style>
</head>
<body>
	<div class="content myinfo_page">
		<div class="myinfo_area">
			<div class="txt_area">
				<div class="inner_box" id="myinfoForm">
					<h2 align="center">
						마이 페이지
					</h2>
					<div class="btn_area col2">
						<form method="post" class="input_row">
							<input type="text" name="name" class="pos" placeholder="${ users.name }" style="width: 250px; height: 50px;" readonly><br>
							<input type="password" name="password" class="pos" placeholder="${ users.user_id }" style="width: 250px; height: 50px;" readonly> <br>
							<input type="date" name="birthday" class="pos" placeholder="${ users.birthday }" style="width: 250px; height: 50px;" readonly><br>
							<input type="text" name="phone" class="pos" placeholder="${users.phone }" style="width: 250px; height: 50px;" readonly><br>
							<input type="text" name="email" class="pos" placeholder="${ users.email }" style="width: 250px; height: 50px;" readonly><br>
							
							
						</form>
						<c:url var="moveup" value="/moveup.do">
							<c:param name="user_id" value="${ users.user_id }" />
						</c:url>
						<a href="${ moveup }" class="find_text">수정페이지로 이동</a> 
						<c:url var="mdel" value="/mdel.do">
							<c:param name="user_id" value="${ users.user_id }" />
						</c:url>
						<a href="${ mdel }" class="find_text">탈퇴하기</a>
						<a href="main.do" class="find_text">시작페이지로 이동</a>
					</div>

				</div>
			</div>
		</div>
	</div>
	

	<div class="mypage_container">
		<div class="mypage_contents">
			<ul class="mypage_category" style="height: 94px">
				<li class="menu1"><a href="#"><span class="name">구매내역</span></a></li>
				<li class="menu2"><a href="/user/buyInfo/claim"><span
						class="name">취소·환불·교환</span></a></li>
				<li class="menu7"><a href="/user/qna/talklist?type=talk"><span
						class="name">상품문의</span></a></li>
				<li class="menu8 last"><a href="/user/info"><span
						class="name">개인정보</span></a></li>
			</ul>
		</div>
	</div>
</body>
</html>