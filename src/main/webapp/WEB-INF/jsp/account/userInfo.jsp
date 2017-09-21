<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/21
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人信息</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="plugin/layui/css/layui.css"/>
    <!--引入js文件-->
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="plugin/layui/layui.js"></script>
</head>

<style type="text/css">
    .user_info
    {
        margin-left: 26%;
        margin-top: 10%;
    }
</style>

<body>

<div class="layui-tab user_info">
    <ul class="layui-tab-title" >
        <li class="layui-this">个人信息修改</li>
        <li>收获地址</li>
        <li>密码修改</li>
    </ul>
    <div class="layui-tab-content">

        <!--信息修改-->
        <div class="layui-tab-item layui-show">
            <br>
            <br>
            <br>
            <form class="layui-form" action="">
                <!--用户头像-->
                <div class="layui-form-item">
                    <label class="layui-form-label">头  像:</label>
                    <img src="images/user/avatar.jpg" style="width: 100px;height: 100px">
                    <button type="button" class="layui-btn" id="test1">
                        <i class="layui-icon">&#xe67c;</i>上传图片
                    </button>
                </div>
                <br>
                <!--用户ID-->
                <div class="layui-form-item">
                    <label class="layui-form-label">用户ID:</label>
                    <div class="layui-input-block">
                        <input type="text" name="user_id" value="848743941"  autocomplete="off" class="layui-input" style="width: 300px" readonly="readonly">
                    </div>
                </div>
                <br>
                <!--昵称-->
                <div class="layui-form-item">
                    <label class="layui-form-label">昵  称:</label>
                    <div class="layui-input-block">
                        <input type="text" name="username" value="cocohobo"  autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <br>
                <!--邮箱-->
                <div class="layui-form-item">
                    <label class="layui-form-label">邮  箱:</label>
                    <div class="layui-input-block">
                        <input type="text" name="email" value="yuemengyangr370@163.com"  autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <br>
                <!--手机号码-->
                <div class="layui-form-item">
                    <label class="layui-form-label">手机号码:</label>
                    <div class="layui-input-block">
                        <input type="text" name="phone" value="15111214456"  autocomplete="off" class="layui-input" style="width: 300px" >
                    </div>
                </div>
                <br>
                <!--保存修改-->
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">保存修改</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>

        <!--收获地址-->
        <div class="layui-tab-item">
            内容2
        </div>
        <!--密码修改-->
        <div class="layui-tab-item">
            <br>
            <br>
            <form class="layui-form" action="">
                <!--初始密码-->
                <div class="layui-form-item">
                    <label class="layui-form-label">初始密码:</label>
                    <div class="layui-input-block">
                        <input type="password" name="origin_password"  autocomplete="off" class="layui-input" style="width: 300px" placeholder="请输入初始密码">
                    </div>
                </div>
                <br>
                <!--新密码-->
                <div class="layui-form-item">
                    <label class="layui-form-label"> 新密码:</label>
                    <div class="layui-input-block">
                        <input type="text" name="new_password"  autocomplete="off" class="layui-input" style="width: 300px" placeholder="请输入新密码">
                    </div>
                </div>
                <br>
                <!--确认密码-->
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码:</label>
                    <div class="layui-input-block">
                        <input type="text" name="required_password"   autocomplete="off" class="layui-input" style="width: 300px" placeholder="请再次输入新密码">
                    </div>
                </div>
                <br>
                <!--保存修改-->
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">保存修改</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
</script>
</body>
</html>
