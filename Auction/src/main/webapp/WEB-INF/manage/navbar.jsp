<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/3
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>navbar</title>
</head>
<body>
<div class="header">
    <div class="logo">后台管理系统</div>
    <div class="user-info">
        <el-dropdown trigger="click" @command="handleCommand">
                <span class="el-dropdown-link">
                    <img class="user-logo" src="/resources/images/img.jpg">
                    ${username}
                </span>
            <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="loginout">退出</el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>
    </div>
</div>
</body>
</html>
