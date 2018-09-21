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
    
    $('#releaseAnnounce').click(function(){
    	$('#time').val(new Date().getTime());
    	var title = $("#annTitle").val();
    	var content = $('.editormd-html-textarea').val();
		if(title == "" || content == ""){
			isay.pageTip("标题或内容不能为空！");
			return false;
		}
    });
    
    $('#releaseAbout').click(function(){
    	$('#time').val(new Date().getTime());
    	var aboutType = $("#aboutType").val();
    	var content = $('.editormd-html-textarea').val();
    	if(aboutType == "" || content == ""){
    		isay.pageTip("关于类型或内容不能为空！");
    		return false;
    	}
    });

});