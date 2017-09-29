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
    <style>
        .btn_my{
            border: 1px solid #f60;
            color: #f60;
            height: 35px;
            line-height: 35px;
            border-radius: 9px;
            float: right;
            padding: 0px 10px;
            margin-right: 480px;
            cursor: pointer;
            font-size: 14px;
            margin-top: 3px;
        }
    </style>
</head>
<body>
<%@ include file="nav.jsp" %>

<div class="w1200 mauto" style="z-index: 1000" id="app">
    <div class="place mt20"><a href=" ">个人中心</a> &gt;&gt;&nbsp;<span class="c9" id="YeQianSan">基本信息<span></div>
    <div class="mt25 clearfix">
        <%@ include file="personal_nav.jsp" %>
        <div class="fr w1060">
            <div class="infor">
                <h2><span></span>基本信息</h2>
                <p>用户名称：${userInfo.name}</p>
                <c:if test="${userInfo.level==0}">
                    <p>商户级别：普通用户</p>
                </c:if>
                <c:if test="${userInfo.level==1}">
                    <p>商户级别：银牌用户</p>
                </c:if>
                <c:if test="${userInfo.level==2}">
                    <p>商户级别：金牌用户</p>
                </c:if>
                <c:if test="${userInfo.level==3}">
                    <p>商户级别：钻石用户</p>
                </c:if>
                <p>注册手机：${userInfo.phone}</p>
                <p>用户编号：${userInfo.id}</p>
                <p>经营所在地：{{cityName}} </p>

                <div v-show="select_tag" style="text-align: center;">
                    <el-select v-model="cityName" placeholder="请选择" >
                        <el-option
                                v-for="item in citys"
                                :label="item.text"
                                :value="item.text">
                        </el-option>
                    </el-select>
                    <el-button type="info" style="margin-left: 10px;" @click="submitChange">修改</el-button>
                    <el-button type="warning" @click="select_tag=!1">取消</el-button>
                </div>
                <div v-show="!select_tag" class="lay" @click="select_tag=1"  >更改经营所在地</div>
            </div>

            <div class="infor">
                <h2><span></span>实名认证</h2>

                <div class="one" v-if="status==1">
                    <p class="head">您以实名认证成功</p>
                    <div class="infor_com">
                        <div class="infor_div">姓名：${userInfo.name}</div>
                        <div class="infor_div">身份证号：${userInfo.idNum}</div>
                        <div class="infor_div">手机号：${userInfo.phone}</div>
                    </div>
                </div>

                <div class="one" v-if="status==9">
                    <p class="head" style="color: #F44336">未实名认证
                        <span class="btn_my" @click="dialogVisible=1">去认证</span>
                    </p>
                </div>

                <div class="one" v-if="status==2">
                    <p class="head" style="color: #FF6600">认证中，请等待
                        <%--<span class="btn_my" @click="dialogVisible=1">去认证</span>--%>
                    </p>
                </div>

                <div class="one" v-if="status==5">
                    <p class="head" style="color: #F44336">认证不通过
                        <span class="btn_my" @click="dialogVisible=1">重新认证</span>
                    </p>
                </div>


            </div>
        </div>
    </div>
    <%--实名认证--%>
    <el-dialog title="实名认证" v-model="dialogVisible" size="large">
        <div class="two" style="margin-bottom: 200px;">
            <div class="infor_com" style="margin: 0px">
                <div class="infor_div" style="margin-left: 0px">
                    <label>姓 &nbsp;  &nbsp; &nbsp; &nbsp;名：</label>
                    <input type="text" v-model="form.name" placeholder="请输入姓名">
                </div>
                <div class="infor_div" style="margin-left: 0px">
                    <label>身份证号：</label>
                    <input type="text" v-model="form.idNum" placeholder="请输入身份证号">
                </div>
                <div class="infor_div" style="clear: both;margin-left: 0px;height: 10px;"></div>
                <div class="img" style="float: left;margin-left: 40px;">
                    <el-upload
                            class="avatar-uploader"
                            action="/personal/img/upload"
                            :show-file-list="false"
                            :on-success="handleAvatarScucess1"
                            :before-upload="beforeAvatarUpload">
                        <img v-if="form.img1" :src="form.img1" width="300px" height="180px">
                        <img v-else src="/resources/main/img/image.png" width="300px" height="180px">
                        <p>身份证正面照</p>
                    </el-upload>
                </div>

                <div class="img" style="float: left;margin-left: 40px;">
                    <el-upload
                            class="avatar-uploader"
                            action="/personal/img/upload"
                            :show-file-list="false"
                            :on-success="handleAvatarScucess2"
                            :before-upload="beforeAvatarUpload">
                        <img v-if="form.img2" :src="form.img2" width="300px" height="180px">
                        <img v-else src="/resources/main/img/image.png" width="300px" height="180px">
                        <p>身份证反面照</p>
                    </el-upload>
                </div>

                <div class="img" style="float: left;margin-left: 30px;">
                    <el-upload
                            class="avatar-uploader"
                            action="/personal/img/upload"
                            :show-file-list="false"
                            :on-success="handleAvatarScucess3"
                            :before-upload="beforeAvatarUpload">
                        <img v-if="form.img3" :src="form.img3" width="300px" height="180px">
                        <img v-else src="/resources/main/img/image.png" width="300px" height="180px">
                        <p>手持身份证半身照</p>
                    </el-upload>
                </div>
            </div>
        </div>
        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="submit_rz">确 定</el-button>
          </span>
    </el-dialog>
