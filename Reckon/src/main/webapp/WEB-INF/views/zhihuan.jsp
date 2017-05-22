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
    <title>悟空收车</title>
    <meta name="keywords" content="悟空收车，悟空，二手车，估值，收购"/>
    <meta name="description" content="悟空收车专业的二手车估值收购平台，验车快，当天到账，售后跟踪"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/sp.css" />
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />

    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js"></script>
    <script src="http://cdn.bootcss.com/layer/3.0.1/layer.min.js" type="text/javascript"></script>
    <script src="/resources/js/js.js"></script>
    <script language="javascript">
        function imgdragstart(){return false;}
    </script>
</head>
<body>
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
            <li style="display: none;" id="user_li"><a href="/per/or" target="_blank" >个人中心</a></li>

        </ul>
        <ul class="lon" style="margin-top: 0px;">
            <li >
                <i class="iconfont icon ">&#xe6a3;</i>
                <a href="/login"  id="user">登录</a>
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
<!--banner-->
<div class="bg_imgt"> </div>
<!--banner end-->
<!--头end-->


<!--四个优势-->
<div class="zh">
    <div class="ys">
        <dl>
            <dt><img src="/resources/img/zh_05.jpg"></dt>
            <dd class="dd2">

                加油卡
            </dd>
        </dl>

        <dl>
            <dt><img src="/resources/img/zh_08.jpg"></dt>
            <dd class="dd2">记录仪</dd>
        </dl>

        <dl>
            <dt><img src="/resources/img/zh_10.jpg"></dt>
            <dd class="dd2">空气净化器</dd>
        </dl>

        <dl>
            <dt><img src="/resources/img/zh_12.jpg"></dt>
            <dd class="dd2">车载吸尘器</dd>
        </dl>
    </div>
</div>
<!--四个优势 end-->

<div class="zh_cen">
    <h3>以旧换新,方便又划算</h3>
    <p>新车享最底价，旧车卖高价，最快一天成交</p>
    <div class="inpu"><input type="text" name="0" id="phone" maxlength="11" placeholder="请输入手机号"> <label onclick="yuyue()">免费预约</label></div>
    <p>选本地优质正规4S店，新车我们帮你去砍价，到店即送香水一瓶哦!</p>



    <h2>想看看您的爱车值多少钱吗？足不出户即可为您的爱车估值</h2>
    <p>一站式服务  高价卖爱车</p>
    <p><a href="/sale">线上估值，看看我的爱车值多少钱>></a>
    <div class="clear"></div>
    <div>
        <img src="/resources/img/zh_19.jpg">
    </div>
</div>


<div class="guiz">
   <div class="guiz_cen">
           <h2>置换规则 </h2>
           <p>1、参与估价并提交订单完成线上回收交易（保证车辆的真实合法合规性），即可参与“置”尊享受“换”然一新 活动，奖品包括   加油卡、行车记录仪、空气净化器 车载吸尘器  等以系列置换礼包</p>
           <p>2、完成置换条件的所有订单，悟空收车客服会在5个工作日内完成审核并快递到您的手中；</p>
           <p>3、所有置换的奖品均属于额外补贴，不支持退换或折现，单笔订单交易手机号或收货地址只能享受一次补贴。</p>
           <p>4、活动参与时间：2017年5月6日-2018年1月1日，奖品种类会有变动具体可咨询悟空收车客服。</p>
           <p>5、本次活动最终解释权归悟空收车所有。</p>

           <h2>常见问题 </h2>
           <p>（1）如何可以领到置换的奖品？</p>
           <p>参与估价并提交订单完成线上回收交易（保证车辆的真实合法合规性），即可参与“置”尊享受“换”然一新 活动奖品</p>
           <p>（2）客服电话是多少？</p>
           <p>客服热线电话 010-80258108</br>
               悟空收车客户服务热线通过人工，短信等方式为您提供有关卖车的业务咨询、业务受理和投诉建议等业务服务</p>
           <div class="hide">
               <p>（3）在悟空收车平台卖车需要交什么费用？</p>
               <p> 我们不会向卖家收取任何费用，整个服务过程全部免费，物流费，过户费用等都由悟空收车平台承担。</p>
               <p>（4）卖车流程是什么？</p>
               <p> 1、在卖车页面填写车辆信息，或拨打客服电话联系我们。</p>
               <p> 2、约定后和质检师在约定时间地点进行见面，对车辆细致检测。</p>
               <p> 3、质检结果与卖家订单填写情况相符即可，若质检结果不符者需要按照实际车况重新作价。</p>
               <p>4、签定收购协议。</p>
               <p>（5）大概多长时间能够成交？</p>
               <p> 需要您先在网站提交订单，由您选择现场质检时间，质检结果与订单无误，现场即可成交。</p>
               <p> （6）打款需要多长时间？</p>
               <p>悟空收车平台承诺，卖家签定收购协议即可打款。</p>
               <p>（7）在悟空收车平台卖车需要准备什么？</p>
               <p> 需要先在网站提供您的联系电话，车辆品牌、型号等基本信息。待服务人员联系您后，在约定时间内准备好</p>
               <p> 1、身份证</p>
               <p>  2、行驶证</p>
               <p>  3、车辆登记证</p>
               <p> 4、车辆钥匙</p>
               <p>  5、车示标（环保标、检字标、交强险标）</p>
               <p> 6、交强险单</p>
               <p>  7、购置税本及购置税发票</p>
               <p> 8、购车发票/最近一次过户发票</p>
               <p>（8）一直无法估价、提交订单怎么办？</p>
               <p> 用其他浏览器试一下，如果还是不行请联系客服解决。</p>
               <p>（9）哪些车悟空收车平台不进行收购？</p>
               <p> 对于以下车辆迈众汽车不予收购</p>
               <p> 1.发生事故影响过户车辆、泡水车、火烧车</p>
               <p> 2.有被盗抢记录，有经济抵押、法院封存记录车辆</p>
               <p> 3.改凿发动机及车架号码车辆</p>
               <p>4.数据与车管所档案不相符车辆</p>
               <p>5.证件不齐全、不合格、已无效车辆</p>
               <p>（10）什么情况发生退车？</p>
               <p> 如果您的车辆出现因为手续或者车况无法进行过户，或者我们发现车辆有被盗抢记录，有经济抵押、法院封存记录等不合法车辆。</p>
               <p>（11）退车物流费用由谁承担？</p>
               <p>退车的物流费用全部由悟空收车平台来承担（不合法车辆除外）。</p>
               <p>（12）退车时间大概多久？</p>
               <p> 一般的退车时间为同意退车后的两个工作日内，悟空收车平台客服在退车后会与卖家约定退车时间地点将车辆送回并签定退车协议。</p>

           </div>
             <div class="bot">查看更多常见问题</div>
       </div>
   </div>
