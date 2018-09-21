/**
 * Created by dong on 2018/5/24.
 */
$(function(){
    $('.write-timeline').click(function(){
        $('#addTimeLineModal').modal('show');
    });
    
    $('#submitTimeline').click(function(){
    	var tlContent = $('.timeline-textarea').val();
    	var url = isay.preUrl + '/timeline/add';
    	var args = {"tlContent":tlContent, "tlTime":new Date().getTime()};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("添加成功！");
    				setTimeout(() => {
						location.reload(true);
					}, 500);
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    });
    
    $('a[data-role="delLine"]').click(function(){
    	var tlId = $(this).attr('data-id');
    	var url = isay.preUrl + '/timeline/del';
    	var args = {"tlId":tlId};
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