$(function(){
	/*-------------------jcrop裁剪图片部分-----------------------*/
	
	var boundx, boundy, jcrop_api;
	function start(){
		$('#cropImg').Jcrop({
			aspectRatio: 1,
			onSelect:preview,
			onChange:preview,
			onRelease:clear
		},function(){
			//获得图片展示大小
			var bounds = this.getBounds();
			boundx = bounds[0];
			boundy = bounds[1];
			//前台展示长宽
			$('#dw').val(boundx);
			$('#dh').val(boundy);
			jcrop_api = this;
			jcrop_api.setSelect([50,50,200,200]);
		});
	}
	
	function preview(c){
		$("#x").val(c.x);
		$("#y").val(c.y);
		$("#w").val(c.w);//裁剪宽度
		$("#h").val(c.h);//裁剪高度
		
		//计算预览区域图片缩放的比例，通过计算显示区域的宽度(与高度)与剪裁的宽度(与高度)之比得到
		var rx_50 = 50 / c.w;
        var ry_50 = 50 / c.h;
        var rx_150 = 150 / c.w;
        var ry_150 = 150 / c.h;
		
		$('#img_50').css({
			//预览图片宽度为计算比例值与显示图片宽度的乘积
			width: Math.round(rx_50 * boundx) + 'px',
			//预览图片高度为计算比例值与显示图片高度的乘积
	        height: Math.round(ry_50 * boundy) + 'px',
	        marginLeft: '-' + Math.round(rx_50 * c.x) + 'px',
	        marginTop: '-' + Math.round(ry_50 * c.y) + 'px'
		});
		$('#img_150').css({
			width: Math.round(rx_150 * boundx) + 'px',
			height: Math.round(ry_150 * boundy) + 'px',
			marginLeft: '-' + Math.round(rx_150 * c.x) + 'px',
			marginTop: '-' + Math.round(ry_150 * c.y) + 'px'
		});
		
	}

	function clear(){
		$('#imgform').find('input:hidden').val("");
	}

	start();
	//--------------------------------------------------
	var isChange = false;
	var uploadimg = function(){
		isChange = true;
		$.ajaxFileUpload({
			url: isay.preUrl + '/user/upload_photo', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'userImgFile', //文件上传域的ID
            dataType: 'content', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
            	var str = new String(data);
            	//去除不需要的，只留下json字符串
            	var result = str.replace('<pre style="word-wrap: break-word; white-space: pre-wrap;">', '')
        		.replace('</pre>', '');
            	var json = JSON.parse(result);
            	//$(".jcrop-holder img").attr("src", data.imgurl);
            	//jcrop_api.setImage(data.imgurl);
            	//先上传成功
            	$('#cropImg').attr("src", json.data.url);
            	//更改插件的图片
            	$('.jcrop-holder > img').attr("src", json.data.url);
            	$('.jcrop-holder > div > div > img').attr("src", json.data.url);
            	//然后开始初始化
            	start();
                $('#img_50').attr("src", json.data.url);
                $('#img_150').attr("src", json.data.url);
                $('#imgInfo').html("<strong>文件名：</strong>" + json.data.fileName + "&nbsp;&nbsp;<strong>文件大小：</strong>" + json.data.fileSize);
                
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
            	//$('#imgInfo').text("上传出错啦\n" + e);
            }
		});
        var $up = $('#userImgFile');
		var $p = $up.parent();
        $up.remove();
		$p.append('<input class="us-upload-input" type="file" accept="image/png,image/gif,image/jpeg" name="imgFile" id="userImgFile">');
		$('#userImgFile').bind("change",uploadimg);
	};
	$("#userImgFile").bind("change",uploadimg);

	$('#saveUserPhoto').click(function(){
		if(!isChange){
            $('#saveMsg').removeClass('alert alert-success').addClass('alert alert-danger').text("选择文件后才可以保存！");
			return;
		}
		var url = isay.preUrl + '/user/save_photo';
		var x = $("#x").val();
		var y = $("#y").val();
		var w = $("#w").val();
		var h = $("#h").val();
		var dw = $("#dw").val();
		var dh = $("#dh").val();
		var args = {
				"x":x,
				"y":y,
				"w":w,
				"h":h,
				"dw":dw,
				"dh":dh,
				"date": new Date().getTime()
		};
		
		$.getJSON(url, args, function(res){
			if(res.code == 0){
				isay.pageTip("修改成功！");
				//更改头像
				setTimeout(() => {
					location.reload(true);
				}, 500);
			}else{
				isay.pageTip(res.msg);
			}
		});
		
	});

});