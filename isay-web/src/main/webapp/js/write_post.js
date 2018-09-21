/**
 * Created by biubiu on 2017/9/20.
 */


$(function(){
    $(window).scroll(function(){
        if($(this).scrollTop() > 70){
            $('.isay-header').fadeOut();
        }else{
            $('.isay-header').fadeIn();
        }
    });
    
    // 保存共享帖子的修改
    $('#releaseSharePost').click(function(){
    	$('#time').val(new Date().getTime());
    	var content = $('.editormd-html-textarea').val();
    	//获取编辑预览内容
    	var prevContent = $(".editormd-preview > div").text();
    	if(content == ""){
    		isay.pageTip("文章内容不能为空！");
    		return false;
    	}
    });
    
    $('#releasePost').click(function(){
    	$('#time').val(new Date().getTime());
    	var title = $("#postTitle").val();
    	var content = $('.editormd-html-textarea').val();
    	//获取编辑预览内容
		var prevContent = $(".editormd-preview > div").text();
		// 填充全文本
		$('#postText').text(prevContent);
		//填充摘要
		$('#postShortCut').text(prevContent.substring(0,250));
		if(title == "" || content == ""){
			isay.pageTip("标题或文章内容不能为空！");
			return false;
		}
    });
    
    /**
     * 领域标签：特效+显示子标签
     */
    $('.write-type > input:radio').click(function(){
    	$('.write-type-active').removeClass('write-type-active');
    	$(this).parent().addClass('write-type-active');
    	var $p = $(this).parents('.col-xs-12').next('.col-xs-12').find('ul');	// 领域对应的标签父元素
    	var areaId = $(this).val();
    	//isay.pageTip(areaId);
    	var data = JSON.parse(sessionStorage.getItem('areaLabel:' + areaId));	// 先从本地存储获取
    	// 没有的话
    	if(data == undefined || data == null){
    		var url = isay.preUrl + '/card/area_label';
    		var args = {"areaId":areaId};
    		$.getJSON(url, args, function(res){
    			if(res.code == 0){
    				data = res.data;
    				// 拿到数据存储到本地
    				sessionStorage.setItem('areaLabel:' + areaId, JSON.stringify(data));
    				// 展示
    				$p.empty();
    				for(var i = 0; i < data.length; i++)
    					$p.append($('<li class="write-label"><input type="checkbox" name="postLabel" value="'+ data[i].labelId +'" form="poform" id="l-'+ data[i].labelId +'"><label for="l-'+ data[i].labelId +'">'+ data[i].labelName +'</label></li>'));
    			}
    		});
    	}else{
    		// 展示
    		$p.empty();
    		var $labels = $(data);
    		for(var i = 0; i < $labels.length; i++)
    			$p.append($('<li class="write-label"><input type="checkbox" name="postLabel" value="'+ $labels[i].labelId +'" form="poform" id="l-'+ $labels[i].labelId +'"><label for="l-'+ $labels[i].labelId +'">'+ $labels[i].labelName +'</label></li>'));
    	}
    });
    
    /**
     * 领域标签
     */
    $(document).on('click','.write-label > input:checkbox',function(){
		$(this).parent().toggleClass('write-label-active');
//    	if($(this).parent().hasClass('write-label-active')){
//    		$(this).parent().removeClass('write-label-active');
//    	}else{
//    		$(this).parent().addClass('write-label-active');
//    	}
    });
});