/**
 * Created by biubiu on 2017/10/10.
 */

$(function(){
    

    // 投票
    $(document).on('click','.vote-operate > a',function(){
    	var voteId = $(this).attr('data-voteid');
        var itemId = $(this).attr('data-itemid');
        
        var url = isay.preUrl + '/card/join_vote';
        var args = {"voteId":voteId, "itemId":itemId}
        $.getJSON(url, args, function(res){
        	if(res.code == 0){
        		isay.pageTip("投票成功！");
        		setTimeout(() => {
					location.reload(true);
				}, 500);
        	}else{
        		isay.pageTip(res.msg);
        	}
        });
    });

});