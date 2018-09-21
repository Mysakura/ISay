<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-公司印象</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail_global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/company.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-12">
            <div class="side-menu hidden-xs">
                <h2 class="title">公司印象 <span class="glyphicon glyphicon-heart-empty"></span></h2>
                <ul class="list-group list-unstyled">
                    <li><input type="text" class="company-search-input" id="searchByNameInput" placeholder="请输入公司名称"></li>
                    <li><a class="active" href="javascript:;" id="searchByName">查询</a></li>
                    <li><input type="text" class="company-search-input" id="addCompanyInput" placeholder="没找到？添加公司名称"></li>
                    <li><a class="active" href="javascript:;" id="addCompany">添加</a></li>
                </ul>
            </div>
            <div class="main-content">
                <ul class="list-group post-wrap">
                	<li class="list-group-item">
                        <a href="javascript:;" class="already-exist btn btn-success" id="alreadyExist">已有公司列表</a>
                        <div class="exist-list">
                        	<c:forEach items="${response.data }" var="i">
	                            <a href="javascript:;" data-id="${i.companyId }">${i.companyName }</a>
                        	</c:forEach>
                        </div>
                    </li>
                    <li class="list-group-item post-item">
                        <h3 class="h3 text-center text-info" id="companyTitle"></h3>
                        <div class="text-right company-evaluate">
                            <a href="javascript:;">
                                <span class="e-num" id="goodLabelNum">0</span>
                                	好评 <span class="glyphicon glyphicon-thumbs-up"></span>
                            </a>
                            <a href="javascript:;">
                                <span class="e-num" id="badLabelNum">0</span>
                                	差评 <span class="glyphicon glyphicon-thumbs-down"></span>
                            </a>
                            <a href="javascript:;" id="putCompanyLabel" data-companyId="">
                                <span class="e-num" id="labelNum">0</span>
                                	添加标签 <span class="glyphicon glyphicon-tags"></span>
                            </a>
                        </div>
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">感觉公司如何？</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <input type="text" class="form-control" maxlength="10" id="companyLabelInput" placeholder="写下你的真实感受，10字以内">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary" id="putGood">Good</button>
                                        <button type="button" class="btn btn-danger" id="putBad">Bad</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="company-labels">
                        	<!--  
                            <span class="company-labels-item c-ok" title="Tom 说">Good</span>
                        	-->
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ref/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/company.js"></script>
</body>
</html>