<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2017/3/1 0030
  Time: 下午 7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>广告信息</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>广告信息</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">广告名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="advertName" value="" placeholder="广告名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">广告类型</label>
                    <div class="layui-input-inline">
                        <select name="advertType">
                            <option value="">请选择广告类型</option>
                            <c:forEach items="${typeList}" var="type">
                                <option value="${type.key}">${type.value}</option>
                            </c:forEach>
                            <option value="">全部类型</option>
                        </select>
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
                           data-href="${handleUrl}/new"><i class="fa fa-plus"></i></i>新增广告</a>
                        <a class="layui-btn layui-btn-small do-action" data-type="doRefresh" data-href="${baseUrl}"><i
                                class="fa fa-refresh"></i>刷新</a>
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
                    <col width="5%">
                    <col width="15%">
                    <col width="10%">
                    <col width="10%">
                    <col width="5%">
                    <col width="30%">
                </colgroup>
                <thead>
                <tr>
                    <%--   <th><input type="checkbox" name="" lay-skin="line" lay-filter="allChoose"></th>--%>
                    <th>ID</th>
                    <th>广告图片</th>
                    <th>广告名称</th>
                    <th>商品编号</th>
                    <th>广告链接</th>
                    <th>广告描述</th>
                    <th>广告位置</th>
                    <th>是否发布</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.id }}</td>
                        <td><img src="{{ item.advertImg }}" height="50"/></td>
                        <td>{{ item.advertName }}</td>
                        <td>{{ item.carNumber }}</td>
                        <td>{{ item.advertUrl }}</td>
                        <td>{{ item.advertDesc}}</td>
                        <td>{{ item.typeName }}
                        </td>
                        <td align="center">{{# if (item.publishState) { }}
                            <i class="fa fa-toggle-on unlock"></i>
                            {{# } else { }}
                            <i class="fa fa-toggle-off islock"></i>
                            {{# } }}
                        </td>

                        <td>

                            {{# if (item.publishState) { }}
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete"
                               data-text="确定取消<span class=red></span>吗？"
                               data-href="${baseUrl}/remove/{{item.id}}"><i class="icon-trash-o  fa fa-trash-o"></i>取消发布</a>
                            {{# } else { }}
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit"
                               data-href="${handleUrl}/{{item.id}}"><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAndRefresh"
                               data-href="${baseUrl}/fabu/{{item.id}}"><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>发布</a>
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete"
                               data-text="确定删除<span class=red>{{item.advertName}}</span>吗？"
                               data-href="${deleteUrl}/{{item.id}}"><i class="icon-trash-o  fa fa-trash-o"></i>删除</a>
                            {{# } }}


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
            layui.pagelist.basePagingInit(6);
        });
    </script>
</div>
</body>
</html>
