<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/3
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
    <title>悟空收车</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Windows-Target" contect="_top">
    <meta name="keywords" content="悟空收车，悟空，二手车，估值，收购"/>
    <meta name="description" content="悟空收车专业的二手车估值收购平台，验车快，当天到账，售后跟踪"/>
	<link rel="icon" href="/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css" />
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />

    <link rel="stylesheet" type="text/css" href="/resources/css/owl.carousel.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/owl.theme.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/owl.carousel.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cxscroll.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js"></script>
    <script src="/resources/js/js.js"></script>
    <script language="javascript">
        function imgdragstart(){return false;}
    </script>
</head>
<body>
<!--头部开始-->
  <div class="bg_top1">

      <span class="bg_x">
          <a href="/activity/3" style="display: block;float: left;height: 59px; width: 90%;"></a>
          <a href="javascript:void(0)" onclick="$('.bg_top1').hide();" style="color: #fff; background:rgba(0,0,0,0.3); padding:2px 5px">X</a>
      </span>

  </div>


    <div class="top e_top">
        <div class="t_cen">
            <a href="/" class="logo"><img src="/resources/img/logo.png"></a>
            <ul class="t_right">
                <li><a href="/" class="hover">首页</a></li>
                <li><a href="/sale" target="_blank">我要卖车</a></li>
                <li><a href="/join" target="_blank">销售商加盟</a></li>
                <li><a href="/app" target="_blank">APP下载</a></li>
               <li><a href="/help" target="_blank">帮助中心</a></li>
                <li style="display: none;" id="user_li"><a href="/per/or" target="_blank" >个人中心</a></li>
            </ul>
            <ul class="lon" style="margin-top: 0px;">
                <li >
                    <i class="iconfont icon ">&#xe6a3;</i>
                    <a href="/login" target="_blank" id="user">登录</a>
                </li>
                <li>
                    <a href="javascript:void(0)" class="two" id="exit" style="display:none" onclick="exit();">退出</a>
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



