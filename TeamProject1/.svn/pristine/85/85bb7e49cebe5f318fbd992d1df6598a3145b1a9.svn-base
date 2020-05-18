<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>

<link rel="stylesheet" href="/TeamProject/css/login.css" />
<script src="/TeamProject/script/jquery-3.5.0.min.js"></script>
<script src="/TeamProject/script/login.js"></script>
</head>

<body>
	<div id="login_box">
		<form method="post" action="/TeamProject/member/login">
		<input type="text" name="type" value="login" style="display: none">
			<h2>로그인</h2>
			<ul id="login_info">
				<li><label for="user_id">아이디</label><br/> <input type="text" name="user_id"
					id="user_id"></li>
				<li><label for="user_pass">비밀번호</label><br /> <input name="user_pass"
					type="password" id="user_pass"></li>
			</ul>
			<ul class="login_buttons">
				<li><button name="login_check">로그인</button></li>
			</ul>
		</form>

		<form method="post" action="/TeamProject/member/login">
			<input type="text" name="type" value="register" style="display: none">
			<ul class="login_buttons">
				<li><button name="login_register">회원가입</button></li>
			</ul>
		</form>

		<form method="post" action="/TeamProject/member/login">	
			<input type="text" name="type" value="searchLogin" style="display: none">
			<ul class="login_buttons">
				<li><button name="login_find_id">아이디 찾기</button></li>
			</ul>
		</form>

		<form method="post" action="/TeamProject/member/login">
			<input type="text" name="type" value="searchPass" style="display: none">
			<ul class="login_buttons">
				<li><button name="login_find_pass">비밀번호 찾기</button></li>
			</ul>
		</form>
	</div>


	<!-- 로그인할 때 아이디를 입력하지 않은 경우 -->
	<div id="loginIDPopup" style="display: none;">
		<ul>
			<li>아이디를 입력해주세요.</li>
		</ul>
		<br/>
		<ul>
			<li><button class="loginIDOkayBtn">확인</button></li>
		</ul>
	</div>

	<!-- 로그인할 때 비밀번호를 입력하지 않은 경우 -->
	<div id="loginPassPopup" style="display: none;">
		<ul>
			<li>비밀번호를 입력해주세요.</li>
		</ul>
		<br/>
		<ul>
			<li><button class="loginPassOkayBtn">확인</button></li>
		</ul>
	</div>
	
</body>
</html>