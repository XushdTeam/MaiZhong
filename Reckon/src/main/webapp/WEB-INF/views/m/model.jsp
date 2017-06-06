<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/1
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>车型选择</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <style>
        .mui-content>.mui-table-view:first-child {
            margin-top: 0px;
        }
        .mui-h5{
            font-size: 14px;
            font-weight: 400;
            color: #e2544f;
            top: -5px;
        }
        .mui-ellipsis{
            width: 100%;
        }
        .mui-btn{
            margin-right: 15px;
            margin-top: 5px;
            margin-bottom: 5px;
        }

        .mui-btn:active{
            background: #F60!important;
        }
        .btn-select{
            background: #F60!important;
            border: 1px solid #FF2600;
            color: #FFF;
        }
        .hide{
            display: none;
        }
    </style>
</head>
<body>
<div id="app" class="mui-content" v-cloak>
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
        <div class="mui-content" v-show="!loading">
            <ul class="mui-table-view">
                <li class="mui-table-view-divider mui-indexed-list-group">手自动档</li>
                <li>
                    <div class="mui-content-padded">
                        <button v-for="v in gears" type="button"
                                class="mui-btn" :class="{'btn-select':gear==v}"
                                v-tap="{methods:search,filed:v,type:'g'}">
                            {{v}}
                        </button>
                    </div>
                </li>
                <li class="mui-table-view-divider mui-indexed-list-group">排量</li>
                <li class="">
                    <div class="mui-content-padded">
                        <button v-for="v in liters" type="button"
                                class="mui-btn" :class="{'btn-select':liter==v}"
                                v-tap="{methods:search,filed:v,type:'l'}">
                            {{v}}
                        </button>
                    </div>
                </li>
                <template v-for="(vo,index) in modelList">
                    <li v-if="vo.group==1" class="mui-table-view-divider mui-indexed-list-group">{{vo.model_year}}款</li>
                    <li v-else class="mui-table-view-cell mui-indexed-list-item"
                        v-tap="{methods:modelChange,modelId:vo.model_id}"
                        v-show="isshow(vo)"
                    >
                        <div class="mui-table">
                            <div class="mui-table-cell mui-col-xs-10">
                                <span class="mui-ellipsis2">{{vo.model_name}}</span>
                            </div>
                            <div class="mui-table-cell mui-col-xs-3 mui-text-right">
                                <span class="mui-h5">{{vo.model_price}}万  </span>
                            </div>
                        </div>
                    </li>
                </template>
            </ul>
        </div>
    </transition>
</div>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js" ></script>
<script type="text/javascript" src="/resources/wap/script/interface.js"></script>
<script>

    vm = new Vue({
        el: '#app',
        data:{
            loading:true,
            modelList:[],
            gears:[],
            gear:0,
            liters:[],
            liter:0,
            child:false
        },
        methods:{
            modelChange:function(param){
                var modelId = param.modelId;
                if(modelId){
                    window.location.href= "/m/computed/"+modelId;
                }
            },search:function(param){
                if(param.type=='g'){
                    if(param.filed==this.gear){
                        this.gear=0
                        return
                    }else{
                        this.gear = param.filed
                    }
                }else{
                    if(param.filed==this.liter){
                        this.liter=0
                        return
                    }else{
                        this.liter = param.filed
                    }
                }

            },isshow:function(item){
                if(this.gear&&!this.liter){
                    if(item.gear_type==this.gear){
                        return true;
                    }else{
                        return false;
                    }
                }else if(!this.gear&&this.liter){
                    if(item.liter==this.liter){
                        return true;
                    }else{
                        return false;
                    }
                }else if(this.gear&&this.liter){
                    if(item.gear_type==this.gear&&item.liter == this.liter){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return true;
                }
            }

        }
    })
    var seriesId = "${seriesId}";
    mui.ready(function(){

        InterFace.getModelBySeriesId(seriesId,function(e,r){
            if(e){
                console.log(JSON.stringify(e))
            }else{

                var modelYear = 9999,liter=0,gear=0;
                var newList = [],liters=[],gears=[];
                $api.each(r.data,function(j,i){
                    if(i.model_year!=modelYear){
                        modelYear = i.model_year;
                        newList.push({model_year:modelYear,group:1});
                    }
                    if(!contains(liters,i.liter)){liters.push(i.liter)}
                    if(!contains(gears,i.gear_type)){gears.push(i.gear_type)}
                    i.group = 0;
                    newList.push(i);

                })
                vm.modelList = newList;
                vm.liters = liters;
                vm.gears = gears;
                vm.loading = false;
            }
        })


    });

    function contains(arr, obj) {
        var i = arr.length;
        while (i--) {
            if (arr[i] === obj) {
                return true;
            }
        }
        return false;
    }
</script>
</body>
</html>
