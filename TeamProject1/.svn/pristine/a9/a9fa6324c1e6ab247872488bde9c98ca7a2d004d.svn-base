<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="/TeamProject/css/findID.css"/>
<script src="/TeamProject/script/jquery-3.5.0.min.js"></script>
<script src="/TeamProject/script/findID.js"></script>
</head>
<body>
	<div id="findID_box">
		<form>
			<h2>아이디 찾기</h2>
			<ul id="findID_info">
				<li>
					<label for="findID_email">이메일</label><br/>
					<input type="text" id="findID_email" name="findID_email"/>
				</li>
				<input type="text" name="type" value="findID_email" style="display: none">
			</ul>
				
			<ul class="findID_buttons">
				<li><button type="button" name="findID_check">아이디 찾기</button></li>
			</ul>		
		</form>
		
		<form>
			<ul class="findID_buttons">
			<input type="text" name="type" value="cancel" style="display: none">
				<li><button type="button" id="findIDCancel">취소</button></li>
			</ul>
		</form>
	</div>
	
	
	
	
	<!-- 아이디 찾기 화면에서 이메일을 입력하지 않은 경우 -->
	<div id="findIDEmailPopup" style="display: none;">
		<ul>
			<li>이메일을 입력해주세요</li>
		</ul>
		<br/>
		<ul>
			<li><button id="findIDEmailOkayBtn">확인</button></li>
		</ul>
	</div>
	
	<!-- 동적으로 사용할 팝업창 -->
	<div id="findIDPopup" style="display: none">
		<ul id="popupMessage">
			<!-- 동적으로 메시지가 추가되는 위치 -->
		</ul>
		<br/>
		<ul>
			<li><button type="button" id="findIDPopupOkayBtn">확인</button></li>
		</ul>
	</div>
	
</body>
</html>