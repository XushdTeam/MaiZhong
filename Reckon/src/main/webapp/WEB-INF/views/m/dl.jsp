<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/2
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <script src="/resources/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.cookie.min.js" type="text/javascript"></script>
    <style>
        .mui-content{
            background: #FFF;
        }
        .mui-input-group input, .mui-input-group textarea {
            border-bottom: 1px solid #e5e5e5;
            font-size: 16px;
        }
        button:active{background: none!important;}
        .mui-logins{ background: #fff !important; }
        .mui-logins a{ color: #f60; line-height: 44px;}
        .mui_p{ text-align: center;color: #000; font-size: 1.5rem;}
        .mui-p2{ text-align: center;color: #000f42;}
    </style>
</head>

<body>
<div id="app">
<header id="header" class="mui-bar mui-logins">
    <a class="mui-pull-left" v-tap="{methods:back}">取消</a>
</header>

<div class="mui-content mui-login" >
    <p class="mui_p">使用手机号登录</p>
    <form class="mui-input-group" onsubmit="return false">
        <div class="mui-input-row">
            <input type="tel" placeholder="请输入手机号" maxlength="11" v-model="phone">
        </div>
        <div class="mui-input-row mui-wid">
            <input type="tel" placeholder="验证码" v-model="vercode" maxlength="4">
            <button class="mui-color" v-tap="{methods:sendVercode}" :disabled="time > 0">{{text}}</button>
        </div>

    </form>
    <button class="but butss" v-tap="{methods:login}" >登录</button>
    <p class="mui-p2">通过短信验证码登录</p>
</div>
</div>
</body>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js" ></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>
<script type="text/javascript" src="/resources/wap/script/interface.js"></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            phone:'',
            vercode:'' ,
            time:-1
        },
        methods:{
            login:function(){
                if(!this.phone){
                    mui.toast('请输入手机号');
                    return false;
                }
                if(!this.vercode){
                    mui.toast('请输入4位验证码');
                    return false;
                }


                //验证手机验证码
                mui.getJSON('/userLogin/'+this.phone+'/'+this.vercode,function (res) {
                    if(res.status==200) {

                        //电话写入cookie
                        $.cookie('phone', vm.phone, {expires: 7, path: '/'});
                        $.cookie('token', res.data, {expires: 7, path: '/'});
                        window.history.back(1)
                    }else{
                        mui.toast(res.message);
                    }
                });


            },
            sendVercode:function(){
                if(!this.phone){
                    mui.toast('请输入手机号');
                    return false;
                }
                if(!(/^1[34578]\d{9}$/.test(this.phone))){
                    mui.toast('请输入正确的手机号');
                    return false;
                }
                mui.getJSON('/getSMSCode/'+this.phone,function (res) {
                    if(res){
                        mui.toast('验证码发送成功，请注意查收');
                        vm.time = 120;
                        vm.timer();
                    }
                });


            },
            timer:function() {
                if (this.time > 0) {
                    this.time = this.time - 1
                    setTimeout(this.timer, 1000)
                }
            },back:function(){
                window.history.back(1);
            }
        },
        computed: {
            text:function() {
                if(this.time<0){
                    return '获取验证码';
                }else if(this.time == 0){
                    return '重新发送';
                }else{
                    return this.time > 0 ? this.time + 's后，重新发送' : '重新发送'
                }

            }
        }
    })
</script>

</html>

