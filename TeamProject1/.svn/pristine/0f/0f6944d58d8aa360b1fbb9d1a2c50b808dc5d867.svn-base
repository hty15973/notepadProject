$(document).ready(function() {
	$('.findID_buttons > li > button[name=findID_check]').click(function(e) {
		// 아이디 찾기 화면에서 이메일을 입력하지 않은 경우
		if($.trim($('#findID_email').val())=='') {
			e.preventDefault();
			e.stopPropagation();
			$('#findIDEmailPopup').css("display", "block");
			return;
		}
		
		$.ajax ({
			url: '/TeamProject/member/findIDByEmail',
			type: "post",
			data: {
				findemail: $('#findID_email').val(),
				type: 'findID'
			},
			success: function(data) {
				// 받은 데이터가 정상적으로 들어오는지 확인 
				console.log(data);

				if(data==0) {	// 받은 데이터가 빈 문자열일 때
					$('<li>', {text:"해당 계정이 존재하지 않습니다."}).prependTo('#popupMessage');
					$('#findIDPopup').css("display", "block");					
					$('#findIDPopupOkayBtn').click(function() {
						location.reload();
					});
				}
				else {
					$('<li>', {text:'회원님의 아이디는 [ '+data+' ] 입니다.'}).prependTo('#popupMessage');
					$('#findIDPopup').css("display", "block");
					$('#findIDPopupOkayBtn').click(function() {
						location.href="/TeamProject/login.jsp";
					})
				}
			}
		})
	});
	
	// 아이디 찾기 -> 이메일 입력 팝업창에서 확인 버튼 누른 경우 
	$('#findIDEmailOkayBtn').click(function() {
		$('#findIDEmailPopup').hide();
		$('#findID_email').focus();
	})
	
	// 취소 버튼을 눌렀을 때 로그인 화면으로 이동 
	$('#findIDCancel').click(function() {
		window.location.href="/TeamProject/login.jsp";
	});
});