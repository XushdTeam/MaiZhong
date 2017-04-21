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
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/guzhi.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/js.js" type="text/javascript"></script>
    <style>

        .error{
            display: none;
            color: #f05b48;
        }
        .d_box input {
            line-height: 41px;
            height: 41px;
            margin-top: 20px;
            padding-left: 10px;
            width: 178px;
            border: 1px solid #f05b48;
        }
        .verbut {
            width: 120px!important;
            background: #f05b48;
            color: #FFF;
            cursor: pointer;
        }
        .tells input[disabled]{color:#7a8475;opacity:0.8;background: #CCCCCC!important;}
    </style>
</head>
<body>
<div class="box">
    <p class="width"><img src="../resources/img/dl.jpg"></p>
    <div class="shouj">手机验证登录</div>
    <div class="d_box">
        <form name="form" class="tells" onsubmit="return false">
            <input type="text" name="phone" id="phone" maxlength="11" placeholder="手机号"><input type="button" class="verbut" value="获取验证码" onclick="onSendVcode(this)"/>
            <b class="error pr">手机号格式不正确</b>
            <input type="text" name="vercode" id="vercode" placeholder="短信验证码" maxlength="4" class="input2">
            <b class="error verc">验证码不能为空</b>
            <button onclick="onMysubmit()">立即登录</button>
        </form>
    </div>
    <a class="xieyi xieyis" href=" javascript:showoutc();"><input type="checkbox" name="1" checked>我已阅读并同意《迈众汽车协议》</a>
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
</div>

<p class="p_fooot">Copyright © 2017-2020 迈众 All Rights Reserved 版权所有 迈众汽车信息服务有限公司</p>
<p class="p_fooot">京ICP备17017795号     联系电话：010-8025-8108     站长统计</p>
<script>
    var countdown = 120;

    var time = function(el){
        if (countdown == 0) {
            el.removeAttribute("disabled");
            el.value = "获取验证码";
            countdown = 120;
            return;
        } else {
            el.setAttribute("disabled", true);
            el.value = "重新发送(" + countdown + "s)";
            countdown--;
        }


        setTimeout(function(){time(el)},1000)

    }

    var onSendVcode = function(el){
        var phone = $("#phone").val();
        if(!(/^1[34578]\d{9}$/.test(phone))){
            $(".pr").show();
            $(".tell").css({
                color: "#f05b48"
            })
            return;
        }
        $(".pr").hide();
        $(".tell").css({
            color: "#333"
        });


        $.getJSON('/getSMSCode/'+phone,function (res) {
            console.log(JSON.stringify(res));
            if(res.status==200){
                countdown = 120;
                time(el);
            }
        });


    }

    var onMysubmit = function(){
        var phone = $("#phone").val();
        if(!(/^1[34578]\d{9}$/.test(phone))){
            $(".pr").show();
            return;
        }
        $(".pr").hide();
        var vercode = $("#vercode").val();
        if(vercode == ""){
            $(".verc").show();
            return;
        }
        $(".verc").hide();

        $.getJSON('/userLogin/'+phone+"/"+vercode,function(res){
           console.log(JSON.stringify(res));
            if(res.status == 200){
                window.sessionStorage.setItem('token',res.data);
                window.location.href="/";
            }else {
                $(".verc").html(res.message);
                $(".verc").show();
            }
        });

    }
</script>
</body>
</html>
