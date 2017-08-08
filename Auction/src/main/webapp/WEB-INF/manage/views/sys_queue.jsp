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
    <title>通道队列</title>
    <link href="https://cdn.bootcss.com/element-ui/1.3.7/theme-default/index.css" rel="stylesheet">
    <link href="/resources/css/app.css" rel="stylesheet">
    <link href="/resources/css/iconfont.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.3.4/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/element-ui/1.3.7/index.js"></script>

</head>
<body>
<div id="app" class="wrapper">
    <%@ include file="../navbar.jsp" %>
    <%@ include file="../slider.jsp" %>
    <div class="content" v-cloak>
        <transition name="slide-fade">
            <div class="list" v-show="handle=='list'">
                <div class="row blockquote">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item><a @click="handle='list'">通道队列</a></el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <div class="row">

                </div>
                <div class="row">

                        <el-button type="info" @click="refrush"><i class="iconfont icon-shuaxin"></i>刷新</el-button>

                </div>
                <div class="row">
                    <el-table :data="list" highlight-current-row
                              v-loading="loading"
                              element-loading-text="拼命加载中"
                              style="width: 100%" height="500">
                        <el-table-column prop="name" label="通道名称" width="200"></el-table-column>
                        <el-table-column prop="chKey" label="通道" width="200"></el-table-column>
                        <el-table-column prop="length" label="当前数量" width="200"></el-table-column>
                        <el-table-column prop="status" label="操作">
                            <template scope="scope">
                                <el-button
                                        size="small"
                                        @click="handleLook(scope.row)">
                                    <i class="el-icon-search"></i>
                                    查看车辆
                                </el-button>
                                <el-button
                                        size="small"
                                        type="info" icon="icon-add1"
                                        @click="handleAdd(scope.row)">
                                    <i class="iconfont icon-add1"></i>
                                    添加车辆
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </div>

            </div>
        </transition>
        <transition name="slide-fade">
            <div class="handel" v-show="handle!='list'">
                <div class="row blockquote">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item><a @click="handle='list'">通道队列</a></el-breadcrumb-item>
                        <el-breadcrumb-item>{{title}}</el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <div class="row">
                    <el-row type="flex" justify="start">
                        <el-col>
                            <el-card class="box-card" style="width: 1100px"
                                     element-loading-text="拼命加载中">
                                <div class="row">
                                <el-table :data="pageInfo.list" highlight-current-row
                                          v-loading="loading" @selection-change="handleSelectionChange"
                                          element-loading-text="拼命加载中"
                                          style="width: 100%" height="300">
                                    <el-table-column type="selection" width="55">
                                    </el-table-column>
                                    <el-table-column prop="id" label="ID"width="80"></el-table-column>
                                    <el-table-column prop="picMain" label="图片"width="100">
                                        <template scope="scope">
                                            <img :src="scope.row.picMain" height="50" width="50" style="margin: 10px 0px;">
                                        </template>
                                    </el-table-column>
                                    <el-table-column prop="modelName" label="车型名称"width="250"></el-table-column>
                                    <el-table-column prop="carNum" label="牌照号码"width="120"></el-table-column>
                                    <el-table-column prop="userName" label="检测员"width="120"></el-table-column>
                                    <el-table-column prop="userPhone" label="联系电话"width="140"></el-table-column>
                                    <el-table-column prop="companyName" label="所属商户"></el-table-column>
                                </el-table>
                                </div>
                                <%--分页--%>
                                <div class="row pagination">
                                    <el-pagination
                                            @current-change="handleCurrentChange"
                                            :current-page.sync="pageInfo.pageNum"
                                            :page-size="pageInfo.pageSize"
                                            layout="total, prev, pager, next"
                                            :total="pageInfo.total">
                                    </el-pagination>
                                </div>
                                <div class="row">
                                    <el-form :model="form" :rules="rules"
                                             ref="form" label-width="100px" class="demo-ruleForm">
                                        <el-form-item label="已选车辆" prop="name">
                                            <el-input v-model="form.name" :disabled="true" type="textarea"></el-input>
                                        </el-form-item>
                                        <el-form-item label="时长" prop="time">
                                            <el-select v-model="form.time" placeholder="请选择">
                                                <el-option label="15分钟" value="15"></el-option>
                                                <el-option label="30分钟" value="30"></el-option>
                                                <el-option label="1小时" value="60"></el-option>
                                                <el-option label="24小时" value="1440"></el-option>
                                                <el-option label="48小时" value="2880"></el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form-item>
                                            <el-button type="primary" @click="submitForm">提交</el-button>
                                            <el-button type="warning" @click="handle='list'">取消</el-button>
                                        </el-form-item>
                                </div>
                            </el-card>
                        </el-col>
                    </el-row>
                </div>
            </div>
        </transition>
    </div>
