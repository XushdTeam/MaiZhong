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
    <link rel="stylesheet" type="text/css" href="/resources/style/other.css" />
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
            <img src="${car.image}" width="670px" />
        </div>
    </div><!--left/-->
    <div class="pro_details_topcenter">
        <div class="pro1" style="padding-top:10px;padding-left:0px">${car.name}</div>
        <p class="j_color">进口车型 详询经销商</p>
        <div class="jiage2"><p>准价：</p><span class="red">￥${car.sell_price}</span></div>
        <div class="jiage2 jiage3"><p>市场价：<span class="red2">￥${car.shop_price}</span></p></div>
        <table class="cd_m_info_desc" cellspacing="0" border="0">
            <tbody>
            <tr>
                <td>
                      <span class="cd_m_info_desc_val">
                            <a class="cd_m_innerlink1" href=" " target="_blank">2.8万公里</a>
                      </span>
                    <span class="cd_m_info_desc_key bor">表显里程</span>
                </td>
                <td><span class="cd_m_info_desc_val">2015-10</span><span class="cd_m_info_desc_key bor">上牌时间</span></td>
                <td><span class="cd_m_info_desc_val">2017-03-22</span><span class="cd_m_info_desc_key bor">上架时间</span></td>
            </tr>

            <tr>
                <td><span class="cd_m_info_desc_val">国Ⅳ(国Ⅴ)</span><span class="cd_m_info_desc_key">排放标准</span></td>
                <td><span class="cd_m_info_desc_val">2.4L/CVT无级变速</span><span class="cd_m_info_desc_key">排量/变速箱</span></td>
                <td><span class="cd_m_info_desc_val">北京</span><span class="cd_m_info_desc_key">看车地点</span></td>
            </tr>
            </tbody>
        </table>

        <p class="p5">
            <a href="#" class="one">预约看车</a> <a href="#" class="one two">我要置换</a>
        </p>
    </div><!--pro_details_topcenter end-->
</div>
<div class="poss">
    <div class="poss2"></div>
    <div class="car-options clearFix" id="mynav">
        <div class="container" >
            <ul class="fl info-select">
                <li class="current"><a href="#one">购车流程</a></li>
                <li class=""><a href="#two">配置参数</a></li>
                <li class=""><a href="#tree">车系图片</a></li>

            </ul>
            <div class="btns">
                <a href="javascript:;" class="appointment J_AppointmentBtn" style="display: none;">预约看车</a>
            </div>
        </div>
    </div><!--car-options end-->
</div>
<div class="bg_co">
    <div id="one" class="shoppin">
        <div class="d-item car-information">
            <div class="container">

                <ul class="clearFix zhunxinche">
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
    </div><!--#one end-->
    <div class="xi_qi">

        <h2 id="two"><strong>配置参数</strong></h2>
        <div class="parameters clearFix" >
            <div class="item performance">
                <h4>概览</h4>
                <ul id="J_PerformanceParam">
                    <li><span>车身结构</span>${car.car_door+car.car_seat+car.bodywork}</li>

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

                    <li><span>最大功率(kW)</span>${car.car_max_power}</li>

                    <li><span>最大扭矩(N·m)</span>${car.car_max_power_speed}</li>

                    <li><span>官方0-100km/h加速(s)</span>${car.car_hs_factory}</li>

                    <li><span>最高车速(km/h)</span>${car.car_maxspeed}</li>

                    <li><span>变速箱</span>${car.car_gearbox}</li>

                    <li><span>驱动方式</span>${car.car_drive_mode}</li>
                </ul>
            </div><!--item end-->
        </div><!--parameters end-->
        <div class="clear"></div>

        <h2 id="tree"><strong>车系图片</strong></h2>
        <div class="xq_img">


            <div class="sec bnspic">
                    <ul>
                        <li class="on"><a href="#"><img src="../../resources/img/xq_1.jpg"  width="100%"  /> </a></li>
                        <li><a href="#"><img src="../../resources/img/xq_1.jpg"  width="100%" /> </a></li>
                        <li><a href="#"><img src="../../resources/img/xq_1.jpg"  width="100%"  /> </a></li>
                        <li><a href="#"><img src="../../resources/img/xq_1.jpg"  width="100%" /> </a></li>
                        <li><a href="#"><img src="../../resources/img/xq_1.jpg"  width="100%"  /> </a></li>
                        <li><a href="#"><img src="../../resources/img/xq_1.jpg"  width="100%" /> </a></li>
                    </ul>
            </div>
        </div><!--xq_img end-->


        <div class="clear"></div>
      <%--  <h2 id="four"><strong>认证证书</strong></h2>
        <div class="zs">
            <img src="img/zs.jpg">
        </div>--%>


    </div><!--xi_qi end-->

</div>
<jsp:include page="footer.jsp"></jsp:include>
<!--广告-->
<script>
   $(function () {
       var nav = $("#mynav"),mtop = 0,zindex = 999,
               dftop = nav.offset().top - $(window).scrollTop(),
               dfleft = nav.offset().left - $(window).scrollLeft(),
               dfcss = new Array;
       dfcss[0] = nav.css("position"),
       dfcss[1] = nav.css("top"),
       dfcss[2] = nav.css("left"),
       dfcss[3] = nav.css("zindex"),
       $(window).scroll(function (e) {
           if($(this).scrollTop() > dftop){
               nav.css({
                   position: "fixed",
                   top: mtop + "px",
                   left: dfleft,
                   "z-index": zindex
               });
               $(".J_AppointmentBtn").show();
           }else{
               nav.css({position: dfcss[0], top: dfcss[1], left: dfcss[2], "z-index": dfcss[3]});
               $(".J_AppointmentBtn").hide();
           }

       })
       $(".small_pic li").mouseover(function(){
           $(this).siblings().removeClass("on");
           $(this).addClass("on");
           var preNumber=$(this).prevAll().size()+1;
           $(".big_pic li").removeClass("on");
           $(".big_pic li:nth-child("+preNumber+")").addClass("on");
       });
   });
</script>

</body>
</html>
