/**
 * Created by dong on 2017/9/20.
 */

$(function(){
    var companyId;
    // 显示添加标签模态框
    $('#putCompanyLabel').click(function(){
        $('#myModal').modal('show');
        companyId = $(this).attr('data-companyId');
    });

    // 好标签
    $('#putGood').click(function(){
    	var labelContent = $('#companyLabelInput').val();
    	var url = isay.preUrl + '/card/company_add_label';
        var args = {"company.companyId": companyId,"labelName":labelContent,"labelType":"0"};
        $.getJSON(url,args,function(res){
        	if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("添加成功！");
    				$('.company-labels').append($('<span class="company-labels-item c-ok" title="我 说">'+ labelContent +'</span>'));
    				$('#myModal').modal('hide');
    				$('#companyLabelInput').val('');
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
        });
    });

    // 坏标签
    $('#putBad').click(function(){
    	var labelContent = $('#companyLabelInput').val();
    	var url = isay.preUrl + '/card/company_add_label';
        var args = {"company.companyId": companyId,"labelName":labelContent,"labelType":"1"};
        $.getJSON(url,args,function(res){
        	if(res.code == 0){
    			if(res.data == 1){
    				isay.pageTip("添加成功！");
    				$('.company-labels').append($('<span class="company-labels-item c-bad" title="我 说">'+ labelContent +'</span>'));
    				$('#myModal').modal('hide');
    				$('#companyLabelInput').val('');
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
        });
    });
    
    // 展示已经存在的公司
    $('#alreadyExist').click(function(){
        $('.exist-list').fadeToggle();
    });
    
    // 添加公司
    $('#addCompany').click(function(){
    	var name = $('#addCompanyInput').val();
    	var url = isay.preUrl + '/card/company_add';
    	var args = {"companyName":name};
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
    
    // 展示特定的公司
    $('.exist-list > a').click(function(){
    	var id = $(this).attr('data-id');
    	var url = isay.preUrl + '/card/company_search_by_id';
    	var args = {"companyId":id};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data != undefined){
    				$('#putCompanyLabel').attr('data-companyId',res.data.companyId);
    				$('#companyTitle').text(res.data.companyName);	// 设置公司名
    		    	$('#labelNum').text(res.data.goodNum+res.data.badNum);	// 设置总评数
    		    	$('#goodLabelNum').text(res.data.goodNum);	// 设置好评数
    		    	$('#badLabelNum').text(res.data.badNum);	// 设置差评数
    		    	$('.company-labels').empty();
    		    	for(var i = 0; i < res.data.labels.length; i++){
    		    		var l =  res.data.labels[i];
    		    		if(l.labelType == "0")
    		    			$('.company-labels').append($('<span class="company-labels-item c-ok" title="'+ l.user.nickname +' 说">'+ l.labelName +'</span>'));
    		    		else
    		    			$('.company-labels').append($('<span class="company-labels-item c-bad" title="'+ l.user.nickname +' 说">'+ l.labelName +'</span>'));
    		    	}
    		    	$('.company-evaluate').fadeIn();
    			}else{
    				isay.pageTip("查询失败！");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    	
    });
    
    // 根据名字查询公司
    $('#searchByName').click(function(){
    	var name = $('#searchByNameInput').val();
    	var url = isay.preUrl + '/card/company_search_by_name';
    	var args = {"companyName":name};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			if(res.data != undefined){
    				$('#putCompanyLabel').attr('data-companyId',res.data.companyId);
    				$('#companyTitle').text(res.data.companyName);	// 设置公司名
    		    	$('#labelNum').text(res.data.goodNum+res.data.badNum);	// 设置总评数
    		    	$('#goodLabelNum').text(res.data.goodNum);	// 设置好评数
    		    	$('#badLabelNum').text(res.data.badNum);	// 设置差评数
    		    	$('.company-labels').empty();
    		    	for(var i = 0; i < res.data.labels.length; i++){
    		    		var l =  res.data.labels[i];
    		    		if(l.labelType == "0")
    		    			$('.company-labels').append($('<span class="company-labels-item c-ok" title="'+ l.user.nickname +' 说">'+ l.labelName +'</span>'));
    		    		else
    		    			$('.company-labels').append($('<span class="company-labels-item c-bad" title="'+ l.user.nickname +' 说">'+ l.labelName +'</span>'));
    		    	}
    		    	$('.company-evaluate').fadeIn();
    			}else{
    				isay.pageTip("没有您需要的公司！请您添加！");
    			}
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    });

});