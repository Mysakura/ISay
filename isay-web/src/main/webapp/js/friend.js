$(function(){
	
	$('#submitFriemd').click(function(){
		
		var flName = $.trim($('#flName').val());
		var flUrl = $.trim($('#flUrl').val());
		if(flName == ""){
			isay.pageTip("网站名称不能为空");
			return;
		}
		if(flUrl == ""){
			isay.pageTip("网站地址不能为空");
			return;
		}
		
		var url = isay.preUrl + "/submit_friend";
		var args = {"flName": flName, "flUrl": flUrl};
		$.getJSON(url, args, function(res){
			isay.pageTip(res.msg);
			if(res.code == 0){
				$('#flName').val("");
				$('#flUrl').val("");
			}
		});
		
	});
	
})