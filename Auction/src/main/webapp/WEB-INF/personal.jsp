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
    <style>
        .cz_tag{
            float: right;
            margin-right: 10px;
            font-size: 14px;
            color: #F60;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@ include file="nav.jsp" %>
<div class="w1200 mauto" style="z-index: 1000" id="app" v-clock>

    <div class="mt25 clearfix">
        <%@ include file="personal_nav.jsp"%>
        <div class="fr w1060">
            <div class=" pt15 pb15 pl20 clearfix">
                <dl class="userpho fl">
                    <dt>
                        <el-upload v-loading="loading"
                                class="avatar-uploader"
                                action="/auction/personal/headImg" :with-credentials="true"
                                :show-file-list="false"
                                :on-success="handleAvatarScucess"
                                :before-upload="beforeAvatarUpload">
                            <img v-if="headImg" :src="headImg" title="点击修改头像" class="photo">
                            <img v-else src="/resources/main2/512.png" title="点击修改头像" class="photo" >
                            <p>手持身份证半身照</p>
                        </el-upload>

                    </dt>
                    <dd>
                        <p class="name fs16 c3 mt10">${userInfo.name}</p>
                        <c:if test="${userInfo.level==0}">
                        <p class="mt5">
                            <img src="resources/main/img/VP.gif" alt="普通用户" class="vm">
                            <span class="vm ml5 fs12 c3">普通用户</span>
                        </p>
                        </c:if>
                        <c:if test="${userInfo.level==1}">
                            <p class="mt5">
                                <img src="resources/main/img/VP.gif" alt="银牌用户" class="vm">
                                <span class="vm ml5 fs12 c3">金牌用户</span>
                            </p>
                        </c:if>
                        <c:if test="${userInfo.level==2}">
                            <p class="mt5">
                                <img src="resources/main/img/VP.gif" alt="金牌用户" class="vm">
                                <span class="vm ml5 fs12 c3">金牌用户</span>
                            </p>
                        </c:if>
                        <c:if test="${userInfo.level==3}">
                            <p class="mt5">
                                <img src="resources/main/img/VP.gif" alt="钻石用户" class="vm">
                                <span class="vm ml5 fs12 c3">钻石用户</span>
                            </p>
                        </c:if>
                        <c:if test="${userInfo.status==0}"><p class="mt5 fs12 ">用户锁定</p></c:if>
                        <c:if test="${userInfo.status==1}"><p class="mt5 fs12 ">已实名认证</p></c:if>
                        <c:if test="${userInfo.status==2}"><p class="mt5 fs12 ">等待认证</p></c:if>
                        <c:if test="${userInfo.status==5}"><p class="mt5 fs12 ">未通过实名认证</p></c:if>
                        <c:if test="${userInfo.status==9}"><p class="mt5 fs12 ">未实名认证</p></c:if>
                        <c:if test="${userInfo.status==-1}"><p class="mt5 fs12 ">未实名认证</p></c:if>
                    </dd>
                </dl>
                <ul class="usertra fr">
                    <li class="tra1 cursor">成交确认<span class="ccheng ml5" id="sureCarnum">{{userInfo.n1}}</span></li>
                    <li class="tra2 cursor">待付款<span class="ccheng ml5" id="nopaymentnum">{{userInfo.n2}}</span></li>
                    <li class="tra3 cursor">交付中<span class="ccheng ml5" id="deliverying">{{userInfo.n3}}</span></li>
                    <li class="tra4 cursor">交易完成<span class="ccheng ml5" id="dealClose">{{userInfo.n4}}</span></li>
                </ul>
            </div>
            <div class="newtit fs20 c3 mt25"><span class="newtit-tex">资产信息</span></div>

            <div class="mt15 clearfix assetsinfo">
                <div>
                    <p class="tit">保证金<span class="cz_tag" @click="dialogVisible=1">去充值</span></p>
                    <div class="pl25 pr25 pt25">
                        <table width="100%">
                            <tbody>
                            <tr>
                                <td>总额：</td>
                                <td align="right">${userInfo.bzj}元</td>
                            </tr>
                            <tr>
                                <td>余额：</td>
                                <td align="right">{{yue}}元</td>
                            </tr>
                            <tr>
                                <td>冻结：</td>
                                <td align="right">{{userInfo.freeze}}元</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>


    <el-dialog title="提示" v-model="dialogVisible" size="tiny">
        <span>为保障用户资金的安全性，本平台的所有资金缴纳、充值都为线下操作，详细联系客服 010-8025-8108，感谢您的支持。</span>
        <span slot="footer" class="dialog-footer">
        </span>
    </el-dialog>

</div>

<%@ include file="footer.jsp" %>



<script type="text/javascript">


    var vm = new Vue({
        el: "#app",
        data: {userInfo:{n1:0,n4:0,freeze:0,n3:0,n2:0},dialogVisible:!1,headImg:'${userInfo.headImg}',loading:!1},
        mounted: function () {
            $.getJSON('/auction/personalInfo', function (param) {
               vm.userInfo=param.data
            })
        },
        methods: {
            handleAvatarScucess(res, file) {
                this.loading=!1;
                if(res.status==200)this.headImg = res.data;
                else this.error(res.message);
            },beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;
                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                if(isJPG && isLt2M){
                    this.loading=1;
                    return true;
                }
                return false;
            }
        },computed:{
            yue:function () {
                var  num= ${userInfo.bzj} - this.userInfo.freeze
                return num
            }
        }
    })



</script>
</body>
</html>
