<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-公告列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/announce.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/article.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row announce-add-padding">
        <div class="col-xs-10 col-xs-offset-1 col-md-8 col-md-offset-2">
            <div class="col-xs-12">
                <h2 class="text-center">公告列表</h2>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2 ">
            <ul class="list-group list-unstyled">
            	<c:forEach items="${response.data }" var="i">
	                <li class="list-group-item">
	                    <a href="${pageContext.request.contextPath }/announcement/${i.annId}">${i.annTitle }</a>
	                    <span class="pull-right">
	                    	<f:formatDate value="${i.annTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	                    </span>
	                </li>
            	</c:forEach>
            </ul>
            <div class="page-split">
				<c:forEach items="${response.showPage }" var="p">
					<c:if test="${p.info == 1 }">
						<a href="${pageContext.request.contextPath }/announcement_list/${p.pageNo }">上一页</a>
					</c:if>
					<c:if test="${p.info == 2 }">
						<a href="${pageContext.request.contextPath }/announcement_list/${p.pageNo }">${p.pageNo }</a>
					</c:if>
					<c:if test="${p.info == 3 }">
						<span>...</span>
					</c:if>
					<c:if test="${p.info == 4 }">
						<a href="#" class="selected">${p.pageNo }</a>
					</c:if>
					<c:if test="${p.info == 5 }">
						<a href="${pageContext.request.contextPath }/announcement_list/${p.pageNo }">下一页</a>
					</c:if>
					<c:if test="${p.info == 6 }">
						<span>共 ${p.pageNo } 页</span>
					</c:if>
				</c:forEach>
			</div>
        </div>
    </div>
    <div class="announce-add-margin"></div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>