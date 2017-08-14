<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/31
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <%@ include file="head.jsp" %>
    <link href="/resources/main/css/MyCyp.css" rel="stylesheet">
</head>
<body>
<%@ include file="nav.jsp" %>
<div class="w1200 mauto" style="z-index: 1000" id="app">

    <div class="mt25 clearfix">


        <div class="fl w130 bgf8">
            <div class="pl30 pb15 pt15">
                <h3 class="fs14 c3 lh27">交易中心</h3>
                <ul class="fs12 newsubnav">
                      <li id="ConfirmOrderList"><a href=" ">成交确认</a></li>
                      <li id="OrderList"><a href=" ">订单车辆</a></li>
                      <li id="HistoryAuctionCarList"><a href=" ">历史竞价</a></li>
                      <li id="CarList"><a href=" ">关注车辆</a></li>
                </ul>
                <h3 class="fs14 c3 lh27 mt20">个人设置</h3>
                <ul class="fs12 newsubnav">
                     <li id="Account"><a href=" ">基本信息</a></li>
                    <li id="EditPwd"><span @click="changePassword" style="cursor: hand">修改密码</span></li>
                     <li id="Message"><a href=" ">投诉建议</a></li>
                </ul>
            </div>
        </div>



        <div class="fr w1060">
            <div class=" pt15 pb15 pl20 clearfix">
                <dl class="userpho fl">
                    <dt>
                        <img src="resources/main/img/photo.jpg" alt="头像" class="photo">
                        <p class="togphoto" style="display: none;">更换头像</p>
                    </dt>
                    <dd>
                        <p class="name fs16 c3 mt10">${userInfo.name}</p>
                        <p class="mt5">
                            <img src="resources/main/img/VP.gif" alt="普通商户" class="vm"><span class="vm ml5 fs12 c3">普通商户</span>
                        </p>
                        <p class="mt5 fs12 ">通过实名认证</p>
                        <p class="mt5 fs12">通过手机认证</p>

                    </dd>
                </dl>
                <ul class="usertra fr">
                    <li class="tra1 cursor">成交确认<span class="ccheng ml5" id="sureCarnum">0</span></li>
                    <li class="tra2 cursor">待付款<span class="ccheng ml5" id="nopaymentnum">0</span></li>
                    <li class="tra3 cursor">交付中<span class="ccheng ml5" id="deliverying">0</span></li>
                    <li class="tra4 cursor">交易完成<span class="ccheng ml5" id="dealClose">0</span></li>
                </ul>
            </div>
            <div class="newtit fs20 c3 mt25"><span class="newtit-tex">资产信息</span></div>
            <div class="mt15 clearfix assetsinfo">
                <div>
                    <p class="tit">保证金</p>
                    <div class="pl25 pr25 pt25">
                        <table width="100%">
                            <tbody>
                            <tr>
                                <td>总额：</td>
                                <td align="right">10000元</td>
                            </tr>
                            <tr>
                                <td>余额：</td>
                                <td align="right">8000元</td>
                            </tr>
                            <tr>
                                <td>冻结：</td>
                                <td align="right">2000元</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--头像弹出层-->
    <div class="headimage">
        <p class="rel"></p>
        <div class="pup">
            <div class="w590 bgcwhite bs5c pr">
                <div class="close js-popup-hide"></div>
                <div class="pl10 pr10">
                    <div class="fs16 c3 bbs1 lh48">头像设置</div>
                    <div class="mt10 pl10 pr10 pb25">
                        <form id="formlogo" method="post">
                            <input type="file" name="logo" style="width: 336px;  opacity: 0;filter:alpha(opacity=0); height: 40px; font-size:108px;position: absolute;left:20px; z-index:2; cursor: pointer;" class="file" id="logo" size="28" runat="server" headimageurl="http://i.268v.com//s/" headimg="">
                            <span class="btn bggreen cwhite pl120 pr120 lh40 fz16 btn_float">+ 选择头像图片</span>
                        </form>
                        <p class="fs14 cc mt10" style="clear: both; padding-top: 10px;">仅支持JPG、PNG、GIF、JPEG格式，大小不超过3M</p>
                        <div class="mt20 clearfix">
                            <div class="fl w380 bgf6 h350 tac">
                                <p class="pt75">
                                    <img src="resources/main/img/photo.jpg" width="200px" height="200px" alt="头像" class="userimg">

                                </p>
                            </div>
                            <div class="fr w155 bgf6 tac h350">
                                <p class="fs16 pt35">效果预览</p>
                                <p class="mt20">
                                    <img src="resources/main/img/photo.jpg" width="100px" height="100px" alt="头像" class="userimg">
                                </p>
                                <p class="fs14 cc mt15">100×100像素</p>
                                <p class="mt30">
                                    <img src="resources/main/img/photo.jpg" width="50px" height="50px" alt="头像" class="userimg">
                                </p>
                                <p class="fs14 cc mt15">50×50像素</p>
                            </div>
                        </div>
                        <p class="mt20 tac"><span class="btn bgcheng cwhite fs18 pl25 pr25 lh37 btnHeadImg">确定</span><span class="btn b1s bggrayc cwhite c9 fs18 pl25 pr25 lh37 ml15 js-popup-hide">取消</span></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--聚类的模板-->

</div>

<%@ include file="footer.jsp"%>

<script type="text/javascript">
    $(function(){

        $(".photo").mouseenter(function(){
          $(".togphoto").show();
       })

        $(".photo").mouseleave(function(){
            $(".togphoto").hide();
        })

        $(".togphoto,.photo").click(function(){
            $(".headimage").show();
        })
        $(".js-popup-hide").click(function(){
            $(".headimage").hide();
            $(".togphoto").hide();
        })
    })


    var vm = new Vue({
        el:"#app",
        data:{

        },
        methods:{
            changePassword:function(){
                window.location.href = '/to/mypass';
            }
        }
    })




</script>
</body>
</html>
