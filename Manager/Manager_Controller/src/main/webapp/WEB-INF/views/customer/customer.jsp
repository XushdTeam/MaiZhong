<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/3/1 0030
  Time: 下午 7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>客户管理</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">客户姓名</label>
                    <div class="layui-input-inline" style="width: 120px !important;" >
                        <input type="text" name="userName" value="" placeholder="用户名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">客户手机号</label>
                    <div class="layui-input-inline" style="width: 120px !important;">
                        <input type="text" name="userPhone" value="" placeholder="用户手机号" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">店铺名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="shopName" value="" placeholder="店铺名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline" >
                    <label class="layui-form-label">客户角色</label>
                    <div class="layui-input-inline" style="width: 100px !important;">
                        <select name="userRole">
                            <option value="">全部客户</option>
                            <option value="1">普通客户</option>
                            <option value="2">合作客户</option>
                            <option value="">全部客户</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">范围选择</label>
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
                    <col width="15%">
                    <col width="20%">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                </colgroup>
                <thead>
                <tr>
                    <th>头像</th>
                    <th>用户手机号</th>
                    <th>用户角色</th>
                    <th>用户名称</th>
                    <th>所属店铺</th>
                    <th>店铺地址</th>
                    <th>职务</th>
                    <th>注册时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td><img src="{{ item.userImg }}" width="50" height="50"/></td>

                        <td>{{ item.phone}}</td>

                        <td>{{# if (item.userRole==2) { }}
                            合作用户
                            {{# } else { }}
                            普通用户
                            {{# } }}
                        </td>
                        <td>{{# if (item.userName) { }}
                            {{ item.userName }}
                            {{# } else { }}
                            --
                            {{# } }}
                        </td>
                        <td>{{# if (item.shopName) { }}
                            {{ item.shopName }}
                            {{# } else { }}
                            --
                            {{# } }}
                        </td>
                        <td>{{# if (item.shopAddress) { }}
                            {{ item.shopAddress }}
                            {{# } else { }}
                            --
                            {{# } }}
                        </td>

                        <td>{{# if (item.userJob) { }}
                            {{ item.userJob }}
                            {{# } else { }}
                            --
                            {{# } }}
                        </td>
                        <td>{{ item.createTime}}</td>
                        <td>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit"
                               data-href="${handleUrl}/{{item.userId}}"><i
                                    class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete"
                               data-text="确定删除<span class=red>{{item.phone}}</span>吗？"
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
            var pagelist = layui.pagelist;
            pagelist.basePagingInit(10);
            pagelist.logTimeInit();
        });
    </script>
</div>
</body>
</html>
