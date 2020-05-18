$(document).ready(function() {
   $('.findPass_buttons > li > button[name=findPass_check]').click(function(e) {
      // 비밀번호 찾기 화면에서 아이디를 입력하지 않은 경우
      if($.trim($('#findPass_id').val())=='') {
         e.preventDefault();
         e.stopPropagation();
         $('#findPassIDPopup').css("display", "block");
         $('#findPass_id').focus();
         return;
      }
      
      // 비밀번호 찾기 화면에서 이메일을 입력하지 않은 경우
      else if($.trim($('#findPass_email').val())=='') {
         e.preventDefault();
         e.stopPropagation();
         $('#findPassEmailPopup').css("display", "block");
         $('#findPass_email').focus();
         return;
      }
      
      $.ajax ({
         url: '/TeamProject/member/findPass',
         type: 'post',
         data: {
            findID : $('#findPass_id').val(),
            findEmail : $('#findPass_email').val(),
            type: 'findPass'
         },
         success : function(data){
            console.log(data);

			if(data==0) {	// 받은 데이터가 빈 문자열일 때 
				$('<li>', {text: "해당 정보와 일치하는 계정이 존재하지 않습니다."}).prependTo('#popupMessage');
				$('#findPassPopup').css("display", "block");
				$('#findPassPopupOkayBtn').click(function() {
					location.reload();
				})
			}
			else {
				$('<li>', {text:'회원님의 비밀번호는 [ '+data+' ] 입니다.'}).prependTo('#popupMessage');
				$('#findPassPopup').css("display", "block");
				$('#findPassPopupOkayBtn').click(function() {
					location.href="/TeamProject/login.jsp";
				})
			}
         }
      })
   // 비밀번호 찾기 -> 아이디 입력 팝업창에서 확인 버튼 누른 경우
   $('#findPassIDOkayBtn').click(function() {
      $('#findPassIDPopup').hide();
      $('#findPass_ID').focus();
   });
   
   // 비밀번호 찾기 -> 이메일 입력 팝업창에서 확인 버튼 누른 경우
   $('#findPassEmailOkayBtn').click(function() {
      $('#findPassEmailPopup').hide();
      $('#findPass_email').focus();
   });
   
   // 취소 버튼을 눌렀을 때 로그인 화면으로 이동 
   $('.findPass_buttons[name=cancel]').click(function() {
      location.hrel="/TeamProject/member/login";
   })
})

   $('#findPassIDOkayBtn').click(function(){
      $('#findPassIDPopup').hide();
      $('#findPass_id').focus();
   })
   
   $('#findPassEmailOkayBtn').click(function(){
      $('#findPassEmailPopup').hide();
      $('#findPass_email').focus();
   })
   
	// 취소 버튼을 눌렀을 때 로그인 화면으로 이동 
	$('#findPassCancel').click(function() {
		window.location.href="/TeamProject/login.jsp";
	});
})