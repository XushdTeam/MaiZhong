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
                        <el-table-column prop="key" label="通道" width="200"></el-table-column>
                        <el-table-column prop="carInfo.carId" label="车辆编号" width="200"></el-table-column>
                        <el-table-column prop="carInfo.modelName" label="车辆信息" ></el-table-column>


                    </el-table>
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
                $.post('/system/channel/now/list', this.searchForm, function (d) {
                    if (d.status == 200) {
                        VM.list = d.data;
                    } else {
                        this.error(d.message);
                    }
                    VM.loading = false;
                }, "JSON")
            },refrush () {

                this.loading = true;
                this.init();
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
