<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/20
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="plugin/layui/css/layui.css"/>
    <!--引入js文件-->
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="plugin/layui/layui.js"></script>
</head>
<body>
<style type="text/css">
    .search
    {
        margin-left: 45%;
    }
    .search1
    {
        margin-left: 25%;
    }
    .search2
    {
        margin-left: 40%;
    }
</style>
<div class="navigation">
    <table>
        <tr>
            <td style="width: 80%"><img src="images/main/text.png"></td>

            <td style="width: 200px"><img src="images/main/user.png" id="login"></td>

            <td><img src="images/main/cart.png"></td>
        </tr>
    </table>
</div>
<br>
<br>
<div >

    <div class="search">
        <img src="images/main/logo.png">
    </div>
    <br><br><br>
    <div class="search1">
        <table>
            <tr>
                <td>
                    <input style="width: 700px" type="text" name="search"  placeholder="请输入商品名称" autocomplete="off" class="layui-input">
                </td>
                <td></td>
                <td>
                    <button class="layui-btn layui-btn-radius layui-btn-primary">
                        <i class="layui-icon">&#xe615;</i>
                    </button>
                </td>
            <tr>
        </table>
    </div>
    <br>
    <br>
    <div class="search2">
        <img src="images/main/text2.png">
    </div>
    <br>
    <br>
    <br>
    <br>
    <div>
        <img src="images/main/p1.png">
    </div>



</div>

<script type="text/javascript">
    $('#login').on('click', function(){
        layer.open({
            type: 2, //弹出层的类型
            title: '',//弹出框的标题
            maxmin: false,//最大最小化
            shadeClose: true, //点击遮罩关闭层
            area : ['420px' , '300px'],//区域大小面积
            content: 'loginForm'//打开之后呈现的html内容
        });
    });
</script>

</body>
</html>