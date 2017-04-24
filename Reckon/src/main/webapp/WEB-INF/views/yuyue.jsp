<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/19
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/site.css" />

    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/js.js" type="text/javascript"></script>
    <script src="https://cdn.bootcss.com/layer/3.0.1/layer.js"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=N8kgZsufZYtKgEXbtUoTHrKlaqgAxTFY"></script>
</head>
<body>
<div class="top e_top">
    <div class="t_cen">
        <a href="#"><img src="../resources/img/logo.png"></a>
        <span class="tell">010-8025-8108</span>
        <span class="t_right">
            <a href="/sale" class="one">我要卖车</a>
            <a href="/login" class="one" id="login">登录</a>
            <a href="/per/or" class="two" id="user" style="display:none">188****8888</a>
            <a href="javascript:vold(0)" class="two">APP下载</a>
        </span>
    </div>
</div>

<div class="x_nav">当前位置 :  <a href="#">首页</a> > <a href="#">二手车评估</a> > 预约</div>

<div class="yuyue">
    <div class="left">
        <h1><span>1</span>验车方式</h1>
        <dl class="dl1">
            <dt class="dt1"> </dt>
            <dd class="dd1">门店验车</dd>
            <dd>24小时内到店交易 必中现金大奖</dd>
        </dl>

        <dl class="dl2">
            <dt class="dt2"> </dt>
            <dd class="dd1">上门验车</dd>
            <dd>免费上门服务，提前预约</dd>
        </dl>
        <div class="clear"></div>
        <div class="xk xk1">
            <h1><span>2</span>选择门店</h1>
            <div class="x_left">
                <ul>
                    <li class="active" data-id="0">全部门店</li>
                    <c:forEach items="${shop}" var="item">
                        <li data-id="${item.id}">${item.district}</li>
                    </c:forEach>

                </ul>
            </div>
            <div class="x_right">
                <div class="over">
                    <ul id="outlets-list" class="outlets-list scrollbar">
                        <c:forEach items="${shop}" var="item">
                            <c:forEach items="${item.shop}" var="j">
                                <li data-shop-id="${j.id}"
                                    data-location="${j.location}"
                                    data-address="${j.address}"
                                    data-title="${j.name}"
                                    style="display: list-item;" class="parent${j.districtId}">
                                    <p class="outlets-name">${j.name}</p>
                                    <p class="outlets-addr">${j.address}</p>
                                </li>
                            </c:forEach>
                        </c:forEach>
                    </ul>
                </div>
            </div><!--xiao_right-->
            <div class="baidumap" id="map"></div>
        </div><!--xk end-->
        <div class="clear"></div>
        <div class="xk xk2">
            <h1><span>2</span>验车方式</h1>
            <div class="quh">
                <div class="qu"> <span>地铁附近</span> <span>上门验车</span></div>
                <div class="d_1" >
                    <div class="one one1">
                        <p>地铁线路</p>
                        <div id="lineInput">地铁线路<img src="../resources/img/u.jpg"></div>
                    </div>

                    <div class="one">
                        <p>预约时间</p>
                        <div id="dateInput">预约时间<img src="../resources/img/u.jpg"></div>
                    </div>
                    <div class="hid">
                        <c:forEach items="${lines}" var="item">
                            <span  data-id="${item.id}">${item.name}线</span>
                        </c:forEach>
                    </div>
                    <div class="hid1">
                        <c:forEach items="${week}" var="item">
                            <span data-text="${item.Mday}${item.week}" data-date="${item.Ydate}">${item.Mday} <br> ${item.week}</span>
                        </c:forEach>


                    </div>
                </div>

                <div class="metro-station-wrap  clearfix ">
                    <div class="metro-station-content" id="lineSite">
                        <script id="list-tmpl" type="text/x-dot-template">
                            <ul style="margin-left: 0px;" id="ul_site">
                                {{ for(var i=0,len=it.length;i<len; i++) { }}
                                <li data-metro-station-id="{{=it[i].id}}">
                                    <div class="station-name">{{=it[i].name}}</div>
                                </li>
                                {{ } }}
                            </ul>
                        </script>
                    </div>

                </div>

                <div class="d_1" style="display: none;">
                    <div class="one one3">
                        <p>详细地址</p>
                        <input type="text" name="1" placeholder="请输入您的小区、大厦或街道名称" id="address">
                    </div>
                    <div class="one">
                        <p>交易时间</p>
                        <div id="dateInput1">预约时间<img src="../resources/img/u.jpg"></div>
                    </div>
                    <div class="hid2">
                        <c:forEach items="${week}" var="item">
                            <span data-text="${item.Mday}${item.week}" data-date="${item.Ydate}">${item.Mday} <br> ${item.week}</span>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div><!--xk end-->
        <div class="clear"></div>
        <h1><span>3</span>联系方式</h1>
        <div class="d_2">
            <div class="one one1">
                <p>输入姓名</p>
                <div>
                    <input type="text" name="name" id="userName" style="width: 100px;">
                    <label class="demo--label">
                        <input class="demo--radio" type="radio" value="先生" name="demo-radio" checked>
                        <span class="demo--radioInput"></span>先生
                    </label>
                    <label class="demo--label">
                        <input class="demo--radio" type="radio" value="女士" name="demo-radio">
                        <span class="demo--radioInput"></span>女士
                    </label>
                    <%--<input type="radio" value="先生" name="r" style="width: 20px" checked>先生--%>
                    <%--<input type="radio" value="女士" name="r" style="width: 20px">女士--%>
                </div>
            </div>
            <div class="one">
                <p>输入手机号</p>
                <div><input type="text" maxlength="11" name="phone" id="phone"></div>
                <p>用来接受订单信息</p>
            </div>
        </div><!--d_2 end-->
        <div class="clear"></div>
    </div><!--left end-->
    <div class="right">
        <dl>
            <dt><img src="${result.seriesImg}" width="100"></dt>
            <dd>${result.modelName}</dd>
            <dd class="dd2">￥${result.salePrice}万</dd>
        </dl>
        <div class="clear"></div>
        <div>
            <p> 所属地区: ${result.city}</p>
            <p> 行驶里程: ${result.mail}万公里</p>
            <p> 主体颜色: ${result.color}</p>
            <p> 使用性质: ${result.xz}</p>
            <p> 现使用方: ${result.method}</p>
            <p> 交强险有效期: ${result.jqx}</p>
            <p> 年检有效期: ${result.nj}</p>
            <p> 过户次数: ${result.gh}</p>
            <p> 最后一次过户时间: ${result.ghtime}</p>
            <p> 车况: ${result.ck}</p>
            <p> 评估时间: ${result.reckonTime}</p>
        </div>
    </div><!--right end -->
