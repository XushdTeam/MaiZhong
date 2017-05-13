<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/18
  Time: 16:51
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
    <title>悟空收车</title>
    <meta name="keywords" content="悟空收车，悟空，二手车，估值，收购"/>
    <meta name="description" content="悟空收车专业的二手车估值收购平台，验车快，当天到账，售后跟踪"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi2.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>
    <script src="https://cdn.bootcss.com/layer/3.0.1/layer.js"></script>
</head>
<body>
<div class="top e_top">
    <div class="t_cen">
        <a href="/" class="logo"><img src="/resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="/" >首页</a></li>
            <li><a href="/sale" class="hover">我要卖车</a></li>
            <li><a href="/join">销售商加盟</a></li>
            <li><a href="/app">APP下载</a></li>
           <li><a href="/help">帮助中心</a></li>
            <li style="display: none;" id="user_li"><a href="/per/or"  >个人中心</a></li>
        </ul>
        <ul class="lon" style="margin-top: 0px;">
            <li >
                <i class="iconfont icon ">&#xe6a3;</i>
                <a href="/login"  id="user">登录</a>
            </li>
            <li>
                <a href="javascript:void(0)" class="two" id="exit" style="display:none" onclick="exit();">退出</a>
            </li>
        </ul>
    </div>
</div><!--top end-->




