
$(document).ready(function() {
	
    
	$('#content').on('drop', function(e) {
		e.stopPropagation()
		e.preventDefault();
		e.dataTransfer = e.originalEvent.dataTransfer;
		var file = e.target.files || e.dataTransfer.files;
		console.log(e)
		var img = $('<img>')
		img.attr('src', window.URL.createObjectURL(file[0]))
		console.log(window.URL.createObjectURL(file[0]));
		var div = $('<div>').append(img);
		div
		div.appendTo('#shdudfo');
	})
	
	$(document).on('click','#addTheme',function(){
		var content=$(this).closest('.addThemeBox').siblings('#editor').find('#content').html();
		var theme=$(this).closest('.addThemeBox').siblings('#editor').find('#title').text();
		if(theme.trim() =="" ||$(this).closest('.addThemeBox').siblings('#editor').find('#content').text().trim()==""){
			return;
		}
		console.log(theme);
		$.ajax ({
	         url: '/TeamProject/Notepad/insert',
	         type: "post",
	         data: {
	            themes:theme,
	            contents:content
	         },
	         success: function(data) {
	        	 	// 로그인 되어 있지 안으면 로그인 창으로 data의 string이 1일때
		     }
	    });
		$(this).css("display","none");
		$(this).siblings().css("display","none");
		let box=$('<div>',{class:"editorBox"}).appendTo($('.right'));
		$('<br>').appendTo(box);
		let editor=$('<div>',{id:"editor"}).appendTo(box);
		$('<h1>',{id:"title",contentEditable:true,text:"입력"}).appendTo(editor);
		$('<div>',{id:"shdudfo",contentEditable:true}).appendTo($('<div>',{id:"content"}).appendTo(editor));
		$('<br>').appendTo(box);
		let addThemeBox=$('<div>',{class:"addThemeBox"}).appendTo(box);
		$('<button>',{id:"addTheme",text:"테마추가"}).appendTo(addThemeBox);
		$('<button>',{id:"cancelToCreate",text:"취소하기"}).appendTo(addThemeBox)
		$(box).find('#title').focus();
	})
	
	$(document).on('click','#cancelToCreate',function(){
		if($(this).closest('.editorBox').prev().attr('class')=='editorToolbar'){
			return;
		}
		$(this).closest('.editorBox').prev().find('#addTheme').css('display','inline-block');
		$(this).closest('.editorBox').prev().find('#cancelToCreate').css('display','inline-block');
		$(this).closest('.editorBox').remove();
	})
	
	
	$(document).on('keydown','#title',function(key) {
        if (key.keyCode == 13) {
        	$(this).blur();
        	let instance= $(this).closest('#editor').find('#shdudfo');
        	instance.focus();
        }
    });
	 $(document).on("click", ".folder", function(e) {
		let tCode=$(this).children('#a').text()
		$.ajax({
			url:"/TeamProject/date/themeContent",
			type:"post",
			data:{
				memberCode:'-1',
				themeName:tCode
			},
			success:function(data){
				console.log(data);
				if(data.myGroupList.length==0){
					return;
				}
				$('.editorBox').remove();
				$('.themeNameBox').remove();
				$('<div>',{class:"themeNameBox",text:tCode}).appendTo($('.right'));
				for(let i=0;i<data.myGroupList.length;i++){
					let box=$('<div>',{class:"editorBox"}).appendTo($('.right'));
	 	    		$('<button>',{id:"editBtn",type:"button",text:"수정하기"}).appendTo(box);
	 	    		$('<br>').appendTo(box);
	 	    		let editor=$('<div>',{id:"editor"}).appendTo(box);
	 	    		let h=$('<h1>',{id:"title",contentEditable:false,text:data.myGroupList[i].themeName}).appendTo(editor);
	 	    		$('<div>',{id:"regDate",contentEditable:false,text:data.myGroupList[i].regdate}).appendTo(editor);
	 	    		let dudfo=$('<div>',{html:$.parseHTML(data.myGroupList[i].content)}).appendTo($('<div>',{id:"content"}).appendTo(editor));
	 	    		$('#shdudfo').attr('contenteditable',false);																																														
				}
			}
		})
	 })
	 
	 $(document).on("click", ".dateFolder", function() {
		  let value=$(this).children("#a").text()
		  console.log(value);
	      $.ajax({
	         url : "/TeamProject/date/contentName",
	         type: "post",
	         data:{
	        	 date:value
	         },
	         success: function(data) {
	            console.log(data);
	            if(data.contentName.length==0){
	            	return;
	            }
	            $('.editorBox').remove();
	            $('.themeNameBox').remove();
	            $('<div>',{class:"themeNameBox",text:value}).appendTo($('<div>',{class:"themeNameBox"}).appendTo($('.right')));
	            for(let i = 0;i<data.contentName.length;i++){	
	            	let box=$('<div>',{class:"editorBox"}).appendTo($('.right'));
	 	    		$('<button>',{id:"editBtn",type:"button",text:"수정하기"}).appendTo(box);
	 	    		$('<br>').appendTo(box);
	 	    		let editor=$('<div>',{id:"editor"}).appendTo(box);
	 	    		let h=$('<h1>',{id:"title",contentEditable:false,text:data.contentName[i].themeName}).appendTo(editor);
	 	    		$('<div>',{id:"regDate",contentEditable:false,text:data.contentName[i].regdate}).appendTo(editor);
	 	    		let dudfo=$('<div>',{html:$.parseHTML(data.contentName[i].content)}).appendTo($('<div>',{id:"content"}).appendTo(editor));
	 	    		$('#shdudfo').attr('contenteditable',false);
	            }
	            $('.editorBox').css("display","block");
	    		
	            
	         }
	      })
	   })
	   
	    $(document).on("click", ".groupMemberTheme", function() {
	    	mCode=$(this).children('#dataMemberCode').text();
	    	tCode=$(this).children('#a').text();
	    	$.ajax({
				url:"/TeamProject/date/themeContent",
				type:"post",
				data:{
					memberCode:mCode,
					themeName:tCode
				},
				success:function(data){
					console.log(data);
					if(data.myGroupList.length==0){
						return;
					}
					$('.editorBox').remove();
					$('.themeNameBox').remove();
					$('<div>',{class:"themeNameBox",text:tCode}).appendTo($('<div>').appendTo($('.right')));
					for(let i=0;i<data.myGroupList.length;i++){
						let box=$('<div>',{class:"editorBox"}).appendTo($('.right'));
		 	    		$('<button>',{id:"editBtn",type:"button",text:"수정하기"}).appendTo(box);
		 	    		$('<br>').appendTo(box);
		 	    		let editor=$('<div>',{id:"editor"}).appendTo(box);
		 	    		let h=$('<h1>',{id:"title",contentEditable:false,text:data.myGroupList[i].themeName}).appendTo(editor);
		 	    		$('<div>',{id:"regDate",contentEditable:false,text:data.myGroupList[i].regdate}).appendTo(editor);
		 	    		let dudfo=$('<div>',{html:$.parseHTML(data.myGroupList[i].content)}).appendTo($('<div>',{id:"content"}).appendTo(editor));
		 	    		$('#shdudfo').attr('contenteditable',false);																																														
					}
				}
			})
	    })
	   $(document).on("click",'#editBtn',function(){
		   let selectOption=$('.category option:selected').val();
		   console.log($(this).siblings('#editor').find('#shdudfo').attr('contenteditable'));
		   if($(this).siblings('#editor').find('#shdudfo').attr('contenteditable')=='false'){
			  $(this).siblings('#editor').find('#shdudfo').attr('contenteditable',true)
			  $(this).text("수정완료");
			  

		   }
		   else{
			   $(this).siblings('#editor').find('#shdudfo').attr('contenteditable',false)
			   $(this).text("수정하기");
			   
			   if(selectOption=="day"){
				   let c=$(this).closest('.editorBox').find('#content').html();
				   let t=$(this).siblings('#editor').find('#title').text();
				   let d=$(this).siblings('#editor').find('#regDate').text()
				   console.log(c);
					   console.log(t);
					   console.log(d);
					  $.ajax({
						  url:"/TeamProject/Notepad/updateContent",
						  type:"post",
						  data:{
							  content:$(this).closest('.editorBox').find('#content').html(),
							  themeName:$(this).siblings('#editor').find('#title').text(),
							  date:$(this).siblings('#editor').find('#regDate').text()
						  },
						  success:function(data){
							  console.log(data);
						  }
					  })
				  }
				  else if(selectOption=="theme"){
					  let c=$(this).closest('.editorBox').find('#content').html();
					   let t=$(this).closest('.right').find('.themeNameBox').text();					   
					   let d=$(this).siblings('#editor').find('#regDate').text();
					   console.log(c);
					   console.log(t);
					   console.log(d);
					  $.ajax({
						  url:"/TeamProject/Notepad/updateContent",
						  type:"post",
						  data:{
							  content:$(this).closest('.editorBox').find('#content').html(),
							  themeName:$(this).closest('.right').find('.themeNameBox').text(),
							  date:$(this).siblings('#editor').find('#regDate').text()
						  },
						  success:function(data){
							  console.log(data);
						  }
					  })
				  }
		   }
	   })

		
})
