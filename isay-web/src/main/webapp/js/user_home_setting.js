/**
 * 
 * @returns
 */
$(function(){

	var motify = 0;
	var pass = 1;
	
    $('#nickname').blur(function(){
    	var oldName = $(this).attr('data-name');
    	var nickname = $(this).val();
    	if(oldName == nickname){
    		motify = 0;
    		return;
    	}
    	
    	var url = isay.preUrl + '/checkNickName';
    	var args = {"nickname": nickname};
    	$.getJSON(url, args, function(res){
    		// 请求成功
    		if(res.code == 0){
    			// 用户名不可用
    			if(res.data == 0){
    				motify = 0;
    			}else{
    				motify = 1;
    				isay.pageTip("用户名已存在");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    });
    
    $('#saveBaseInfo').click(function(){
    	if(motify != 0){
    		isay.pageTip("您有不完善的字段");
    		return false;
    	}
    	var nickname = $('#nickname').val();
    	var sex = $('[name=sex]:checked').val();
    	var graduate = $('#education').val();
    	var company = $('#company').val();
    	var job = $('#job').val();
    	var area = $('#area').val();
    	
    	var url = isay.preUrl + '/user/update_base_info';
    	var args = {"nickname":nickname,"sex":sex,"userGraduate":graduate,"company":company,"job":job,"workplace":area};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("修改成功！");
    				setTimeout(() => {
						location.reload(true);
					}, 500);
    			}else{
    				isay.pageTip("修改失败！");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    });
    
    $('#checkOldPassowrd').click(function(){
    	var oldPassword = $('#oldPassword').val();
    	var url = isay.preUrl + '/user/check_password';
    	var args = {"oldPassword":oldPassword};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data == true){
    				pass = 0;	// 通过标志
    				isay.pageTip("验证通过！");
    			}else{
    				pass = 1;	// 未通过标志
    				isay.pageTip("输入的密码不正确！");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    });
    
    $('#saveNewPassword').click(function(){
    	if(pass == 1){
    		isay.pageTip("请先验证输入的旧密码");
    		return false;
    	}
    	var newPassword = $('#newPassword').val();
    	var url = isay.preUrl + '/user/update_password';
    	var args = {"password":newPassword};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("修改成功！");
    			}else{
    				isay.pageTip("修改失败！");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    });
    
    /**
     * 上传背景图片
     */
    var uploadBgImg = function(){
    	$.ajaxFileUpload({
    		url: isay.preUrl + '/user/upload_bg', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'bgImgFile', //文件上传域的ID
            dataType: 'content', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
            	var str = new String(data);
            	//去除不需要的，只留下json字符串
            	var result = str.replace('<pre style="word-wrap: break-word; white-space: pre-wrap;">', '')
        		.replace('</pre>', '');
            	var json = JSON.parse(result);
            	if(json.code == 0){
        			isay.pageTip("上传成功");
        			setTimeout(() => {
        				location.reload(true);
        			}, 500);
        		}else{
        			isay.pageTip(json.msg);
        		}
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
            	//$('#imgInfo').text("上传出错啦\n" + e);
            }
    	});
        var $up = $('#bgImgFile');
		var $p = $up.parent();
        $up.remove();
		$p.append('<input class="us-upload-input" type="file" accept="image/png,image/gif,image/jpeg" name="imgFile" id="bgImgFile">');
		$('#bgImgFile').bind("change",uploadBgImg);
	};
	$("#bgImgFile").bind("change",uploadBgImg);
	
	/**
	 * 上传支付宝图片
	 */
	var uploadAliImg = function(){
		$.ajaxFileUpload({
    		url: isay.preUrl + '/user/upload_alipay', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'AliImgFile', //文件上传域的ID
            dataType: 'content', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
            	var str = new String(data);
            	//去除不需要的，只留下json字符串
            	var result = str.replace('<pre style="word-wrap: break-word; white-space: pre-wrap;">', '')
        		.replace('</pre>', '');
            	var json = JSON.parse(result);
            	if(json.code == 0){
        			isay.pageTip("上传成功");
        			$('#AliImgFile').parent().siblings('img').attr('src',json.data.url);
        		}else{
        			isay.pageTip(json.msg);
        		}
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
            	//$('#imgInfo').text("上传出错啦\n" + e);
            }
    	});
		
		var $up = $('#AliImgFile');
		var $p = $up.parent();
		$up.remove();
		$p.append('<input class="us-upload-input" type="file" accept="image/png,image/gif,image/jpeg" name="imgFile" id="AliImgFile">');
		$('#AliImgFile').bind("change",uploadAliImg);
	};
	$("#AliImgFile").bind("change",uploadAliImg);
	
	/**
	 * 上传微信图片
	 */
	var uploadVxinImg = function(){
		$.ajaxFileUpload({
    		url: isay.preUrl + '/user/upload_vxin', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'VxinImgFile', //文件上传域的ID
            dataType: 'content', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
            	var str = new String(data);
            	//去除不需要的，只留下json字符串
            	var result = str.replace('<pre style="word-wrap: break-word; white-space: pre-wrap;">', '')
        		.replace('</pre>', '');
            	var json = JSON.parse(result);
            	if(json.code == 0){
        			isay.pageTip("上传成功");
        			$('#VxinImgFile').parent().siblings('img').attr('src',json.data.url);
        		}else{
        			isay.pageTip(json.msg);
        		}
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
            	//$('#imgInfo').text("上传出错啦\n" + e);
            }
    	});
		
		var $up = $('#VxinImgFile');
		var $p = $up.parent();
		$up.remove();
		$p.append('<input class="us-upload-input" type="file" accept="image/png,image/gif,image/jpeg" name="imgFile" id="VxinImgFile">');
		$('#VxinImgFile').bind("change",uploadVxinImg);
	};
	$("#VxinImgFile").bind("change",uploadVxinImg);

});