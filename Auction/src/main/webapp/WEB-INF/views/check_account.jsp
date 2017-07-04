<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/4
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检测端用户管理</title>
    <link href="https://cdn.bootcss.com/element-ui/1.3.7/theme-default/index.css" rel="stylesheet">
    <link href="/resources/css/app.css" rel="stylesheet">
    <link href="/resources/css/iconfont.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.3.4/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/element-ui/1.3.7/index.js"></script>

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
                        <el-breadcrumb-item><a @click="handle='list'">检测端用户</a></el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <div class="row">
                    <el-row type="flex" justify="start">
                        <el-col :span="24">
                            <el-form :inline="true">
                                <el-form-item >
                                    <el-input v-model="searchForm.searchFileds.username" placeholder="用户名" >
                                        <template slot="prepend">用户名</template>
                                    </el-input>
                                </el-form-item>
                                <el-form-item >
                                    <el-input v-model="searchForm.searchFileds.phoneNum" placeholder="手机号" >
                                        <template slot="prepend">手机号</template>
                                    </el-input>
                                </el-form-item>
                                <el-form-item >
                                    <el-select v-model="searchForm.searchFileds.companyId" placeholder="请选择">
                                        <el-option label="全部" value=""></el-option>
                                        <el-option
                                                v-for="item in companys":key="item.id"
                                                :label="item.name"
                                                :value="item.id">
                                        </el-option>
                                    </el-select>
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
                        <el-button type="info" @click="add"><i class="iconfont icon-add1"></i>添加</el-button>
                        <el-button type="info" @click="refrush"><i class="iconfont icon-shuaxin"></i>刷新</el-button>
                    </el-button-group>
                </div>
                <div class="row">
                    <el-table :data="pageInfo.list" highlight-current-row
                              v-loading="loading"
                              element-loading-text="拼命加载中"
                              style="width: 100%" height="500">
                        <el-table-column prop="id" label="ID"width="100"></el-table-column>
                        <el-table-column prop="userName" label="用户名"width="200"></el-table-column>
                        <el-table-column prop="userPhone" label="手机号"width="200"></el-table-column>
                        <el-table-column prop="companyName" label="商家"width="200"></el-table-column>
                        <el-table-column prop="status" label="状态"width="200">
                            <template scope="scope">
                                <a href="javascript:;" v-if="scope.row.status" @click="changeState(scope.$index,scope.row)"><el-tag  type="success">可用</el-tag></a>
                                <a href="javascript:;" v-else @click="changeState(scope.$index,scope.row)"><el-tag  type="danger">不可用</el-tag></a>
                            </template>
                        </el-table-column>
                        <el-table-column prop="status" label="操作">
                            <template scope="scope">
                            <el-button
                                    size="small" icon="edit"
                                    @click="handleEdit(scope.row)">编辑</el-button>
                            <el-button
                                    size="small"
                                    type="danger" icon="delete"
                                    @click="delConfim(scope.row)">删除</el-button>
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
                        <el-breadcrumb-item><a @click="handle='list'">检测端用户</a></el-breadcrumb-item>
                        <el-breadcrumb-item v-show="handle=='add'">添加</el-breadcrumb-item>
                        <el-breadcrumb-item v-show="handle=='edit'">编辑</el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <div class="row">
                    <el-row type="flex" justify="start">
                        <el-col>
                            <el-card class="box-card" style="width: 500px"  v-loading="loading" element-loading-text="拼命加载中">
                                <el-form label-position="left" :model="form" ref="form" :rules="rules" label-width="120px"
                                         class="demo-form-inline demo-ruleForm">
                                    <el-form-item label="用户名称" prop="userName">
                                        <el-input v-model="form.userName" style="width: 300px"></el-input>
                                    </el-form-item>
                                    <el-form-item label="手机号" prop="userPhone">
                                        <el-input v-model="form.userPhone" :maxlength='11' style="width: 300px"></el-input>
                                    </el-form-item>
                                    <el-form-item label="商家" prop="comanyId">
                                        <el-select v-model="form.comanyId" placeholder="请选择">
                                            <el-option
                                                    v-for="item in companys"
                                                    :label="item.name"
                                                    :value="''+item.id+''">
                                            </el-option>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item>
                                        <el-button type="primary" @click="submitForm">提交</el-button>
                                        <el-button @click="resetForm">重置</el-button>
                                        <el-button type="warning" @click="handle='list'">取消</el-button>
                                    </el-form-item>
                                </el-form>
                            </el-card>
                        </el-col>
                    </el-row>
                </div>
            </div>
            </transition>
            <el-dialog title="提示":visible.sync="dialogVisible"size="tiny">
                <span> {{confrimStr}} ？</span>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="handleConfrim()">确 定</el-button>
                </span>
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
            companys:${companys},
            pageInfo:{},
            searchForm:{
                searchFileds:{username: '',phoneNum:'',companyId:''},
                pageIndex:1,
                pageSize:10
            },
            form:{
                id:-1,
                userName:'',
                userPhone:'',
                comanyId:''
            },
            rules:{
                userName: [
                    { required: true,message: '请输入用户名称', trigger: 'blur' },
                    { max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
                ],userPhone:[
                    { required: true,message: '请输入手机号', trigger: 'blur'},
                    { max: 11,min:11, message: '长度为 11 个字符', trigger: 'blur' }
                ],comanyId:[
                    { required: true,message: '请选择车商', trigger: 'change' }
                ]
            },
            loading:true,
            confrimStr:'',
            cur_index:''
        },methods:{
            handleCommand (command) {
                if(command == 'loginout'){

                }
            },handleSelect (href) {
                window.location.href = href;
            },init () {
               $.post('/system/check/account/list',this.searchForm,function(d){
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

            },delConfim (row) {
                this.dialogVisible = true;
                this.confrimStr = "确认删除 "+row.userName+" ?";
                this.cur_index = row.id;

            },handleEdit (row) {

                this.form.id = row.id;
                this.form.userName = row.userName;
                this.form.userPhone = row.userPhone+'';
                this.form.comanyId = row.comanyId+'';
                this.handle = 'edit';

            },changeState (index,row) {
                this.loading = true;
                $.getJSON('/system/check/account/status/'+row.id+'/'+row.status,function(d){
                    if(d.status==200){
                        VM.pageInfo.list[index].status = row.status?0:1;
                    }else{
                        VM.error(d.message);
                    }
                    VM.loading = false;
                })

            },handleConfrim () {
                this.dialogVisible = false;
                $.getJSON('/system/check/account/del/'+this.cur_index,function(d){
                    if(d.status==200){
                        VM.success();
                        VM.refrush();
                    }else{
                        VM.error(d.message);
                    }
                });
            },add () {
                this.form.id = -1;
                this.resetForm();
                this.handle = 'add';
            },refrush () {
                this.searchForm= {
                    searchFileds:{username: '',phoneNum:'',companyId:""},
                    pageIndex:1,
                    pageSize:10
                }
                this.loading = true;
                this.init();

            },submitForm () {
                this.$refs['form'].validate(function(valid) {
                    if (valid) {
                        VM.loading = true;
                        $.post('/system/check/account/save',VM.form,function(d){
                            if(d.status==200){
                                VM.success(d.message);
                                VM.handle = "list";
                                VM.refrush();
                            }else{
                                VM.error(d.message);
                            }
                            VM.loading = false;
                        },"JSON")
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },success (msg) {
                this.$message({message: msg||'操作成功',type: 'success'});
            },error (msg) {
                this.$message.error(msg);
            },resetForm () {
                this.$refs["form"].resetFields();
            }
        },mounted () {
            this.init();
        }
    })
</script>
</html>
