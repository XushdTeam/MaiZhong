<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2017/3/9 0030
  Time: 下午 7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>广告发布</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>广告发布</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">广告类型</label>
                    <div class="layui-input-inline">
                        <select name="advertType" >
                            <option value="">全部分类</option>
                            <c:forEach items="${typeList}" var="type">
                                <option value="${type.key}">${type.value}</option>
                            </c:forEach>
                            <option value="">全部分类</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layui-btn-warm" lay-submit lay-filter="btnsearch" >搜索</button>
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
                    <col width="15%">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                    <col width="5%">
                    <col width="30%">
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>广告图片</th>
                    <th>广告名称</th>
                    <th>发布时间</th>
                    <th>广告类型</th>
                    <th>显示顺序</th>
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
                        <td>{{ item.advertTime }}</td>
                        <td >{{item.typeName }}
                        </td>
                        <td>{{ item.advertSort }}</td>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAndRefresh"
                               data-href="${handleUrl}/top/{{item.id}}"><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>置顶</a>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAndRefresh"
                               data-href="${handleUrl}/up/{{item.id}}"><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>上移</a>

                            <a class="layui-btn layui-btn-small do-action" data-type="doAndRefresh"
                               data-href="${handleUrl}/down/{{item.id}}"><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>下移</a>

                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete"
                               data-text="确定删除<span class=red></span>吗？"
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
            layui.pagelist.basePagingInit(6);
        });
    </script>
</div>
</body>
</html>
