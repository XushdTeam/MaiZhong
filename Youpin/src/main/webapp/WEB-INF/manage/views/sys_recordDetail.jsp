<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/4
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>车辆审核</title>
    <link href="https://cdn.bootcss.com/element-ui/1.3.7/theme-default/index.css" rel="stylesheet">
    <link href="/resources/css/app.css" rel="stylesheet">
    <link href="/resources/css/iconfont.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.3.4/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/element-ui/1.3.7/index.js"></script>
    <style>
        .el-upload-list--picture-card .el-upload-list__item-actions {
            opacity: 1;
        }

        .el-upload-list--picture-card .el-upload-list__item-actions span {
            display: inline-flex !important;
        }

        .el-form--inline2 {
            width: 1000px !important;
        }

        .w200 {
            width: 150px !important;
        }
    </style>
</head>
<body>
<div id="app" class="wrapper">
    <%@ include file="../navbar.jsp" %>
    <%@ include file="../slider.jsp" %>
    <div class="content" v-cloak>
        <transition name="slide-fade">
            <div class="handel">
                <div class="row blockquote">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item><a @click="handle='list'">订单管理</a></el-breadcrumb-item>
                        <el-breadcrumb-item v-show="handle=='look'">订单管理</el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <%--详细信息--%>
                <div class="row">

                    <div class="itembody">
                        <el-form :inline="true" label-width="200px" v-if="detail.user.id" class="el-form--inline2">

                            <el-form-item label="所在地">
                                <span>{{detail.record_info.cityName}}</span>
                            </el-form-item>
                            <el-form-item label="车型名称">
                                <span>{{detail.record_info.modelName}}</span>
                            </el-form-item>
                            <br>
                            <el-form-item label="颜色">
                                <span>{{detail.record_info.color}}</span>
                            </el-form-item>
                            <el-form-item label="行驶里程">
                                <span>{{detail.record_info.gls}}</span>
                            </el-form-item>
                            <br>
                            <el-form-item label="登记日期">
                                <span>{{detail.record_info.registTime}}</span>
                            </el-form-item>
                            <el-form-item label="过户次数">
                                <span>{{detail.record_info.gh}}</span>
                            </el-form-item>
                            <br>
                            <el-form-item label="最后一次过户时间">
                                <span>{{detail.record_info.ghtime}}</span>
                            </el-form-item>
                            <el-form-item label="交强险剩余时间">
                                <span>{{detail.record_info.jqx}}</span>
                            </el-form-item>
                            <br>
                            <el-form-item label="年检剩余时间">
                                <span>{{detail.record_info.nj}}</span>
                            </el-form-item>
                            <el-form-item label="排量">
                                <span>{{detail.record_info.liter}}</span>
                            </el-form-item>
                            <br>
                            <el-form-item label="排放标准">
                                <span>{{detail.record_info.pfbz}}</span>
                            </el-form-item>
                            <el-form-item label="使用性质">
                                <span>{{detail.record_info.xz}}</span>
                            </el-form-item>
                            <br>
                            <el-form-item label="使用方">
                                <span>{{detail.record_info.method}}</span>
                            </el-form-item>
                            <el-form-item label="车况">
                                <span>{{detail.record_info.ck}}</span>
                            </el-form-item>
                            <br>
                            <el-form-item label="客户称呼">
                                <span>{{detail.user.name}}</span>
                            </el-form-item>
                            <el-form-item label="联系方式">
                                <span>{{detail.user.phone}}</span>
                            </el-form-item>
                            <br>
                            <el-form-item label="所属公司">
                                <span>{{detail.company.name}}</span>
                            </el-form-item>
                            <c:if test="${guzhi!=null}">
                                <el-form-item label="系统预估" >
                                    <span>${guzhi.precisePrice}万元</span>
                                </el-form-item>
                            </c:if>
                            <c:if test="${error!=null}">
                                <el-form-item label="系统预估" >
                                    <span>${error}</span>
                                </el-form-item>
                            </c:if>
                            <el-form-item label="报价" v-show="detail.saleRecord.price">
                                <span>{{detail.saleRecord.price}}万元</span>
                            </el-form-item>
                            <br>
                            <el-form-item label="车辆图片">
                                <div class="source">
                                    <div>
                                        <ul class="el-upload-list el-upload-list--picture-card">
                                            <li class="el-upload-list__item is-success" v-for="img in imgs"
                                                v-if="img!=0">
                                                <img :src="img" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                                    <span class="el-upload-list__item-preview">
                                                                        <i class="el-icon-view"
                                                                           @click="imgView(img)"></i>
                                                                    </span>
                                                                </span>
                                            </li>

                                        </ul>
                                    </div>
                                </div>
                            </el-form-item>


                        </el-form>
                        <div style="margin-left: 400px!important;" @click="chujia">
                            <el-button type="primary">我要出价</el-button>
                            <div>
                            </div>

                        </div>
                    </div>

                    <%--驳回--%>
                    <el-dialog title="请输入车辆预估价格（万元）" v-model="reasonDialog" style="width: 800px">
                        <div class="row" style="width: 300px">
                            <el-form ref="form" :model="form" :rules="rules">
                                <el-form-item prop="reason">
                                    <el-input type="input" :rows="5" v-model="form.price"></el-input>
                                </el-form-item>
                            </el-form>
                        </div>
                        <div slot="footer" class="dialog-footer">
                            <el-button @click="reasonDialog = false">取 消</el-button>
                            <el-button type="primary" @click="rejectOK">确 定</el-button>
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
        el: "#app",
        data: {
            handle: 'list',
            onRoutes: '${cur}',
            items:${menu},
            ordernumber:${ordernumber},
            pageInfo: {},
            detail: {},
            activeName: '1',
            activeFirstNames: ['1'],
            searchForm: {
                searchFileds: {name: ''},
                pageIndex: 1,
                pageSize: 10
            },
            cur_row: {},
            form: {
                reason: ''
            }, price: 0,
            rules: {
                reason: [
                ]
            },
            cur_arry: [],
            imgs: [],
            firstData: {},
            secondData: {},
            thirdData: {},
            fourData: {},
            fiveData: {},
            reasonDialog: false,
            dialogImgVisible: false,
            dialogImageUrl: '',
            loading: true
        }, methods: {
            handleCommand(command) {
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
            }, handleSelect(href) {
                window.location.href = href;
            }, init() {
                this.loading = true;
                $.getJSON('/system/orderDetail/' + this.ordernumber, function (d) {
                    if (d.status == 200) {
                        console.log(JSON.stringify(d))
                        VM.detail = d.data
                        var str = d.data.record_info.imgArry
                        var strs = str.split(","); //字符分割
                        VM.imgs = strs
                    } else {
                        VM.error(d.message);
                    }
                    VM.loading = false;
                })
            }, rejectOK() {
                VM.reasonDialog = false;
                var data={}
                data.price=VM.form.price

                $.post('/system/price/' + VM.detail.saleRecord.ordernum,data, (d) => {
                    if (d.status == 200) {
                        VM.success();
                        this.init();
                    } else {
                        VM.error(d.message);
                    }
                }, 'JSON')
            }, chujia() {
                VM.reasonDialog = true
            }, imgView(url) {
                this.dialogImageUrl = url;
                this.dialogImgVisible = true;
            }, success(msg) {
                this.$message({message: msg || '操作成功', type: 'success'});
            }, error(msg) {
                this.$message.error(msg);
            }, confrim(title, cb) {
                this.$confirm(title, '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    cb()
                }).catch(() => {

                });
            },notify(object){
            const h = this.$createElement;
            this.$notify.info({
                title: '新的订单消息',
                message:'你有新的订单提交，订单编号：'+object.orderId+"，提交时间："+object.time,
                duration: 0
            });
        }
        }, mounted() {
            this.init();
        }
    })
</script>
</html>
