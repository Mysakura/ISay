<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-公告</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/announce.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/article.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/editormd/editormd.preview.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/editormd/editormd.min.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row announce-add-padding">
        <div class="col-xs-10 col-xs-offset-1 col-md-8 col-md-offset-2">
            <div class="col-xs-12">
                <h2 class="text-center">${announce.annTitle }</h2>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2 col-xs-12 col-xs-offset-0">
            <div id="content" class="isay-article-wrap">${announce.annContent }</div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/editormd/lib/marked.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/editormd/lib/prettify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/editormd/editormd.min.js"></script>
<script type="text/javascript">
	editormd.markdownToHTML("content");//
</script>
</body>
</html>