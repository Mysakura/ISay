<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>事件管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/timeline_manage.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row isay-inner">
        <div class="col-md-offset-2 col-md-8">
            <a href="javascript:void(0)" class="write-timeline">新的事件</a>
        </div>
        <div class="col-md-offset-2 col-md-8">
            <ul class="list-group">
            	<c:forEach items="${data }" var="i">
	                <li class="list-group-item list-group-item-info tl-item">
	                    <div class="pull-right tl-time">
	                        <div>
	                        	<f:formatDate value="${i.tlTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	                        </div>
	                        <a type="button" class="btn btn-danger btn-sm" data-role="delLine" data-id="${i.tlId }">删除</a>
	                    </div>
	                    <div class="tl-content">${i.tlContent }</div>
	                </li>
            	</c:forEach>
            </ul>
        </div>
        <div class="modal fade" id="addTimeLineModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">添加事件</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <textarea class="form-control timeline-textarea" placeholder="新的事件" maxlength="250"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="submitTimeline">OK</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/timeline.js"></script>
</body>
</html>