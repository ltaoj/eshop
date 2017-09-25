<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/25
  Time: 16:41
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
                <a class="active" href="<%=request.getContextPath()%>/orderMg">订单管理</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/spplierMg">用户管理</a>
            </li>
        </ul>
    </div>
    <div class="body-right">
        <h2>订单管理</h2>
        <div class="topnav">
            <ul>
                <li><a class="active" href="<%=request.getContextPath()%>/orderMg">订单量</a></li>
            </ul>
        </div>
        <div class="main-content">
            <!--用于弹出信息-->
            <div class="" hidden="true"></div>
            <div class="content-item">
                <h4>今日订单</h4>
                <div class="dropdown ci-header-extra">
                    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">订单时间
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" href="#">最近三天</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" href="#">最近七天</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" href="#">最近一月</a>
                        </li>
                    </ul>
                </div>
                <!--主体部分-->
                <div class="ci-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th><span>订单ID</span></th>
                            <th><span>用户ID</span></th>
                            <th><span>姓名</span></th>
                            <th><span>运输地</span></th>
                            <th><span>订单总价</span></th>
                            <th><span>订单状态</span></th>
                            <th><span>操作</span></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><span>20170910102342HBCTXD</span></td>
                            <td><span>111</span></td>
                            <td><span>李涛江</span></td>
                            <td><span>湖南省长沙市天心区铁道学院</span></td>
                            <td><span>2000.0</span></td>
                            <td>
                                <span class="">未付款</span>
                            </td>
                            <td><span>
                                        <a class="btn btn-success">订单详情</a>
                                        </span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- 底部信息没有数据时显示 -->
                <div class="ci-footer">
                    <span>尚未有任何订单</span>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>