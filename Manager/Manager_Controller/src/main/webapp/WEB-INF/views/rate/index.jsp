<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/5/24
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>阶梯利率调整</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>阶梯利率</h2>
    </blockquote>

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
    <div class="fhui-admin-table-container" id="list" data-href="${listUrl}">
        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="5%">
                <col width="15%">
                <col width="10%">
                <col width="15%">
                <col width="8%">
                <col width="20%">
            </colgroup>
            <thead>
            <tr>
                <th>ID</th>
                <th>金额阶梯</th>
                <th>浮动利率</th>
                <th>最后修改时间</th>
                <th>修改人</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="tbody">
            <script id="tpl" type="text/html">
                {{#  layui.each(d.rows, function(index, item){ }}
                <tr>
                    <td>{{ item.id }}</td>
                    <td>{{ item.rateName }} 万 </td>
                    <td>{{ item.rate }} %</td>
                    <td>{{ item.updateTime }}</td>
                    <td >{{ item.updateUser }}</td>
                    <td>
                        <a class="layui-btn layui-btn-small medit"
                           data-href="${handleUrl}/{{item.id}}" data-rate="{{ item.rate }}">
                            <i class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                    </td>
                </tr>
                {{#  }); }}
            </script>
            </tbody>
        </table>
    </div>



</div>
<script src="/resources/js/event.js"></script>
<script type="text/javascript">
    layui.use(["pagelist","app"],function(){
        var $ = layui.jquery,app = layui.app;
        layui.pagelist.baseInit();

        $('body').on("click", ".medit", function (e) {
            var href = $(this).data('href'),rate = $(this).data('rate');
            layer.prompt({title: '输入新的利率，并确认', formType: 0,value: rate,maxlength:5}, function(value, index){
                //layer.close(index);
                if(value){
                    var patten = /^-?\d+\.?\d{0,2}$/;
                    if(patten.test(value)){
                        layer.close(index);
                        $.getJSON(href+'/'+value,function(d){
                            if(d.status==200){
                                window.location.reload()
                            }else{
                                app.layerAlertE(d.message)
                            }
                        })
                    }else{
                        app.layerAlertE('格式有误')
                    }
                }
            });



            layui.stope(e);//阻止冒泡事件
        });
    });

</script>


</body>
</html>
