$(document).ready(function() {
	$('#modify_check').click(function(e) {
		// 회원 정보 수정을 할 때 아이디를 입력하지 않은 경우
		if($.trim($('#modify_id').val())=="") {
			e.preventDefault();
			e.stopPropagation();
			$('#modifyMessage').empty();
			$('<li>', {text:"아이디를 입력하지 않았습니다."}).prependTo("#modifyMessage");
			$('.modifyPopup').css("display", "block");
			$('#modify_id').val('');
			$('#modifyPopupOkayBtn').click(function() {
				$('.modifyPopup').hide();
				$('#modify_id').focus();
			})
			return;
		}
		
		
		// 회원 정보 수정을 할 때 이메일을 입력하지 않은 경우
		else if($.trim($('#modify_email').val())=="") {
			e.preventDefault();
			e.stopPropagation();
			$('#modifyMessage').empty();
			$('<li>', {text:"이메일을 입력하지 않았습니다."}).prependTo('#modifyMessage');
			$('.modifyPopup').css("display", "block");
			$('#modify_email').val('');
			$('#modifyPopupOkayBtn').click(function() {
				$('.modifyPopup').hide();
				$('#modify_email').focus();
			})
			return;
		}
		
		// 회원 정보 수정을 할 때 비밀번호를 입력하지 않은 경우
		else if($.trim($('#modify_password').val())=="") {
			e.preventDefault();
			e.stopPropagation();
			$('#modifyMessage').empty();
			$('<li>', {text:"비밀번호를 입력하지 않았습니다."}).prependTo('#modifyMessage');
			$('.modifyPopup').css("display", "block");
			$('#modify_password').val('');
			$('#modifyPopupOkayBtn').click(function() {
				$('.modifyPopup').hide();
				$('#modify_password').focus();
			})
			return;
		}
		
		// 회원 정보 수정을 할 때 비밀번호 확인을 입력하지 않은 경우
		else if($.trim($('#modify_password2').val())=="") {
			e.preventDefault();
			e.stopPropagation();
			$('#modifyMessage').empty();
			$('<li>', {text:"비밀번호 확인을 입력하지 않았습니다."}).prependTo('#modifyMessage');
			$('.modifyPopup').css("display", "block");
		
			$('#modify_password2').val('');
			$('#modifyPopupOkayBtn').click(function() {
				$('.modifyPopup').hide();
				$('#modify_password2').focus();
			})
			return;
		}
		
		// 회원 정보를 수정할 때 비밀번호와 비밀번호 확인이 일치하지 않는 경우
		else if($.trim($('#modify_password').val())!=$.trim($('#modify_password2').val())) {
			e.preventDefault();
			e.stopPropagation();
			$('#modifyMessage').empty();
			$('<li>', {text:"비밀번호가 일치하지 않습니다."}).prependTo('#modifyMessage');
			$('.modifyPopup').css("display", "block");
			
			$('#modify_password').val('');
			$('#modify_password2').val('');
			
			$('#modifyPopupOkayBtn').click(function() {
				$('.modifyPopup').hide();
				$('#modify_password').focus();
			})
			return;
		}
		
		// 회원 정보 수정할 때 
//		$.ajax ({
//			url: "update...",
//			type: "post",
//			data: {
//				userID: $('#modify_id').val(),					// 아이디
//				userEmail: $('#modify_email').val(),			// 이메일
//				userPassword: $('#modify_password2').val()		// 비밀번호
//			},
//			success: function(data) {
//				// 회원 정보 수정에 성공하였을 경우
//				if(data.trim()=="success") {
//					e.preventDefault();
//					$('#modifyMessage').empty();
//					$('<li>', {text:"회원 정보 수정에 성공하였습니다."}).prependTo('#modifyMessage');
//					$('.modifyPopup').css("display", "block");
//					location.href="/TeamProject/login.jsp";
//				}
//				// 회원 정보 수정에 실패하였을 경우
//				else{
//					e.preventDefault();
//					$('#modifyMessage').empty();
//					$('<li>', {text:"회원 정보 수정에 실패하였습니다."}).prependTo('#modifyMessage');
//					$('.modifyPopup').css("display", "block");
//					location.href="/TeamProject/modify.jsp";
//				}
//			}
//		})
	})
	
	
	// 회원 탈퇴를 할 때 
	$('#delete').click(function(e) {
		e.preventDefault();
		$('.deletePopup').css("display", "block");
		
		$('#deletePopupOkayBtn').click(function(e) {
			$('.deletePopup').hide();
			$.ajax ({
				url: "/TeamProject/member/delete",
				type: "post",
				data: {
					// 지정한 데이터
					userID: $('#modify_id').val(),					// 아이디
					userEmail: $('#modify_email').val(),			// 이메일
					userPassword: $('#modify_password2').val()		// 비밀번호
				},
				success: function(data) {
					// 회원 탈퇴에 성공하였을 경우
					if(data.trim()=="OK") {
						e.preventDefault();
						$('#modifyMessage').empty();
						$('<li>', {text:"회원 탈퇴에 성공하였습니다."}).prependTo('#modifyMessage');
						$('.modifyPopup').css("display", "block");
						location.href="/TeamProject/login.jsp";
					}
					// 회원 탈퇴에 실패하였을 경우
					else if(data=="NO"){
						e.preventDefault();
						$('#modifyMessage').empty();
						$('<li>', {text:"회원 탈퇴에 실패하였습니다."}).prependTo('#modifyMessage');
						$('.modifyPopup').css("display", "block");
						location.href="/TeamProject/modify.jsp";
					}
				}
			})
		})
		
		$('#deletePopupCancelBtn').click(function() {
			$('.deletePopup').hide();
		})
	})
})