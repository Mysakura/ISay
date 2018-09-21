<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-写帖子</title>
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
            <h3 class="text-center">就等你说点什么了</h3>
        </div>
        <div class="col-xs-12">
            <div class="form-group">
                <input class="form-control" required type="text" id="postTitle" name="postTitle" form="poform" placeholder="请输入标题">
            </div>
        </div>
        <div class="col-xs-12">
            <div class="editormd" id="editormd_warp">
                <!--
                <textarea style="display: none;" name="articleContent" form="raform"></textarea>
                                                                                        form="raform"
                -->
                <textarea data-role="write" class="editormd-markdown-textarea" name="postMarkdown" form="poform"></textarea>
                <textarea data-role="write" class="editormd-html-textarea" name="postContent" form="poform"></textarea>
            </div>

        </div>
        <div class="col-xs-12">
            <h4 class="text-success">选择领域</h4>
            <ul class="list-unstyled">
            	<c:forEach items="${area }" var="i">
	                <li class="write-type">
	                    <input type="radio" name="workArea.areaId" value="${i.areaId }" form="poform" id="a-${i.areaId }">
	                    <label for="a-${i.areaId }">${i.areaName }</label>
	                </li>
            	</c:forEach>
            	<!--  
                <li class="write-type write-type-active">
                    <input type="radio" name="workArea.areaId" form="poform" id="t-1">
                    <label for="t-1">技术</label>
                </li>
                <li class="write-type">
                    <input type="radio" name="workArea.areaId" form="poform" id="t-2">
                    <label for="t-2">产品</label>
                </li>
            	-->
            </ul>
        </div>
        <div class="col-xs-12">
            <h4 class="text-success">选择标签</h4>
            <ul class="list-unstyled">
            	<!--  
                <li class="write-label">
                    <input type="checkbox" name="postLabel" form="poform" value="" id="l-1">
                    <label for="l-1">Java</label>
                </li>
                <li class="write-label write-label-active">
                    <input type="checkbox" name="postLabel" form="poform" value="" id="l-2">
                    <label for="l-2">C++</label>
                </li>
            	-->
            </ul>
        </div>
        <div class="col-xs-4 col-xs-offset-4">
            <input class="form-control submit-btn" type="submit" id="releasePost" value="发布" form="poform">
        </div>
        <div class="col-xs-12">
            <form action="${pageContext.request.contextPath }/card/submit_post" method="post" id="poform">
                <input type="hidden" name="time" id="time" form="poform">
                <textarea style="display: none;" name="postShortCut" id="postShortCut" form="poform"></textarea>
            	<textarea style="display: none;" name="postText" id="postText" form="poform"></textarea>
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