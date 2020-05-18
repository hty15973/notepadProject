var string;
var address= '';
var prevAddress=null;
var folderNum=-1;
var isMenuBoxOn=false;



$.fn.showThemeList = function(){

   $.ajax({
      url: '/TeamProject/themeMember/relation',
      type: 'post',
      data: {
         type:'home',
         theme:''
      },
      success: function(data){
    	  console.log(data);
    	 $('.list').empty();
         address='';
         $(".address").text("현재 위치 : "+address);
         
         for(let i=0;i<data.list.length;i++){
            
            let ul=$('<ul>',{class:'folder'}).appendTo($('.list'));
            $('<li>',{id:'a',text:data.list[i].theme}).appendTo(ul);
         }
// let ul=$('<ul>',{class:'folder'}).appendTo($('.list'));
// $('<li>',{class:"add",text:' + '}).prependTo(ul);
      }
   });
}


$.fn.showThemeChild = function(){
	let tmp=$(this).children('#a').text();
   $.ajax({
      url: '/TeamProject/themeMember/relation',
      type: 'post',
      data: {
         type:'front',
         theme:$(this).children('#a').text()
      },
      success: function(data){
         if(data.list.length>0){
             address=address+tmp+"/";
             $(".address").text("현재 위치 : "+address);
        	  $('.list').empty();
        	  for(let i=0;i<data.list.length;i++){
                  
                  let ul=$('<ul>',{class:'folder'}).appendTo($('.list'));
                  $('<li>',{id:'a',text:data.list[i].theme}).appendTo(ul);
 	         }
// let ul=$('<ul>',{class:'folder'}).appendTo($('.list'));
// $('<li>',{class:"add",text:' + '}).prependTo(ul);
 	       
         }
	  }
   });
}

$.fn.showDateList = function() {
      $('.list').empty();
      $.ajax ({
         url: '/TeamProject/date/dates',
         type: 'post',
         data: {
            type: 'home',
            theme: ''
         },
         success: function(data) {
           console.log(data);
            var obj = data;
            
            for(let i=0; i<Object.keys(data).length; i++) {
               let array = data[i];
               let ul = $('<ul>', {class: 'dateFolder'}).appendTo('.list');
               $('<li>', {id: 'a', text: array}).appendTo(ul);
            }
         }
      })
   }

$.fn.showGroupList = function() {
	$('.list').empty();
	$.ajax ({
		url: '/TeamProject/Group/getGroupList',
		type: 'post',
		success: function(data) {
			console.log(data);
			address='';
	        $(".address").text("현재 위치 : "+address);
			for(let i=0; i<data.myGroupList.length; i++) {
				let array = data.myGroupList[i];
				let ul = $('<ul>', {class: 'groupFolder'}).appendTo('.list');
				let li = $('<li>', {id: 'a', text: data.myGroupList[i].groupName}).appendTo(ul);
				$('<span>',{class:"storage",id:data.myGroupList[i].groupCode,text:data.myGroupList[i].groupName}).appendTo(ul);
			}
			let ul = $('<ul>', {class: 'groupFolder'}).appendTo('.list');
			$('<li>', {class: 'add', text: " + "}).appendTo(ul);
		}
	})
}

$.fn.themeGoBack = function(){
   $('.list').empty();
   let res=address.split('/');
   let cnt=res.length;
   let newAddress='';
   if(cnt>1){
      for (let i=0;i<cnt-2;i++){
         newAddress+=res[i]+'/';
      }
      address=newAddress;
      $.ajax({
         url: '/TeamProject/themeMember/relation',
         type: 'post',
         data: {
            type:'back',
            theme:res[cnt-2]
         },
         success: function(data){
        	 console.log(data);
            for(let i=0;i<data.list.length;i++){
               let ul=$('<ul>',{class:'folder'}).appendTo($('.list'));
               $('<li>',{id:'a',text:data.list[i].theme}).appendTo(ul);
            }
            $(".address").text("현재 위치 : "+address);
            
         }
         
      });
   }
   else{
      $.ajax({
         url: '/TeamProject/themeMember/relation',
         type: 'post',
         data: {
            type:'back',
            theme:''
         },
         success: function(data){
            console.log(data);
            for(let i=0;i<data.list.length;i++){
                let ul=$('<ul>',{class:'folder'}).appendTo($('.list'));
                $('<li>',{id:'a',text:data.list[i].theme}).appendTo(ul);
             }
            address="";
            $(".address").text("현재 위치 : "+address);
         }
      });   
   }
}

$.fn.ClickAndSize =function(){
   $('ul').css('height','30px');
   $(this).css('height','78px');
}

