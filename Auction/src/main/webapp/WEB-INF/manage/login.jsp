<%--
  Created by IntelliJ IDEA.
  User: Xushd
  Date: 2017/7/3
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>优品拍车后台管理系统</title>
    <link href="https://cdn.bootcss.com/element-ui/1.3.7/theme-default/index.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.3.4/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/element-ui/1.3.7/index.js"></script>
    <style lang="scss" scoped>

        body{
            margin: 0px;
        }

        .login-container {
            /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
            -webkit-border-radius: 5px;
            border-radius: 5px;
            -moz-border-radius: 5px;
            background-clip: padding-box;
            margin: 40px auto;
            width: 350px;
            padding: 35px 35px 15px 35px;
            background: rgba(255, 255, 255, 0.4);
            border: 1px solid #eaeaea;
            box-shadow: 0 0 25px #cac6c6;
            margin-right: 10%;
        }
        .title {
            margin: 0px auto 40px auto;
            text-align: center;
            color: #505458;
        }
        .remember {
            margin: 0px 0px 35px 0px;
        }
        #app{
            background-image: url("https://ss3.bdstatic.com/lPoZeXSm1A5BphGlnYG/skin/74.jpg");
            background-position: center 0;
            background-repeat: no-repeat;
            background-size: cover;
            -webkit-background-size: cover;
            height: 500px;
            margin-top: 150px;
            position: absolute;
            width: 100%;

        }
    </style>
</head>
<body>
<div id="app">
    <el-form :model="form" :rules="rules" ref="form" label-position="left" label-width="0px" class="demo-ruleForm login-container">
        <h3 class="title">系统登录</h3>
        <el-form-item prop="account">
            <el-input type="text" v-model="form.account" maxlength="11" auto-complete="off" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="password">
            <el-input type="password" v-model="form.password" auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-checkbox v-model="form.checked" class="remember">记住密码</el-checkbox>
        <el-form-item style="width:100%;">
            <el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">登录</el-button>
        </el-form-item>
    </el-form>
</div>
</body>
<script src="/resources/script/sha256.js" type="text/javascript"></script>
<script>
    var VM = new Vue({
        el:"#app",
        data:{
            logining:false,
            form:{
                account:'',
                password:'',
                checked:false
            },rules:{
                account:[ { required: true,message: '请输入帐号', trigger: 'blur' }],
                password:[{ required: true,message: '请输入密码', trigger: 'blur' }]
            }
        },
        methods:{
            handleSubmit(){
                this.$refs['form'].validate(function(valid) {
                    if (valid) {
                        VM.form.password = sha256.digest(VM.form.password)
                        $.post('/login/check',VM.form,function(d){
                           if(d.status==200){
                               VM.success(d.message);

                               var date = new Date(),token = d.data;
                               if(VM.form.checked){
                                   $.cookie('m_token', token, { expires: 7, path: '/' });
                               }else{
                                   date.setTime(date.getTime()+60*30*1000);//30min
                                   $.cookie('m_token', token, { expires: date, path: '/' });
                               }
                               setTimeout(function(){
                                   window.location.href = "/manage/";
                               },1000)

                           }else{
                               VM.error(d.message);
                           }
                        },"JSON")
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },success (msg) {
                this.$message({message: msg||'保存成功',type: 'success'});
            },error (msg) {
                this.$message.error(msg);
            }
        }
    })
</script>

</html>