</div>

<%@ include file="footer.jsp"%>
</body>
<script type="text/javascript">
    var vm = new Vue({
        el:'#app',
        data:{
            cityName:'${userInfo.city}',
            select_tag:!1,
            dialogVisible:0,
            status:'${userInfo.status}',
            citys:[],
            form:{
                name:'',
                idNum:'',
                img1:'',
                img2:'',
                img3:''
            }
        },
        methods:{
            getCity(){
                $.getJSON('/resources/data/city.json',(d)=>{
                    this.citys = d;
                })
            },submitChange(){
                $.post('/auction/persional/change/city',{city:this.cityName},(d)=>{
                    if(d.status==200){
                        this.success('修改成功');
                    }else{
                        this.error(d.message);
                    }
                    this.select_tag = !1;
                },'JSON');
            },gotoRz(){

            },success (msg) {
                this.$message({message: msg, type: 'success'});
            },error (msg) {
                this.$message.error(msg);
            },handleAvatarScucess1(res, file) {
               if(res.status==200)this.form.img1 = res.data;
               else this.error(res.message);
            },handleAvatarScucess2(res, file) {
                if(res.status==200)this.form.img2 = res.data;
                else this.error(res.message);
            },handleAvatarScucess3(res, file) {
                if(res.status==200)this.form.img3 = res.data;
                else this.error(res.message);
            },beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;
                if (!isJPG) {
                    this.$message.error('图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            },submit_rz(){
                if(!this.form.name) {
                    this.error('请输入姓名')
                    return false;
                }
                if(!this.form.idNum) {
                    this.error('请输入身份证号')
                    return false;
                }
                if(!(/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/.test(this.form.idNum))) {
                    this.error('请输入正确的身份证');
                    return false;
                }
                if(!this.form.img1) {
                    this.error('请上传身份证正面');
                    return false;
                }

                if(!this.form.img2) {
                    this.error('请上传身份证反面')
                    return false;
                }

                if(!this.form.img3) {
                    this.error('请上传手持身份证头部照片')
                    return false;
                }

                $.post('/auction/personal/rz/submit',this.form,(d)=>{
                    if(d.status==200){
                        vm.success('提交成功，等待审核');
                        vm.status = 2;
                    }else{
                        vm.error(d.message);
                    }
                },"JSON")
            }
        },
        mounted(){
            this.getCity();
        }
    })
</script>
</html>
