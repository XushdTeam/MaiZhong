<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/2
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>菜单列表</h2>
    </blockquote>
    <blockquote class="layui-elem-quote fhuaui-tip">菜单管理，可以灵活配置系统菜单，需要重新登录。</blockquote>
    <div class="y-role">
        <!--工具栏-->
        <div id="floatHead" class="toolbar-wrap">
            <div class="toolbar">
                <div class="box-wrap">
                    <a class="menu-btn"></a>
                    <div class="l-list">
                        <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit" data-href="${handleUrl}/null"><i class="fa fa-plus"></i>新增</a>
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
                    <col width="20%">
                    <col width="10%">
                    <col width="20%">
                    <col width="10%">
                    <col width="5%">
                    <col width="10%">
                    <col width="20%">
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>菜单名称</th>
                    <th>菜单ICO</th>
                    <th>菜单URL</th>
                    <th>菜单类型</th>
                    <th>排序</th>
                    <th style="text-align:center">是否启用</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr data-parent="{{ item.parent  }}">
                        <td>{{ item.id }}</td>
                        <td >{{# if (item.parent) { }}
                            &emsp;|---- {{ item.menuName}}
                            {{# } else { }}
                            <a class="do-action" data-type="doToggle" data-id="{{item.id}}"><i class="fa fa-minus-square-o"></i></a> {{ item.menuName}}
                            {{# } }}
                        </td>
                        <td><i class="{{ item.menuIco}}"></i></td>
                        <td>{{ item.menuUrl}}</td>
                        <td>{{ item.typeName }}</td>
                        <td>{{ item.sort}}</td>
                        <td align="center">{{# if (item.status) { }}
                            <i class="fa fa-toggle-on unlock"></i>
                            {{# } else { }}
                            <i class="fa fa-toggle-off islock"></i>
                            {{# } }}
                        </td>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit" data-href="${handleUrl}/{{item.id}}"><i class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete" data-text="确定删除<span class=red>{{item.menuName}}</span>吗？" data-href="${deleteUrl}/{{item.id}}"><i class="icon-trash-o  fa fa-trash-o"></i>删除</a>
                        </td>
                    </tr>
                    {{#  }); }}
                </script>
                </tbody>
            </table>
        </div>
        <!--列表-->
        <!--分页 -->
        <div class="fhui-admin-pagelist"/>
        <!--分页 -->
    </div>
    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">
        layui.use("pagelist",function(){
            layui.pagelist.baseInit();
        });
    </script>
</div>
</body>
</html>
