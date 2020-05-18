$(document).ready(function() {
	$(".login_buttons > li > button[name=login_check]").click(function(e) {
		// 로그인할 때 아이디를 입력하지 않은 경우
		if ($.trim($("#user_id").val()) == "") {
			e.preventDefault();
			$('#loginIDPopup').css("display", "block");
			return;
		}

		// 로그인할 때 비밀번호를 입력하지 않은 경우
		else if ($.trim($("#user_pass").val()) == "") {
			e.preventDefault();
			$('#loginPassPopup').css("display", "block");
			return;
		}
	});
	
	/* 팝업에서 '확인' 버튼을 눌렀을 때 팝업이 사라짐 */
	$('.loginIDOkayBtn').click(function() {
		$('#loginIDPopup').hide();
		$("#user_id").focus();
	});
	
	$('.loginPassOkayBtn').click(function() {
		$('#loginPassPopup').hide();
		$("#user_pass").focus();
	});
});
 