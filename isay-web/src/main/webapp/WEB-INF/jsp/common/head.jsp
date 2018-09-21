<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="isay-header navbar-fixed-top">
    <div class=" container-fluid">
        <div class="row">
        	<c:if test="${sessionScope.user == null }">
	            <div class="pull-right isay-nav hidden-sm hidden-xs">
	                <a href="${pageContext.request.contextPath }/" class="links"><span class="glyphicon glyphicon-home"></span> 首页</a>
	                <a href="${pageContext.request.contextPath }/about">关于</a>
	                <a href="${pageContext.request.contextPath }/login_p">登录</a>
	                <a href="${pageContext.request.contextPath }/register_p">注册</a>
	            </div>
        	</c:if>
        	<c:if test="${sessionScope.user != null }">
	        	<div class="pull-right">
	                <a href="javascript:;" id="userOperate">
	                    <img class="isay-user-photo" src="${pageContext.request.contextPath }/${user.userPhoto}">
	                </a>
	                <div class="pull-right isay-nav-u">
	                    <a href="${pageContext.request.contextPath }/user/home">个人中心</a>
	                    <a href="${pageContext.request.contextPath }/logout">退出登录</a>
	                </div>
	            </div>
        	</c:if>
            <!--手机菜单-->
            <div class="isay-mobile-btn visible-sm visible-xs">
                <a href="javascript:;" id="show_menu_toggle">
                    <span class="glyphicon glyphicon-menu-hamburger"></span>
                </a>
                <div class="isay-mobile-menu">
                    <ul class="list-unstyled">
                        <li><a href="${pageContext.request.contextPath }/" class="active">首页</a></li>
                        <li><a href="${pageContext.request.contextPath }/card/statistics">统计</a></li>
		                <li><a href="${pageContext.request.contextPath }/card/advice">忠告</a></li>
		                <li><a href="${pageContext.request.contextPath }/card/throw_pot_chat">甩锅</a></li>
		                <li><a href="${pageContext.request.contextPath }/card/readme">自述</a></li>
		                <li><a href="${pageContext.request.contextPath }/card/resource">资源</a></li>
		                <li><a href="${pageContext.request.contextPath }/card/question">疑问</a></li>
		                <li><a href="${pageContext.request.contextPath }/card/vote">投票</a></li>
		                <li><a href="${pageContext.request.contextPath }/card/company">公司印象</a></li>
		                <li><a href="${pageContext.request.contextPath }/card/interview">面经</a></li>
		                <li><a href="${pageContext.request.contextPath }/card/job">技能图</a></li>
                        <li><a href="${pageContext.request.contextPath }/login_p">登录</a></li>
                    </ul>
                </div>
            </div>
            <!--logo-->
            <div class="logo-wrap">
                <a href="${pageContext.request.contextPath }/" class="logo">
                    <img src="${pageContext.request.contextPath }/sys_photo/logo.png" >
                </a>
            </div>
        </div>
        <div class="main-navs-wrap">
            <!--失去焦点隐藏，回车搜索-->
            <div class="isay-search-wrap">
                <div class="isay-search-input">
                    <span class="glyphicon glyphicon-search"></span>
                    <input type="text" id="searchingContent" placeholder="搜索...">
                </div>
            </div>
            <ul class="main-nav hidden-sm hidden-xs">
                <li><a href="${pageContext.request.contextPath }/">首页</a></li>
                <li><a href="${pageContext.request.contextPath }/card/statistics">统计</a></li>
                <li><a href="${pageContext.request.contextPath }/card/advice">忠告</a></li>
                <li><a href="${pageContext.request.contextPath }/card/throw_pot_chat">甩锅</a></li>
                <li><a href="${pageContext.request.contextPath }/card/readme">自述</a></li>
                <li><a href="${pageContext.request.contextPath }/card/resource">资源</a></li>
                <li><a href="${pageContext.request.contextPath }/card/question">疑问</a></li>
                <li><a href="${pageContext.request.contextPath }/card/vote">投票</a></li>
                <li><a href="${pageContext.request.contextPath }/card/company">公司印象</a></li>
                <li><a href="${pageContext.request.contextPath }/card/interview">面经</a></li>
                <li><a href="${pageContext.request.contextPath }/card/job">技能图</a></li>
            </ul>
        </div>
    </div>
</div>
<!--返回顶部-->
<div class="isay-return-top-wrap">
    <a href="javascript:;" id="isay-return-top">
        <span class="glyphicon glyphicon-plane"></span>
    </a>
</div>