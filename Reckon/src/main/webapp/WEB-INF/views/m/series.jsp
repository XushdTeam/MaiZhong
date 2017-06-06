<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/5
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>车系</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />

</head>

<body>
<div class="mui-content" id="app" v-cloak>
    <transition name="fade">
        <div v-show="loading" class="loading">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
    </transition>
    <transition name="fade">
        <div v-show="!loading" >
            <ul class="mui-table-view">
                <li class="mui-table-view-cell mui-media">
                    <img class="mui-media-object mui-pull-left" :src="model.largeLogo" :data-img='model.largeLogo' >
                    <div class="mui-media-body" style="line-height: 42px;">
                        {{model.brand}}
                    </div>
                </li>
                <template v-for="(s,si) in seriesData" name="fade">
                    <li v-if="s.seriesId==0" class="mui-table-view-divider mui-indexed-list-group lileft" v-show="s.seriesGroupName">{{s.seriesGroupName}}</li>
                    <li v-else class="mui-table-view-cell mui-indexed-list-item lileft"
                        v-tap="{methods:seriesChange,id:s.seriesId}">
                        {{s.seriesName}}
                    </li>
                </template>
            </ul>
        </div>
    </transition>
</div>
</body>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js"></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            loading:true,
            seriesData:[],
            model:{}
        },
        methods:{
            seriesChange:function(param){
                window.location.href = "/m/model/"+param.id;
            }
        },
        computed: {

        }
    })
    mui.ready(function(){
        var model = $api.getStorage('hotbrandItem')
        if(model)vm.model = model
        vm.seriesData = ${data}
        vm.loading = false
    })

</script>

</html>
