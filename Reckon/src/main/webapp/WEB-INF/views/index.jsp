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
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />

    <link rel="stylesheet" type="text/css" href="/resources/css/owl.carousel.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/owl.theme.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/owl.carousel.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cxscroll.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js"></script>
    <script src="/resources/js/js.js"></script>
</head>
<body>
<!--头部开始-->

    <div class="top e_top">
        <div class="t_cen">
            <a href="#"><img src="../resources/img/logo.png"></a>
            <span class="tell">010-8025-8108</span>
            <span class="t_right">
                <a href="/sale" class="one">我要卖车</a>
                <a href="/login" class="one" id="login">登录</a>
                <a href="/per/or" class="two" id="user" style="display:none">188****8888</a>
                <a href="javascript:void(0)" class="two" id="exit" style="display:none" onclick="exit();">退出</a>
                <a href="javascript:vold(0)" class="two">APP下载</a></span>
        </div>
    </div><!--top end-->


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
                  <a href="#">
                      <p class="xian">
                          <span>汽车估价</span>
                      </p>
                      <p class="p1">悟空估价系统、真实可靠精准评估帮助你卖车</p>
                  </a>
              </div>
              <div class="j_two">
                  <a href="#">
                      <p class="h2">
                          <span>悟空收车</span>
                      </p>
                      <p class="p1">快速打款、售后保障、检测专业</p>
                   </a>
              </div>
          </div><!--j_left-->

        <div class="j_right">
            <div class="result-top">
                <div class="brands">
                    <span class="sub-title">品牌：</span>

                    <ul class="brands-list">
                        <li class="show" data-val="52">
                            <a href=" " title="宝马汽车" class="no_hover">
                                <img src="../resources/img/b_47.png" alt="宝马汽车">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="7">
                            <a href="" title="" class="no_hover">
                                <img src="../resources/img/b_38.png" alt="宝马汽车">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="184">
                            <a href="" title="" class="no_hover">
                                <img src="../resources/img/b_55.png" alt="宝马汽车">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="9">
                            <a href="" title="" class="no_hover">
                                <img src="../resources/img/b_73.png" alt="宝马汽车">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="24">
                            <a href="" title="" class="no_hover">
                                <img src="../resources/img/b_98.png" alt="宝马汽车">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="356">
                            <a href="" title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439633048183361102333564.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="4">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143935099013348928577242.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="16">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439351013572672120090359.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="278">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143940158420666395938663.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="365">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439633059120711413239127.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="17">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439351015133801068873362.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="19">
                            <a href=" " title=" " class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439351019821551462257230.png" alt=" ">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="1">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439318803992762058406761.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="show" data-val="3">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439350987009491215174584.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="18">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143935101825919716660345.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="342">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143943246721587975055736.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="25">
                            <a href=" " title=" " class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439360782384101897504348.png" alt=" ">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="357">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143963304974544347668102.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="8">
                            <a href=" " title=" " class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143935099638530593559841.png" alt=" ">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="21">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439360776134271319378279.png" alt=" ">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="14">
                            <a href=" " title=" " class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439351008884231715451689.png" alt=" ">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="103">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143937277621026897627965.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="20">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143935102138428823174381.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="15">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143935101044645782737074.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="12">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439351005758501233307607.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="10">
                            <a href=" " title=" " class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439351001072232096640321.png" alt=" ">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="11">
                            <a href=" " title=" " class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143935100419662630904409.png" alt=" ">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="358">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143963305130796644997531.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="51">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/636143936078707120145452801.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="391">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439647488900921337887683.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="458">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/63614397347753943911431533.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="460">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361723942445574431123020530.jpg" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="463">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6362044783883086241324530320.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="478">
                            <a href=" " title="" class="no_hover">
                                <img src="https://sr.aihuishou.com/cms/image/6362639815162794002102382406.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                        <li class="hide" data-val="266">
                            <a href=" " title="" class="no_hover">
                                <img src="http://oss-cn-hangzhou.aliyuncs.com/aihuishou-internal/cms/image/6361439401576394972070275816.png" alt="">
                            </a>
                            <div id="hot-prods"></div>
                        </li>
                    </ul>


                    <div class="opt">
                        <span class="more">更多</span>
                        <span class="collapse">收起</span>
                        <span class="after"></span>
                    </div>
                </div>
                <div class="hot-prods">
                    <span class="sub-title">热门：</span>
                    <ul class="hot-prods-list">
                        <li><a title=" " href=" " class="no_hover">OPPO R9s</a></li>
                        <li><a title="  " href=" " class="no_hover">苹果 iPhone 7</a></li>
                        <li><a title="   " href=" " class="no_hover">苹果 iPhone 7 Plus</a></li>
                        <li><a title="" href=" " class="no_hover">红米Pro</a></li>
                        <li><a title=" " href=" " class="no_hover">魅族 MX6</a></li>
                        <li><a title="" href=" " class="no_hover">红米3X</a></li>
                        <li><a title="" href=" " class="no_hover">红米手机3S</a></li>
                        <li><a title="" href=" " class="no_hover">小米Max</a></li>
                        <li><a title="  " href=" " class="no_hover">三星 GALAXY C5</a></li>
                        <li><a title="  " href=" " class="no_hover">魅族 魅蓝 3S</a></li>
                        <li><a title="  " href=" " class="no_hover">酷派 ivvi i3</a></li>
                        <li><a title=" " href=" " class="no_hover">魅族 MX5e</a></li>
                        <li><a title="   " href=" " class="no_hover">魅族 魅蓝 Note 3</a></li>
                        <li><a title="  " href=" " class="no_hover">魅族 魅蓝 3</a></li>
                        <li><a title="  " href=" " class="no_hover">华为 P9 Plus</a></li>
                        <li><a title=" " href=" " class="no_hover">华为 P9</a></li>
                        <li><a title=" " href=" " class="no_hover">魅族 PRO6</a></li>
                        <li><a title="  " href=" " class="no_hover">苹果 iPhone SE</a></li>
                        <li><a title=" " href=" " class="no_hover">OPPO R9 Plus</a></li>
                        <li><a title="" href=" " class="no_hover">小米手机4S</a></li>
                        <li><a title=" " href=" " class="no_hover">小米手机5 </a></li>
                        <li><a title="  " href=" " class="no_hover">三星 GALAXY S7 edge 蝙蝠侠版</a></li>
                        <li><a title="  " href=" " class="no_hover">三星 GALAXY S7</a></li>
                        <li><a title="   " href=" " class="no_hover">三星 GALAXY S7 edge</a></li>
                        <li><a title="" href=" " class="no_hover">红米手机3</a></li>
                        <li><a title="  " href=" " class="no_hover">华硕 ZenFone 6</a></li>
                        <li><a title=" " href=" " class="no_hover">三星 W2016</a></li>
                        <li><a title=" " href=" " class="no_hover">联想 乐檬3</a></li>
                        <li><a title="  " href=" " class="no_hover">华硕鹰眼 ZenFone Zoom</a></li>
                        <li><a title="" href=" " class="no_hover">vivo X5Max+</a></li>
                    </ul>
                    <div class="opt">
                        <span class="more">更多</span>
                        <span class="collapse">收起</span>
                        <span class="after"></span>
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

            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动2010年出厂2010年出厂</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>

            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>
            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>

            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>

            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>

            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>
            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>

            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>

            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>

            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>

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
                <a href=" ">

                    <img class="lazy-load img_loaded" src="../resources/img/1_03.jpg " alt="4s店图片" style="display: block;">
                </a>
            </div>
            <div class="col-right">
                <div class="store-dist-list">
                    <span class="allstores active">全部门店(17)</span>
                    <div id="alldistrict" class="swiper-container">
                        <div class="swiper-wrapper" style="width: 120px; height: 516px; transform: translate3d(0px, 0px, 0px); transition-duration: 0.2s;">
                            <div class="swiper-slide swiper-slide-visible swiper-slide-active" style="width: 120px; height: 258px;">

                                <div class="region " data-index="0">东城区(3)</div>
                                <div class="region " data-index="1">西城区(1)</div>
                                <div class="region " data-index="2">朝阳区(9)</div>
                                <div class="region " data-index="3">丰台区(3)</div>
                                <div class="region " data-index="4">石景山区(1)</div>
                                <div class="region " data-index="5">海淀区(9)</div>
                                <div class="region " data-index="6">顺义区(1)</div>
                                <div class="region " data-index="7">昌平区(3)</div>
                            </div>
                            <div class="swiper-slide" style="width: 120px; height: 258px;">
                                <div class="region" data-index="8">大兴区(4)</div>
                            </div>
                        </div>
                    </div>

                    <span class="more-store-dist next"><i></i></span>
                </div>

                <div id="r-storelist-all" class="storelist current" data-page="1" data-pagecount="7">
                    <ul>
                        <li class="page-1 show">
                            <div>
                                <a href=" " data-fancybox-type="iframe" class="shop-addr-pop" title="北京东方广场店门店回收">
                                    <p class="store-name">北京东方广场店 </p>

                                </a>
                            </div>
                        </li>
                        <li class="page-1 show">
                            <div>
                                <a href=" " data-fancybox-type="iframe" class="shop-addr-pop" title="北京国瑞店门店回收">
                                    <p class="store-name">北京国瑞店 </p>

                                </a>
                            </div>
                        </li>
                        <li class="page-1 show">
                            <div>
                                <a href=" " data-fancybox-type="iframe" class="shop-addr-pop" title="北京东方银座店门店回收">
                                    <p class="store-name">北京东方银座店 </p>

                                </a>
                            </div>
                        </li>
                        <li class="page-1 show">
                            <div>
                                <a href=" " data-fancybox-type="iframe" class="shop-addr-pop" title="北京新华百货店门店回收">
                                    <p class="store-name">北京新华百货店 </p>

                                </a>
                            </div>
                        </li>
                        <li class="page-1 show">
                            <div>
                                <a href=" " data-fancybox-type="iframe" class="shop-addr-pop" title="北京朝阳大悦城店门店回收">
                                    <p class="store-name">北京朝阳大悦城店 </p>

                                </a>
                            </div>
                        </li>
                        <li class="page-2">
                            <div>
                                <a href=" " data-fancybox-type="iframe" class="shop-addr-pop" title="北京太阳宫凯德店门店回收">
                                    <p class="store-name">北京太阳宫凯德店 </p>

                                </a>
                            </div>
                        </li>
                        <li class="page-2">
                            <div>
                                <a href=" " data-fancybox-type="iframe" class="shop-addr-pop" title="北京金地店门店回收">
                                    <p class="store-name">北京金地店 </p>

                                </a>
                            </div>
                        </li>
                        <li class="page-2">
                            <div>
                                <a href=" " data-fancybox-type="iframe" class="shop-addr-pop" title="北京龙湖广场店门店回收">
                                    <p class="store-name">北京龙湖广场店 </p>

                                </a>
                            </div>
                        </li>

                        <li class="page-2">
                            <div>
                                <a href=" " data-fancybox-type="iframe" class="shop-addr-pop" title="北京金地店门店回收">
                                    <p class="store-name">北京金地店 </p>

                                </a>
                            </div>
                        </li>
                        <li class="page-2">
                            <div>
                                <a href=" " data-fancybox-type="iframe" class="shop-addr-pop" title="北京龙湖广场店门店回收">
                                    <p class="store-name">北京龙湖广场店 </p>

                                </a>
                            </div>
                        </li>

                        <li class="page-2">
                            <div>
                                <a href=" " class="shop-addr-pop" title="北京金地店门店回收">
                                    <p class="store-name">北京金地店 </p>

                                </a>
                            </div>
                        </li>
                        <li class="page-2">
                            <div>
                                <a href=" " class="shop-addr-pop" title="北京龙湖广场店门店回收">
                                    <p class="store-name">北京龙湖广场店 </p>

                                </a>
                            </div>
                        </li>

                    </ul>
                </div>
        </div>
    </div>

        <div class="free-service">
            <span class="tips-title">上门服务</span>

            <span class="tips">所有在本网站卖车的用户</span>
            <span class="tips">可享受质检小哥优质上门服务</span>


            <ul class="pros">
                <li>

                    <span>专业</span>
                </li>
                <li>

                    <span>放心</span>
                </li>
                <li>

                    <span>高效</span>
                </li>
            </ul>
            <p class="p3"><img src="../resources/img/c_4.png "></p>
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

                    <ul class="list">
                        <li>
                            <div class="l_box">
                                <p class="p_t"><img src="../resources/img/t_07.jpg">136****4839</p>
                                <p class="pl">估值的价格准确，服务较好，评估师态度良好</p>
                                <p class="bottom">05月03号在北京龙湖广场店收一辆奥迪A4</p>
                            </div>
                        </li>
                        <li>
                            <div class="l_box">
                                <p class="p_t"><img src="../resources/img/t_07.jpg">136****4839</p>
                                <p class="pl">估值的价格准确，服务较好，评估师态度良好</p>
                                <p class="bottom">05月03号在北京龙湖广场店收一辆奥迪A4</p>
                            </div>
                        </li>
                        <li>
                            <div class="l_box">
                                <p class="p_t"><img src="../resources/img/t_07.jpg">136****4839</p>
                                <p class="pl">估值的价格准确，服务较好，评估师态度良好</p>
                                <p class="bottom">05月03号在北京龙湖广场店收一辆奥迪A4</p>
                            </div>
                        </li>
                        <li>
                            <div class="l_box">
                                <p class="p_t"><img src="../resources/img/t_07.jpg">136****4839</p>
                                <p class="pl">估值的价格准确，服务较好，评估师态度良好</p>
                                <p class="bottom">05月03号在北京龙湖广场店收一辆奥迪A4</p>
                            </div>
                        </li>
                        <li>
                            <div class="l_box">
                                <p class="p_t"><img src="../resources/img/t_07.jpg">136****4839</p>
                                <p class="pl">估值的价格准确，服务较好，评估师态度良好</p>
                                <p class="bottom">05月03号在北京龙湖广场店收一辆奥迪A4</p>
                            </div>
                        </li>
                        <li>
                            <div class="l_box">
                                <p class="p_t"><img src="../resources/img/t_07.jpg">136****4839</p>
                                <p class="pl">估值的价格准确，服务较好，评估师态度良好</p>
                                <p class="bottom">05月03号在北京龙湖广场店收一辆奥迪A4</p>
                            </div>
                        </li>
                        <li>
                            <div class="l_box">
                                <p class="p_t"><img src="../resources/img/t_07.jpg">136****4839</p>
                                <p class="pl">估值的价格准确，服务较好，评估师态度良好</p>
                                <p class="bottom">05月03号在北京龙湖广场店收一辆奥迪A4</p>
                            </div>
                        </li>
                        <li>
                            <div class="l_box">
                                <p class="p_t"><img src="../resources/img/t_07.jpg">136****4839</p>
                                <p class="pl">估值的价格准确，服务较好，评估师态度良好</p>
                                <p class="bottom">05月03号在北京龙湖广场店收一辆奥迪A4</p>
                            </div>
                        </li>
                        <li>
                            <div class="l_box">
                                <p class="p_t"><img src="../resources/img/t_07.jpg">136****4839</p>
                                <p class="pl">估值的价格准确，服务较好，评估师态度良好</p>
                                <p class="bottom">05月03号在北京龙湖广场店收一辆奥迪A4</p>
                            </div>
                        </li>
                        <li>
                            <div class="l_box">
                                <p class="p_t"><img src="../resources/img/t_07.jpg">136****4839</p>
                                <p class="pl">估值的价格准确，服务较好，评估师态度良好</p>
                                <p class="bottom">05月03号在北京龙湖广场店收一辆奥迪A4</p>
                            </div>
                        </li>

                    </ul>

                    <ul class="piclist swaplist"></ul>

                </div>

                <div class="og_prev"></div>

                <div class="og_next"></div>

            </div>

        </div>
    </div>
    <!--用户评价 end-->

     <!--合作伙伴-->
        <%--<div class="hezuo">--%>
             <%--<div class="hz_cen">--%>
                 <%--<h2>合作伙伴</h2>--%>
                 <%--<table>--%>
                     <%--<tbody>--%>
                     <%--<tr>--%>

                         <%--<td> <img src="../resources/img/b_38.png"></td>--%>
                         <%--<td><img src="../resources/img/b_47.png"></td>--%>
                         <%--<td><img src="../resources/img/b_55.png"></td>--%>
                         <%--<td><img src="../resources/img/b_73.png"></td>--%>
                         <%--<td><img src="../resources/img/b_98.png"></td>--%>
                     <%--</tr>--%>
                     <%--<tr class="bottom-border">--%>
                         <%--<td><img src="../resources/img/b_47.png"></td>--%>
                         <%--<td><img src="../resources/img/b_55.png"></td>--%>
                         <%--<td> <img src="../resources/img/b_38.png"></td>--%>
                         <%--<td><img src="../resources/img/b_73.png"></td>--%>
                         <%--<td><img src="../resources/img/b_98.png"></td>--%>
                     <%--</tr>--%>
                     <%--<tr>--%>
                         <%--<td><img src="../resources/img/b_98.png"></td>--%>
                         <%--<td><img src="../resources/img/b_73.png"></td>--%>
                         <%--<td><img src="../resources/img/b_47.png"></td>--%>
                         <%--<td><img src="../resources/img/b_55.png"></td>--%>

                         <%--<td> <img src="../resources/img/b_38.png"></td>--%>

                     <%--</tr>--%>

                     <%--</tbody></table>--%>
             <%--</div>--%>
        <%--</div>--%>
        <!--合作伙伴 end-->

