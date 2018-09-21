<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-闲聊</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail_global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/throw_pot.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-12">
            <div class="side-menu hidden-xs">
                <h2 class="title" title="一个吐(xian)槽(liao)的地方">甩锅<span class="glyphicon glyphicon-flash"></span></h2>
                <ul class="list-group list-unstyled">
                    <li><a href="${pageContext.request.contextPath }/card/throw_pot_chat">闲聊</a></li>
                    <li><a href="${pageContext.request.contextPath }/card/${areaType }?type=1">技术</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=2">产品</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=3">设计</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=4">运营</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=5">市场</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=6">职能</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=7">金融</a></li>
                </ul>
                <div class="write-post-link">
                    <a href="javascript:;" id="iPot">我要甩锅</a>
                    <a href="javascript:;" id="iChat">我要闲聊</a>
                </div>
            </div>
            <div class="main-content">
                <h3 class="text-center">如果你没啥可聊的，说明你不够闲</h3>
                <div>
                    <a href="${pageContext.request.contextPath }/card/throw_pot_chat">全部闲聊</a>
                    <span>|</span>
                    <a href="${pageContext.request.contextPath }/card/my_chat">我的闲聊</a>
                </div>
                <ul class="list-group chat-wrap">
                	<c:forEach items="${response.data }" var="i">
                	<c:if test="${i.isDelete == '0' }">
	                    <li class="list-group-item chat-item" id="${i.chatId }">
	                        <div>
	                            <div class="pull-left">
	                                <img class="chat-user-photo" src="${pageContext.request.contextPath }/${i.user.userPhoto}">
	                            </div>
	                            <div class="chat-user-info">
	                                <p>
	                                    <a href="${pageContext.request.contextPath }/user/${i.user.userId}">${i.user.nickname }</a>
	                                    <span class="tp-time">发表于<f:formatDate value="${i.chatTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	                                    <a href="javascript:;" class="iReply" data-uid="${i.user.userId}" data-uname="${i.user.nickname }" data-chatid="${i.chatId }">回复</a>
	                                    <a href="javascript:;" class="iDelChat" data-chatid="${i.chatId }">删除</a>
	                                </p>
	                                <p class="chat-content">${i.chatContent }</p>
	                            </div>
	                            <ul class="list-unstyled chat-item-reply-wrap">
	                            	<c:forEach items="${i.replies }" var="j">
	                            	<c:if test="${j.isDelete == '0' }">
		                                <li class="reply">
		                                    <a href="${pageContext.request.contextPath }/user/${j.replyUser.userId}">${j.replyUser.nickname }</a> 回复 <a href="${pageContext.request.contextPath }/user/${j.targetUser.userId}">${j.targetUser.nickname }</a>：
		                                    <p class="reply-content">${j.replyContent }</p>
		                                    <span class="tp-time"><f:formatDate value="${j.replyTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
		                                    <a href="javascript:;" class="iReply" data-uid="${j.replyUser.userId}" data-uname="${j.replyUser.nickname }" data-chatid="${i.chatId }">回复</a>
		                                    <a href="javascript:;" class="iDelReply" data-replyid="${j.replyId }">删除</a>
		                                </li>
	                            	</c:if>
	                            	<c:if test="${j.isDelete == '1' }">
		                                <li class="reply">
		                                    <a href="${pageContext.request.contextPath }/user/${j.replyUser.userId}">${j.replyUser.nickname }</a> 回复 <a href="${pageContext.request.contextPath }/user/${j.targetUser.userId}">${j.targetUser.nickname }</a>：
		                                    <p class="reply-content already-del">该回复已经删除！</p>
		                                    <span class="tp-time"><f:formatDate value="${j.replyTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
		                                </li>
	                            	</c:if>
	                            	</c:forEach>
	                            </ul>
	                        </div>
	                    </li>
                	</c:if>
                	<c:if test="${i.isDelete == '1' }">
                		<!-- 已删除 -->
	                    <li class="list-group-item chat-item" id="${i.chatId }">
	                        <div>
	                            <div class="pull-left">
	                                <img class="chat-user-photo" src="${pageContext.request.contextPath }/${i.user.userPhoto}">
	                            </div>
	                            <div class="chat-user-info">
	                                <p>
	                                    <a href="${pageContext.request.contextPath }/user/${i.user.userId}">${i.user.nickname }</a>
	                                    <span class="tp-time">发表于<f:formatDate value="${i.chatTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	                                </p>
	                                <p class="chat-content already-del">该闲聊已删除！</p>
	                            </div>
	                            <ul class="list-unstyled chat-item-reply-wrap"></ul>
	                        </div>
	                    </li>
                	</c:if>
                	</c:forEach>
                	<!--  
                    <li class="list-group-item chat-item">
                        <div>
                            <div class="pull-left">
                                <img class="chat-user-photo" src="user_photo/1.jpg">
                            </div>
                            <div class="chat-user-info">
                                <p>
                                    <a href="">Tom</a>
                                    发表于<span class="tp-time">2017-10-06 10:30:44</span>
                                    <a href="javascript:;" class="iReply">回复</a>
                                </p>
                                <p>赛码网（ACMcoder）由大型人力资源中央企业中智集团（CIIC）孵化，用互联网跨界思维改变长久以来纸笔的考试方式，是一站式的企业/机构/学校在线考试平台</p>
                            </div>
                            <ul class="list-unstyled chat-item-reply-wrap">
                                <li class="reply">
                                    <a href="">Tom</a> 回复 <a href="">Mary</a>：
                                    <p class="reply-content">满足大型招聘考试、企业内部选拔、培训考核评定、学校教育测评等多种考试需求</p>
                                    <span class="tp-time">2017-10-06 10:30:44</span>
                                    <a href="javascript:;" class="iReply">回复</a>
                                </li>
                                <li class="reply">
                                    <a href="">Tom</a> 回复 <a href="">Mary</a>：
                                    <p class="reply-content">满足大型招聘考试、企业内部选拔、培训考核评定、学校教育测评等多种考试需求</p>
                                    <span class="tp-time">2017-10-06 10:30:44</span>
                                    <a href="javascript:;" class="iReply">回复</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                	-->
                </ul>
                <div class="text-center">
                    <a href="javascript:;" class="load-more" data-pageNo="${response.nextPage }" data-isLast="${response.isLast }" data-role="${chatRole }" id="loadMoreChat">Load More</a>
                </div>
            </div>
            <!--甩锅-->
            <div class="modal fade" id="potModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">没事甩个锅</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12">

                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon">我是</span>
                                            <select class="form-control" id="fieldSelectionFrom">
                                                <option>-- 选择你的门派 --</option>
                                                <option>技术</option>
                                                <option>产品</option>
                                                <option>设计</option>
                                                <option>运营</option>
                                                <option>市场</option>
                                                <option>职能</option>
                                                <option>金融</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon">送给</span>
                                            <select class="form-control" id="fieldSelectionTo">
                                                <option>-- 选择目标门派 --</option>
                                                <option>技术</option>
                                                <option>产品</option>
                                                <option>设计</option>
                                                <option>运营</option>
                                                <option>市场</option>
                                                <option>职能</option>
                                                <option>金融</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon">Gift</span>
                                            <select class="form-control" id="giftSelection">
                                                <option>-- 选择Gift --</option>
                                                <option value="flower">一朵小红发</option>
                                                <option value="hammer">一把镇定锤</option>
                                                <option value="pot">一个平底锅</option>
                                                <option value="ak47">一梭子AK47</option>
                                                <option value="nuclear">一个核武器</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="text-center">
                                            <span id="showGift" class="weapon"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="putPot">OK</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--闲聊-->
            <div class="modal fade" id="chatModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">没事吐个槽</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12">
                                    <textarea maxlength="150" class="form-control chat-textarea" id="chatContent" placeholder="有啥不(fen)爽(xiang)，说出来让大家开心开心。控制在150字以内哦"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="putChat">OK</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--回复-->
            <div class="modal fade" id="replyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">回复<strong id="replyTarget"></strong></h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12">
                                    <textarea maxlength="150" class="form-control chat-textarea" id="replyContent" placeholder="控制在150字以内哦"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="putReply">OK</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ref/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/throw_pot.js"></script>
</body>
</html>