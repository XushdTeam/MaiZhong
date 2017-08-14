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

<div class="w1200 mauto" style="z-index: 1000"  id="app">
    <div class="place mt20"><a href=" ">个人中心</a> &gt;&gt;&nbsp;<span class="c9" id="YeQianSan">基本信息</span></div>
    <div class="mt25 clearfix">
        <div class="fl w130 bgf8">
            <div class="pl30 pb15 pt15">
                <h3 class="fs14 c3 lh27">交易中心</h3>
                <ul class="fs12 newsubnav">
                    <li id="ConfirmOrderList"><span @click="mylist" style="cursor: hand">成交确认</span></li>
                    <li id="OrderList"><span @click="orderList" style="cursor: hand">订单车辆</span></li>
                    <li id="HistoryAuctionCarList"><span @click="bidRecordList" style="cursor: hand">历史订单</span></li>
                    <li id="CarList"><span @click="likeCarList" style="cursor: hand">关注车辆</span></li>
                </ul>
                <h3 class="fs14 c3 lh27 mt20">个人设置</h3>
                <ul class="fs12 newsubnav">
                    <li id="Account"><span @click="personal" style="cursor: hand">基本信息</span></li>
                    <li id="EditPwd"><span @click="changePassword" style="cursor: hand">修改密码</span></li>
                    <li id="Message"><span @click="yijian" style="cursor: hand">投诉建议</span></li>
                </ul>
            </div>
        </div>

        <div class="fr w1060">
            <div class="infor">
                <h2><span></span>修改密码</h2>
                <div class="infor_coms">
                    <div class="infor_pass">
                        <label>输入旧密码：</label>
                        <input type="password" v-model="form1.pass" placeholder="请输入旧密码">
                    </div>
                    <div class="infor_pass">
                        <label>输入新密码：</label>
                        <input type="password"  v-model="form1.newPass" placeholder="请输入新密码">
                    </div>

                    <div class="infor_pass">
                        <label>确认新密码：</label>
                        <input type="password"  v-model="form1.reNewPass" placeholder="确认新密码">
                    </div>
                    <button class="buts" @click="submit">确定提交</button>
                </div>
            </div>
        </div>

    </div>

</div>

<%@ include file="footer.jsp"%>


<script type="text/javascript" src="/resources/script/sha256.js"></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            form1:{
                pass:'',
                newPass:'',
                reNewPass:''
            },userInfo:{n1:0,n4:0,freeze:0,n3:0,n2:0}
        },
        methods:{
            submit:function(){
                if(!this.form1.pass){
                    this.error("请输入原密码！");
                    return ;
                }
                if(!this.form1.newPass){
                    this.error("请输入新密码");
                    return ;
                }
                if(this.form1.newPass.length<6){
                    this.error("密码不能少于6位");
                    return ;
                }
                if(!this.form1.reNewPass){
                    this.error("请重复新密码");
                    return ;
                }
                if(this.form1.reNewPass!=this.form1.newPass){
                    this.error("两次密码不一致");
                    return ;
                }
                this.form1.pass = sha256.digest(this.form1.pass);
                this.form1.newPass = sha256.digest(this.form1.newPass);
                this.form1.reNewPass = sha256.digest(this.form1.reNewPass);
                /*修改密码*/
                $.post('/login/pass',this.form1,(d)=>{
                    if(d.status==200){
                        console.log("000找回密码000")
                    }else{
                        vm.error(d.message);
                    }
                },'JSON')
            },error (msg) {
                this.$message.error(msg);
            },
            changePassword: function () {
                window.location.href = '/auction/personal/changePass';
            },mylist: function () {
                window.location.href = '/auction/personal/mylist';
            },orderList: function () {
                window.location.href = '/auction/personal/orderList';
            },bidRecordList: function () {
                window.location.href = '/auction/personal/bidRecordList';
            },likeCarList: function () {
                window.location.href = '/auction/personal/likeCarList';
            },personal:function () {
                window.location.href = '/personal';
            },yijian:function () {
                window.location.href = '/auction/personal/myyijian';
            }
        },computed:{

        }
    })

</script>

</body>
</html>