<div class="pos">
    <div class="guzs">
       <div class="pinggu">

        <ul class="pt16">
            <li class="mb13" style="z-index:100">
                <div class="select_box" id="select1">
                    <div id="valnone">请 选 择 车 型</div>
                </div>
                <div class="bg0 lr_158_30 select model" id="select1_1" style="display: none"></div>
                <div class="ucarselecttype lr_158_30 select model" id="select1_2" style="width: 227px; height: 450px; display: none;">
                    <div class="ucarselecttype_pinpai " style="width:227px;height:450px">
                        <div class="ucarselecttype_pinpaitop" id="xzpp" style="width:222px;">请选择品牌</div>
                        <div class="left_list letters">
                            <a href="javascript:void(0)" id="letters_0" class="pinpai_num" rel="4">A</a>
                            <a href="javascript:void(0)" id="letters_1" class="pinpai_num" rel="26">B</a>
                            <a href="javascript:void(0)" id="letters_2" class="pinpai_num" rel="32">C</a>
                            <a href="javascript:void(0)" id="letters_3" class="pinpai_num" rel="45">D</a>
                            <a href="javascript:void(0)" id="letters_4" class="pinpai_num" rel="54">F</a>
                            <a href="javascript:void(0)" id="letters_5" class="pinpai_num" rel="60">G</a>
                            <a href="javascript:void(0)" id="letters_6" class="pinpai_num" rel="77">H</a>
                            <a href="javascript:void(0)" id="letters_7" class="pinpai_num" rel="91">J</a>
                            <a href="javascript:void(0)" id="letters_8" class="pinpai_num" rel="99">K</a>
                            <a href="javascript:void(0)" id="letters_9" class="pinpai_num" rel="113">L</a>
                            <a href="javascript:void(0)" id="letters_10" class="pinpai_num" rel="122">M</a>
                            <a href="javascript:void(0)" id="letters_11" class="pinpai_num" rel="124">N</a>
                            <a href="javascript:void(0)" id="letters_12" class="pinpai_num" rel="128">O</a>
                            <a href="javascript:void(0)" id="letters_13" class="pinpai_num" rel="133">Q</a>
                            <a href="javascript:void(0)" id="letters_14" class="pinpai_num" rel="137">R</a>
                            <a href="javascript:void(0)" id="letters_15" class="pinpai_num" rel="150">S</a>
                            <a href="javascript:void(0)" id="letters_16" class="pinpai_num" rel="154">T</a>
                            <a href="javascript:void(0)" id="letters_17" class="pinpai_num" rel="160">W</a>
                            <a href="javascript:void(0)" id="letters_18" class="pinpai_num" rel="169">X</a>
                            <a href="javascript:void(0)" id="letters_19" class="pinpai_num" rel="177">Y</a>
                            <a href="javascript:void(0)" id="letters_20" class="pinpai_num" rel="185">Z</a>
                        </div>
                        <div class="ucarselecttype_pinpaibottom brandgun" style="width:180px;">
                            <div class="ucarselecttype_pinpaibottom_ul brand">
                                <c:forEach items="${brandList}" var="i">
                                    <p id="${i.key}" class="pinpailist" style="background:#e3e3e3;text-align:center">${i.key}</p>
                                    <c:forEach items="${i.object}" var="j">
                                        <p class="pinpailist list_1" id="${j.key}" rel="A">${j.value}</p>
                                    </c:forEach>
                                </c:forEach>
                             </div>
                        </div>
                    </div>
                </div>
                <div class="bg0 lr_158_30 select model" style="width: 210px;height: 458px;left: 252px;display: none;" id="select2_1"></div>
                <div class="ucarselecttype lr_158_30 select model" style="left:260px;width:200px;height:450px;display: none;" id="select2_2">
                    <div class="ucarselecttype_pinpai" style="width:190px; height:450px;">
                        <div class="ucarselecttype_pinpaitop" id="xzcx" style="width:190px;">
                            请选择车系
                        </div>
                        <div class="ucarselecttype_pinpaibottom" style="width:190px;">
                            <div class="ucarselecttype_pinpaibottom_ul series"></div>
                        </div>
                    </div>
                </div>
                <div class="bg0 lr_158_30 select model" style="width:420px; height:458px; left:463px;display: none;" id="select3_1"></div>
                <div class="ucarselecttype lr_158_30 select model" style="left:472px;width:411px;height:450px;display: none;" id="select3_2">
                    <div class="ucarselecttype_pinpai last" style="width:400px;height:450px;">
                        <div class="ucarselecttype_pinpaitop" id="xzcxing" style="width:400px;">请选择车型</div>
                        <div class="ucarselecttype_pinpaibottom" style="width:400px;">
                            <div class="ucarselecttype_pinpaibottom_ul simple"></div>
                        </div>
                    </div>
                </div>
            </li>
            <li class="mb13" style="z-index:99">
                <div class="select_box" id="select4">请 选 择 年 份</div>
                <div class="bg1 lr_158_30 sele regDate" id="sele1_1" style="height:365px;display: none;"></div>
                <div class="ucarselecttype lr_158_30 sele regDate" id="sele1_2" style="width:182px;height:310px;display: none;">
                    <div class="ucarselecttype_pinpai" style="height:310px;">
                        <div class="ucarselecttype_pinpaitop selyear" style="width:180px;">选择年份</div>
                        <div class="ucarselecttype_pinpaibottom" style="height:320px;width:163px; margin-left:7px">
                            <div class="ucarselecttype_pinpaibottom_ul years"></div>
                        </div>
                    </div>
                </div>
                <div class="bg1 lr_158_30 sele regDate" id="sele2_1" style="height:365px;left:208px;display: none;"></div>
                <div class="ucarselecttype lr_158_30 sele regDate" id="sele2_2" style="left:206px;width:182px;height:340px;display: none;">
                    <div class="ucarselecttype_pinpai" style="height:340px;">
                        <div class="ucarselecttype_pinpaitop selmonth" style="width:180px;">选择月份</div>
                        <div class="ucarselecttype_pinpaibottom" style="height:320px;width:165px; margin-left:7px">
                            <div class="ucarselecttype_pinpaibottom_ul months"></div>
                        </div>
                    </div>
                </div>
            </li>
            <li class="mb13" style="z-index:88">
                <div class="select_box" id="select5">
                    北京</div>
                <div class="bg1 lr_158_30 sel zone" id="sel1_1" style="display: none;"></div>
                <div class="ucarselecttype lr_158_30 sel zone" id="sel1_2" style="width:182px;height:310px;display: none;">
                    <div class="ucarselecttype_pinpai" style="height:310px;">
                        <div class="ucarselecttype_pinpaitop selprov" style="width: 170px;">选择省份</div>
                        <div class="ucarselecttype_pinpaibottom" style="height:265px;width:165px; margin-left:7px">
                            <div class="ucarselecttype_pinpaibottom_ul select_province">
                               <c:forEach items="${proviceList}" var="i" varStatus="status">
                                   <p class="list_6 province <c:if test="${status.count == 1}">layerbg2</c:if>" id="${i.id}">${i.name}</p>
                               </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="bg1 lr_158_30 sel zone" id="sel2_1" style="left:208px;display: none;"></div>
                <div class="ucarselecttype lr_158_30 sel zone" id="sel2_2" style="left:206px;width:182px;height:310px;display: none;">
                    <div class="ucarselecttype_pinpai" style="height:310px;">
                        <div class="ucarselecttype_pinpaitop selcity">选择城市</div>
                        <div class="ucarselecttype_pinpaibottom" style="height:265px;width:160px; margin-left:7px">
                            <div class="ucarselecttype_pinpaibottom_ul select_city">
                                <p class="pinpailist list_7 layerbg2 pinpailisthover" id="1">北京</p>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
            <li class="mb13" style="z-index:77">
                <div class="select_box none" id="gongli">
                    <input name="s_km" type="text" class="numgongli" id="lichengpd" maxlength="6" autocomplete="off" style="padding-left:0;">
                    <label>万公里</label>
                </div>
            </li>
            <li>
                <input type="hidden" name="s_brand" id="s_brand" value="0">
                <input type="hidden" name="s_series" id="s_series" value="0">
                <input type="hidden" name="s_simple" id="s_simple" value="0">
                <input type="hidden" name="s_year" id="s_year" value="0">
                <input type="hidden" name="s_mouth" id="s_month" value="0">
                <input type="hidden" name="s_province" id="s_province" value="1">
                <input type="hidden" name="s_city" id="s_city" value="1">
                <input id="cityList" type="hidden" value="">
            </li>
        </ul>
        <div class="submit" id="eval">免费估值</div>
    </div>

    </div>

        <!--banner-->

        <div class="htmleaf-container">

            <div class="banner">
                <ul>
                </ul>
                <ol>
                </ol>
            </div><!--banner end-->
        </div><!--htmleaf-container end-->
        <!--banner end-->

