<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-意见反馈</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/message_board.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row mb-add-padding">
        <div class="col-xs-10 col-xs-offset-1 col-md-8 col-md-offset-2">
            <div class="col-xs-12">
                <h2 class="text-center">意见反馈</h2>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1 col-xs-12 col-xs-offset-0">
            <div class="mb-wrap">
                <div class="well message-input-wrap">
                    <div class="message-input" contenteditable="true" data-tip="留下您的意见和建议"></div>
                    <div class="message-tools">
                        <a class="tool-btn" href="javascript:;" id="leaveMessage"><span class="glyphicon glyphicon-send"></span> 留言</a>
                        <a class="tool-btn" href="javascript:;">
                            <span class="glyphicon glyphicon-picture"></span> 添加图片
                            <input class="file-input" type="file" accept="image/jpeg,image/png,image/gif" name="imgFile" id="messageImgFile">
                        </a>
                    </div>
                </div>
                <ul class="list-group">
                	<c:forEach items="${response.data }" var="i">
                    <li class="list-group-item" id="${i.messageId }">
                        <div class="message-wrap">
                            <div class="row">
                            	<c:if test="${i.isDelete eq '0' }">
	                                <div class="col-md-12">
	                                    <div class="user-photo">
	                                        <img src="${pageContext.request.contextPath }/${i.user.userPhoto }">
	                                    </div>
	                                    <div class="message-info">
	                                        <a href="${pageContext.request.contextPath }/user/${i.user.userId }">${i.user.nickname }</a>
	                                        <span><f:formatDate value="${i.messageTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	                                    </div>
	                                    <div class="message-operate">
	                                        <a href="javascript:;" data-role="reply" data-mid="${i.messageId }" data-uname="${i.user.nickname }" data-uid="${i.user.userId }">回复</a>
	                                        <a href="javascript:;" data-role="delete" data-mid="${i.messageId }">删除</a>
	                                    </div>
	                                </div>
	                                <div class="col-md-12">
	                                    <div class="message-content">${i.messageContent }</div>
	                                </div>
                            	</c:if>
                            	<c:if test="${i.isDelete eq '1' }">
	                                <div class="col-md-12">
	                                    <div class="user-photo">
	                                        <img src="${pageContext.request.contextPath }/${i.user.userPhoto }">
	                                    </div>
	                                    <div class="message-info">
	                                        <a href="${pageContext.request.contextPath }/user/${i.user.userId }">${i.user.nickname }</a>
	                                        <span><f:formatDate value="${i.messageTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	                                    </div>
	                                </div>
	                                <div class="col-md-12">
	                                    <div class="message-content allready-del">该留言已被删除！</div>
	                                </div>
                            	</c:if>
                            </div>
                        </div>
                        <div class="reply-wrap">
                            <ul class="list-group list-unstyled">
                            	<c:forEach items="${i.replies }" var="j">
	                                <li class="reply-li" id="${j.mrId }">
	                                    <div class="user-info">
	                                        <a href="${pageContext.request.contextPath }/user/${j.fromUser.userId }">${j.fromUser.nickname }</a>
	                                        <span>回复</span>
	                                        <a href="${pageContext.request.contextPath }/user/${j.toUser.userId }">${j.toUser.nickname }</a>
	                                    </div>
	                                    <c:if test="${j.isDelete eq '1' }">
	                                    	<div class="reply-content allready-del">该回复已被删除！</div>
		                                    <div class="reply-operate">
		                                        <span class="reply-time"><f:formatDate value="${j.mrTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
		                                    </div>
	                                    </c:if>
	                                    <c:if test="${j.isDelete eq '0' }">
		                                    <div class="reply-content">${j.mrContent }</div>
		                                    <div class="reply-operate">
		                                        <span class="reply-time"><f:formatDate value="${j.mrTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
		                                        <a href="javascript:;" data-role="reply" data-mid="${i.messageId }" data-uname="${j.fromUser.nickname }" data-uid="${j.fromUser.userId }">回复</a>
		                                        <a href="javascript:;" data-role="delete" data-rid="${j.mrId }">删除</a>
		                                    </div>
	                                    </c:if>
	                                </li>
                            	</c:forEach>
                            </ul>
                            <!--<div class="well message-input-wrap reply-input-wrap" id="messageReplyWrap">-->
                                <!--<div class="message-input reply-input" contenteditable="true" data-tip="回复 Mary"></div>-->
                                <!--<div class="message-tools">-->
                                    <!--<a class="tool-btn" href="javascript:;" id="leaveReply"><span class="glyphicon glyphicon-send"></span> 回复</a>-->
                                    <!--<a class="tool-btn" href="javascript:;">-->
                                        <!--<span class="glyphicon glyphicon-picture"></span> 添加图片-->
                                        <!--<input class="file-input" type="file" accept="image/jpeg,image/png,image/gif" name="imgFile" id="replyImgFile">-->
                                    <!--</a>-->
                                <!--</div>-->
                            <!--</div>-->
                        </div>
                    </li>
                	</c:forEach>
                </ul>
				<div class="page-split">
					<c:forEach items="${response.showPage }" var="p">
						<c:if test="${p.info == 1 }">
							<a href="${pageContext.request.contextPath }/message_board/${p.pageNo }">上一页</a>
						</c:if>
						<c:if test="${p.info == 2 }">
							<a href="${pageContext.request.contextPath }/message_board/${p.pageNo }">${p.pageNo }</a>
						</c:if>
						<c:if test="${p.info == 3 }">
							<span>...</span>
						</c:if>
						<c:if test="${p.info == 4 }">
							<a href="#" class="selected">${p.pageNo }</a>
						</c:if>
						<c:if test="${p.info == 5 }">
							<a href="${pageContext.request.contextPath }/message_board/${p.pageNo }">下一页</a>
						</c:if>
						<c:if test="${p.info == 6 }">
							<span>共 ${p.pageNo } 页</span>
						</c:if>
					</c:forEach>
				</div>
            </div>
        </div>
    </div>
    <div class="mb-add-margin"></div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ref/ajaxfileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/message_board.js"></script>
</body>
</html>