<!--优势-->
  <div class="you">
      <div class="you_cen">
          <dl>
              <dt><i class="icon iconfont icon-success"></i></dt>
              <dd class="dd1">成交快</dd>
              <dd>线上回收， 成交快</dd>
          </dl>
          <dl>
              <dt><i class="icon iconfont icon-renminbi1688"></i></dt>
              <dd class="dd1">价格高</dd>
              <dd>精准估值 卖的高</dd>
          </dl>
          <dl>
              <dt><i class="icon iconfont icon-iconfontfuwushichang"></i></dt>
              <dd class="dd1">超省心</dd>
              <dd>一对一全程服务</dd>
          </dl>
          <dl>
              <dt><i class="icon iconfont icon-maijiabz"></i></dt>
              <dd class="dd1">有保障</dd>
              <dd>安全无忧/全程保障</dd>
          </dl>
      </div>
  </div>
<!--优势 end-->
<div class="clear"></div>
<div class="footer">
    <div class="foot_cen">
        <div class="n_f_m_c">
            <div class="ul1">
                <a href="/about.html">交易方式</a>
                <a href="/help.html">质检说明</a>
                <a href="/joinus.html">帮助中心</a>

                <a href="/joinus.html">加盟合作</a>
                <a href="/feedback.html">关于我们</a>
                <a href="/feedback.html">联系我们</a>
            </div>
            <div class="ul">
                <ul>
                    <li><a href="#">门店交易</a></li>
                    <li><a href="#">上门交易</a></li>
                </ul>
                <ul>
                    <li><a href="#">检测名词解释</a></li>
                    <li><a href="#">专业检测项目</a></li>

                </ul>
                <ul>
                    <li><a href="#">常见问题</a></li>
                    <li><a href="#">服务条款</a></li>

                </ul>

                <ul>
                    <li><a href="#">公司简介</a></li>
                    <li><a href="#">招贤纳士</a></li>

                </ul>
                <ul>
                    <li><a href="#"> 销售商加盟</a></li>

                </ul>
                <ul class="last">
                    <li><a href="#">系电话：010-82967855/18515157855</a></li>
                    <li><a href="#">  公司地址：北京市大兴区西红门嘉悦广场
                        5号楼1002室或西红门公交车站对面</a></li>
                </ul>

        </div><!--ul end-->
    </div><!--f_n-->
        <div class="f_n_r">
            <div class="f_one">
               <img src="../resources/img/m_11.jpg">
               <p>APP下载</p>
            </div>
            <div class="f_one">
                <img src="../resources/img/m_13.jpg">
                <p>微信公众号</p>
            </div>
        </div>


        <div class="clear"></div>
        <div class="pp">
            <p>Copyright © 2017-2020 迈众 All Rights Reserved 版权所有 北京迈众汽车信息服务有限公司</p>
            <p>京ICP备17017795号  &nbsp;&nbsp;&nbsp; 联系电话：010-8025-8108 &nbsp;&nbsp;&nbsp;
                <script type="text/javascript">
                    var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
                    document.write(unescape("%3Cspan id='cnzz_stat_icon_1261672623'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1261672623' type='text/javascript'%3E%3C/script%3E"));
                </script>
            </p>
        </div>

    </div>
</div>


<script>

    $(document).ready(function($) {
        $("#owl-example").owlCarousel();
    });


    $("body").data("page", "frontpage");

</script>

<script>


    $("#pic_list_2").cxScroll({direction:"left",step:3});

</script>


<script src="/resources/js/index.js"></script>
<script>
    $(document).ready(function() {

        var phone = $.cookie('phone');
        var token = $.cookie('token');
        if(phone&&token){
            $.getJSON('/loginByToken/'+phone+'/'+token,function (d) {
                console.log(d)
                if(d.status==200){
                    $("#login").hide();

                    $('#user').html(phone).show();
                    $('#exit').show();

                }else{
                    $.cookie("phone",null,{path:"/"});
                    $.cookie("token",null,{path:"/"});
                }
            })
        }
    })
    function exit(){
        $.cookie("phone",null,{path:"/"});
        $.cookie("token",null,{path:"/"});
        window.location.reload()
    }
</script>




</body>
</html>