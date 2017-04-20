<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/19
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>迈众汽车</title>
    <meta name="keywords" content="汽车,汽车买卖,汽车网,汽车报价,汽车图片,买车"/>
    <meta name="description" content="迈众汽车为您提供最新汽车报价，汽车图片，汽车价格大全，最精彩的汽车新闻、行情、评测、导购内容，是提供信息最快最全的中国汽车网站。"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css"/>
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/js.js" type="text/javascript"></script>
</head>
<body class="bgss">
<div class="box">
    <p class="width"><img src="../resources/img/logo.png"></p>
    <div class="shouj">手机验证登录</div>
    <div class="d_box">
        <form action="#" name="form">
            <input type="text" id="phone" name="phone" placeholder="手机号"><%--<input type="button" onclick="getSMSCode(this)"
                                                                               style="background-color: #ff6048;color: white" value="获取验证码">--%>

            <input type="button" id="btn" value="免费获取验证码" onclick="getSMSCode(this)" />

            <input type="text" id="smsCode" name="smsCode" placeholder="短信验证码">
            <button type="button" onclick="userLogin()">立即登录</button>
        </form>
    </div>
    <a class="xieyi xieyis" href=" javascript:showoutc();"><input type="checkbox" name="1" checked>我已阅读并同意《迈众汽车协议》</a>
    <div class="xies">
        <div class=" regcon">
            <div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose"
                                                               onClick="closeClause()">×</b></div>
            <div class="apply_up_content">
    	<pre class="f-r0">
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
            </div>
            <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3"
                       href="javascript:closeClause();">已阅读并同意此条款</a></center>
        </div>
    </div>
</div>

<p class="p_fooot">Copyright © 2017-2020 迈众 All Rights Reserved 版权所有 迈众汽车信息服务有限公司</p>
<p class="p_fooot">京ICP备17017795号 联系电话：010-8025-8108 站长统计</p>
</body>
<script src="/resources/js/login.js"></script>
<script type="text/javascript">

    function getSMSCode(obb) {
        var phone = $("#phone");
        var myreg = /^1[34578]\d{9}$/;
        if (!myreg.test(phone.val())) {
            alert('请输入有效的手机号码！');
            return false;
        }
        $.ajax({
            url: "/getSMSCode/" + phone.val(),
            type: "GET",
            dataType: "JSON",
            success: function (data, startic) {
                if (data.status == 200) {
                   alert("发送成功");
                    settime(obb);
                } else {
                   alert("发送失败");
                    settime(obb);
                }
            }
        })
    }


    function userLogin() {
        var phone = $("#phone");
        var smsCode = $("#smsCode");
        var myreg = /^1[34578]\d{9}$/;
        var testCode = /^(\d{4})$/;
        if (!myreg.test(phone.val())) {
            alert('请输入有效的手机号码！');
            return false;
        }
        if (!testCode.test(smsCode.val())) {
            alert('请输入正确的验证码！');
            return false;
        }
        $.ajax({
            url: "/userLogin/" + phone.val() + "/" + smsCode.val(),
            type: "GET",
            dataType: "JSON",
            success: function (data, startic) {
                if (data.status == 200) {
                 alert("登录成功");
                } else {
                    alert(data.message);
                }
            }
        })
    }
    var countdown = 60;
    function settime(obj) {
        if (countdown == 0) {
            obj.removeAttribute("disabled");
            obj.value = "免费获取验证码";
            countdown = 60;
            return;
        } else {
            obj.setAttribute("disabled", true);
            obj.value = "重新发送(" + countdown + ")";
            countdown--;
        }
        setTimeout(function () { settime(obj)
                }  , 1000)
    }


</script>
</html>
