<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/user_manage.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row isay-inner">
        <div class="col-md-12">
            <table class="table">
                <thead>
                <tr>
                    <th>UserId</th>
                    <th>UserEmail</th>
                    <th>UserName</th>
                    <th>UserSex</th>
                    <th>UserGraduate</th>
                    <th>UserJob</th>
                    <th>UserCompany</th>
                    <th>WorkPlace</th>
                    <th>Shield</th>
                    <th>身份</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${response.data }" var="i" varStatus="st">
	                <tr>
	                    <td>${i.userId }</td>
	                    <td>${i.userEmail }</td>
	                    <td>${i.nickname }</td>
	                    <td>${i.sex }</td>
	                    <td>${i.userGraduate }</td>
	                    <td>${i.job }</td>
	                    <td>${i.company }</td>
	                    <td>${i.workplace }</td>
	                    <td>
	                    	<c:if test="${i.shield eq '0' }">未屏蔽</c:if>
	                    	<c:if test="${i.shield eq '1' }">已屏蔽</c:if>
	                    </td>
	                    <td>
                   			<c:set var="isAdmin" value="1"></c:set>
	                    	<c:forEach items="${i.roles }" var="r">
	                    		<c:if test="${r.roleName eq 'admin' }">
	                    			<c:set var="roleId" value="${r.roleId }"></c:set>
	                    			<c:set var="isAdmin" value="0"></c:set>
	                    		</c:if>
	                    	</c:forEach>
	                    	<c:if test="${isAdmin == 0 }">管理员</c:if>
	                    	<c:if test="${isAdmin == 1 }">用户</c:if>
	                    </td>
	                    <td>
	                    	<c:if test="${i.shield eq '0' }">
		                        <a href="javascript:;" class="op-btn" data-id="${i.userId }" data-role="shield">屏蔽</a>
	                    	</c:if>
	                    	<c:if test="${i.shield eq '1' }">
		                        <a href="javascript:;" class="op-btn" data-id="${i.userId }" data-role="show">解除屏蔽</a>
	                    	</c:if>
	                    	<c:if test="${isAdmin == 0 }">
		                        <a href="javascript:;" class="op-btn" data-id="${i.userId }" data-roleid="${roleId }" data-role="removeAdmin">取消管理</a>
	                    	</c:if>
	                    	<c:if test="${isAdmin == 1 }">
		                        <a href="javascript:;" class="op-btn" data-id="${i.userId }" data-role="toAdmin">设为管理</a>
	                    	</c:if>
	                    </td>
	                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="text-center">
            	<ul class="pagination">
					<c:forEach items="${response.showPage }" var="p">
						<c:if test="${p.info == 1 }">
							<li><a href="${pageContext.request.contextPath }/user/list/${p.pageNo }"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
						</c:if>
						<c:if test="${p.info == 2 }">
							<li><a href="${pageContext.request.contextPath }/user/list/${p.pageNo }">${p.pageNo }</a></li>
						</c:if>
						<c:if test="${p.info == 3 }">
							<li><a href="#">...</a></li>
						</c:if>
						<c:if test="${p.info == 4 }">
							<li class="active"><a href="#">${p.pageNo }</a></li>
						</c:if>
						<c:if test="${p.info == 5 }">
							<li><a href="${pageContext.request.contextPath }/user/list/${p.pageNo }"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
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
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user.js"></script>
</body>
</html>