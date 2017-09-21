<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/21
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>按商品形状分类</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="plugin/layui/css/layui.css"/>
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
    .shape
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

<div class="shape">
    <table>
        <tr>
            <td><p>形状分类</p></td>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td><img src="images/shape/color.png"></td>
        </tr>
    </table>
</div>

<div class="pic">
    <table>
        <tr>
            <td><img class="product" src="images/preview/cup-5/black_cup1.png"></td>
            <td><img class="product" src="images/preview/cup-5/black_cup2.png"></td>
            <td><img class="product" src="images/preview/cup-5/yellow_cup1.png"></td>
            <td><img class="product" src="images/preview/cup-5/blue_cup.png"></td>
            <td><img class="product" src="images/preview/cup-5/green_cup.png"></td>
        </tr>
        <tr>
            <td><img class="product" src="images/preview/pan-6/pink_pan2.png"></td>
            <td><img class="product" src="images/preview/pan-6/yellow_pan2.png"></td>
            <td><img class="product" src="images/preview/pan-6/grey_pan1.png"></td>
            <td><img class="product" src="images/preview/pan-6/grey_pan2.png"></td>
            <td><img class="product" src="images/preview/pan-6/green_pan1.png"></td>
        </tr>
        <tr>
            <td><img class="product" src="images/preview/bowl-5/black_bowl5.png"></td>
            <td><img class="product" src="images/preview/bowl-5/gray_bowl4.png"></td>
            <td><img class="product" src="images/preview/bowl-5/green_bowl1.png"></td>
            <td><img class="product" src="images/preview/bowl-5/green_bowl2.png"></td>
            <td><img class="product" src="images/preview/bowl-5/pink_bowl3.png"></td>
        </tr>
    </table>
</div>
</body>
</html>
