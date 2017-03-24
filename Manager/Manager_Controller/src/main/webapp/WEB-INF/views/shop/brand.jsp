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
    <title>品牌管理</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>品牌管理</h2>
    </blockquote>
    <div class="y-role">
        <div class="search-bar">
            <!--查询区-->
            <form class="layui-form layui-form-pane">
                <div class="layui-inline">
                    <label class="layui-form-label">品牌名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="brandName" value="" placeholder="品牌名称" class="layui-input">
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
                        <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit"  data-href="${handleUrl}/new"><i class="fa fa-plus"></i></i>新增品牌</a>
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
                    <col width="55%" >
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>品牌LOGO</th>
                    <th>品牌名称</th>
                    <th>显示顺序</th>
                    <th>是否启用</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <script id="tpl" type="text/html">
                    {{#  layui.each(d.rows, function(index, item){ }}
                    <tr>
                        <td>{{ item.id }}</td>
                        <td><img src="{{ item.brandImg }}" width="50" height="50"/></td>
                        <td>{{ item.brandName }}</td>
                        <td>{{ item.brandSequence}}</td>
                        <td align="center">{{# if (item.status) { }}
                            <i class="fa fa-toggle-on unlock"></i>
                            {{# } else { }}
                            <i class="fa fa-toggle-off islock"></i>
                            {{# } }}
                        </td>
                        <td>
                    <%--        <a class="layui-btn layui-btn-small" onclick="showLine('{{ item.id }}')"><i class="icon-edit  fa fa-pencil-square-o"></i>显示车系</a>--%>
                            <a class="layui-btn layui-btn-small do-action" data-type="doAddEdit" data-href="${handleUrl}/{{item.id}}"><i class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            <a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete" data-text="确定删除<span class=red>{{item.brandName}}</span>吗？" data-href="${deleteUrl}/{{item.id}}"><i class="icon-trash-o  fa fa-trash-o"></i>删除</a>
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


        <%--   <!--车系列表-->
  <div id="hideDiv" style="display:none">
      <table class="layui-table" lay-skin="line">
          <thead>
          <tr>
              <th>ID</th>
              <th>车系名称</th>
              <th>显示顺序</th>
              <th>是否启用</th>
              <th>操作</th>
          </tr>
          </thead>
          <tbody id="linelist">
          </tbody>
      </table>
  </div>

  <!--车系添加-->
&lt;%&ndash; &ndash;%&gt;
      <div  id="hideInsert" style="display:none">
          <div class="site-text site-block">
              <form  class="layui-form layui-form-pane">
                  <input name="id" type="hidden" >
                  <input name="brandId" type="hidden" >
                  <div class="layui-form-item">
                      <label class="layui-form-label">车系名称</label>
                      <div class="layui-input-block">
                          <input name="lineName" autocomplete="off" lay-verify="required" maxlength="50"
                                 placeholder="汽车车系名称  例：辉腾" class="layui-input" type="text">
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label class="layui-form-label">车系顺序</label>
                      <div class="layui-input-block">
                          <input name="lineSequence" autocomplete="off" lay-verify="number" maxlength="50"
                                 placeholder="车系顺序 顺序越小越靠前" class="layui-input" type="text">
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label class="layui-form-label">是否启用</label>
                      <div class="layui-input-block">
                          <input type="radio" name="status" value="1" title="启用" checked="checked" >
                          <input type="radio" name="status" value="0" title="停用" >
                      </div>
                  </div>
                  <div class="layui-form-item" style="display: none;">
                      <div class="layui-input-block">
                          <button class="layui-btn" id="submitBtn"  lay-submit lay-filter="submitBtn" data-href="${insertLineUrl}">添加品牌</button>
                      </div>
                  </div>
              </form>
          </div>
      </div>--%><%--   &lt;%&ndash; &ndash;%&gt;
            <div  id="hideInsert" style="display:none">
                <div class="site-text site-block">
                    <form  class="layui-form layui-form-pane">
                        <input name="id" type="hidden" >
                        <input name="brandId" type="hidden" >
                        <div class="layui-form-item">
                            <label class="layui-form-label">车系名称</label>
                            <div class="layui-input-block">
                                <input name="lineName" autocomplete="off" lay-verify="required" maxlength="50"
                                       placeholder="汽车车系名称  例：辉腾" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">车系顺序</label>
                            <div class="layui-input-block">
                                <input name="lineSequence" autocomplete="off" lay-verify="number" maxlength="50"
                                       placeholder="车系顺序 顺序越小越靠前" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">是否启用</label>
                            <div class="layui-input-block">
                                <input type="radio" name="status" value="1" title="启用" checked="checked" >
                                <input type="radio" name="status" value="0" title="停用" >
                            </div>
                        </div>
                        <div class="layui-form-item" style="display: none;">
                            <div class="layui-input-block">
                                <button class="layui-btn" id="submitBtn"  lay-submit lay-filter="submitBtn" data-href="${insertLineUrl}">添加品牌</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>--%><%--   &lt;%&ndash; &ndash;%&gt;
            <div  id="hideInsert" style="display:none">
                <div class="site-text site-block">
                    <form  class="layui-form layui-form-pane">
                        <input name="id" type="hidden" >
                        <input name="brandId" type="hidden" >
                        <div class="layui-form-item">
                            <label class="layui-form-label">车系名称</label>
                            <div class="layui-input-block">
                                <input name="lineName" autocomplete="off" lay-verify="required" maxlength="50"
                                       placeholder="汽车车系名称  例：辉腾" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">车系顺序</label>
                            <div class="layui-input-block">
                                <input name="lineSequence" autocomplete="off" lay-verify="number" maxlength="50"
                                       placeholder="车系顺序 顺序越小越靠前" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">是否启用</label>
                            <div class="layui-input-block">
                                <input type="radio" name="status" value="1" title="启用" checked="checked" >
                                <input type="radio" name="status" value="0" title="停用" >
                            </div>
                        </div>
                        <div class="layui-form-item" style="display: none;">
                            <div class="layui-input-block">
                                <button class="layui-btn" id="submitBtn"  lay-submit lay-filter="submitBtn" data-href="${insertLineUrl}">添加品牌</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>--%><%--   &lt;%&ndash; &ndash;%&gt;
            <div  id="hideInsert" style="display:none">
                <div class="site-text site-block">
                    <form  class="layui-form layui-form-pane">
                        <input name="id" type="hidden" >
                        <input name="brandId" type="hidden" >
                        <div class="layui-form-item">
                            <label class="layui-form-label">车系名称</label>
                            <div class="layui-input-block">
                                <input name="lineName" autocomplete="off" lay-verify="required" maxlength="50"
                                       placeholder="汽车车系名称  例：辉腾" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">车系顺序</label>
                            <div class="layui-input-block">
                                <input name="lineSequence" autocomplete="off" lay-verify="number" maxlength="50"
                                       placeholder="车系顺序 顺序越小越靠前" class="layui-input" type="text">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">是否启用</label>
                            <div class="layui-input-block">
                                <input type="radio" name="status" value="1" title="启用" checked="checked" >
                                <input type="radio" name="status" value="0" title="停用" >
                            </div>
                        </div>
                        <div class="layui-form-item" style="display: none;">
                            <div class="layui-input-block">
                                <button class="layui-btn" id="submitBtn"  lay-submit lay-filter="submitBtn" data-href="${insertLineUrl}">添加品牌</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>--%>



        <!--分页 -->
    </div>
    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">
        layui.use(['pagelist','layer','form'],function(){
            $ = layui.jquery,layer = layui.layer,form = layui.form();

            layui.pagelist.basePagingInit(6);

            openId = null;

            form.on("submit(submitBtn)", function (formdata) {
//                alert(JSON.stringify(formdata.field))
                $.ajax({
                    type:"POST",
                    url:"${insertLineUrl}",
                    dataType:"json",
                    contentType:"application/json",
                    data:JSON.stringify(formdata.field),
                    success:function(result){
                        layer.msg(result.message);
                        layer.closeAll();
                        showLine(openId)
//                        layer.close(index);
                    }
                });
                return false;
            });
        });

        function showLine(id){
            layer.closeAll();
            openId = id;
            $("#linelist").html("");
            //数据遍历
            $.post("${lineListUrl}/"+id,function(result){
                if(result.status==200){
                    $.each(result.data,function(i,e){
                        var stauts = e.status==1?'启用':'停用';

                        $("#linelist").append('<tr><td>'+e.id+'</td><td>'+e.lineName+'</td> <td>'+e.lineSequence+'</td><td align="center">'
                                +stauts+'</td><td>'
                                +'<a class="layui-btn layui-btn-small" onclick="insertLineUI(\''+e.brandId+'\',\''+e.id+'\',\''+e.lineName+'\',\''+e.lineSequence+'\',\''+e.status+'\')"><i class="icon-edit  fa fa-pencil-square-o"></i>修改</a>'
                                +'<a class="layui-btn layui-btn-small layui-btn-danger do-action" data-type="doDelete" data-text="确定删除<span class=red>'+e.lineName+'</span>吗？" data-href="${deleteLineUrl}/'+e.id+'"><i class="icon-trash-o  fa fa-trash-o"></i>删除</a>'
                                +'</td></tr>');
                    })
                    showLineCallBack(id);
                }else{
                    layer.msg(result.message);
                }
            },"json")
        }


        function showLineCallBack(brandId){
            //打开弹框
            layer.open({
                type: 1
                ,title: '车系列表'
                ,area:'900px'
                ,shade: 0
                ,content: $("#hideDiv").html()
                ,btn: ['添加', '全部关闭'] //只是为了演示
                ,yes: function(){
                    insertLineUI(brandId);
                }
                ,btn2: function(){
                    layer.closeAll();
                }
                ,zIndex: layer.zIndex
            });
        }


        //数据添加
        function insertLineUI(brandId,id,lineName,lineSequence,status) {

            //数据准备以及初始化
            $("input[name!='status']").val("");
            //如果id在  说明是更改
            var btnText = "确认保存";
            if(id){
                //数据填充
                $("input[name='id'][type='hidden']").val(id);
                $("input[name='lineName']").val(lineName);
                $("input[name='lineSequence']").val(lineSequence);
                btnText = "确认修改";
            }

            if(!status){
                status = 1 ;
            }
            $("input[name='status'][value='"+status+"']")[0].click();


            if(brandId){
                $("input[name='brandId'][type='hidden']").val(brandId);
            }else{
                layer.msg("错误");
                return;
            }


            index = layer.open({
                type: 1
                ,title: '车系'
                ,area:'900px'
                ,shade: 0
                ,content:$("#hideInsert")
                ,btn: [btnText, '取消']
                ,yes: function(){
                    $("#submitBtn").click();
                }
                ,btn2: function(){
                    layer.close(index);
                }
                ,zIndex: layer.zIndex
                ,success: function(layero){
                    layer.setTop(layero);
                    form.render();
                }
            });
        }
    </script>
</div>
</body>
</html>
