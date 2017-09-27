<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/25
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/adminIncludeTop.jsp" %>
<%--添加品类模态框--%>
<div class="modal fade" id="pModal" tabindex="-1" role="dialog" aria-labelledby="pModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="pModalLabel">
                    新品类
                </h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <label for="name">品类名称</label>
                        <input type="text" id="name" class= "form-control" placeholder="请输入品类名称" />
                    </div>
                    <div class="form-group">
                        <label for="description">品类描述</label>
                        <input type="text" id="description" class="form-control" placeholder="请输入品类描述">
                    </div>
                    <div class="form-group">
                        <label for="categoryId">品类ID</label>
                        <input type="text" id="categoryId" class="form-control" placeholder="请输入品类ID">
                        <button class="btn btn-success">随机生成</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="addCategory()">
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
                <a class="active" href="<%=request.getContextPath()%>/catelogMg">商品管理</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/orderMg">订单管理</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/spplierMg">用户管理</a>
            </li>
        </ul>
    </div>
    <div class="body-right">
        <h2>商品管理</h2>
        <div class="topnav">
            <ul>
                <li><a class="active" href="<%=request.getContextPath()%>/catelogMg">品类</a></li>
                <li><a href="<%=request.getContextPath()%>/itemMg">商品</a></li>
            </ul>
        </div>
        <div class="main-content">
            <!--用于弹出信息-->
            <div class=""></div>

            <div class="content-item">
                <h4>品类列表</h4>
                <div class="ci-header-extra">
                    <a class="btn btn-success" data-toggle="modal" data-target="#pModal">添加品类</a>
                </div>
                <!--主体部分-->
                <div class="ci-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th><span>品类ID</span></th>
                            <th><span>品类名称</span></th>
                            <th><span>品类描述</span></th>
                            <th><span>操作</span></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="category" items="${categoryList}">
                            <tr>
                                <td><span>${category.categoryId}</span></td>
                                <td><span>${category.name}</span></td>
                                <td><span>${category.description}</span></td>
                                <td><span>
                                        <a class="btn btn-danger" onclick="deleteCategory(${category.categoryId})">删除</a></span>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- 底部信息没有数据时显示 -->
                <div class="ci-footer">
                    <span <c:if test="${categoryList.size() > 0}">hidden="true"</c:if>>尚未添加任何品类</span>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/admin/product.js"></script>
</body>
</html>