</div>
<input type="hidden" id="orderNum" value="${result.orderNumber}">
<div class="anniu" onclick="submit()">确认下单</div>
<div class="footer">
    <div class="foot_cen">
        <!--div class="n_f_m_c">
            <div class="">
                <a href="/about.html">关于我们</a>
                <a href="/help.html">帮助中心</a>
                <a href="/joinus.html">加入我们</a>
                <a href="/feedback.html">用户反馈</a>
            </div>
        </div-->

        <div class="pp">
            <p>Copyright © 2017-2020 迈众 All Rights Reserved 版权所有 迈众汽车信息服务有限公司</p>
            <p>京ICP备17017795号  &nbsp;&nbsp;&nbsp; 联系电话：010-8025-8108 &nbsp;&nbsp;&nbsp;
                <script type="text/javascript">
                    var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
                    document.write(unescape("%3Cspan id='cnzz_stat_icon_1261672623'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1261672623' type='text/javascript'%3E%3C/script%3E"));
                </script>
            </p>
        </div>

    </div>
</div>
</body>
<script src="/resources/js/doT.min.js" type="text/javascript"></script>
<script type="text/javascript">



    $(function () {

        var evalText = doT.template($("#list-tmpl").text());
        $(".hid1 span").click(function () {
            $(this).addClass('checked').siblings().removeClass("checked");
            var text = $(this).data("text");
            $("#dateInput").html(text+'<img src="../resources/img/u.jpg">');
            $(".hid1").hide();
        });
        $(".hid2 span").click(function () {
            $(this).addClass('checked').siblings().removeClass("checked");
            var text = $(this).data("text");
            $("#dateInput1").html(text+'<img src="../resources/img/u.jpg">');
            $(".hid2").hide();
        });
        $(".hid span").click(function(){
            $(this).addClass('cun').siblings().removeClass("cun");
            var lineId = $(this).data("id");
            var lineName = $(this).html();
            $("#lineInput").html(lineName+'<img src="../resources/img/u.jpg">');
            $(".hid").hide();

            $.getJSON("/getSite/"+lineId,function (d) {
                if(d.status == 200){
                    $("#lineSite").html('');
                    $("#lineSite").html(evalText(d.data));
                    $(".metro-station-wrap").css("visibility","visible");
                    var count = d.data.length;
                    var w = 35*count;
                    if(w>550){
                        $("#ul_site").css({"width":w+"px"}).parent().css({"overflow-x": "scroll"});
                    }else{
                        $("#ul_site").css({"width":w+"px"}).parent().css({"overflow-x": "hidden"});
                    }
                    $(".metro-station-content ul li").click(function(){
                        $(this).addClass("active").siblings().removeClass('active');
                    });

                }
            })


        });

        $("#lineInput").click(function () {
            $(this).html('地铁线路<img src="../resources/img/d.jpg">');
            $(".hid").show();
            $(".hid1").hide();
        })
        $("#dateInput").click(function () {
            $(this).html('预约时间<img src="../resources/img/d.jpg">');
            $(".hid1").show();
            $(".hid").hide();

        })
        $("#dateInput1").click(function () {
            $(this).html('交易时间<img src="../resources/img/d.jpg">');
            $(".hid2").show();

        })
        $(".x_left li").click(function(){
            $(this).addClass('active').siblings().removeClass("active");
            var id = $(this).data('id');
            if(id==0){
                $(".scrollbar li").show();
            }else{
                $(".scrollbar li").hide();
                $(".parent"+id).show();
            }
        });
        $(".scrollbar li").click(function () {
            var location = $(this).data('location');
            $(this).addClass('checked').siblings().removeClass("checked");

            if(map){
                map.centerAndZoom(new BMap.Point(location.split(',')[0],location.split(',')[1]),18);
            }
        });


    });
    $(document).ready(function(){

        var phone = $.cookie('phone');
        var token = $.cookie('token');
        if(phone&&token){
            $.getJSON('/loginByToken/'+phone+'/'+token,function (d) {
                if(d.status==200){
                    $("#login").hide();

                    $('#user').html(phone).show();

                    $("#phone").val(phone);

                }else{
                    $.cookie("phone",null,{path:"/"});
                    $.cookie("token",null,{path:"/"});
                }
            })
        }

        // 百度地图API功能
        window.map = new BMap.Map("map");
        map.centerAndZoom(new BMap.Point(116.404, 39.915), 10);
        map.enableScrollWheelZoom(true);
        var els = document.querySelectorAll(".scrollbar li");
        $.each(els,function(d,i){
            var location = $(i).data('location');
            var title = $(i).data('title');
            var address = $(i).data('address');
            var opts = {
                width : 250,     // 信息窗口宽度
                height: 80,     // 信息窗口高度
                title : title , // 信息窗口标题
                enableMessage:true//设置允许信息窗发送短息
            };

            var point = new BMap.Point(location.split(',')[0],location.split(',')[1]);
            var marker = new BMap.Marker(point);  // 创建标注

            map.addOverlay(marker);
            // 将标注添加到地图中
            var infoWindow = new BMap.InfoWindow("地址："+address, opts);  // 创建信息窗口对象
            marker.addEventListener("click", function(){
                map.openInfoWindow(infoWindow,point); //开启信息窗口
            });
        })
    })

    var submit = function () {
        //判断方式
        if($('.dl1').hasClass('hover')){
            //门店
            var els = document.querySelectorAll(".scrollbar li");
            var shopId = "";
            $.each(els,function (d,i) {
                if($(i).hasClass('checked')){
                    shopId = $(i).data('shop-id');
                    return false;
                }
            })
            if(!shopId){
                layer.msg('请选择4S店',{
                    offset: 't',
                    anim: 6
                });
                return false;
            }
            var userName = $("#userName").val();
            if(!userName){
                layer.msg('请输入您的姓氏',{
                    offset: 't',
                    anim: 6
                });
                return false;
            }

            var phone = $("#phone").val();
            if(!(/^1[34578]\d{9}$/.test(phone))){
                layer.msg('手机号格式不正确',{
                    offset: 't',
                    anim: 6
                });
                return false;
            }
            var name_right = $('.demo--label input:radio:checked').val();

            var orderNum = $("#orderNum").val();

            var param={};
            param.orderNumber = orderNum;
            param.dealWay = "1";
            param.wayId = shopId;
            param.linkMan = userName+name_right;
            param.linkPhone = phone;
            param.checktime = "";
            param.address = "";


            $.post("/OrderConfim",param,function(res){
                if(res.status==200){
                    window.location.href = "/per/or"
                }
            },'JSON');

        }else{
           //判断选择是地铁还是上门
            if($('.qu span').eq(0).hasClass('hovers')){
                //地铁
                var els = document.querySelectorAll("#ul_site li");
                var siteId = "";
                $.each(els,function (d,i) {
                    if($(i).hasClass('active')){
                        siteId = $(i).data('metro-station-id');
                        return false;
                    }
                })
                if(!siteId){
                    layer.msg('请选择地铁站',{
                        offset: 't',
                        anim: 6
                    });
                    return false;
                }
                els = document.querySelectorAll(".hid1 span");
                var date = "";
                $.each(els,function (d,i) {
                    if($(i).hasClass('checked')){
                        date = $(i).data('date');
                        return false;
                    }
                })
                if(!date){
                    layer.msg('请选择预约时间',{
                        offset: 't',
                        anim: 6
                    });
                    return false;
                }
                var userName = $("#userName").val();
                if(!userName){
                    layer.msg('请输入您的姓氏',{
                        offset: 't',
                        anim: 6
                    });
                    return false;
                }

                var phone = $("#phone").val();
                if(!(/^1[34578]\d{9}$/.test(phone))){
                    layer.msg('手机号格式不正确',{
                        offset: 't',
                        anim: 6
                    });
                    return false;
                }
                var name_right = $('.demo--label input:radio:checked').val();

                var orderNum = $("#orderNum").val();

                var param={};
                param.orderNumber = orderNum;
                param.dealWay = "2";
                param.wayId = siteId;
                param.linkMan = userName+name_right;
                param.linkPhone = phone;
                param.checktime = date;
                param.address = "";

                $.post("/OrderConfim",param,function(res){
                    if(res.status==200){
                        window.location.href = "/per/or"
                    }
                },'JSON');


            }else{
                //上门
                var address = $("#address").val();
                if(!address){
                    layer.msg('请输入详细地址',{
                        offset: 't',
                        anim: 6
                    });
                    return false;
                }
                var els = document.querySelectorAll(".hid2 span");
                var date = "";
                $.each(els,function (d,i) {
                    if($(i).hasClass('checked')){
                        date = $(i).data('date');
                        return false;
                    }
                })
                if(!date){
                    layer.msg('请选择预约时间',{
                        offset: 't',
                        anim: 6
                    });
                    return false;
                }
                var userName = $("#userName").val();
                if(!userName){
                    layer.msg('请输入您的姓氏',{
                        offset: 't',
                        anim: 6
                    });
                    return false;
                }

                var phone = $("#phone").val();
                if(!(/^1[34578]\d{9}$/.test(phone))){
                    layer.msg('手机号格式不正确',{
                        offset: 't',
                        anim: 6
                    });
                    return false;
                }
                var name_right = $('.demo--label input:radio:checked').val();

                var orderNum = $("#orderNum").val();


                var param={};
                param.orderNumber = orderNum;
                param.dealWay = "3";
                param.wayId = "0";
                param.linkMan = userName+name_right;
                param.linkPhone = phone;
                param.checktime = date;
                param.address = address;

                $.post("/OrderConfim",param,function(res){
                    if(res.status==200){
                        window.location.href = "/per/or"
                    }
                },'JSON');



            }
        }

    }

</script>
</html>
