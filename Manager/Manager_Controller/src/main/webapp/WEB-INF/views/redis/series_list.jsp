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
    <title>车系缓存</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>车系缓存</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">车系名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="seriesName" value="" placeholder="车系名称" class="layui-input">
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
                        <a class="layui-btn layui-btn-small layui-btn-normal do-action" data-type="doAndRefresh"
                           data-href="${interUrl}"><i class="fa fa-exchange"></i>拉取最新数据并同步缓存</a>
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
                    <th>车系名称</th>
                    <th>图片</th>
                    <th>厂商</th>
                    <th>更新时间</th>
                    <th>热门</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.seriesId }}</td>
                        <td>{{ item.seriesName }}</td>
                        <td><img src="{{ item.seriesPic }}" width="40" height="40"/></td>
                        <td>{{ item.seriesGroupName }}</td>
                        <td>{{ item.updateTime }}</td>
                        <td>{{# if (item.isHot) { }}
                            <i class="fa fa-toggle-on unlock"></i>
                            {{# } else { }}
                            <i class="fa fa-toggle-off islock"></i>
                            {{# } }}
                        </td>
                        <td>
                            {{# if (item.isHot) { }}
                            <a class="layui-btn layui-btn-small layui-btn-primary do-action" data-type="doAndRefresh" data-href="${cancleUrl}/{{item.brandId}}">
                                <i class="icon-edit  fa fa-heart-o"></i>取消热门
                            </a>
                            {{# } else { }}
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doAndRefresh" data-href="${hotUrl}/{{item.brandId}}">
                                <i class="icon-edit  fa fa-heartbeat"></i>设为热门
                            </a>
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
            layui.pagelist.basePagingInit(10);
        });
    </script>
</div>
</body>
</html>

