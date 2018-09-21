<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-${sessionScope.user.nickname }</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome.css">
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
            <div class="col-md-10 col-md-offset-1 col-xs-12">
                <ul class="list-group my-post-wrap" id="myPostWrap">
                	<c:forEach items="${response.data }" var="i">
                		<c:if test="${i.isDelete ne '1' }">
		                    <li class="list-group-item my-post" id="${i.postId }">
		                        <h3 class="h3"><a href="${pageContext.request.contextPath }/card/post_details/${i.postId }">${i.postTitle }</a></h3>
		                        <div class="pull-right">
		                            <img class="my-post-img" src="${i.postCover }">
		                        </div>
		                        <p class="my-post-p">${i.postShortCut }</p>
		                        <div>
		                            <span class="my-post-span">发表于：<f:formatDate value="${i.postTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
		                            <span class="my-post-span">浏览[${i.visitNum }]</span>
		                            <span class="my-post-span">评论[${i.commentNum }]</span>
		                            <a href="${pageContext.request.contextPath }/card/edit_post/${i.postId }" data-pid="${i.postId }" class="my-post-edit">编辑</a>
		                            <a href="javascript:;" data-pid="${i.postId }" class="my-post-del">删除</a>
		                            <div class="pull-right">
		                                <span>所属分类:</span>
		                                <a href="${pageContext.request.contextPath }/card/${i.classify.classifyName }">${i.classify.classifyName }</a>
		                                <span>所属领域:</span>
		                                <a href="">${i.workArea.areaName }</a>
		                            </div>
		                        </div>
		                    </li>
                		</c:if>
                	</c:forEach>
                	<!--  
                    <li class="list-group-item my-post">
                        <h3 class="h3"><a href="#">Java是最好的语言</a></h3>
                        <div class="pull-right">
                            <img class="my-post-img" src="${pageContext.request.contextPath }/test_pic/1.jpg">
                        </div>
                        <p class="my-post-p">都说别小看公司扫地的，他们都是生藏不漏的角色。
                        </p>
                        <div>
                            <span class="my-post-span">发表于：2017-10-02 20:38:20</span>
                            <span class="my-post-span">浏览[525]</span>
                            <span class="my-post-span">评论[58]</span>
                            <div class="pull-right">
                                <span>所属分类:</span>
                                <a href="">自述</a>
                            </div>
                        </div>
                    </li>
                	-->
                </ul>
                <div class="text-center">
                    <a href="javascript:;" class="load-more" data-pageNo="${response.nextPage }" data-isLast="${response.isLast }" id="loadOwnPost">Load More</a>
                </div>
                <!--  
                <div class="text-center">
                    <ul class="pagination">
                        <li><a href="${pageContext.request.contextPath }/.../${p.pageNo }"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
                        <li><a href="${pageContext.request.contextPath }/.../${p.pageNo }">1</a></li>
                        <li><a href="#">...</a></li>
                        <li class="active"><a href="#">5</a></li>
                        <li><a href="${pageContext.request.contextPath }/.../${p.pageNo }"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
                        <li><span>共 10 页</span></li>
                    </ul>
                </div>
                -->
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user_home.js"></script>
</body>
</html>