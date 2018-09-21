/**
 * Created by dong on 2018/5/24.
 */

$(function(){
	
    $('a[data-role="accept"]').click(function(){
    	var flId = $(this).attr('data-id');
    	var url = isay.preUrl + '/friend/deal_accept';
    	var args = {"flId":flId};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("通过成功！");
    				setTimeout(() => {
						location.reload(true);
					}, 500);
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    });
    
    $('a[data-role="deny"]').click(function(){
    	var flId = $(this).attr('data-id');
    	var url = isay.preUrl + '/friend/deal_deny';
    	var args = {"flId":flId};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("拒绝成功！");
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
