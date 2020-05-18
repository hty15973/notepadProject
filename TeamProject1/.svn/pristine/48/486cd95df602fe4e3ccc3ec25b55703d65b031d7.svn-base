<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 회원가입에 대한 컨트롤러 import -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script src="/TeamProject/script/jquery-3.5.0.min.js"></script>
<script src="/TeamProject/script/register.js"></script>
<link rel="stylesheet" href="/TeamProject/css/register.css" />

<script>
	
</script>

</head>
<body>

	<div id="register_box">
		<form method="post" action="/TeamProject/member/register">
			<h2>회원가입</h2>
			<ul id="register_info">
				<li>
					<label for="register_name">이름</label><br/>
					<input type="text" id="register_name" name="register_name"/>
				</li>
				<li>
					<label for="register_id">아이디</label><br/>
					<input type="text" id="register_id" name="register_id"/>
					<button id="sameIDBtn">중복확인</button>
				</li>
				<li>
					<label for="register_email">이메일</label><br/>
					<input type="text" id="register_email" name="register_email"/>
				</li>
				<li>
					<label for="register_password">비밀번호</label><br/>
					<input type="password" id="register_password" name="register_password"/>
				</li>
				<li>
					<label for="register_password2">비밀번호 확인</label><br/>
					<input type="password" id="register_password2" name="register_password2"/>
				</li>
					<input type="text" name="type" value="register" style="display: none">
			</ul>
				
			<ul class="register_buttons">
				<li><button type="submit" name="register_check" id="register_check">회원가입 신청</button></li>
			</ul>	
		</form>


		<form method="post" action="/TeamProject/member/register">
			<ul class="register_buttons">
				<input type="text" name="type" value="cancel" style="display: none">
				<li><button type="submit" name="cancel" id="cancel">취소</button></li>
			</ul>
		</form>
	</div>
	
	<!-- 회원가입할 때 이름을 입력하지 않은 경우 -->
	<div id="registerNamePopup" style="display: none;">
		<ul>
			<li>이름을 입력해주세요.</li>
		</ul>
		<br/>
		<ul>
			<li><button class="registerNameOkayBtn">확인</button></li>
		</ul>
	</div>
	
	<!-- 회원가입할 때 아이디를 입력하지 않은 경우 -->
	<div id="registerIDPopup" style="display: none;">
		<ul>
			<li>아이디를 입력해주세요.</li>
		</ul>
		<br/>
		<ul>
			<li><button class="registerIDOkayBtn">확인</button></li>
		</ul>
	</div>
	
	<!-- 회원가입할 때 이메일를 입력하지 않은 경우 -->
	<div id="registerEmailPopup" style="display: none;">
		<ul>
			<li>이메일을 입력해주세요.</li>
		</ul>
		<br/>
		<ul>
			<li><button class="registerEmailOkayBtn">확인</button></li>
		</ul>
	</div>
	
	<!-- 회원가입할 때 비밀번호를 입력하지 않은 경우 -->
	<div id="registerPassPopup" style="display: none;">
		<ul>
			<li>비밀번호을 입력해주세요.</li>
		</ul>
		<br/>
		<ul>
			<li><button class="registerPassOkayBtn">확인</button></li>
		</ul>
	</div>
	
	<!-- 회원가입할 때 비밀번호 확인을 입력하지 않은 경우 -->
	<div id="registerPass2Popup" style="display: none;">
		<ul>
			<li>비밀번호 확인을 입력해주세요.</li>
		</ul>
		<br/>
		<ul>
			<li><button class="registerPass2OkayBtn">확인</button></li>
		</ul>
	</div>
	
	<!-- 회원가입할 때 비밀번호가 일치하지 않는 경우 -->
	<div id="registerPassNotEqualPopup" style="display: none;">
		<ul>
			<li>비밀번호가 일치하지 않습니다.</li>
		</ul>
		<br/>
		<ul>
			<li><button class="registerPassNotEqualOkayBtn">확인</button></li>
		</ul>
	</div>
	
	<!-- 중복 확인할 때 아이디가 중복되는 경우 -->
	<div id="sameIDPopup" style="display: none;">
		<ul>
			<li>이미 사용 중인 아이디입니다.</li>
		</ul>
		<br/>
		<ul>
			<li><button class="isSameIDOkayBtn">확인</button></li>
		</ul>
	</div>
	
	<!-- 중복 확인할 때 아이디가 중복되지 않는 경우 -->
	<div id="diffIDPopup" style="display: none;">
		<ul>
			<li>사용 가능한 아이디입니다.</li>
		</ul>
		<br/>
		<ul>
			<li><button class="isDiffIDOkayBtn">확인</button></li>
		</ul>
	</div>
</body>
</html>