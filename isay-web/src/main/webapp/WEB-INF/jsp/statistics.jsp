<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>互联网说-统计</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="互联网，职业，程序">
<meta name="description" content="让新人更好的去了解互联网">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ref/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail_global_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/statistics.css">
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<!--内容-->
<div class="container-fluid isay-container">
    <div class="row">
        <div class="col-xs-12">
            <div class="side-menu hidden-xs">
                <h2 class="title">统计<span class="glyphicon glyphicon-stats"></span></h2>
                <ul class="list-group list-unstyled">
                    <li><a class="active" href="#">社区统计</a></li>
                </ul>
            </div>
            <div class="main-content">
                <ul class="list-group">
                    <li class="list-group-item clearfix">
                        <div class="chart-wrap"><canvas id="myBarChart" width="400px" height="400px"></canvas></div>
                        <div class="chart-wrap"><canvas id="myBarChart2" width="400px" height="400px"></canvas></div>
                        <div class="chart-wrap"><canvas id="myLineChart" width="400px" height="400px"></canvas></div>
                        <div class="chart-wrap"><canvas id="myRadarChart" width="400px" height="400px"></canvas></div>
                        <div class="chart-wrap"><canvas id="myPieChart" width="400px" height="400px"></canvas></div>
                        <div class="chart-wrap"><canvas id="myDoughnutChart" width="400px" height="400px"></canvas></div>
                        <div class="chart-wrap"><canvas id="myScatterChart" width="400px" height="400px"></canvas></div>
                        <div class="chart-wrap"><canvas id="myBubbleChart" width="400px" height="400px"></canvas></div>
                        <div class="chart-wrap"><canvas id="myPolarAreaChart" width="400px" height="400px"></canvas></div>
                    </li>


                </ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ref/Chart.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/statistics.js"></script>
</body>
</html>