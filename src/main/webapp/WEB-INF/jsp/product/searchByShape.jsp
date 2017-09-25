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
    <link rel="stylesheet" href="plugin/layui/css/layui.css" />
    <link rel="stylesheet" href="css/product/search.css" />
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="js/product/searchByShape.js"></script>
    <script src="js/product/searchByName.js"></script>
    <script src="plugin/layui/layui.js"></script>
</head>
<body>

<div class="mainbody">
    <div class="longPic">
        <ul>
            <!--<tr><td><img src="../images/main/logo.png" ></td></tr>-->
            <li></li>
            <li><a href="<%=request.getContextPath()%>/"><img class="icon" src="images/shape/home.png" /></a></li>
            <li><a href="<%=request.getContextPath()%>/shapeRes"><img class="icon" src="images/shape/shape.png" /></a></li>
            <li><a href="<%=request.getContextPath()%>/colorRes"><img class="icon" src="images/shape/color.png" /></a></li>
            <li><a href="<%=request.getContextPath()%>/viewCart"><img class="icon" src="images/shape/cart.png" /></a></li>
            <li><a href="<%=request.getContextPath()%>/orderList"><img class="icon" src="images/shape/bill.png" /></a></li>
            <li><a href="###"><img class="icon" src="images/shape/service.png" /></a></li>
        </ul>
    </div>


    <!--商品搜索框-->
    <div class="body-right">
        <div class="br-right">
            <div class="search">
                <ul>
                    <li><input type="text" id="search" name="keyword" placeholder="请输入商品名称" autocomplete="off" class="layui-input" style="width: 200px"></li>
                    <li><button class="layui-btn layui-btn-radius"><img onclick="searchByName()" src="images/shape/zoom.png" style="width: 24px;height: 24px"></li>
                </ul>
            </div>

            <!--形状-->
            <div class="shape">
                <table>
                    <tr>
                        <td><a href="###"><img id="圆形" onclick="searchByShape(this)" src="images/shape/circle.png" style="width: 40px;height: 40px"></a></td>
                        <td>&nbsp;&nbsp;&nbsp;</td>
                        <td><a href="###"><img id="矩形" onclick="searchByShape(this)" src="images/shape/rectangle.png" style="width: 40px;height: 40px"></a></td>
                        <td>&nbsp;&nbsp;&nbsp;</td>
                        <td><a href="###"><img id="线性" onclick="searchByShape(this)" src="images/shape/stripe.png" style="width: 40px;height: 40px"></a></td>
                    </tr>
                </table>
            </div>
        </div>

        <!--商品展示-->
        <div id="pic" class="pic">
        </div>
    </div>
</div>
</body>
</html>