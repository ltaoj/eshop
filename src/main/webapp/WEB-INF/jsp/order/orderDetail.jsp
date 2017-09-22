<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/22
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>订单详情</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="plugin/layui/css/layui.css"/>
    <!--引入js文件-->
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="plugin/layui/layui.js"></script>
</head>
<body>
<style type="text/css">
    .order
    {
        position: relative;
        left: 34%;
    }
    .product_info
    {
        position: relative;
        left: 16%;
    }
</style>
<div class="navigation">
    <table>
        <tr>
            <td style="width: 80%"><img src="images/main/text.png"></td>

            <td style="width: 200px"><a href="/myInfo"><img src="images/main/user.png" id="login"></a></td>

            <td><img src="images/main/cart.png"></td>
        </tr>
    </table>
</div>
<fieldset class="layui-elem-field">
    <legend>订单详情</legend>
    <div class="layui-field-box order">
        <!--订单form表单-->

        <div>
            <br>
            <form class="layui-form" action="">
                <!--订单号-->
                <div class="layui-form-item">
                    <label class="layui-form-label"> 订单号:</label>
                    <div class="layui-input-block">
                        <input type="text" name="order_id" required  lay-verify="required" value="09Z1" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <!--下单时间-->
                <div class="layui-form-item">
                    <label class="layui-form-label">下单时间:</label>
                    <div class="layui-input-block">
                        <input type="text" name="date" required  lay-verify="required" value="2017-01-11 19:37" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <!--发货地点-->
                <div class="layui-form-item">
                    <label class="layui-form-label">发货地点:</label>
                    <div class="layui-input-block">
                        <input type="text" name="origin_address" required  lay-verify="required" value="北京市朝阳区" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <!--收货人-->
                <div class="layui-form-item">
                    <label class="layui-form-label"> 收货人:</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" required  lay-verify="required" value="忘词王" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <!--收货地点-->
                <div class="layui-form-item">
                    <label class="layui-form-label">收货地点:</label>
                    <div class="layui-input-block">
                        <input type="text" name="bill_address" required  lay-verify="required" value="江西省新余市大一中学" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <!--订单状态-->
                <div class="layui-form-item">
                    <label class="layui-form-label">订单状态:</label>
                    <div class="layui-input-block">
                        <input type="text" name="status" required  lay-verify="required" value="运输中" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <!--商品用一个表格的形式呈现，考虑到可能一个订单中会有多个商品-->

            </form>

        </div>


    </div>

    <div class="product_info">
        <table class="layui-table" style="width: 1000px;">
            <colgroup>
                <col width="150">
                <col width="200">
                <col width="150">
                <col width="150">
                <col width="150">
            </colgroup>
            <thead>
            <tr>
                <th>商  品</th>
                <th>商品描述</th>
                <th>单  价</th>
                <th>数  量</th>
                <th>总  计</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><img src="images/preview/box-8/yellow_box2.png" style="width: 180px;height:180px"></td>
                <td>品质棉麻衣物收纳袋</td>
                <td>89.0</td>
                <td>1</td>
                <td>89.0</td>
            </tr>

            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>共计</td>
                <td>89.0</td>
            </tr>
            </tbody>
        </table>
    </div>
</fieldset>
</body>
</html>
