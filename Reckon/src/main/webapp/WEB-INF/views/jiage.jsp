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
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
            </div>
            <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a></center>
        </div>
    </div>


    <div class="anniu"><a href="/yuyue" style="display: block;color: #FFF">立即下单</a></div>
</div>
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
