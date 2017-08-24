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
    <link href="/resources/main/css/page.css" rel="stylesheet">
</head>
<body>
<%@ include file="nav.jsp" %>

<div class="w1200 mauto">
    <div class="place mt20"><a href=" ">个人中心</a> &gt;&gt;&nbsp;<span class="c9" id="YeQianSan">历史竞价</span></div>
    <div class="mt25 clearfix">


        <div class="fl w130 bgf8">
            <div class="pl30 pb15 pt15">
                <h3 class="fs14 c3 lh27">交易中心</h3>
                <ul class="fs12 newsubnav">
                    <li id="ConfirmOrderList"><a href=" ">成交确认</a></li>
                    <li id="OrderList"><a href=" ">订单车辆</a></li>
                    <li id="HistoryAuctionCarList"><a href=" "  >历史竞价</a></li>
                    <li id="CarList"><a href=" "  >关注车辆</a></li>
                </ul>
                <h3 class="fs14 c3 lh27 mt20">个人设置</h3>
                <ul class="fs12 newsubnav">
                    <li id="Account"><a href=" ">基本信息</a></li>
                    <li id="EditPwd"><a href=" ">修改密码</a></li>
                    <li id="Message"><a href=" ">投诉建议</a></li>
                </ul>
            </div>
        </div>

        <div class="fr w1060">
            <div class="newtit fs20 c3 mt25"><span class="newtit-tex">关注车辆</span></div>
            <div class="pr10 pl10 pt25">
                <table class="fs14 c9 tabcar w">
                    <thead>
                    <tr class="c3 bgf5 fs14">
                        <td colspan="2" width="550">
                            <div class="select_box select_box2">
                                <span class="c3 text">车辆</span>

                            </div>
                        </td>
                        <td width="260" style="padding-left: 80px">合手价</td>
                        <td width="230">
                            <div class="select_box select_box2">
                                <span class="c3 text">竞拍结束时间</span>

                            </div>
                        </td>
                    </tr>
                    </thead>
                    <tbody id="HistoryAuctionCar">

                    <tr height="120" class="trhover">
                        <td width="140px" class="pl10">
                            <div class="carnew">
                                <img src="main/img/5.jpg">
                            </div>
                        </td>
                        <td width="270px" class="pl10 pr10">
                            <div class="fs14 clearfix">
                                <a target="_blank" title="2004款 捷达 1.6L MT GIF 豪华" href=" " id="model_11081241" class="fl cblack">
                                    <span class="fl carname" style="cursor: pointer">2004款 捷达 1.6L MT GIF 豪华</span>
                                </a>
                                <p class="fr fs12 cwhite w60"></p>
                            </div>
                            <p class="mt10">北京&nbsp;&nbsp;初登：2006-09&nbsp;&nbsp;等级：50B</p>
                            <p>里程：13.2万&nbsp;&nbsp;排放：不详</p>
                        </td>
                        <td>
                            <span class="fs16 ccheng ml10">15000</span>
                        </td>
                        <td class="pl20">2017/07/26 14:00</td>
                    </tr>
                    <tr height="120" class="trhover bgqing">
                        <td width="140px" class="pl10">
                            <div class="carnew">
                                <img src="main/img/5.jpg">
                            </div>
                        </td>
                        <td width="270px" class="pl10 pr10">
                            <div class="fs14 clearfix">
                                <a target="_blank" title="2004款 捷达 1.6L MT GIF 豪华" href=" " id="model_11080973" class="fl cblack">
                                    <span class="fl carname" style="cursor: pointer">2004款 捷达 1.6L MT GIF 豪华</span>
                                </a>
                                <p class="fr fs12 cwhite w60">
                                    <span class="shou" title="首次上线">首次上拍</span>
                                </p>
                            </div>
                            <p class="mt10">北京&nbsp;&nbsp;初登：2006-09&nbsp;&nbsp;等级：50B</p>
                            <p>里程：13.2万&nbsp;&nbsp;排放：不详</p>
                        </td>
                        <td><span class="fs16 ccheng ml10">15500</span></td>
                        <td class="pl20">2017/07/25 16:13</td>
                    </tr>
                    <tr height="120" class="trhover">
                        <td width="140px" class="pl10">
                            <div class="carnew">
                                <img src="main/img/5.jpg">
                            </div>
                        </td>
                        <td width="270px" class="pl10 pr10">
                            <div class="fs14 clearfix">
                                <a target="_blank" title="2015款 320Li 2.0T AT 时尚" href=" " id="model_11080856" class="fl cblack">
                                    <span class="fl carname" style="cursor: pointer">2015款 320Li 2.0T AT 时尚</span>
                                </a>
                                <p class="fr fs12 cwhite w60">
                                    <span class="shou" title="首次上线">首次上拍</span>
                                </p>
                            </div>
                            <p class="mt10">北京&nbsp;&nbsp;初登：2014-10&nbsp;&nbsp;等级：65B</p>
                            <p>里程：4.9万&nbsp;&nbsp;排放：国四</p>
                        </td>
                        <td>
                            <span class="fs16 ccheng ml10">222500</span>
                        </td>
                        <td class="pl20">2017/07/25 15:41</td>
                    </tr>
                    <tr height="120" class="trhover">
                        <td width="140px" class="pl10">
                            <div class="carnew">
                                <img src="main/img/5.jpg">
                            </div>
                        </td>
                        <td width="270px" class="pl10 pr10">
                            <div class="fs14 clearfix">
                                <a target="_blank" title="2008款 凯越 1.6L MT 舒适" href=" " id="model_11080701" class="fl cblack">
                                    <span class="fl carname" style="cursor: pointer">2008款 凯越 1.6L MT 舒适</span>
                                </a>
                                <p class="fr fs12 cwhite w60">
                                    <span class="shou" title="首次上线">首次上拍</span>
                                </p>
                            </div>
                            <p class="mt10">北京&nbsp;&nbsp;初登：2008-07&nbsp;&nbsp;等级：50B</p>
                            <p>里程：14.7万&nbsp;&nbsp;排放：国四</p>
                        </td>
                        <td>
                            <span class="fs16 ccheng ml10">23700</span>
                        </td>
                        <td class="pl20">2017/07/25 15:07</td>
                    </tr>

                    </tbody>
                </table>                <div id="pagination" class="pageinfo" style="  display: block;">

                    <ul class="pages">
                        <li>
                            <span class="beginEnd">首页</span>
                        </li>
                        <li>
                            <span class="beginEnd">上一页</span>
                        </li>
                        <li>
                            <span class="current">1</span>
                        </li>
                        <li>
                            <a>2</a>
                        </li>
                        <li><a>3</a></li>
                        <li><a>4</a></li>
                        <li><a>5</a></li>
                        <li class="dotted">...</li>
                        <li><a><span class="beginEnd">下一页</span></a></li>
                        <li><a><span class="beginEnd">末页</span></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>
