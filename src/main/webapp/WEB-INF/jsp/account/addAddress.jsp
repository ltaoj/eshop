<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/21
  Time: 22:31
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

</style>



<!--登录表单-->

<fieldset class="layui-elem-field" style="width: 400px">

    <legend>新增地址</legend>

    <br>
    <div class="layui-field-box">

        <form class="layui-form" action="">

            <div class="layui-form-item" class="add_address">
                <label class="layui-form-label"> 收货人：</label>
                <div class="layui-input-block">
                    <input type="text" name="" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" style="width: 220px">
                </div>
            </div>
            <br>
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label">联系方式：</label>
                <div class="layui-input-inline">
                    <input type="password" name="password" required lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input" style="width: 220px">
                </div>
            </div>
            <br>
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label">省  份：</label>
                <div class="layui-input-block">
                    <input type="text" name="user_id" required  lay-verify="required" placeholder="请输入所在省份" autocomplete="off" class="layui-input" style="width: 220px">
                </div>
            </div>
            <br>
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label">城  市：</label>
                <div class="layui-input-block">
                    <input type="text" name="user_id" required  lay-verify="required" placeholder="请输入所在城市" autocomplete="off" class="layui-input" style="width: 220px">
                </div>
            </div>

            <br>
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label">区  域：</label>
                <div class="layui-input-block">
                    <input type="text" name="user_id" required  lay-verify="required" placeholder="请输入所在区域" autocomplete="off" class="layui-input" style="width: 220px">
                </div>
            </div>

            <br>
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label">详细地址：</label>
                <div class="layui-input-block">
                    <input type="text" name="user_id" required  lay-verify="required" placeholder="请输入详细地址" autocomplete="off" class="layui-input" style="width: 220px">
                </div>
            </div>
            <br>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>

        </form>

    </div>

</fieldset>



<script>
    //Demo





    layui.use('form', function(){

        var form = layui.form;

        //监听提交
        /*form.on('submit(formDemo)', function(data){
         layer.msg(JSON.stringify(data.field));
         return false;
         });*/
    });
</script>