<div class="jingzhun">
    <%--<div class="jing">--%>
        <%--<label>选择车型:</label>--%>
        <%--<li class="mb13" style="z-index:100">--%>
            <%--<div class="select_box" id="select1">--%>
                <%--<div id="valnone">请 选 择 车 型</div>--%>
            <%--</div>--%>
            <%--<div class="bg0 lr_158_30 select model" id="select1_1" style="display: none"></div>--%>
            <%--<div class="ucarselecttype lr_158_30 select model" id="select1_2" style="width: 227px; height: 450px; display: none;">--%>
                <%--<div class="ucarselecttype_pinpai " style="width:227px;height:450px">--%>
                    <%--<div class="ucarselecttype_pinpaitop" id="xzpp" style="width:222px;">请选择品牌</div>--%>
                    <%--<div class="left_list letters">--%>
                        <%--<a href="javascript:void(0)" id="letters_0" class="pinpai_num" rel="4">A</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_1" class="pinpai_num" rel="26">B</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_2" class="pinpai_num" rel="32">C</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_3" class="pinpai_num" rel="45">D</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_4" class="pinpai_num" rel="54">F</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_5" class="pinpai_num" rel="60">G</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_6" class="pinpai_num" rel="77">H</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_7" class="pinpai_num" rel="91">J</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_8" class="pinpai_num" rel="99">K</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_9" class="pinpai_num" rel="113">L</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_10" class="pinpai_num" rel="122">M</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_11" class="pinpai_num" rel="124">N</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_12" class="pinpai_num" rel="128">O</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_13" class="pinpai_num" rel="133">Q</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_14" class="pinpai_num" rel="137">R</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_15" class="pinpai_num" rel="150">S</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_16" class="pinpai_num" rel="154">T</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_17" class="pinpai_num" rel="160">W</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_18" class="pinpai_num" rel="169">X</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_19" class="pinpai_num" rel="177">Y</a>--%>
                        <%--<a href="javascript:void(0)" id="letters_20" class="pinpai_num" rel="185">Z</a>                                            </div>--%>
                    <%--<div class="ucarselecttype_pinpaibottom brandgun" style="width:180px;">--%>
                        <%--<div class="ucarselecttype_pinpaibottom_ul brand">--%>
                            <%--<c:forEach items="${brandList}" var="i">--%>
                                <%--<p id="${i.key}" class="pinpailist" style="background:#e3e3e3;text-align:center">${i.key}</p>--%>
                                <%--<c:forEach items="${i.object}" var="j">--%>
                                    <%--<p class="pinpailist list_1" id="${j.key}" rel="A">${j.value}</p>--%>
                                <%--</c:forEach>--%>
                            <%--</c:forEach>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="bg0 lr_158_30 select model" style="width: 210px;height: 458px;left: 252px;display: none;" id="select2_1"></div>--%>
            <%--<div class="ucarselecttype lr_158_30 select model" style="left:260px;width:200px;height:450px;display: none;" id="select2_2">--%>
                <%--<div class="ucarselecttype_pinpai" style="width:190px; height:450px;">--%>
                    <%--<div class="ucarselecttype_pinpaitop" id="xzcx" style="width:190px;">--%>
                        <%--请选择车系--%>
                    <%--</div>--%>
                    <%--<div class="ucarselecttype_pinpaibottom" style="width:190px;">--%>
                        <%--<div class="ucarselecttype_pinpaibottom_ul series"></div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="bg0 lr_158_30 select model" style="width:420px; height:458px; left:463px;display: none;" id="select3_1"></div>--%>
            <%--<div class="ucarselecttype lr_158_30 select model" style="left:472px;width:411px;height:450px;display: none;" id="select3_2">--%>
                <%--<div class="ucarselecttype_pinpai last" style="width:400px;height:450px;">--%>
                    <%--<div class="ucarselecttype_pinpaitop" id="xzcxing" style="width:400px;">请选择车型</div>--%>
                    <%--<div class="ucarselecttype_pinpaibottom" style="width:400px;">--%>
                        <%--<div class="ucarselecttype_pinpaibottom_ul simple"></div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</li>--%>
    <%--</div>--%>

    <%--<div class="jing">--%>
        <%--<label>选择年份：</label>--%>
        <%--<p class="two">2017年2月</p>--%>

        <%--<label>车牌归属地：</label>--%>
        <%--<p class="trr">北京</p>--%>
        <%--<p class="for"><input type="text" name="1" value="20" /> 万公里</p>--%>
    <%--</div>--%>
        <%--<div class="jing" >--%>
        <%--<label>选择车型:</label>--%>
        <div class="pinggu">


            <ul class="pt16">
                <li class="mb13" style="z-index:100">

                    <div class="select_box" id="select1">
                        <div class="lable">选择车型:</div>
                        <div id="valnone">${result.modelName}</div>
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
                                <a href="javascript:void(0)" id="letters_20" class="pinpai_num" rel="185">Z</a>                                            </div>
                            <div class="ucarselecttype_pinpaibottom brandgun" style="width:180px;">
                                <div class="ucarselecttype_pinpaibottom_ul brand">
                                    <c:forEach items="${result.brandList}" var="i">
                                        <p id="${i.key}" class="pinpailist" style="background:#e3e3e3;text-align:center">${i.key}</p>
                                        <c:forEach items="${i.object}" var="j">
                                            <p class="pinpailist list_1" id="${j.key}" rel="A">${j.value}</p>
                                        </c:forEach>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="bg0 lr_158_30 select model" style="width: 210px;height: 458px;left: 378px;display: none;" id="select2_1"></div>
                    <div class="ucarselecttype lr_158_30 select model" style="left:386px;width:200px;height:450px;display: none;" id="select2_2">
                        <div class="ucarselecttype_pinpai" style="width:190px; height:450px;">
                            <div class="ucarselecttype_pinpaitop" id="xzcx" style="width:190px;">
                                请选择车系
                            </div>
                            <div class="ucarselecttype_pinpaibottom" style="width:190px;">
                                <div class="ucarselecttype_pinpaibottom_ul series"></div>
                            </div>
                        </div>
                    </div>
                    <div class="bg0 lr_158_30 select model" style="width:420px; height:458px; left:589px;display: none;" id="select3_1"></div>
                    <div class="ucarselecttype lr_158_30 select model" style="left:598px;width:411px;height:450px;display: none;" id="select3_2">
                        <div class="ucarselecttype_pinpai last" style="width:400px;height:450px;">
                            <div class="ucarselecttype_pinpaitop" id="xzcxing" style="width:400px;">请选择车型</div>
                            <div class="ucarselecttype_pinpaibottom" style="width:400px;">
                                <div class="ucarselecttype_pinpaibottom_ul simple">
                                    <c:if test="${second==1}">
                                        <input type="hidden" id="ndy" value="1">
                                        <p class="list_3 mylist  simple_${result.modelId} layerbg2" data-min="${result.minYear}" data-max="${result.maxYear}"></p>
                                    </c:if>

                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="mb13" style="z-index:99">

                    <div class="select_box" id="select4"><div class="lable">首次上牌时间:</div>${result.regdate}</div>
                    <div class="bg1 lr_158_30 sele regDate" id="sele1_1" style="height:365px;display: none;"></div>
                    <div class="ucarselecttype lr_158_30 sele regDate" id="sele1_2" style="width:182px;height:310px;display: none;">
                        <div class="ucarselecttype_pinpai" style="height:310px;">
                            <div class="ucarselecttype_pinpaitop selyear" style="width:180px;">选择年份</div>
                            <div class="ucarselecttype_pinpaibottom" style="height:320px;width:163px; margin-left:7px">
                                <div class="ucarselecttype_pinpaibottom_ul years"></div>
                            </div>
                        </div>
                    </div>
                    <div class="bg1 lr_158_30 sele regDate" id="sele2_1" style="height:365px;left:334px;display: none;"></div>
                    <div class="ucarselecttype lr_158_30 sele regDate" id="sele2_2" style="left:333px;width:182px;height:340px;display: none;">
                        <div class="ucarselecttype_pinpai" style="height:340px;">
                            <div class="ucarselecttype_pinpaitop selmonth" style="width:180px;">选择月份</div>
                            <div class="ucarselecttype_pinpaibottom" style="height:320px;width:165px; margin-left:7px">
                                <div class="ucarselecttype_pinpaibottom_ul months"></div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="mb13" style="z-index:88">
                    <div class="lable">车牌归属地:</div>
                    <div class="select_box" id="select5">
                        ${result.city}
                    </div>
                    <div class="bg1 lr_158_30 sel zone" id="sel1_1" style="display: none;"></div>
                    <div class="ucarselecttype lr_158_30 sel zone" id="sel1_2" style="width:182px;height:310px;display: none;">
                        <div class="ucarselecttype_pinpai" style="height:310px;">
                            <div class="ucarselecttype_pinpaitop selprov" style="width: 170px;">选择省份</div>
                            <div class="ucarselecttype_pinpaibottom" style="height:265px;width:165px; margin-left:7px">
                                <div class="ucarselecttype_pinpaibottom_ul select_province">
                                    <c:forEach items="${result.proviceList}" var="i" varStatus="status">
                                        <p class="list_6 province <c:if test="${status.count == 1}">layerbg2</c:if>" id="${i.id}">${i.name}</p>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="bg1 lr_158_30 sel zone" id="sel2_1" style="left:334px;display: none;"></div>
                    <div class="ucarselecttype lr_158_30 sel zone" id="sel2_2" style="left:338px;width:182px;height:310px;display: none;">
                        <div class="ucarselecttype_pinpai" style="height:310px;">
                            <div class="ucarselecttype_pinpaitop selcity">选择城市</div>
                            <div class="ucarselecttype_pinpaibottom" style="height:265px;width:160px; margin-left:7px">
                                <div class="ucarselecttype_pinpaibottom_ul select_city">
                                    <p class="pinpailist list_7 layerbg2 pinpailisthover" id="1">北京</p>                                                                      </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="mb13" style="z-index:77">

                    <div class="select_box none" id="gongli">
                        <div class="lable">行驶里程:</div>
                        <input name="s_km" type="text" class="numgongli" value="${result.mail}" id="lichengpd" maxlength="6" autocomplete="off" style="padding-left:0;">
                        <label>万公里</label>
                    </div>
                </li>
                <li>
                    <input type="hidden" name="s_brand" id="s_brand" value="${result.brandId}">
                    <input type="hidden" name="s_series" id="s_series" value="${result.seriesId}">
                    <input type="hidden" name="s_simple" id="s_simple" value="${result.modelId}">
                    <input type="hidden" name="s_year" id="s_year" value="${result.year}">
                    <input type="hidden" name="s_mouth" id="s_month" value="${result.mouth}">
                    <input type="hidden" name="s_province" id="s_province" value="${result.provice}">
                    <input type="hidden" name="s_city" id="s_city" value="${result.cityId}">
                    <input type="hidden" name="s_color" id="s_color" value="0">
                    <input type="hidden" name="s_jxq" id="s_jxq" value="0">
                    <input type="hidden" name="s_nj" id="s_nj" value="0">
                    <input type="hidden" name="s_xz" id="s_xz" value="0">
                    <input type="hidden" name="s_gh" id="s_gh" value="0">
                    <input type="hidden" name="s_ghtime" id="s_ghtime" value="0">
                    <input type="hidden" name="s_method" id="s_method" value="0">
                    <input type="hidden" name="s_ck" id="s_ck" value="0">
                    <input type="hidden" name="sceond" id="sceond" value="${second}">
                    <input id="cityList" type="hidden" value="">
                </li>
            </ul>
        </div>