<style>
    .layerpop{
        height: 220px;
    }
    .layerpop .cd_m_pop_jjtx_result {
        width: 260px;
        padding: 0 45px;
        text-align: center;
    }
    .layerpop .cd_m_pop_jjtx_success>i {
        background-position: 0 -1640px;
    }
    .layerpop .cd_m_pop_jjtx_result>span {
        display: block;
    }
    .layerpop .cd_m_pop_jjtx_result>i {
        height: 55px;
        width: 52px;
        margin-top: 50px;
        display: inline-block;
        background: url(/resources/img/correct.png) no-repeat;
    }
    .layerpop .cd_m_pop_jjtx_res_tit {
        font-size: 18px;
        color: #e72116;
        margin-top: 20px;
    }
    .layerpop .cd_m_pop_jjtx_res_desc {
        font-size: 14px;
        color: #585858;
        margin-top: 15px;
        line-height: 25px;
    }


</style>
<div class="layerpop" style="display: none;">
    <p class="cd_m_pop_jjtx_result" style="display: block;">
        <i></i>
        <span class="cd_m_pop_jjtx_res_tit" id="cd_m_pop_jjtx_res_tit_car">预约成功</span>
        <span class="cd_m_pop_jjtx_res_desc" id="cd_m_pop_jjtx_res_desc_car">稍后会有客服与您联系，请您注意接听。</span>
    </p>
</div>


<%@include file="footer.jsp"%>
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

                    $('#user').attr('href','/per/or')
                    $("#user_li").show();
                }else{
                    $.cookie("phone",null,{path:"/"});
                    $.cookie("token",null,{path:"/"});
                }
            })
        }
        $(".guiz_cen .bot").toggle(function() {
            $(".guiz_cen .hide").show();
            $(this).text("点击收起");
        },
        function() {
            $(".guiz_cen .hide").hide()
            $(this).text("查看更多常见问题")
        })


    })
    function exit(){
        $.cookie("phone",null,{path:"/"});
        $.cookie("token",null,{path:"/"});
        window.location.reload()
    }
    function yuyue(){
        var phone = $("#phone").val();
        if(!(/^1[34578]\d{9}$/.test(phone))){
            layer.msg("请输入正确的手机号", {
                offset: 't',
                anim: 6
            });
            return false;
        }else{
            $.post('/zhihuancar',{phone:phone},function(d){
                layer.open({
                    type: 1,
                    shade: false,
                    offset: '300px',
                    title: false, //不显示标题
                    content: $('.layerpop'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响

                });
            },'json')
        }
    }
</script>


<script language="javascript">
    for(i in document.images)document.images[i].ondragstart=imgdragstart;
</script>




</body>
</html>