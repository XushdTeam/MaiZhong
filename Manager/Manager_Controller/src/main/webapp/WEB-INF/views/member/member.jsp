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
    <title>会员管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>会员列表</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">会员姓名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="memberName" value="" placeholder="会员名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">手机号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="mobile" value="" placeholder="手机号" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">注册时间</label>
                    <div class="layui-input-inline">
                        <input class="layui-input" name="timeBegin" placeholder="开始日" lay-filter="LAY_TIME_S">
                    </div>
                    <div class="layui-input-inline">
                        <input class="layui-input" name="timeEnd" placeholder="截止日" lay-filter="LAY_TIME_E">
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
                     <%--   <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit"  data-href="${handleUrl}/new"><i class="fa fa-plus"></i></i>新增品牌</a>--%>
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
                    <col width="5%" >
                    <col width="10%" >
                    <col width="10%" >
                    <col width="10%" >
                    <col width="10%" >
                    <col width="15%" >
                    <col width="40%" >
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>手机号</th>
                    <th>邮箱</th>
                    <th>身份证号码</th>
                    <th>注册时间</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.id }}</td>
                        <td>{{ item.memberName }}</td>
                        <td align="left">{{# if (item.sex==0) { }}
                            男
                            {{# } }}
                            {{# if (item.sex==1) { }}
                          女
                            {{# } }}
                            {{# if (item.sex==2) { }}
                          保密
                            {{# } }}
                        </td>
                        <td>{{ item.mobile}}</td>
                        <td>{{ item.email}}</td>
                        <td>{{ item.idcard}}</td>
                        <td>{{ item.registerTime}}</td>
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
            var pagelist = layui.pagelist;
            pagelist.basePagingInit(10);
            pagelist.logTimeInit();
        });
    </script>
</div>
</body>
</html>
