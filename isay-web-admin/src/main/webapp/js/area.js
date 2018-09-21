/**
 * Created by dong on 2018/5/24.
 */

$(function(){
	var temp = {};
    $('a[data-role="addLabel"]').click(function(){
        $('.modal-title').text($(this).attr('data-area') + '：标签');
        temp.areaId = $(this).attr('data-areaid');
        $('#addLabelModal').modal('show');
    });
    
    $('#submitLabel').click(function(){
    	var labelName = $('#labelName').val();
    	var url = isay.preUrl + '/area/addLabel';
    	var args = {"labelName":labelName, "workArea.areaId":temp.areaId};
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
    
    $('a[data-role="delLabel"]').click(function(){
    	var labelId = $(this).attr('data-id');
    	var url = isay.preUrl + '/area/delLabel';
    	var args = {"labelId":labelId};
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
