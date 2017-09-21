<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/21
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>按商品颜色分类</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="plugin/layui/css/layui.css"/>
    <!--引入js文件-->
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="plugin/layui/layui.js"></script>
</head>
<body>

<style type="text/css">

    .longPic
    {
        margin-left: 50px;

    }
    .container
    {
        background-image: url(images/main/longPic.png);
        width: 200px;
        height: 1000px;
    }
    .color
    {
        position:absolute;
        right: 100px;
        top: 50px;
    }
    .product
    {
        width: 250px;
        height: 250px;
    }
    .pic
    {
        position:absolute;
        left:215px;
        top:110px;
    }
    .icon
    {

    }
</style>

<div class="container">
    <div class="longPic">
        <table>
            <!--<tr><td><img src="../images/main/logo.png" ></td></tr>-->

            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td><img class="icon" src="images/shape/search.png"></td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td><img class="icon" src="images/shape/color.png"></td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td><img class="icon" src="images/shape/cart.png"></td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td><img class="icon" src="images/shape/order.png"></td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td><img class="icon" src="images/shape/service.png"></td></tr>
        </table>
    </div>
</div>

<div class="color">
    <table>
        <tr>
            <td><p>颜色分类</p></td>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td><img src="images/shape/color.png"></td>
        </tr>
    </table>
</div>

<div class="pic">
    <table>
        <tr>
            <td><img id="black_cup1" class="product" src="images/preview/cup-5/black_cup1.png"></td>
            <td><img class="product" src="images/preview/cup-5/black_cup2.png"></td>
            <td><img class="product" src="images/preview/bed-12/black_bed5.png"></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    $('#black_cup1').on('click', function(){
        layer.open({
            type: 2, //弹出层的类型
            title: '',//弹出框的标题
            maxmin: false,//最大最小化
            shadeClose: true, //点击遮罩关闭层
            area : ['800px' , '520px'],//区域大小面积
            content: 'itemDetail'//打开之后呈现的html内容
        });
    });
</script>
</body>
</html>
