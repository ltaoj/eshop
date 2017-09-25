<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/25
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/adminIncludeTop.jsp" %>

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
            <div class="" hidden="true"></div>

            <div class="content-item">
                <h4>品类列表</h4>
                <div class="ci-header-extra">
                    <a class="btn btn-success" href="###">添加品类</a>
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
                        <tr>
                            <td><span>IFEY</span></td>
                            <td><span>沙发</span></td>
                            <td><span>沙发沙发沙发沙发沙发沙发</span></td>
                            <td><span>
                                        <a class="btn btn-danger">删除</a></span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- 底部信息没有数据时显示 -->
                <div class="ci-footer">
                    <span>尚未添加任何品类</span>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

