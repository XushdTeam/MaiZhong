<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/20
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>悟空收车</title>
    <meta name="keywords" content="悟空收车，悟空，二手车，估值，收购"/>
    <meta name="description" content="悟空收车专业的二手车估值收购平台，验车快，当天到账，售后跟踪"/>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css" />
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />
    <script src="https://cdn.bootcss.com/jquery/3.0.0/jquery.min.js"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="bgss">
<!--头部开始-->
<div class="top e_top">
    <div class="t_cen">
        <a href="/" class="logo"><img src="/resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="/">首页</a></li>
            <li><a href="/sale" target="_blank">我要卖车</a></li>
            <li><a href="/join" target="_blank">销售商加盟</a></li>
            <li><a href="/app" target="_blank">APP下载</a></li>
           <li><a href="/help" target="_blank">帮助中心</a></li>
            <li><a href="/per/or"  class="hover" target="_blank">个人中心</a></li>
        </ul>
        <ul class="lon" style="margin-right: 0px">
            <li >
                <i class="iconfont icon ">&#xe6a3;</i>
                <a href="/per/or"  id="user">${phone}</a>
            </li>
            <li>
                <a href="javascript:void(0)" class="two" id="exit"  onclick="exit();">退出</a>
            </li>
            <li >
                <img src="/resources/img/erwei.jpg" onmouseover="javascript:$('#erw').show()" onmouseleave="javascript:$('#erw').hide()" >
                <div style="display: none;position: absolute;z-index: 1989" id="erw">
                    <img src="/resources/img/m_11.jpg" width="150" >
                </div>
            </li>
        </ul>
    </div>
</div><!--top end-->


<div class="x_nav" style="height: 40px"></div>
<style>
    a{text-decoration:none!important;}
    .main .m_left ul li span{
        font-size: 14px;
        color: #000;

        width: 180px;
        display: block;
        padding-left: 36px;
    }
    .main .m_left ul a li:hover{
        color: #F60!important;
    }
</style>
<div class="main">
    <div class="m_left">
        <ul>
            <a href="/per/or"  style="display: block">
                <li ><img src="/resources/img/p_03.jpg">
                    订单中心
                    <span >查看订单详情</span>
                </li>

            </a>
        </ul>

        <ul>
            <a href="/per/sh" style="display: block">
                <li><img src="/resources/img/p_06.jpg">
                    售后进度
                    <span>过户、指标更新状态</span>
                </li>

            </a>
        </ul>

        <ul>
            <a href="javascript:;" style="display: block" class="cuns">
                <li style="color:#f60"><img src="/resources/img/p_12.jpg">
                    历史成交车辆
                    <span style="color: #F60">历史记录</span>
                </li>
            </a>
        </ul>
    </div><!--m_left-->
    <div class="m_right">
        <p class="m_top">
            <span class="span1">订单名称</span>
            <span class="mon">价格</span>
            <span >状态</span>
            <span >进度</span>
        </p>
        <c:forEach items="${orderInfo}" var="item">
            <c:if test="${item.status=='6'}">
            <p class="danxix">
                <span>订单号：${item.orderNumber}</span>
                <span class="colors">${item.reckon_time}</span>
                <span class="colors detal" style="cursor: pointer" data-id="${item.orderNumber}">详细</span>
            </p>
            <div class="td">
                <div class="flot ont">
                    <img src="${item.seriesImg}">
                    <span>${item.modelName}</span>
                </div>
                <div class="flot mony">￥${item.reckonPrice}万</div>
                <div class="flot monys">
                    <c:if test="${item.status=='0'}">
                        待预约
                    </c:if>
                    <c:if test="${item.status=='1'}">
                        待验车
                    </c:if>
                    <c:if test="${item.status=='2'}">
                        车辆处理中
                    </c:if>
                    <c:if test="${item.status=='3'}">
                        等待过户
                    </c:if>
                    <c:if test="${item.status=='4'}">
                        过户完成
                    </c:if>
                    <c:if test="${item.status=='5'}">
                        更新指标
                    </c:if>
                    <c:if test="${item.status=='6'}">
                        --
                    </c:if>
                </div>
                <div class="flot none monys">
                    <c:if test="${item.status!='6'}">
                        进行中
                    </c:if>
                    <c:if test="${item.status=='6'}">
                        完结
                    </c:if>
                </div>
            </div>
            <div class="modal fade" id="modal${item.orderNumber}" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">订单详情</h4>
                        </div>
                        <div class="modal-body">
                            <div class="container">
                                <div class="row">
                                    <div class="span12">
                                        <h3>车辆信息</h3>
                                        <div class="media">
                                            <a href="javascript:void(0);" class="pull-left"><img src="${item.seriesImg}" class="media-object" alt='' width="100"/></a>
                                            <div class="media-body">
                                                <h4 class="media-heading">
                                                        ${item.modelName}
                                                </h4>
                                                <span>${item.model.gearType}</span>|
                                                <span>排量${item.model.liter}</span>|
                                                <span>${item.model.dischargeStandard}</span>|
                                                <span>座位${item.model.seatNumber}</span>|
                                                <span>新车售价${item.model.modelPrice}万</span>
                                            </div>
                                        </div>
                                        <h3>估值信息</h3>
                                        <div class="media">
                                            <div class="media-body">
                                                <span>城市：${item.orderInfo.cityId}</span> |
                                                <span>公里数：${item.orderInfo.sKm}万公里</span> |
                                                <span>上牌时间：${item.orderInfo.regDate}</span> |
                                                <span>颜色：${item.orderInfo.color}</span> |<br>
                                                <span>过户次数：${item.orderInfo.gh}</span> |
                                                <span>过户时间：${item.orderInfo.ghtime}</span> |
                                                <span>交强险：${item.orderInfo.jqx}</span> |
                                                <span>年检：${item.orderInfo.nj}</span> |<br>
                                                <span>使用性质：${item.orderInfo.xz}</span> |
                                                <span>现使用方：${item.orderInfo.method}</span> |
                                                <span>车况：${item.orderInfo.ck}</span>
                                            </div>
                                        </div>
                                        <br>
                                        <h3>预约信息</h3>
                                        <div class="media">
                                            <div class="media-body">
                                                <dt>验车方式</dt>
                                                <dd>${item.dealWay}</dd>
                                                <dt>地址</dt>
                                                <dd>${item.address}</dd>
                                                <dt>预约时间</dt>
                                                <dd>${item.checkTime}</dd>
                                                <dt>联系人/联系方式</dt>
                                                <dd>${item.linkMan}/${item.linkPhone}</dd>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            </c:if>
        </c:forEach>

    </div><!--m_right-->
</div><!--main end-->


<%@include file="footer.jsp"%>





<script>
    $(function(){

        $(".danxix .detal").click(function(){
            var id = $(this).data('id');
            $('#modal'+id).modal('show');
        });

    })
    function exit(){
        $.cookie("phone",null,{path:"/"});
        $.cookie("token",null,{path:"/"});
        window.location.href="/";
    }
</script>


</body>
</html>
