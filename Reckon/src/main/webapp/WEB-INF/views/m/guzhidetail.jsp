<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/6/5
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>精准价格</title>
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/api.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/mui/mui.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/resources/wap/css/eval_result.css" />
    <style>
        .des{
            margin: .5rem 0;
        }
        .des>li{
            font-size: 14px;
            color: #8f8f94;
            padding: 0.75rem;
        }
        .Btn{
            margin: 1.25rem 0.75rem;
        }
        .s-1 > ul {
            margin: 5px 0 10px;
        }
        .s-1 > ul > li > div:first-of-type {
            color: #999;
            margin-bottom: 5px;
        }

    </style>
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
        <div class="main" v-show="!loading">
            <div class="mui-card-content">
                <section class="s-1">
                    <div class="clearfix">
                        <img class="seriesPic" alt="" :src="model.seriesImg">
                        <div class="des">
                            <strong class="modelName">{{model.modelName}}</strong>
                        </div>
                    </div>
                    <ul>
                        <li>
                            <div>所在城市</div>
                            <div>{{model.city}}</div>
                        </li>
                        <li>
                            <div>上牌日期</div>
                            <div>{{model.regdate}}</div>
                        </li>
                        <li>
                            <div>行驶里程</div>
                            <div>{{model.mail}}万公里</div>
                        </li>
                        <li>
                            <div>排量</div>
                            <div>{{model.liter}}</div>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <div>现使用方</div>
                            <div>{{model.method}}</div>
                        </li>
                        <li>
                            <div>交强险</div>
                            <div>{{model.jqx}}</div>
                        </li>
                        <li>
                            <div>使用性质 </div>
                            <div>{{model.xz}}</div>
                        </li>
                        <li>
                            <div>车况</div>
                            <div>{{model.ck.split(',')[0]}}</div>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <div>车身颜色</div>
                            <div>{{model.color}}</div>
                        </li>

                        <li>
                            <div>过户次数</div>
                            <div>{{model.gh}}</div>
                        </li>
                        <li>
                            <div>过户时间</div>
                            <div>{{model.ghtime}}</div>
                        </li>
                        <li>
                            <div>年检</div>
                            <div>{{model.nj}}</div>
                        </li>
                    </ul>
                </section>
            </div>
            <h2>{{model.salePrice}}万</h2>
            <p>
                <input type="checkbox"  v-model="state" >
                <a v-tap="{methods:agreement}" style="color: #F60;">我已同意悟空收车协议</a>
            </p>
            <div class="Btn">
                <button type="button" class="mui-btn mui-btn-danger mui-btn-block" v-tap="{methods:sale}">确认卖车</button>
            </div>
            <h3>注意事项</h3>
            <div class="mui-content-padded">
                <ul class="des">
                    <li>1、车辆成交需要携带：车主身份证原件 登记证 行驶本 新车发票/过户票 交强险原件 购置税本</li>
                    <li>2、精准估计即为成交价格，用户所填能容应真实有效。（如检测结果与用户所填内容不符，以实际检测结果重新估算价格为准。）</li>
                    <li>3、检测师质检通过后即第一时间给您打款。</li>
                </ul>
            </div>


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
            model:{ck:''},
            state:true
        },
        methods:{
            agreement:function(){
                window.location.href = "/m/agreement"
            },
            sale:function(){
                if(this.state){
                    window.location.href = "/m/yuyue"
                }else{
                    mui.toast('请同意悟空收车协议')
                }

            }
        },
        computed: {

        }
    })
   mui.ready(function(){
       vm.model = ${data}
       vm.loading = false
   })

</script>

</html>

