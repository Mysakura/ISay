<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${user.userId ne data[0].sender.userId }">
	<title>互联网说-来自【${data[0].sender.nickname}】的消息</title>
</c:if>
<c:if test="${user.userId ne data[0].receiver.userId }">
	<title>互联网说-来自【${data[0].receiver.nickname}】的消息</title>
</c:if>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome_msg.css">
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
        	<c:if test="${user.userId ne data[0].sender.userId }">
        		<c:set var="otherId" scope="page" value="${data[0].sender.userId}"/>
        		<c:set var="otherName" scope="page" value="${data[0].sender.nickname}"/>
	            <h3 class="text-center">来自<a href="${pageContext.request.contextPath }/user/${data[0].sender.userId }">${data[0].sender.nickname }</a>的消息</h3>
        	</c:if>
        	<c:if test="${user.userId ne data[0].receiver.userId }">
        		<c:set var="otherId" scope="page" value="${data[0].receiver.userId}"/>
        		<c:set var="otherName" scope="page" value="${data[0].receiver.nickname}"/>
	            <h3 class="text-center">来自<a href="${pageContext.request.contextPath }/user/${data[0].receiver.userId }">${data[0].receiver.nickname }</a>的消息</h3>
        	</c:if>
            <div class="col-md-8 col-md-offset-2 col-xs-12">
                <ul class="list-group">
                    <li class="list-group-item">
						<c:forEach items="${data }" var="i">
							<!-- 本人发送的消息 -->
							<c:if test="${user.userId eq i.sender.userId }">
			                    <div class="u-msg-detail">
		                            <div class="me">
		                                <span class="glyphicon glyphicon-triangle-right triangle"></span>
		                                <span class="content">${i.content }</span>
		                            </div>
		                        </div>
							</c:if>
							<!-- 他人发送的消息 -->
							<c:if test="${user.userId eq i.receiver.userId }">
		                        <div class="u-msg-detail">
		                            <div class="other">
		                                <span class="glyphicon glyphicon-triangle-left triangle"></span>
		                                <span class="content">${i.content }</span>
		                            </div>
		                        </div>
							</c:if>
						</c:forEach>
						<!--  
                        <div class="u-msg-detail">
                            <div class="other">
                                <span class="glyphicon glyphicon-triangle-left triangle"></span>
                                <span class="content">你好</span>
                            </div>
                        </div>
                        <div class="u-msg-detail">
                            <div class="me">
                                <span class="glyphicon glyphicon-triangle-right triangle"></span>
                                <span class="content">有事吗？</span>
                            </div>
                        </div>
                        <div class="u-msg-detail">
                            <div class="other">
                                <span class="glyphicon glyphicon-triangle-left triangle"></span>
                                <span class="content">Don't miss out on the ultimate creative resource!</span>
                            </div>
                        </div>
                        <div class="u-msg-detail">
                            <div class="me">
                                <span class="glyphicon glyphicon-triangle-right triangle"></span>
                                <span class="content">Your subscription includes unlimited downloads from our Member Library at no additional cost.</span>
                            </div>
                        </div>
						-->
                        <div class="u-msg-detail">
                            <p class="time">-<f:formatDate value="${data[0].time }" pattern="yyyy-MM-dd"/>-</p>
                        </div>
                        <div class="u-msg-select">
                            <button class="btn btn-sm btn-primary" id="lastHistory" data-lid="${data[0].letter.letterId }" data-me="${user.userId }" data-cur="">上次消息</button>
                            <button class="btn btn-sm btn-primary" id="nextHistory" data-lid="${data[0].letter.letterId }" data-me="${user.userId }" data-cur="">下次消息</button>
                            <button class="btn btn-sm btn-success" id="curHistory" data-lid="${data[0].letter.letterId }" data-me="${user.userId }">最近消息</button>
                            <!-- <button class="btn btn-sm btn-success" id="msgHistory">消息记录</button> -->
                        </div>
                        <div class="u-msg-line">
                            <button class="pull-right btn btn-sm btn-danger" id="closeMsgHistory">关闭</button>
                            <div class="row">
                                <div class="col-xs-12 col-md-8 col-md-offset-2">
                                    <div>
                                        <div class="time-point">
                                            <span class="l-t">2018-01</span>
                                            <span class="glyphicon glyphicon-triangle-bottom child-time-btn" data-has="0"></span>
                                            <span class="r-n">1000条消息</span>
                                            <div class="child-time-list">
                                                <div class="child-time-point">
                                                    <span class="l-t">2018-01-01</span>
                                                    <a href="#" class="r-n">500条消息</a>
                                                </div>
                                                <div class="child-time-point">
                                                    <span class="l-t">2018-01-02</span>
                                                    <a href="#" class="r-n">310条消息</a>
                                                </div>
                                                <div class="child-time-point">
                                                    <span class="l-t">2018-01-03</span>
                                                    <a href="#" class="r-n">190条消息</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="time-point">
                                            <span class="l-t">2018-02</span>
                                            <span class="glyphicon glyphicon-triangle-bottom child-time-btn" data-has="0"></span>
                                            <span class="r-n">10条消息</span>
                                            <!--默认子时间为空-->
                                            <div class="child-time-list"></div>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="time-point">
                                            <span class="l-t">2018-03</span>
                                            <span class="glyphicon glyphicon-triangle-bottom child-time-btn" data-has="0"></span>
                                            <span class="r-n">10条消息</span>
                                            <div class="child-time-list">
                                                <div class="child-time-point">
                                                    <span class="l-t">2018-03-01</span>
                                                    <a href="#" class="r-n">500条消息</a>
                                                </div>
                                                <div class="child-time-point">
                                                    <span class="l-t">2018-03-02</span>
                                                    <a href="#" class="r-n">310条消息</a>
                                                </div>
                                                <div class="child-time-point">
                                                    <span class="l-t">2018-03-03</span>
                                                    <a href="#" class="r-n">190条消息</a>
                                                </div>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
				<div class="u-msg-reply">
                    <div class="reply-content" contenteditable="true" data-tip="回复 ${otherName }"></div>
                    <a href="javascript:;" class="reply-btn" data-lid="${data[0].letter.letterId }" data-oid="${otherId }" id="replyOther">回复</a>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user_home_msg.js"></script>
</body>
</html>