</div><!--pos end-->






<!--头end-->


<!--流程-->
<div class="liu">
    <div class="l_cen">
        <dl>
            <dt><i class="icon iconfont icon-search"></i></dt>
            <dd>1、搜索车型</dd>
            <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </dl>

        <dl>
            <dt><i class="icon iconfont icon-stop"></i></dt>
            <dd>2、获得报价</dd>
            <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </dl>

        <dl>
            <dt><i class="icon iconfont icon-cart"></i></dt>
            <dd>3、提交订单</dd>
            <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </dl>

        <dl class="lase">
            <dt><i class="icon iconfont icon-huanhuobz"></i></dt>
            <dd>4、极速到账</dd>
        </dl>
    </div>
</div>
<!--流程 end-->


<!--交易记录-->
<div class="jiao">

    <div class="j_cen">
          <div class="j_left">
              <div class="j_one">
                  <a href="/sale"  target="_blank" style="display: block">
                      <p class="xian">
                          <span>汽车估价</span>
                      </p>
                      <p class="p1">悟空估价系统、真实可靠精准评估帮助你卖车</p>
                  </a>
              </div>
              <div class="j_two">
                  <a href="/help/3" target="_blank">
                      <p class="h2">
                          <span>悟空收车</span>
                      </p>
                      <p class="p1">在悟空收车卖车需要准备什么？</p>
                   </a>
              </div>
          </div><!--j_left-->

        <div class="j_right">
            <div class="result-top">
                <div class="brands">
                    <span class="sub-title">热门品牌：</span>

                    <ul class="brands-list">
                        <c:forEach items="${hotBrand}" var="item" varStatus="status">
                            <li  <c:if test="${status.index > 13}">style="display: none;"</c:if> >
                                <a href="javascript:selectBrand('${item.brandId}')" title="${item.brand}" class="no_hover">
                                    <img src="${item.largeLogo}" alt="${item.brand}">
                                </a>
                            </li>

                        </c:forEach>
                        <li  style="display: none;">
                            <a href="/sale" title="其他品牌" class="no_hover">
                                <img src="/resources/img/other.svg" alt="其他品牌">
                            </a>
                        </li>

                    </ul>


                    <div class="opt">
                        <span class="more">更多</span>
                        <span class="collapse">收起</span>
                        <span class="after"></span>
                    </div>
                </div>
                <div class="hot-prods" id="series_hot">
                    <span class="sub-title">热门车系：</span>
                    <ul class="hot-prods-list">
                        <c:forEach items="${hotSeries}" var="item">
                            <li><a title="${item.seriesName}" id="series_${item.seriesId}" href="javascript:selectSeriest('${item.seriesId}')" class="no_hover">${item.seriesName}</a></li>
                        </c:forEach>

                    </ul>
                    <div class="opt">
                        <span class="more">更多</span>
                        <span class="collapse">收起</span>
                        <span class="after"></span>
                    </div>
                </div>
                <div id="serises_list">
                    <script id="tmpl-series" type="text/x-dot-template">
                        {{ for(var i=0,len=it.length;i<len; i++) { }}
                        <div class="hot-prods">
                            <span class="sub-title">{{=it[i].gn}}：</span>
                            <ul class="hot-prods-list">
                                {{ for(var j=0,len1=it[i].child.length;j<len1; j++) { }}
                                <li><a title="{{=it[i].child[j].series_name}}" id="seriesh_{{=it[i].child[j].series_id}}"   href="javascript:selectSeries('{{=it[i].child[j].series_id}}')" class="no_hover">{{=it[i].child[j].series_name}}</a></li>
                                {{ } }}
                            </ul>
                        </div>
                        {{ } }}
                    </script>
                </div>
                <style>
                    .car_model_close{
                        position: absolute;
                        /* top: 15px; */
                        height: 32px;
                        width: 32px;
                        /* position: relative; */
                        left: 870px;
                        top: 27px;
                        z-index: 19890509 ;
                        background: #FFF;
                        border-radius: 30px;
                    }
                </style>
                <div id="car_model" style="position: absolute!important;display: none">
                    <img src="/resources/img/close.svg" class="car_model_close" onclick="closeCarModel()">
                    <div class="bg0 lr_158_30 select model" style="width:420px; height:458px; left:463px;" ></div>
                    <div class="ucarselecttype lr_158_30 select model" style="left:467px;width:410px;height:447px;top: 45px;" >
                        <div class="ucarselecttype_pinpai last" style="width:400px;height:450px;">
                            <div class="ucarselecttype_pinpaitop"  style="width:400px;">请选择车型</div>
                            <div class="ucarselecttype_pinpaibottom" style="width:400px;">
                                <div class="ucarselecttype_pinpaibottom_ul" id="car_model_list" >


                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>

