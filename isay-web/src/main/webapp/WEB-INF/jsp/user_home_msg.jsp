<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-我的消息</title>
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
            <h3 class="text-center">我收到的消息</h3>
            <div class="col-md-8 col-md-offset-2 col-xs-12">
                <ul class="list-group">
                	<c:forEach items="${response.data }" var="i">
	                    <li class="list-group-item" id="${i.letterId }">
	                        <div class="u-msg-wrap">
	                        	<c:if test="${user.userId ne i.personA.userId }">
		                            <a href="${pageContext.request.contextPath }/user/${i.personA.userId }">${i.personA.nickname }</a>
	                        	</c:if>
	                        	<c:if test="${user.userId ne i.personB.userId }">
		                            <a href="${pageContext.request.contextPath }/user/${i.personB.userId }">${i.personB.nickname }</a>
	                        	</c:if>
	                            <span>的消息</span>
	                            <a class="pull-right go-detail" href="${pageContext.request.contextPath }/user/msg_detail/${i.letterId }?t=<f:formatDate value="${i.lastTime }" pattern="yyyy-MM-dd"/>">详细</a>
	                            <span class="pull-right">Last Msg:
	                            	<span class="text-success"><f:formatDate value="${i.lastTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	                            </span>
	                        </div>
	                    </li>
                	</c:forEach>
                	<!--  
                    <li class="list-group-item">
                        <div class="u-msg-wrap">
                            <a href="">Tom</a>
                            <span>的消息</span>
                            <a class="pull-right go-detail" href="">详细</a>
                            <span class="pull-right">Last Msg:<span class="text-success">2017-08-24 12:00:00</span></span>
                        </div>
                    </li>
                	-->
                </ul>
                <div class="text-center">
                    <ul class="pagination">
                        <c:forEach items="${response.showPage }" var="p">
							<c:if test="${p.info == 1 }">
								<li><a href="${pageContext.request.contextPath }/user/msg/${p.pageNo }"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
							</c:if>
							<c:if test="${p.info == 2 }">
								<li><a href="${pageContext.request.contextPath }/user/msg/${p.pageNo }">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 3 }">
								<li><a href="#">...</a></li>
							</c:if>
							<c:if test="${p.info == 4 }">
								<li class="active"><a href="#">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 5 }">
								<li><a href="${pageContext.request.contextPath }/user/msg/${p.pageNo }"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
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