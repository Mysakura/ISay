<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-投票</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail_global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/vote.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-12">
            <div class="side-menu hidden-xs">
                <h2 class="title">投票 <span class="glyphicon glyphicon-bullhorn"></span></h2>
                <ul class="list-group list-unstyled">
                    <jsp:include page="common/area.jsp"></jsp:include>
                </ul>
                <div class="write-post-link">
                    <a href="${pageContext.request.contextPath }/card/write_vote">我也写一个</a>
                </div>
            </div>
            <div class="main-content">
                <ul class="list-group vote-wrap">
                    <!--<li>比如点击技术：显示技术相关问题，标题，标签。投票信息直接显示</li>-->
                    <c:forEach items="${response.data }" var="i">
	                    <li class="list-group-item vote">
	                        <div class="vote-info">
	                            	此投票由<a href="${pageContext.request.contextPath }/user/${i.user.userId}">${i.user.nickname}</a>于
	                            	<span><f:formatDate value="${i.voteTime }" pattern="yyyy-MM-dd HH:mm"/></span>发起
	                        </div>
	                        <p class="vote-description">${i.voteContent }</p>
	                        <div class="vote-operate">
	                        	<c:forEach items="${i.items }" var="j">
	                        		<!-- active -->
		                            <a href="javascript:;" class="" data-itemid="${j.itemId }" data-voteid="${i.voteId }">
		                                <span class="vote-num">票数：${j.voteNum }</span>
		                                <input type="radio" name="voteId" id="item-${j.itemId }">
		                                <label for="item-${j.itemId }">${j.itemContent }</label>
		                            </a>
	                        	</c:forEach>
	                        </div>
	                    </li>
                    </c:forEach>
                    <!--  
                    <li class="list-group-item vote">
                        <div class="vote-info">
                            	此投票由<a href="">Tom</a>于<span>2017-10-04 09:10:55</span>发起
                        </div>
                        <p class="vote-description">非 法 传 销 有 三 点 特征：
				                            其一 ，推广的产品虚构 ，没有实物 ；其二 ，推广方有发展下线的需求 ，且以此获利 ；
				                            其三 ，需要达到一定的规模 ，对推广层级 、人数有所限定。
				                            工商部门提醒 ，如果需要入门费 、没有实质项目和产品 、对方明显要发展下线 ，
				                            符合其中任何两点 ，都可判断是传销。点击广告便能赚钱确实诱惑性不小 ，
				                            但在遇到类似投资机会时 ，一 定 要 提 高 警 惕 注 意 辨别，切勿误入传销陷阱。</p>
                        <div class="vote-operate">
                            <a href="javascript:;" class="active">
                                <span class="vote-num">1</span>
                                <input type="radio" name="voteId2" id="voteOptionId3">
                                <label for="voteOptionId3">是</label>
                            </a>
                            <a href="javascript:;">
                                <span class="vote-num">0</span>
                                <input type="radio" name="voteId2" id="voteOptionId4">
                                <label for="voteOptionId4">否</label>
                            </a>
                        </div>
                    </li>
                    -->
                </ul>
                <div class="text-center">
                    <ul class="pagination">
                        <c:forEach items="${response.showPage }" var="p">
							<c:if test="${p.info == 1 }">
								<li><a href="${pageContext.request.contextPath }/card/${response.classifyName }/${p.pageNo }?type=${response.areaType }"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
							</c:if>
							<c:if test="${p.info == 2 }">
								<li><a href="${pageContext.request.contextPath }/card/${response.classifyName }/${p.pageNo }?type=${response.areaType }">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 3 }">
								<li><a href="#">...</a></li>
							</c:if>
							<c:if test="${p.info == 4 }">
								<li class="active"><a href="#">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 5 }">
								<li><a href="${pageContext.request.contextPath }/card/${response.classifyName }/${p.pageNo }?type=${response.areaType }"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/vote.js"></script>
</body>
</html>