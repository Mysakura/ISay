$(function(){
	$('#loadOwnPost').click(function(){
		var $t = $(this);
		var isLast = $t.attr('data-isLast');
		if(isLast == 0){
			isay.pageTip("没有更多的数据！");
			return false;
		}
		var pageNo = $t.attr('data-pageNo');
		var url = isay.preUrl + '/user/own_post';
		var args = {"pageNo":pageNo};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				$t.attr('data-pageNo', res.nextPage);
				$t.attr('data-isLast', res.isLast);
				for(var i = 0; i < res.data.length; i++){
					var time = res.data[i].postTime;
					time = isay.formatTime(time);
					var $content = $(
							'<li class="list-group-item my-post" id="'+ res.data[i].postId +'">'+
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
	
	// 取消收藏帖子
	$('.cancel-collect-post').click(function(){
		var postId = $(this).attr('data-pid');
		var url = isay.preUrl + '/card/cancel_collect_post';
		var args = {"postId":postId};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == 1){
					isay.pageTip("取消收藏成功！");
					setTimeout(() => {
						location.reload(true);
					}, 500);
				}else{
					isay.pageTip("取消收藏失败！");
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
	// 删除帖子
	$('.my-post-del').click(function(){
		var postId = $(this).attr('data-pid');
		var url = isay.preUrl + '/card/del_post';
		var args = {"postId":postId};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == 1){
					isay.pageTip("删除成功！");
					setTimeout(() => {
						location.reload(true);
					}, 500);
				}else{
					isay.pageTip("删除失败！");
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
	
});