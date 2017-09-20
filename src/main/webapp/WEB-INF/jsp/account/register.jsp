<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/20
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>新用户注册</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="layui/layui/css/layui.css"/>

    <%--jquery--%>
    <script src="js/jquery/jquery-3.2.1.min.js"></script>

    <%--special js--%>
    <script src="js/account/emcode.js"></script>
</head>
<body>
<style type="text/css">
    .layui-input-block
    {
        width: 300px;
    }
    .layui-field-box
    {
        margin-left: 32%;
    }
    .logoPic
    {
        width: 50%;
        height: 50%;
        margin-left: 10px;
        margin-top: 20px;
    }
    .loginTip
    {
        margin-right: 20px;
    }


</style>
<div>
    <table>
        <tr>
            <td>
                <img src="../images/main/logo.png" class="logoPic">
            </td>
            <td>
                <img src="../images/main/title1.png">
            </td>
            <td>
                <p><span class="loginTip">已有账号，立即登录</span></p>
            </td>
        </tr>
    </table>

</div>
<br>
<br>

<fieldset class="layui-elem-field">
    <legend>新用户注册</legend>
    <div class="layui-field-box">
        <form class="layui-form" action="">

            <div class="layui-form-item">
                <label class="layui-form-label">用户名:</label>
                <div class="layui-input-block">
                    <input type="text" name="user_id" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label">密码:</label>
                <div class="layui-input-block">
                    <input type="text" name="password" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label">确认密码:</label>
                <div class="layui-input-block">
                    <input type="text" name="requiredPassword" required  lay-verify="required" placeholder="请再次输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label">手机号码:</label>
                <div class="layui-input-block">
                    <input type="text" name="phone" required  lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <br>
            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label">邮箱:</label>
                            <div class="layui-input-block">
                                <input type="text" id="email" name="email" required  lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
                            </div>
                        </td>

                        <td>&nbsp;&nbsp;</td>

                        <td>
                            <button class="layui-btn layui-btn-primary" onclick="sendEmcode()">获取激活码</button>
                        </td>

                    </tr>
                </table>
            </div>
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label">邮箱激活码:</label>
                <div class="layui-input-block">
                    <input type="text" name="activeCode" required  lay-verify="required" placeholder="请输入邮箱激活码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <br>
            <div class="layui-form-item">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button class="layui-btn layui-btn-radius">点击注册</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button class="layui-btn layui-btn-radius layui-btn-primary">重&nbsp;&nbsp;置</button>
            </div>
        </form>
    </div>
</fieldset>
</body>
</html>
