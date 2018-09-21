<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-写投票</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/write_vote.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="write-vote-wrap">
        <div class="row">
            <div class="col-xs-12 col-md-5 col-md-offset-1">
                <h3 class="h3">制定投票</h3>
                <div class="form-group">
                    <select class="form-control" name="areaId" form="vform">
                        <option>-- 请选择领域 --</option>
                        <c:forEach items="${area }" var="i">
                        	<option value="${i.areaId }">${i.areaName }</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="vote-content" contenteditable="true" data-tip="请输入投票说明"></div>
                <div class="vote-options">
                </div>
                <div class="text-center">
                    <a href="javascript:;" class="isay-common-btn" id="addVoteOption"><span class="glyphicon glyphicon-plus"></span> 添加投票选项</a>
                </div>
            </div>
            <div class="col-xs-12 col-md-5">
                <h3 class="h3">预览投票</h3>
                <p class="preview-content"></p>
                <div class="preview-options"></div>
            </div>
            <div class="col-xs-12 text-center add-padding-top">
                <input type="submit" class="isay-common-btn" value="制定好了" form="vform" id="releaseVote">
            </div>
            <form action="${pageContext.request.contextPath }/card/submit_vote" method="post" id="vform">
            	<input type="hidden" name="voteTime" id="voteTime">
            	<textarea style="display: none;" name="voteContent" id="voteContent"></textarea>
            </form>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/write_vote.js"></script>
</body>
</html>