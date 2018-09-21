<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-我的收藏</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome_collection.css">
</head>
<body>
<jsp:include page="common/user_head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="userhome-wrap">
        <div class="row">
            <jsp:include page="common/user_info.jsp"></jsp:include>
        </div>
        <div class="row">
            <h3 class="text-center">我收藏的帖子</h3>
            <div class="col-md-10 col-md-offset-1 col-xs-12">
                <ul class="list-group my-post-wrap">
                	<c:forEach items="${response.data }" var="i">
	                    <li class="list-group-item my-post">
	                        <h3 class="h3"><a href="${pageContext.request.contextPath }/card/post_details/${i.postId }">${i.postTitle }</a></h3>
	                        <div class="pull-right">
	                            <img class="my-post-img" src="${i.postCover }">
	                        </div>
	                        <p class="my-post-p">${i.postShortCut }</p>
	                        <div>
	                        	<a href="${pageContext.request.contextPath }/user/${i.user.userId }">${i.user.nickname }</a>
	                            <span class="my-post-span">发表于：<f:formatDate value="${i.postTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	                            <span class="my-post-span">浏览[${i.visitNum }]</span>
	                            <span class="my-post-span">评论[${i.commentNum }]</span>
	                            <a href="javascript:;" class="cancel-collect-post" data-pid="${i.postId }">取消收藏</a>
	                            <div class="pull-right">
	                                <span>所属分类:</span>
	                                <a href="${pageContext.request.contextPath }/card/${i.classify.classifyName }">${i.classify.classifyName }</a>
	                                <span>所属领域:</span>
	                                <a href="">${i.workArea.areaName }</a>
	                            </div>
	                        </div>
	                    </li>
                	</c:forEach>
                </ul>
                <div class="text-center">
                    <ul class="pagination">
                        <c:forEach items="${response.showPage }" var="p">
							<c:if test="${p.info == 1 }">
								<li><a href="${pageContext.request.contextPath }/user/collection/${p.pageNo }"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
							</c:if>
							<c:if test="${p.info == 2 }">
								<li><a href="${pageContext.request.contextPath }/user/collection/${p.pageNo }">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 3 }">
								<li><a href="#">...</a></li>
							</c:if>
							<c:if test="${p.info == 4 }">
								<li class="active"><a href="#">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 5 }">
								<li><a href="${pageContext.request.contextPath }/user/collection/${p.pageNo }"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user_home.js"></script>
</body>
</html>