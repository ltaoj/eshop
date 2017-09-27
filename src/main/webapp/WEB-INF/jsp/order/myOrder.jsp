<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2017/9/26
  Time: PM8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>确认订单</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="plugin/layui/css/layui.css"/>
    <!--引入js文件-->
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="plugin/layui/layui.js"></script>
</head>
<body>
<%@ include file="../public/includeTop.jsp" %>
<body>
<fieldset class="layui-elem-field">
    <legend>确认订单</legend>
    <div class="layui-field-box order">
        <!--订单form表单-->
        <div>
            <br>
            <form class="layui-form" action="">

                <!--下单时间-->
                <div class="layui-form-item">
                    <label class="layui-form-label">下单时间:</label>
                    <div class="layui-input-block">
                        <input type="text" name="date" required  lay-verify="required" value="${orderDetail.orders.orderDate}" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <!--发货地点-->
                <div class="layui-form-item">
                    <label class="layui-form-label">发货地点:</label>
                    <div class="layui-input-block">
                        <input  readonly="true" type="text" name="origin_address" required  lay-verify="required" value="${orderDetail.orders.originProvince}${orderDetail.orders.originCity}" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <!--收货信息-->
                <div class="layui-form-item">
                  <%--
               <label class="layui-form-label">收获信息：</label>
                <div class="layui-input-block">
                        <select name="city" lay-verify="required">
                         <option value=""></option>
                         <option value="0">北京</option>
                         <option value="1">上海</option>
                         <option value="2">广州</option>
                         <option value="3">深圳</option>
                         <option value="4">杭州</option>
                       </select>
                </div>--%>
                </div>
                <!--订单状态-->
                <div class="layui-form-item">
                    <label class="layui-form-label">订单状态:</label>
                    <div class="layui-input-block">
                        <input type="text" name="status" required  lay-verify="required" <c:if test="${orderDetail.orderstatus.status == 0}">value="待付款"</c:if><c:if test="${orderDetail.orderstatus.status == 1}">value="已取消"</c:if> autocomplete="off" class="layui-input" style="width: 300px">
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
            <c:forEach var="lineitem" items="${orderDetail.lineitems}">
                <tr>
                    <td><img src="images/preview/box-8/yellow_box2.png" style="width: 180px;height:180px"></td>
                    <td>品质棉麻衣物收纳袋</td>
                    <td>${lineitem.unitprice}</td>
                    <td>${lineitem.quantity}</td>
                    <td>${lineitem.unitprice * lineitem.quantity}</td>
                </tr>
            </c:forEach>

            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>共计</td>
                <td>${orderDetail.orders.totalPrice}</td>
            </tr>
            </tbody>
        </table>
    </div>
</fieldset>
<link rel="stylesheet" href="css/order/orderDetail.css"/>
</body>
</html>
