$(document).ready(function() {
   $('.register_buttons > li > button[name=register_check]').click(function(e) {
         // 회원가입을 할 때 이름을 입력하지 않은 경우
         if($.trim($('#register_name').val())=='') {
            e.preventDefault();
            e.stopPropagation();
            // location.href="register.jsp";
            $('#registerNamePopup').css("display", "block");
         }
      
         // 회원가입할 때 아이디를 입력하지 않은 경우
         else if($.trim($('#register_id').val())=='') {
            e.preventDefault();
            e.stopPropagation();
            // location.href="register.jsp";
            $('#registerIDPopup').css("display", "block");
         }
         
         // 회원가입할 때 이메일을 입력하지 않은 경우
         else if($.trim($('#register_email').val())=='') {
            e.preventDefault();
            e.stopPropagation();
            // location.href="register.jsp";
            $('#registerEmailPopup').css("display", "block");
            
         }
         
         // 회원가입할 때 비밀번호를 입력하지 않은 경우
         else if($.trim($('#register_password').val())=='') {
            e.preventDefault();
            e.stopPropagation();
            // location.href="register.jsp";
            $('#registerPassPopup').css("display", "block");
                        
         }
         
         // 회원가입할 때 비밀번호 확인을 입력하지 않은 경우
         else if($.trim($('#register_password2').val())=='') {
            e.preventDefault();
            e.stopPropagation();
            // location.href="register.jsp";
            $('#registerPass2Popup').css("display", "block");
                        
         }
         
         // 입력한 비밀번호와 비밀번호 확인이 불일치하는 경우
         else if($.trim($('#register_password').val())!=$.trim($('#register_password2').val())) {
            e.preventDefault();
            e.stopPropagation();
            // location.href="register.jsp";
            $('#registerPassNotEqualPopup').css("display", "block");
            $('#register_password').val('');
            $('#register_password2').val('');
            
         
         }
   });

   /* 팝업에서 '확인' 버튼을 눌렀을 때 팝업이 사라짐 */
   $('.registerNameOkayBtn').click(function() {
      $('#registerNamePopup').hide();
      $("#register_name").focus();
   });
   
   
   $('.registerIDOkayBtn').click(function() {
      $('#registerIDPopup').hide();
      $("#register_id").focus();
   });
   
   $('.registerEmailOkayBtn').click(function() {
      $('#registerEmailPopup').hide();
      $("#register_email").focus();
   });
   
   $('.registerPassOkayBtn').click(function() {
      $('#registerPassPopup').hide();
      $("#register_password").focus();
   });
   
   $('.registerPass2OkayBtn').click(function() {
      $('#registerPass2Popup').hide();
      $("#register_password2").focus();
   });
   
   $('.registerPassNotEqualOkayBtn').click(function() {
      $('#registerPassNotEqualPopup').hide();
      $("#register_password").focus();
   })
   
   /* 전송 받은 문자열에 대해서 중복 처리 */
   /* 전송 받은 문자열에 대해서 중복 처리 */
   /* 전송 받은 문자열에 대해서 중복 처리 */
   /* 전송 받은 문자열에 대해서 중복 처리 */
   $("#sameIDBtn").click(function(e) {
      e.preventDefault();
      $.ajax ({
         url: '/TeamProject/member/register',
         type: "post",
         data: {
            id: $('#register_id').val(),
            type: 'duplicate'
         },
         success: function(data) {
            // 값이 제대로 들어오는지 확인하기 위한 코드
            console.log(data);
            // 0 : 중복 아닐 때, 1 : 중복일 때 
            if(data == 0) {
               // 사용 가능한 아이디라고 팝업을 통해 출력
               
               // alert("사용 가능한 아이디입니다.");
               
               $('#diffIDPopup').css("display", "block");
               $('.isDiffIDOkayBtn').click(function() {
                  $('#diffIDPopup').hide();
                  $('#register_email').focus();
               })
               
            }
            else if(data == 1){
               // 이미 사용 중인 아이디라고 팝업을 통해 출력
               
               // alert("이미 사용 중인 아이디입니다.");
            
               $('#sameIDPopup').css("display", "block");
               $('.isSameIDOkayBtn').click(function() {
                  $('#sameIDPopup').hide();
                   $('#register_id').val('');
                  $('#register_id').focus();
               })
            }
         }
      });
   });
      
//   /* 회원가입 창에서 취소를 눌렀을 때 로그인 화면으로 이동하기 */
//   
//   $('#cancel').click(function(e) {
//      e.preventDefault();
//      e.stopPropagation();
//      location.href="login.jsp";
//   })
});