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
    <title>文章管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>文章管理</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">文章标题</label>
                    <div class="layui-input-inline">
                        <input type="text" name="title" value="" placeholder="文章标题" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">文章作者</label>
                    <div class="layui-input-inline">
                        <input type="text" name="author" value="" placeholder="文章作者" class="layui-input">
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
                        <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit"
                           data-href="${handleUrl}/new"><i class="fa fa-plus"></i>新增文章</a>
                        <a class="layui-btn layui-btn-small do-action" data-type="doRefresh" data-href="${baseUrl}"><i
                                class="fa fa-refresh"></i>刷新</a>
                        <a class="layui-btn layui-btn-small layui-btn-warm do-action" data-type="doAjax"
                           data-href="/help/updateHelpRedis"><i class="fa fa-exchange"></i>同步缓存</a>
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
                    <col width="40%">
                    <col width="10%">
                    <col width="15%">
                    <col width="8%">
                    <col width="20%">
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>标题名称</th>
                    <th>作者</th>
                    <th>最后修改时间</th>
                    <th>是否启用</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.id }}</td>
                        <td>{{ item.title }}</td>
                        <td>{{ item.author }}</td>
                        <td>{{ item.editTime }}</td>
                        <td >{{# if (item.status) { }}
                            <i class="fa fa-toggle-on unlock"></i>
                            {{# } else { }}
                            <i class="fa fa-toggle-off islock"></i>
                            {{# } }}
                        </td>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit"
                               data-href="${handleUrl}/{{item.id}}"><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete"
                               data-text="确定删除<span class=red>{{item.title}}</span>吗？"
                               data-href="${deleteUrl}/{{item.id}}"><i class="icon-trash-o  fa fa-trash-o"></i>删除</a>
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
        layui.use("pagelist", function () {
            layui.pagelist.basePagingInit(10);
        });
    </script>
</div>
</body>
</html>

