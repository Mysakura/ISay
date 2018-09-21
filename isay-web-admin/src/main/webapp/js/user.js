/**
 * Created by dong on 2018/5/24.
 */

$(function(){

	$('a[data-role="shield"]').click(function(){
    	var userId = $(this).attr('data-id');
    	var url = isay.preUrl + '/user/shield';
    	var args = {"userId":userId};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("屏蔽成功！");
    				setTimeout(() => {
						location.reload(true);
					}, 500);
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    });
	
	$('a[data-role="show"]').click(function(){
		var userId = $(this).attr('data-id');
		var url = isay.preUrl + '/user/show';
		var args = {"userId":userId};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == 1){
					isay.pageTip("解除成功！");
					setTimeout(() => {
						location.reload(true);
					}, 500);
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
	$('a[data-role="removeAdmin"]').click(function(){
		var userId = $(this).attr('data-id');
		var roleId = $(this).attr('data-roleid');
		var url = isay.preUrl + '/user/removeAdmin';
		var args = {"userId":userId, "roleId":roleId};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == 1){
					isay.pageTip("操作成功！");
					setTimeout(() => {
						location.reload(true);
					}, 500);
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
	$('a[data-role="toAdmin"]').click(function(){
		var userId = $(this).attr('data-id');
		var url = isay.preUrl + '/user/toAdmin';
		var args = {"userId":userId};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == 1){
					isay.pageTip("操作成功！");
					setTimeout(() => {
						location.reload(true);
					}, 500);
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
    
});
