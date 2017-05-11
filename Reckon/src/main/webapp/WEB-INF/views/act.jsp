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
    <script src="/resources/js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
    <script src="/resources/js/js.js"></script>
</head>
<body>
<!--头部开始-->
<div class="top e_top">
    <div class="t_cen">
        <a href="/" class="logo"><img src="../resources/img/logo.png"></a>
        <ul class="t_right">
            <li><a href="/" >首页</a></li>
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
<div class="bg_imge"> </div>
<!--banner end-->

<div class="bg_imgs"></div>

<div class="hui_color">
    <div class="hui_top">
       <img src="../resources/img/hui_04.jpg">
        <a href="#"><img src="../resources/img/hui_08.jpg"></a>
        <p>成交即可赠送应季大礼包 多卖多送无上限</p>
    </div>
</div>

<div class="bg_imgr"></div>

<div class="zhongj">
   <div class="zhi_cen">
       <div class="z_left">
           <p class="p_head">中奖名单</p>

           <div class="txtMarquee-top">
               <div class="zdan bd">
                   <div class="zd"></div>
                   <ul class="infoList">
                       <li><span class="sp1">135****6862</span> <span class="sp2">获得了500元现金红包</span> <span>2017/05/08</span></li>
                       <li><span class="sp1">135****6862</span> <span class="sp2">获得了888元现金红包</span> <span>2017/05/08</span></li>
                       <li><span class="sp1">135****6862</span> <span class="sp2">获得了666元现金红包</span> <span>2017/05/08</span></li>
                       <li><span class="sp1">135****6862</span> <span class="sp2">获得了500元现金红包</span> <span>2017/05/08</span></li>
                       <li><span class="sp1">135****6862</span> <span class="sp2">获得了300元现金红包</span> <span>2017/05/08</span></li>
                       <li><span class="sp1">135****6862</span> <span class="sp2">获得了888元现金红包</span> <span>2017/05/08</span></li>
                       <li><span class="sp1">135****6862</span> <span class="sp2">获得了400元现金红包</span> <span>2017/05/08</span></li>
                       <li><span class="sp1">135****6862</span> <span class="sp2">获得了200元现金红包</span> <span>2017/05/08</span></li>
                       <li><span class="sp1">135****6862</span> <span class="sp2">获得了300元现金红包</span> <span>2017/05/08</span></li>
                       <li><span class="sp1">135****6862</span> <span class="sp2">获得了50元现金红包</span> <span>2017/05/08</span></li>

                   </ul>
               </div>
           </div>


       </div>
       <div class="z_right">
           <p class="p_head">你还有2次抽奖机会</p>

           <div class="turntable-bg">

               <!--<div class="mask"><img src="images/award_01.png"/></div>-->

               <div class="pointer"><img src="../resources/img/pointer.png" alt="pointer" width="100%"/></div>

               <div class="rotate" ><img id="rotate" src="../resources/img/turntable.png" alt="turntable" width="100%"/></div>

           </div>
       </div>

       <div class="clear"></div>
       <div class="huod">
           <img src="../resources/img/huo_03.jpg">
           <div class="huo_cen">
               <p>1.活动时间：2017.5.6-2018.1.1</p>
               <p> 2.用户在48小时内完成交易，即可活动一次抽奖机会</p>
               <p> 3.中奖奖品由悟空收车平台客服负责审核并发放</p>
               <p> 4.本次活动只针对在悟空收车平台成功交易客户参加</p>
               <p> 5、奖品数量有限，先到先得</p>
           </div>
       </div>
   </div>
</div>



<div class="cj">
    <div class="cj_cen">
        <h2>热销车型</h2>

        <div class="owl-item">
            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动2010年出厂2010年出厂</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>
        </div>

        <div class="owl-item">
            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动2010年出厂2010年出厂</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>
        </div>

        <div class="owl-item">
            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动2010年出厂2010年出厂</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>
        </div>
        <div class="owl-item">
            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动2010年出厂2010年出厂</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>
        </div>
        <div class="owl-item">
            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动2010年出厂2010年出厂</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>
        </div>

        <div class="owl-item">
            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动2010年出厂2010年出厂</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>
        </div>

        <div class="owl-item">
            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动2010年出厂2010年出厂</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>
        </div>
        <div class="owl-item">
            <div class="item darkCyan">
                <img src="../resources/img/2-y.jpg "  alt="Touch">
                <h3>别克 君威 2010年出厂 2.0L自动2010年出厂2010年出厂</h3>
                <p>7年车龄/8.0万公里/北京</p>
                <h4>5.6万</h4>
            </div>
        </div>


        </div>
    </div>


<!--头end-->









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
                        5号楼1002-1004室或西红门公交车站对面</a></li>
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




<script type="text/javascript">
    jQuery(".txtMarquee-top").slide({mainCell:".bd ul",autoPlay:true,effect:"topMarquee",vis:10,interTime:100});
</script>

<script>
    $(function(){
        $(".zdan ul li:even").css("background","#eee")
    });
</script>



<script src="/resources/js/awardRotate.js"></script>

<script>

    $(function (){

        var rotateTimeOut = function (){

            $('#rotate').rotate({

                angle:0,

                animateTo:2160,

                duration:8000,

                callback:function (){

                    alert('网络超时，请检查您的网络设置！');

                }

            });

        };

        var bRotate = false;



        var rotateFn = function (awards, angles, txt){

            bRotate = !bRotate;

            $('#rotate').stopRotate();

            $('#rotate').rotate({

                angle:0,

                animateTo:angles+1800,

                duration:8000,

                callback:function (){

                    alert(txt);

                    bRotate = !bRotate;

                }

            })

        };



        $('.pointer').click(function (){



            if(bRotate)return;

            var item = rnd(0,8);



            switch (item) {

                case 0:

                    //var angle = [26, 88, 137, 185, 235, 287, 337];

                    rotateFn(0, 360, '50元');

                    break;

                case 1:

                    //var angle = [88, 137, 185, 235, 287];

                    rotateFn(1, 45, '666元');

                    break;

                case 2:

                    //var angle = [137, 185, 235, 287];

                    rotateFn(2, 90, '700元');

                    break;

                case 3:

                    //var angle = [137, 185, 235, 287];

                    rotateFn(3, 135, '888元');

                    break;

                case 4:

                    //var angle = [185, 235, 287];

                    rotateFn(4, 180, '500元');

                    break;

                case 5:

                    //var angle = [185, 235, 287];

                    rotateFn(5, 225, '300元');

                    break;

                case 6:

                    //var angle = [235, 287];

                    rotateFn(6, 270, '200元');

                    break;

                case 7:

                    //var angle = [287];

                    rotateFn(7, 315, '100元');

                    break;

                case 8:

                    //var angle = [287];

                    rotateFn(8, 360, '50元');

                    break;

            }



            console.log(item);

        });

    });

    function rnd(n, m){

        return Math.floor(Math.random()*(m-n+1)+n)

    }

</script>





</body>
</html>