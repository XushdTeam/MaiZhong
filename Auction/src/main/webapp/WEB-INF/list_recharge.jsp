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
    <title>充值记录</title>
    <%@ include file="head.jsp" %>
    <link href="/resources/main/css/MyCyp.css" rel="stylesheet">
    <link href="/resources/main/css/page.css" rel="stylesheet">
</head>
<body>
<%@ include file="nav.jsp" %>

<div class="w1200 mauto" id="app">
    <div class="mt25 clearfix">
        <%@ include file="personal_nav.jsp" %>
        <div class="fr w1060">
            <div class="bbs1b h41 pr" style="font-size: 16px;font-weight: bold">
                充值记录
            </div>
            <div class="pr10 pl10 pt25">
                <el-alert title="如有疑问，请联系客服 010-8025-8108，感谢您的支持。"type="info" style="margin: 10px 0px;"></el-alert>
                <el-button type="text" @click="dialogVisible=1"
                           style="color: #FF6600;margin-bottom: 10px;font-size: 16px;">充值</el-button>
                <el-table :data="tableData" stripe style="width: 100%" v-loading="loading">
                    <el-table-column  prop="id" label="编号" width="100"></el-table-column>
                    <el-table-column  prop="createTime" label="时间" ></el-table-column>
                    <el-table-column  prop="createUser" label="操作人" ></el-table-column>
                    <el-table-column  prop="plus" label="充值金额" ></el-table-column>
                </el-table>

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
</body>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            loading:1,
            dialogVisible:!1,
            tableData:[],
        },
        methods:{
            getRecord(){
                $.getJSON('/auction/recharge/list',d =>{
                    if(d.status==200)this.tableData = d.data;
                    this.loading=!1;
                })
            }
        },
        mounted(){
            this.getRecord();
        }
    })

</script>
</html>
