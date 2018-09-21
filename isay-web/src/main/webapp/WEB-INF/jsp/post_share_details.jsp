<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-【${post.postTitle }】</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/editormd/editormd.preview.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/editormd/editormd.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/post_details.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/post_share_details.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-12 col-md-8 col-md-offset-2">
            <div class="col-xs-12">
                <h1 class="text-center pd-title">${post.postTitle }</h1>
                <div class="pd-post-info">
                    <a href="${pageContext.request.contextPath }/user/${post.user.userId }">${post.user.nickname }</a>
                    <span class="info-item">发表于[<f:formatDate value="${post.postTime }" pattern="yyyy-MM-dd HH:mm:ss"/>]</span>
                    <span class="info-item">阅读[${post.visitNum }]</span>
                    <span class="info-item">收藏[${post.collectionNum }]</span>
                    <span class="info-item">赞成[${post.upNum }]</span>
                    <span class="info-item">反对[${post.downNum }]</span>
                    <button type="button" class="btn btn-info btn-sm" id="modifyHistory">修改历史</button>
                </div>
            </div>
            <div class="mofify-history">
            	<h3 class="title">版本历史</h3>
            	<ul>
            		<c:forEach items="${postShare }" var="i">
            		<li>
            			<a href="javascript:;" data-shareid="${i.shareId }" class="look-history">查看</a>
            			<a href="${pageContext.request.contextPath }/card/edit_own_share_post/${i.shareId }?title=${post.postTitle }" target="_blank" class="go-modify">修改</a>
            			<span class="author-span">作者：</span>
            			<a href="${pageContext.request.contextPath }/user/${i.user.userId }" class="author-info">${i.user.nickname }</a>
            		</li>
            		</c:forEach>
            	</ul>
            	<a type="button" class="close-btn" id="closeModifyHistory">
            		<span class="glyphicon glyphicon-remove"></span>
            	</a>
            </div>
            <div id="content">${post.postContent }</div>
            <div class="col-xs-12">
                <div class="text-right pd-tail">
                    <label><span class="glyphicon glyphicon-th-large"></span> 分类:</label>
                    <a href="${pageContext.request.contextPath }/card/${post.classify.classifyName }">${post.classify.classifyName }</a>
                </div>
                <div class="text-right pd-tail">
                    <label><span class="glyphicon glyphicon-tags"></span> 标签:</label>
                    <c:forEach items="${post.labels }" var="l">
	                    <a href="">${l.labelName }</a>
                    </c:forEach>
                </div>
            </div>
            <div class="col-xs-12">
                <div class="pd-tail-operate">
                    <a href="javascript:;"><span class="glyphicon glyphicon-glass"></span> 打赏</a>
                    <a href="javascript:;" data-pid="${post.postId }" id="supportPost"><span class="glyphicon glyphicon-thumbs-up"></span> 赞成</a>
                    <a href="javascript:;" data-pid="${post.postId }" id="denyPost"><span class="glyphicon glyphicon-thumbs-down"></span> 反对</a>
                    <a href="javascript:;" data-pid="${post.postId }" id="collectPost"><span class="glyphicon glyphicon-star"></span> 收藏</a>
                    <a href="#say-comment"><span class="glyphicon glyphicon-comment"></span> 评论</a>
                    <a href="${pageContext.request.contextPath }/card/edit_share_post/${post.postId }"><span class="glyphicon glyphicon-pencil"></span> 参与完善</a>
                </div>
            </div>
            <div class="col-xs-12">
                <div class="pd-comment-wrap">
                    <h4 class="text-center text-primary">评论</h4>
                    <ul class="list-group">
                    	<!-- ${fn:length(response.data) } -->
                    	<c:forEach items="${response.data }" var="i">
                    		<c:if test="${i.isDelete == 1 }">
                    			<li class="list-group-item" id="${i.commentId }">
		                            <div class="user-info">
		                                <div class="user-photo">
		                                    <img src="${pageContext.request.contextPath }/${i.user.userPhoto }">
		                                </div>
		                                <div class="user-extra">
		                                    <a href="${pageContext.request.contextPath }/user/${i.user.userId }">${i.user.nickname }</a>
		                                    <span class="comment-time"><f:formatDate value="${i.commentTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
		                                </div>
		                            </div>
		                            <div class="comment comment-del">该评论已被删除！</div>
		                        </li>
                    		</c:if>
                    		<!-- ${i.isDelete} -->
                    		<c:if test="${i.isDelete == 0 or i.isDelete eq null }">
		                        <li class="list-group-item" id="${i.commentId }">
		                            <div class="user-info">
		                                <div class="user-photo">
		                                    <img src="${pageContext.request.contextPath }/${i.user.userPhoto }">
		                                </div>
		                                <div class="user-extra">
		                                    <a href="${pageContext.request.contextPath }/user/${i.user.userId }">${i.user.nickname }</a>
		                                    <span class="comment-time"><f:formatDate value="${i.commentTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
		                                </div>
		                                <div class="user-operate">
		                                    <a href="javascript:;" class="user-operate-btn" data-role="cReply" data-cid="${i.commentId }" data-uname="${i.user.nickname }" data-uid="${i.user.userId }">回复</a>
		                                    <a href="javascript:;" class="user-operate-btn" data-role="cDel" data-cid="${i.commentId }" data-pid="${post.postId }">删除</a>
		                                    <a href="javascript:;" class="show-reply" data-role="showReply" data-cid="${i.commentId }" data-rnum="${i.replyNum }" data-page="1" data-isLast="1">回复列表&nbsp;(${i.replyNum })</a>
		                                </div>
		                            </div>
		                            <div class="comment">${i.commentContent }</div>
		                            <div class="pd-reply-wrap">
		                                <ul class="list-unstyled">
		                                	<!-- 回复 -->
		                                </ul>
		                            </div>
		                        </li>
                    		</c:if>
                    	</c:forEach>
                    </ul>
                    <div class="text-center">
	                    <a href="javascript:;" class="load-more" data-pageNo="${response.nextPage }" data-isLast="${response.isLast }" data-pid="${post.postId }" id="loadComment">Load More</a>
	                </div>
                </div>
                <div class="well pd-release-comment-wrap">
                    <div id="say-comment" class="comment-input" contenteditable="true" data-tip="留下你的见解"></div>
                    <div class="comment-tools">
                        <a class="tool-btn" href="javascript:;" id="leaveComment" data-pid="${post.postId }"><span class="glyphicon glyphicon-send"></span> 评论</a>
                        <a class="tool-btn" href="javascript:;">
                            <span class="glyphicon glyphicon-picture"></span> 添加图片
                            <input class="file-input" type="file" accept="image/jpeg,image/png,image/gif" name="imgFile" id="commentFile">
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/editormd/lib/marked.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/editormd/lib/prettify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/editormd/editormd.min.js"></script>
<script type="text/javascript">
    editormd.markdownToHTML("content");//
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ref/ajaxfileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/post_detail_comment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/post_detail.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/post_share_detail.js"></script>
</body>
</html>