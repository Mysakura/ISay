<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-与【${other.nickname }】PK</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome_pk.css">
</head>
<body>
<jsp:include page="common/user_head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="userhome-wrap">
        <div class="row">
            <div class="col-md-6">
                <div class="userhome-info" style="background-image: url(${pageContext.request.contextPath }/${user.userBg })">
                    <div class="col-xs-12 text-center">
                        <img class="u-pic" src="${pageContext.request.contextPath }/${user.userPhoto }">
                    </div>
                    <div class="col-xs-12 text-center">
                    	<c:if test="${user.sex eq '男' }">
	                        <h2>我 <span class="sex-man-icon" title="性别：男"></span></h2>
				        </c:if>
				        <c:if test="${user.sex eq '女' }">
	                        <h2>我 <span class="sex-woman-icon" title="性别：女"></span></h2>
				        </c:if>
				        <c:if test="${user.sex eq '保密' }">
	                        <h2>我 <span class="sex-none-icon" title="性别：保密"></span></h2>
				        </c:if>
                    </div>
                    <div class="col-xs-12">
                        <div class="u-info text-center">
                            <div class="info-block">
                                <span title="赞成数"><span class="glyphicon glyphicon-thumbs-up"></span>${infusion.upNum }</span>
				                <span title="反对数"><span class="glyphicon glyphicon-thumbs-down"></span>${infusion.downNum }</span>
				                <span title="发帖数"><span class="glyphicon glyphicon-file"></span>${infusion.postNum }</span>
				                <span title="关注者"><span class="glyphicon glyphicon-heart"></span>10</span>
				                <span title="职业"><span class="glyphicon glyphicon-briefcase"></span>${user.job }</span>
				                <span title="毕业于"><span class="glyphicon glyphicon-education"></span>${user.userGraduate }</span>
				                <span title="目前公司"><span class="glyphicon glyphicon-ice-lolly"></span>${user.company }</span>
				                <span title="所在地"><span class="glyphicon glyphicon-map-marker"></span>${user.workplace }</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="userhome-info" style="background-image: url(${pageContext.request.contextPath }/${other.userBg })">
                    <div class="col-xs-12 text-center">
                        <img class="u-pic" src="${pageContext.request.contextPath }/${other.userPhoto }">
                    </div>
                    <div class="col-xs-12 text-center">
                    	<c:if test="${other.sex eq '男' }">
	                        <h2>${other.nickname } <span class="sex-man-icon" title="性别：男"></span></h2>
				        </c:if>
				        <c:if test="${other.sex eq '女' }">
	                        <h2>${other.nickname } <span class="sex-woman-icon" title="性别：女"></span></h2>
				        </c:if>
				        <c:if test="${other.sex eq '保密' }">
	                        <h2>${other.nickname } <span class="sex-none-icon" title="性别：保密"></span></h2>
				        </c:if>
                    </div>
                    <div class="col-xs-12">
                        <div class="u-info text-center">
                            <div class="info-block">
                                <span title="赞成数"><span class="glyphicon glyphicon-thumbs-up"></span>${otherInfusion.upNum }</span>
				                <span title="反对数"><span class="glyphicon glyphicon-thumbs-down"></span>${otherInfusion.downNum }</span>
				                <span title="发帖数"><span class="glyphicon glyphicon-file"></span>${otherInfusion.postNum }</span>
				                <span title="关注者"><span class="glyphicon glyphicon-heart"></span>10</span>
				                <span title="职业"><span class="glyphicon glyphicon-briefcase"></span>${other.job }</span>
				                <span title="毕业于"><span class="glyphicon glyphicon-education"></span>${other.userGraduate }</span>
				                <span title="目前公司"><span class="glyphicon glyphicon-ice-lolly"></span>${other.company }</span>
				                <span title="所在地"><span class="glyphicon glyphicon-map-marker"></span>${other.workplace }</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1 col-xs-12">
                <div class="pk-wrap">
                    <h2 class="text-center">PK</h2>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <h4 class="text-info">共同关注的人</h4>
                            <div class="pk-common-friend">
                            	<c:forEach begin="0" end="5">
	                                <div class="friend-info">
	                                    <img src="${pageContext.request.contextPath }/${other.userPhoto }">
	                                    <p class="text-center">
	                                        <a href="#">哎哎哎</a>
	                                    </p>
	                                </div>
                            	</c:forEach>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <h4 class="text-info">共同收藏的文章</h4>
                            <p class="text-center">您暂时<strong class="text-danger no-tip">没有</strong>和<strong class="text-info no-tip">TA</strong>共同关注的人</p>
                            <div>

                            </div>
                        </li>
                    </ul>
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