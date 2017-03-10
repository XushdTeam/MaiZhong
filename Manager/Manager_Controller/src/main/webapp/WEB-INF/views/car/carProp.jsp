<%--
  Created by IntelliJ IDEA.
  User: yangF
  Date: 2017/3/9
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>汽车属性</title>
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<div class="main-wrap" data-href="${baseUrl}">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>属性编辑</h2>
    </blockquote>
    <div class="site-text site-block">
        <form class="layui-form layui-form-pane" >
            <input type="hidden" value="${prop.id}" name="id"/>
            <input type="hidden" value="${carId}" name="carId"/>
            <%--`id` bigint(10) NOT NULL COMMENT '主键',--%>
            <%--`car_id` bigint(10) NOT NULL COMMENT '对应的汽车id',--%>
            <%--`unable` int(1) NOT NULL DEFAULT '1' COMMENT '是否可用',--%>
            <%--`manufacturers` varchar(50) DEFAULT NULL COMMENT '生产厂商  先不考虑数据字典',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">生产厂商</label>
                <div class="layui-input-block">
                    <input name="manufacturers" autocomplete="off" value="${prop.manufacturers}"
                           placeholder="生产厂商 上海通用" class="layui-input" type="text">
                </div>
            </div>
            <%--`construction` varchar(50) DEFAULT NULL COMMENT '车身结构 类似4门5座三厢车',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">车身结构</label>
                <div class="layui-input-block">
                    <input name="construction" autocomplete="off" value="${prop.construction}"
                           placeholder="车身结构 类似4门5座三厢车" class="layui-input" type="text">
                </div>
            </div>
            <%--`size` varchar(10) DEFAULT NULL COMMENT '车身大小  例：4643*1797*1479',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">车身大小</label>
                <div class="layui-input-block">
                    <input name="size" autocomplete="off" value="${prop.manufacturers}"
                           placeholder="大小 4643*1797*1479'" class="layui-input" type="text">
                </div>
            </div>
            <%--`axle_distance` double DEFAULT NULL COMMENT '轴距  轮胎轴心之间的距离',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">轴距</label>
                <div class="layui-input-block">
                    <input name="axleDistance" autocomplete="off" value="${prop.axleDistance}"
                           placeholder="轴距  轮胎轴心之间的距离" class="layui-input" type="text">
                </div>
            </div>
            <%--`engine` varchar(20) DEFAULT NULL COMMENT '发动机类型 例：L型4缸',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">车身结构</label>
                <div class="layui-input-block">
                    <input name="engine" autocomplete="off" value="${prop.engine}"
                           placeholder="发动机类型 例：L型4缸" class="layui-input" type="text">
                </div>
            </div>
            <%--`oil_num` varchar(20) DEFAULT NULL COMMENT '燃油编号 94#',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">燃油编号</label>
                <div class="layui-input-block">
                    <input name="oilNum" autocomplete="off" value="${prop.oilNum}"
                           placeholder="燃油编号 94#" class="layui-input" type="text">
                </div>
            </div>
            <%--`capacity` varchar(20) DEFAULT NULL COMMENT '汽车排量',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">车身结构</label>
                <div class="layui-input-block">
                    <input name="capacity" autocomplete="off" value="${prop.capacity}"
                           placeholder="汽车排量" class="layui-input" type="text">
                </div>
            </div>
            <%--`oil_cost` varchar(20) DEFAULT NULL COMMENT '油耗',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">油耗</label>
                <div class="layui-input-block">
                    <input name="oilCost" autocomplete="off" value="${prop.oilCost}"
                           placeholder="油耗" class="layui-input" type="text">
                </div>
            </div>
            <%--`environment_norm` varchar(20) DEFAULT NULL COMMENT '环保标准',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">环保标准</label>
                <div class="layui-input-block">
                    <input name="environmentNorm" autocomplete="off" value="${prop.environmentNorm}"
                           placeholder="环保标准 " class="layui-input" type="text">
                </div>
            </div>
            <%--`speed_100` varchar(20) DEFAULT NULL COMMENT '百米加速度',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">百米加速度</label>
                <div class="layui-input-block">
                    <input name="speed100" autocomplete="off" value="${prop.speed100}"
                           placeholder="百米加速度" class="layui-input" type="text">
                </div>
            </div>
            <%--`protect_limit` varchar(20) DEFAULT NULL COMMENT '质保限制  三年或者10w公里',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">质保限制</label>
                <div class="layui-input-block">
                    <input name="protectLimit" autocomplete="off" value="${prop.protectLimit}"
                           placeholder="质保限制  三年或者10w公里" class="layui-input" type="text">
                </div>
            </div>
            <%--`speed_high` double DEFAULT NULL COMMENT '最高时速',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">车身结构</label>
                <div class="layui-input-block">
                    <input name="speedHigh" autocomplete="off" value="${prop.speedHigh}"
                           placeholder="最高时速" class="layui-input" type="text">
                </div>
            </div>
            <%--`drive_type` varchar(20) DEFAULT NULL COMMENT '驱动方式  例：前轮驱动',--%>
            <div class="layui-form-item">
                <label class="layui-form-label">车身结构</label>
                <div class="layui-input-block">
                    <input name="driveType" autocomplete="off" value="${prop.driveType}"
                           placeholder="驱动方式  例：前轮驱动" class="layui-input" type="text">
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-submit lay-filter="propSeve" id="saveBtn" >保存</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </form>
    </div>
    <div class="fhui-admin-pagelist"></div>

    <script type="text/javascript" src="/resources/js/event.js"></script>
    <script type="text/javascript">

        layui.use('form', function() {
            var form = layui.form(),$= layui.jquery;

            form.on('submit(propSeve)', function(data){
                alert("测试");
                $.ajax({
                    type:"POST",
                    url:"${saveUrl}",
                    dataType:"json",
                    contentType:"application/json",
                    data:JSON.stringify(data.field),
                    success:function(result){
                        alert("xxx");
//                        layer.msg(result.message);
//                        if(result.status==200){
//                            alert("添加成功");
//                        }
                    },error:function(result){
                        alert("yyy");

                    }
                })
                alert("测试");
                return false;
            });
        })
    </script>
</div>
</body>
</html>