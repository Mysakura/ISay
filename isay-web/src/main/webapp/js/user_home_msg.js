/**
 * Created by dong on 2018/1/29.
 */
$(function(){
	
	function createMeHtml(content){
		var $me =  $('<div class="u-msg-detail">'+
                '<div class="me">'+
                '<span class="glyphicon glyphicon-triangle-right triangle"></span>'+
                '<span class="content">'+ content +'</span>'+
                '</div>'+
                '</div>');
		return $me;
	}
	
	function createOtherHtml(content){
		var $other =  $('<div class="u-msg-detail">'+
                '<div class="other">'+
                '<span class="glyphicon glyphicon-triangle-left triangle"></span>'+
                '<span class="content">'+ content +'</span>'+
                '</div>'+
            	'</div>');
		return $other;
	}
	
	function createTimeLine(time){
		var $t = $('<div class="u-msg-detail">'+
                '<p class="time">-'+ isay.formatDateStr(new Date(time)) +'-</p>'+
                '</div>');
		return $t;
	}
	
	/**
	 * 上次消息
	 */
	$('#lastHistory').click(function(){
		var $t = $(this);
		var meId = $t.attr('data-me');			// 自己
		var curDateStr = $t.attr('data-cur');	// 当前展示的数据对应的时间
		var date;
		if(curDateStr == "" || curDateStr == undefined){
			date = new Date();
		}else{
			var split = curDateStr.split('-');			// 解析
			date = new Date(Number(split[0]),Number(split[1])-1,Number(split[2]));	// 重组
		}
		date.setDate(date.getDate() - 1);			// 上一天
		var lastDateStr = isay.formatDateStr(date);	// 格式化[要查询的对应时间的数据]
		var letterId = $(this).attr('data-lid');
		
		var url = isay.preUrl + '/user/get_msg_detail';
		var args = {"id":letterId,"dateStr":lastDateStr};
		$.getJSON(url,args,function(res){
			if(res.code == 0){
				if(res.data != undefined){
					$t.attr('data-cur', lastDateStr);	// 更新前端时间
					if(res.data.length == 0){
						isay.pageTip("无数据");
						return;
					}
					$('.u-msg-detail').remove();
					for(var i = 0; i < res.data.length; i++){
						if(meId == res.data[i].sender.userId){
							$('.u-msg-select').before(createMeHtml(res.data[i].content));
						}else{
							$('.u-msg-select').before(createOtherHtml(res.data[i].content));
						}
					}
					// 时间线
					$('.u-msg-select').before(createTimeLine(res.data[0].time));
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
	/**
	 * 下次消息
	 */
	$('#nextHistory').click(function(){
		var $t = $(this);
		var meId = $t.attr('data-me');			// 自己
		var $parent = $('.u-msg-detail').parent();	// 
		var curDateStr = $t.attr('data-cur');	// 当前展示的数据对应的时间
		var date;
		if(curDateStr == "" || curDateStr == undefined){
			date = new Date();
		}else{
			var split = curDateStr.split('-');			// 解析
			date = new Date(Number(split[0]),Number(split[1])-1,Number(split[2]));	// 重组
		}
		date.setDate(date.getDate() + 1);			// 上一天
		var nextDateStr = isay.formatDateStr(date);	// 格式化[要查询的对应时间的数据]
		var letterId = $t.attr('data-lid');
		
		var url = isay.preUrl + '/user/get_msg_detail';
		var args = {"id":letterId,"dateStr":nextDateStr};
		$.getJSON(url,args,function(res){
			if(res.code == 0){
				if(res.data != undefined){
					if(res.data.length == 0){
						isay.pageTip("无数据");
						return;
					}
					$('.u-msg-detail').remove();
					for(var i = 0; i < res.data.length; i++){
						if(meId == res.data[i].sender.userId){
							$('.u-msg-select').before(createMeHtml(res.data[i].content));
						}else{
							$('.u-msg-select').before(createOtherHtml(res.data[i].content));
						}
					}
					$('.u-msg-select').before(createTimeLine(res.data[0].time));
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
	/**
	 * 最近消息
	 */
	$('#curHistory').click(function(){
		var $t = $(this);
		var meId = $t.attr('data-me');			// 自己
		var curDateStr = isay.formatDateStr(new Date());
		var letterId = $t.attr('data-lid');
		var url = isay.preUrl + '/user/get_msg_detail';
		var args = {"id":letterId,"dateStr":curDateStr};
		$.getJSON(url,args,function(res){
			if(res.code == 0){
				if(res.data != undefined){
					$t.attr('data-cur', curDateStr);	// 更新前端时间
					if(res.data.length == 0){
						isay.pageTip("无数据");
						return;
					}
					$('.u-msg-detail').remove();
					for(var i = 0; i < res.data.length; i++){
						if(meId == res.data[i].sender.userId){
							$('.u-msg-select').before(createMeHtml(res.data[i].content));
						}else{
							$('.u-msg-select').before(createOtherHtml(res.data[i].content));
						}
					}
					$('.u-msg-select').before(createTimeLine(res.data[0].time));
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
	/**
	 * 直接回复他
	 */
	$('#replyOther').click(function(){
		var letterId = $(this).attr('data-lid');
		var otherId = $(this).attr('data-oid');
		var $letter = $(this).siblings('.reply-content');
		var letterContent = $letter.text();
		var url = isay.preUrl + '/user/reply_letter';
		var args = {"letterId":letterId,"otherId":otherId,"letterContent":letterContent,"time":new Date().getTime()};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("回复成功！对方已收到你的消息！");
    				setTimeout(() => {
						location.reload(true);
					}, 500);
    			}else{
    				isay.pageTip("回复失败！");
    			}
    		}else{
				isay.pageTip(res.msg);
			}
		});
	});

    /**
     * 显示消息记录
     */
    $('#msgHistory').click(function(){
        $('.u-msg-line').fadeIn();
    });

    /**
     * 关闭消息记录
     */
    $('#closeMsgHistory').click(function(){
        $('.u-msg-line').fadeOut();
    });

    /**
     * 点击时间点，切换子时间点，发送Ajax请求，请求点击的月份里，含有数据的那几天。
     * 先判断是否请求过，如果请求过，就执行动画。
     * 如果没请求过，就现请求，不执行动画，然后将请求标志（data-has="1"）记录到当前按钮，表示这个已经请求过了
     */
    $('.u-msg-line .time-point .child-time-btn').click(function(){
        $(this).siblings('.child-time-list').slideToggle();
    });

    /**
     * 点击具体的日期，关闭消息记录，然后Ajax请求后台，将日期对应的数据显示到前台
     */
    $(document).on('click','.u-msg-line .time-point .child-time-list > .child-time-point > .r-n',function(){
        //$('.u-msg-line').fadeOut();
        var date = $(this).prev('span').text();
        alert(date);
    });

});