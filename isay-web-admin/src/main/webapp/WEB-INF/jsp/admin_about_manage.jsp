<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>About管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/about_manage.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row isay-inner">
        <div class="col-md-offset-2 col-md-8 about-list-type">
            <a href="${pageContext.request.contextPath }/about/write">新关于</a>
        </div>
        <div class="col-md-offset-2 col-md-8">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Editor</th>
                    <th>Time</th>
                    <th>Operate</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${data }" var="i">
	                <tr>
	                    <td>${i.aboutId }</td>
	                    <td>
	                    	<c:if test="${i.aboutType eq '1' }">关于站点</c:if>
	                    	<c:if test="${i.aboutType eq '2' }">关于作者</c:if>
	                    	<c:if test="${i.aboutType eq '3' }">联系方式</c:if>
	                    </td>
	                    <td>${i.aboutEditor.nickname }</td>
	                    <td>
	                    	<f:formatDate value="${i.aboutTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	                    </td>
	                    <td>
	                        <a href="${pageContext.request.contextPath }/about/look/${i.aboutId }" class="btn btn-default btn-sm">查看</a>
	                        <a href="javascript:;" class="btn btn-danger btn-sm" data-role="delAbout" data-id="${i.aboutId }">删除</a>
	                    </td>
	                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/about.js"></script>
</body>
</html>