<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 수정</title>
	
	<script src="/TeamProject/script/jquery-3.5.0.min.js"></script>
	<script src="/TeamProject/script/modify.js"></script>
	<link rel="stylesheet" href="/TeamProject/css/modify.css" />
</head>
<body>
	<div id="modify_box">
		<form method="post" action="/TeamProject/member/register">
			<h2>회원 정보 수정</h2>
			<ul id="modify_info">
				<li>
					<label for="modify_id">아이디</label><br/>
					<input type="text" id="modify_id" name="modify_id"/>
				</li>
				<li>
					<label for="modify_email">이메일</label><br/>
					<input type="text" id="modify_email" name="modify_email"/>
				</li>
				<li>
					<label for="modify_password">비밀번호</label><br/>
					<input type="password" id="modify_password" name="modify_password"/>
				</li>
				<li>
					<label for="modify_password2">비밀번호 확인</label><br/>
					<input type="password" id="modify_password2" name="modify_password2"/>
				</li>
					<input type="text" name="type" value="modify" style="display: none">
			</ul>
			
			<ul class="modify_buttons">
				<li>
					<button type="submit" id="modify_check">회원 정보 수정</button>
				</li>
				<li>
					<button type="submit" id="delete">회원 탈퇴</button>				
				</li>
			</ul>
		</form>
	</div>
	
	<!-- 팝업 상자 기본 틀 -->
	<div class="modifyPopup">
		<ul id="modifyMessage">
			<!-- 동적으로 해당 메시지를 띄워줄 공간. -->
		</ul>
		<br/>
		<ul>
			<li><button type="button" id="modifyPopupOkayBtn">확인</button></li>		
		</ul>
	</div>
	
	<!-- 팝업 상자2(회원 탈퇴 시 확인용) -->
	<div class="deletePopup">
		<ul id="deleteMessage">
			<li>정말로 회원 탈퇴를 진행하시겠습니까?</li>
		</ul>
		<br/>
		<ul>
			<li>
				<button type="button" id="deletePopupOkayBtn">확인</button>
				<button type="button" id="deletePopupCancelBtn">취소</button>
			</li>
		</ul>
	</div>
</body>
</html>