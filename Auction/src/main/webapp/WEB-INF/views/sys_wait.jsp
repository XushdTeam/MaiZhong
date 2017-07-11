<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/4
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代拍车辆</title>
    <link href="https://cdn.bootcss.com/element-ui/1.3.7/theme-default/index.css" rel="stylesheet">
    <link href="/resources/css/app.css" rel="stylesheet">
    <link href="/resources/css/iconfont.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.3.4/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/element-ui/1.3.7/index.js"></script>
    <style>
        .el-upload-list--picture-card .el-upload-list__item-actions {
            opacity:1;
        }
        .el-upload-list--picture-card .el-upload-list__item-actions span {
            display: inline-flex!important;
        }
    </style>
</head>
<body>
<div id="app" class="wrapper" >
    <%@ include file="../navbar.jsp"%>
    <%@ include file="../slider.jsp"%>
    <div class="content" v-cloak>
        <transition name="slide-fade">
            <div class="list" v-show="handle=='list'">
                <div class="row blockquote">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item><a @click="handle='list'">代拍车辆</a></el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <%--查询--%>
                <div class="row">
                    <el-row type="flex" justify="start">
                        <el-col :span="24">
                            <el-form :inline="true">
                                <el-form-item >
                                    <el-input v-model="searchForm.searchFileds.name" placeholder="商户名称" >
                                        <template slot="prepend">商户名称</template>
                                    </el-input>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" @click="init">查询</el-button>
                                </el-form-item>
                            </el-form>
                        </el-col>
                    </el-row>
                </div>
                <%--操作--%>
                <div class="row">
                    <el-button type="info" @click="refrush"><i class="iconfont icon-shuaxin"></i>刷新</el-button>
                </div>
                <%--列表--%>
                <div class="row">
                    <el-table :data="pageInfo.list" highlight-current-row
                              v-loading="loading"
                              element-loading-text="拼命加载中"
                              style="width: 100%" height="500">
                        <el-table-column prop="id" label="ID"width="80"></el-table-column>
                        <el-table-column prop="picMain" label="图片"width="100">
                            <template scope="scope">
                                <img :src="scope.row.picMain" height="50" width="50" style="margin: 10px 0px;">
                            </template>
                        </el-table-column>
                        <el-table-column prop="modelName" label="车型名称"width="250"></el-table-column>
                        <el-table-column prop="carNum" label="牌照号码"width="120"></el-table-column>
                        <el-table-column prop="userName" label="检测员"width="120"></el-table-column>
                        <el-table-column prop="userPhone" label="联系电话"width="140"></el-table-column>
                        <el-table-column prop="companyName" label="所属商户"width="200"></el-table-column>
                        <el-table-column prop="status" label="操作">
                            <template scope="scope">
                                <el-button
                                        type="info" size="small"
                                        @click="look(scope.row)">
                                    <i class="iconfont icon-mr"></i>详情
                                </el-button>
                                <%--<el-button--%>
                                        <%--size="small" type="success"--%>
                                        <%--@click="pass(scope.row)">--%>
                                    <%--<i class="iconfont icon-tongguo"></i>通过--%>
                                <%--</el-button>--%>
                                <%--<el-button--%>
                                        <%--size="small" type="danger"--%>
                                        <%--@click="reject(scope.row)">--%>
                                    <%--<i class="iconfont icon-work-reject"></i>驳回--%>
                                <%--</el-button>--%>

                            </template>
                        </el-table-column>
                    </el-table>
                </div>
                <%--分页--%>
                <div class="row pagination">
                    <el-pagination
                            @current-change="handleCurrentChange"
                            :current-page.sync="pageInfo.pageNum"
                            :page-size="pageInfo.pageSize"
                            layout="total, prev, pager, next"
                            :total="pageInfo.total">
                    </el-pagination>
                </div>
            </div>
        </transition>
        <transition name="slide-fade">
            <div class="handel" v-show="handle!='list'">
                <div class="row blockquote">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item><a @click="handle='list'">代拍车辆</a></el-breadcrumb-item>
                        <el-breadcrumb-item v-show="handle=='look'">详情</el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <%--操作--%>
                <div class="row" style="width: 1101px;">
                    <el-row type="flex" class="row-bg" justify="space-between">
                        <el-col :span="6">
                            <el-button type="primary" icon="arrow-left" @click="handle='list'"></el-button>
                        </el-col>
                    </el-row>
                </div>

                <%--详细信息--%>
                <div class="row" >
                    <el-tabs v-model="activeName" @tab-click="handleClick">
                        <el-tab-pane label="手续信息" name="1" >
                            <el-collapse v-model="activeFirstNames" v-loading="loading">
                                <el-collapse-item title="行驶证" name="1" >
                                   <div class="itembody" >
                                       <el-form :inline="true" label-width="120px" v-if="firstData.id">
                                           <el-form-item label="行驶证照片" >
                                               <div class="source" v-show="firstData.xsz.wj">
                                                   <div>
                                                       <ul class="el-upload-list el-upload-list--picture-card">
                                                           <li class="el-upload-list__item is-success">
                                                                <img :src="firstData.xsz.pic1" class="el-upload-list__item-thumbnail">
                                                                <span class="el-upload-list__item-actions">
                                                                    <span class="el-upload-list__item-preview">
                                                                        <i class="el-icon-view" @click="imgView(firstData.xsz.pic1)"></i>
                                                                    </span>
                                                                </span>
                                                           </li>
                                                           <li class="el-upload-list__item is-success">
                                                               <img :src="firstData.xsz.pic2" class="el-upload-list__item-thumbnail">
                                                               <span class="el-upload-list__item-actions">
                                                                    <span class="el-upload-list__item-preview">
                                                                        <i class="el-icon-view" @click="imgView(firstData.xsz.pic2)"></i>
                                                                    </span>
                                                                </span>
                                                           </li>
                                                           <li class="el-upload-list__item is-success">
                                                               <img :src="firstData.xsz.pic3" class="el-upload-list__item-thumbnail">
                                                               <span class="el-upload-list__item-actions">
                                                                    <span class="el-upload-list__item-preview">
                                                                        <i class="el-icon-view" @click="imgView(firstData.xsz.pic3)"></i>
                                                                    </span>
                                                                </span>
                                                           </li>
                                                       </ul>
                                                   </div>
                                               </div>
                                               <span v-show="!firstData.xsz.wj">行驶证未见</span>
                                           </el-form-item>
                                           <br>
                                           <el-form-item label="牌照号码">
                                               <span>{{firstData.xsz.number}}</span>
                                           </el-form-item>
                                           <el-form-item label="车辆类型">
                                               <span v-show="firstData.xsz.lx==1">微型车</span>
                                               <span v-show="firstData.xsz.lx==2">小型车</span>
                                               <span v-show="firstData.xsz.lx==3">中型车</span>
                                               <span v-show="firstData.xsz.lx==4">大型车</span>
                                           </el-form-item>
                                           <el-form-item label="使用性质">
                                               <span v-show="firstData.xsz.xz==1">非营运</span>
                                               <span v-show="firstData.xsz.xz==2">运营</span>
                                               <span v-show="firstData.xsz.xz==3">营转非</span>
                                               <span v-show="firstData.xsz.xz==4">租赁</span>
                                               <span v-show="firstData.xsz.xz==5">教练</span>
                                           </el-form-item>
                                           <el-form-item label="品牌型号">
                                               <span>{{firstData.xsz.ppxh}}</span>
                                           </el-form-item>
                                           <el-form-item label="车架号（VIN）">
                                               <span>{{firstData.xsz.cjh}}</span>
                                           </el-form-item>
                                           <el-form-item label="发动机号">
                                               <span>{{firstData.xsz.fdjh}}</span>
                                           </el-form-item>
                                           <el-form-item label="年检有效期">
                                               <span>{{firstData.xsz.njh}}</span>
                                           </el-form-item>
                                       </el-form>
                                   </div>
                                </el-collapse-item>
                                <el-collapse-item title="登记证" name="2" >
                                    <div class="itembody" v-loading="loading">
                                        <el-form :inline="true" label-width="120px" v-if="firstData.id">
                                            <el-form-item label="登记证照片" >
                                                <div class="source" v-show="firstData.djz.wj">
                                                    <div>
                                                        <ul class="el-upload-list el-upload-list--picture-card">
                                                            <li class="el-upload-list__item is-success">
                                                                <img :src="firstData.djz.pic1" class="el-upload-list__item-thumbnail">
                                                                <span class="el-upload-list__item-actions">
                                                                    <span class="el-upload-list__item-preview">
                                                                        <i class="el-icon-view" @click="imgView(firstData.djz.pic1)"></i>
                                                                    </span>
                                                                </span>
                                                            </li>
                                                            <li class="el-upload-list__item is-success">
                                                                <img :src="firstData.djz.pic2" class="el-upload-list__item-thumbnail">
                                                                <span class="el-upload-list__item-actions">
                                                                    <span class="el-upload-list__item-preview">
                                                                        <i class="el-icon-view" @click="imgView(firstData.djz.pic2)"></i>
                                                                    </span>
                                                                </span>
                                                            </li>
                                                            <li class="el-upload-list__item is-success">
                                                                <img :src="firstData.djz.pic3" class="el-upload-list__item-thumbnail">
                                                                <span class="el-upload-list__item-actions">
                                                                    <span class="el-upload-list__item-preview">
                                                                        <i class="el-icon-view" @click="imgView(firstData.djz.pic3)"></i>
                                                                    </span>
                                                                </span>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <span v-show="!firstData.djz.wj">登记证未见</span>
                                            </el-form-item >
                                            <br>
                                            <el-form-item label="车身颜色">
                                                <span v-show="firstData.djz.color==1">黑</span>
                                                <span v-show="firstData.djz.color==2">蓝</span>
                                                <span v-show="firstData.djz.color==3">白</span>
                                                <span v-show="firstData.djz.color==4">红</span>
                                                <span v-show="firstData.djz.color==5">银</span>
                                                <span v-show="firstData.djz.color==6">金</span>
                                                <span v-show="firstData.djz.color==7">绿</span>
                                                <span v-show="firstData.djz.color==8">灰</span>
                                                <span v-show="firstData.djz.color==9">紫</span>
                                                <span v-show="firstData.djz.color==10">黄</span>
                                                <span v-show="firstData.djz.color==11">橙</span>
                                                <span v-show="firstData.djz.color==12">粉</span>
                                                <span v-show="firstData.djz.color==13">其他颜色</span>
                                            </el-form-item>
                                            <el-form-item label="是否进口">
                                                <span v-show="firstData.djz.jk==1">非进口</span>
                                                <span v-show="firstData.djz.jk==2">海关罚没</span>
                                                <span v-show="firstData.djz.jk==3">境外自带</span>
                                                <span v-show="firstData.djz.jk==4">海关进口</span>
                                                <span v-show="firstData.djz.jk==5">海关监管</span>
                                            </el-form-item>
                                            <el-form-item label="燃烧种类">
                                                <span v-show="firstData.djz.rszl==1">汽油</span>
                                                <span v-show="firstData.djz.rszl==2">柴油</span>
                                                <span v-show="firstData.djz.rszl==3">纯电动</span>
                                                <span v-show="firstData.djz.rszl==4">混合动力</span>
                                                <span v-show="firstData.djz.rszl==5">天然气</span>
                                            </el-form-item>
                                            <el-form-item label="排量">
                                                <span>{{firstData.djz.pl}}</span>
                                            </el-form-item>
                                            <el-form-item label="轮胎规格">
                                                <span>{{firstData.djz.ltgg}}</span>
                                            </el-form-item>
                                            <el-form-item label="核定载客数">
                                                <span>{{firstData.djz.hdzks}}</span>
                                            </el-form-item>
                                            <el-form-item label="获得方式">
                                                <span v-show="firstData.djz.hdfs==1">购买</span>
                                                <span v-show="firstData.djz.hdfs==2">继承</span>
                                                <span v-show="firstData.djz.hdfs==3">判决</span>
                                                <span v-show="firstData.djz.hdfs==4">赠与</span>
                                                <span v-show="firstData.djz.hdfs==5">其他</span>
                                            </el-form-item>
                                            <el-form-item label="注册地">
                                                <span>{{firstData.djz.zcd}}</span>
                                            </el-form-item>
                                            <el-form-item label="初登日期">
                                                <span>{{firstData.djz.cdrq}}</span>
                                            </el-form-item>
                                            <el-form-item label="出厂日期">
                                                <span>{{firstData.djz.ccrq}}</span>
                                            </el-form-item>
                                            <el-form-item label="过户次数" v-show="firstData.djz.ghcs">
                                                <span>{{firstData.djz.ghcs}}</span>
                                            </el-form-item>
                                            <el-form-item label="最后过户时间" v-show="firstData.djz.ghcs">
                                                <span>{{firstData.djz.zhghsj}}</span>
                                            </el-form-item>
                                            <el-form-item label="最后转入地" v-show="firstData.djz.ghcs">
                                                <span>{{firstData.djz.yzrd}}</span>
                                            </el-form-item>
                                            <el-form-item label="原使用方">
                                                <span v-show="firstData.djz.ysyf==1">个人</span>
                                                <span v-show="firstData.djz.ysyf==2">单位</span>
                                                <span v-show="firstData.djz.ysyf==3">出租车</span>
                                                <span v-show="firstData.djz.ysyf==4">汽车租赁公司</span>
                                                <span v-show="firstData.djz.ysyf==5">汽车销售（服务）公司</span>
                                            </el-form-item>
                                            <el-form-item label="现使用方">
                                                <span v-show="firstData.djz.xsyf==1">个人</span>
                                                <span v-show="firstData.djz.xsyf==2">单位</span>
                                                <span v-show="firstData.djz.xsyf==3">出租车</span>
                                                <span v-show="firstData.djz.xsyf==4">汽车租赁公司</span>
                                                <span v-show="firstData.djz.xsyf==5">汽车销售（服务）公司</span>
                                            </el-form-item>
                                        </el-form>
                                    </div>
                                </el-collapse-item>
                                <el-collapse-item title="其他证件" name="3">
                                    <div class="itembody">
                                        <el-form :inline="true" label-width="120px" v-if="firstData.id">
                                            <el-form-item label="交强险到期日">
                                                <span>{{firstData.qtz.jqxrq}}</span>
                                                <span v-show="firstData.qtz.bxyz" style="color: red">被保险人与车主不一致</span>
                                                <span v-show="firstData.qtz.wj" style="color: red">未见</span>
                                            </el-form-item>
                                            <el-form-item label="交强险所在地">
                                                <span>{{firstData.qtz.jqxd}}</span>
                                                <span v-show="firstData.qtz.bxyz" style="color: red">车牌所在地与交强险所在地不一致 </span>
                                            </el-form-item>
                                            <el-form-item label="车船税">
                                                <span>{{firstData.qtz.ccx}}</span>
                                                <span v-show="firstData.qtz.ccxwj" style="color: red">未见</span>
                                            </el-form-item>
                                            <el-form-item label="过户票">
                                                <span v-show="firstData.qtz.ghp==0">有</span>
                                                <span v-show="firstData.qtz.ghp==1">无</span>
                                            </el-form-item>
                                            <el-form-item label="购置税">
                                                <span v-show="firstData.qtz.gzs==1">购置税政（征税）</span>
                                                <span v-show="firstData.qtz.gzs==2">购置税政（免税）</span>
                                                <span v-show="firstData.qtz.gzs==3">无购置税政</span>
                                            </el-form-item>
                                            <el-form-item label="备用钥匙">
                                                <span v-show="firstData.qtz.byys==0">有</span>
                                                <span v-show="firstData.qtz.byys==1">无</span>
                                            </el-form-item>
                                        </el-form>
                                    </div>
                                </el-collapse-item>
                                <el-collapse-item title="车主信息" name="4">
                                    <div class="itembody">
                                        <el-form :inline="true" label-width="120px" v-if="firstData.id">
                                            <el-form-item label="车主信息">
                                                <span>{{firstData.czxx.czxx}}</span>
                                            </el-form-item>
                                            <el-form-item label="证件类型">
                                                <span v-show="firstData.czxx.zjlx==1">身份证</span>
                                                <span v-show="firstData.czxx.zjlx==2">户口本</span>
                                                <span v-show="firstData.czxx.zjlx==3">军官证</span>
                                                <span v-show="firstData.czxx.zjlx==4">护照</span>
                                                <span v-show="firstData.czxx.zjlx==5">组织机构代码证</span>
                                            </el-form-item>
                                            <el-form-item label="登记证与证件号">
                                                <span v-show="firstData.czxx.djzczyz==0">相符</span>
                                                <span v-show="firstData.czxx.djzczyz==1">不相符</span>
                                                <span v-show="firstData.czxx.djzczyz==2">未见</span>
                                            </el-form-item>
                                            <el-form-item label="有效证件">
                                                <span>{{firstData.czxx.yxzj}}</span>
                                            </el-form-item>
                                            <el-form-item label="联系电话">
                                                <span>{{firstData.czxx.lxdh}}</span>
                                            </el-form-item>
                                        </el-form>
                                    </div>
                                </el-collapse-item>
                            </el-collapse>
                        </el-tab-pane>
                        <el-tab-pane label="基本照片" name="2">
                            <div class="baseImgBody" v-loading="loading" >
                                <div class="source">
                                    <div v-if="secondData.id">
                                        <ul class="el-upload-list el-upload-list--picture-card">
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.cph" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.cph)">车牌号</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.zq45" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.zq45)">左前45°</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.fdjc" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.fdjc)">发动机舱</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.fdjcz" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.fdjcz)">发动机舱左</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.fdjcy" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.fdjcy)">发动机舱右</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.fdcjh" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.fdcjh)">风挡车架号</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.cjh" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.cjh)">车架号</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.mp" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.mp)">铭牌</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.ltxh" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.ltxh)">轮胎型号</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.qpzy" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.qpzy)">前排座椅</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.ybp" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.ybp)">仪表盘</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.hpzy" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.hpzy)">后排座椅</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.zkt" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.zkt)">中控台</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.hbx" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.hbx)">后备箱</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.yh45" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.yh45)">右后45°</i>
                                                    </span>
                                                </span>
                                            </li>
                                            <li class="el-upload-list__item is-success">
                                                <img :src="secondData.data.ys" class="el-upload-list__item-thumbnail">
                                                <span class="el-upload-list__item-actions">
                                                    <span class="el-upload-list__item-preview">
                                                        <i class="el-icon-view" @click="imgView(secondData.data.ys)">钥匙</i>
                                                    </span>
                                                </span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </el-tab-pane>
                        <el-tab-pane label="车况信息" name="3">
                            <el-collapse v-model="activeFirstNames" v-loading="loading">
                                <el-collapse-item title="外观缺陷"  name="1" >
                                   <div class="itembody">
                                       <div class="source">
                                           <div>
                                               <ul class="el-upload-list el-upload-list--picture-card">
                                                   <li class="el-upload-list__item is-success" v-for="item in thirdData.wgqx">
                                                       <img :src="item.img" class="el-upload-list__item-thumbnail">
                                                       <span class="el-upload-list__item-actions">
                                                            <span class="el-upload-list__item-preview">
                                                                <i class="el-icon-view" @click="imgView(item.img)">{{item.des}}</i>
                                                            </span>
                                                        </span>
                                                   </li>
                                               </ul>
                                           </div>
                                       </div>
                                   </div>
                                </el-collapse-item>
                                <el-collapse-item title="内饰缺陷" name="2" >
                                   <div class="itembody">
                                       <div class="source">
                                           <div>
                                               <ul class="el-upload-list el-upload-list--picture-card">
                                                   <li class="el-upload-list__item is-success" v-for="item in thirdData.nsqx">
                                                       <img :src="item.img" class="el-upload-list__item-thumbnail">
                                                       <span class="el-upload-list__item-actions">
                                                            <span class="el-upload-list__item-preview">
                                                                <i class="el-icon-view" @click="imgView(item.img)">{{item.des}}</i>
                                                            </span>
                                                        </span>
                                                   </li>
                                               </ul>
                                           </div>
                                       </div>
                                   </div>
                                </el-collapse-item>
                                <el-collapse-item title="事故" name="3" >
                                    <div class="itembody">
                                        <div class="source">
                                            <div>
                                                <ul class="el-upload-list el-upload-list--picture-card">
                                                    <li class="el-upload-list__item is-success" v-for="item in thirdData.sg">
                                                        <img :src="item.img" class="el-upload-list__item-thumbnail">
                                                        <span class="el-upload-list__item-actions">
                                                            <span class="el-upload-list__item-preview">
                                                                <i class="el-icon-view" @click="imgView(item.img)">{{item.des}}</i>
                                                            </span>
                                                        </span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </el-collapse-item>
                                <el-collapse-item title="泡水" name="4" >
                                    <div class="itembody">
                                        <div class="source">
                                            <div>
                                                <ul class="el-upload-list el-upload-list--picture-card">
                                                    <li class="el-upload-list__item is-success" v-for="item in thirdData.ps">
                                                        <img :src="item.img" class="el-upload-list__item-thumbnail">
                                                        <span class="el-upload-list__item-actions">
                                                            <span class="el-upload-list__item-preview">
                                                                <i class="el-icon-view" @click="imgView(item.img)">{{item.des}}</i>
                                                            </span>
                                                        </span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </el-collapse-item>
                                <el-collapse-item title="火烧" name="5" >
                                    <div class="itembody">
                                        <div class="source">
                                            <div>
                                                <ul class="el-upload-list el-upload-list--picture-card">
                                                    <li class="el-upload-list__item is-success" v-for="item in thirdData.hs">
                                                        <img :src="item.img" class="el-upload-list__item-thumbnail">
                                                        <span class="el-upload-list__item-actions">
                                                            <span class="el-upload-list__item-preview">
                                                                <i class="el-icon-view" @click="imgView(item.img)">{{item.des}}</i>
                                                            </span>
                                                        </span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </el-collapse-item>
                            </el-collapse>
                        </el-tab-pane>
                        <el-tab-pane label="配置动力" name="4">
                            <el-collapse v-model="activeFirstNames" v-loading="loading">
                                <el-collapse-item title="配置检测" name="1" >
                                    <div class="itembody" >
                                        <el-form :inline="true" label-width="120px" v-if="fourData.id">
                                            <el-form-item label="ABS">
                                                <span v-show="fourData.pz.abs">有</span>
                                                <span v-show="!fourData.pz.abs">无</span>
                                                <span v-show="fourData.pz.absBug>0" class="red">
                                                    {{qx[fourData.pz.absBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="气囊">
                                                <span v-show="fourData.pz.qn==0">无</span>
                                                <span v-show="fourData.pz.qn==1">一个</span>
                                                <span v-show="fourData.pz.qn==2">两个</span>
                                                <span v-show="fourData.pz.qn==3">三个</span>
                                                <span v-show="fourData.pz.qn==4">四个</span>
                                                <span v-show="fourData.pz.qnBug>0" class="red">
                                                    {{qx[fourData.pz.qnBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="转向助力">
                                                <span v-show="fourData.pz.zxzl==0">无</span>
                                                <span v-show="fourData.pz.zxzl==1">有</span>
                                                <span v-show="fourData.pz.zxzlBug>0" class="red">
                                                    {{qx[fourData.pz.zxzlBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="车窗玻璃">
                                                <span v-show="fourData.pz.ccbl==1">四门电动</span>
                                                <span v-show="fourData.pz.ccbl==2">手动</span>
                                                <span v-show="fourData.pz.ccbl==3">两门电动</span>
                                                <span v-show="fourData.pz.ccblBug>0" class="red">
                                                    {{qx[fourData.pz.ccblBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="天窗">
                                                <span v-show="fourData.pz.tc==0">无</span>
                                                <span v-show="fourData.pz.tc==1">有</span>
                                                <span v-show="fourData.pz.tc==2">全景</span>
                                                <span v-show="fourData.pz.tc==3">加装</span>
                                                <span v-show="fourData.pz.tcBug>0" class="red">
                                                    {{qx[fourData.pz.tcBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="车外后视镜">
                                                <span v-show="fourData.pz.cwhsj==1">电折叠</span>
                                                <span v-show="fourData.pz.cwhsj==2">电动调节</span>
                                                <span v-show="fourData.pz.cwhsj==3">手动调节</span>
                                                <span v-show="fourData.pz.cwhsjBug>0" class="red">
                                                    {{qx[fourData.pz.cwhsjBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="座椅材质">
                                                <span v-show="fourData.pz.zycz==1">织布</span>
                                                <span v-show="fourData.pz.zycz==2">真皮</span>
                                                <span v-show="fourData.pz.zycz==3">改装真皮</span>
                                                <span v-show="fourData.pz.zycz==4">混合材质</span>
                                            </el-form-item>
                                            <el-form-item label="座椅调节方式">
                                                <span v-show="fourData.pz.zytjfs==1">手动</span>
                                                <span v-show="fourData.pz.zytjfs==2">电动</span>
                                                <span v-show="fourData.pz.zytjfs==3">记忆</span>
                                            </el-form-item>
                                            <el-form-item label="座椅功能">
                                                <span v-show="fourData.pz.zygn==1">电加热</span>
                                                <span v-show="fourData.pz.zygn==2">通风</span>
                                                <span v-show="fourData.pz.zygn==3">按摩</span>
                                            </el-form-item>
                                            <el-form-item label="座椅缺陷" v-show="fourData.pz.zyBug>0">
                                                <span  class="red">
                                                    {{qx[fourData.pz.zyBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="空调">
                                                <span v-show="fourData.pz.kt==0">无</span>
                                                <span v-show="fourData.pz.kt==1">手动</span>
                                                <span v-show="fourData.pz.kt==2">自动</span>
                                                <span v-show="fourData.pz.kt==3">前后</span>
                                                <span v-show="fourData.pz.ktBug>0" class="red">
                                                    {{qx[fourData.pz.ktBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="影音设备">
                                                <span v-show="fourData.pz.yysb==0">无</span>
                                                <span v-show="fourData.pz.yysb==1">收音机</span>
                                                <span v-show="fourData.pz.yysb==2">CD</span>
                                                <span v-show="fourData.pz.yysb==3">加装CD</span>
                                                <span v-show="fourData.pz.yysb==4">前屏DVD</span>
                                                <span v-show="fourData.pz.yysb==5">多屏DVD</span>
                                                <span v-show="fourData.pz.yysb==6">加装单屏DVD</span>
                                                <span v-show="fourData.pz.yysb==7">加装多屏DVD</span>
                                                <span v-show="fourData.pz.yysbBug>0" class="red">
                                                    {{qx[fourData.pz.yysbBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="导航">
                                                <span v-show="fourData.pz.dh==0">无</span>
                                                <span v-show="fourData.pz.dh==1">有</span>
                                                <span v-show="fourData.pz.dh==2">加装</span>
                                                <span v-show="fourData.pz.dhBug>0" class="red">
                                                    {{qx[fourData.pz.dhBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="定速巡航">
                                                <span v-show="fourData.pz.dsxh==0">无</span>
                                                <span v-show="fourData.pz.dsxh==1">有</span>
                                                <span v-show="fourData.pz.dsxh==2">加装</span>
                                                <span v-show="fourData.pz.dsxhBug>0" class="red">
                                                    {{qx[fourData.pz.dsxhBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="倒车雷达">
                                                <span v-show="fourData.pz.dcld==0">无</span>
                                                <span v-show="fourData.pz.dcld==1">有</span>
                                                <span v-show="fourData.pz.dcld==2">加装</span>
                                                <span v-show="fourData.pz.dcld==3">前后</span>
                                                <span v-show="fourData.pz.dcldBug>0" class="red">
                                                    {{qx[fourData.pz.dcldBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="倒车影像">
                                                <span v-show="fourData.pz.dcyx==0">无</span>
                                                <span v-show="fourData.pz.dcyx==1">有</span>
                                                <span v-show="fourData.pz.dcyx==2">全景</span>
                                                <span v-show="fourData.pz.dcyx==3">加装</span>
                                                <span v-show="fourData.pz.dcyxBug>0" class="red">
                                                    {{qx[fourData.pz.dcyxBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="轮毂">
                                                <span v-show="fourData.pz.lg==1">钢</span>
                                                <span v-show="fourData.pz.lg==2">铝合金</span>
                                                <span v-show="fourData.pz.lgBug>0" class="red">
                                                    {{qx[fourData.pz.lgBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="起动机缺陷" v-show="fourData.pz.qdjBug>0">
                                                <span  class="red">
                                                    {{qx[fourData.pz.qdjBug]}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item label="故障灯" v-show="fourData.pz.gzdBug">
                                                <span  class="red">
                                                    {{fourData.pz.gzdBug}}
                                                </span>
                                            </el-form-item>
                                            <el-form-item :label="fourData.pz.other" v-show="fourData.pz.other">
                                                <span  class="red" v-show="fourData.pz.otherBug>0">
                                                    {{qx[fourData.pz.otherBug]}}
                                                </span>
                                            </el-form-item>
                                        </el-form>
                                    </div>
                                </el-collapse-item>
                                <el-collapse-item title="动力检测" name="2" >
                                    <div class="itembody" >
                                        <el-form :inline="true" label-width="120px" v-if="fourData.id">
                                            <el-form-item label="发动机性能">
                                                <span v-show="fourData.dl.fdjXn==-1">正常</span>
                                                <span v-show="fourData.dl.fdjXn==1" class="red">异响</span>
                                                <span v-show="fourData.dl.fdjXn==2" class="red">漏油</span>
                                                <span v-show="fourData.dl.fdjXn==3" class="red">水温高</span>
                                                <span v-show="fourData.dl.fdjXn==4" class="red">运转不平稳</span>
                                            </el-form-item>
                                            <el-form-item label="发动机尾气">
                                                <span v-show="fourData.dl.fdjWq==-1">正常</span>
                                                <span v-show="fourData.dl.fdjWq==1" class="red">冒蓝烟</span>
                                                <span v-show="fourData.dl.fdjWq==2" class="red">冒黑烟</span>
                                                <span v-show="fourData.dl.fdjWq==3" class="red">冒白烟</span>
                                                <span v-show="fourData.dl.fdjWq==4" class="red">改装</span>
                                            </el-form-item>
                                            <el-form-item label="变速器">
                                                <span v-show="fourData.dl.bsq==-1">正常</span>
                                                <span v-show="fourData.dl.bsq==1" class="red">闯档</span>
                                                <span v-show="fourData.dl.bsq==2" class="red">换档有冲击</span>
                                            </el-form-item>
                                        </el-form>
                                    </div>
                                </el-collapse-item>
                            </el-collapse>
                        </el-tab-pane>
                        <el-tab-pane label="附加信息" name="5">
                            <div class="itembody" v-loading="loading" >
                                <el-form label-width="130px" v-if="fiveData.id">
                                    <el-form-item label="车型" >
                                        <span>{{fiveData.model.modelName}}</span>
                                        <span v-show="fiveData.model.bsx==1">手动</span>
                                        <span v-show="fiveData.model.bsx==2">自动</span>
                                        <span v-show="fiveData.model.bsx==3">CVT</span>
                                        <span v-show="fiveData.model.qdfs==1">两驱</span>
                                        <span v-show="fiveData.model.qdfs==2">四驱</span>
                                    </el-form-item>
                                    <el-form-item label="行驶证和实车照片" >
                                        <template v-for="i in fiveData.verify.xsz.split(',')">
                                            <span v-show="i==1">天窗不一致</span>
                                            <span v-show="i==2">车窗覆盖件不一致</span>
                                            <span v-show="i==3">中网不一致</span>
                                            <span v-show="i==4">颜色不一致(贴纸)</span>
                                            <span v-show="i==5">轮毂不一致</span>
                                            <span v-show="i==6">前照灯总成不一致</span>
                                        </template>
                                    </el-form-item>
                                    <el-form-item label="登记证和实车照片" >
                                        <template v-for="i in fiveData.verify.djz.split(',')">
                                            <span v-show="i==1">实车铭牌破损</span>
                                            <span v-show="i==2">实车铭牌未</span>
                                            <span v-show="i==3">铭牌日期与登记证不一致</span>
                                        </template>
                                    </el-form-item>
                                    <el-form-item label="车架号" >
                                        <template v-for="i in fiveData.verify.cjh.split(',')">
                                            <span v-show="i==1">实车车架号不一致</span>
                                            <span v-show="i==2">打刻较浅无法拓印</span>
                                            <span v-show="i==3">实车车架号锈蚀</span>
                                            <span v-show="i==4">打磨修复痕迹</span>
                                            <span v-show="i==5">风挡车架号未见</span>
                                            <span v-show="i==6">风挡车架号破损</span>
                                        </template>
                                    </el-form-item>
                                    <el-form-item label="轮胎规格" >
                                        <template v-for="i in fiveData.verify.ltgg.split(',')">
                                            <span v-show="i==1">轮胎规格与登记证不符</span>
                                            <span v-show="i==2">同轴轮胎花纹不一致</span>
                                        </template>
                                    </el-form-item>
                                    <el-form-item label="表显里程" >
                                        <span>{{fiveData.verify.bxlc}}</span>
                                    </el-form-item>
                                    <el-form-item label="违章" >
                                        <span>{{fiveData.other.wz_f}} 分 {{fiveData.other.wz_y}}元</span>
                                    </el-form-item>
                                    <el-form-item label="排放标准" >
                                        <span v-show="fiveData.other.pfbz==1">国2及以下</span>
                                        <span v-show="fiveData.other.pfbz==2">国3</span>
                                        <span v-show="fiveData.other.pfbz==3">国4</span>
                                        <span v-show="fiveData.other.pfbz==4">国5</span>
                                        <span v-show="fiveData.other.pfbz==5">不详</span>
                                    </el-form-item>
                                    <el-form-item label="漆面光洁度" >
                                        <span v-show="fiveData.other.qmgjd==1">好</span>
                                        <span v-show="fiveData.other.qmgjd==2">一般</span>
                                        <span v-show="fiveData.other.qmgjd==3">差</span>
                                    </el-form-item>
                                    <el-form-item label="评级" >
                                        <span v-show="fiveData.other.pj==1">A</span>
                                        <span v-show="fiveData.other.pj==2">B</span>
                                        <span v-show="fiveData.other.pj==3">C</span>
                                        <span v-show="fiveData.other.pj==4">D</span>
                                    </el-form-item>
                                    <el-form-item label="其他" v-show="fiveData.other.other">
                                        <span>{{fiveData.other.other}}</span>
                                    </el-form-item>
                                </el-form>
                            </div>
                        </el-tab-pane>
                    </el-tabs>
                </div>
            </div>
        </transition>
        <%--图片预览--%>
        <el-dialog v-model="dialogImgVisible" size="tiny">
            <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
    </div>
</div>
</body>
<script>
    var VM = new Vue({
        el:"#app",
        data:{
            handle:'list',
            onRoutes:'${cur}',
            items:${menu},
            pageInfo:{},
            activeName:'1',
            activeFirstNames: ['1'],
            searchForm:{
                searchFileds:{name: ''},
                pageIndex:1,
                pageSize:10
            },
            cur_row:{},
            form:{
                reason:''
            },
            rules:{
                reason:[
                    { required: true, message: '驳回原因不能为空'},
                    { max: 500, message: '最多500字符'}
                ]
            },
            cur_arry:[],
            qx:['','故障','卡滞','异响','漏油','沉重'],
            firstData:{},
            secondData:{},
            thirdData:{},
            fourData:{},
            fiveData:{},
            reasonDialog:false,
            dialogImgVisible:false,
            dialogImageUrl:'',
            loading:true
        },methods:{
            handleCommand (command) {
                if(command == 'loginout'){
                    this.$confirm('确定要退出?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        $.getJSON("/system/logOff",function(d){
                            if(d.status==200){
                                var date = new Date()
                                date.setTime(date.getTime()+1*1000);//30min
                                $.cookie('token', null, { expires: date, path: '/' });
                                window.location.href = "/";
                            }
                        })
                    }).catch(() => {

                    });
                }
            },handleSelect (href) {
                window.location.href = href;
            },init () {
                $.post('/system/check/wait/list',this.searchForm,(d)=>{
                    if(d.status==200){
                        VM.pageInfo = d.data;
                    }else{
                        this.error(d.message);
                    }
                    VM.loading = false;
                },"JSON")
            },handleCurrentChange (pageNum) {
                this.searchForm.pageIndex = pageNum;
                this.init();

            },reject (row) {
                this.cur_row = row;
                this.confrim("确定驳回 编号："+row.id+" 的 "+row.modelName,()=>{
                    VM.reasonDialog= true;
                })
            },rejectOK () {
                var row = this.cur_row;
                this.$refs['form'].validate((valid) =>{
                    if(valid){
                        VM.reasonDialog = false;
                        $.post('/system/check/examine/reject/'+row.id,VM.form,(d)=>{
                            if(d.status==200){
                                VM.success();
                                VM.handle = "list";
                                VM.refrush();
                            }else{
                                VM.error(d.message);
                            }
                        },'JSON')
                    }
                });
            },pass (row) {
                this.confrim("确认通过 编号："+row.id+" 的 "+row.modelName,()=>{
                    $.getJSON('/system/check/examine/pass/'+row.id,(d)=>{
                        if(d.status==200){
                            VM.success("审核通过");
                            VM.handle = "list";
                            VM.refrush();
                        }else{
                            VM.error(d.message);
                        }
                    })
                })
            },look (row) {
                this.handle = 'look';
                this.cur_row = row;
                this.cur_arry = [];
                this.cur_arry.push(row);

                if($.isEmptyObject(this.firstData)||this.firstData.id!=row.id){
                    this.loading = true;
                    $.getJSON("/system/check/car/step1/"+row.id,(d)=>{
                        if(d.status==200){
                            VM.firstData.id = row.id;
                            VM.firstData.xsz = d.data.xsz;
                            VM.firstData.djz = d.data.djz;
                            VM.firstData.qtz = d.data.qtz;
                            VM.firstData.czxx = d.data.czxx;
                        }
                        VM.loading = false;
                    })
                    VM.activeName = "1"
                }

            },refrush () {
                this.searchForm= {
                    searchFileds:{username: '',phoneNum:''},
                    pageIndex:1,
                    pageSize:10
                }
                this.loading = true;
                this.init();
            },handleClick (tab) {
                if(tab.name==2&&this.secondData.id!=this.cur_row.id){
                    this.loading = true;
                    $.getJSON("/system/check/car/step2/"+this.cur_row.id,(d)=>{
                        if(d.status==200){
                            VM.secondData.id = VM.cur_row.id;
                            VM.secondData.data = d.data;
                        }
                        VM.loading = false;
                    })
                }
                if(tab.name==3&&this.thirdData.id!=this.cur_row.id){
                    this.loading = true;
                    $.getJSON("/system/check/car/step3/"+this.cur_row.id,(d)=>{
                        if(d.status==200){
                            VM.thirdData.id = VM.cur_row.id;
                            VM.thirdData.wgqx = d.data.wgqx;
                            VM.thirdData.nsqx = d.data.nsqx;
                            VM.thirdData.sg = d.data.sg;
                            VM.thirdData.ps = d.data.ps;
                            VM.thirdData.hs = d.data.hs;
                        }
                        VM.loading = false;
                    })
                }
                if(tab.name==4&&this.fourData.id!=this.cur_row.id){
                    this.loading = true;
                    $.getJSON("/system/check/car/step4/"+this.cur_row.id,(d)=>{
                        if(d.status==200){
                            VM.fourData.id = VM.cur_row.id;
                            VM.fourData.pz = d.data.pz;
                            VM.fourData.dl = d.data.dl;
                        }
                        VM.loading = false;
                    })
                }
                if(tab.name==5&&this.fiveData.id!=this.cur_row.id){
                    this.loading = true;
                    $.getJSON("/system/check/car/step5/"+this.cur_row.id,(d)=>{
                        if(d.status==200){
                            VM.fiveData.id = VM.cur_row.id;
                            VM.fiveData.model = d.data.model;
                            VM.fiveData.verify = d.data.verify;
                            VM.fiveData.other = d.data.other;
                        }
                        VM.loading = false;
                    })
                }

            },imgView (url) {
                this.dialogImageUrl = url;
                this.dialogImgVisible = true;
            },success (msg) {
                this.$message({message: msg||'操作成功',type: 'success'});
            },error (msg) {
                this.$message.error(msg);
            },confrim(title,cb) {
                this.$confirm(title, '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    cb()
                }).catch(() => {

                });
            }
        },mounted () {
            this.init();
        }
    })
</script>
</html>
