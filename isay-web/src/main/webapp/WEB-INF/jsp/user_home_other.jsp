<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-${requestScope.user.nickname }的主页</title>
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
            <div class="userhome-info" style="background-image: url(${pageContext.request.contextPath }/${otherUser.userBg })">
                <div class="col-xs-12 text-center">
                    <img class="u-pic" src="${pageContext.request.contextPath }/${otherUser.userPhoto }">
                </div>
                <div class="col-xs-12 text-center">
                    <h2>${otherUser.nickname }&nbsp;
			        <c:if test="${otherUser.sex eq '男' }">
			        	<span class="sex-man-icon" title="性别：男"></span>
			        </c:if>
			        <c:if test="${otherUser.sex eq '女' }">
			        	<span class="sex-woman-icon" title="性别：女"></span>
			        </c:if>
			        <c:if test="${otherUser.sex eq '保密' }">
			        	<span class="sex-none-icon" title="性别：保密"></span>
			        </c:if>
			        </h2>
                </div>
                <div class="col-xs-12">
                    <div class="u-info text-center">
                        <div class="info-block">
                            <span title="赞成数"><span class="glyphicon glyphicon-thumbs-up"></span>${otherInfusion.upNum }</span>
			                <span title="反对数"><span class="glyphicon glyphicon-thumbs-down"></span>${otherInfusion.downNum }</span>
			                <span title="发帖数"><span class="glyphicon glyphicon-file"></span>${otherInfusion.postNum }</span>
			                <span title="关注者"><span class="glyphicon glyphicon-heart"></span>10</span>
			                <span title="职业"><span class="glyphicon glyphicon-briefcase"></span>${otherUser.job }</span>
			                <span title="毕业于"><span class="glyphicon glyphicon-education"></span>${otherUser.userGraduate }</span>
			                <span title="目前公司"><span class="glyphicon glyphicon-ice-lolly"></span>${otherUser.company }</span>
			                <span title="所在地"><span class="glyphicon glyphicon-map-marker"></span>${otherUser.workplace }</span>
                        </div>
                    </div>
                    <p class="u-btn-wrap text-center">
                        <a href="${pageContext.request.contextPath }/user/${otherUser.userId }" class="u-btn u-btn-red">TA的主页</a>
                        <a href="${pageContext.request.contextPath }/user/pk/${otherUser.userId }" target="_blank" class="u-btn u-btn-red">PK</a>
                        <a href="javascript:;" class="u-btn u-btn-blue" id="openSupportModal">打赏</a>
                        <a href="javascript:;" class="u-btn u-btn-blue" id="openLetterModal">私信</a>
                        <c:if test="${isRelation == 0 }">
	                        <a href="javascript:;" class="u-btn u-btn-blue" data-uid="${otherUser.userId }" id="focusTA">关注</a>
                        </c:if>
                        <c:if test="${isRelation == 1 }">
	                        <a href="javascript:;" class="u-btn u-btn-blue" data-uid="${otherUser.userId }" id="cancelFocusTA">已关注</a>
                        </c:if>
                    </p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1 col-xs-12">
                <ul class="list-group my-post-wrap" id="myPostWrap">
                	<c:forEach items="${response.data }" var="i">
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
                    <a href="javascript:;" class="load-more" data-pageNo="${response.nextPage }" data-isLast="${response.isLast }" data-id="${otherUser.userId }" id="loadOtherPost">Load More</a>
                </div>
            </div>
        </div>
		<div class="modal fade" id="supportModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">打赏</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-6">
                                <div class="text-center">
                                    <img class="support-pic" src="${pageContext.request.contextPath }/${otherUser.userAlipay }">
                                    <p>支付宝</p>
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <div class="text-center">
                                    <img class="support-pic" src="${pageContext.request.contextPath }/${otherUser.userVxin }">
                                    <p>微信</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="letterModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">私信TA</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <textarea maxlength="150" class="form-control chat-textarea" placeholder="有什么要对我说的。控制在150字以内哦"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="submitLetter" data-uid="${otherUser.userId }">OK</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ref/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/other_home.js"></script>
</body>
</html>