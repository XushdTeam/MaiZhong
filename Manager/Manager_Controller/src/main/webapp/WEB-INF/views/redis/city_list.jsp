<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/5/22
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>城市缓存</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>城市缓存</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">城市名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="cityName" value="" placeholder="城市名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layui-btn-warm" lay-submit lay-filter="btnsearch">搜索</button>
                </div>
            </form>
        </div>
        <!--工具栏-->
        <div id="floatHead" class="toolbar-wrap">
            <div class="toolbar">
                <div class="box-wrap">
                    <a class="menu-btn"></a>
                    <div class="l-list">
                        <a class="layui-btn layui-btn-small do-action" data-type="doRefresh" data-href="${baseUrl}"><i
                                class="fa fa-refresh"></i>刷新</a>
                        <a class="layui-btn layui-btn-small layui-btn-warm do-action" data-type="doAjax"
                           data-href="${redisUrl}"><i class="fa fa-exchange"></i>同步缓存</a>
                        <a class="layui-btn layui-btn-small layui-btn-normal do-action" data-type="doAndRefresh"
                           data-href="${interUrl}"><i class="fa fa-exchange"></i>拉取最新数据</a>
                        <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doConfirm"
                           data-text="确定同步OSS文件吗，前方高能，非专业人士，请别乱点？"
                           data-href="${syncOSS}"><i class="fa fa-exchange"></i>OSS同步</a>
                    </div>
                </div>
            </div>
        </div>
        <!--/工具栏-->
        <!--列表-->
        <div class="fhui-admin-table-container" id="list" data-href="${listUrl}">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="5%">
                    <col width="10%">
                    <col width="10%">
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>城市名称</th>
                    <th>首字母</th>
                    <th>行政区号</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.cityId }}</td>
                        <td>{{ item.cityName }}</td>
                        <td>{{ item.initial }}</td>
                        <td>{{ item.adminCode }}</td>
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
        layui.use("pagelist", function () {
            layui.pagelist.basePagingInit(10);
        });
    </script>
</div>
</body>
</html>

