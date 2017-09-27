<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/21
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/includeTop.jsp" %>

<!--图片轮播-->
<div class="layui-carousel pic_play" id="pic_play">
    <div carousel-item>
        <div><img src="images/login/1.png"></div>
        <div><img src="images/login/2.png"></div>
        <div><img src="images/login/3.png"></div>
    </div>
</div>

<!--登录表单-->
<div class="login">
    <fieldset class="layui-elem-field " style="width:420px;height: 300px">

        <legend>登录</legend>

        <br>

        <div class="layui-field-box ">

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
                <p><span class="find_password"><a href="#">忘记密码</a></span></p>
            </div>

            <div>
                <p><span class="register" id="register"><a href="<%=request.getContextPath()%>/registForm">还木有账号？点击立马注册</a></span></p>
            </div>

        </div>

    </fieldset>

</div>

<script>
    //form表单验证
    layui.use('form', function(){
        var form = layui.form;
    });
    //图片轮播效果
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#pic_play'
            ,width: '55%',height:'288px'//设置容器宽度
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
</script>

<%--special script--%>
<script src="js/account/addAddress.js"></script>
<%--special css--%>
<link rel="stylesheet" href="css/account/login.css" />

</body>
</html>
