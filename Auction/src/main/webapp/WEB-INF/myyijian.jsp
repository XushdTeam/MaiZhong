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
    <link href="/resources/main/css/CarDetailCss.css" rel="stylesheet">
</head>
<body>
<%@ include file="nav.jsp" %>

<div class="w1200 mauto" style="z-index: 1000">
    <div class="place mt20"><a href=" ">个人中心</a> &gt;&gt;&nbsp;<span class="c9" id="YeQianSan">基本信息<span></div>
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
            <div class="infor">
                <h2><span></span>投诉建议 <i onclick="jianyi();">+添加新建议</i></h2>
                <div class="infor_com">
                    <div class="infor_center">
                        <span class="span1">内容</span>
                        <span class="span2">提交时间</span>
                        <span class="span3">状态</span>
                    </div>

                    <div class="infor_cen">
                        <span class="span1">内容asasdasdasdasdasdasddasdasdasdasd</span>
                        <span class="span2">dasdasdasdasdsdasdasdasdasd</span>
                        <span class="span3">状asd态</span>
                    </div>


                </div>
            </div>
        </div>

    </div>

</div>

<div class="popup hide" id="memoirDialogPopup">
    <p class="vam"></p>
    <div class="content bgwhite w700 h420 pr" id="memoirDialog">
        <span class="test-close close" dialog="memoirDialog">×</span>
        <div class="pt35 pr40 pl40 tl">
            <p class="fs18 c4">评价</p>
            <table width="100%" class="c6 mt10">
                <tbody>
                <tr height="30">
                    <td class="evalB"><p class="memoirStarList">请您评价：<i num="1"></i><i num="2"></i><i num="3"></i><i num="4"></i><i num="5"></i> <span class="starDescribe"></span></p></td>
                </tr>
                <tr>
                    <td id="memoirList"></td>
                </tr>

                <tr>
                    <!--<td valign="top"><span class="pr t20">简单描述</span></td>-->
                    <td>
                        <div class="report-tex-box">
                            <p class="report-tex-num hui"><span id="memoirNum">0</span>/200</p>
                            <textarea class="report-tex hui" id="memoirTex">点评一下车辆或报告吧，您的意见很重要（选填）</textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <!--<td>手机号</td>-->
                    <td height="70">
                        <input type="text" class="report-ipt  " id="memoirPhone" value=" " maxlength="11" placeholder="请输入你的手机号">
                        <span class="red" id="memoirPhoneMsg"></span>
                    </td>
                </tr>
                <tr>
                    <!--<td>&nbsp;</td>-->
                    <td><span class="test-btn-new" id="memoirSubmit">提交</span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>
<script type="text/javascript">
    function jianyi(){
        $("#memoirDialogPopup").show();
    }
    $(function(){
        $(".test-close").click(function(){
            $("#memoirDialogPopup").hide();
        })
    })
</script>
</body>
</html>
