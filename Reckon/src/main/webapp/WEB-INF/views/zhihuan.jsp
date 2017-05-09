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
    <link rel="stylesheet" type="text/css" href="/resources/font/iconfont.css" />

    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/js.js"></script>
</head>
<body>
<!--头部开始-->
<div class="top e_top">
    <div class="t_cen">
        <a href="#" class="logo"><img src="../resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="#" class="hover">首页</a></li>
            <li><a href="/sale">我要卖车</a></li>
            <li><a href="#">销售商加盟</a></li>
            <li><a href="#">app下载</a></li>
            <li><a href="#">帮助中心</a></li>
            <li><a href="#">个人中心</a></li>
            <li><a href="/per/or"  id="user" style="display:none">188****8888</a></li>
        </ul>
        <ul class="lon">
            <li ><i class="iconfont icon ">&#xe6a3;</i><a href="/login"  id="login">登录</a>/<a href="/login"  id="">注册</a></li>
            <li><a href="javascript:void(0)" class="two" id="exit" style="display:none" onclick="exit();">退出</a></li>
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
            <dt><img src="../resources/img/zh_05.jpg"></dt>
            <dd class="dd2">加油卡</dd>
        </dl>

        <dl>
            <dt><img src="../resources/img/zh_08.jpg"></dt>
            <dd class="dd2">记录仪</dd>
        </dl>

        <dl>
            <dt><img src="../resources/img/zh_10.jpg"></dt>
            <dd class="dd2">空气净化器</dd>
        </dl>

        <dl>
            <dt><img src="../resources/img/zh_12.jpg"></dt>
            <dd class="dd2">车载吸尘器</dd>
        </dl>
    </div>
</div>
<!--四个优势 end-->

<div class="zh_cen">
    <h3>以旧换新,方便又划算</h3>
    <p>新车享最底价，旧车卖高价，最快一天成交</p>
    <div class="inpu"><input type="text" name="0" placeholder="请输入手机号"> <label>免费预约</label></div>
    <p>选本地优质正规4S店，新车我们帮你去砍价，到店即送香水一瓶哦!</p>



    <h2>想看看您的爱车值多少钱吗？足不出户即可为您的爱车估值</h2>
    <p>一站式服务  高价卖爱车</p>
    <p><a href=" ">线上估值，看看我的爱车值多少钱>></a>
    <div class="clear"></div>
    <div>
        <img src="../resources/img/zh_19.jpg">
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
               <p> 如果您的车辆出现因为手续或者车况无法进行过户，或者我们发现车辆有被盗抢记录，有经济抵押、法院封存记录等不合</p>
               <p>（11）退车物流费用由谁承担？</p>
               <p>退车的物流费用全部由悟空收车平台来承担（不合法车辆除外）。</p>
               <p>（12）退车时间大概多久？</p>
               <p> 一般的退车时间为同意退车后的两个工作日内，悟空收车平台客服在退车后会与卖家约定退车时间地点将车辆送回并签定退车协议。</p>

           </div>
             <div class="bot">查看更多常见问题</div>
       </div>
   </div>



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
                <a href="/feedback.html">关于我们</a>
                <a href="/joinus.html">加盟合作</a>
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
                    <li><a href="#"> 销售商加盟</a></li>

                </ul>
                <ul>
                    <li><a href="#">公司简介</a></li>
                    <li><a href="#">联系我们</a></li>
                    <li><a href="#">招贤纳士</a></li>

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
$(document).ready(function(){
$(".guiz_cen .bot").toggle(function() {
    $(".guiz_cen .hide").show();
    $(this).text("点击收起");
},
   function() {
       $(".guiz_cen .hide").hide()
       $(this).text("查看更多常见问题")
   })
});
</script>



</body>
</html>