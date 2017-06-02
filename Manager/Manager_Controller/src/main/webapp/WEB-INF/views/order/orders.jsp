<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2017/3/7 0030
  Time: 下午 7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单管理</title>
    <jsp:include page="../common/head.jsp"/>
    <link rel="stylesheet" type="text/css" href="/resources/easyui/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/resources/easyui/icon.css">
    <script type="text/javascript" src="/resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/easyui/jquery.easyui.min.js"></script>

</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>订单审核</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <c:if test="${baseUrl=='/orders'}">
                    <div class="layui-inline">
                        <label class="layui-form-label">订单状态</label>
                        <div class="layui-input-inline">
                            <select name="status">
                                <option value="">请选择订单状态</option>
                                <option value="1">等待验收</option>
                                <option value="2">车辆处理</option>
                                <option value="3">等待过户</option>
                                <option value="4">过户完成</option>
                                <option value="5">更新指标</option>
                                <option value="6">已完结</option>
                                <option value="">全部订单</option>
                            </select>
                        </div>
                    </div>
                </c:if>

                <div class="layui-inline">
                    <label class="layui-form-label">用户手机号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="user_id" value="" placeholder="用户手机号" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">订单编号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="orderNumber" value="" placeholder="订单编号" class="layui-input">
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
                    <col width="10%">
                    <col width="5%">
                    <col width="5%">
                    <col width="20%">
                    <col width="5%">
                    <col width="10%">
                    <col width="10%">
                    <col width="15%">
                </colgroup>
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>用户手机号</th>
                    <th>联系人</th>
                    <th>车型名称</th>
                    <th>预估价格</th>
                    <th>预估时间</th>
                    <th>订单状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{# layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.orderNumber }}</td>
                        <td>{{ item.userId }}</td>
                        <td>{{# if (item.linkMan) { }}
                            {{ item.linkMan }}
                            {{# } else { }}
                            ---
                            {{# } }}
                        </td>

                        <td>{{ item.modelName }}</td>
                        <td>{{ item.reckonPrice }}万元</td>
                        <td>{{ item.reckonTime }}</td>
                        <td>
                            {{# if (item.status==0) { }}
                            未预约
                            {{# } else if (item.status==1) { }}
                            等待验收
                            {{# } else if (item.status==2) { }}
                            车辆处理
                            {{# } else if (item.status==3) { }}
                            等待过户
                            {{# } else if (item.status==4) { }}
                            过户完成
                            {{# } else if (item.status==5) { }}
                            更新指标
                            {{# } else { }}
                            已完结
                            {{# }}}

                        </td>
                        <td>

                            <a class="layui-btn layui-btn-small do-action" id="editOrder"
                               onclick="openOrders('${handleUrl}/{{item.orderId}}')"><i
                                    class="icon-edit fa fa-pencil-square-o"></i>编辑</a>

                            <%--<a class="layui-btn layui-btn-small do-action" data-type="doAddEdit" id="editOrder"
                               data-href="${handleUrl}/{{item.orderId}}"><i
                                    class="icon-edit fa fa-pencil-square-o"></i>编辑</a>--%>

                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete"
                               data-text="确定删除<span class=red>{{ item.modelName }}</span>吗？"
                               data-href="${deleteUrl}/{{item.orderId}}"><i
                                    class="icon-trash-o fa fa-trash-o"></i>删除</a>
                        </td>
                    </tr>
                    {{# }); }}
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
    <div>
        <audio id="chatAudio">
            <source src="/resources/voice/notify.mp3" type="audio/mpeg">
        </audio>
    </div>


    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">

        layui.use("pagelist", function () {
            layui.pagelist.basePagingInit(8);
        });
    </script>
    <script type="text/javascript">

        layui.use(['layer', 'tab'], function () { //独立版的layer无需执行这一句
            var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

            var tab = layui.tab({elem: '.layui-tab-card'});

            var websocket = null;
            //判断当前浏览器是否支持WebSocket
            if ('WebSocket' in window) {
                websocket = new WebSocket("ws://core.maizhongcar.com/websocket");
            }
            else {
                alert('当前浏览器 不支持订单监控，请更换浏览器')
            }

            //连接发生错误的回调方法
            websocket.onerror = function () {
                setMessageInnerHTML("订单监控连接失败，请稍后刷新重试或更换浏览器");
            };

            //接收到消息的回调方法
            websocket.onmessage = function (event) {
                setMessageInnerHTML(event.data);
            }

            //连接关闭的回调方法
            websocket.onclose = function () {
                setMessageInnerHTML("连接关闭");
            }

            //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
            window.onbeforeunload = function () {
                closeWebSocket();
            }

            //将消息显示在网页上
            function setMessageInnerHTML(innerHTML) {
                if (innerHTML && innerHTML != '连接关闭') {
                    $('#chatAudio')[0].play(); //播放声音
                    var dv_num = 0;
                    $('.panel-htop').each(function(){
                        dv_num +=1;
                    });
                    var turnLeft=0;
                    var lines=Math.floor(dv_num / 4);
                    if(lines>0){
                        turnLeft=280*lines;
                    }

                    $.messager.show({
                        title: '您有新订单了！',
                        msg: innerHTML,
                        width:280,
                        height:160,
                        timeout:0,
                        showType: 'show(fast)',
                        draggable:true,
                        style:{
                            right:turnLeft,
                            left:'',
                            top:document.body.scrollTop+document.documentElement.scrollTop+160*(dv_num%4),
                            bottom:''
                        }
                    });
                }
                ;
            }

            //关闭WebSocket连接
            function closeWebSocket() {
                websocket.close();
            }
        });

        function openOrders(href) {
            parent.openWin({
                href: href,
                icon: "fa2 fa-car",
                title: "订单"
            });
        }

    </script>

</div>
</body>
</html>
