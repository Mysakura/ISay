<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台-首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/home.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="col-md-8 col-md-offset-2 home-wrap">
        <div class="alert alert-success alert-dismissible fade in" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
            <strong>欢迎登录后台!</strong> <a href="#">${user.nickname }</a>
        </div>
        <!--<div class="alert alert-success alert-dismissible fade in" role="alert">-->
            <!--<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>-->
            <!--<strong>新用户!</strong> <a href="#">Smart</a> 注册了本站-->
        <!--</div>-->
        <!--<div class="alert alert-info alert-dismissible fade in" role="alert">-->
            <!--<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>-->
            <!--<strong>新留言!</strong> <a href="#">Smart</a> 给咱们提意见了-->
        <!--</div>-->
        <!--<div class="alert alert-info alert-dismissible fade in" role="alert">-->
            <!--<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>-->
            <!--<strong>新申请!</strong> <a href="#">Smart</a> 申请了友情链接-->
        <!--</div>-->
        <!--<div class="alert alert-danger alert-dismissible fade in" role="alert">-->
            <!--<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>-->
            <!--<strong>当用户有以上操作，就将消息存入数据库isay_site（可以先放入消息队列），这个表只为显示给管理员看!</strong>-->
        <!--</div>-->

    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>