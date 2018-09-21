<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-参与完善</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/editormd/editormd.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/write_post.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-12">
            <h3 class="text-center">参与完善：<span class="text-danger">${post.postTitle }</span></h3>
        </div>
        <div class="col-xs-12">
            <div class="editormd" id="editormd_warp">
                <!--
                <textarea style="display: none;" name="articleContent" form="raform"></textarea>
                                                                                        form="raform"
                -->
                <textarea data-role="write" class="editormd-markdown-textarea" name="postMarkdown" form="poform">${post.postMarkdown }</textarea>
                <textarea data-role="write" class="editormd-html-textarea" name="postContent" form="poform"></textarea>
            </div>

        </div>
        <div class="col-xs-4 col-xs-offset-4">
            <input class="form-control submit-btn" type="submit" id="releaseSharePost" form="poform" value="提交我的完善">
        </div>
        <div class="col-xs-12">
            <form action="${pageContext.request.contextPath }/card/save_share_post" method="post" id="poform">
                <input type="hidden" name="time" id="time" form="poform">
                <input type="hidden" name="postId" value="${post.postId }" form="poform">
            </form>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/write_post.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/editormd/editormd.min.js"></script>
<script type="text/javascript">
    var editor;
    $(function() {
        editor = editormd("editormd_warp", {
            width   : "100%",
            height: 640,
            syncScrolling : "single",
            //编辑器lib目录的路径
			path    : "<%=request.getContextPath()%>/editormd/lib/",
            //path    : "editormd/lib/",
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png"],
            //上传路径
			imageUploadURL : "<%=request.getContextPath()%>/card/upload_post_img",
            //imageUploadURL : "post_photo",
            saveHTMLToTextarea : true,
            toolbarIcons : function() {
                return ["undo", "redo", "|","bold","del","italic","quote",
                    "ucwords","uppercase","lowercase","|","h1","h2","h3",
                    "h4","h5","h6","|","list-ul","list-ol","hr","|","link",
                    "reference-link","image","code","preformatted-text",
                    "code-block","table","datetime","html-entities","pagebreak","|",
                    "goto-line","watch","preview","fullscreen","clear","|","help"]
            }

        });
        $("#editormd_warp > textarea").attr("placeholder", "我知道你是“老司机”");
    });
</script>
</body>
</html>