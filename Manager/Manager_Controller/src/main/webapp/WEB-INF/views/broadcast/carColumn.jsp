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
    <title>首页汽车</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>首页汽车</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                    <label class="layui-form-label">汽车栏目</label>
                    <div class="layui-input-inline">
                        <select name="columnId">
                            <option value="">请选择汽车栏目</option>
                            <option value="">请选择所属栏目</option>
                            <c:forEach items="${columnList}" var="item">
                                <option value="${item.key}">${item.value}</option>
                            </c:forEach>
                            <option value="">全部栏目</option>
                        </select>
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
                           data-href="${handleUrl}/new"><i class="fa fa-plus"></i>添加汽车</a>
                        <a class="layui-btn layui-btn-small do-action" data-type="doRefresh" data-href="${baseUrl}"><i
                                class="fa fa-refresh"></i>刷新</a>
                        <a class="layui-btn layui-btn-small layui-btn-warm do-action" data-type="doAjax" data-href="${redisUrl}"><i class="fa fa-exchange"></i>同步缓存</a>
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
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                    <col width="35%">
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>汽车ID</th>
                    <th>名称</th>
                    <th>汽车图片</th>
                    <th>所属栏目</th>
                    <th>显示顺序</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.id }}</td>
                        <td>{{ item.carId }}</td>
                        <td>{{ item.name }}</td>
                        <td><img src="{{ item.image }}" width="50" height="50"/></td>
                        <td>{{ item.columnName }}</td>
                        <td>{{ item.carSort }}</td>
                        <td>{{# if (item.status) { }}
                            <i class="fa fa-toggle-on unlock"></i>
                            {{# } else { }}
                            <i class="fa fa-toggle-off islock"></i>
                            {{# } }}
                        </td>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit" data-href="${handleUrl}/{{item.id}}"><i class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete" data-text="确定删除<span class=red>{{item.name}}</span>吗？" data-href="${deleteUrl}/{{item.id}}"><i class="icon-trash-o  fa fa-trash-o"></i>删除</a>
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
