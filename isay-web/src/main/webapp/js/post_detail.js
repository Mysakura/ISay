/**
 * 赞成，反对，收藏
 * @returns
 */
$(function(){
	
	/**
	 * 赞成
	 */
	$('#supportPost').click(function(){
		var postId = $(this).attr('data-pid');
		var url = isay.preUrl + '/card/support_post';
		var args = {"postId":postId};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == 1){
					isay.pageTip("赞成+1");
				}else{
					isay.pageTip("赞成操作失败！");
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
	/**
	 * 反对
	 */
	$('#denyPost').click(function(){
		var postId = $(this).attr('data-pid');
		var url = isay.preUrl + '/card/deny_post';
		var args = {"postId":postId};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == 1){
					isay.pageTip("反对+1");
				}else{
					isay.pageTip("反对操作失败！");
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
	/**
	 * 收藏
	 */
	$('#collectPost').click(function(){
		var postId = $(this).attr('data-pid');
		var url = isay.preUrl + '/card/collect_post';
		var args = {"postId":postId};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == 1){
					isay.pageTip("收藏+1");
				}else{
					isay.pageTip("收藏失败！");
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
});