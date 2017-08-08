<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/3
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sidebar</title>
</head>
<body>
<div class="sidebar">
    <el-menu :default-active="onRoutes" class="el-menu-vertical-demo" unique-opened @select="handleSelect">
        <template v-for="item in items">
            <template v-if="item.subs">
                <el-submenu :index="item.url">
                    <template slot="title">
                        <i class="iconfont" :class="item.icon"></i>
                        {{ item.name }}
                    </template>
                    <el-menu-item v-for="(subItem,i) in item.subs" :key="i" :index="subItem.url">
                        <i class="iconfont" :class="subItem.icon"></i>
                        {{ subItem.name }}
                    </el-menu-item>
                </el-submenu>
            </template>
            <template v-else>
                <el-menu-item :index="item.url">
                    <i class="iconfont" :class="item.icon"></i>
                    {{ item.name }}
                </el-menu-item>
            </template>
        </template>
    </el-menu>
</div>
</body>
</html>
