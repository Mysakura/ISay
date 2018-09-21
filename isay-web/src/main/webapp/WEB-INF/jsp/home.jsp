<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说--互联网圈子的那些事儿</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/home.css">
</head>
<body>
	<jsp:include page="common/head.jsp"></jsp:include>
    <!--内容-->
    <div class="container-fluid isay-container">
        <div class="home-banner-wrap">
            <div class="home-banner-table">
                <div class="home-banner banner-1">
                    <h1 class="title">互联网说</h1>
                    <p class="info">一个为互联网新人服务的社区</p>
                </div>
            </div>
        </div>
        <div class="home-banner-wrap text-center">
            <div class="col-md-10 col-md-offset-1 home-add-padding">
                <div class="col-md-4">
                    <h2><span class="glyphicon glyphicon-heart"></span></h2>
                    <h3>帮助新人</h3>
                    <p>每个人都是曾经的“新人”，“新人”需要挫折，但也需要帮助</p>
                </div>
                <div class="col-md-4">
                    <h2><span class="glyphicon glyphicon-glass"></span></h2>
                    <h3>交流经验</h3>
                    <p>无论是“新人”还是“老司机”，分享你的心得，让更多的人认识你</p>
                </div>
                <div class="col-md-4">
                    <h2><span class="glyphicon glyphicon-ok"></span></h2>
                    <h3>一起成长</h3>
                    <p>最终的目的——就是<strong>成长</strong>!</p>
                </div>
            </div>
        </div>
        <div class="home-banner-wrap">
            <div class="home-banner-child-wrap">
                <div class="col-md-6 home-banner-child banner-2"></div>
                <div class="col-md-6">
                    <div class="home-banner-child-table">
                        <div class="home-banner-child-cell">
                            <h1 class="title">For新人</h1>
                            <p class="info">那么你来对了，我们找的就是你</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="home-banner-wrap">
            <div class="home-banner-child-wrap">
                <div class="col-md-6">
                    <div class="home-banner-child-table">
                        <div class="home-banner-child-cell">
                            <h1 class="title">For牛人老司机</h1>
                            <p class="info">那么你就是引路人，我们需要你</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 home-banner-child banner-3"></div>
            </div>
        </div>
        <div class="home-get-start text-center">
            <a class="link-btn" href="${pageContext.request.contextPath }/card/statistics" title="使用指南">Getting Start</a>
        </div>
    </div>
	<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>