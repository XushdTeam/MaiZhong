<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2017/3/22 0030
  Time: 下午 7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>店铺管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>店铺管理</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">店铺名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="businessName" value="" placeholder="店铺名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">手机号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="mobilePhone" value="" placeholder="手机号" class="layui-input">
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
                        <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit"  data-href="${handleUrl}/new"><i class="fa fa-plus"></i></i>添加店铺</a>
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
                    <col width="10%">
                    <col width="5%">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                    <col width="5%">
                    <col width="25%">
                </colgroup>
                <thead>
                <tr>
                    <th>编号</th>
                    <th>店铺名称</th>
                    <th>LOGO</th>
                    <th>地址</th>
                    <th>负责人</th>
                    <th>手机号</th>
                    <th>座机</th>
                    <th>邮箱</th>
                    <th>状态</th>
                    <th>操作</th>

                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.number }}</td>
                        <td>{{ item.businessName }}</td>
                        <td><img src="{{ item.logo }}" width="100" height="40"/></td>
                        <td>{{ item.address }}</td>
                        <td>{{ item.linkman}}</td>
                        <td>{{ item.mobilePhone}}</td>
                        <td>{{ item.telephone}}</td>
                        <td>{{ item.email}}</td>
                        <td>{{# if (item.status) { }}
                            <i class="fa fa-toggle-on unlock"></i>
                            {{# } else { }}
                            <i class="fa fa-toggle-off islock"></i>
                            {{# } }}
                        </td>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit" data-href="${handleUrl}/{{item.id}}"><i class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete" data-text="确定删除<span class=red>{{item.businessName}}</span>吗？" data-href="${deleteUrl}/{{item.id}}"><i class="icon-trash-o  fa fa-trash-o"></i>删除</a>
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
</div>
</body>
</html>
