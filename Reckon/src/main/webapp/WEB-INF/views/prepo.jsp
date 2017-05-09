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
<div class="bg_imgq"> </div>
<!--banner end-->
<!--头end-->


<!--四个优势-->
<div class="ys">
   <dl>
       <dt><img src="../resources/img/ys_05.jpg"></dt>
       <dd class="dd1">二手车收购专家</dd>
       <dd>悟空收车给你更专业的服务</dd>
   </dl>

    <dl>
        <dt><img src="../resources/img/ys_12.jpg"></dt>
        <dd class="dd1">全新卖车方式</dd>
        <dd>直接线上成交 省时、省力、省心</dd>
    </dl>

    <dl>
        <dt><img src="../resources/img/ys_07.jpg"></dt>
        <dd class="dd1">不挑车</dd>
        <dd>悟空收车不挑车合法合规均收购</dd>
    </dl>

    <dl>
        <dt><img src="../resources/img/ys_09.jpg"></dt>
        <dd class="dd1">速度</dd>
        <dd>最快当天成交，当天付款</dd>
    </dl>
</div>
<!--四个优势 end-->


<div class="bg_ys">
    <div class="ys_cen">
         <div class="ys_left">
             <h2>成交快</h2>
             <p>选择太多 没时间等，网上提交订单，
                 悟空收车直接收购，分分钟成交。</p>
         </div>
        <div class="ys_right">
            <img src="../resources/img/ys_1.jpg">
            <img src="../resources/img/ys_2.jpg">
        </div>
    </div>
</div>
<div class="bg_none">
    <div class="ys_cen">

        <div class="ys_right">
            <img src="../resources/img/ys_3.jpg">
            <img src="../resources/img/ys_4.jpg">
        </div>

        <div class="ys_left">
            <h2>价格高</h2>
            <p>海量的收购数据、精准的市场估价，平均比市场多卖10%~20%
                2000万 +用户卖车的第一选择
            </p>
        </div>

    </div>
</div>


<div class="bg_ys">
    <div class="ys_cen">
        <div class="ys_left">
            <h2>超省心</h2>
            <p>一站式服务，足不出户，省时省心</p>
        </div>
        <div class="ys_right">
            <img src="../resources/img/ys_5.jpg">
            <img src="../resources/img/ys_6.jpg">
        </div>
    </div>
</div>



<div class="bg_none">
    <div class="ys_cen">

        <div class="ys_right">
            <img src="../resources/img/ys_7.jpg">
            <img src="../resources/img/ys_8.jpg">
        </div>

        <div class="ys_left">
            <h2>有保障</h2>
            <p>放心卖车，安全有我 </br> 一对一服务，全程可视
            </p>
        </div>

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



</body>
</html>