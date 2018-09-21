<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>友链管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/friend_manage.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row isay-inner">
        <div class="col-md-offset-2 col-md-8 friend-list-type">
            <a href="${pageContext.request.contextPath }/friend/all">全部</a>
            <span>|</span>
            <a href="${pageContext.request.contextPath }/friend/uncheck">未审核</a>
            <span>|</span>
            <a href="${pageContext.request.contextPath }/friend/accept">通过</a>
            <span>|</span>
            <a href="${pageContext.request.contextPath }/friend/deny">未通过</a>
        </div>
        <div class="col-md-offset-2 col-md-8">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>URL</th>
                    <th>申请者</th>
                    <th>处理者</th>
                    <th>Status</th>
                    <th>Time</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${data }" var="i" varStatus="st">
	                <tr>
	                    <td>${st.index }</td>
	                    <td><a href="${i.flUrl }">${i.flName }</a></td>
	                    <td>${i.flUser.nickname }</td>
	                    <td>
	                    	<c:if test="${i.flOk ne '0' }">${i.flAdmin.nickname }</c:if>
	                    </td>
	                    <td>
	                    	<c:if test="${i.flOk eq '0' }">未处理</c:if>
	                    	<c:if test="${i.flOk eq '1' }">不通过</c:if>
	                    	<c:if test="${i.flOk eq '2' }">已通过</c:if>
	                    </td>
	                    <td>
	                    	<f:formatDate value="${i.flTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	                    </td>
	                    <td>
	                    	<c:if test="${i.flOk eq '0' }">
	                    		<a href="javascript:;" class="btn btn-success btn-sm" data-role="accept" data-id="${i.flId }">通过</a>
	                    		<a href="javascript:;" class="btn btn-danger btn-sm" data-role="deny" data-id="${i.flId }">拒绝</a>
	                    	</c:if>
	                    	<c:if test="${i.flOk eq '1' }">
	                    		<a href="javascript:;" class="btn btn-success btn-sm" data-role="accept" data-id="${i.flId }">通过</a>
	                    	</c:if>
	                    	<c:if test="${i.flOk eq '2' }">
	                    		<a href="javascript:;" class="btn btn-danger btn-sm" data-role="deny" data-id="${i.flId }">拒绝</a>
	                    	</c:if>
	                    </td>
	                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/friend.js"></script>
</body>
</html>