<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2017/3/1 0030
  Time: 下午 7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车系管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>车系管理</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">品牌名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="brandName" value="" placeholder="品牌名称" class="layui-input">
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
                        <a class="layui-btn layui-btn-small do-action" data-type="doRefresh" data-href="${baseUrl}"><i class="fa fa-refresh"></i>刷新</a>
                        <a class="layui-btn layui-btn-small layui-btn-warm do-action" data-type="doAjax" data-href="/series/updateRedis"><i class="fa fa-exchange"></i>同步缓存</a>
                    </div>
                </div>
            </div>
        </div>
        <!--/工具栏-->
        <!--列表-->
        <div class="fhui-admin-table-container"  id="list" data-href = "${listUrl}">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="5%" >
                    <col width="10%" >
                    <col width="10%" >
                    <col width="10%" >
                    <col width="10%" >
                    <col width="55%" >
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>品牌LOGO</th>
                    <th>品牌名称</th>
                    <th>显示顺序</th>
                    <th>是否启用</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.id }}</td>
                        <td><img src="{{ item.brandImg }}" width="50" height="50"/></td>
                        <td>{{ item.brandName }}</td>
                        <td>{{ item.brandSequence}}</td>
                        <td>{{# if (item.status) { }}
                            <i class="fa fa-toggle-on unlock"></i>
                            {{# } else { }}
                            <i class="fa fa-toggle-off islock"></i>
                            {{# } }}
                        </td>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit" data-href="${handleSeries}/{{item.id}}"><i class="icon-edit  fa fa-pencil-square-o"></i>编辑车系</a>
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
            layui.pagelist.basePagingInit(8);
        });
    </script>
</div>
</body>
</html>
