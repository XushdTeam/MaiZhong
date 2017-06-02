<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/1
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>所有品牌</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.indexedlist.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/animation.css" />
    <style>
        html,
        body{
            height: 100%;
            overflow: hidden;
        }

        .mui-indexed-list-search a {
            margin: 5px;
            display: inline-block;
            text-align: center;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 6px 7px 4px 2px;
            background-clip: padding-box;
            font-size: 16px;
        }
        .mui-indexed-list-bar {
            top: 5%;
            z-index: 90;
        }
        .mui-grid-view.mui-grid-9 {
            background-color: #FFFFFF!important;
        }
        .mui-media-body{
            line-height: 42px!important;
        }
        .mui-table-view.mui-grid-view .mui-table-view-cell {
            width: 25%;
        }
        .hot{
            line-height: 15px!important;
        }
        .lileft{
            text-align: left;
            padding: 10px 15px!important;
        }

        .mui-table-view li:active{
            background: #FFF!important;
        }

    </style>
</head>
<body>
<div id="app" class="mui-content">
    <transition name="fade">
        <div v-show="loading" class="loading">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
    </transition>
    <div id='list' class="mui-indexed-list" v-cloak >
        <div class="mui-indexed-list-search mui-input-row" style="display: none;"></div>
        <div class="mui-indexed-list-bar">
            <a>A</a>
            <a>B</a>
            <a>C</a>
            <a>D</a>
            <a>F</a>
            <a>G</a>
            <a>H</a>
            <a>J</a>
            <a>K</a>
            <a>L</a>
            <a>M</a>
            <a>N</a>
            <a>O</a>
            <a>P</a>
            <a>Q</a>
            <a>R</a>
            <a>S</a>
            <a>T</a>
            <a>W</a>
            <a>X</a>
            <a>Y</a>
            <a>Z</a>
        </div>
        <div class="mui-indexed-list-alert"></div>
        <div class="mui-indexed-list-inner" id ="inner">
            <transition name="fade">
                <ul class="mui-table-view" v-show="!loading">
                    <template v-for="(vo,index) in brandData">
                        <li v-if="vo.id==0" :data-group="vo.initial"
                            class="mui-table-view-divider mui-indexed-list-group">{{vo.initial}}</li>
                        <li v-else class="mui-table-view-cell mui-indexed-list-item"
                            v-tap="{methods:brandChange,id:vo.id}">
                            <img class="mui-media-object mui-pull-left"
                                 src="/resources/wap/image/placeholder.png"
                                 :data-src='vo.img'>
                            <div class="mui-media-body">{{vo.name}}</div>
                        </li>
                    </template>
                </ul>
            </transition>
        </div>
    </div>

    <div id="menu-wrapper" class="menu-wrapper hidden">
        <div id="menu" class="menu">
            <div v-show='loading2' class="innerLoading">
                <span class="mui-spinner"></span>
            </div>
            <ul class="mui-table-view" v-show='!loading2'>
                <template v-for="(s,si) in seriesData" name="fade">
                    <li v-if="s.seriesId==0" class="mui-table-view-divider mui-indexed-list-group lileft" v-show="s.seriesGroupName">{{s.seriesGroupName}}</li>
                    <li v-else class="mui-table-view-cell mui-indexed-list-item lileft"
                        v-tap="{methods:seriesChange,id:s.seriesId}">
                        {{s.seriesName}}
                    </li>
                </template>

            </ul>
        </div>
    </div>
    <div id="menu-backdrop" class="menu-backdrop" v-tap="{methods:closeMenu}" ></div>
</div>
<script type="text/javascript" src="/resources/wap/script/api.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.min.js"></script>
<script type="text/javascript" src="/resources/wap/script/mui.indexedlist.js"></script>
<script type="text/javascript" src="/resources/wap/script/vue.js"></script>
<script type="text/javascript" src="/resources/wap/script/common.js"></script>
<script type="text/javascript" src="/resources/wap/script/lazy-load-img.min.js" ></script>
<script type="text/javascript" src="/resources/wap/script/interface.js"></script>
<script>
    vm = new Vue({
        el: '#app',
        data:{
            brandData:[],
            seriesData:[],
            loading:true,
            loading2:true
        },
        methods:{
            brandChange :function(param){
                var brandId = param.id;
                if(brandId){
                    vm.loading2 = true;
                    vm.seriesData=[];
                    mui.ajax()
                    InterFace.getSeriesByBrandId(brandId,function(e,r){
                        if(e){
                            console.log(JSON.stringify(e))
                        }else{
                            vm.seriesData = r.data;
                            vm.loading2 = false;
                        }
                    })

                    toggleMenu();

                }
            },
            seriesChange:function(param){
                window.location.href = "/m/model/"+param.id;
            },
            closeMenu:function(){
                toggleMenu();
            }
        }
    })
    mui.ready(function() {
        var list = document.getElementById('list');
        //calc hieght
        list.style.height = document.body.offsetHeight + 'px';
        //create
        window.indexedList = new mui.IndexedList(list);
        mui('.menu-wrapper').scroll({deceleration: 0.0005});

        mui.getJSON('${OSS}/allbrand.json',function(d){
            vm.brandData = d;
            lazyLoadImg()
            vm.loading = false;
        });
    });

    var menuWrapper = document.getElementById("menu-wrapper");
    var menu = document.getElementById("menu");
    var menuWrapperClassList = menuWrapper.classList;
    var backdrop = document.getElementById("menu-backdrop");
    var busying = false;


    var toggleMenu = function () {
        if (busying) {
            return;
        }
        busying = true;
        if (menuWrapperClassList.contains('mui-active')) {

            document.body.classList.remove('menu-open');
            menuWrapper.className = 'menu-wrapper fade-out-up animated';
            setTimeout(function() {
                backdrop.style.opacity = 0;
                menuWrapper.classList.add('hidden');
                $api.dom("#inner").style.overflowY = 'auto';
            },200)


        } else {
            backdrop.style.opacity = 1;
            mui('.menu-wrapper').scroll().scrollTo(0,0,100);
            $api.dom("#inner").style.overflowY = 'hidden';
            setTimeout(function() {
                document.body.classList.add('menu-open');
                menuWrapper.className = 'menu-wrapper fade-in-down animated mui-active';
            },200)

        }
        setTimeout(function() {
            busying = false;
        }, 500);
    }

</script>
</body>
</html>
