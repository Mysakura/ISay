/**
 * Created by dong on 2018/1/26.
 */

$(function(){

	var commentVar = {
			postId:"",
	};
	var replyVar = {
			commentId:"",
			otherId:"",
			other:""
	};
	
    function createReplyDiv(name){
        var $replyDiv = $('<div class="well pd-release-comment-wrap pd-release-reply-wrap">'+
            '<div id="say-reply" class="comment-input reply-input" contenteditable="true" data-tip="回复 '+ name +'"></div>'+
            '<div class="comment-tools">'+
            '<a class="tool-btn" href="javascript:;" id="leaveReply"><span class="glyphicon glyphicon-send"></span> 回复</a>&nbsp;'+
            '<a class="tool-btn" href="javascript:;">'+
            '<span class="glyphicon glyphicon-picture"></span> 添加图片'+
            '<input class="file-input" type="file" accept="image/jpeg,image/png,image/gif" name="imgFile" id="replyFile">'+
            '</a>'+
            '</div>'+
            '</div>');
        return $replyDiv;
    }

    /**
     * 评论
     */
    function createCommentHtml(postId,commentId,replyNum,page,isLast,userId,nickname,userPhoto,content,time){
        var $comment = $('<li class="list-group-item" id="'+ commentId +'">'+
            '<div class="user-info">'+
            '<div class="user-photo">'+
            '<img src="'+ isay.preUrl + '/' + userPhoto +'">'+
            '</div>'+
            '<div class="user-extra">'+
            '<a href="'+ isay.preUrl + '/user/' + userId +'">'+ nickname +'</a>'+
            '<span class="comment-time">'+ isay.formatTime(time) +'</span>'+
            '</div>'+
            '<div class="user-operate">&nbsp;'+
            '<a href="javascript:;" class="user-operate-btn" data-role="cReply" data-cid="'+ commentId +'" data-uname="'+ nickname +'" data-uid="'+ userId +'">回复</a>&nbsp;'+
            '<a href="javascript:;" class="user-operate-btn" data-role="cDel" data-cid="'+ commentId +'" data-pid="'+ postId +'">删除</a>&nbsp;'+
            '<a href="javascript:;" class="show-reply" data-role="showReply" data-cid="'+ commentId +'" data-rnum="'+ replyNum +'" data-page="'+ page +'" data-isLast="'+ isLast +'">回复列表&nbsp;('+ replyNum +')</a>'+
            '</div>'+
            '</div>'+
            '<div class="comment">'+ content +'</div>'+
            '<div class="pd-reply-wrap"><ul class="list-unstyled"></ul></div>'+
            '</li>');
        return $comment;
    }
    /**
     * 已删除的评论
     */
    function createCommentHtmlDelete(commentId,userId,nickname,userPhoto,time){
    	var $comment = $('<li class="list-group-item" id="'+ commentId +'">'+
    			'<div class="user-info">'+
    			'<div class="user-photo">'+
    			'<img src="'+ isay.preUrl + '/' + userPhoto +'">'+
    			'</div>'+
    			'<div class="user-extra">'+
    			'<a href="'+ isay.preUrl + '/user/' + userId +'">'+ nickname +'</a>'+
    			'<span class="comment-time">'+ isay.formatTime(time) +'</span>'+
    			'</div>'+
    			'</div>'+
    			'<div class="comment comment-del">该评论已被删除！</div>'+
    	'</li>');
    	return $comment;
    }

    /**
     * 回复
     */
    function createReplyHtml(meId, me, otherId, other, content, time, commentId, replyId){
        var $reply = $('<li class="pd-reply" id="'+ replyId +'">'+
            '<div class="user-info">'+
            '<a href="'+ isay.preUrl + '/user/' + meId +'">'+ me +'</a>'+
            '<span>&nbsp;回复&nbsp;</span>'+
            '<a href="'+ isay.preUrl + '/user/' + otherId +'">'+ other +'</a>'+
            '</div>'+
            '<div class="reply">'+ content +'</div>'+
            '<div class="user-operate">'+
            '<span class="reply-time">'+ isay.formatTime(time) +'</span>'+
            '<a href="javascript:;" class="user-operate-btn" data-role="rReply" data-cid="'+ commentId +'" data-uname="'+ me +'" data-uid="'+ meId +'">回复</a>'+
            '<a href="javascript:;" class="user-operate-btn" data-role="rDel" data-rid="'+ replyId +'" data-cid="'+ commentId +'">删除</a>'+
            '</div>'+
            '</li>');
        return $reply;
    }
    
    /**
     * 已删除的回复
     */
    function createReplyHtmlDelete(meId, me, otherId, other, time, replyId){
    	var $reply = $('<li class="pd-reply" id="'+ replyId +'">'+
    			'<div class="user-info">'+
    			'<a href="'+ isay.preUrl + '/user/' + meId +'">'+ me +'</a>'+
    			'<span>&nbsp;回复&nbsp;</span>'+
    			'<a href="'+ isay.preUrl + '/user/' + otherId +'">'+ other +'</a>'+
    			'</div>'+
    			'<div class="reply reply-del">该回复已被删除！</div>'+
    			'<div class="user-operate">'+
    			'<span class="reply-time">'+ isay.formatTime(time) +'</span>'+
    			'</div>'+
    	'</li>');
    	return $reply;
    }

    /**
     * 提交评论
     */
    $('#leaveComment').click(function(){
    	var $t = $(this);
    	var postId = $t.attr('data-pid');
        var $input = $('#say-comment');
        var content = $input.html();
        var url = isay.preUrl + '/addComment';
        var args = {"commentContent":content,"post.postId":postId};
        $.getJSON(url,args,function(res){
        	if(res.code == 0){
        		if(res.data != undefined){
        			isay.pageTip("评论成功！");
        			// 更新前台
        			$t.parents('.well').siblings('.pd-comment-wrap').children('ul').prepend(createCommentHtml(postId,res.data.commentId,0,1,0,res.data.user.userId,res.data.user.nickname,res.data.user.userPhoto,content,res.data.commentTime));
        			$input.html('');
        		}else{
        			isay.pageTip("评论失败！");
        		}
        	}else{
    			isay.pageTip(res.msg);
    		}
        });
    });

    /**
     * 上传评论图片
     */
    $(document).on('change','#commentFile',function(){
    	$.ajaxFileUpload({
    		url: isay.preUrl + '/upload_comment_img', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'commentFile', //文件上传域的ID
            dataType: 'content', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
            	var str = new String(data);
            	//去除不需要的，只留下json字符串
            	var result = str.replace('<pre style="word-wrap: break-word; white-space: pre-wrap;">', '')
        		.replace('</pre>', '');
            	var json = JSON.parse(result);
            	if(json.code == 0){
        			var $img = $('<img class="mr-img" src="'+ json.data.url +'" />');
        			$('#say-comment').append($img);
        		}else{
        			isay.pageTip(json.msg);
        		}
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
            	//$('#imgInfo').text("上传出错啦\n" + e);
            }
    	});
    });

    /**
     * 提交回复
     */
    $(document).on('click','#leaveReply',function(){
    	var $t = $(this);
        var $input = $('#say-reply');
        var content = $input.html();
        var otherId = replyVar.otherId;
        var commentId = replyVar.commentId;
        var url = isay.preUrl + '/addReply';
        var args = {"replyContent":content, "targetUser.userId":otherId, "postComment.commentId":commentId};
        $.getJSON(url, args, function(res){
        	if(res.code == 0){
        		if(res.data != undefined){
        			isay.pageTip("回复成功！");
        			// 更新前台
        			$t.parents('.pd-reply-wrap').find('ul').append(createReplyHtml(res.data.replyUser.userId, res.data.replyUser.nickname, otherId, replyVar.other, content, res.data.replyTime, commentId, res.data.replyId));
        			$('.pd-release-reply-wrap').remove();
        		}else{
        			isay.pageTip("回复失败！");
        		}
        	}else{
    			isay.pageTip(res.msg);
    		}
        });
    });

    /**
     * 上传回复图片
     */
    $(document).on('change','#replyFile',function(){
    	$.ajaxFileUpload({
    		url: isay.preUrl + '/upload_comment_img', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'replyFile', //文件上传域的ID
            dataType: 'content', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
            	var str = new String(data);
            	//去除不需要的，只留下json字符串
            	var result = str.replace('<pre style="word-wrap: break-word; white-space: pre-wrap;">', '')
        		.replace('</pre>', '');
            	var json = JSON.parse(result);
            	if(json.code == 0){
        			var $img = $('<img class="mr-img" src="'+ json.data.url +'" />');
        			$('#say-reply').append($img);
        		}else{
        			isay.pageTip(json.msg);
        		}
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
            	//$('#imgInfo').text("上传出错啦\n" + e);
            }
    	});
    });

    /**
     * 在评论里回复-显示回复框
     */
    $(document).on('click','.user-operate .user-operate-btn[data-role="cReply"]',function(){
        // 每次生成回复框，都先删除已经存在的，保证页面只存在一个回复框
        $('.pd-release-reply-wrap').remove();
        replyVar.commentId = $(this).attr('data-cid');
        replyVar.other = $(this).attr('data-uname');
        replyVar.otherId = $(this).attr('data-uid');
        $(this).parents('li').find('.pd-reply-wrap').append(createReplyDiv(replyVar.other));
        $('#say-reply').focus();
    });

    /**
     * 在回复里回复-显示回复框
     */
    $(document).on('click','.user-operate .user-operate-btn[data-role="rReply"]',function(){
        // 每次生成回复框，都先删除已经存在的，保证页面只存在一个回复框
        $('.pd-release-reply-wrap').remove();
        replyVar.commentId = $(this).attr('data-cid');
        replyVar.other = $(this).attr('data-uname');
        replyVar.otherId = $(this).attr('data-uid');
        $(this).parents('.pd-reply-wrap').append(createReplyDiv(replyVar.other));
        $('#say-reply').focus();
    });
    
    /**
     * 删除评论
     */
    $(document).on('click','.user-operate .user-operate-btn[data-role="cDel"]',function(){
    	var pid = $(this).attr('data-pid');
        var cid = $(this).attr('data-cid');
        var $body = $(this).parents('#'+cid);
        var url = isay.preUrl + '/delComment';
        var args = {"commentId":cid, "post.postId":pid};
        $.getJSON(url, args, function(res){
        	if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("删除成功！");
    				$body.remove();
    			}else{
    				isay.pageTip("删除失败！");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
        });
    });
    
    /**
     * 删除回复
     */
    $(document).on('click','.user-operate .user-operate-btn[data-role="rDel"]',function(){
    	var cid = $(this).attr('data-cid');
    	var rid = $(this).attr('data-rid');
    	var $body = $(this).parents('#'+rid);
    	var url = isay.preUrl + '/delReply';
    	var args = {"replyId":rid,"postComment.commentId":cid};
        $.getJSON(url, args, function(res){
        	if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("删除成功！");
    				$body.remove();
    			}else{
    				isay.pageTip("删除失败！");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
        });
    });
    
    /**
     * 回复列表
     */
    $(document).on('click','.user-operate .show-reply[data-role="showReply"]',function(){
    	var $t = $(this);
    	var cid = $t.attr('data-cid');
    	var rnum = $t.attr('data-rnum');
    	var page = $t.attr('data-page');
    	var isLast = $t.attr('data-isLast');
    	if(rnum == 0){
    		isay.pageTip("该评论没有回复！");
    		return;
    	}
    	if(isLast == 0){
    		isay.pageTip("没有更多数据！");
    		return;
    	}
    	var url = isay.preUrl + '/getPostReplies';
    	var args = {"commentId":cid,"pageNo":page};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data != undefined){
    				$t.attr('data-page',res.data.nextPage);
    				$t.attr('data-isLast',res.isLast);
    				for(var i = 0; i < res.data.length; i++){
    					if(res.data[i].isDelete == 1)
    						$t.parents('.user-info').siblings('.pd-reply-wrap').find('ul').append(createReplyHtmlDelete(
    								res.data[i].replyUser.userId, res.data[i].replyUser.nickname,
    								res.data[i].targetUser.userId, res.data[i].targetUser.nickname,
    								res.data[i].replyTime, res.data[i].replyId));
    					else
    						$t.parents('.user-info').siblings('.pd-reply-wrap').find('ul').append(createReplyHtml(
    								res.data[i].replyUser.userId, res.data[i].replyUser.nickname,
    								res.data[i].targetUser.userId, res.data[i].targetUser.nickname,
    								res.data[i].replyContent, res.data[i].replyTime,
    								res.data[i].postComment.commentId, res.data[i].replyId));
    						
    				}
    			}else{
    				isay.pageTip("获取回复列表失败！");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    });
    
    /**
     * 评论列表
     */
    $(document).on('click','#loadComment',function(){
    	var $t = $(this);
    	var pid = $t.attr('data-pid');		// 帖子id
    	var page = $t.attr('data-pageNo');	// 要检索的页码
    	var isLast = $t.attr('data-isLast');// 是否最后一页
    	if(isLast == 0){
    		isay.pageTip("没有更多数据！");
    		return;
    	}
    	var url = isay.preUrl + '/getPostComments';
    	var args = {"postId":pid,"pageNo":page};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data != undefined){
    				$t.attr('data-pageNo',res.nextPage);
    				$t.attr('data-isLast',res.isLast);
    				for(var i = 0; i < res.data.length; i++){
    					if(res.data[i].isDelete == 1)
    						$t.parent().siblings('ul').append(createCommentHtmlDelete(
    								res.data[i].commentId,
    								res.data[i].user.userId,res.data[i].user.nickname,
	    							res.data[i].user.userPhoto,res.data[i].commentTime));
    					else
	    					$t.parent().siblings('ul').append(createCommentHtml(
	    							res.data[i].post.postId,
	    							res.data[i].commentId,res.data[i].replyNum,1,1,
	    							res.data[i].user.userId,res.data[i].user.nickname,
	    							res.data[i].user.userPhoto,
	    							res.data[i].commentContent,res.data[i].commentTime));
    				}
    			}else{
    				isay.pageTip("获取评论列表失败！");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    });

});
