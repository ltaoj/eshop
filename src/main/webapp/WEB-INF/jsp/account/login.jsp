<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/21
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" href="plugin/layui/css/layui.css"/>
<!--引入js文件-->
<script src="js/jquery/jquery-3.2.1.min.js"></script>
<script src="js/layer/layer.js"></script>
<script src="plugin/layui/layui.js"></script>

<style type="text/css">
    .register
    {
        font-size: 8px;
        position: absolute;
        left: 60%;
        color: #999999;
    }
    .find_password
    {
        font-size: 8px;
        position: absolute;
        left: 13%;
        color: #999999;
    }
</style>



<!--登录表单-->

<fieldset class="layui-elem-field" style="width: 420px;height: 300px">

    <legend>登录</legend>

    <br>
    <div class="layui-field-box">

        <form class="layui-form" name="f" action="<%=request.getContextPath()%>/login" method="POST">

            <div class="layui-form-item">
                <label class="layui-form-label">用户名：</label>
                <div class="layui-input-block">
                    <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" style="width: 220px">
                </div>
            </div>
            <br>
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label">密码：</label>
                <div class="layui-input-inline">
                    <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" style="width: 220px">
                </div>
            </div>


            <br>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>

        </form>

        <div>
            <p><a href="#"><span class="find_password">忘记密码</span></a></p>
        </div>

        <div>
            <p><span class="register" id="register">还木有账号？点击立马注册</span></p>
        </div>

    </div>

</fieldset>



<script>
    //Demo
    $("#register").click(function(){

//window.location= 'register.html' ; //跳转到指定页面
        window.open('registForm') ; //打开窗口
    })





    layui.use('form', function(){

        var form = layui.form;

        //监听提交
        /*form.on('submit(formDemo)', function(data){
         layer.msg(JSON.stringify(data.field));
         return false;
         });*/
    });
</script>
