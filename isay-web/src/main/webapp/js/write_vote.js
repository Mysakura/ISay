/**
 * Created by biubiu on 2017/10/10.
 */

$(function(){
    var opId = 1;
    $('#addVoteOption').click(function(){
        var $op = $('<div class="form-group">' +
            '<input class="form-control" type="text" name="itemContent" placeholder="请输入投票选项" data-id="'+ opId +'" form="vform">' +
            '</div>');
        $('.vote-options').append($op);

        var $prevop = $('<a href="javascript:;" class="option" data-id="'+ opId +'"></a>');
        $('.write-vote-wrap .preview-options').append($prevop);
        opId++;
    });

    //预览
    $(document).on('keyup','.vote-content',function(){
        var content = $(this).text();
        $('.preview-content').text(content);
    });
    $(document).on('keyup','.write-vote-wrap .vote-options input',function(){
        var val = $(this).val();
        var id = $(this).attr('data-id');
        $('.write-vote-wrap .preview-options .option[data-id="'+ id +'"]').text(val);
    });
    //点击-选中
    $(document).on('click','.write-vote-wrap .preview-options .option',function(){
        $('.write-vote-wrap .preview-options .option').removeClass("active");
        $(this).addClass("active");
    });

    // 提交
    $('#releaseVote').click(function(){
    	$('#voteTime').val(new Date().getTime());
		$('#voteContent').text($('.vote-content').html());
    });
});