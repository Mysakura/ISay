$(function(){
	var isOkA = false;	// 是否可以提交
	var isOkB = false;	// 是否可以提交
	var isOkC = false;	// 是否可以提交
	// 校验用户名
	$('#nickname').blur(function(){
		var nickname = $(this).val();
		var url = isay.preUrl + '/checkNickName';
		var args = {"nickname":nickname};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == 0){
					isay.pageTip("用户名可以使用");
					isOkA = true;
				}else{
					isay.pageTip("用户名已被占用");
					isOkA = false;
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	// 校验邮箱
	$('#userEmail').blur(function(){
		var userEmail = $(this).val();
		var url = isay.preUrl + '/checkUserEmail';
		var args = {"userEmail":userEmail};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == 0){
					isay.pageTip("邮箱可以使用");
					isOkB = true;
				}else{
					isay.pageTip("邮箱已被占用");
					isOkB = false;
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
		
	});
	// 发送邮件获取验证码
	$('#sendEmail').click(function(){
		var email = $('#userEmail').val();
		var url = isay.preUrl + '/check_email';
		var args = {"email":email};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				isay.pageTip(res.data);
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	// 校验验证码
	$('#token').blur(function(){
		var validCode = $(this).val();
		var url = isay.preUrl + '/check_code';
		var args = {"validCode":validCode};
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				if(res.data == true){
					isay.pageTip("验证码通过");
					isOkC = true;
				}else{
					isay.pageTip("验证码不正确");
					isOkC = false;
				}
			}else{
				isay.pageTip(res.msg);
			}
		});
	});
	
	$('#submitRegister').click(function(){
		if(!(isOkA && isOkB && isOkC)){
			isay.pageTip("请检查您的字段！");
			return false;
		}
	});
})