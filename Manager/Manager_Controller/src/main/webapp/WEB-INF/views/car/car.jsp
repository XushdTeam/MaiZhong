<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<head>
    <jsp:include page="../common/head.jsp"/>
    <title>
        <c:if test="${car!=null}">
            车辆信息修改
        </c:if>
        <c:if test="${car==null}">
            添加车辆信息
        </c:if>
    </title>
    <!-- 引入kindEditor插件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.10/themes/default/default.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/kindeditor-4.1.10/kindeditor-all-min.js" charset="utf-8"></script>
    <script src="/resources/js/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<div  class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>
            <a class="layui-btn layui-btn-small do-action" id="returnList" data-type="doAddEdit" data-href="/car/list"><i class="layui-icon">&#xe603;</i> 返回</a>
            <h2 style="display: inline">汽车添加</h2>
            <c:if test="${car!=null}">
                车辆信息修改
            </c:if>
            <c:if test="${car==null}">
                添加车辆
            </c:if>
        </h2>
    </blockquote>
    <div class="y-role">
        <fieldset class="layui-elem-field">
            <legend>车型
                <a class="layui-btn layui-btn-small do-action" id="toProp" data-type="doAddEdit" data-href="${seepropUrl}/"><i class="layui-icon">&#xe609;</i>点击查看属性</a>
            </legend>
            <div class="layui-field-box">

                <form class="layui-form" action="${updateCarUrl}"  method="post">
                    <input type="hidden" name="id" id="idInput" value="${car.id}">
                    <div class="layui-input-block">
                        <div class="layui-form-item layui-input-inline"  style="width: 50%">
                            <label class="layui-form-label">汽车编号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="number" required value="${car.number}"  lay-verify="required" placeholder="请输入汽车编号" autocomplete="off" class="layui-input">
                            </div>
                        </div>


                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">汽车分类</label>
                            <div class="layui-input-block" style="width: 50%">
                                <select name="carType" id="carType" lay-verify="required" >
                                    <option value=""></option>
                                    <c:forEach items="${carTypeList}" var="type">
                                        <c:if test="${car.carType==type.id}">
                                            <option value="${type.id}" selected="selected">${type.typeName}</option>
                                        </c:if>
                                        <c:if test="${car.carType!=type.id}">
                                            <option value="${type.id}">${type.typeName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                    </div>

                    <div class="layui-input-block">


                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">汽车品牌</label>
                            <div class="layui-input-block"  style="width: 50%">
                                <select name="carBrand"  lay-filter="carBrand"   lay-verify="required">
                                    <option value=""></option>
                                    <c:forEach items="${carBrandList}" var="brand" >
                                        <c:if test="${car.carBrand==brand.id}">
                                            <option value="${brand.id}" selected="selected">${brand.brandName}</option>
                                        </c:if>
                                        <c:if test="${car.carBrand!=brand.id}">
                                            <option value="${brand.id}">${brand.brandName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">汽车车系</label>
                            <div class="layui-input-inline">
                                <select name="carBrandLine" id="carBrandLine" lay-verify="required">
                                    <option value=""></option>
                                    <c:forEach items="${lineList}" var="line">
                                        <c:if test="${car.carBrandLine==line.id}">
                                            <option value="${line.id}" selected="selected">${line.lineName}</option>
                                        </c:if>
                                        <c:if test="${car.carBrandLine!=line.id}">
                                            <option value="${line.id}">${line.lineName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>


                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">年份</label>
                            <div class="layui-input-inline">
                                <select name="carYear" id="carYear"  lay-filter="carBase" placeholder="年份" lay-verify="required">
                                    <option value="">请选择汽车年份</option>
                                    <option value="0">不限</option>
                                    <c:forEach begin="1990" end="2020" var="year">
                                        <c:if test="${year==car.carYear}">
                                            <option value="${year}" selected >${year}</option>
                                        </c:if>
                                        <c:if test="${year!=car.carYear}">
                                            <option value="${year}">${year}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>


                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">汽车款式</label>
                            <div class="layui-input-inline">
                                <select name="baseId" id="car_base"  lay-filter="carColor"   lay-verify="required">
                                    <option value="">请先选中时间与车系</option>
                                    <c:forEach items="${carBaseVoList}" var="baseVo">
                                        <c:if test="${car.baseId==baseVo.id}">
                                            <option value="${baseVo.id}"    data-year='${baseVo.carYear}'  data-color='${baseVo.color}'  selected="selected">${baseVo.carName}</option>
                                        </c:if>
                                        <c:if test="${car.carBrandLine!=baseVo.id}">
                                            <option value="${baseVo.id}"  data-year='${baseVo.carYear}'  data-color='${baseVo.color}'>${baseVo.carName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>


                        <%--   js回显 汽车颜色     layui-input-inline --%>
                        <div class="layui-form-item" id="car_color_box" hidden>
                            <label class="layui-form-label">汽车颜色</label>
                            <div class="layui-input-inline">
                                <select name="color" id="car_color"  >
                                    <option value="">请选择车辆颜色</option>
                                </select>
                            </div>
                        </div>
                    </div>






                    <div class="layui-input-block">


                        <div class="layui-form-item  layui-input-inline">
                            <label class="layui-form-label">订金</label>
                            <div class="layui-input-inline">
                                <input type="text" name="reservePrice" value="${car.reservePrice}"  lay-verify="required" placeholder="页面显示金额" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item  layui-input-inline">
                            <label class="layui-form-label">售价</label>
                            <div class="layui-input-inline">
                                <input type="text" name="sellPrice"  value="${car.sellPrice}" lay-verify="required" placeholder="实际价格" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item layui-input-inline">
                            <label class="layui-form-label">是否上架</label>
                            <div class="layui-input-inline">
                                <c:if test="${car==null||car.unable==1}">
                                    <input type="radio" name="unable" value="1" title="上架"  checked="checked">
                                    <input type="radio" name="unable" value="0" title="下架">
                                </c:if>
                                <c:if test="${car!=null&&car.unable!=1}">
                                    <input type="radio" name="unable" value="1" title="上架" >
                                    <input type="radio" name="unable" value="0" title="下架"  checked="checked">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item  layui-input-inline">
                            <label class="layui-form-label">权重</label>
                            <div class="layui-input-inline">
                                <input type="text" name="weight" value="${car.weight}"  lay-verify="required" placeholder="权重，数值越大出现越靠前" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>

                    <div class="layui-form-item layui-input-block">
                        <label class="layui-form-label">卖点</label>
                        <div class="layui-input-block">
                            <input type="text" name="sellpoint"  value="${car.sellpoint}"  lay-verify="required" placeholder="请输入商品卖点" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item layui-input-block">
                        <div class="layui-form-label">图片上传</div>
                        <button type="button"  class="layui-btn layui-btn-normal" id="fileUpload">上传图片</button>
                        <div class="layui-input-block">
                            <input type="hidden" name="image" id="hiddenImgs" value="${car.image}" />
                        </div>
                    </div>

                    <div class="layui-input-block" id="imagesShow">
                    </div>

                    <%--<div class="layui-form-item layui-input-block">--%>
                        <%--<div class="layui-form-label">属性</div>--%>
                        <%--<div class="layui-input-block">--%>
                            <%--<a class="layui-btn layui-btn-small do-action" id="toProp" data-type="doAddEdit" data-href="${seepropUrl}/"><i class="layui-icon">&#xe609;</i>点击查看属性</a>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <div class="layui-input-block">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">普通文本域</label>
                            <div class="layui-input-block">
                                <textarea placeholder="请输入内容" name="details" id="cardetails" class="layui-textarea">
                                  ${car.details}
                                </textarea>
                            </div>
                        </div>
                    </div>



                    <div class="layui-form-item layui-input-block">
                        <div class="layui-input-inline">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即更改</button>
                            <button class="layui-btn" type="button" onclick="javascript:history.go(-1);">返回</button>
                        </div>
                        <div class="layui-input-inline">

                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
    </div>
</div>
<!-- js脚本 -->
<script type="text/javascript" src="/resources/js/event.js"></script>
<script type="text/javascript">



    layui.use('form', function(){
        var form = layui.form();

        //监听提交
        //ajax 提交
        //get请求
        form.on('submit(formDemo)', function(data){

            <!--富文本数据同步 同步方法-->
            itemAddEditor.sync();
            <!--添加参数-->
            data.field.details=$("#cardetails").val();
            <!--图片收集-->
            var imgArray = [];
             $.each($("#imagesShow img"),function(i,e){
                 imgArray.push($(e).attr("src"));
                 alert($(e).attr("src"));
             });
            data.field.image = imgArray.join(",");

//            layer.msg(JSON.stringify(data.field));
            //数据提交
            $.ajax({
                type:"POST",
                url:"${updateCarUrl}",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(data.field),
                success:function(result){
                    layer.msg(result.message);
                    if(result.status==200){
                        $("#returnList").click();
                    }
                }
            });
            return false;
        });


        //监听下拉框的选择   用于车系下拉框的动态回显   车系车型  品牌联动
        //TODO  目前页面Bug  选择品牌联动时  无法置空款式 和颜色
        form.on('select(carBrand)', function(data){
            var brandId = data.value; //得到被选中的值
            if(!brandId||brandId==""){
                return;
            }
            $.post("${lineListUrl}/"+brandId,function(result){
                if(result.status==200){
                    $("#carBrandLine").html("");
                    $("#carBrandLine").append("<option value=''>请选择</option>");
                    $.each(result.data,function(i,e){
                        $("#carBrandLine").append("<option value='"+e.id+"'>"+e.lineName+"</option>");
                    })
                }
                form.render('select');
            },"json")
        });



        //TODO 监听  车系下拉框和时间下拉框
        form.on('select(carBase)', function(data){

            $("#car_base").html("");
            $("#car_color").html("");
            $("#car_color_box").hide();
//            $("#car_color_box").removeClass("layui-input-inline");


            //TODO  汽车车系的选择
            $("#car_base").append("<option value=''>请选择</option>");

            if($("#carYear").val()==""||$("#carBrandLine").val()==""){
                return;
            }else{
                //显示最终的车型
                $.post("${findBaseCarUrl}/"+$("#carBrandLine").val()+"/"+$("#carYear").val(),function(result){
                    if(result.status==200){
                        $.each(result.data,function(i,e){
                            //颜色的处理
                            $("#car_base").append("<option value='"+e.id+"'  data-year='"+e.carYear+"'  data-color='"+e.color+"' >"+e.carName+"</option>");
                        })
                        form.render('select');
                    }
                },"json")
            }
        });


        //TODO 监听  车型选择
        form.on('select(carColor)', function(data){
            $("#car_color").html("");
            if(data.value==""){
                return;
            }




            var color = $("#car_base :selected").data("color").split(";");
            //判断是否达成颜色显示条件
            if(color&&color.length>0&&color[0]!=""){
                $("#car_color").append("<option value=''>请选择</option>");
                $.each(color,function(i,e){
                    $("#car_color").append("<option value='"+e+"' >"+e+"</option>");
                })
//                $("#car_color_box").addClass("layui-input-inline")
                $("#carYear option[value='"+$("#car_base :selected").data("year")+"']").attr("selected","");
                $("#car_color_box").show();
            }
            form.render('select');
            //TODO  颜色遍历
        });

        <c:if test="${car!=null}">

            //        图片回显
            $.each($("#hiddenImgs").val().split(","),function(i,e){
                if($.trim(e).length > 0){
                    $("#imagesShow").append('<div class="layui-input-block" ><a href="'+e+'"  target="_blank"><img  style="width: 690px;height: 366px"  src="'+e+'"></a><button type="button" class="layui-btn layui-btn-warm" onclick="delImage(this)">删除<button/></div>');
                }
            });


            //页面刷新方法  用于颜色回显
            if($("#car_base").val()!=null&&$("#car_base").val()!=""){
                var color = $("#car_base :selected").data("color").split(";");
                //判断是否达成颜色显示条件
                if(color&&color.length>0&&color[0]!=""){
                    $.each(color,function(i,e){
                        if(e=='${car.color}'){
                            $("#car_color").append("<option value='"+e+"' selected >"+e+"</option>");
                        }else{
                            $("#car_color").append("<option value='"+e+"'  >"+e+"</option>");
                        }
                    })
                    $("#car_color").append("<option value=''>请选择</option>");
                    $("#car_color_box").show();
                    form.render('select');
                }
            }
        </c:if>


    });

    <!--图片上传以及富文本编译器-->
    $(function(){

        $("#toProp").attr("data-href","${seepropUrl}/"+$("#idInput").val());


        var kindEditorParams = {
            //指定上传文件参数名称
            filePostName  : "uploadFile",
            //指定上传文件请求的url。
            uploadJson : '/file/upload',
            //上传类型，分别为image、flash、media、file
            dir : "image",
            allowFileManager : true
        }

        //创建富文本编辑器
        itemAddEditor = KindEditor.create("#cardetails",kindEditorParams);
        $("#cardetails").click(function(){
            var _self = $(this);
            KindEditor.editor(kindEditorParams).loadPlugin('image', function() {
                this.plugin.imageDialog({
                    showRemote : false,
                    clickFn : function(url, title, width, height, border, align) {

                        //添加图片成功之后的回显
                        $("#imagesShow").append('<div class="layui-input-block" ><a href="'+url+'"  target="_blank"><img  style="width: 690px;height: 366px"  src="'+url+'"></a><button type="button" class="layui-btn layui-btn-warm" onclick="delImage(this)">删除<button/></div>');
                    }
                });
            });
        });

        <!--图片上传-->

        //给“上传图片按钮”绑定click事件
        $("#fileUpload").click(function(){
            var formTable = $(this).parentsUntil("form").parent("form");
            //打开图片上传窗口
            KindEditor.editor(kindEditorParams).loadPlugin('multiimage',function(){
                var editor = this;
                editor.plugin.multiImageDialog({
                    clickFn : function(urlList) {
                        var imgArray = [];
                        KindEditor.each(urlList, function(i, data) {
                            imgArray.push(data.url);
                            $("#imagesShow").append('<div class="layui-input-block" ><a href="'+data.url+'"  target="_blank"><img  style="width: 690px;height: 366px"  src="'+data.url+'"></a><button type="button" class="layui-btn layui-btn-warm" onclick="delImage(this)">删除<button/></div>');
                        });
                        formTable.find("[name=image]").val(imgArray.join(","));
                        editor.hideDialog();
                    }
                });
            });
        });
    })


    function delImage(obj){
        if(confirm("确定删除？")){
            $(obj).parent().remove();
        }

    }
</script>
</body>
</html>