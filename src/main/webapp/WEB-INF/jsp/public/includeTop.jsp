<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/24
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>购物车</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="plugin/layui/css/layui.css"/>
    <!--引入js文件-->
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="plugin/layui/layui.js"></script>
</head>
<body>
<style type="text/css">
    .table
    {
        margin-left: 1%;
    }
</style>
<!--导航栏-->
<div class="navigation">
    <table>
        <tr>
            <td style="width: 80%"><img src="images/main/text.png"></td>

            <td style="width: 200px"><a href="<%=request.getContextPath()%>/myInfo"><img src="images/main/user.png" id="login"></a></td>

            <td><a href="<%=request.getContextPath()%>/viewCart"><img src="images/main/cart.png"></a></td>
        </tr>
    </table>
</div>
