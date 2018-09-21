<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>领域标签管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row isay-inner">
        <div class="col-md-offset-2 col-md-8">
        </div>
        <div class="col-md-offset-2 col-md-8">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${data }" var="i">
	                <tr>
	                    <td>${i.labelId }</td>
	                    <td>${i.labelName }</td>
	                    <td>
	                        <a href="javascript:;" class="btn btn-danger btn-sm" data-role="delLabel" data-id="${i.labelId }">删除标签</a>
	                    </td>
	                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="modal fade" id="addLabelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title"></h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12">
                                    <input class="form-control" type="text" id="labelName" maxlength="25" placeholder="标签名称">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="submitLabel">OK</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/area.js"></script>
</body>
</html>