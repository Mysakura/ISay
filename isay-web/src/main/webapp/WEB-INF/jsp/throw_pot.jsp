<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-甩锅</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail_global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/throw_pot.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-12">
            <div class="side-menu hidden-xs">
                <h2 class="title" title="一个吐(xian)槽(liao)的地方">甩锅<span class="glyphicon glyphicon-flash"></span></h2>
                <ul class="list-group list-unstyled">
                    <li><a href="${pageContext.request.contextPath }/card/throw_pot_chat">闲聊</a></li>
                    <li><a href="${pageContext.request.contextPath }/card/${areaType }?type=1">技术</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=2">产品</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=3">设计</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=4">运营</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=5">市场</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=6">职能</a></li>
					<li><a href="${pageContext.request.contextPath }/card/${areaType }?type=7">金融</a></li>
                </ul>
                <div class="write-post-link">
                    <a href="javascript:;" id="iPot">我要甩锅</a>
                    <a href="javascript:;" id="iChat">我要闲聊</a>
                </div>
            </div>
            <div class="main-content">
                <div class="tp-info-wrap">
                    <h3>[技术]累计送出了</h3>
                    <div class="tp-info-give">
                        <div class="tp-info-give-item">0朵 <span class="weapon flower"></span></div>
                        <div class="tp-info-give-item">150把 <span class="weapon hammer"></span></div>
                        <div class="tp-info-give-item">150个 <span class="weapon pot"></span></div>
                        <div class="tp-info-give-item">150个 <span class="weapon agent"></span></div>
                        <div class="tp-info-give-item">150个 <span class="weapon green-hat"></span></div>
                    </div>
                    <h3>[技术]累计收到了</h3>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <div class="row tp-info-item">
                                <div class="col-xs-2">0朵 <span class="weapon flower"></span></div>
                                <div class="col-xs-10">
                                   	 分别来自
                                    <span class="tp-from">产品[0]</span>
                                    <span class="tp-from">设计[0]</span>
                                    <span class="tp-from">运营[0]</span>
                                    <span class="tp-from">市场[0]</span>
                                    <span class="tp-from">职能[0]</span>
                                    <span class="tp-from">金融[0]</span>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row tp-info-item">
                                <div class="col-xs-2">150把 <span class="weapon hammer"></span></div>
                                <div class="col-xs-10">
                                  	 分别来自
                                    <span class="tp-from">产品[102]</span>
                                    <span class="tp-from">设计[48]</span>
                                    <span class="tp-from">运营[0]</span>
                                    <span class="tp-from">市场[0]</span>
                                    <span class="tp-from">职能[0]</span>
                                    <span class="tp-from">金融[0]</span>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row tp-info-item">
                                <div class="col-xs-2">150个 <span class="weapon pot"></span></div>
                                <div class="col-xs-10">
                                   	 分别来自
                                    <span class="tp-from">产品[102]</span>
                                    <span class="tp-from">设计[48]</span>
                                    <span class="tp-from">运营[0]</span>
                                    <span class="tp-from">市场[0]</span>
                                    <span class="tp-from">职能[0]</span>
                                    <span class="tp-from">金融[0]</span>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row tp-info-item">
                                <div class="col-xs-2">150个 <span class="weapon agent"></span></div>
                                <div class="col-xs-10">
                                   	 分别来自
                                    <span class="tp-from">产品[102]</span>
                                    <span class="tp-from">设计[48]</span>
                                    <span class="tp-from">运营[0]</span>
                                    <span class="tp-from">市场[0]</span>
                                    <span class="tp-from">职能[0]</span>
                                    <span class="tp-from">金融[0]</span>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row tp-info-item">
                                <div class="col-xs-2">150个 <span class="weapon green-hat"></span></div>
                                <div class="col-xs-10">
                                   	 分别来自
                                    <span class="tp-from">产品[102]</span>
                                    <span class="tp-from">设计[48]</span>
                                    <span class="tp-from">运营[0]</span>
                                    <span class="tp-from">市场[0]</span>
                                    <span class="tp-from">职能[0]</span>
                                    <span class="tp-from">金融[0]</span>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <h3>我方动态</h3>
                <ul class="list-group">
                    <li class="list-group-item">
                        <a href="">Tom</a>于<span class="tp-time">2017-10-06 09:36:12</span>
                        	送给<span class="tp-to">产品</span>
                        <span class="weapon pot"></span>
                    </li>
                    <li class="list-group-item">
                        <a href="">Tom</a>于<span class="tp-time">2017-10-06 09:36:12</span>
                        	送给<span class="tp-to">产品</span>
                        <span class="weapon pot"></span>
                    </li>
                    <li class="list-group-item">
                        <a href="">Tom</a>于<span class="tp-time">2017-10-06 09:36:12</span>
                        	送给<span class="tp-to">产品</span>
                        <span class="weapon pot"></span>
                    </li>
                </ul>
                <div class="text-center">
                    <a href="javascript:;" class="load-more">Load More</a>
                </div>
                <p>加载更多-Ajax</p>
            </div>
            <!--甩锅-->
            <div class="modal fade" id="potModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">没事甩个锅</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12">

                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon">我是</span>
                                            <select class="form-control" id="fieldSelectionFrom">
                                                <option>-- 选择你的门派 --</option>
                                                <option>技术</option>
                                                <option>产品</option>
                                                <option>设计</option>
                                                <option>运营</option>
                                                <option>市场</option>
                                                <option>职能</option>
                                                <option>金融</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon">送给</span>
                                            <select class="form-control" id="fieldSelectionTo">
                                                <option>-- 选择目标门派 --</option>
                                                <option>技术</option>
                                                <option>产品</option>
                                                <option>设计</option>
                                                <option>运营</option>
                                                <option>市场</option>
                                                <option>职能</option>
                                                <option>金融</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon">Gift</span>
                                            <select class="form-control" id="giftSelection">
                                                <option>-- 选择Gift --</option>
                                                <option value="flower">一朵小红发</option>
                                                <option value="hammer">一把镇定锤</option>
                                                <option value="pot">一个平底锅</option>
                                                <option value="agent">一个经纪人</option>
                                                <option value="green-hat">一个绿帽</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="text-center">
                                            <span id="showGift" class="weapon"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="putPot">OK</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--闲聊-->
            <div class="modal fade" id="chatModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">没事吐个槽</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12">
                                    <textarea maxlength="150" class="form-control chat-textarea" placeholder="有啥不(fen)爽(xiang)，说出来让大家开心开心。控制在150字以内哦"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="putChat">OK</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ref/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/throw_pot.js"></script>
</body>
</html>