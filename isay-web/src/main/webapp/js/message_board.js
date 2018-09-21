/**
 * Created by dong on 2018/1/25.
 */

$(function(){

    // 存储留言或者回复需要的数据
    var msgVar = {
        // 初始化变量
        init: function(){
            //
        },
        messageId: ""
    };
    var replyVar = {
        // 初始化变量
        init: function(){
            //
        },
        replyId: "",
        messageId: "",
        uid: "",
        uname: ""
    };

    /**
     * 生成回复面板(不完整)
     * @param name
     * @returns {*|jQuery|HTMLElement}
     */
    function createReplyDiv(name){
        var $replyDiv = $('<div class="well message-input-wrap reply-input-wrap" id="messageReplyWrap">' +
            '<div class="message-input reply-input" contenteditable="true" data-tip="回复 '+ name +'"></div>' +
            '<div class="message-tools">' +
            '<a class="tool-btn" href="javascript:;" id="leaveReply"><span class="glyphicon glyphicon-send"></span> 回复</a>&nbsp;' +
            '<a class="tool-btn" href="javascript:;">' +
            '<span class="glyphicon glyphicon-picture"></span> 添加图片' +
            '<input class="file-input" type="file" accept="image/jpeg,image/png,image/gif" name="imgFile" id="replyImgFile">' +
            '</a>' +
            '</div>' +
            '</div>');
        return $replyDiv;
    }

    /**
     * 生成留言内容
     * @param messageId
     * @param content
     * @param messageTime
     * @param userId
     * @param nickname
     * @param userPhoto
     * @returns {*|jQuery|HTMLElement}
     */
    function createMessageHtml(messageId, content, messageTime, userId, nickname, userPhoto){
        var $msgHtml = $('<li class="list-group-item">'+
            '<div class="message-wrap">'+
            '<div class="row">'+
            '<div class="col-md-12">'+
            '<div class="user-photo">'+
            '<img src="'+ isay.preUrl + '/' + userPhoto +'">'+
            '</div>'+
            '<div class="message-info">'+
            '<a href="'+ isay.preUrl + '/user/' + userId +'">'+ nickname +'</a>'+
            '<span>'+ isay.formatTime(messageTime) +'</span>'+
            '</div>'+
            '<div class="message-operate">&nbsp;'+
            '<a href="javascript:;" data-role="reply">回复</a>&nbsp;'+
            '<a href="javascript:;" data-role="delete">删除</a>'+
            '</div>'+
            '</div>'+
            '<div class="col-md-12">'+
            '<div class="message-content">'+ content +'</div>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '</li>');
        return $msgHtml;
    }

    /**
     * 生成回复内容（回复删除按钮不完整）
     * @param meId
     * @param me
     * @param otherId
     * @param other
     * @param content
     * @param time
     * @returns {*|jQuery|HTMLElement}
     */
    function createReplyHtml(meId, me, otherId, other, content, time){
        var $replyHtml = $('<li class="reply-li">'+
            '<div class="user-info">'+
            '<a href="'+ isay.preUrl + '/user/' + meId +'">'+ me +'</a>'+
            '<span>&nbsp;回复&nbsp;</span>'+
            '<a href="'+ isay.preUrl + '/user/' + otherId +'">'+ other +'</a>'+
            '</div>'+
            '<div class="reply-content">'+ content +'</div>'+
            '<div class="reply-operate">'+
            '<span class="reply-time">'+ isay.formatTime(time) +'</span>'+
            '<a href="javascript:;" data-role="reply">回复</a>&nbsp;'+
            '<a href="javascript:;" data-role="delete">删除</a>'+
            '</div>'+
            '</li>');
        return $replyHtml;
    }

    /**
     * 提交留言
     */
    $('#leaveMessage').click(function(){
    	var $t = $(this);
        var $input = $t.parents('.message-input-wrap').find('.message-input');
        var content = $input.html();
        
        var url = isay.preUrl + '/submit_message';
        var args = {"messageContent": content};
        $.getJSON(url, args, function(res){
        	if(res.code == 0){
        		if(res.data != undefined){
        			// 更新前台
        			isay.pageTip("留言成功！");
        			$t.parents('.mb-wrap').children('ul').prepend(createMessageHtml(res.data.messageId, content, res.data.messageTime, res.data.user.userId, res.data.user.nickname, res.data.user.userPhoto));
        			// 清空留言框
        			$input.html('');
        		}else{
        			isay.pageTip("留言失败！");
        		}
        	}else{
    			isay.pageTip(res.msg);
    		}
        });
    });

    /**
     * 上传留言图片
     */
    $(document).on('change','#messageImgFile',function(){
    	$.ajaxFileUpload({
    		url: isay.preUrl + '/upload_message_pic', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'messageImgFile', //文件上传域的ID
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
        			$('#messageImgFile').parents('.message-input-wrap').find('.message-input').append($img);
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
        // $('.reply-input-wrap .reply-input')全局只存在一个
        var $input = $('.reply-input-wrap .reply-input');
        var content = $input.html();
        var url = isay.preUrl + '/submit_message_reply';
        var args = {"mrMessage.messageId": replyVar.messageId, "mrContent":content, "toUser.userId": replyVar.uid};
        $.getJSON(url, args, function(res){
        	if(res.code == 0){
        		if(res.data != undefined){
        			isay.pageTip("回复成功！");
        			// 更新前台
        			$t.parents('.reply-wrap').find('ul').append(createReplyHtml(res.data.fromUser.userId, res.data.fromUser.nickname, replyVar.uid, replyVar.uname, content, res.data.mrTime));
        			// 删除回复框
        			$('#messageReplyWrap').remove();
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
    $(document).on('change','#replyImgFile',function(){
    	$.ajaxFileUpload({
    		url: isay.preUrl + '/upload_message_pic', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'replyImgFile', //文件上传域的ID
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
        			$('.reply-input-wrap .reply-input').append($img);
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
     * 在留言里回复-显示回复框
     */
    $(document).on('click','.message-operate > a[data-role="reply"]',function(){
        // 每次生成回复框，都先删除已经存在的，保证页面只存在一个回复框
        $('#messageReplyWrap').remove();
        var uname = $(this).attr('data-uname');
        var uid = $(this).attr('data-uid');
        var messageId = $(this).attr('data-mid');
        replyVar.messageId = messageId;
        replyVar.uid = uid;
        replyVar.uname = uname;
        $(this).parents('li').find('.reply-wrap').append(createReplyDiv(uname));
        $('#messageReplyWrap .message-input').focus();
    });

    /**
     * 在回复里回复-显示回复框
     */
    $(document).on('click','.reply-operate > a[data-role="reply"]',function(){
        // 每次生成回复框，都先删除已经存在的，保证页面只存在一个回复框
        $('#messageReplyWrap').remove();
        var uname = $(this).attr('data-uname');
        var uid = $(this).attr('data-uid');
        var messageId = $(this).attr('data-mid');
        replyVar.messageId = messageId;
        replyVar.uid = uid;
        replyVar.uname = uname;
        $(this).parents('.reply-wrap').append(createReplyDiv(uname));
        $('#messageReplyWrap .message-input').focus();
    });

    /**
     * 删除留言
     */
    $(document).on('click','.message-operate > a[data-role="delete"]',function(){
    	var mid = $(this).attr('data-mid');
    	var $body = $(this).parents('#'+mid);
    	var url = isay.preUrl + '/delete_message';
    	var args = {"messageId": mid};
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
    $(document).on('click','.reply-operate > a[data-role="delete"]',function(){
    	var rid = $(this).attr('data-rid');
    	var $body = $(this).parents('#'+rid);
    	var url = isay.preUrl + '/delete_message_reply';
    	var args = {"mrId": rid};
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
    
});
