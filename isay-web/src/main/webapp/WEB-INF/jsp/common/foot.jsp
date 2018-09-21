<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--页脚-->
<div class="isay-footer">
    <div class="foot-top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4 col-sm-12">
                    <h3>关于</h3>
                    <ul class="list-group list-unstyled">
                        <li><a href="${pageContext.request.contextPath }/about">关于InternetSaying</a></li>
                        <li><a href="${pageContext.request.contextPath }/about_author">关于作者</a></li>
                        <li><a href="${pageContext.request.contextPath }/about_contact">联系我们</a></li>
                    </ul>
                </div>
                <div class="col-md-4 col-sm-12">
                    <h3>其它</h3>
                    <ul class="list-group list-unstyled">
                        <li><a href="${pageContext.request.contextPath }/">首页</a></li>
                        <li><a href="${pageContext.request.contextPath }/announcement_list">公告</a></li>
                        <li><a href="${pageContext.request.contextPath }/timeline">时间轴</a></li>
                    </ul>
                </div>
                <div class="col-md-4 col-sm-12">
                    <h3>友情链接</h3>
                    <ul class="list-inline list-unstyled" id="common_friends">
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="foot-bottom">
        <div class="logo col-md-6 col-sm-12">
            <img src="${pageContext.request.contextPath }/sys_photo/logo.png">
            <span>© 2017 internetsaying.com</span>
            <span>冀ICP备17005195号</span>
        </div>
        <div class="col-md-6 col-sm-12">
            <ul class="add-nav">
                <li><a href="${pageContext.request.contextPath }/friend">友情链接</a></li>
                <li>|</li>
                <li><a href="${pageContext.request.contextPath }/message_board">意见反馈</a></li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ref/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/global_script.js"></script>