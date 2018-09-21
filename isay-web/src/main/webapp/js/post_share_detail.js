/**
 * 赞成，反对，收藏
 * @returns
 */
$(function(){
	
	/**
	 * 显示修改历史
	 */
	$('#modifyHistory').click(function(){
		$('.mofify-history').fadeToggle();
	});
	
	/**
	 * 关闭修改历史
	 */
	$('#closeModifyHistory').click(function(){
		$('.mofify-history').fadeToggle();
	});
	
	/**
	 * 查看
	 */
	$('.mofify-history ul li .look-history').click(function(){
		var shareId = $(this).attr('data-shareid');
		var url = isay.preUrl + '/card/share_content';
		var args = {"shareId":shareId};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data != undefined){
					$('#content').html(res.data);
					editormd.markdownToHTML("content");
				}else{
					isay.pageTip("读取失败！");
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
});