<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/27
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/style/base.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/style/other.css"/>
    <script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>


<div class="infoTop">
    <a href="/">首页</a>
    <span class="cut">&nbsp;&gt;&nbsp;</span>
    <a href="/car/cb_${car.branId}/cs_0/cp_0/cv_0/list.html" title="${car.brandName}">${car.brandName}</a>
    <span class="cut">&nbsp;&gt;&nbsp;</span>
    <span>${car.name}</span>
</div>
<div class="pro">
    <div class="left">
        <div class="jqzoom">
            <img src="${car.image}" width="500px"/>
        </div>
    </div><!--left/-->
    <div class="pro_details_topcenter">
        <div class="pro1" style="padding-left:0px">${car.name}</div>
        <p class="j_color">进口车型 详询经销商</p>
        <br/>
        <p class="soles">保障车源，保障质量，保障价格，保障售后</p>


        <div class="jiage2"><p>准价：</p><span class="red">￥${car.sell_price} 万</span> &nbsp;&nbsp;&nbsp;本平台优惠价格</div>

        <div class="jiage2 jiage3"><p>市场价：<span class="red2">￥${car.shop_price}</span> &nbsp;&nbsp;&nbsp;</p> <span
                class="reds">其他平台或4s店价格</span></div>
        <br/>
        <table class="cd_m_info_desc" cellspacing="0" border="0">
            <tbody>
            <%--<tr>--%>
            <%--<td>--%>
            <%--<span class="cd_m_info_desc_val">--%>
            <%--<a class="cd_m_innerlink1" href=" " target="_blank">2.8万公里</a>--%>
            <%--</span>--%>
            <%--<span class="cd_m_info_desc_key bor">表显里程</span>--%>
            <%--</td>--%>
            <%--<td><span class="cd_m_info_desc_val">2015-10</span><span class="cd_m_info_desc_key bor">上牌时间</span></td>--%>
            <%--<td><span class="cd_m_info_desc_val">2017-03-22</span><span class="cd_m_info_desc_key bor">上架时间</span></td>--%>
            <%--</tr>--%>

            <tr>
                <td><span class="cd_m_info_desc_val">${car.car_fuel_label}</span><span
                        class="cd_m_info_desc_key">排放标准</span></td>
                <td><span class="cd_m_info_desc_val">${car.car_displacement}/${car.car_gearbox}</span><span
                        class="cd_m_info_desc_key">排量/变速箱</span></td>
                <td><span class="cd_m_info_desc_val">北京</span><span class="cd_m_info_desc_key">看车地点</span></td>
            </tr>
            </tbody>
        </table>

        <p class="p5">
            <a href="#" class="one">预约看车</a> <a href="#" class="one two">我要置换</a>
        </p>
    </div><!--pro_details_topcenter end-->
</div>
<div class="cd_m_pop_yykc" style="top: 626px; left: 986.5px; display: block;">
    <input type="hidden" id="type_sale" value="3">
    <i></i><em></em>
    <p class="cd_m_pop_yykc_tit">完成预约后，客服专员会及时与您联系确认约车详情</p>
    <p class="cd_m_pop_yykc_input">
        <input id="txtYykcPhone" type="text" maxlength="11" style="display: none;">
        <span style="display: block;">请输入联系电话</span>
    </p>
    <p class="cd_m_pop_yykc_errortip" style="visibility: hidden;">
        请输入联系电话
    </p>
    <p class="cd_m_pop_yykc_input">
        <input id="txtYykcValid" type="text" maxlength="4" style="display: none;">
        <span>请输入图片验证码</span><a href="javascript:;">
        <img class="flush_vcode" id="codeimg_appoint" src="/register/get_vcode?r=Sat Apr 08 2017 10:40:30 GMT+0800 (中国标准时间)"></a>
    </p>
    <p class="cd_m_pop_yykc_errortip" style="visibility: hidden;">
        请输入图片验证码
    </p>
    <a class="cd_m_pop_yykc_ok">立即预约</a>
</div>





<div class="poss">
    <div class="poss2"></div>
    <div class="car-options clearFix" id="mynav">
        <div class="container">
            <ul class="fl info-select">
                <li class="current"><a href="#one">购车流程</a></li>
                <li class=""><a href="#one">配置参数</a></li>
                <li class=""><a href="#three">车系图片</a></li>
            </ul>
            <div class="btns">
                <a href="javascript:;" class="appointment J_AppointmentBtn" style="display: none;">预约看车</a>
            </div>
        </div>
    </div><!--car-options end-->
