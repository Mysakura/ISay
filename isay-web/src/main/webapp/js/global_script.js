/**
 * Created by biubiu on 2017/9/20.
 */
var isay = {};
isay.preUrl = '/isay-web';

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
 * 回车搜索
 */
isay.search = function(){
	$('#searchingContent').keydown(function(event){
    	if(event.keyCode == 13){
    		var key = $(this).val();
			key = $.trim(key);
			var newUrl = location.protocol + '//' + location.host + isay.preUrl + '/search_result?key="' + key + '"';
			location.href = newUrl;
    	}
    });
};

/**
 * 页脚显示友情链接
 */
isay.showFriend = function(){
	// 先从本地存储拿数据，没有的话再请求
	var data = JSON.parse(sessionStorage.getItem('friends'));
	if(data == undefined || data == null){
		var url = isay.preUrl + "/friend_foot";
		var args = {};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				data = res.data;
				// 拿到数据存储到本地
				sessionStorage.setItem('friends', JSON.stringify(data));
			}
		});
	}
	// 展示
	var $friends = $(data);
	for(var i = 0; i < $friends.length; i++)
		$('#common_friends').append($('<li><a target="_blank" href="'+ $friends[i].flUrl +'">'+ $friends[i].flName +'</a></li>'));
};

/**
 * 用户头像切换
 */
isay.userOperateToggle = function(){
	$('#userOperate').click(function(){
        $(this).siblings('.isay-nav-u').toggle('fast',function(){
            $(this).animate({
                width: 137 + 'px'
            });
        });
    });
};

/**
 * 活跃连接
 */
isay.urlActive = function(){
	var wurl = window.location.pathname;
	var purl = wurl.substring(0, wurl.lastIndexOf("/"));
	// 	purl是为了应对以下情况
	//	/isay-web/card/readme/2
	//	/isay-web/card/readme
	//console.log(wurl);
	//console.log(purl);
	$('.main-nav a').each(function(){
		var curl = $(this).attr("href");
		//console.log("curl:" + curl);
		if(wurl == curl)
			$(this).parent().addClass('active');
		else if(purl == curl)
			$(this).parent().addClass('active');
	});
};

/**
 * 时间戳----字符串
 */
isay.formatTime = function(time){
	var t = new Date(time);
	var y = t.getFullYear();
	var M = t.getMonth()+1;	// 获取的月份+1，因为月份从0开始
	if(M < 10){
		M = "0"+M;
	}
	var d = t.getDate();
	if(d < 10){
		d = "0"+d;
	}
	var h = t.getHours();
	if(h < 10){
		h = "0"+h;
	}
	var m = t.getMinutes();
	if(m < 10){
		m = "0"+m;
	}
	var s = t.getSeconds();
	if(s < 10){
		s = "0"+s;
	}
	var datetime = y+"-"+M+"-"+d+" "+h+":"+m+":"+s;
	return datetime;
};

/**
 * 格式化日期字符串：yyyy-MM-dd
 */
isay.formatDateStr = function(date){
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	if(month <= 9){
		month = '0'+month;
	}
	if(day <= 9){
		day = '0'+day;
	}
	return year+"-"+month+"-"+day;
}


$(function(){
    $('#show_menu_toggle').click(function(){
        $('.isay-header .isay-mobile-menu').slideToggle();
    });

    $('#isay-return-top').click(function(){
        $("body,html").animate({
            scrollTop: 0
        },400);
    });
    
    isay.search();
    
    isay.userOperateToggle();

    isay.urlActive();
    
    isay.showFriend();

});