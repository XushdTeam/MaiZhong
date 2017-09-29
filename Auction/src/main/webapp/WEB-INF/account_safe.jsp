<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/31
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人中心</title>
    <%@ include file="head.jsp" %>
    <link href="/resources/main/css/MyCyp.css" rel="stylesheet">
</head>
<body>
<%@ include file="nav.jsp" %>
<div class="w1200 mauto" style="z-index: 1000" id="app" v-clock>
    <div class="mt25 clearfix">
        <%@ include file="personal_nav.jsp"%>
        <div class="fr w1060">
            <div class="bbs1b h41 pr" style="font-size: 16px;font-weight: bold">
                密码修改
            </div>
            <div class="pr10 pl10 pt25">
                <el-alert title="帐号帐号密码为注册手机号后4位，为保障账户的安全，请及时修改密码。"type="info" style="margin: 10px 0px;"></el-alert>
                <el-form ref="form1" :model="form1" label-width="100px" label-position="left">
                    <el-form-item label="注册手机号">
                        <el-input v-model="form1.phone" style="width: 250px;" maxlength="11" disabled></el-input>
                        <el-button type="text" style="color: #999">手机号已经不使用了</el-button>
                    </el-form-item>
                    <el-form-item label="验证码">
                        <el-input v-model="form1.verifyCode" style="width: 100px;" maxlength="6"></el-input>
                        <el-button type="primary" style="width: 147px" @click="sendVerifyCode">{{text}}</el-button>
                    </el-form-item>
                    <el-form-item label="新密码">
                        <el-input v-model="form1.pass" type="password" style="width: 250px;" maxlength="40"></el-input>
                    </el-form-item>
                    <el-form-item >
                        <el-button type="success" style="width: 147px" @click="submit">确认修改</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
<script type="text/javascript">


    var vm = new Vue({
        el: "#app",
        data: {
            time:-1,
            form1:{
                phone:'${userInfo.phone}',
                verifyCode:'',
                pass:''
            }
        },
        methods: {
            sendVerifyCode(){
                if(this.time>0)return ;
                $.getJSON('/auction/send/sms/'+this.form1.phone,d=>{
                    if(d.status==200){
                        vm.success(d.message);
                        vm.time = 120;
                        vm.timer();
                    } else {
                        vm.error(d.message);
                    }
                })
            }, timer() {
                if (this.time > 0) {
                    this.time = this.time - 1
                    setTimeout(this.timer, 1000)
                }
            }, success (msg) {
                this.$message({message: msg, type: 'success'});
            }, error (msg) {
                this.$message.error(msg);
            }, submit(){
                if(!this.form1.verifyCode){
                    this.error('请输入验证码');
                    return false;
                }
                if(!this.form1.pass){
                    this.error('请输入新密码');
                    return false;
                }
                $.post('/auction/change/pass',this.form1,d=>{
                    if(d.status==200){
                        this.success('密码修改成功');
                        this.form1.pass='';
                        this.form1.verifyCode='';
                        this.time = -1;
                    }else{
                        this.error(d.message);
                    }
                },'JSON')
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
