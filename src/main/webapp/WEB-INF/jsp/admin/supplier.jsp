<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/25
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/adminIncludeTop.jsp" %>
<div class="modal fade" id="supplierModal" tabindex="-1" role="dialog" aria-labelledby="supplierModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="supplierModalLabel">
                    添加供货商
                </h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <label for="supplierId">供货商ID</label>
                        <input id="supplierId" type="text" class="form-control" placeholder="请输入供货商ID">
                    </div>
                    <div class="form-group">
                        <label for="name">姓名</label>
                        <input id="name" type="text" class="form-control" placeholder="请输入姓名">
                    </div>
                    <div class="form-group">
                        <label for="phone">手机号</label>
                        <input id="phone" type="text" class="form-control" placeholder="请输入手机号">
                    </div>
                    <div class="form-group">
                        <label for="sex">性别</label>
                        <input id="sex" type="text" class="form-control" placeholder="请输入城市">
                    </div>
                    <div class="form-group">
                        <label for="email">邮箱</label>
                        <input id="email" type="text" class="form-control" placeholder="请输入邮箱">
                    </div>
                    <div class="form-group">
                        <label for="province">省份</label>
                        <input id="province" type="text" class="form-control" placeholder="请输入省份">
                    </div>
                    <div class="form-group">
                        <label for="city">城市</label>
                        <input id="city" type="text" class="form-control" placeholder="请输入城市">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="addSupplier()">
                    确认添加
                </button>
            </div>
        </div>
    </div>
</div>

<div class="mainbody">
    <div class="sidenav">
        <ul>
            <li>
                <a href="<%=request.getContextPath()%>/catelogMg">商品管理</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/orderMg">订单管理</a>
            </li>
            <li>
                <a class="active" href="<%=request.getContextPath()%>/spplierMg">用户管理</a>
            </li>
        </ul>
    </div>
    <div class="body-right">
        <h2>用户管理</h2>
        <div class="topnav">
            <ul>
                <li><a class="active" href="<%=request.getContextPath()%>/spplierMg">供货商</a></li>
            </ul>
        </div>
        <div class="main-content">
            <!--用于弹出信息-->
            <div id="alert" class=""></div>
            <div class="content-item">
                <h4>供货商</h4>
                <div class="ci-header-extra">
                    <a class="btn btn-success" data-toggle="modal" data-target="#supplierModal">添加供货商</a>
                </div>
                <!--主体部分-->
                <div class="ci-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th><span>供货商ID</span></th>
                            <th><span>姓名</span></th>
                            <th><span>性别</span></th>
                            <th><span>手机号</span></th>
                            <th><span>邮箱</span></th>
                            <th><span>地址</span></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="supplier" items="${supplierList}">
                            <tr>
                                <td><span>${supplier.supplierId}</span></td>
                                <td><span>${supplier.name}</span></td>
                                <td><span><c:if test="${supplier.sex == 1}">男</c:if><c:if test="${supplier.sex == 0}">女</c:if></span></td>
                                <td><span>${supplier.phone}</span></td>
                                <td><span>${supplier.email}</span></td>
                                <td><span>${supplier.province}${supplier.city}</span></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- 底部信息没有数据时显示 -->
                <div class="ci-footer">
                    <span <c:if test="${supplierList.size() == 0}">hidden="true"</c:if>尚未添加任何商品</span>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/admin/supplier.js"></script>
<script src="js/widge/alert.js"></script>
</body>
</html>
