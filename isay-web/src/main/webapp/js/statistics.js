/**
 * Created by biubiu on 2017/10/16.
 */

$(function(){

    function rand(min, max) {
        return Math.floor(Math.random()*(max-min+1) + min);
    }

    window.randomScalingFactor = function() {
        var val = rand(-100, 100);
        return val;
    };

    function A(){
    	var url = isay.preUrl + '/card/stat/A';
    	var args = {};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			chartA(res.data);
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    }
    
    A();
    
    function B(){
    	var url = isay.preUrl + '/card/stat/B';
    	var args = {};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			chartB(res.data);
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    }
    
    B();
    
    function C(){
    	var url = isay.preUrl + '/card/stat/C';
    	var args = {};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			chartC(res.data);
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    }
    
    C();
    
    function D(){
    	var url = isay.preUrl + '/card/stat/D';
    	var args = {};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			chartD(res.data);
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    }
    
    D();
    
    function E(){
    	var url = isay.preUrl + '/card/stat/E';
    	var args = {};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			chartE(res.data);
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    }
    
    E();
    
    function F(){
    	var url = isay.preUrl + '/card/stat/F';
    	var args = {"year": "2018"};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			chartF(res.data);
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    }
    
    F();
    
    function G(){
    	var url = isay.preUrl + '/card/stat/G';
    	var args = {};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			chartG(res.data);
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    }
    
    G();
    
    function H(){
    	var url = isay.preUrl + '/card/stat/H';
    	var args = {};
    	$.getJSON(url, args, function(res){
    		if(res.code == 0){
    			chartH(res.data);
    		}else{
    			isay.pageTip(res.msg);
    		}
    	});
    }
    
    H();

    function chartA(data){
    	var $ctx = $('#myBarChart');
        var mychart = new Chart($ctx, {
            type: 'bar',
            data: {
                labels: [data.postUser.nickname, data.upUser.nickname, data.downUser.nickname],
                datasets: [{
                    label: '赞成',
                    data: [data.upNum],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)'
                    ],
                    borderWidth: 1
                },{
                    label: '反对',
                    data: [data.downNum],
                    backgroundColor: [
                        'rgba(54, 162, 235, 0.2)'
                    ],
                    borderColor: [
                        'rgba(54, 162, 235, 1)'
                    ],
                    borderWidth: 1
                },{
                    label: '发帖',
                    data: [data.postNum],
                    backgroundColor: [
                        'rgba(255, 206, 86, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 206, 86, 1)'
                    ],
                    borderWidth: 1
                }],
            },
            options: {
                title:{
                    display:true,
                    text:'Top用户统计'
                },
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero:true
                        }
                    }]
                }
            }
        });
    }
    
    function chartB(data){
    	var $ctx = $('#myBarChart2');
        var mychart = new Chart($ctx, {
            type: 'bar',
            data: {
                labels: [
                	data.visitPost.postTitle,
                	data.commentPost.postTitle,
                	data.collectPost.postTitle,
                	data.upPost.postTitle,
                	data.downPost.postTitle
                	],
                datasets: [{
                    label: '浏览最多的',
                    data: [data.visitNum],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)'
                    ],
                    borderWidth: 1
                },{
                    label: '评论最多的',
                    data: [data.commentNum],
                    backgroundColor: [
                        'rgba(54, 162, 235, 0.2)'
                    ],
                    borderColor: [
                        'rgba(54, 162, 235, 1)'
                    ],
                    borderWidth: 1
                },{
                    label: '收藏最多的',
                    data: [data.collectNum],
                    backgroundColor: [
                        'rgba(255, 206, 86, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 206, 86, 1)'
                    ],
                    borderWidth: 1
                },{
                    label: '获赞最多的',
                    data: [data.upNum],
                    backgroundColor: [
                        'rgba(10, 179, 17, 0.2)'
                    ],
                    borderColor: [
                        'rgba(10, 179, 17, 1)'
                    ],
                    borderWidth: 1
                },{
                    label: '反对最多的',
                    data: [data.downNum],
                    backgroundColor: [
                        'rgba(76, 10, 179, 0.2)'
                    ],
                    borderColor: [
                        'rgba(76, 10, 179, 1)'
                    ],
                    borderWidth: 1
                }],
            },
            options: {
                title:{
                    display:true,
                    text:'Top帖子统计'
                },
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero:true
                        }
                    }]
                }
            }
        });
    }
    
    function chartC(data){
    	var $ctx3 = $('#myRadarChart');
        var mychart3 = new Chart($ctx3, {
            type: 'radar',
            data:{
                labels: ["总用户数",",总帖子数","评论数","留言数","闲聊数"],
                datasets: [{
                    label: "总计",
                    backgroundColor: 'rgba(234, 61, 61, 0.3)',
                    borderColor: 'rgba(234, 61, 61, 0.9)',
                    pointBackgroundColor: 'rgba(234, 61, 61, 0.9)',
                    data: [
                        data.userNum,
                        data.postNum,
                        data.commentNum,
                        data.massageNum,
                        data.chatNum
                    ]
                },]
            },
            options: {
                legend: {
                    position: 'top'
                },
                title: {
                    display: true,
                    text: '各个统计总数'
                },
                scale: {
                    ticks: {
                        beginAtZero: true
                    }
                }
            }
        });
    }
    function chartD(data){
    	var $ctx4 = $('#myDoughnutChart');
        var mychart4 = new Chart($ctx4,{
            type: 'doughnut',
            data: {
                labels: [
                    data[0].area.areaName,
                    data[1].area.areaName,
                    data[2].area.areaName,
                    data[3].area.areaName,
                    data[4].area.areaName,
                    data[5].area.areaName,
                    data[6].area.areaName,
                ],
                datasets: [{
                    data: [
                    	data[0].postNum,
                    	data[1].postNum,
                    	data[2].postNum,
                    	data[3].postNum,
                    	data[4].postNum,
                    	data[5].postNum,
                    	data[6].postNum,
                    ],
                    backgroundColor: [
                        'rgb(255, 99, 132)',
                        'rgb(75, 192, 192)',
                        'rgb(54, 162, 235)',
                        'rgb(253, 180, 92)',
                        'rgb(61, 220, 32)',
                        'rgb(180, 16, 199)',
                        'rgb(199, 16, 109)',
                    ],
                    label: 'Dataset 1'
                }]
            },
            options: {
                responsive: true,
                legend: {
                    position: 'top',
                },
                title: {
                    display: true,
                    text: '不同领域里面的帖子数'
                },
                animation: {
                    animateScale: true,
                    animateRotate: true
                }
            }
        });
    }
    function chartE(data){
    	var $ctx5 = $('#myPieChart');
        var mychart5 = new Chart($ctx5,{
            type: 'pie',
            data: {
                labels: [
                	data[0].area.areaName,
                    data[1].area.areaName,
                    data[2].area.areaName,
                    data[3].area.areaName,
                    data[4].area.areaName,
                    data[5].area.areaName,
                    data[6].area.areaName,
                ],
                datasets: [{
                    data: [
                    	data[0].labelNum,
                    	data[1].labelNum,
                    	data[2].labelNum,
                    	data[3].labelNum,
                    	data[4].labelNum,
                    	data[5].labelNum,
                    	data[6].labelNum,
                    ],
                    backgroundColor: [
                    	'rgb(255, 99, 132)',
                        'rgb(75, 192, 192)',
                        'rgb(54, 162, 235)',
                        'rgb(253, 180, 92)',
                        'rgb(61, 220, 32)',
                        'rgb(180, 16, 199)',
                        'rgb(199, 16, 109)',
                    ],
                    label: 'Dataset 1'
                }]
            },
            options: {
                title: {
                    display: true,
                    text: '每个领域的标签数'
                },
                responsive: true
            }
        });
    }
    function chartF(data){
    	var $ctx6 = $('#myLineChart');
        var mychart6 = new Chart($ctx6, {
            type: 'line',
            data: {
                labels: [
                	data[0].month,
                	data[1].month,
                	data[2].month,
                	data[3].month,
                	data[4].month,
                	data[5].month,
                	data[6].month,
                	data[7].month,
                	data[8].month,
                	data[9].month,
                	data[10].month,
                	data[11].month,
                ],
                //borderDashOffset: 100000,
                //lineTension: 0,
                datasets: [{
                    label: "折线",
                    backgroundColor: '#ff4d4d',
                    borderColor: '#ff4d4d',
                    data: [
                    	data[0].num,
                    	data[1].num,
                    	data[2].num,
                    	data[3].num,
                    	data[4].num,
                    	data[5].num,
                    	data[6].num,
                    	data[7].num,
                    	data[8].num,
                    	data[9].num,
                    	data[10].num,
                    	data[11].num,
                    ],
                    //lineTension: 0, //设置成0，使其具有折线图的外观，否则是曲线图
                    fill: false
                },]
            },
            options: {
                responsive: true,
                title:{
                    display:true,
                    text:'每月的帖子数'
                },
                tooltips: {
                    mode: 'index',
                    intersect: false
                },
                hover: {
                    mode: 'nearest',
                    intersect: true
                },
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: '月份'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: '帖子数'
                        }
                    }]
                },
                //elements: {
                //    line: {
                //        tension: 0, // 禁用整个图表的贝赛尔曲线
                //    }
                //},
                //showLines: false, // 禁用行，只显示数据点
            }
        });
    }
    
    function chartG(data){
    	var arr = new Array();
    	for(var i = 0; i < data.length; i++){
    		arr[i] = {
    				x: data[i].upNum / 100,
                    y: data[i].downNum / 100,
                    r: data[i].visitNum / 1000,
    		};
    	}
    	var $ctx7 = $('#myBubbleChart');
        var mychart7 = new Chart($ctx7, {
            type: 'bubble',
            data: {
                animation: {
                    duration: 10000
                },
                datasets: [{
                    label: "",
                    backgroundColor: 'rgba(255, 99, 132, 0.5)',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 1,
                    data: arr
                }]
            },options: {
                responsive: true,
                title:{
                    display:true,
                    text:'根据发帖量选出前10名用户，在查出10名用户的赞成数，反对数，以及浏览量'
                },
                tooltips: {
                    mode: 'point'
                }
            }
        });
    }

    function chartH(data){
    	var arr = new Array();
    	for(var i = 0; i < data.length; i++){
    		arr[i] = {
    				x: data[i].visitNum,
    				y: data[i].commentNum
    		}
    	}
    	var $ctx7 = $('#myScatterChart');
        var mychart7 = new Chart($ctx7, {
            type: 'scatter',
            data: {
                datasets: [{
                    label: '散点数据',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    backgroundColor: 'rgba(255, 99, 132, 0.5)',
                    pointRadius: 5, //渲染点的半径
                    data: arr
                }]
            },
            options: {
                title: {    //标题
                    display: true,
                    text: '根据赞成数选出前十名文章，并获取浏览量与评论数'
                },
                scales: {
                    xAxes: [{
                        display: true,
                        type: 'linear',
                    	position: 'bottom',
                        scaleLabel: {
                            display: true,
                            labelString: '评论数'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: '浏览量'
                        }
                    }]
                },
            }
        });
    }

    

    var $ctx6 = $('#myPolarAreaChart');
    var mychart6 = new Chart($ctx6, {
        type: 'polarArea',
        data: {
            datasets: [{
                data: [100,25,90],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.5)',
                    'rgba(75, 192, 192, 0.5)',
                    'rgba(54, 162, 235, 0.5)'
                ],
                label: 'My dataset' // for legend
            }],
            labels: [
                "Red",
                "Green",
                "Blue"
            ]
        },
        options: {
            responsive: true,
            legend: {   //图例
                position: 'top'
            },
            title: {    //标题
                display: true,
                text: 'Chart.js Polar Area Chart'
            },
            scale: {
                ticks: {
                    beginAtZero: true
                },
                reverse: false
            },
            animation: {
                animateRotate: false,
                animateScale: true
            }
        }
    });

    


});