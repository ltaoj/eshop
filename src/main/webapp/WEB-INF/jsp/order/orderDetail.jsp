<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/22
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/includeTop.jsp" %>
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
                        <input type="text" name="order_id" required  lay-verify="required" value="${orderDetail.orders.orderId}" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
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
                        <input type="text" name="origin_address" required  lay-verify="required" value="${orderDetail.orders.originProvince}${orderDetail.orders.originCity}" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <!--收货人-->
                <div class="layui-form-item">
                    <label class="layui-form-label"> 收货人:</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" required  lay-verify="required" value="${orderDetail.orders.name}" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <!--收货地点-->
                <div class="layui-form-item">
                    <label class="layui-form-label">收货地点:</label>
                    <div class="layui-input-block">
                        <input type="text" name="bill_address" required  lay-verify="required" value="${orderDetail.orders.billProvince}${orderDetail.orders.billCity}${orderDetail.orders.billDistrict}${orderDetail.orders.billDetailAddr}" autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
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

<%--special css--%>
<link rel="stylesheet" href="css/order/orderDetail.css"/>
</body>
</html>
