<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!-- 비밀번호 찾기 컨트롤러로 연결 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="/TeamProject/css/findPass.css"/>
<script src="/TeamProject/script/jquery-3.5.0.min.js"></script>
<script src="/TeamProject/script/findPass.js"></script>
</head>
<body>
   <div id="findPass_box">
      <form>
         <h2>비밀번호 찾기</h2>
         <ul id="findPass_info">
            <li>
               <label for="findPass_id">아이디</label><br/>
               <input type="text" id="findPass_id" name="findPass_id"/>
            </li>
            <li>
               <label for="findPass_email">이메일</label><br /> 
               <input type="text" id="findPass_email" name="findPass_email" />
            </li>
            <input type="text" name="type" value="findPass" style="display: none">
         </ul>

         <ul class="findPass_buttons">
            <li><button type="button" name="findPass_check">비밀번호 찾기</button></li>
         </ul>
      </form>
      
      <form>
         <ul class="findPass_buttons">
         <input type="text" name="type" value="cancel" style="display: none">
            <li><button type="button" id="findPassCancel">취소</button></li>
         </ul>
      </form>
   </div>
   <!-- 비밀번호 찾기 화면에서 아이디를 입력하지 않았을 경우 -->
   <div id="findPassIDPopup" style="display: none;">
      <ul>
         <li>아이디를 입력해주세요</li>
      </ul>
      <br/>
      <ul>
         <li><button id="findPassIDOkayBtn">확인</button></li>
      </ul>
   </div>
   
   <!-- 비밀번호 찾기 화면에서 이메일을 입력하지 않았을 경우 -->
   <div id="findPassEmailPopup" style="display: none;">
      <ul>
         <li>이메일을 입력해주세요</li>
      </ul>
      <br/>
      <ul>
         <li><button id="findPassEmailOkayBtn">확인</button></li>
      </ul>
   </div>
   
   	<!-- 동적으로 사용할 팝업창 -->
	<div id="findPassPopup" style="display: none">
		<ul id="popupMessage">
			<!-- 동적으로 메시지가 추가되는 위치 -->
		</ul>
		<br/>
		<ul>
			<li><button type="button" id="findPassPopupOkayBtn">확인</button></li>
		</ul>
	</div>
</body>
</html>