</div>
</body>
<script>
    var VM = new Vue({
        el: "#app",
        data: {
            handle: 'list',
            dialogVisible: false,
            onRoutes: '${cur}',
            items:${menu},
            list: [],
            waitList: [],
            form:{
                ids:[],
                name:'',
                ch:'',
                time:''
            },rules:{
                name:[
                    {required: true, message: '请选择车辆'}
                ],time:[
                    {required: true, message: '请选择时长'}
                ]
            },
            searchForm:{
                searchFileds: {name: ''},
                pageIndex: 1,
                pageSize: 5
            },
            pageInfo:{},
            loading: true,
            title: ""
        }, methods: {
            handleCommand (command) {
                if (command == 'loginout') {
                    this.$confirm('确定要退出?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        $.getJSON("/system/logOff", function (d) {
                            if (d.status == 200) {
                                var date = new Date()
                                date.setTime(date.getTime() + 1 * 1000);//30min
                                $.cookie('token', null, {expires: date, path: '/'});
                                window.location.href = "/";
                            }
                        })
                    }).catch(() => {

                    });
                }
            }, handleSelect (href) {
                window.location.href = href;
            }, init () {
                $.post('/system/channel/queue/list', this.searchForm, function (d) {
                    if (d.status == 200) {
                        VM.list = d.data;
                    } else {
                        this.error(d.message);
                    }
                    VM.loading = false;
                }, "JSON")
            }, handleSelectionChange (val) {
                VM.form.ids = [];
                VM.form.name = '';
                $.each(val,(j,i)=>{
                    VM.form.ids.push(i.id);
                    VM.form.name += i.modelName +'/';
                })
            },handleCurrentChange (pageNum) {
                this.searchForm.pageIndex = pageNum;
                this.getWait();
            },handleLook (row) {
                this.title = row.name + "队列";
                this.handle = 'look';
                this.getChList(row.chkey);
            }, handleAdd (row) {
                this.title = row.name + "队列添加车辆";
                this.handle = 'look';
                this.loading = true;
                this.form.ch = row.chKey;
                this.getWait();

            }, getWait(){
                $.post('/system/check/wait/list',this.searchForm,(d)=>{
                    if(d){
                        VM.pageInfo = d.data;
                    }else{
                        VM.error(d.message);
                    }
                    VM.loading = false;
                },"JSON")
            },refrush () {
                this.searchForm = {
                    searchFileds: {username: '', phoneNum: ''},
                    pageIndex: 1,
                    pageSize: 10
                }
                this.loading = true;
                this.init();
            }, submitForm () {
                this.$refs['form'].validate(function(valid) {
                    if (valid) {
                        VM.loading = true;
                        var param = {};
                        param.carIds = VM.form.ids.join(",");
                        param.time = VM.form.time;
                        param.ch = VM.form.ch;
                        $.post('/system/channel/add',param,function(d){
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
            }, getChList(key){
                $.getJSON('/system/channel/queue/list/'+key,(d)=>{

                })
            }, success (msg) {
                this.$message({message: msg || '操作成功', type: 'success'});
            }, error (msg) {
                this.$message.error(msg);
            }, resetForm () {
                this.$refs["form"].resetFields();
            }
        }, mounted () {
            this.init();
        }
    })
</script>
</html>
