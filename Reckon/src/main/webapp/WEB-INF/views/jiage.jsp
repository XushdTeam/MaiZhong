<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/19
  Time: 10:01
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
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>
    <script src="/resources/js/js.js" type="text/javascript"></script>

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
            <a href="javascript:vold(0)" class="two">APP下载</a></span>
        </span>
    </div>
</div>

<div class="x_nav">当前位置 :  <a href="/">首页</a> > <a href="javascript:void(0)">二手车评估</a> > 精准估值</div>
<div class="jiage">
    <div class="jias"><span>￥</span>${price}万</div>
    <div class="jzj">精准价</div>
    <div class="pos"></div>
    <a class="xieyi" href=" javascript:showoutc();"><input type="checkbox" name="1" checked>我已阅读并同意《迈众汽车协议》</a>

    <div class="xies">
        <div class=" regcon">
            <div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b></div>
            <div class="apply_up_content">
    	<pre class="f-r0">
		<strong>同意以下服务条款</strong>
        </pre>
                <div class="ovf">
                 <p>（一）交验车</p>
              <p> 1.迈众汽车（收购方）检测车辆时应该对车辆车况和手续进行核实，并向用户（出卖方）出具有效评估报告。如有与用户在系统上所填内容不相符的，迈众汽车有权依据车辆实际车况和手续重新估值，或者不予收购。</p>
                    <p>2.用户应于成交时将车辆及全部手续交给迈众汽车，并获得迈众汽车认可。手续包括行驶证、登记证书、购置税凭证、年检凭证（标）、车船使用税（标及完税发票）、环保绿标、原始购车发票或过户交易发票、交强险保险单正本及保险卡（标）、车主身份证或组织机构代码证及联系人电话。</p>
                3.迈众汽车确认收购车辆后，在公平公正的情况下应现场与用户签定车辆收购协议。
                <p>（二）双方的权利及义务</p>
                1.用户保证车辆的来源合法，无被盗抢记录，无经济抵押、法院封存记录，无改凿发动机及车架号码，所有数据与车管所档案相符，证件齐全，合格、有效，并保证承担由此引起的经济损失和法律责任。
                2.如果车辆有伤用户应该如实告知，不得隐瞒车辆有伤的事实。车辆架构整体切割，伤及防火墙，泡水，烧毁等严重影响车辆价格的车况，不在系统估价范围内。如有以上情况，迈众汽车有权重新估值或不予收购。
                3.如在办理过户过程中，由于车辆原因及证件问题和不可抗力的原因造成该车不能过户，车主应在3个工作日内退回所有的预付款及车款。
                <p>（三）注意事项</p>
                1.车款两清后，车辆及全部手续归属迈众汽车。自交车时间点之前该车存在的任何交通事故、交通违章及在该车上发生的任何经济纠纷由用户负责，与迈众汽车无关；交车时间点之后的由迈众汽车负责，该车存在的任何交通事故、交通违章及在该车上发生的任何经济纠纷由迈众汽车负责，与用户无关。
                2.迈众汽车收购车辆后，因需整修暂时不能过户，一旦迈众汽车向用户提出过户时，用户应积极配合迈众汽车，应按照迈众汽车要求将车辆在七个工作日内过户至迈众汽车指定的第三方名下，过户费用由迈众汽车承担。由于用户的原因不能过户或用户故意拖延、过户不及时，给迈众汽车所造成的一切损失由用户负责。
                <p>（四）违约责任</p>
                1.第三人对车辆主张权利并有确实证据的，出卖方应承担由此给收购方造成的一切损失。
                2.用户未按照约定交付车辆或相关文件的应支付5000元违约金。
                3.迈众汽车未按照约定支付车款的，用户有权要求迈众汽车承担由此造成的一切损失。
               <p> （五）付款</p>
                1.迈众汽车与用户签定车辆收购协议后现场向用户支付全额车款，并向用户出示转账证明，现场确认车款到账。
                2.车款到账后用户应在迈众汽车车辆付款确认单上确认签字。
                3.如收款方与车主不是同一人情况下，收款方应出具车主本人所写的有效委托收款证明。
            </div>
            <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a></center>
        </div>
    </div>


    <div class="anniu"><a href="/yuyue" style="display: block;color: #FFF">立即下单</a></div>
</div>
</div><!--jiage end-->
<div class="zhuyi">
    <div>注意事项</div>
    <p>1、车辆成交需要携带：车主身份证原件  登记证 行驶本 新车发票/过户票  交强险原件 购置税本 /p>
    <p>2、精准估计即为成交价格，用户所填能容应真实有效。（如检测结果与用户所填内容不符，以实际检测结果重新估算价格为准。）</p>
    <p>3、检测师质检通过后即第一时间给您打款。</p>
</div>
<script>
    $(document).ready(function() {

        var phone = $.cookie('phone');
        var token = $.cookie('token');
        if(phone&&token){
            $.getJSON('/loginByToken/'+phone+'/'+token,function (d) {
                if(d.status==200){
                    $("#login").hide();

                    $('#user').html(phone).show();

                }else{
                    $.cookie("phone",null,{path:"/"});
                    $.cookie("token",null,{path:"/"});
                }
            })
        }
    })
</script>
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
</html>