<!--交易记录 end-->


<!--关于我们-->
<div class="jiyi">
    <div class="jiao_cen">
         <h2>最近成交记录</h2>


        <div id="owl-example" class="owl-carousel">
            <script id="list-car-tmpl" type="text/x-dot-template">
                {{ for(var i=0,len=it.length;i<len; i++) { }}
                <a href="/sale/{{=it[i].paramId}}" target="_blank" style="color:#262930" title="{{=it[i].title}}">
                    <div class="item darkCyan">
                        <img src="{{=it[i].img}}">
                        <h3>{{=it[i].title}}</h3>
                        <p>{{=it[i].param}}</p>
                        <h4>{{=it[i].price}}</h4>
                    </div>
                </a>
                {{ } }}
            </script>
        </div>

    </div>
</div>

<!--关于我们 end-->


<!--预约服务-->
<div class="yuye">
    <div class="yue_cen">
        <h2>预约服务</h2>

        <div class="stores-info">
            <div class="col-left">
                <p>你身边的免费服务站</p>
                <a href=" ">
                    <style>
                        .cc{
                            z-index: 1989;
                            background: rgba(0, 0, 0, 0.49);
                            color: #FFF;
                            position: absolute;
                            bottom: 5px;
                            height: 45px;
                            width: 379px;
                           padding: 5px 20px;
                            display: none;
                        }
                        div#serises_list {
                            position: relative !important;
                        }
                    </style>
                    <img class="lazy-load img_loaded" id = "4simg" src="/resources/img/1_03.jpg " alt="4s店图片" style="display: block;" width="410" height="318">
                    <div class="cc" >
                        <span id="shopAddress" ></span>
                    </div>
                </a>
            </div>
            <div class="col-right">
                <div class="store-dist-list">
                    <c:forEach items="${shopList}" var="item" begin="1" end="1">
                    <span class="allstores active">全部门店(${item.totalNumber})</span>
                    </c:forEach>
                    <div id="alldistrict" class="swiper-container">
                        <div class="swiper-wrapper" style="width: 120px; height: 516px; transform: translate3d(0px, 0px, 0px); transition-duration: 0.2s;">
                            <div class="swiper-slide swiper-slide-visible swiper-slide-active district" style="width: 120px; height: 258px;">
                                <c:forEach items="${shopList}" var="item">
                                    <div class="region " data-id="${item.id}">${item.district}(${item.count})</div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>

                    <span class="more-store-dist next"><i></i></span>
                </div>

                <div id="r-storelist-all" class="storelist current" data-page="1" data-pagecount="7">
                    <ul class="shop">
                        <c:forEach items="${shopList}" var="item">
                            <c:forEach items="${item.shop}" var="j">
                                <li data-shop-id="${j.id}"
                                    data-location="${j.location}"
                                    data-address="${j.address}"
                                    data-img="${j.img}"
                                    data-title="${j.name}" class="page-1 show parent${j.districtId}">
                                    <div>
                                        <a href="javascript:void(0)" data-fancybox-type="iframe"  class="shop-addr-pop" title="${j.name}">
                                            <p class="store-name">
                                            ${j.name}
                                            </p>
                                        </a>
                                    </div>
                                </li>
                            </c:forEach>
                        </c:forEach>
                    </ul>
                </div>
        </div>
    </div>

        <div class="free-service">
            <span class="tips-title">上门服务</span>

            <span class="tips">足不出户</span>
            <span class="tips">即可高价卖车</span>
            <span class="tips">北京6环内地区的用户</span>
            <span class="tips">可享受质检小哥优质上门服务</span>
            <span class="tips">您附近的地铁口现场验车</span>


            <ul class="pros">
                <li>

                    <span>高效</span>
                </li>
                <li>

                    <span>专业</span>
                </li>
                <li>

                    <span>安心</span>
                </li>
            </ul>
            <p class="p3"><img src="/resources/img/c_4.png "></p>
        </div>
