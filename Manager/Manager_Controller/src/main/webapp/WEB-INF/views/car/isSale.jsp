<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<!--工具栏-->
    <div class="main-wrap">
        <blockquote class="layui-elem-quote fhui-admin-main_hd">
            <h2>汽车列表</h2>
        </blockquote>
        <div class="y-role">
            <div class="search-bar">
                <!--查询区-->
                <form class="layui-form layui-form-pane">
                    <%--<div class="layui-inline">
                        <label class="layui-form-label">搜索</label>
                        <div class="layui-input-inline">
                            <input type="text" name="queryString" value="" placeholder="请输入关键字" class="layui-input">
                        </div>
                    </div>--%>
                        <div class="layui-inline">
                            <label class="layui-form-label">店铺名称</label>
                            <div class="layui-input-inline">
                                <select name="businessId" id="business" lay-filter="aihao">
                                    <option value=""></option>
                                    <option value="">所有店铺</option>
                                    <c:forEach items="${carBusinessList}" var="business">
                                        <option value="${business.id}">${business.businessName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
<%--
                    <div class="layui-inline">
                        <label class="layui-form-label">时间范围</label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="timeBegin" placeholder="开始日" lay-filter="LAY_TIME_S">
                        </div>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="timeEnd" placeholder="截止日" lay-filter="LAY_TIME_E">
                        </div>
                    </div>--%>


                  <%--  <div class="layui-inline">
                        <label class="layui-form-label">车型</label>
                        <div class="layui-input-inline">
                            <select name="carType" id="carType"  lay-filter="carchange" >
                                <option value=""></option>
                                <option value="">所有车型</option>
                                <c:forEach items="${carTypeList}" var="type">
                                    <option value="${type.id}">${type.typeName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>--%>

                    <div class="layui-inline">
                        <label class="layui-form-label">品牌</label>
                        <div class="layui-input-inline">
                            <select name="carBrand" id="carBrand" lay-filter="aihao">
                                <option value=""></option>
                                <option value="">所有品牌</option>
                                <c:forEach items="${carBrandList}" var="brand" >
                                    <option value="${brand.id}">${brand.brandName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">是否上线</label>
                            <div class="layui-input-inline">
                                <select name="isSale" id="isSale" lay-filter="aihao">
                                    <option value=""></option>
                                    <option value="">全部</option>
                                        <option value="1">上线</option>
                                        <option value="0">未上线</option>
                                </select>
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
                            <a class="layui-btn layui-btn-small "  onclick="betchIssale()" ><i class="layui-icon">&#xe609;</i>批量上/下线</a>
                            <a class="layui-btn layui-btn-small do-action" data-type="doRefresh" data-href="${baseUrl}"><i class="fa fa-refresh"></i>刷新</a>
                        </div>
                    </div>
                </div>
            </div>
        <!--/工具栏-->
        <!--列表-->
            <div class="fhui-admin-table-container"  id="list" data-href = "${carListSaleUrl}">
                <table class="layui-table" lay-skin="line">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="selAll" onclick="selAllBtn(this)"   ></th>
                        <th>审核状态</th>
                        <%--'汽车编号 ',--%>

                        <th>编号</th>
                        <th>店铺名称</th>

                        <%--'车型名称 类似奥迪a4',--%>
                        <th>品牌</th>
                        <%--'外键  链接车辆类型',--%>
                        <th>结构</th>
                        <%--年款式 类似 奥迪a42016款',--%>
                        <th>型号</th>
                        <%--'车辆颜色  外联数据字典表',--%>
                        <%--<th>颜色</th>--%>
                        <%--'汽车排量 1.7L',--%>
                        <%--<th>排量</th>--%>
                        <%--<th>变速箱类型</th>--%>
                        <%--'变速箱类型 外联数据字典表 ',--%>
                        <th>卖点</th>
                        <%--MMENT '车辆卖点 用于搜索',--%>
                        <%--<th>订金</th>--%>
                        <%--LL COMMENT '订金价格',--%>
                        <th>售价(万)</th>
                        <%--ENT '修改时间',--%>
                       <%-- <th>修改时间</th>--%>
                  <%--      <th>图片</th>--%>
                        <%--MMENT '商品图片，多张图片中间用符号分割',--%>
                        <%--COMMENT '是否可用 用于搜索时是否展示',--%>
                        <%--'商品详情的存储字段',--%>
                        <th>权重</th>
                        <th>库存</th>
                        <th>是否上线</th>
                      <%--  <th>详情</th>--%>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <script id="tpl" type="text/html">
                        {{#  layui.each(d.rows, function(index, item){ }}
                        <tr>
                            <td ><input type="checkbox" onclick="isSale(this)" name="selectNum" value="{{ item.id }}"></td>
                            <%--<td>{{ item.id }}</td>--%>
                            <%--<td>{{ item.unable }}</td>--%>
                            <td align="center">
                                    {{# if (item.unable==1) { }}
                                    <i class="layui-icon">&#x1005;</i>通过
                                    <%--<i class="fa fa-toggle-on unlock"></i>--%>
                                    {{# } else if (item.unable==0) { }}
                                    <i class="layui-icon">&#xe63a;</i>待审核
                                    <%--<i class="fa fa-toggle-off islock"></i>--%>
                                    {{# } else { }}
                                    <i class="layui-icon">&#x1007;</i>违规
                                    {{# }}}
                            </td>
                        <%--'汽车编号 ',--%>
                            <td>{{ item.number }}</td>
                            <%--店铺名称--%>
                            <td>{{ item.business }}</td>
                        <%--'车型名称 类似奥迪a4',--%>
                            <td>{{ item.carBrand }}</td>
                        <%--'外键链接车辆品牌  类似奥迪',--%>
                            <td>{{ item.carType }}</td><%--此字段需要遍历--%>
                        <%--'外键  链接车辆类型',--%>
                            <td>{{ item.name }}</td>
                        <%--年款式 类似 奥迪a42016款',--%>
                            <%--<td>{{ item.color }}</td>--%>
                        <%--'车辆颜色  外联数据字典表',--%>
                            <%--<td>{{ item.capacity }}</td>--%>
                        <%--'汽车排量 1.7L',--%>
                            <%--<td>{{ item.gearbox }}</td>--%>
                            <td>{{ item.sellpoint }}</td>
                        <%--LL COMMENT '订金价格',--%>
                            <%--<td>{{ item.reservePrice }}</td>--%>
                        <%--ULL COMMENT '售价',--%>
                            <td>{{ item.sellPrice }}</td>
                        <%--ENT '修改时间',--%>
                          <%--  <td>{{ item.updateTime }}</td>--%>
                        <%--MMENT '商品图片，多张图片中间用符号分割',--%>
                           <%-- <td>
                                <span style="display: none;" class="imageHideText">{{ item.image }}</span>
                                <img src="{{ item.image }}" style="width: 40px;height: 20px">
                            </td>--%>
                            <td>{{ item.weight }}</td>
                            <td>{{ item.stockNum }}</td>
                            <td>{{# if (item.issale) { }}
                                <i class="fa fa-toggle-on unlock"></i>
                                {{# } else { }}
                                <i class="fa fa-toggle-off islock"></i>
                                {{# } }}
                            </td>
                         <%--   <td><a href="javascript:;" onclick="seeDesc('{{ item.id }}','{{ item.name}}')">查看详情</a></td>--%>
                        <%--'商品详情的存储字段',--%>
                            <td>
                                {{# if (item.issale) { }}
                                <a class="layui-btn layui-btn-small do-action" data-type="doAndRefresh"
                                   data-href="${changeSale}?id={{item.id}}"><i
                                        class="icon-edit  fa fa-pencil-square-o"></i>下线</a>
                                {{# } else { }}
                                <a class="layui-btn layui-btn-small do-action" data-type="doAndRefresh"
                                   data-href="${changeSale}?id={{item.id}}"><i
                                        class="icon-edit  fa fa-pencil-square-o"></i>上线</a>
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
</div>
    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script src="/resources/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        layui.use(["pagelist","layer"],function(){
            layer = layui.layer,
                    pagelist = layui.pagelist;

            pagelist.basePagingInit(15);
            pagelist.carListInit();
        });

        function seeDesc(id,name){
            $.post("/car/seeDesc",{"id":id},function (data){
                var title = "";
                var content = data.message;
                if(data.status==200){
                    title = name+"详情";
                }else{
                    title = "出错啦";
                }
                layer.open({
                    title: title,
                    area: 'auto',
                    maxWidth:1000,
                    content:content
                });
            },"json");
        }

        function selAllBtn(Obj){
            if($(Obj).attr("value")=="1"){
                $("input[name='selectNum']").removeAttr("checked");
                $(Obj).attr("value","0")
            }else{
                $("input[name='selectNum']").attr("checked",true);
                $(Obj).attr("value","1")
            }
        }

        function betchIssale(){
            layer.open({
                type: 1
                ,offset: 'auto'
                ,id: 'LAY_demo'
                ,content: '<div style="padding: 20px 100px;">'+ "上/下线选中的汽车" +'</div>'
                ,btn: ['全部上线', '全部下线']
                ,btnAlign: 'c' //按钮居中
                ,yes: function(){
                    layer.closeAll();
                    realFun2(1)
                },btn2: function(){
                    layer.closeAll();
                    realFun2(0)
                }
            });
        }

        function realFun2(btn){
            var param = [];
            $("input[name='selectNum']:checked").each(function(i,e){
                param.push($(this).val());
            });
            if(param.length!=0){
                $.post("${issale}?ids="+param.join(","),{"issale":btn},function(result){
                    var messgae = "操作失败";
                    if(result.status==200){
                        location.reload();
                    }
                },"json");
            }else{
                layer.msg('当前勾选的车辆为空哦', {
                    time: 10000,
                    btn:"确认"
                });
            }
        }

    </script>
</body>
</html>
