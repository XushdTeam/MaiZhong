<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/01 0023
  Time: 上午 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异常日志</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>异常日志</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="userName" value="" placeholder="请输入用户名" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">范围选择</label>
                    <div class="layui-input-inline">
                        <input class="layui-input" name="timeBegin" placeholder="开始日" lay-filter="LAY_TIME_S">
                    </div>
                    <div class="layui-input-inline">
                        <input class="layui-input" name="timeEnd" placeholder="截止日" lay-filter="LAY_TIME_E">
                    </div>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layui-btn-warm" lay-submit  lay-filter="btnsearch">搜索</button>
                </div>
            </form>
        </div>
        <!--工具栏-->
        <div id="floatHead" class="toolbar-wrap">
            <div class="toolbar">
                <div class="box-wrap">
                    <a class="menu-btn"></a>
                    <div class="l-list">
                        <a class="layui-btn layui-btn-small do-action" data-type="doDelete" data-text="确定删除7天之前的运行日志吗？" data-href="${deleteUrl}"><i class="fa fa-trash-o"></i></i>删除7天之前的记录【物理删除】</a>
                        <a class="layui-btn layui-btn-small do-action" data-type="doRefresh" data-href="${baseUrl}"><i class="fa fa-refresh"></i>刷新</a>
                    </div>
                </div>
            </div>
        </div>
        <!--/工具栏-->
        <!--列表-->
        <div class="fhui-admin-table-container"  id="list" data-href = "${listUrl}">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="5%">
                    <col width="10%">
                    <col width="10%">
                    <col width="">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>模块名称</th>
                    <th>方法名称</th>
                    <th>Method</th>
                    <th>请求IP</th>
                    <th>用户名称</th>
                    <th>TIME</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.id }}</td>
                        <td>{{ item.moduleName }}</td>
                        <td>{{ item.methodName }}</td>
                        <td>{{ item.logMethod }}</td>
                        <td>{{ item.requestIp }}</td>
                        <td>{{ item.userName }}</td>
                        <td>{{ item.logTime }}</td>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit" data-href="${handleUrl}/{{item.id}}" ><i class="icon-edit  fa fa-chain"></i>详细</a>
                        </td>
                    </tr>
                    {{#  }); }}
                </script>
                </tbody>
            </table>
        </div>
        <!--列表-->
        <!--分页 -->
        <div class="fhui-admin-pagelist">
            <div id="page"></div>
        </div>
        <!--分页 -->
    </div>
    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">
        layui.use("pagelist",function(){
            var page = layui.pagelist;
            page.basePagingInit(10);
            page.logTimeInit();
        });
    </script>
</div>
</body>
</html>
