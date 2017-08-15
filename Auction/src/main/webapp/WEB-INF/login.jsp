<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/8/2
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>优品拍车登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=1200,height=device-height,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="Description" content=" ">
    <meta name="Keywords" content="优品拍车，拍车，卖车，买车 ">
    <link href="https://cdn.bootcss.com/element-ui/1.4.1/theme-default/index.css" rel="stylesheet">
    <link href="/resources/main/css/LayoutLogin.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.0.0/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.4.2/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/element-ui/1.4.1/index.js"></script>
    <style>
        .el-tabs__nav{
            width: 100%;
        }
        .el-tabs__active-bar{
            width: 50%;
        }
        .el-tabs__item{
            width: 50%;
            text-align: center;
        }
        .el-tab-pane{
            text-align: center;
        }
        .tells input{
            float: left;
            margin-left: 20px;
        }
    </style>
</head>
<body class="page1200" style="background: #f5f5f5">
<div class="box" id="app" v-cloak>
    <p class="width"><img src="/resources/main/img/logo.png"></p>

    <div class="d_box">
        <el-tabs v-model="active" @tab-click="handleClick">
            <el-tab-pane label="密码登录" name="first">
                <form name="form" class="tells" onsubmit="return false">
                    <input type="text" v-model="form1.account"  maxlength="11" placeholder="请输入手机号">
                    <input type="password" v-model="form1.pass" placeholder="请输入密码" >
                    <div style="clear:both"></div>
                    <button @click="login1">立即登录</button>
                </form>
            </el-tab-pane>
            <el-tab-pane label="手机验证码登录" name="second">
                <form name="form" class="tells" onsubmit="return false">
                    <input type="text" v-model="form2.phone" maxlength="11" placeholder="请输入手机号">
                    <input type="text" v-model="form2.ver" placeholder="图形验证码" maxlength="4" style="width: 170px">
                    <img src="/verifyCode?Math.random()" onclick="this.src='/verifyCode?'+Math.random()">
                    <input type="text" v-model="form2.verify" maxlength="6" placeholder="验证码" style="width: 170px" >
                    <span @click="sendVerifyCode" :class="{'dis':time > 0}">{{text}}</span>
                    <div style="clear:both"></div>
                    <button @click="login2">立即登录</button>
                </form>
            </el-tab-pane>
        </el-tabs>
        <div class="id">没有账号，<a href="/user/regist">立即注册</a></div>
    </div>
    <div style="clear:both"></div>
</div>
<p class="p_fooot">Copyright © 2017-2020 迈众 All Rights Reserved 版权所有 北京迈众汽车信息服务有限公司</p>
<p class="p_fooot">京ICP备17017795-3号 联系电话：010-8025-8108 站长统计</p>
<script type="text/javascript" src="/resources/script/sha256.js"></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            active:'first',
            form1:{
                account:'',
                pass:''
            },
            form2:{
                phone:'',
                ver:'',
                verify:''
            },
            time:-1
        },
        methods:{
            handleClick(){

            },login1 () {
                if(!(/^1[34578]\d{9}$/.test(this.form1.account))){
                    this.error("请输入正确的手机号！");
                    return ;
                }
                if(!this.form1.pass.trim()){
                    this.error("图形验证码不能为空！");
                    return ;
                }
                this.form1.pass = sha256.digest(this.form1.pass);
                $.post('/login/pass',this.form1,(d)=>{
                    if(d.status==200){
                        vm.success('登录成功');
                        setTimeout(_=>{
                            window.location.href = '/';
                        },500)
                    }else{
                        vm.error(d.message);
                    }
                },'JSON')
            },login2(){
                if(this.time<0){
                    this.error('点击获取验证码！');
                    return ;
                }
                if(!(/^1[34578]\d{9}$/.test(this.form2.phone))){
                    this.error("请输入正确的手机号！");
                    return ;
                }
                if(!this.form2.verify.trim()){
                    this.error('请输入您收到的验证码！');
                    return ;
                }
                $.post('/login/phone',this.form2,(d)=>{
                    if(d.status==200){
                        vm.success('登录成功');
                        setTimeout(_=>{
                            window.location.href = '/';
                        },500)
                    }else{
                        vm.error(d.message);
                    }
                },'JSON')

            },
            sendVerifyCode(){
                if(this.time>0)return ;
                if(!this.form2.phone){
                    this.error("手机号不能为空！");
                    return ;
                }
                if(!(/^1[34578]\d{9}$/.test(this.form2.phone))){
                    this.error("请输入正确的手机号！");
                    return ;
                }
                if(!this.form2.ver.trim()){
                    this.error("图形验证码不能为空！");
                    return ;
                }
                $.getJSON('/sendSms/'+vm.form2.phone+'/'+vm.form2.ver,(d)=>{
                    if(d.status==200){
                        vm.success(d.message);
                        vm.time = 120;
                        vm.timer();
                    } else {
                        vm.error(d.message);
                    }
                })
            },success (msg) {
                this.$message({message: msg, type: 'success'});
            }, error (msg) {
                this.$message.error(msg);
            },timer() {
                if (this.time > 0) {
                    this.time = this.time - 1
                    setTimeout(this.timer, 1000)
                }
            }
        },computed:{
            text(){
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
</body>
</html>
