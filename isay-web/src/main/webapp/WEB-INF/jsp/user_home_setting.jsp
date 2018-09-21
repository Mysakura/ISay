<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-设置</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/userhome_setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/jquery.Jcrop.min.css">
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
            <h3></h3>
            <div class="col-md-8 col-md-offset-2 col-xs-12">
                <ul class="list-group">
                    <li class="list-group-item">
                        <h3 class="text-center">基本信息设置</h3>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-2 col-xs-12">
                                    <label for="nickname">昵称</label>
                                </div>
                                <div class="col-md-10 col-xs-12">
                                    <input class="form-control" type="text" id="nickname" name="nickname" value="${user.nickname }" data-name="${user.nickname }">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-2 col-xs-12">
                                    <label for="hideSex">性别</label>
                                </div>
                                <div class="col-md-10 col-xs-12">
									<div class="sex-wrap">
										<c:if test="${user.sex eq '保密' }">
	                                        <input type="radio" id="hideSex" name="sex" value="保密" checked="checked">
										</c:if>
										<c:if test="${user.sex ne '保密' }">
	                                        <input type="radio" id="hideSex" name="sex" value="保密">
										</c:if>
                                        <label for="hideSex">保密</label>
                                    </div>

                                    <div class="sex-wrap">
	                                    <c:if test="${user.sex eq '男' }">
	                                        <input type="radio" id="male" name="sex" value="男" checked="checked">
	                                    </c:if>
	                                    <c:if test="${user.sex ne '男' }">
	                                        <input type="radio" id="male" name="sex" value="男">
	                                    </c:if>
                                        <label for="male">男</label>
                                    </div>

                                    <div class="sex-wrap">
                                    	<c:if test="${user.sex eq '女' }">
                                        	<input type="radio" id="female" name="sex" value="女" checked="checked">
                                    	</c:if>
                                    	<c:if test="${user.sex ne '女' }">
                                        	<input type="radio" id="female" name="sex" value="女">
                                    	</c:if>
                                        <label for="female">女</label>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-2 col-xs-12">
                                    <label for="education">毕业学校</label>
                                </div>
                                <div class="col-md-10 col-xs-12">
                                    <input class="form-control" type="text" id="education" name="education" value="${user.userGraduate }">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-2 col-xs-12">
                                    <label for="company">就职公司</label>
                                </div>
                                <div class="col-md-10 col-xs-12">
                                    <input class="form-control" type="text" id="company" name="company" value="${user.company }">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-2 col-xs-12">
                                    <label for="job">职位</label>
                                </div>
                                <div class="col-md-10 col-xs-12">
                                    <input class="form-control" type="text" id="job" name="job" value="${user.job }">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-2 col-xs-12">
                                    <label for="area">所在地</label>
                                </div>
                                <div class="col-md-10 col-xs-12">
                                    <input class="form-control" type="text" id="area" name="area" placeholder="目前在哪个城市" value="${user.workplace }">
                                </div>
                            </div>
                        </div>
                        <a class="us-upload-btn" href="javascript:;" id="saveBaseInfo">
                            <span>保存</span>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <h3 class="text-center">密码设置</h3>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-2 col-xs-12">
                                    <label for="oldPassword">旧密码</label>
                                </div>
                                <div class="col-md-10 col-xs-12">
                                    <div class="input-group">
                                        <input class="form-control" type="password" id="oldPassword" placeholder="请输入旧密码">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="button" id="checkOldPassowrd">验证</button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-2 col-xs-12">
                                    <label for="oldPassword">新密码</label>
                                </div>
                                <div class="col-md-10 col-xs-12">
                                    <div class="input-group">
                                        <input class="form-control" type="password" id="newPassword" placeholder="请输入新密码">
                                        <span class="input-group-btn">
                                            <button class="btn btn-success" type="button" id="saveNewPassword">保存</button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <!--<h3 class="text-center">头像设置</h3>-->
                        <div class="row">
                            <div class="col-md-6 col-xs-12">
                                <div class="center-block us-jcrop-wrap">
                                    <img src="${pageContext.request.contextPath }/${user.userPhoto }" id="cropImg" width="400px">
                                </div>
                            </div>
                            <div class="col-md-6 col-xs-12">
                                <h3 class="text-center">预览</h3>
                                <div class="preview-wrap preview-50 center-block">
                                    <img src="${pageContext.request.contextPath }/${user.userPhoto }" class="preview-50-img" id="img_50">
                                </div>
                                <div class="preview-wrap preview-150 center-block">
                                    <img src="${pageContext.request.contextPath }/${user.userPhoto }" class="preview-150-img" id="img_150">
                                </div>
                            </div>
                            <div class="col-xs-12">
                                <a class="us-upload-btn" href="javascript:;">
                                    <input class="us-upload-input" type="file" accept="image/png,image/gif,image/jpeg" name="imgFile" id="userImgFile">
                                    <span>上传头像图片</span>
                                </a>
                                <a class="us-upload-btn" href="javascript:;" id="saveUserPhoto">
                                    <span>保存修改</span>
                                </a>
                                <span class="text-success" id="imgInfo"></span>
                            </div>
                            <div id="imgform">
                                <input type="hidden" id="x" name="x">
                                <input type="hidden" id="y" name="y">
                                <input type="hidden" id="w" name="w">
                                <input type="hidden" id="h" name="h">
                                <input type="hidden" id="dw" name="dw">
                                <input type="hidden" id="dh" name="dh">
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <!--<h3 class="text-center">背景设置</h3>-->
                        <a class="us-upload-btn" href="javascript:;">
                            <input class="us-upload-input" type="file" accept="image/png,image/gif,image/jpeg" name="imgFile" id="bgImgFile">
                            <span>上传背景图片</span>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <h3 class="text-center">打赏设置</h3>
                        <div class="row">
                            <div class="col-xs-12 col-md-6 text-center">
                                <a class="us-upload-btn" href="javascript:;">
                                    <input class="us-upload-input" type="file" accept="image/png,image/gif,image/jpeg" name="imgFile" id="AliImgFile">
                                    <span>上传支付宝二维码图片</span>
                                </a>
                                <img class="us-pay-pic" src="${pageContext.request.contextPath }/${user.userAlipay }">
                            </div>
                            <div class="col-xs-12 col-md-6 text-center">
                                <a class="us-upload-btn" href="javascript:;">
                                    <input class="us-upload-input" type="file" accept="image/png,image/gif,image/jpeg" name="imgFile" id="VxinImgFile">
                                    <span>上传微信二维码图片</span>
                                </a>
                                <img class="us-pay-pic" src="${pageContext.request.contextPath }/${user.userVxin }">
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ref/jquery.Jcrop.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ref/ajaxfileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/cut_img.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user_home_setting.js"></script>
</body>
</html>