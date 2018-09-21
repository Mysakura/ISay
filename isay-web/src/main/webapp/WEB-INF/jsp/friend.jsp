<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-友情链接</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/friend.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row friend-add-padding">
        <div class="col-xs-10 col-xs-offset-1 col-md-8 col-md-offset-2">
            <div class="col-xs-12">
                <h2 class="text-center">友情链接</h2>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1 col-xs-12 col-xs-offset-0">
            <div class="friend-wrap">
                <form class="form-horizontal col-md-10 col-md-offset-1" action="${pageContext.request.contextPath }/submit_friend" method="post">
                    <div class="form-group">
                        <div class="col-xs-12">
                            <label>网站名称</label>
                        </div>
                        <div class="col-xs-12">
                            <input required class="form-control" type="text" id="flName" name="flName" placeholder="Please put your website name">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12">
                            <label>网站链接</label>
                        </div>
                        <div class="col-xs-12">
                            <input required class="form-control" type="url" id="flUrl" name="flUrl" placeholder="Please put your website URL. eg:http://www.XXX.com">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3 col-xs-12">
                            <input class="form-control btn btn-info" type="button" id="submitFriemd" value="提交">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="friend-add-margin"></div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/friend.js"></script>
</body>
</html>