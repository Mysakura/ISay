<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-搜索结果</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail_global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/search_result.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-12">
            <div class="side-menu hidden-xs">
                <h2 class="title">热门搜索<span class="glyphicon glyphicon-fire"></span></h2>
                <ul class="list-group list-unstyled">
                    <li><a href="#">Java</a></li>
                    <li><a href="#">分布式</a></li>
                    <li><a href="#">大数据</a></li>
                </ul>
            </div>
            <div class="main-content">
                <div class="row">
                    <p class="text-center search-key-result">关键词[<strong class="text-success">${key }</strong>]搜索结果</p>
                </div>
                <div class="row">
                    <ul class="list-group post-wrap">
                    	<c:forEach items="${data }" var="i">
	                        <li class="list-group-item post-item">
	                            <h3 class="h3"><a href="${pageContext.request.contextPath }/card/post_details/${i.postId }">${i.postTitle }</a></h3>
	                            <div class="pull-right">
	                                <img class="post-img" src="${i.postCover }">
	                            </div>
	                            <p class="post-p">${i.postContent }</p>
	                            <div>
	                                <span class="post-span">发表于：<f:formatDate value="${i.postTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	                            </div>
	                        </li>
                    	</c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>