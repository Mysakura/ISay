<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/register.css">
</head>
<body>
<div class="isay-header navbar-fixed-top">
    <div class=" container-fluid">
        <div class="row">
            <div class="pull-right isay-nav hidden-sm hidden-xs">
                <a href="${pageContext.request.contextPath }/" class="links"><span class="glyphicon glyphicon-home"></span> 首页</a>
            </div>
            <!--logo-->
            <div class="logo-wrap">
                <a href="/" class="logo">
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
                <h2 class="text-center">创建您的账户</h2>
            </div>
        </div>
    </div>
    <div class="row">
        <form class="login-form col-xs-12 col-sm-8 col-sm-offset-2" action="${pageContext.request.contextPath }/register" method="post">
            <div class="form-group row">
                <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 input-group">
                    <div class="col-xs-12 col-sm-12 col-md-3">
                        <label class="register-label">行走江湖的称号</label>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-9">
                        <input required title="请输入您的称呼" class="login-input form-control" type="text" id="nickname" name="nickname" placeholder="请输入您的称呼">
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 input-group">
                    <div class="col-xs-12 col-sm-12 col-md-3">
                        <label class="register-label">飞鸽传书的地址</label>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-9">
                        <input required pattern="^[a-zA-Z0-9.!#$%&amp;’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" title="请输入您的邮箱" class="login-input form-control" type="email" id="userEmail" name="userEmail" placeholder="请输入您的邮箱" autocomplete="on">
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 input-group">
                    <div class="col-xs-12 col-sm-12 col-md-3">
                        <label class="register-label">关乎性命的暗号</label>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-9">
                        <input required pattern=".{6,}" title="密码至少6位" class="login-input form-control" type="password" id="password" name="password" placeholder="请输入您的密码">
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 input-group">
                    <div class="col-xs-12 col-sm-12 col-md-3">
                        <label class="register-label">您不确认一下么</label>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-9">
                        <input required pattern=".{6,}" title="密码至少6位" class="login-input form-control" type="password" id="repassword" name="repassword" placeholder="请确认您的密码">
                    </div>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-xs-10 col-xs-offset-1 col-md-8 col-md-offset-2">
                    <div class="col-xs-12">
                        <h2 class="text-center">等等，客官~</h2>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 input-group">
                    <div class="col-xs-12 col-sm-12 col-md-3">
                        <label class="register-label">飞鸽传书试试先</label>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-9 input-group">
                        <input required pattern=".{6,}" title="验证码6位" class="form-control" type="text" id="token" name="token" placeholder="请确认验证码">
                        <span class="input-group-btn">
                            <button class="btn bg-primary" id="sendEmail">获取验证码</button>
                        </span>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2">
                    <input class="form-control login-submit-btn" type="submit" id="submitRegister" value="开始我的表演">
                </div>
            </div>
        </form>
    </div>

    <div class="login-add-margin"></div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/register.js"></script>
</body>
</html>