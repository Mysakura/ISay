<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="isay-header navbar-fixed-top">
    <div class="container-fluid">
        <div class="row">
            <div class="pull-right isay-nav hidden-sm hidden-xs">
                <a href="${pageContext.request.contextPath }/home" class="links"><span class="glyphicon glyphicon-home"></span> </a>
            </div>
            <!--手机菜单-->
            <div class="isay-mobile-btn visible-sm visible-xs">
                <a href="javascript:;" id="show_menu_toggle">
                    <span class="glyphicon glyphicon-menu-hamburger"></span>
                </a>
                <div class="isay-mobile-menu">
                    <ul class="list-unstyled">
                        <li><a href="${pageContext.request.contextPath }/home" class="active">首页</a></li>
                        <li><a href="${pageContext.request.contextPath }/user/list">用户管理</a></li>
                        <li><a href="${pageContext.request.contextPath }/area/list">领域管理</a></li>
                        <li><a href="${pageContext.request.contextPath }/friend/all">友链管理</a></li>
                        <li><a href="${pageContext.request.contextPath }/announce/list">公告管理</a></li>
                        <li><a href="${pageContext.request.contextPath }/about/list">关于管理</a></li>
                        <li><a href="${pageContext.request.contextPath }/timeline/all">事件管理</a></li>
                    </ul>
                </div>
            </div>
            <!--logo-->
            <div class="logo-wrap">
                <a href="/" class="logo">
                    <img src="${pageContext.request.contextPath }/sys_photo/logo.png" >
                </a>
            </div>
        </div>
        <div class="main-navs-wrap">
            <ul class="main-nav text-center hidden-sm hidden-xs">
                <li><a href="${pageContext.request.contextPath }/home" class="active">首页</a></li>
                <li><a href="${pageContext.request.contextPath }/user/list">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath }/area/list">领域管理</a></li>
                <li><a href="${pageContext.request.contextPath }/friend/all">友链管理</a></li>
                <li><a href="${pageContext.request.contextPath }/announce/list">公告管理</a></li>
                <li><a href="${pageContext.request.contextPath }/about/list">关于管理</a></li>
                <li><a href="${pageContext.request.contextPath }/timeline/all">事件管理</a></li>
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