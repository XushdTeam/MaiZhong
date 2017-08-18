<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/20
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>拍卖端用户管理</title>
    <link href="https://cdn.bootcss.com/element-ui/1.3.7/theme-default/index.css" rel="stylesheet">
    <link href="/resources/css/app.css" rel="stylesheet">
    <link href="/resources/css/iconfont.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.3.4/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/element-ui/1.3.7/index.js"></script>
    <style>
        .el-input-number__decrease, .el-input-number__increase {
            height: auto;
            border-left: 1px solid #bfcbd9;
            width: 36px;
            line-height: 34px;
            top: 1px;
            text-align: center;
            color: #97a8be;
            cursor: pointer;
            position: absolute;
            z-index: 1;
            height: 25px;
            overflow: hidden;
            padding-top: 10px;
        }
    </style>
</head>
<body>
<div id="app" class="wrapper" >
    <%@ include file="../navbar.jsp"%>
    <%@ include file="../slider.jsp"%>
    <div class="content" v-cloak>
        <transition name="slide-fade">
            <div class="list" v-show="handle=='list'">
                <div class="row blockquote">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item><a @click="handle='list'">拍卖端用户</a></el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <div class="row">
                    <el-row type="flex" justify="start">
                        <el-col :span="24">
                            <el-form :inline="true">
                                <el-form-item >
                                    <el-input v-model="searchForm.searchFileds.name" placeholder="用户名" >
                                        <template slot="prepend">用户名</template>
                                    </el-input>
                                </el-form-item>
                                <el-form-item >
                                    <el-input v-model="searchForm.searchFileds.phone" placeholder="手机号" >
                                        <template slot="prepend">手机号</template>
                                    </el-input>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" @click="init">查询</el-button>
                                </el-form-item>
                            </el-form>
                        </el-col>
                    </el-row>
                </div>
                <div class="row">
                    <el-button-group>
                        <el-button type="info" @click="refrush"><i class="iconfont icon-shuaxin"></i>刷新</el-button>
                    </el-button-group>
                </div>
                <div class="row">
                    <el-table :data="pageInfo.list" highlight-current-row
                              v-loading="loading"
                              element-loading-text="拼命加载中"
                              style="width: 100%" height="500">
                        <el-table-column prop="id" label="ID"width="80"></el-table-column>
                        <el-table-column prop="name" label="用户名"width="150"></el-table-column>
                        <el-table-column prop="headImg" label="头像"width="100">
                            <template scope="scope">
                                <img :src="scope.row.headImg" height="50" width="50" style="margin: 10px 0px;">
                            </template>
                        </el-table-column>
                        <el-table-column prop="phone" label="手机号"width="150"></el-table-column>
                        <el-table-column prop="city" label="城市" width="150"></el-table-column>
                        <el-table-column prop="type" label="类型" width="100">
                            <template scope="scope">
                                <el-tag v-show="scope.row.type==1">个人</el-tag>
                                <el-tag v-show="scope.row.type==2">企业</el-tag>
                            </template>
                        </el-table-column>
                        <el-table-column prop="bzj" label="保证金" width="100"></el-table-column>
                        <el-table-column prop="status" label="状态"width="200">
                            <template scope="scope">
                               <el-tag v-if="scope.row.status==0">不可用</el-tag>
                               <el-tag v-if="scope.row.status==1" type="success">认证通过</el-tag>
                               <el-tag v-if="scope.row.status==2" type="warning">等待认证</el-tag>
                               <el-tag v-if="scope.row.status==5" type="danger">未通过认证</el-tag>
                               <el-tag v-if="scope.row.status==9" type="danger">未实名认证</el-tag>
                            </template>
                        </el-table-column>
                        <el-table-column prop="status" label="操作">
                            <template scope="scope">

                                <el-button size="small" icon="plus" type="warning" v-show="scope.row.status==1"
                                    @click="addBzj(scope.row)">
                                    充值保证金
                                </el-button>
                                <el-button v-show="scope.row.status==2" size="small" icon="check" type="success"
                                           @click="gotorz(scope.row)">去认证
                                </el-button>
                                <el-button v-show="scope.row.status==1" size="small" icon="warning" type="success"
                                           @click="lookrz(scope.row)">查看认证信息
                                </el-button>
                                <el-button size="small"   v-show="scope.row.status==1"
                                           @click="stop(scope.row)">
                                    停用
                                </el-button>
                                <el-button size="small"   v-show="scope.row.status==0"
                                           @click="start(scope.row)">
                                    启用
                                </el-button>
                                <el-button size="small" icon="delete"
                                        type="danger" @click="del(scope.row)">删除
                                </el-button>

                            </template>
                        </el-table-column>
                    </el-table>
                </div>
                <div class="row pagination">
                    <el-pagination
                            @current-change="handleCurrentChange"
                            :current-page.sync="pageInfo.pageNum"
                            :page-size="pageInfo.pageSize"
                            layout="total, prev, pager, next"
                            :total="pageInfo.total">
                    </el-pagination>
                </div>
            </div>
        </transition>
        <transition name="slide-fade">
            <div class="handel" v-show="handle!='list'">
                <div class="row blockquote">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item><a @click="handle='list'">拍卖端用户</a></el-breadcrumb-item>
                        <el-breadcrumb-item v-show="handle=='gotorz'">实名认证</el-breadcrumb-item>
                        <el-breadcrumb-item v-show="handle=='lookrz'">认证信息</el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <div class="row">
                    <el-row type="flex" justify="start">
                        <el-col>
                            <el-card class="box-card" style="width: 500px"  v-loading="loading" element-loading-text="拼命加载中">
                                <el-form label-width="100px" class="demo-ruleForm">
                                    <el-form-item label="真实姓名">
                                        <el-input v-model="curRow.name" :disabled="true"></el-input>
                                    </el-form-item>
                                    <el-form-item label="身份证号">
                                        <el-input v-model="curRow.idNum" :disabled="true"></el-input>
                                    </el-form-item>
                                    <el-form-item label="身份证正面">
                                        <a href="javascript:;" @click="imgView(curRow.pic1)"><img :src="curRow.pic1" style="width: 200px"></a>
                                    </el-form-item>
                                    <el-form-item label="身份证反面">
                                        <a href="javascript:;" @click="imgView(curRow.pic2)"><img :src="curRow.pic2" style="width: 200px"></a>
                                    </el-form-item>
                                    <el-form-item label="手持身份证">
                                        <a href="javascript:;" @click="imgView(curRow.pic3)"><img :src="curRow.pic3" style="width: 200px"></a>
                                    </el-form-item>
                                    <el-form-item v-show="handle=='gotorz'">
                                        <el-button type="success" icon="check" @click="rztg">通过</el-button>
                                        <el-button type="danger" icon="close" @click="reject">驳回</el-button>
                                        <el-button type="warning" @click="handle='list'">返回</el-button>
                                    </el-form-item>
                                </el-form>
                            </el-card>
                        </el-col>
                    </el-row>
                </div>
            </div>
        </transition>
        <el-dialog title="充值保证金" v-model="bzjDialog" size="tiny">
            <el-form>
                <el-form-item label="充值金额" label-width="100">
                    <el-input-number v-model="bzj" :step="1000" :min="1000"></el-input-number>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="bzjDialog = false">取 消</el-button>
                <el-button type="primary" @click="plusConfirm">确 定</el-button>
            </div>
        </el-dialog>
        <%--图片预览--%>
        <el-dialog v-model="dialogImgVisible" size="tiny">
            <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>

    </div>
