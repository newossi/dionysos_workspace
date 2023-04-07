<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
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

.content.updatepw_page {
	display: table;
	padding: 0 20px;
	width: 100vh;
	height: 100vh;
}

.updatepw_page .updatepw_area {
	display: table-cell;
	vertical-align: middle
}

.updatepw_page .updatepw_area .txt_area .inner_box {
	padding: 20px;
	box-sizing: border-box;
	background: rgba(255, 255, 255, .8);
	border: 1px solid #ac8b68;
	text-size: 30;
}

.updatepw_page .updatepw_area .txt_area .inner_box h2.logo {
	margin: 0 auto;
	width: 200px
}

.updatepw_page .updatepw_area .txt_area .inner_box h2.logo a {
	display: block
}

.updatepw_page .updatepw_area .txt_area .inner_box h2.logo a img {
	width: 100%
}

.updatepw_page .updatepw_area .txt_area .inner_box .btn_area {
	margin-top: 30px
}

.updatepw_page .updatepw_area .txt_area .inner_box .btn_area .btn_txt.btn_black
	{
	background: #ac8b68
}

.updatepw_page .updatepw_area .txt_area .inner_box .btn_area .btn_txt {
	background: #fff
}
</style>
<script>
	$(function(){
		$("#findBtn").click(function(){
			$.ajax({
				url : "../users/find_pw.do",
				type : "POST",
				data : {
					user_id : $("#user_id").val(),
					email : $("#email").val()
				},
				success : function(result) {
					alert(result);
				},
			})
		});
	})
</script>
</head>
<body>
	<div class="content updatepw_page">
		<div class="updatepw_area">
			<div class="txt_area">
				<div class="inner_box" id="findpw_form">
					<h2 align="center">비밀번호 찾기</h2>
					<div class="btn_area col2">
						<form action="find_pw.do" method="post" class="input_row">
							<p>
								<label>아이디</label> <input type="text" name="user_id" id="user_id"
								class="pos" style="width: 250px; height: 50px;" required>
								<label>이메일</label> <input type="text" name="email" id="email"
								class="pos" style="width: 250px; height: 50px;" required>
							</p>
							<p>
								<button type="submit" id=findBtn>비밀번호 찾기</button>
								<button type="button" onclick="history.go(-1);">취소</button>
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>