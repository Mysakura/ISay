<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录后台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">
</head>
<body>
<div class="isay-header navbar-fixed-top">
    <div class=" container-fluid">
        <div class="row">
            <!--logo-->
            <div class="logo-wrap">
                <a href="${pageContext.request.contextPath }/" class="logo">
                    <img src="${pageContext.request.contextPath }/sys_photo/logo.png" >
                </a>
            </div>
        </div>
    </div>
</div>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-10 col-xs-offset-1 col-md-8 col-md-offset-2">
            <div class="col-xs-12">
                <h2 class="text-center">登录互联网说后台</h2>
            </div>
        </div>
    </div>
    <div class="row">
        <form class="login-form col-xs-12 col-sm-8 col-sm-offset-2" action="${pageContext.request.contextPath }/login" method="post">
            <div class="form-group row">
                <div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3">
                    <input required pattern="^[a-zA-Z0-9.!#$%&amp;’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" title="请输入您的邮箱" class="login-input form-control" type="email" id="email" name="email" placeholder="Email Address" autocomplete="on">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3">
                    <input required pattern=".{6,}" title="密码至少6位" class="login-input form-control" type="password" id="password" name="password" placeholder="Password">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-5 col-xs-offset-1 col-sm-3 col-sm-offset-3">
                    <input type="checkbox" id="show-password" name="show-password">
                    <label for="show-password">显示密码</label>
                </div>
                <div class="col-xs-5 col-sm-3 col-md-offset-0 login-forget-password">
                    <a href="/reset-page?email=">忘记密码?</a>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3">
                    <input class="form-control login-submit-btn" type="submit" value="登录">
                </div>
            </div>
        </form>
    </div>

    <div class="login-add-margin"></div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>