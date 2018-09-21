<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/announce_manage.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row isay-inner">
        <div class="col-md-offset-2 col-md-8">
            <a href="${pageContext.request.contextPath }/announce/write" class="write-announce">新公告</a>
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
                <c:forEach items="${response.data }" var="i">
	                <tr>
	                    <td>${i.annId }</td>
	                    <td>${i.annTitle }</td>
	                    <td>${i.annEditor.nickname }</td>
	                    <td>
	                    	<f:formatDate value="${i.annTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	                    </td>
	                    <td>
	                        <a href="${pageContext.request.contextPath }/announce/look/${i.annId }" class="btn btn-default btn-sm">查看</a>
	                        <a href="javascript:;" class="btn btn-danger btn-sm" data-role="delAnnounce" data-id="${i.annId }">删除</a>
	                    </td>
	                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="text-center">
            	<ul class="pagination">
					<c:forEach items="${response.showPage }" var="p">
						<c:if test="${p.info == 1 }">
							<li><a href="${pageContext.request.contextPath }/announce/list/${p.pageNo }"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
						</c:if>
						<c:if test="${p.info == 2 }">
							<li><a href="${pageContext.request.contextPath }/announce/list/${p.pageNo }">${p.pageNo }</a></li>
						</c:if>
						<c:if test="${p.info == 3 }">
							<li><a href="#">...</a></li>
						</c:if>
						<c:if test="${p.info == 4 }">
							<li class="active"><a href="#">${p.pageNo }</a></li>
						</c:if>
						<c:if test="${p.info == 5 }">
							<li><a href="${pageContext.request.contextPath }/announce/list/${p.pageNo }"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
						</c:if>
						<c:if test="${p.info == 6 }">
							<li><span>共&nbsp;${response.allPage }&nbsp;页</span></li>
						</c:if>
					</c:forEach>
				</ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/announce.js"></script>
</body>
</html>