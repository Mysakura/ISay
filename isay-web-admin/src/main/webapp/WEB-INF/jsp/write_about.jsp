<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建About</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            <h3 class="text-center">新建About</h3>
        </div>
        <div class="col-xs-12">
            <div class="form-group">
                <select class="form-control" id="aboutType" name="aboutType" form="poform">
                    <option>--选择About类型--</option>
                    <option value="1">关于站点</option>
                    <option value="2">关于作者</option>
                    <option value="3">联系方式</option>
                </select>
            </div>
        </div>
        <div class="col-xs-12">
            <div class="editormd" id="editormd_warp">
                <!--
                <textarea style="display: none;" name="articleContent" form="raform"></textarea>
                                                                                        form="raform"
                -->
                <textarea data-role="write" class="editormd-markdown-textarea" name="aboutMarkdown" form="poform"></textarea>
                <textarea data-role="write" class="editormd-html-textarea" name="aboutContent" form="poform"></textarea>
            </div>

        </div>
        <div class="col-xs-4 col-xs-offset-4">
            <input class="form-control submit-btn" type="submit" id="releaseAbout" value="发布" form="poform">
        </div>
        <div class="col-xs-12">
            <form action="${pageContext.request.contextPath }/about/add" method="post" id="poform">
                <input type="hidden" name="aboutTime" id="time" form="poform">
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
            imageUploadURL : "<%=request.getContextPath()%>/uploadfile",
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
        $("#editormd_warp > textarea").attr("placeholder", "在这里开始");
    });
</script>
</body>
</html>