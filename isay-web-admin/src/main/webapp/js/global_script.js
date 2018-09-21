/**
 * Created by biubiu on 2017/9/20.
 */
var isay = {};
isay.preUrl = '/isay-web-admin';

/**
 * 异步请求，加载提示
 */
isay.ajaxLoading = function(){
    $('body').append($('<div class="ajax-loading-wrap">'+
                        '<div class="loading"><strong>Loading...</strong></div>'+
                    '</div>'));
};

/**
 * 页面提示
 */
isay.pageTip = function(msg){
	$('body').append($('<div class="page-tip-wrap">'+
            '<div class="text"><strong>'+ msg +'</strong></div>'+
        '</div>'));
	var w = $('.page-tip-wrap > .text').outerWidth();
	var h = $('.page-tip-wrap > .text').outerHeight();
	// 根据实际大小居中显示
	$('.page-tip-wrap > .text').css({
		"margin-left": -w/2 + 'px',
		"margin-top" : -h/2 + 'px'
	});
	setTimeout(() => {
		$('.page-tip-wrap').remove();
	}, 1000);
};

/**
 * 调整页脚位置
 */
isay.adjustFoot = function(){
    var foot = $('.isay-footer').height();
    var all = $(window).height();
    $('.isay-container').css({
        minHeight: (all-foot) + 'px'
    });
};

$(function(){
    $('#show_menu_toggle').click(function(){
        $('.isay-header .isay-mobile-menu').slideToggle();
    });

    $('#isay-return-top').click(function(){
        $("body,html").animate({
            scrollTop: 0
        },400);
    });

    $('#userOperate').click(function(){
        $(this).siblings('.isay-nav-u').toggle('fast',function(){
            $(this).animate({
                width: 137 + 'px'
            });
        });
    });

    isay.adjustFoot();
});