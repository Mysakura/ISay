<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-找回密码</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/find_password.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<div class="container-fluid isay-container">
    <div style="height: 700px">
        <div class="col-md-6 col-xs-12 col-md-offset-3 text-center find-wrap">
            <div class="well">
                <h1 class="h1 text-danger">验证邮箱</h1>
                <div class="form-group">
                    <input class="form-control" type="email" id="findEmail" name="findEmail" placeholder="请输入您的邮箱">
                </div>
                <span class="text-danger">验证失败！</span>
                <span class="text-success">验证成功！</span>
            </div>
            <a href="javascript:;" class="btn btn-primary">验证并下一步</a>
        </div>
        <div class="col-md-6 col-xs-12 col-md-offset-3 text-center find-wrap">
            <div class="well">
                <h1 class="h1 text-danger">输入验证码</h1>
                <div class="form-group">
                    <input class="form-control" type="email" id="validationCode" name="validationCode" placeholder="请输入发送到您邮箱的验证码">
                </div>
                <span class="text-danger">验证失败！</span>
                <span class="text-success">验证成功！</span>
            </div>
            <a href="javascript:;" class="btn btn-primary">验证并下一步</a>
        </div>
        <div class="col-md-6 col-xs-12 col-md-offset-3 text-center find-wrap">
            <div class="well">
                <h1 class="h1 text-danger">输入新密码</h1>
                <div class="form-group">
                    <input class="form-control" type="email" id="newPassword" name="newPassword" placeholder="请输入您的新密码">
                </div>
                <div class="form-group">
                    <input class="form-control" type="email" id="rePassword" name="rePassword" placeholder="请输入确认密码">
                </div>
            </div>
            <a href="javascript:;" class="btn btn-primary">提交</a>
        </div>

    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>