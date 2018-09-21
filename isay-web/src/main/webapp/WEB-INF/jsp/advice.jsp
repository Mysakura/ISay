<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-忠告</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail_global_style.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-12">
            <div class="side-menu hidden-xs">
                <h2 class="title">忠告<span class="glyphicon glyphicon-tree-deciduous"></span></h2>
                <ul class="list-group list-unstyled">
                    <jsp:include page="common/area.jsp"></jsp:include>
                </ul>
                <div class="write-post-link">
                    <a href="${pageContext.request.contextPath }/card/write_post?type=advice">我也写一个</a>
                </div>
            </div>
            <div class="main-content">
                <div class="row" style="display: none">
                    <div class="col-md-12">
			                        后端开发
			                        Java C++ PHP 数据挖掘 搜索算法 精准推荐 C C# 全栈工程师 .NET Hadoop Python Delphi VB Perl Ruby Node.js Go ASP Shell 后端开发其它
			                        移动开发
			                        HTML5 Android iOS WP 移动开发其它
			                        前端开发
			                        web前端 Flash html5 JavaScript U3D COCOS2D-X 前端开发其它
			                        人工智能
			                        深度学习 机器学习 图像处理 图像识别 语音识别 机器视觉 算法工程师 自然语言处理
			                        测试
			                        测试工程师 自动化测试 功能测试 性能测试 测试开发 游戏测试 白盒测试 灰盒测试 黑盒测试 手机测试 硬件测试 测试经理 测试其它
			                        运维
			                        运维工程师 运维开发工程师 网络工程师 系统工程师 IT支持 IDC CDN F5 系统管理员 病毒分析 WEB安全 网络安全 系统安全 运维经理 运维其它
			                        DBA
			                        MySQL SQLServer Oracle DB2 MongoDB ETL Hive 数据仓库 DBA其它
			                        高端职位
			                        技术经理 技术总监 架构师 CTO 运维总监 技术合伙人 项目总监 测试总监 安全专家 高端技术职位其它
			                        项目管理
			                        项目经理 项目助理
			                        硬件开发
			                        硬件 嵌入式 自动化 单片机 电路设计 驱动开发 系统集成 FPGA开发 DSP开发 ARM开发 PCB工艺 模具设计 热传导 材料工程师 精益工程师 射频工程师 硬件开发其它
			                        企业软件
			                        实施工程师 售前工程师 售后工程师 BI工程师 企业软件其它
                    </div>
                    <div class="col-md-12">
			                        产品经理
			                        产品经理 网页产品经理 移动产品经理 产品助理 数据产品经理 电商产品经理 游戏策划 产品实习生
			                        产品设计师
			                        网页产品设计师 无线产品设计师
			                        高端职位
			                        产品部经理 产品总监 游戏制作人
                    </div>
                    <div class="col-md-12">
			                        视觉设计
			                        视觉设计师 网页设计师 Flash设计师 APP设计师 UI设计师 平面设计师 美术设计师（2D/3D） 广告设计师 多媒体设计师 原画师 游戏特效 游戏界面设计师 游戏场景 游戏角色 游戏动作
			                        交互设计
			                        交互设计师 无线交互设计师 网页交互设计师 硬件交互设计师
			                        用户研究
			                        数据分析师 用户研究员 游戏数值策划
			                        高端职位
			                        设计经理/主管 设计总监 视觉设计经理/主管 视觉设计总监 交互设计经理/主管 交互设计总监 用户研究经理/主管 用户研究总监
                    </div>
                    <div class="col-md-12">
			                        运营
			                        用户运营 产品运营 数据运营 内容运营 活动运营 商家运营 品类运营 游戏运营 网络推广 运营专员 网店运营 新媒体运营 海外运营 运营经理
			                        编辑
			                        副主编 内容编辑 文案策划 记者
			                        客服
			                        售前咨询 售后客服 淘宝客服 客服经理
			                        高端职位
			                        主编 运营总监 COO 客服总监
                    </div>
                    <div class="col-md-12">
			                        市场/营销
			                        市场营销 市场策划 市场顾问 市场推广 SEO SEM 商务渠道 商业数据分析 活动策划 网络营销 海外市场 政府关系
			                        公关
			                        媒介经理 广告协调 品牌公关
			                        销售
			                        销售专员 销售经理 客户代表 大客户代表 BD经理 商务渠道 渠道销售 代理商销售 销售助理 电话销售 销售顾问 商品经理
			                        供应链
			                        物流 仓储
			                        采购
			                        采购专员 采购经理 商品经理
			                        投资
			                        分析师 投资顾问 投资经理
			                        高端职位
			                        市场总监 销售总监 商务总监 CMO 公关总监 采购总监 投资总监
                    </div>
                    <div class="col-md-12">
			                        人力资源
			                        人力资源 招聘 HRBP 人事/HR 培训经理 薪资福利经理 绩效考核经理 员工关系
			                        行政
			                        助理 前台 行政 总助 文秘
			                        财务
			                        会计 出纳 财务 结算 税务 审计 风控
			                        法务
			                        法务 律师 专利
			                        高端职位
			                        行政总监/经理 财务总监/经理 HRD/HRM CFO CEO
                    </div>
                    <div class="col-md-12">
			                        投融资
			                        投资经理 分析师 投资助理 融资 并购 行业研究 投资者关系 资产管理 理财顾问 交易员
			                        风控
			                        风控 资信评估 合规稽查 律师
			                        审计税务
			                        审计 法务 会计 清算
			                        高端职位
			                        投资总监 融资总监 并购总监 风控总监 副总裁
                    </div>

                </div>
                <ul class="list-group post-wrap">
                	<c:forEach items="${response.data }" var="i">
	                    <li class="list-group-item post-item" id="${i.postId }">
	                        <h3 class="h3"><a href="${pageContext.request.contextPath }/card/post_details/${i.postId }">${i.postTitle }</a></h3>
	                        <div class="pull-right">
	                            <img class="post-img" src="${i.postCover }">
	                        </div>
	                        <p class="post-p">${i.postShortCut }</p>
	                        <div>
	                            <a href="${pageContext.request.contextPath }/user/${i.user.userId }">${i.user.nickname }</a>
	                            <span class="post-span">发表于：<f:formatDate value="${i.postTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	                            <span class="post-span">浏览[${i.visitNum }]</span>
	                            <span class="post-span">评论[${i.commentNum }]</span>
	                            <div class="pull-right">
	                                <span>领域:</span>
	                                <a href="">${i.workArea.areaName }</a>
	                                <span>分类:</span>
	                                <a href="">${response.classifyShowName }</a>
	                            </div>
	                        </div>
	                    </li>
                	</c:forEach>
                </ul>
                <div class="text-center">
                    <ul class="pagination">
                        <c:forEach items="${response.showPage }" var="p">
							<c:if test="${p.info == 1 }">
								<li><a href="${pageContext.request.contextPath }/card/advice/${p.pageNo }?type=${response.areaType }"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
							</c:if>
							<c:if test="${p.info == 2 }">
								<li><a href="${pageContext.request.contextPath }/card/advice/${p.pageNo }?type=${response.areaType }">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 3 }">
								<li><a href="#">...</a></li>
							</c:if>
							<c:if test="${p.info == 4 }">
								<li class="active"><a href="#">${p.pageNo }</a></li>
							</c:if>
							<c:if test="${p.info == 5 }">
								<li><a href="${pageContext.request.contextPath }/card/advice/${p.pageNo }?type=${response.areaType }"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
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