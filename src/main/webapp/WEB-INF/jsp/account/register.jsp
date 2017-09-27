<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/20
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>新用户注册</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="plugin/layui/css/layui.css"/>
    <!--引入js文件-->
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="plugin/layui/layui.js"></script>
</head>
<body>
<%@ include file="../public/includeTop.jsp" %>
<span class="loginTip"><a href="<%=request.getContextPath()%>/login">已有账号，立即登录</a></span>
<br>
<br>

<fieldset class="layui-elem-field">
    <legend>新用户注册</legend>
    <div class="layui-field-box">

        <form>

            <div class="layui-form-item">
                <label class="layui-form-label"><span class="tag">*</span>用户名:</label>
                <div class="layui-input-block">
                    <input type="text" id="user_id"  placeholder="请输入用户名" autocomplete="off" class="layui-input" onblur="username()">
                </div>
            </div>

            <br>

            <div class="layui-form-item">
                <label class="layui-form-label"><span class="tag">*</span>密码:</label>
                <div class="layui-input-block">
                    <input type="password" id="password"  placeholder="请输入密码" autocomplete="off" class="layui-input" >
                </div>
            </div>

            <br>

            <div class="layui-form-item">
                <label class="layui-form-label"><span class="tag">*</span>确认密码:</label>
                <div class="layui-input-block">
                    <input type="password" id="repeatPassword"  placeholder="请再次输入密码" autocomplete="off" class="layui-input" onblur="verify()">
                </div>
            </div>

            <br>

            <div class="layui-form-item">
                <label class="layui-form-label">手机号码:</label>
                <div class="layui-input-block">
                    <input type="text" id="phone"  placeholder="请输入手机号码" autocomplete="off" class="layui-input">
                </div>
            </div>

            <br>

            <div class="layui-form-item">
                <table>
                    <tr>
                        <td>
                            <label class="layui-form-label"><span class="tag">*</span>邮箱:</label>
                            <div class="layui-input-block">
                                <input type="text" id="email"  placeholder="请输入邮箱" autocomplete="off" class="layui-input">
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
                <label class="layui-form-label"><span class="tag">*</span>激活码:</label>
                <div class="layui-input-block">
                    <input type="text" id="code" required  lay-verify="required" placeholder="请输入邮箱激活码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <br>
        </form>
        <div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button onclick="regist()" class="layui-btn layui-btn-radius">点击注册</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="layui-btn layui-btn-radius layui-btn-primary" type="reset">重&nbsp;&nbsp;置</button>
        </div>
    </div>
</fieldset>

<%--special script--%>
<script src="js/account/emcode.js"></script>
<script src="js/account/register.js"></script>

<%--special css--%>
<link rel="stylesheet" href="css/account/register.css">
</body>
</html>