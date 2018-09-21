<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-自述</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail_global_style.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-12">
            <div class="side-menu hidden-xs">
                <h2 class="title">自述<span class="glyphicon glyphicon-star"></span></h2>
                <ul class="list-group list-unstyled">
                	<jsp:include page="common/area.jsp"></jsp:include>
                </ul>
                <div class="write-post-link">
                    <a href="${pageContext.request.contextPath }/card/write_post?type=readme">我也写一个</a>
                </div>
            </div>
            <div class="main-content">
                <ul class="list-group post-wrap">
                    <!-- <li class="list-group-item">比如点击技术：显示技术对本职位的认识以及工作情况</li> -->
                    <c:forEach items="${response.data }" var="i">
	                    <li class="list-group-item post-item" id="${i.postId }">
	                        <h3 class="h3"><a href="${pageContext.request.contextPath }/card/post_details/${i.postId }">${i.postTitle }</a></h3>
	                        <div class="pull-right">
	                            <img class="post-img" src="${i.postCover }">
	                        </div>
	                        <p class="post-p">${i.postShortCut }</p>
	                        <div>
	                            <a href="${pageContext.request.contextPath }/user/${i.user.userId }">${i.user.nickname }</a>
	                            <span class="post-span">发表于：<f:formatDate value="${i.postTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	                            <span class="post-span">浏览[${i.visitNum }]</span>
	                            <span class="post-span">评论[${i.commentNum }]</span>
	                            <div class="pull-right">
	                                <span>领域:</span>
	                                <a href="">${i.workArea.areaName }</a>
	                                <span>分类:</span>
	                                <a href="">${response.classifyShowName }</a>
	                            </div>
	                        </div>
	                    </li>
                	</c:forEach>
                </ul>
                <div class="text-center">
                    <ul class="pagination">
                        <c:forEach items="${response.showPage }" var="p">
							<c:if test="${p.info == 1 }">
								<li><a href="${pageContext.request.contextPath }/card/${response.classifyName }/${p.pageNo }?type=${response.areaType }"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
							</c:if>
							<c:if test="${p.info == 2 }">
								<li><a href="${pageContext.request.contextPath }/card/${response.classifyName }/${p.pageNo }?type=${response.areaType }">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 3 }">
								<li><a href="#">...</a></li>
							</c:if>
							<c:if test="${p.info == 4 }">
								<li class="active"><a href="#">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 5 }">
								<li><a href="${pageContext.request.contextPath }/card/${response.classifyName }/${p.pageNo }?type=${response.areaType }"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
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
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>