/**
 * Created by dong on 2018/5/24.
 */

$(function(){

	$('a[data-role="delAnnounce"]').click(function(){
    	var annId = $(this).attr('data-id');
    	var url = isay.preUrl + '/announce/delAnnounce';
    	var args = {"annId":annId};
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
    
});
