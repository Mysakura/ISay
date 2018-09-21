<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="userhome-info" style="background-image: url(${pageContext.request.contextPath }/${user.userBg })">
    <div class="col-xs-12 text-center">
        <img class="u-pic" src="${pageContext.request.contextPath }/${user.userPhoto }">
    </div>
    <div class="col-xs-12 text-center">
        <h2>${sessionScope.user.nickname }&nbsp;
        <c:if test="${user.sex eq '男' }">
        	<span class="sex-man-icon" title="性别：男"></span>
        	<!-- 已废弃 
        	<span class="man-icon"></span>
        	-->
        </c:if>
        <c:if test="${user.sex eq '女' }">
        	<span class="sex-woman-icon" title="性别：女"></span>
        	<!-- 已废弃 
        	<span class="woman-icon"></span>
        	-->
        </c:if>
        <c:if test="${user.sex eq '保密' }">
        	<span class="sex-none-icon" title="性别：保密"></span>
        </c:if>
        </h2>
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
        <p class="u-btn-wrap text-center">
            <a href="${pageContext.request.contextPath }/user/home" class="u-btn u-btn-red">wo的帖子</a>
            <a href="${pageContext.request.contextPath }/user/msg" class="u-btn u-btn-red">消息</a>
            <a href="${pageContext.request.contextPath }/user/collection" class="u-btn u-btn-red">收藏</a>
            <a href="${pageContext.request.contextPath }/user/follow" class="u-btn u-btn-blue">关注</a>
            <a href="${pageContext.request.contextPath }/user/fans" class="u-btn u-btn-blue">Fans</a>
            <a href="${pageContext.request.contextPath }/user/system" class="u-btn u-btn-green">系统</a>
            <a href="${pageContext.request.contextPath }/user/setting" class="u-btn u-btn-green">设置</a>
        </p>
    </div>
</div>