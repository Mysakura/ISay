/**
 * Created by dong on 2018/1/25.
 */

$(function(){

    $('#openSupportModal').click(function(){
        $('#supportModal').modal('show');
    });
    $('#openLetterModal').click(function(){
        $('#letterModal').modal('show');
    });
    $('#submitLetter').click(function(){
    	var $letter = $(this).parent().siblings('.modal-body').find('textarea');
    	var otherId = $(this).attr('data-uid');
    	var letterContent = $letter.val();
    	var time = new Date().getTime();
    	var url = isay.preUrl + '/user/add_letter';
    	var args = {"otherId":otherId,"letterContent":letterContent,"time":time};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("私信成功！对方已收到你的消息！");
    				$letter.val('');
    			}else{
    				isay.pageTip("私信失败！");
    			}
    		}else{
				isay.pageTip(res.msg);
			}
    	});
    });
    $('#focusTA').click(function(){
    	var masterId = $(this).attr('data-uid');
    	var url = isay.preUrl + '/user/focus';
    	var args = {"masterId":masterId};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("关注成功！");
    				setTimeout(() => {
						location.reload(true);
					}, 500);
    			}else{
    				isay.pageTip("关注失败！");
    			}
    		}else{
				isay.pageTip(res.msg);
			}
    	});
        //isay.ajaxLoading();
    });
    $('#cancelFocusTA').click(function(){
    	var masterId = $(this).attr('data-uid');
    	var url = isay.preUrl + '/user/cancelFocus';
    	var args = {"masterId":masterId};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("取消关注成功！");
    				setTimeout(() => {
						location.reload(true);
					}, 500);
    			}else{
    				isay.pageTip("取消关注失败！");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    	//isay.ajaxLoading();
    });
    
    $('#loadOtherPost').click(function(){
		var $t = $(this);
		var isLast = $t.attr('data-isLast');
		if(isLast == 0){
			isay.pageTip("没有更多的数据！");
			return false;
		}
		var pageNo = $t.attr('data-pageNo');
		var userId = $t.attr('data-id');
		var url = isay.preUrl + '/user/other_post';
		var args = {"pageNo":pageNo,"userId":userId};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				$t.attr('data-pageNo', res.nextPage);
				$t.attr('data-isLast', res.isLast);
				for(var i = 0; i < res.data.length; i++){
					var time = res.data[i].postTime;
					time = isay.formatTime(time);
					var $content = $(
							'<li class="list-group-item my-post">'+
							'<h3 class="h3"><a href="'+ isay.preUrl +'/card/post_details/'+ res.data[i].postId +'">'+ res.data[i].postTitle +'</a></h3>'+
							'<div class="pull-right">'+
							'<img class="my-post-img" src="'+ isay.preUrl +'/'+ res.data[i].postCover +'">'+
							'</div>'+
							'<p class="my-post-p">'+ res.data[i].postShortCut +'</p>'+
							'<div>'+
							'<span class="my-post-span">发表于：'+ time +'</span>&nbsp;'+
							'<span class="my-post-span">浏览['+ res.data[i].visitNum +']</span>&nbsp;'+
							'<span class="my-post-span">评论['+ res.data[i].commentNum +']</span>'+
							'<div class="pull-right">'+
							'<span>所属分类:&nbsp;</span>'+
							'<a href="">'+ res.data[i].classify.classifyName +'</a>&nbsp;'+
							'<span>所属领域:&nbsp;</span>'+
							'<a href="">'+ res.data[i].workArea.areaName +'</a>'+
							'</div>'+
							'</div>'+
					'</li>');
					$('#myPostWrap').append($content);
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
		
	});

});