<%--</div>--%>

<div class="clear"></div>
    <div class="jing color">
        <label>颜色：</label>
        <a href="JavaScript:void(0)" class="hover" data-color="8" title="黑色" style="background: black"> </a>
        <a href="JavaScript:void(0)" class="hover" data-color="2" title="白色" style="background: white"></a>
        <a href="JavaScript:void(0)" class="hover" data-color="1" title="橙色" style="background: orange"></a>
        <a href="JavaScript:void(0)" class="hover" data-color="4" title="红色" style="background: red"></a>
        <a href="JavaScript:void(0)" class="hover" data-color="5" title="棕色" style="background: brown"> </a>
        <a href="JavaScript:void(0)" class="hover" data-color="6" title="蓝色" style="background: blue"> </a>
        <a href="JavaScript:void(0)" class="hover" data-color="7" title="黄色" style="background: yellow"> </a>
        <a href="JavaScript:void(0)" class="hover" data-color="9" title="银色" style="background: silver"> </a>
        <a href="JavaScript:void(0)" class="hover" data-color="10" title="绿色" style="background: green"> </a>
        <a href="JavaScript:void(0)" class="hover" data-color="3" title="其他" >其他</a>
    </div>


    <div class="jing btn xz">
        <label>使用性质：</label>
        <a href="JavaScript:void(0)"  data-xz="1">非营运</a>
        <a href="JavaScript:void(0)"  data-xz="2">租赁</a>
    </div>

    <div class="jing btn method">
        <label>现使用方：</label>
        <a href="JavaScript:void(0)"  data-method="2">个人</a>
        <a href="JavaScript:void(0)"  data-method="1">公司</a>

    </div>

    <div class="jing btn jqx">
        <label>交强险有效期：</label>
         <a href="JavaScript:void(0)"  data-jqx="1">2个月以内</a>
         <a href="JavaScript:void(0)"  data-jqx="2">2个月以上</a>
    </div>


    <div class="jing btn nj">
        <label>年检有效期：</label>
        <a href="JavaScript:void(0)"  data-nj="1">2个月以内</a>
        <a href="JavaScript:void(0)"  data-nj="2">2个月以上</a>
    </div>



    <div class="jing btn gh">
        <label>过户次数：</label>
        <a href="JavaScript:void(0)"  data-gh="1">0次</a>
        <a href="JavaScript:void(0)"  data-gh="1">1次</a>
        <a href="JavaScript:void(0)"  data-gh="2">2次</a>
        <a href="JavaScript:void(0)"  data-gh="3">3次以上</a>
    </div>


    <div class="jing btn ghtime">
        <label>最后一次过户时间：</label>
        <a href="JavaScript:void(0)"  data-ghtime="1">无过户</a>
        <a href="JavaScript:void(0)"  data-ghtime="2">6个月以内</a>
        <a href="JavaScript:void(0)"  data-ghtime="3">6个月以上</a>

    </div>


    <div class="jing jck btn ck">
        <label>车况：</label>
        <a href="JavaScript:void(0)"  data-ck="1">A(优秀)车况好没有任何故障 </a>
        <a href="JavaScript:void(0)"  data-ck="3">C(一般)有过前后轻碰事故 </a>
        <br>
          <i style="display: block; height: 15px;"></i>
        <a href="JavaScript:void(0)"  data-ck="2" style="padding-right: 36px;">B(良好)有过少量剐蹭或钣金 </a>
        <a href="JavaScript:void(0)"  data-ck="4">D(较差)有发生过伤及主体框架的碰撞或较大事故 </a>
    </div>

    <div class="jing tell tells pc">
        <label>手机号：</label>
        <input type="text" name="phone" id="phone" maxlength="11">
        <input type="button" class="tes" onclick="onSendVcode(this)" value="获取验证码"/>
        <b class="error pr">手机号不能为空</b>
    </div>

    <div class="jing tells vc">
        <label>验证码：</label>

        <input type="tell" id="vcode">
        <b class="error vr">验证码不能为空</b>
    </div>
