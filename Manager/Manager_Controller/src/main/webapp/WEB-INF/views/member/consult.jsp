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
    <title>客户咨询</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>咨询列表</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">手机号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="phone" value="" placeholder="手机号" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">咨询类型</label>
                    <div class="layui-input-inline">
                        <select name="type">
                            <option value="">请选择咨询类型</option>
                            <option value="0">新车</option>
                            <option value="1">二手车</option>
                            <option value="">全部类型</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">处理状态</label>
                    <div class="layui-input-inline">
                        <select name="status">
                            <option value="">请选择处理状态</option>
                            <option value="0">未处理</option>
                            <option value="1">已处理</option>
                            <option value="">全部类型</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">咨询时间</label>
                    <div class="layui-input-inline">
                        <input class="layui-input" name="timeBegin" placeholder="开始日" lay-filter="LAY_TIME_S">
                    </div>
                    <div class="layui-input-inline">
                        <input class="layui-input" name="timeEnd" placeholder="截止日" lay-filter="LAY_TIME_E">
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
                    <col width="20%">
                    <col width="15%">
                </colgroup>
                <thead>
                <tr>
                    <th>汽车编号</th>
                    <th>咨询类型</th>
                    <th>手机号</th>
                    <th>咨询时间</th>
                    <th>处理时间</th>
                    <th>处理状态</th>
                    <th>处理人员</th>
                    <th style="text-align: center;">备注</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>

                        <td>{{# if (item.number==null) { }}

                            {{# } else { }}
                            {{ item.number }}
                            {{# } }}
                        </td>
                        <td>{{# if (item.type==0) { }}
                            新车
                            {{# } else { }}
                            二手车
                            {{# } }}
                        </td>
                        <td>{{ item.phone }}</td>
                        <td>{{ item.consultTime}}</td>

                        <td>{{# if (item.handleTime==null) { }}

                            {{# } else { }}
                            {{ item.handleTime}}
                            {{# } }}
                        </td>

                        <td>{{# if (item.status) { }}
                            已处理
                            {{# } else { }}
                            未处理
                            {{# } }}
                        </td>
                        <td>{{# if (item.serviceName==null) { }}

                            {{# } else { }}
                            {{ item.serviceName}}
                            {{# } }}
                        </td>
                        <td align="center">{{# if (item.remark==null) { }}
                            {{# } else { }}
                            {{ item.remark }}
                            {{# } }}
                        </td>
                        <td>{{# if (item.status==0) { }}
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doAddEdit"
                               data-href="${handleUrl}/{{item.id}}"><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>处理</a>
                            {{# } else { }}
                            <a class="layui-btn layui-btn-small "><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>已处理</a>
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
            var pagelist = layui.pagelist;
            pagelist.basePagingInit(10);
            pagelist.logTimeInit();
        });
    </script>
</div>
</body>
</html>
