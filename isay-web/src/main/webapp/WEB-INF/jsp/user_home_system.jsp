<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-系统消息</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome_system.css">
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
            <h3 class="text-center">系统消息</h3>
            <div class="col-md-8 col-md-offset-2 col-xs-12">
                <ul class="list-group">
                	<c:forEach items="${response.data }" var="i">
	                    <li class="list-group-item text-justify">
							${i.msgContent }
	                    </li>
                	</c:forEach>
                	<!--  
                    <li class="list-group-item text-justify">
                    	<a class="sys-user" href="#">劳拉</a>评论了你的帖子<a class="sys-post" href="#">《这座城市的风很大，孤独的人总是很晚才回家》</a><span class="sys-time">2018-05-12 19:52</span>
                    </li>
                    <li class="list-group-item text-justify">
                    	<a class="sys-user" href="#">劳拉</a>回复了你<a class="sys-post" href="#">《这座城市的风很大，孤独的人总是很晚才回家》</a><span class="sys-time">2018-05-12 19:52</span>
                    </li>
                    <li class="list-group-item text-justify">
                    	<a class="sys-user" href="#">劳拉</a>私信了你<span class="sys-content">只对候选人最近一份工作感兴趣</span><span class="sys-time">2018-05-12 19:52</span>
                    </li>
                	-->
                </ul>
                <div class="text-center">
                    <ul class="pagination">
                        <c:forEach items="${response.showPage }" var="p">
							<c:if test="${p.info == 1 }">
								<li><a href="${pageContext.request.contextPath }/user/system/${p.pageNo }"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
							</c:if>
							<c:if test="${p.info == 2 }">
								<li><a href="${pageContext.request.contextPath }/user/system/${p.pageNo }">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 3 }">
								<li><a href="#">...</a></li>
							</c:if>
							<c:if test="${p.info == 4 }">
								<li class="active"><a href="#">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 5 }">
								<li><a href="${pageContext.request.contextPath }/user/system/${p.pageNo }"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
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