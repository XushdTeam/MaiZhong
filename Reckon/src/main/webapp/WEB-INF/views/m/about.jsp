<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/6
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>关于我们</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <style>
        .mui-content{
            background: #FFF;
        }
    </style>
</head>

<body>
<div class="mui-content" id="app">
    <div class="mui-content-padded">
        <div class="qrcode" style="text-align: center;margin-bottom: 10px;margin-top: 20px;">
            <img id="qrcode" src="/resources/wap/image/icon.png"  width="120"/>
        </div>
        <!--<h4 style="margin-top:10px;">mui</h4>-->
        <p style="padding: 10px;line-height: 25px;">悟空收车（www.wukongshouche.com）致力于打造全新的二手车线上交易置换的专业服务平台。
            悟空收车专注于为各大汽车集团、经销商、企事业单位、私家车车主服务。采用线上交易模式，将复杂的卖车环节简单化，卖车价格透明化，并与多家4S店达成合作，为用户提供优质便捷的上门交易业务和一站式置换服务。让交易二手车这件事发生彻底的改变，不再东奔西跑，简单、省心。 悟空收车拥有一支高素质的员工团队，在长期的经营实践和“专业专注，贴心服务，信誉第一，客户至上”的经营思想指导下，以高质量、高素质、高水平的专业服务标准，赢得了各大汽车集团、经销商、企事业单位、私家车车主的认可与信赖。</p>
        <p style="text-align: center;color: #ccc;text-indent: 0;"></p>
    </div>
</div>
</body>
<script type="text/javascript" src="/resources/wap/script/vue.js" ></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            version:''
        },
        methods:{

        },
        computed: {

        }
    })


</script>

</html>

