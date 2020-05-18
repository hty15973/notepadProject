$(document).ready(function(){
	$(document).on('click','#cancel',function(){
		$('.replyBox').css("display","none");
	})
	
	$(document).on("click", "#replyAtReply", function() {
		$('.replyBox').css("display", "none");
		$('.viewBox').css("display", "none");
		let send = true;
		
		let string="'#"+$('#receiver').val()+"'";
		
		$('.Message').children(eval(string)).children("#content").text($("#replyView").val());
		$('.replyBox').css("display", "none");
		$('#replyView').val("");
		
	})		
});