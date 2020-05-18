<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%
String id = (String)session.getAttribute("MemberID");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome To Young's Note!</title>
<script src="/TeamProject/script/jquery-3.5.0.min.js"></script>
<script src="/TeamProject/script/index.js"></script>
<script src="/TeamProject/script/memo.js"></script>
<script src="/TeamProject/script/sidebar.js"></script>
<script src="/TeamProject/script/toolbar.js"></script>
<script src="/TeamProject/script/message.js"></script>
<script src="/TeamProject/script/reply.js"></script>
<script src="/TeamProject/script/themeContent.js"></script>
<link rel="stylesheet" href="/TeamProject/css/index.css">
<link rel="stylesheet" href="/TeamProject/css/message.css">
<link rel="stylesheet" href="/TeamProject/css/toolbar.css">
<link rel="stylesheet" href="/TeamProject/css/sidebar.css">
<link rel="stylesheet" href="/TeamProject/css/memo.css">
<link rel="stylesheet" href="/TeamProject/css/reply.css">
</head>
<body>
<input type="text" id="memberID" value=<%=id %> style="display: none">



	<div class="page">
		<div class="row">
			<div class="head">
				<div class="head2">
					<div>
						<button type="button" class="SideBarOpenAndClose">사이드바</button>
						<form method='post' action='/TeamProject/member/logout'>
							<button type="submit" class="logOut">로그아웃</button>
						</form>
					</div>

					<div id="SuperBox">
						<button type="button" class="Message">쪽지함(<span class="count"></span>)</button>
					</div>
					<div id="searchBox">
						<select class="searchCategory">
							<option value="null"></option>
							<option value="byGroup">그룹명으로 검색</option>
							<option value="byName">회원명으로 검색</option>
						</select> <input type="search" id="searchByCategory"
							placeholder="검색어를 입력하십시오.">
						<button type="submit" id="searchBtn">검색</button>
						 <div id="searchList"></div>  

					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="body">
				<div class="left">
					<select class="category">
						<option value="null" selected></option>
						<option value="theme">테마별 분류</option>
						<option value="day">날짜별 분류</option>
						<option value="group">그룹별 분류</option>
					</select>
					<div>
						<span class="address">현재 위치 : </span><br> <span class="text"></span>
						<br>
						<button type="button" class="back">뒤로가기</button>
						<button type="button" class="gotoStart">처음으로</button>
						<div class="list"></div>
						<div class="pagination">
							<a href="#">&laquo;</a> <a href="#">1</a> <a href="#">2</a> <a
								href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">&raquo;</a>
						</div>
					</div>
				</div>
				<div class="right">
					<div class=editorToolbar>여기는 에디터툴바자리입니다</div>
					<div class="editorBox">
						
						<br />
						<div id="editor">
							<h1 id="title" contentEditable=true>입력</h1>
							<div id="content">
								<div id="shdudfo" contentEditable=true></div>
							</div>
						</div>
						<br>
						<div class="addThemeBox">
							<button id="addTheme">테마추가</button>
							<button id="cancelToCreate">취소하기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="viewBox">
		<ul>
			<li><input type="text" id="sender" readonly></li>
			<li><strong>수신 날짜 : </strong> <input type="text"
				id="receiveDate" readonly></li>
		</ul>
		<ul>
			<li><textarea id="messageView" readonly></textarea></li>
		</ul>
		<ul>
			<li>
				<button id="replyAtMessage">답장하기</button>
				<button id="deleteMsgBtn">삭제</button>
				<button id="cancel">취소</button>
			</li>
		</ul>
	</div>
	<div class="replyBox">
		<ul>
			<li><strong>받는 사람 : </strong><input type="text" id="receiver" readonly></li>
		</ul>

		<ul>
			<li><textarea class="replyView"></textarea></li>
		</ul>

		<ul>
			<li>
				<button id="replyAtReply">쪽지보내기</button>
				<button id="cancel">취소</button>
			</li>
		</ul>

	</div>

	<div class="indexPopup">
		<ul id="dynamicMessage">
			<!-- 동적으로 해당 메시지를 띄워줄 공간. -->
		</ul>
		<ul> 
			<li><input id="indexPopupText" type="text"></li>
			
			<li id="memberCheckMessage" style="color: red;">존재하지 않는 회원입니다.</li>
		</ul>
		<ul>
			<button type="button" id="indexPopupOkayBtn">확인</button>
			<button type="button" id="indexPopupCancelBtn">취소</button>			
		</ul>
	</div>
	
   <div class="indexMessagePopup">
      <ul id="dynamicMessage2">
         
      </ul>
      <ul>
         <button type="button" id="indexMessagePopupOkayBtn">확인</button>
      </ul>
   </div>
	
	
	 
	
	
	
	
	
	
	
	
</body>
</html>