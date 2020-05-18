$(document).ready(function(){
	$(document).on('click','#cancel',function(){
		$('.viewBox').css("display","none");
		$('#receiver').val('');
	})
	$(document).on('click','#deleteMsgBtn',function(){
		let string="'#"+$('#sender').val()+"'";

		console.log($('.Message').children(eval(string)).attr("id"));
		$('.Message').children(eval(string)).remove();
		$('.viewBox').css("display", "none");
	})
	$(document).on("click", "#replyAtMessage", function() {
		$(".viewBox").css("display","none");
		$(".replyBox").css("display","block");
		let data=$('#sender').val();
		$('#receiver').val($("#sender").val());
		$('#replyView').val("");

		$('.groupMenuBox').remove();
       
        $('.replyBox').css('display','block');
        $(document).one('click','#replyAtReply',function(){
        	 let ID=$(this).closest('.replyBox').find('#receiver').val().trim();
       	 let con=$(this).closest('.replyBox').find('.replyView').val();
       	 console.log(ID);
       	 $.ajax({
       			url:"/TeamProject/message/send",
       			type:"post",
       			data:{
       				receiverID:ID, //받는 사람이요!
       				content:con,//내용적어주세요 ><
       				type:'normal'

       			},
       			success:function(data){
       				console.log(data);
       				if(data=='yes'){ 	
       					//ws.send(위에 receiver 그대로 참조해서 적어주세요!);
       				}
       			}

       		})
        });
       		
	});
});