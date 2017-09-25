<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/25
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/adminIncludeTop.jsp" %>
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
            <div class="" hidden="true"></div>
            <div class="content-item">
                <h4>供货商</h4>
                <div class="ci-header-extra">
                    <a class="btn btn-success" href="###">添加供货商</a>
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
                            <th><span>操作</span></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><span>HBCTXD</span></td>
                            <td><span>谢雨晗</span></td>
                            <td><span>男</span></td>
                            <td><span>110</span></td>
                            <td><span>110@qq.com</span></td>
                            <td><span>湖南省长沙市天心区铁道学院</span></td>
                            <td><span>
                                        <a class="btn btn-danger">删除</a>
                                        </span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- 底部信息没有数据时显示 -->
                <div class="ci-footer">
                    <span>尚未添加任何商品</span>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
