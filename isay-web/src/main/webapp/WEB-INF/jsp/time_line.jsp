<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-时间轴</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/timeline.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row tl-add-padding">
        <div class="col-xs-10 col-xs-offset-1 col-md-8 col-md-offset-2">
            <div class="col-xs-12">
                <h2 class="text-center">时间轴</h2>
            </div>
        </div>
    </div>
    <div class="tl-wrap col-xs-12 col-xs-offset-0 col-md-8 col-md-offset-2">
        <div class="tl-top-line"></div>
        <div class="tl-content-wrap">
            <ul class="list-unstyled">
                <c:forEach items="${timeline }" var="i">
	                <li class="tl-content-item">
	                    <div class="row">
	                        <div class="col-xs-3 text-right tl-content">
	                            <span class="tl-year"><f:formatDate value="${i.tlTime }" pattern="yyyy"/></span>
	                            <span class="tl-date"><f:formatDate value="${i.tlTime }" pattern="MM.dd"/></span>
	                            <span class="tl-point"></span>
	                        </div>
	                        <div class="col-xs-9 text-left">
	                            <p class="tl-event">${i.tlContent }</p>
	                        </div>
	                    </div>
	                </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>