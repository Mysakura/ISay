/**
 * Created by biubiu on 2017/9/20.
 */

$(function(){
    //甩锅
    $('#iPot').click(function(){
        $('#potModal').modal('show');
    });
    //闲聊
    $('#iChat').click(function(){
        $('#chatModal').modal('show');
        
    });
    
    //回复
    var replyVar = {};
    $(document).on('click','.iReply',function(){
    	$('#replyModal').modal('show');
        $('#replyTarget').text("Mary");
        replyVar.userId = $(this).attr('data-uid');
        replyVar.nickname = $(this).attr('data-uname');
        replyVar.chatId = $(this).attr('data-chatid');
    });


    // 发表闲聊
    $('#putChat').click(function(){
    	var chatContent = $('#chatContent').val();
        var chatTime = new Date().getTime();
        var url = isay.preUrl + '/card/add_chat';
        var args = {"chatContent":chatContent,"chatTime":chatTime};
        $.getJSON(url,args,function(res){
        	if(res.code == 0){
        		if(res.data == 1){
        			isay.pageTip("添加成功");
        			setTimeout(() => {
						location.reload(true);
					}, 500);
        		}
        	}else{
        		isay.pageTip(res.msg);
        	}
        });
    });

    // 发表回复
    $('#putReply').click(function(){
    	var replyContent = $('#replyContent').val();
        var replyTime = new Date().getTime();
        var userId = replyVar.userId;
        var chatId = replyVar.chatId;
        var url = isay.preUrl + '/card/add_chat_reply';
        var args = {"replyContent":replyContent,"replyTime":replyTime,"targetUser.userId":userId,"chat.chatId":chatId};
        $.getJSON(url,args,function(res){
        	if(res.code == 0){
        		if(res.data == 1){
        			isay.pageTip("添加成功");
        			setTimeout(() => {
						location.reload(true);
					}, 500);
        		}
        	}else{
        		isay.pageTip(res.msg);
        	}
        });
    });

    // 删除闲聊
    $(document).on('click','.chat-wrap .iDelChat',function(){
    	var chatId = $(this).attr('data-chatid');
    	var url = isay.preUrl + '/card/del_chat';
    	var args = {"chatId":chatId};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
        		if(res.data == 1){
        			isay.pageTip("删除成功！");
        			setTimeout(() => {
						location.reload(true);
					}, 500);
        		}
        	}else{
        		isay.pageTip(res.msg);
        	}
    	});
    });
    
    // 删除闲聊回复
    $(document).on('click','.chat-wrap .iDelReply',function(){
    	var replyId = $(this).attr('data-replyid');
    	var url = isay.preUrl + '/card/del_chat_reply';
    	var args = {"replyId":replyId};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
        		if(res.data == 1){
        			isay.pageTip("删除成功！");
        			setTimeout(() => {
						location.reload(true);
					}, 500);
        		}
        	}else{
        		isay.pageTip(res.msg);
        	}
    	});
    });
    
    // 闲聊列表
    $('#loadMoreChat').click(function(){
    	var $t = $(this);
    	var isLast = $t.attr('data-isLast');
    	if(isLast == 0){
    		isay.pageTip("没有更多数据！");
    		return;
    	}
    	var pageNo = $t.attr('data-pageNo');
    	var role = $t.attr('data-role');
    	var url;
    	if(role == "my"){
    		url = isay.preUrl + '/card/my_chat_ajax';
    	}else{
    		url = isay.preUrl + '/card/throw_pot_chat_ajax';
    	}
    	var args = {"page":pageNo};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			$t.attr('data-pageNo', res.nextPage);
				$t.attr('data-isLast', res.isLast);
        		if(res.data != undefined){
        			var len = res.data.length;
        			for(var i = 0; i < len; i++){
        				var isDelete = res.data[i].isDelete;
        				var chatId = res.data[i].chatId;
        				var chatContent = res.data[i].chatContent;
        				var chatTime = res.data[i].chatTime;
        				var userId = res.data[i].user.userId;
        				var nickname = res.data[i].user.nickname;
        				var userPhoto = res.data[i].user.userPhoto;
        				var replys = res.data[i].replies;
        				if(isDelete == "0"){
        					$('.chat-wrap').append(createChat(chatId,chatContent,userId,nickname,userPhoto,chatTime,replys));
        				}else{
        					$('.chat-wrap').append(createDelChat(chatId,userId,nickname,userPhoto,chatTime));
        				}
        				
        			}
        			
        		}
        	}else{
        		isay.pageTip(res.msg);
        	}
    	});
    	
    });
    
    function createChat(chatId,chatContent,userId,nickname,userPhoto,chatTime,replys){
    	var $chat = '<li class="list-group-item chat-item" id="'+ chatId +'">' +
    			'<div><div class="pull-left">' +
    			'<img class="chat-user-photo" src="'+ isay.preUrl + '/' + userPhoto +'"></div>' +
    			'<div class="chat-user-info">' +
    			'<p><a href="'+ isay.preUrl + '/user/' + userId +'">'+ nickname +'</a>' +
    			'<span class="tp-time">发表于'+ isay.formatTime(chatTime) +'</span>' +
    			'<a href="javascript:;" class="iReply" data-uid="' + userId +'" data-uname="'+ nickname +'" data-chatid="'+ chatId +'">回复</a>' +
    			'<a href="javascript:;" class="iDelChat" data-chatid="'+ chatId +'">删除</a></p>' +
    			'<p class="chat-content">'+ chatContent +'</p></div>' +
    	'<ul class="list-unstyled chat-item-reply-wrap">';
    	var len = replys.length;
    	for(var i = 0; i < len; i++){
    		var isDelete = replys[i].isDelete;
    		var replyId = replys[i].replyId;
    		var replyContent = replys[i].replyContent;
    		var replyTime = replys[i].replyTime;
    		var fid = replys[i].replyUser.userId;
    		var fname = replys[i].replyUser.nickname;
    		var tid = replys[i].targetUser.userId;
    		var tname = replys[i].targetUser.nickname;
    		if(isDelete == "0"){
    			$chat += createReply(replyId,replyContent,replyTime,fid,fname,tid,tname,chatId);
    		}else{
    			$chat += createDelReply(replyTime,fid,fname,tid,tname);
    		}
    		
    	}
    	var $foot = '</ul></div></li>';
    	return $chat + $foot;
    }
    function createDelChat(chatId,userId,nickname,userPhoto,chatTime){
    	var $chat = '<li class="list-group-item chat-item" id="'+ chatId +'">' +
    			'<div><div class="pull-left">' +
    			'<img class="chat-user-photo" src="'+ isay.preUrl + '/' + userPhoto +'"></div>' +
    			'<div class="chat-user-info">' +
    			'<p><a href="'+ isay.preUrl + '/user/' + userId +'">'+ nickname +'</a>' +
    			'<span class="tp-time">发表于'+ isay.formatTime(chatTime) +'</span>' +
    			'<p class="chat-content already-del">该闲聊已删除！</p></div>' +
    	'<ul class="list-unstyled chat-item-reply-wrap"></ul></div></li>';
    	return $chat;
    }
    
    function createReply(replyId,replyContent,replyTime,fid,fname,tid,tname,chatId){
    	var $reply = '<li class="reply">' +
    			'<a href="'+ isay.preUrl + '/user/' + fid +'">'+ fname +'</a> 回复 <a href="'+ isay.preUrl + '/user/' + tid +'">'+ tname +'</a>：' +
    			'<p class="reply-content">'+ replyContent +'</p>' +
    			'<span class="tp-time">'+ isay.formatTime(replyTime) +'</span>' +
    			'<a href="javascript:;" class="iReply" data-uid="' + fid +'" data-uname="'+ fname +'" data-chatid="'+ chatId +'">回复</a>' +
    			'<a href="javascript:;" class="iDelReply" data-replyid="'+ replyId +'">删除</a>' +
    	'</li>';
    	return $reply;
    }
    function createDelReply(replyTime,fid,fname,tid,tname){
    	var $reply = '<li class="reply">' +
    			'<a href="'+ isay.preUrl + '/user/' + fid +'">'+ fname +'</a> 回复 <a href="'+ isay.preUrl + '/user/' + tid +'">'+ tname +'</a>：' +
    			'<p class="reply-content already-del">该回复已经删除！</p>' +
    			'<span class="tp-time">'+ isay.formatTime(replyTime) +'</span>' +
    	'</li>';
    	return $reply;
    }

    //送Gift
    $('#giftSelection').change(function(){
        var className = $(this).val();
        $('#showGift').attr('class',className + ' weapon');
    });
    
    $('#putPot').click(function(){
        var url = "";
        var args = {"companyId": companyId};
    });

});