</div>


<div class="clear"></div>
<div class="anniu"><a style="display: block;color: #FFF" onclick="submitForm()">确认估值</a></div>

<div class="clear"></div>

<%@include file="footer.jsp"%>


<!-- jQuery cookie 操作插件-->
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="/resources/js/guzhi.js"></script>
<script>
    $(function(){
        $(".color a").click(function(){
            $(this).addClass('guactive').siblings().removeClass("guactive");
            $("#s_color").val($(this).data('color'));
        });$(".jqx a").click(function(){
            $(this).addClass('hover').siblings().removeClass("hover");
            $("#s_jxq").val($(this).data('jqx'));
        });$(".nj a").click(function(){
            $(this).addClass('hover').siblings().removeClass("hover");
            $("#s_nj").val($(this).data('nj'));
        });$(".xz a").click(function(){
            $(this).addClass('hover').siblings().removeClass("hover");
            $("#s_xz").val($(this).data('xz'));
        });$(".ck a").click(function(){
            $(this).addClass('hover').siblings().removeClass("hover");
            $("#s_ck").val($(this).data('ck'));
        });$(".method a").click(function(){
            $(this).addClass('hover').siblings().removeClass("hover");
            $("#s_method").val($(this).data('method'));
        });$(".gh a").click(function(){
            $(this).addClass('hover').siblings().removeClass("hover");
            $("#s_gh").val($(this).data('gh'));
        });$(".ghtime a").click(function(){
            $(this).addClass('hover').siblings().removeClass("hover");
            $("#s_ghtime").val($(this).data('ghtime'));
        });

    });
    var submitForm = function(){
        0 == $(".numgongli").val() && $(".numgongli").val(""), cleckinput(1, 1, 1, 1)

    }


    var countdown = 120;

    var time = function(el){
        if (countdown == 0) {
            el.removeAttribute("disabled");
            el.value = "获取验证码";
            countdown = 120;
            return;
        } else {
            el.setAttribute("disabled", true);
            el.value = "重新发送(" + countdown + "s)";
            countdown--;
        }
        setTimeout(function(){time(el)},1000)
    }

    var onSendVcode = function(el){
        var phone = $("#phone").val();
        if(!(/^1[34578]\d{9}$/.test(phone))){
            $(".pr").show();
            $(".tell").css({
                color: "#f60"
            })
            return;
        }
        $(".pr").hide();
        $(".tell").css({
            color: "#333"
        });
        $.getJSON('/getSMSCode/'+phone,function (res) {
            if(res.status==200){
                countdown = 120;
                time(el);
            }
        });
    }


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

                    $('#user').attr('href','/per/or')
                    $("#user_li").show();
                }else{
                    $.cookie("phone",null,{path:"/"});
                    $.cookie("token",null,{path:"/"});
                }
            })
        }
    })

</script>
</body>


</html>