</div>
</body>
<script>
    var VM = new Vue({
        el:"#app",
        data:{
            handle:'list',
            dialogVisible:false,
            onRoutes:'${cur}',
            items:${menu},
            pageInfo:{},
            searchForm:{
                searchFileds:{name: '',phone:''},
                pageIndex:1,
                pageSize:5
            },
            bzjDialog:false,
            bzj:'',
            curId:'',
            loading:true,
            dialogImgVisible:false,
            dialogImageUrl:'',
            curRow:{}
        },methods:{
            handleCommand (command) {
                if(command == 'loginout'){
                    this.$confirm('确定要退出?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        $.getJSON("/system/logOff",function(d){
                            if(d.status==200){
                                var date = new Date()
                                date.setTime(date.getTime()+1*1000);//30min
                                $.cookie('token', null, { expires: date, path: '/' });
                                window.location.href = "/";
                            }
                        })
                    }).catch(() => {

                    });
                }
            },handleSelect (href) {
                window.location.href = href;
            },init () {
                $.post('/system/company/user/list',this.searchForm,function(d){
                    if(d.status==200){
                        VM.pageInfo = d.data;
                    }else{
                        this.error(d.message);
                    }
                    VM.loading = false;
                },"JSON")
            },handleCurrentChange (pageNum) {
                this.searchForm.pageIndex = pageNum;
                this.init();

            },del (row) {
                this.confirm('确定删除 '+row.name+' ？',()=>{
                    VM.loading = true;
                    $.getJSON('/system/company/user/del/'+row.id,(d)=>{
                        if(d.status==200){
                            VM.success();
                            VM.refrush();
                        }else{
                            VM.error(d.message);
                        }
                        VM.loading = false;
                    })
                })

            },addBzj (row) {
                this.curId = row.id;
                this.bzjDialog = true;

            },gotorz (row) {
                this.curRow = row;
                this.handle = "gotorz";


            },lookrz (row) {
                this.curRow = row;
                this.handle = 'lookrz';
            },plusConfirm () {
                this.bzjDialog = false;
                this.loading = true;
                $.getJSON('/system/company/user/add/'+this.curId+'/'+this.bzj,(d)=>{
                    if(d.status==200){
                        VM.success();
                        VM.refrush();
                    }else{
                        VM.error(d.message);
                    }
                    VM.loading = false;
                })

            },rztg () {
                this.loading = true;
                $.getJSON('/system/company/user/status/'+this.curRow.id+'/'+1,(d)=>{
                    if(d.status==200){
                        VM.success();
                        VM.handle = 'list';
                        VM.refrush();
                    }else{
                        VM.error(d.message);
                    }
                    VM.loading = false;
                })
            },reject () {
                this.loading = true;
                $.getJSON('/system/company/user/status/'+this.curRow.id+'/'+5,(d)=>{
                    if(d.status==200){
                        VM.success();
                        VM.handle = 'list';
                        VM.refrush();
                    }else{
                        VM.error(d.message);
                    }
                    VM.loading = false;
                })
            },stop(row){
                $.getJSON('/system/company/user/status/'+row.id+'/'+0,(d)=>{
                    if(d.status==200){
                        VM.success();
                        VM.handle = 'list';
                        VM.refrush();
                    }else{
                        VM.error(d.message);
                    }
                    VM.loading = false;
                })
            },start(row){
                $.getJSON('/system/company/user/status/'+row.id+'/'+1,(d)=>{
                    if(d.status==200){
                        VM.success();
                        VM.handle = 'list';
                        VM.refrush();
                    }else{
                        VM.error(d.message);
                    }
                    VM.loading = false;
                })
            },refrush () {
                this.searchForm= {
                    searchFileds:{username: '',phoneNum:'',companyId:""},
                    pageIndex:1,
                    pageSize:5
                }
                this.loading = true;
                this.init();

            },imgView (url) {

                this.dialogImageUrl = url;
                this.dialogImgVisible = true;
            },success (msg) {
                this.$message({message: msg||'操作成功',type: 'success'});
            },error (msg) {
                this.$message.error(msg);
            },resetForm () {
                this.$refs["form"].resetFields();
            },confirm(text,cb){
                this.$confirm(text, '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    cb();
                }).catch(() => {

                });
            }
        },mounted () {
            this.init();
        }
    })
</script>
</html>