</div>
<div class="clear"></div>
<div class="bg_co">
    <div class="xi_qi">
        <div class="clear"></div>
        <div id="one"></div>
        <div class="d-item car-information" style="padding-bottom: 50px">
            <div class="container">
                <h2><strong>购车流程</strong></h2>
                <ul class="clearFix xinche">
                    <li>
                        <div class="num">1</div>
                        <div class="content">
                            <h4>网上浏览</h4>
                            <p>轻松挑选爱车</p>
                        </div>
                        <div class="arrow">&gt;</div>
                    </li>
                    <li>
                        <div class="num">2</div>
                        <div class="content">
                            <h4>电话咨询</h4>
                            <p>专属顾问1对1服务</p>
                        </div>
                        <div class="arrow">&gt;</div>
                    </li>
                    <li>
                        <div class="num">3</div>
                        <div class="content">
                            <h4>4S店看车</h4>
                            <p>全程置车顾问陪同</p>
                        </div>
                        <div class="arrow">&gt;</div>
                    </li>
                    <li>
                        <div class="num">4</div>
                        <div class="content">
                            <h4>门店提车</h4>
                            <p>北京百家合作4S店</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="clear"></div>
        <div id="two"></div>
        <h2><strong>配置参数</strong></h2>
        <div class="parameters clearFix">
            <div class="item performance">
                <h4>概览</h4>
                <ul id="J_PerformanceParam">
                    <li><span>车身结构</span>${car.car_door}门 ${car.car_seat}座 ${car.car_bodywork}</li>

                    <li><span>长*宽*高(mm)</span>${car.car_size}</li>

                    <li><span>轴距(mm)</span>${car.car_z_mm}</li>

                    <li><span>燃油标号</span>${car.car_fuel_label}</li>

                    <li><span>工信部综合油耗(L/100km)</span>${car.car_l_test}</li>

                    <li><span>环保标准</span>${car.car_environment_standards}</li>

                    <li><span>整车质保</span>${car.car_warranty}</li>

                    <li><span>行李厢容积(L)</span>${car.car_luggage}</li>
                </ul>
            </div><!--item end-->
            <div class="item safe">
                <h4>性能</h4>
                <ul id="J_SafeComfort">
                    <li><span>发动机</span>${car.car_engine}</li>

                    <li><span>排量(L)</span>${car.car_displacement}</li>

                    <li><span>最大功率(kW)</span>${car.car_mar_power}</li>

                    <li><span>最大扭矩(N·m)</span>${car.car_max_power_speed}</li>

                    <li><span>官方0-100km/h加速(s)</span>${car.car_hs_factory}</li>

                    <li><span>最高车速(km/h)</span>${car.car_maxspeed}</li>

                    <li><span>变速箱</span>${car.car_gearbox}</li>

                    <li><span>驱动方式</span>${car.car_drive_mode}</li>
                </ul>
            </div><!--item end-->
        </div><!--parameters end-->
        <div class="clear"></div>
        <div id="three"></div>
        <h2 ><strong>车系图片</strong></h2>
        <div class="xq_img">
            <div class="sec bnspic">
                <ul>
                    <c:forEach items="${imgArry}" var="simg">
                        <li class="on"><a href="#"><img src="${simg}" width="100%" height="100%"/> </a></li>
                    </c:forEach>
                </ul>
            </div>
        </div><!--xq_img end-->

    </div><!--xi_qi end-->

</div>
<jsp:include page="footer.jsp"></jsp:include>
<!--广告-->
<script>
    $(function () {
        var nav = $("#mynav"), mtop = 0, zindex = 999,
                dftop = 530,
                dfleft = nav.offset().left - $(window).scrollLeft(),
                dfcss = new Array;
        dfcss[0] = nav.css("position"),
                dfcss[1] = nav.css("top"),
                dfcss[2] = nav.css("left"),
                dfcss[3] = nav.css("zindex"),
                $(window).scroll(function (e) {
                    if ($(this).scrollTop() > dftop) {
                        nav.css({
                            position: "fixed",
                            top: mtop + "px",
                            left: dfleft,
                            "z-index": zindex
                        });
                        $(".J_AppointmentBtn").show();
//                        $(".bg_co").css({top:20+'px'})
                    } else {
                        nav.css({position: dfcss[0], top: dfcss[1], left: dfcss[2], "z-index": dfcss[3]});
                        $(".J_AppointmentBtn").hide();
                    }

                })

    });
</script>

</body>
</html>
