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
    <title>拍卖结束</title>
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
    </style>
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
                        <el-breadcrumb-item><a @click="handle='list'">拍卖结束</a></el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <%--查询--%>

                <%--操作--%>
                <div class="row">
                    <el-button type="info" @click="refrush"><i class="iconfont icon-shuaxin"></i>刷新</el-button>
                </div>
                <%--列表--%>
                <div class="row">
                    <el-table :data="pageInfo.list" highlight-current-row
                              v-loading="loading"
                              element-loading-text="拼命加载中"
                              style="width: 100%" height="500">
                        <el-table-column prop="id" label="ID" width="80"></el-table-column>
                        <el-table-column prop="picMain" label="图片" width="100">
                            <template scope="scope">
                                <img :src="scope.row.picMain" height="50" width="50" style="margin: 10px 0px;">
                            </template>
                        </el-table-column>
                        <el-table-column prop="modelName" label="车型名称" width="250"></el-table-column>
                        <el-table-column prop="userPhone" label="联系电话" width="140"></el-table-column>
                        <el-table-column prop="companyName" label="所属商户" width="150"></el-table-column>
                        <el-table-column prop="startPrice" label="起拍价" width="120"></el-table-column>
                        <el-table-column prop="endPrice" label="拍卖价" width="120"></el-table-column>
                        <el-table-column prop="chKey" label="通道" width="100"></el-table-column>
                        <el-table-column prop="status" label="状态" width="100">
                            <template scope="scope">
                                <el-tag type="primary" v-show="scope.row.status==7">待成交</el-tag>
                                <el-tag type="danger" v-show="scope.row.status==6">流拍</el-tag>
                            </template>
                        </el-table-column>
                        <el-table-column prop="status" label="操作">
                            <template scope="scope">
                                <el-button type="info" size="small" @click="second(scope.row)">
                                    <i class="iconfont icon-2"> 二拍</i>
                                </el-button>
                                <el-button type="success" size="small" v-show="scope.row.status==7"
                                           @click="deal(scope.row)">
                                    <i class="iconfont icon-chengjiao1"> 成交</i>
                                </el-button>
                            </template>
                        </el-table-column>
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
            onRoutes: '${cur}',
            items:${menu},
            pageInfo: {},
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
            },
            rules: {
                reason: [
                    {required: true, message: '驳回原因不能为空'},
                    {max: 500, message: '最多500字符'}
                ]
            },
            temp: [],
            cur_arry: [],
            qx: ['', '故障', '卡滞', '异响', '漏油', '沉重'],
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
                $.post('/system/channel/over/list', this.searchForm, (d) => {
                    if (d.status == 200) {
                        $.each(d.data.list, (j, i) => {
                            i.change = false;
                        })
                        VM.pageInfo = d.data;
                    } else {
                        this.error(d.message);
                    }
                    VM.loading = false;
                }, "JSON")
            }, handleCurrentChange (pageNum) {
                this.searchForm.pageIndex = pageNum;
                this.init();

            }, second(row){
                this.confrim("确定加入二拍，编号：" + row.id + " 的" + row.modelName, () => {
                    VM.loading = true;
                    $.getJSON('/system/car/second/' + row.id+'/'+row.auctionId, (d) => {
                        if (d.status == 200) {
                            VM.success();
                            VM.refrush();
                        } else {
                            VM.error(d.message)
                        }
                        VM.loading = false;
                    })
                })
            }, deal (row) {
                this.confrim("确定成交 编号：" + row.id + " 的 " + row.modelName, () => {
                    VM.loading = true;
                    $.getJSON('/system/car/deal/' + row.id, (d) => {
                        if (d.status == 200) {
                            VM.success();
                            VM.refrush();
                        } else {
                            VM.error(d.message);
                        }
                        VM.loading = false;
                    });
                })
            }, refrush () {
                this.searchForm = {
                    searchFileds: {username: '', phoneNum: ''},
                    pageIndex: 1,
                    pageSize: 10
                }
                this.loading = true;
                this.init();
            }, success (msg) {
                this.$message({message: msg || '操作成功', type: 'success'});
            }, error (msg) {
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
            }
        }, mounted () {
            this.init();
        }
    })
</script>
</html>