</div>
    </div>
<!--预约服务-->
    <!--用户评价-->
    <div class="users">
        <div class="yue_cen">
            <h2>用户评论</h2>
            <div id="pic_list_2" class="scroll_horizontal">
                <div class="box">

                    <ul class="list" id="ul_list">
                        <script id="list-tmpl" type="text/x-dot-template">

                            {{ for(var i=0,len=it.length;i<len; i++) { }}
                            <li data-id="{{=it[i].id}}">
                                <div class="l_box">
                                    <p class="p_t"><img src="/resources/img/t_07.jpg" style="margin-right: 10px;">{{=it[i].phone}}</p>
                                    <p class="pl">{{=it[i].content}}</p>
                                    <p class="bottom">{{=it[i].time}} {{=it[i].method}} <a style="color: #0d0df9" href="/sale/model/{{=it[i].modelId}}"  target="_blank">{{=it[i].car}}</a></p>
                                </div>
                            </li>
                            {{ } }}

                        </script>

                    </ul>

                    <%--<ul class="list"  id="ul_list">--%>

                    <%--</ul>--%>
                    <ul class="piclist swaplist"></ul>

                </div>

                <div class="og_prev"></div>

                <div class="og_next"></div>

            </div>

        </div>
    </div>

<!--文章-->
<div class="wz_box">
    <div class="wz">
        <p>精选文章</p>
        <dl>
            <dt>
                <a href="/news/1000"  target="_blank"><img src="../resources/img/wz.jpg"></a>
            </dt>
        </dl>

        <dl class="dl2">
            <a href="/news/1001"  target="_blank">
                <dt>
                   <img src="http://img.maizhongcar.com/wz/wz2.jpg">
                </dt>
                <dd class="dd1">这是一篇硬文</dd>
                <dd class="dd2">因为悟空收车的优惠太多啦</dd>
                <dd>2017  悟空收车优惠活动第二季 ；</br>第一次就选悟空收车。</dd>
                <dd class="dd3">查看更多>></dd>

            </a>
        </dl>
    </div>
