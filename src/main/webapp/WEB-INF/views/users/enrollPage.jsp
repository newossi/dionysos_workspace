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

.move_text {
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
	width: 125px;
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

.content.enroll_page {
	display: table;
	padding: 0 20px;
	width: 100vh;
	height: 100vh;
	background: url(resources/images/bg_6.jpg) center no-repeat;
	background-size: 100% 100%;
}

.enroll_page .enroll_area {
	display: table-cell;
	vertical-align: middle
}

.enroll_page .enroll_area .txt_area .inner_box {
	padding: 20px;
	box-sizing: border-box;
	background: rgba(255, 255, 255, .8);
	border: 1px solid #ac8b68;
	text-size: 30;
}

.enroll_page .enroll_area .txt_area .inner_box h2.logo {
	margin: 0 auto;
	width: 200px
}

.enroll_page .enroll_area .txt_area .inner_box h2.logo a {
	display: block
}

.enroll_page .enroll_area .txt_area .inner_box h2.logo a img {
	width: 100%
}

.enroll_page .enroll_area .txt_area .inner_box .btn_area {
	margin-top: 30px
}

.enroll_page .enroll_area .txt_area .inner_box .btn_area .btn_txt.btn_black
	{
	background: #ac8b68
}

.enroll_page .enroll_area .txt_area .inner_box .btn_area .btn_txt {
	background: #fff
}
</style>
<script type="text/javascript"
	src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
	function validate() {
		//암호와 암호 확인이 일치하는지 체크
		var pwd1 = document.getElementById("upwd1").value;
		var pwd2 = $('#upwd2').val();

		if (pwd1 !== pwd2) {
			alert("암호와 암호 확인이 일치하지 않습니다.\n" + "다시 입력하세요.");
			document.getElementById("upwd1").select();
			return false; //전송 안 함
		}

		return true; //전송함
	}

	//아이디 중복을 확인
	function dupCheckId() {
		$.ajax({
			url : "idchk.do",
			type : "post",
			data : {
				user_id : $('#user_id').val()
			},
			success : function(data) {
				console.log("success : " + data);
				if (data == 'ok') {
					alert("사용 가능한 아이디입니다.");
					$('#upwd1').focus();
				} else {
					alert("이미 사용중인 아이디입니다.\n다시 입력하세요.");
					$('#user_id').select();
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("error : " + jqXHR + ", " + textStatus + ", "
						+ errorThrown);
			}
		});

		return false;
	}
</script>
</head>
<body>
	<form action="enroll.do" method="post" onsubmit="return validate();">

		<div class="content enroll_page">
			<div class="enroll_area">
				<div class="txt_area">
					<div class="inner_box" id="loginForm">
						<h2 class="logo">
							<a href="#"><img src="resources/images/logo.png"></a>
						</h2>
						<div class="btn_area col2">
							<input type="text" name="name" placeholder="이름" title="이름"
								style="width: 250px; height: 50px;" required> <br>
							<input type="text" name="user_id" id="user_id" placeholder="아이디"
								title="아이디" style="width: 250px; height: 50px;" required>
							&nbsp; &nbsp; <input type="button" value="중복확인"
								onclick="return dupCheckId();"> <br> <input
								type="password" name="password" id="upwd1" placeholder="패스워드"
								title="패스워드" style="width: 250px; height: 50px;" required>
							<br> <input type="password" id="upwd2" placeholder="패스워드"
								title="패스워드 확인" style="width: 250px; height: 50px;" required>
							<br> <input type="date" name="birthday" value="2018-07-22"
								placeholder="나이" title="나이" style="width: 250px; height: 50px;"
								min="1918-01-01" max="2020-12-31"><br> <input
								type="tel" name="phone" placeholder="전화번호" title="전화번호"
								style="width: 250px; height: 50px;"> <br> <input
								type="email" name="email" placeholder="이메일" title="이메일"
								style="width: 250px; height: 50px;" required> <br>
							<input type="submit" value="가입하기" class="btn_txt btn_black">
							&nbsp; <input type="reset" value="작성취소" class="btn_txt btn_black">
							<br> <a href="main.do" class="move_text">시작페이지로 이동</a>
						</div>

					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>