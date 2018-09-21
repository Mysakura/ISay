<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-Success</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/friend.css">
</head>
<body>
<jsp:include page="../common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row friend-add-padding">
        <div class="col-xs-10 col-xs-offset-1 col-md-8 col-md-offset-2">
            <div class="col-xs-12 text-center">
                <img class="success-pic" src="sys_photo/success.png">
            </div>
            <div class="col-xs-12">
                <!--<h1 class="text-center text-success"><span class="glyphicon glyphicon-ok"></span></h1>-->
                <h2 class="text-center">${success }</h2>
                <!--<p class="text-center">用于成功的操作：文字根据具体业务显示</p>-->
            </div>
        </div>
    </div>
    <div class="friend-add-margin"></div>
</div>
<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>