$.fn.AddGroupName =function(){
   let group = prompt("추가할 그룹명을 입력하세요.", "테마명");
   $.ajax({
	   url:"/TeamProject/Group/groupMaking",
	   type:"post",
	   data:{
		   groupName:group
	   },
	   success:function(data){
		   if(data.successCode=="yes"){
			   if(group.length>18){
				      let str=group.substring(0,18)+"...";
				      let ul = $('<ul>', {class: 'groupFolder'})
					  $(ul).insertBefore($('.add').closest('.groupFolder'));
					  let li = $('<li>', {id: 'a', text: str}).appendTo(ul);
					  $('<span>',{class:"storage",id:data.GroupCode,text:group}).appendTo(ul);
			   }
			   else{
				   let ul = $('<ul>', {class: 'groupFolder'})
				   $(ul).insertBefore($('.add').closest('.groupFolder'));
				   let li = $('<li>', {id: 'a', text: group}).appendTo(ul);
				   $('<span>',{class:"storage",id:data.GroupCode,text:group}).appendTo(ul);
			   }
		   }
		   else{
			   // 여기에 팝업처리
		   }
	   }
   })
// let ul = $('<ul>',{class:'groupFolder'}).prependTo($('.list'));
  
}

$(document).ready(function(){
   
	$(document).one("click", ".SideBarOpenAndClose", function() {
		$('.address').css("display", "none");
		
	})
	
   $(document).on('click','.folder',function(){

      $(this).showThemeChild();
  
   });
      
  
   
   $(document).on("click", ".groupFolder", function() {
	  let value=$(this).find(".storage").attr("id");// 그룹코드
	  let temp=$(this).find('#a').text();
      $.ajax({
         url : "/TeamProject/Group/GetGroupMemberList",
         type: "post",
         data:{
        	 groupCode:value
         },
         success: function(data) {
        	console.log(data);
            console.log(data.groupMemberList.length);
            if(data.groupMemberList.length==0){
				return
			}
            address=address+temp+'/';
            $(".address").text("현재 위치 : "+address);
            $('.list').empty();
            $('<ul>',{class:"storage",id:"dataGroupCode",text:value}).appendTo('.list');
            for(let i=0;i<data.groupMemberList.length;i++){
            	let ul = $('<ul>', {class: 'groupMemberList'}).appendTo('.list');
				let li = $('<li>', {id: 'a', text:data.groupMemberList[i].id}).appendTo(ul);
				$('<span>',{class:"storage",id:"grandFather",text:''}).appendTo(ul);
				$('<span>',{class:"storage",id:"dataGroupCode",text:value}).appendTo(ul);
				$('<span>',{class:"storage",id:"dataMemberCode",text:data.groupMemberList[i].memberCode}).appendTo(ul);
            }
         }
      })
   })
   
   $(document).on("click",".groupMemberList",function(){
	   let gCode=$(this).find("#dataGroupCode").text();
	   let mCode=$(this).find("#dataMemberCode").text();
	   let father=$(this).find('#a').text();
	   let fatherClass=$(this).attr('class');
	   let temp=$(this).children('#a').text();
	   console.log(gCode);
	   console.log(father);
	   $.ajax({
		   url:'/TeamProject/Group/themeList',
		   type:"post",
		   data:{
			   type:'themeHome',
			   groupCode:gCode,
			   memberCode:mCode,
			   theme:father
		   },
		   success:function(data){
			   console.log(data);
			   address=address+temp+'/';
			   if(data.list.length==0){
				   $('.list').empty();
				   let ul = $('<ul>', {class: 'open',id:mCode}).appendTo('.list');
					$('<li>', { text: " + "}).appendTo(ul);
					$('<span>',{class:"storage",id:"dataGroupCode",text:gCode}).appendTo(ul);
					$('<span>',{class:"storage",id:"dataMemberCode",text:mCode}).appendTo(ul);
					$('<span>',{class:"storage",id:"father",text:father}).appendTo(ul);
					$('<span>',{class:"storage",id:"fatherClass",text:fatherClass}).appendTo(ul);
			   }
			   else{
				   $(".address").text("현재 위치 : "+address);
				   $('.list').empty();
				   for(let i=0;i<data.list.length;i++){
		            	let ul = $('<ul>', {class: 'groupMemberTheme',id:"blind"}).appendTo('.list');
						let li = $('<li>', {id: 'a', text:data.list[i].themeMemberName}).appendTo(ul);
						$('<span>',{class:"storage",id:"grandFather",text:gCode}).appendTo(ul);
						$('<span>',{class:"storage",id:"father",text:father}).appendTo(ul);
						$('<span>',{class:"storage",id:"fatherClass",text:fatherClass}).appendTo(ul);
						$('<span>',{class:"storage",id:"dataGroupCode",text:gCode}).appendTo(ul);
						$('<span>',{class:"storage",id:"dataMemberCode",text:mCode}).appendTo(ul);
		            }
				   let ul = $('<ul>', {class: 'open',id:mCode}).appendTo('.list');
					$('<li>', { text: " + "}).appendTo(ul);
					$('<span>',{class:"storage",id:"dataGroupCode",text:gCode}).appendTo(ul);
					$('<span>',{class:"storage",id:"dataMemberCode",text:mCode}).appendTo(ul);
					$('<span>',{class:"storage",id:"father",text:father}).appendTo(ul);
					$('<span>',{class:"storage",id:"fatherClass",text:fatherClass}).appendTo(ul);
			   }
				
		   }
	   })
   })
     $(document).on('mousedown', '#blind', function(e){
    	 e.stopPropagation();
    	 e.preventDefault();
     /* 여기 수정함 */
     if(e.which==3){
           let ul =$('<ul>',{class : "openBox"}).appendTo($(this));
           $('<li>', {class:"openBoxChild",id:"blindTheme",text:"테마 비공개"}).appendTo(ul);
      }
      var sWidth = window.innerWidth;
      var sHeight = window.innerHeight;

      var oWidth = $('.openBox').width();
      var oHeight = $('.openBox').height();

      // 레이어가 나타날 위치를 셋팅한다.
      var divLeft = e.clientX ;
      var divTop = e.clientY;

      $('.openBox').css({
         "top": divTop,
         "left": divLeft,
         "position": "fixed"
      }).show();
      isMenuBoxOn=true;
   });
   $(document).on("mousedown",".open",function(){
	   let group = null;
	   $('#dynamicMessage').empty();
       $('<li>', {text: "추가할 그룹명을 입력하시오."}).prependTo('#dynamicMessage');
       $('#indexPopupText').css("display", "block");
       $('.indexPopup').css("display", "block");
       $('#indexPopupText').val()=='';
       let mCode=$(this).find('#dataMemberCode').text();
       let gCode=$(this).find('#dataGroupCode').text();
       let father=$(this).find('#father').text();
       let fatherClass=$(this).find('#fatherClass').text();
       console.log(mCode);
       console.log(gCode);
	   $(document).one("mousedown", "#indexPopupOkayBtn", function() {
	      $('.indexPopup').css("display", "none");
	      group = $('#indexPopupText').text();
	      let val= $('#indexPopupText').val();
	      $.ajax({
	    	   url:"/TeamProject/Group/setThemeSharedIsMine",
	    	   type:"post",
	    	   data:{
	    		   memberCode:mCode
	    	   },
	    	   success:function(data){
	    		   console.log(data);
	    		   if(data.trim()=="true"){
	    			   $.ajax({
	    				   url:"/TeamProject/Group/setThemeShared",
	    				   type:"post",
	    				   data:{
	    					   groupCode:gCode,
	    					   themeName:val
	    				   },
	    				   success:function(data){
	    					   console.log(data);
	    					  if(data.trim()=="true"){
	    					   let ul = $('<ul>', {class: 'groupMemberTheme',id:"blind"});
	    					   $(ul).insertBefore($('.open'));
	       					   let li = $('<li>', {id: 'a', text:val}).appendTo(ul);
	       					   $('<span>',{class:"storage",id:"grandFather",text:gCode}).appendTo(ul);
	       					   $('<span>',{class:"storage",id:"father",text:father}).appendTo(ul);
	       					   $('<span>',{class:"storage",id:"fatherClass",text:fatherClass}).appendTo(ul);
	       					   $('<span>',{class:"storage",id:"dataGroupCode",text:gCode}).appendTo(ul);
	       					   $('<span>',{class:"storage",id:"dataMemberCode",text:mCode}).appendTo(ul);
	    					  }
	    					  else{
	    						  $('#dynamicMessage').empty();
	    		         		    $('<li>', {text: "해당하는 테마가 존재하지않습니다."}).prependTo('#dynamicMessage');
	    		         		   $('#indexPopupText').css("display","none");
	    		         		   setTimeout(function() {
	    		      				 $('.indexPopup').css("display","none");
	    		      			}, 3000);
	    		      			return;
	    					  }
	    				   }
	    			   })
	    		   }else{
	    				$('#dynamicMessage').empty();
	         		    $('<li>', {text: "회원님의 테마가 아닙니다"}).prependTo('#dynamicMessage');
	         		   $('#indexPopupText').css("display", "none");
	         		   setTimeout(function() {
	      				 $('.indexPopup').css("display","none");
	      				$('#indexPopupText').css("display", "block");
	      			}, 3000);
	      			return;
	    		   }
	    	   }
	       })
	   })
   })
   $(document).on("mousedown", "#blindTheme", function(e) {
	   e.stopPropagation();
	   e.preventDefault();
      $('#dynamicMessage').empty();
      $('<li>', {text: "해당 테마를 비공개로 설정하시겠습니까?"}).prependTo('#dynamicMessage');
      $('#indexPopupText').css("display", "none");
      $('.indexPopup').css("display", "block");
      let instance=$(this).closest('.groupMemberTheme');
      let gCode=$(this).closest('.openBox').siblings('#dataGroupCode').text();
      let mCode=$(this).closest('.openBox').siblings('#dataMemberCode').text();
      let name = $(this).closest('.openBox').siblings('#a').text();
		 console.log(mCode);
 		 console.log(gCode);
 		 console.log(name);
      $(document).one("mousedown", "#indexPopupOkayBtn", function() {
    	  
          $.ajax({
         	 url:"/TeamProject/theme/privateTheme",
         	 type:"post",
         	 data:{
         		 memberCode:mCode,
         		 groupCode:gCode,
         		 theme:name
         	 },
         	 success:function(data){
         		 console.log(data);
         		 if(data.trim()=="true"){
         			 console.log(instance.attr('class'));
         			 instance.remove();
         		     $('.indexPopup').css("display", "none");
         		     $(this).groupAtTheFirst();
         		 }
         		 else{
         			$('#dynamicMessage').empty();
         		    $('<li>', {text: "알수없는 이유로 실패했습니다"}).prependTo('#dynamicMessage');
         		   setTimeout(function() {
      				 $('.indexPopup').css("display","none");
      			}, 3000);
      			return;
         		 }
         	 }
          })
       })
     
   })
    
   /* 여기 수정함 */
   $(document).on("click",".groupMemberTheme",function(){
	   let gCode=$(this).find("#dataGroupCode").text();
	   let mCode=$(this).find("#dataMemberCode").text();
	   let father=$(this).children('#a').text(); // 자신의 이름 아들의 아빠는 자신,아들의
													// 할아버지는 자신의 아빠
	   let grandFather=$(this).find('#father').text();
	   let fatherClass=$(this).attr('class'); // 자신의 이름 아들의 아빠는 자신,아들의 할아버지는
												// 자신의 아빠
	   let grandFatherClass=$(this).find('#fatherClass').text();
	   let temp=$(this).children('#a').text();
	   console.log(gCode);
	   console.log(father);
	   $.ajax({
		   url:'/TeamProject/Group/themeList',
		   type:"post",
		   data:{
			   type:'front',
			   groupCode:gCode,
			   memberCode:mCode,
			   theme:father
		   },
		   success:function(data){
			   console.log(data);
			   if(data.list.length==0){
				   return
			   }
			   address=address+temp+'/';
	            $(".address").text("현재 위치 : "+address);
			   $('.list').empty();
			   for(let i=0;i<data.list.length;i++){
	            	let ul = $('<ul>', {class: 'groupMemberTheme'}).appendTo('.list');
					let li = $('<li>', {id: 'a', text:data.list[i].themeMemberName}).appendTo(ul);
					$('<span>',{class:"storage",id:"grandFather",text:grandFather}).appendTo(ul);
					$('<span>',{class:"storage",id:"father",text:father}).appendTo(ul);
					$('<span>',{class:"storage",id:"grandFatherClass",text:grandFatherClass}).appendTo(ul);
					$('<span>',{class:"storage",id:"fatherClass",text:fatherClass}).appendTo(ul);
					$('<span>',{class:"storage",id:"dataGroupCode",text:gCode}).appendTo(ul);
					$('<span>',{class:"storage",id:"dataMemberCode",text:mCode}).appendTo(ul);
	            }
		   }
	   })
   })
   
   $(document).on("change",".category",function(){
	  
      let selectOption=$('.category option:selected').val();
      
      if(selectOption=="null") {
    	  $('.back').css("display", "none");
    	  $('.gotoStart').css("display", "none");
    	  $('.pagination').css("visibility", "hidden");
    	  $('.list').css("visibility", "hidden");
    	  $('.address').css("display", "none");
      }
      else {
	      if(selectOption=="theme") {
	          $(this).showThemeList();
	       }
	       else if(selectOption=="day") {
	          $(this).showDateList();
	       }
	       else if(selectOption=="group") {
	    	   $(this).showGroupList();
	       }
	      $('.back').css("display","block");
	      $('.gotoStart').css("display","block");
	      $('.pagination').css("visibility","visible");
	      $('.list').css("visibility", "visible");
	      
	      $(".address").css("display","block");
      }
	  address='';
	  $(".address").text("현재 위치 : "+address);
   });
   
   $(document).on("click",".add",function(){
      $(this).AddGroupName();
   })
   
   $('.gotoStart').click(function(){
	   let selectOption=$('.category option:selected').val();
	   if(selectOption=="theme"){
		   $(this).showThemeList();
		   address='';
		   $('.text').text(address);
	   }else if(selectOption=="group"){
		   alert("그룹처음으로");
		   $(this).groupAtTheFirst();
	   }
      
   });
   $.fn.groupAtTheFirst=function(){
	   $('.list').empty();
		$.ajax ({
			url: '/TeamProject/Group/getGroupList',
			type: 'post',
			success: function(data) {
				console.log(data);
				address='';
	            $(".address").text("현재 위치 : "+address);
				for(let i=0; i<data.myGroupList.length; i++) {
					let array = data.myGroupList[i];
					let ul = $('<ul>', {class: 'groupFolder'}).appendTo('.list');
					let li = $('<li>', {id: 'a', text: data.myGroupList[i].groupName}).appendTo(ul);
					$('<span>',{class:"storage",id:data.myGroupList[i].groupCode,text:data.myGroupList[i].groupName}).appendTo(ul);
				}
				let ul = $('<ul>', {class: 'groupFolder'}).appendTo('.list');
				$('<li>', {class: 'add', text: " + "}).appendTo(ul);
			}
		})
	   return;
   }
   
   $.fn.groupBack=function(){
	   let result=address.split('/');
	   let cnt = result.length;
	   let gf = (result[cnt-2]);
	   if ((cnt-3)<0){
		   $('.list').empty();
			$.ajax ({
				url: '/TeamProject/Group/getGroupList',
				type: 'post',
				success: function(data) {
					console.log(data);
					address='';
		            $(".address").text("현재 위치 : "+address);
					for(let i=0; i<data.myGroupList.length; i++) {
						let array = data.myGroupList[i];
						let ul = $('<ul>', {class: 'groupFolder'}).appendTo('.list');
						let li = $('<li>', {id: 'a', text: data.myGroupList[i].groupName}).appendTo(ul);
						$('<span>',{class:"storage",id:data.myGroupList[i].groupCode,text:data.myGroupList[i].groupName}).appendTo(ul);
					}
					let ul = $('<ul>', {class: 'groupFolder'}).appendTo('.list');
					$('<li>', {class: 'add', text: " + "}).appendTo(ul);
				}
			})
		   return;
	   }
	   else if((cnt-3)==0){
		   let value=$('.list > ul:first-child').find("#dataGroupCode").text();// 그룹코드
		   $.ajax({
		          url : "/TeamProject/Group/GetGroupMemberList",
		          type: "post",
		          data:{
		         	 groupCode:value
		          },
		          success: function(data) {
		         	 console.log(data);
		             console.log(data.groupMemberList.length);
		             if(data.groupMemberList.length==0){
		 				return
		 			}
		             $('.list').empty();
		             let newAddress='';
						for (let i=0;i<cnt-2;i++){
							newAddress=newAddress+result[i]+'/';
						}
						address=newAddress;
						console.log(address);
						$('.address').text("현재위치 : "+address);
		             for(let i=0;i<data.groupMemberList.length;i++){
		             	let ul = $('<ul>', {class: 'groupMemberList'}).appendTo('.list');
		 				let li = $('<li>', {id: 'a', text:data.groupMemberList[i].id}).appendTo(ul);
		 				$('<span>',{class:"storage",id:"grandFather",text:''}).appendTo(ul);
		 				$('<span>',{class:"storage",id:"dataGroupCode",text:value}).appendTo(ul);
		 				$('<span>',{class:"storage",id:"dataMemberCode",text:data.groupMemberList[i].memberCode}).appendTo(ul);
		             }
		          }
		       })
		      return;
	   }
	   else if((cnt-3)==1){
		   let gCode=$('.list > ul:first-child').find("#dataGroupCode").text();
		   let mCode=$('.list > ul:first-child').find("#dataMemberCode").text();
		   let father=$('.list > ul:first-child').find('#a').text();
		   let fatherClass=$('.list > ul:first-child').attr('class');
		   console.log(gCode);
		   console.log(father);
		   $.ajax({
			   url:'/TeamProject/Group/themeList',
			   type:"post",
			   data:{
				   type:'themeHome',
				   groupCode:gCode,
				   memberCode:mCode,
				   theme:father
			   },
			   success:function(data){
				   console.log(data);
				   if(data.list.length==0){
					   return
				   }
				   $('.list').empty();
				   let newAddress='';
					for (let i=0;i<cnt-2;i++){
						newAddress=newAddress+result[i]+'/';
					}
					address=newAddress;
					console.log(address);
					$('.address').text("현재위치 : "+address);
				   for(let i=0;i<data.list.length;i++){
		            	let ul = $('<ul>', {class: 'groupMemberTheme',id:'blind'}).appendTo('.list');
						let li = $('<li>', {id: 'a', text:data.list[i].themeMemberName}).appendTo(ul);
						$('<span>',{class:"storage",id:"grandFather",text:gCode}).appendTo(ul);
						$('<span>',{class:"storage",id:"father",text:father}).appendTo(ul);
						$('<span>',{class:"storage",id:"fatherClass",text:fatherClass}).appendTo(ul);
						$('<span>',{class:"storage",id:"dataGroupCode",text:gCode}).appendTo(ul);
						$('<span>',{class:"storage",id:"dataMemberCode",text:mCode}).appendTo(ul);
		            }
				   let ul = $('<ul>', {class: 'open',id:mCode}).appendTo('.list');
					$('<li>', { text: " + "}).appendTo(ul);
					$('<span>',{class:"storage",id:"dataGroupCode",text:gCode}).appendTo(ul);
					$('<span>',{class:"storage",id:"dataMemberCode",text:mCode}).appendTo(ul);
					$('<span>',{class:"storage",id:"father",text:father}).appendTo(ul);
					$('<span>',{class:"storage",id:"fatherClass",text:fatherClass}).appendTo(ul);
			   }
		   })
		   return;
	   }
	   else{
		   console.log("지나감");
		   let gCode=$('.list > ul:first-child').find("#dataGroupCode").text();
		   let mCode=$('.list > ul:first-child').find("#dataMemberCode").text();
		   let father=$('.list > ul:first-child').children('#a').text(); // 자신의
																			// 이름
																			// 아들의
																			// 아빠는
																			// 자신,아들의
														// 할아버지는 자신의 아빠
		   let grandFather=$('.list > ul:first-child').find('#grandFather').text();
		   console.log(grandFather);
		   $.ajax({
			   url:'/TeamProject/Group/themeList',
			   type:"post",
			   data:{
				   type:'front',
				   groupCode:gCode,
				   memberCode:mCode,
				   theme:grandFather
			   },
			   success:function(data){
				   console.log(data);
				   if(data.list.length==0){
					   return
				   }
				   $('.list').empty();
				   let newAddress='';
					for (let i=0;i<cnt-2;i++){
						newAddress=newAddress+result[i]+'/';
					}
					address=newAddress;
					console.log(address);
					$('.address').text("현재위치 : "+address);
				   for(let i=0;i<data.list.length;i++){
		            	let ul = $('<ul>', {class: 'groupMemberTheme'}).appendTo('.list');
						let li = $('<li>', {id: 'a', text:data.list[i].themeMemberName}).appendTo(ul);
						$('<span>',{class:"storage",id:"grandFather",text:grandFather}).appendTo(ul);
						$('<span>',{class:"storage",id:"father",text:father}).appendTo(ul);
						$('<span>',{class:"storage",id:"dataGroupCode",text:gCode}).appendTo(ul);
						$('<span>',{class:"storage",id:"dataMemberCode",text:mCode}).appendTo(ul);
		            }
			   }
		   })
	   }
   }
   
   $('.back').click(function(){
	   let selectOption=$('.category option:selected').val();
	   if(selectOption=="theme"){
		   $(this).themeGoBack();
	   }
	   else if(selectOption=="group"){
		   alert("그룹뒤로가기");
		   $(this).groupBack();
	   }
     
   })

    $(document).on("contextmenu",function(e){
        return false;
    });


   
   $(document).on('mousedown','.folder',function(e) {
	      if(e.which ==3){
	           let ul =$('<ul>',{class : "menuBox"}).appendTo($(this));
	           $('<li>',{class:"menuBoxChild",id:"addSuperTheme",text:"상위 테마 지정"}).appendTo(ul);
	           $('<li>',{class:"menuBoxChild",id:"changeTheme",text:"테마변경"}).appendTo(ul);
	           $('<li>',{class:"menuBoxChild",id:"deleteTheme",text:"테마삭제"}).appendTo(ul);
	      }
	      var sWidth = window.innerWidth;
	      var sHeight = window.innerHeight;

	      var oWidth = $('.menuBox').width();
	      var oHeight = $('.menuBox').height();

	      // 레이어가 나타날 위치를 셋팅한다.
	      var divLeft = e.clientX ;
	      var divTop = e.clientY;

	      $('.menuBox').css({
	         "top": divTop,
	         "left": divLeft,
	         "position": "fixed"
	      }).show();
	      isMenuBoxOn=true;
	   });   
	   
	   $(document).on('mousedown', '#exit', function() {
	      $('.menuBox').remove();
	      isMenuBoxOn=false;
	   });
	   
	   $(document).on('mousedown','#addSuperTheme',function(e){
		   e.stopPropagation();

		   let name=$(this).closest('.folder').children('#a').text();
		   let instance=$(this).closest('.folder');
		   $('.menuBox').remove();
	      
	       $('#dynamicMessage').empty();
	       $('<li>', {text: "상위 테마명을 지정하십시오."}).prependTo('#dynamicMessage');
	       $('#indexPopupText').css("display","block");
	       $('#indexPopupText').val('')
	       $('.indexPopup').css("display","block");
	       $(document).one('mousedown', '#indexPopupOkayBtn', function() {
	        // 상위 테마 지정 작업 수행
	    	   let value = $('#indexPopupText').val();
	    	   console.log(name);
		    	 console.log(value);
	    	   $.ajax({
		        	 url:"/TeamProject/theme/setRelation",
		        	 type:"post",
		        	 data:{
		        		 superThemeName:value,
		        		 themeName:name
		        	 },
		        	 success:function(data){
		        		 console.log(data);
		        		 let str="이미 해당 테마를 가지고 있습니다.";
		        		 if(String(data.trim())==str.trim()){
		        			 $('.indexMessagePopup').css("display","block");
		        			 $('#memberCheckMessage').text(str);
		        			 setTimeout(function() {
		        				 $('.indexMessagePopup').css("display","none");
		        			}, 3000);
		        			return;
		        		 }
		        		 $('.indexPopup').css("display", "none");
		        		 instance.remove();
		        		 
		        	 }
		         })
	       })
	     
	     
	       isMenuBoxOn=false;
	   });
	   
	   $(document).on('mousedown','#changeTheme',function() {
		   let name=$(this).closest('.folder').children('#a').text();
		   let instance=$(this).closest('.folder').children('#a');
	      $('.menuBox').remove();
	      
	      $('#dynamicMessage').empty();
	      $('<li>', {id:"changeThemeName",text: "변경하실 테마명을 입력하십시오."}).prependTo('#dynamicMessage');
// $('<input>',{id:"indexPopupText",type:"text"}).appendTo($('<ul>').appendTo('.indexPopup'))
	      $('.indexPopup').css("display", "block");
	      $(document).one('mousedown', '#indexPopupOkayBtn', function() {
	    	  let value = $('#indexPopupText').val();
	    	  console.log(name);
	    	  console.log(value);
	    	  $.ajax({
		        	 url:"/TeamProject/theme/updateThemeTitle",
		        	 type:"post",
		        	 data:{
		        		 superThemeName:value,
		        		 themeName:name
		        	 },
		        	 success:function(data){

		        		 let str="이미 해당 테마를 가지고 있습니다.";
		        		 if(String(data.trim())==str.trim()){
		        			 console.log("d");
		        			 $('.indexMessagePopup').css("display","block");
		        			 $('#memberCheckMessage').text(str);
		        			 setTimeout(function() {
		        				 $('.indexMessagePopup').css("display","none");
		        			}, 3000);
		        			return;
		        		 }
		        		 instance.text(value);
		        		 $('.indexPopup').css("display", "none");
		        	 }
		         })
	      })

	      isMenuBoxOn=false;
	   });
	   
	   $(document).on('mousedown','#deleteTheme',function() {
		  let value=$(this).closest('.folder').children('#a').text();
		  let instance=$(this).closest('.folder');
	      $('.menuBox').remove();
	      
	      $('#dynamicMessage').empty();
	      $('<li>', {text: "테마를 삭제하시겠습니까?"}).prependTo('#dynamicMessage');
	      $('.indexPopup').css("display", "block");
	      $('#indexPopupText').hide();
	      $(document).one('mousedown', '#indexPopupOkayBtn', function() {
	    	 
	         $.ajax({
	        	 url:"/TeamProject/theme/deleteTheme",
	        	 type:"post",
	        	 data:{
	        		 theme:value
	        	 },
	        	 success:function(data){
	        		 console.log(data.trim()=="1");
	        		 if(data.trim()!="1"){
	        			 return;
	        		 }
	        		 instance.remove();
	        		 $('.indexPopup').css("display","none");
	        	 }
	         })
	      })
	      isMenuBoxOn=false;
	   });
	   


	   $(document).on("mousedown", "#indexPopupCancelBtn", function() {
	      $('.indexPopup').hide();
	   })

	   $(document).on('mousedown','.groupFolder',function(e) {
            if(e.which ==3){
                 let ul =$('<ul>',{class : "groupMenuBox"}).appendTo($(this));
                 $('<li>',{class:"groupMenuBoxChild",id:"exitGroup",text:"나가기"}).appendTo(ul);
            }
            var sWidth = window.innerWidth;
            var sHeight = window.innerHeight;

            var oWidth = $('.groupMenuBox').width();
            var oHeight = $('.groupMenuBox').height();

            // 레이어가 나타날 위치를 셋팅한다.
            var divLeft = e.clientX ;
            var divTop = e.clientY;

            $('.groupMenuBox').css({
               "top": divTop,
               "left": divLeft,
               "position": "fixed"
            }).show();
            isMenuBoxOn=true;
         });  
      
      $(document).on('mousedown','#exitGroup',function() {
    	  let value=$(this).closest('.groupFolder').children('.storage').attr('id');
    	  let instance=$(this).closest('.groupFolder');
    	  console.log(value);
            $('.groupMenuBox').remove();
            $.ajax ({
               url : "/TeamProject/Group/withdrawGroup",
               type: "post",
               data: {
                  groupCode: value
               },
               success: function(data) {
                 if(data.trim()=='true') {      // 방장이면
                	console.log("t");
                    $('.indexMessagePopup').css("display", "block");
                    $('.indexMessagePopup').empty();
                    $('<li>', {text: "그룹장을 위임한 후에 나가셔야 합니다."}).prependTo('.indexMessagePopup');
                    $('.indexPopupText').hide();
                   
                    setTimeout(function() {
                  	   $('.indexMessagePopup').css("display","none");
        			}, 3000);
                 }
                 else if(data.trim()=='false') {   // 일반 회원이면

                 	console.log("f");
                    $('.indexPopup').css("display", "block");
                    $('#dynamicMessage').empty();
                    $('<li>', {text:"정말로 나가시겠습니까?"}).prependTo('#dynamicMessage');
                    $('#indexPopupText').hide();
                    $(document).one("mousedown", "#indexPopupOkayBtn", function() {
                       $('.indexPopup').hide();
                       instance.remove();
                    })
                    setTimeout(function() {
                   	   $('.indexMessagePopup').css("display","none");
         			}, 3000);
                 }
                 else{
                	 $('.indexPopup').css("display", "block");
                     $('#dynamicMessage').empty();
                     let li=$('<li>', {text:"당신은 방장입니다 정말로 나가시겠습니까?"}).prependTo('#dynamicMessage');
                     $('#indexPopupText').hide();
                     $(document).one("mousedown", "#indexPopupOkayBtn", function() {
                        $('.indexPopup').hide();
                        instance.remove();
                     })
                     setTimeout(function() {
                    	   $('.indexMessagePopup').css("display","none");
          			}, 3000);
                 }
               }
            })
            isMenuBoxOpen = false;
         });
      
      /* --------------------------------------------------------------------------------------------- */
      
      $(document).on('mousedown','.groupMemberList',function(e) {
            if(e.which ==3){
                 let ul =$('<ul>',{class : "groupMemberListMenuBox"}).appendTo($(this));
                 $('<li>',{class:"groupMemberListMenuBoxChild",id:"expelGroupMember",text:"추방하기"}).appendTo(ul);
                 $('<li>',{class:"groupMemberListMenuBoxChild",id:"sendMessageGroupMember",text:"쪽지 보내기"}).appendTo(ul);
                 $('<li>',{class:"groupMemberListMenuBoxChild",id:"deligateGroupLeaderGroupMember",text:"그룹장 권한 위임하기"}).appendTo(ul);
            }
            var sWidth = window.innerWidth;
            var sHeight = window.innerHeight;

            var oWidth = $('.groupMemberListMenuBox').width();
            var oHeight = $('.groupMemberListMenuBox').height();

            // 레이어가 나타날 위치를 셋팅한다.
            var divLeft = e.clientX ;
            var divTop = e.clientY;

            $('.groupMemberListMenuBox').css({
               "top": divTop,
               "left": divLeft,
               "position": "fixed"
            }).show();
            isMenuBoxOn=true;
         });
     
         $(document).on('mousedown','#sendMessageGroupMember',function(e) {
        	 e.stopPropagation();
             $('.groupMenuBox').remove();
             let ID=$(this).closest('.groupMemberListMenuBox').siblings('#a').text();
             
             $('.replyBox').css('display','block');
             $('#receiver').val(ID);
             $(document).one('click','#replyAtReply',function(){
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
             })
             
         })
      /* 추방하기 */
      $(document).on('mousedown','#expelGroupMember',function() {
            $('.groupMenuBox').remove();
            let instance= $(this).closest('.groupMemberList');
            let id = $(this).closest('.groupMemberList').find('#a').text();
            let gCode=$(this).closest('.groupMemberList').find('#dataGroupCode').text();
            let mCode=$(this).closest('.groupMemberList').find('#dataMemberCode').text();
            console.log(id);
            console.log(gCode);
            console.log(mCode);
            $.ajax ({
               url : "/TeamProject/Group/expelGroupMember",
               type: "post",
               data: {
                  MemberID: id,
                  groupCode: gCode,
                  memberCode: mCode
               },
               success: function(data) {
                  console.log(data);
                if(data.leaderCheck=="true" && data.object=="me") {
                   console.log(data);
                   $('#dynamicMessage2').empty();
                   $('<li>', {text: "자기 자신을 추방할 수 없습니다."}).prependTo('#dynamicMessage2');
                   $('.indexMessagePopup').css("display", "block");
                   isMenuBoxOn = false;
                }
                else if(data.leaderCheck=="true" && data.object=="other") {
                   console.log(data);
                   // 이 부분에 일반 회원 추방 기능 수행
                   // 리스트에 있는 해당 회원 삭제
                   $(this).closest('.groupMemberList').find('#a').remove();
                   $('#dynamicMessage2').empty();
                    $('<li>', {text: "회원 추방을 완료하였습니다."}).prependTo('#dynamicMessage2');
                    instance.remove();
                    $('.indexMessagePopup').css("display", "block");
                    isMenuBoxOn = false;
                }
                else if(data.leaderCheck=="false" && data.object==null) {
                   console.log(data);
                   $('#dynamicMessage2').empty();
                   $('<li>', {text: "일반 회원은 추방을 수행할 수 없습니다."}).prependTo('#dynamicMessage2');
                   $('.indexMessagePopup').css("display", "block");
                   isMenuBoxOn = false;
                }
                $(document).one("mousedown", "#indexMessagePopupOkayBtn", function() {
                    $('.indexMessagePopup').css("display", "none");
                 })
                 
               }
            })
         });
      
      /* 그룹장 위임하기 */
      $(document).on('mousedown', '#deligateGroupLeaderGroupMember', function() {
         
         $('.groupMenuBox').remove();
         let gCode=$(this).closest('.groupMemberList').find("#dataGroupCode").text();
         let mCode=$(this).closest('.groupMemberList').find("#dataMemberCode").text();
         console.log(gCode);
         console.log(mCode);
         $.ajax ({
            url : "/TeamProject/Group/delegateGroupLeader",
            type: "post",
            data: {
               groupCode: gCode,
               memberCode: mCode
            },
            success: function(data) {
            	console.log(data);
               if(data.leaderCheck=='true' && data.object=="me") {
                   $('.indexMessagePopup').empty();
                   let ul=$('<ul>').appendTo($('.indexMessagePopup'));
                   $('<li>', {text: "자신에게 권한을 위임할 수 없습니다."}).prependTo(ul);
                   $('.indexMessagePopup').css("display", "block");
                   setTimeout(function() {
                	   $('.indexMessagePopup').css("display","none");
      			}, 3000);
                   
                }
                else if(data.leaderCheck=='true' && data.object=="other") {
                	$('.indexMessagePopup').empty();
                    let ul=$('<ul>').appendTo($('.indexMessagePopup'));
                    $('<li>', {text: "권한이 위임되었습니다."}).prependTo(ul);
                    $('.indexMessagePopup').css("display", "block");
                    setTimeout(function() {
                 	   $('.indexMessagePopup').css("display","none");
       			}, 3000);
                  
                }
                else if(data.leaderCheck=='false' && data.object==null) {
                	$('.indexMessagePopup').empty();
                    let ul=$('<ul>').appendTo($('.indexMessagePopup'));
                    $('<li>', {text: "권한 위임을 수행할 수 없습니다."}).prependTo(ul);
                    $('.indexMessagePopup').css("display", "block");
                    setTimeout(function() {
                 	   $('.indexMessagePopup').css("display","none");
       			}, 3000);      
                }
            }
         })
      })
      $(document).on("mousedown", "#indexMessagePopupOkayBtn", function() {
                      $('.indexMessagePopup').hide();
                   })
      isMenuBoxOn = false;
     
     if(isMenuBoxOn=true) {
	 $('.page').click(function(e) {
	      e.preventDefault();
	         $('.menuBox').remove();
	         $('.groupMenuBox').remove();
	         $('.groupMemberListMenuBox').remove();
	         isMenuBoxOn=false;
	      })
	}
	   
	})