</div>
<!--文章 end-->

<%@include file="footer.jsp"%>
<script src="/resources/js/doT.min.js"></script>




<script src="/resources/js/index.js"></script>
<script>
    $(document).ready(function() {

        var phone = $.cookie('phone');
        var token = $.cookie('token');
        if(phone&&token){
            $.getJSON('/loginByToken/'+phone+'/'+token,function (d) {
                if(d.status==200){
                    $("#login").hide();

                    var pre = phone.substring(0,3),pbc = phone.substring(8,11);
                    $('#user').html(pre+'****'+pbc).show();
                    $('#exit').show();
                    //
                    $('#user').attr('href','/per/or')
                    $("#user_li").show();
                }else{
                    $.cookie("phone",null,{path:"/"});
                    $.cookie("token",null,{path:"/"});
                }
            })
        }


    })
    //数组排序
    var shuffle = function(v){
        for(var j, x, i = v.length; i; j = parseInt(Math.random() * i), x = v[--i], v[i] = v[j], v[j] = x);
        return v;
    };
    $(function(){
        $.getJSON('/resources/data/comment.json',function(d){
            var evalText = doT.template($("#list-tmpl").text());

            $.each(d,function(i,j){
                j.time = datemy(i);
            })
            d = shuffle(d)
            $("#ul_list").html(evalText(d));
            $("#pic_list_2").cxScroll({direction:"right",step:3});
            //$("#pic_list_2").owlCarousel();
        });
        $.getJSON('/resources/data/hotcar.json',function(d){
            var carevalText = doT.template($("#list-car-tmpl").text());
            d = shuffle(d)
            $("#owl-example").html(carevalText(d));
            $("#owl-example").owlCarousel();
        })

    })

    function exit(){
        $.cookie("phone",null,{path:"/"});
        $.cookie("token",null,{path:"/"});
        window.location.reload()
    }

    $(".district .region").click(function(){
        $(this).addClass('active').siblings().removeClass("active");
        var id = $(this).data('id');
        if(id==0){
            $(".shop li").show();
        }else{
            $(".shop li").hide();
            $(".parent"+id).show();
        }
    });
    $(".shop li").click(function(){
        $(this).addClass('active').siblings().removeClass("active");
        var img = $(this).data("img");
        var address = $(this).data("address");
        $('#shopAddress').html(address).parent().show();
        document.getElementById('4simg').src = img;
    });
    var evalTextSerise = doT.template($("#tmpl-series").text());
    var selectBrand = function(brandId){

        $.getJSON('/series/series_brand/'+brandId,function(r){

            var SeriesArry = [],g = '',arry = [],item = {}
            $.each(r.data,function (i, j) {
                if(g ==''){
                    g = j.series_group_name
                    item.gn = g;
                    arry.push(j);

                }else if(g!=j.series_group_name){
                    item.child = arry;
                    SeriesArry.push(item);
                    item = {};
                    arry = [];

                    g = j.series_group_name
                    item.gn = g;
                    arry.push(j);

                }else{
                    arry.push(j);
                }

            })
            item.child = arry;
            SeriesArry.push(item);
            if(SeriesArry.length){

                $("#serises_list").html();
                $("#serises_list").html(evalTextSerise(SeriesArry));
                $("#series_hot").hide();
            }else{
                $("#series_hot").show();
            }


        })



    }


    var selectSeries =function(seriesId){


        var id = '#seriesh_'+seriesId;

        var X = $(id).offset().top-20;
        var Y = $(id).offset().left-400;
        $(id).css({'color':'#F60'})

        $("#car_model_list").empty();
        $("#car_model_list").html('<div style="margin:0 auto;margin-top:50%;text-align: center;"><p style="padding-left: 0px;height:32px;line-height: 32px;">'+
                '<img src="/resources/img/meta_loading.gif"></p></div>');


        $("#car_model").css({"top":X,'left':Y}).show();



        $.getJSON("/model/model_series/" + seriesId, function(d) {
            carmodelHtml(d.data)
        })
    }
    var selectSeriest =function(seriesId){


        var id = '#series_'+seriesId;

        var X = $(id).offset().top-20;
        var Y = $(id).offset().left-400;
        $(id).css({'color':'#F60'})

        $("#car_model_list").empty();
        $("#car_model_list").html('<div style="margin:0 auto;margin-top:50%;text-align: center;"><p style="padding-left: 0px;height:32px;line-height: 32px;">'+
                '<img src="/resources/img/meta_loading.gif"></p></div>');


        $("#car_model").css({"top":X,'left':Y}).show();



        $.getJSON("/model/model_series/" + seriesId, function(d) {
            carmodelHtml(d.data)
        })
    }
    function carmodelHtml(a) {

        var b = $("#car_model_list"),g='',e='',c='<p onclick="carModeSelect(\'%id\')" class="pinpailist list_3 mylist%css simple_%id" id="%id" rel="%date" data-price="%price" data-name="%modelName" data-min="%min" data-max="%max">%name</p>',
        f = new RegExp("%id", "g")
        if (a.length > 0)
            for (var d = 99999, h = 0; h < a.length; h++) {
            a[h].model_year != d && (d = a[h].model_year, g += '<p class="pinpailist" style="background:#e3e3e3;text-align:center">' + d + "款</p>");
            var i = e == a[h].model_id ? "layerbg2" : "";
            g += c.replace("%css", " " + i).replace(f, a[h].model_id).replace("%name", "<span>" + a[h].model_name + "</span><span style='float:right;margin-right:10px;'>" + Number(a[h].model_price).toFixed(2) + "万</span>").replace("%modelName", a[h].model_name).replace("%date", d).replace("%min", a[h].min_reg_year).replace("%max", a[h].max_reg_year).replace("%price", a[h].model_price)
        } else g += '<p class="pinpailist" style="background:#e3e3e3;text-align:center">暂无车型</p>';

        b.empty(), b.append(g)
    }

    var closeCarModel = function(){
        $("#car_model").hide();

        $(".hot-prods-list li a").css({'color':""})
    }

    var carModeSelect = function(modelId){
        window.open('/sale/model/'+modelId);
    }
</script>


<script language="javascript">
    for(i in document.images)document.images[i].ondragstart=imgdragstart;
</script>

</body>
</html>