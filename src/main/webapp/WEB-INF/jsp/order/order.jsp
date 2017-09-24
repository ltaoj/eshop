<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/22
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/includeTop.jsp" %>

<fieldset class="layui-elem-field layui-field-title" >
    <legend>我的订单</legend>
</fieldset>
<br>
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this">所有订单<span class="layui-badge layui-bg-blue">${allOrderDetailList.size()}</span></li>
        <li> 待付款<span class="layui-badge layui-bg-green">${unPayOrderDetailList.size()}</span></li>
        <li> 已取消<span class="layui-badge">${cancelOrderDetailList.size()}</span></li>
    </ul>

    <div class="layui-tab-content">

        <div  class="layui-tab-item layui-show">
            <table  class="layui-table">
                <colgroup>
                    <col width="100">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="70">
                    <col width="70">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="100">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>时间</th>
                    <th>商品</th>
                    <th>描述</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>收货人</th>
                    <th>收货人联系方式</th>
                    <th>收货地址</th>
                    <th>金额</th>
                    <th>操作</th>
                    <th>说明</th>
                </tr>
                </thead>
                <tbody>
                <!--第一行待付商品-->
                <c:forEach var="orderDetail" items="${allOrderDetailList}">
                    <tr id="${orderDetail.orders.orderId}">
                        <td>${orderDetail.orders.orderId}</td>
                        <td>${orderDetail.orders.orderDate}</td>
                        <td><img src="images/preview/pan-6/pink_pan2.png"></td>
                        <td>德国进口精致不锈钢奶锅</td>
                        <td>189.0</td>
                        <td>1</td>
                        <td>${orderDetail.orders.name}</td>
                        <td>18079086223</td>
                        <td>${orderDetail.orders.billProvince}${orderDetail.orders.billCity}${orderDetail.orders.billDistrict}</td>
                        <td>${orderDetail.orders.totalPrice}</td>
                        <c:if test="${orderDetail.orderstatus.status == 0}">
                            <td>
                                <span class="layui-badge" id="cancel" onclick="cancelOrder(${orderDetail.orders.orderId})">取消订单</span>
                                <a href="<%=request.getContextPath()%>/orderDetail?orderId=${orderDetail.orders.orderId}"><span class="layui-badge layui-bg-orange">查看详情</span></a>
                            </td>
                            <td><span class="layui-badge layui-bg-green">待付款</span></td>
                        </c:if>
                        <c:if test="${orderDetail.orderstatus.status == 1}">
                            <td>
                                <span class="layui-badge" id="delete" onclick="deleteOrder(${orderDetail.orders.orderId})">删除订单</span>
                                <a href="<%=request.getContextPath()%>/orderDetail?orderId=${orderDetail.orders.orderId}"><span class="layui-badge layui-bg-orange">查看详情</span></a>
                            </td>
                            <td><span class="layui-badge">已取消</span></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="layui-tab-item">
            <table  class="layui-table">
                <colgroup>
                    <col width="100">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="70">
                    <col width="70">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="100">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>时间</th>
                    <th>商品</th>
                    <th>描述</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>收货人</th>
                    <th>收货人联系方式</th>
                    <th>收货地址</th>
                    <th>金额</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orderDetail" items="${unPayOrderDetailList}">
                    <tr id="${orderDetail.orders.orderId}">
                        <td>${orderDetail.orders.orderId}</td>
                        <td>${orderDetail.orders.orderDate}</td>
                        <td><img src="images/preview/pan-6/pink_pan2.png"></td>
                        <td>德国进口精致不锈钢奶锅</td>
                        <td>189.0</td>
                        <td>1</td>
                        <td>${orderDetail.orders.name}</td>
                        <td>18079086223</td>
                        <td>${orderDetail.orders.billProvince}${orderDetail.orders.billCity}${orderDetail.orders.billDistrict}</td>
                        <td>${orderDetail.orders.totalPrice}</td>
                        <td>
                            <span class="layui-badge" id="delete" onclick="cancelOrder(${orderDetail.orders.orderId})">取消订单</span>
                            <a href="<%=request.getContextPath()%>/orderDetail?orderId=${orderDetail.orders.orderId}"><span class="layui-badge layui-bg-orange">查看详情</span></a>
                        </td>
                        <td><span class="layui-badge layui-bg-green">待付款</span></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="layui-tab-item">
            <table  class="layui-table">
                <colgroup>
                    <col width="100">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="70">
                    <col width="70">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="100">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>时间</th>
                    <th>商品</th>
                    <th>描述</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>收货人</th>
                    <th>收货人联系方式</th>
                    <th>收货地址</th>
                    <th>金额</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orderDetail" items="${cancelOrderDetailList}">
                    <tr id="${orderDetail.orders.orderId}">
                        <td>${orderDetail.orders.orderId}</td>
                        <td>${orderDetail.orders.orderDate}</td>
                        <td><img src="images/preview/pan-6/pink_pan2.png"></td>
                        <td>德国进口精致不锈钢奶锅</td>
                        <td>189.0</td>
                        <td>1</td>
                        <td>${orderDetail.orders.name}</td>
                        <td>18079086223</td>
                        <td>${orderDetail.orders.billProvince}${orderDetail.orders.billCity}${orderDetail.orders.billDistrict}</td>
                        <td>${orderDetail.orders.totalPrice}</td>
                        <td>
                            <span class="layui-badge" id="delete" onclick="${orderDetail.orders.orderId}">删除订单</span>
                            <a href="<%=request.getContextPath()%>/orderDetail?orderId=${orderDetail.orders.orderId}"><span class="layui-badge layui-bg-orange">查看详情</span></a>
                        </td>
                        <td><span class="layui-badge">已取消</span></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
</table>

<%--specail script--%>
<script src="js/order/order.js"></script>
</body>
</html>
