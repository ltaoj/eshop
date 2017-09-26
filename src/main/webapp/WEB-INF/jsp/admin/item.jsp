<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/25
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/adminIncludeTop.jsp" %>
<%--添加商品modal--%>
<div class="modal fade" id="iModal" tabindex="-1" role="dialog" aria-labelledby="iModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="iModalLabel">
                    新商品
                </h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <label for="itemId">商品ID</label>
                        <input type="text" id="itemId" class= "form-control" placeholder="请输入商品ID" />
                    </div>
                    <div class="form-group">
                        <label for="name">商品名称</label>
                        <input type="text" id="name" class= "form-control" placeholder="请输入商品名称" />
                    </div>
                    <div class="form-group">
                        <label for="categoryId">所属品类</label>
                        <select id="categoryId">
                            <option>222</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="listprice">商品售价</label>
                        <div class="input-group">
                            <input id="listprice" type="text" class="form-control" placeholder="请输入商品售价">
                            <span class="input-group-addon">.0</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="unitcost">商品进价</label>
                        <div class="input-group">
                            <input id="unitcost" type="text" class="form-control" placeholder="请输入商品进价">
                            <span class="input-group-addon">.0</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="attr1">颜色属性</label>
                        <select id="attr1">
                            <option>红色</option>
                            <option>粉红色</option>
                            <option>粉色</option>
                            <option>黄色</option>
                            <option>绿色</option>
                            <option>黑色</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="attr2">形状属性</label>
                        <select id="attr2">
                            <option>圆形</option>
                            <option>矩形</option>
                            <option>线形</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="itemPic">商品描述</label>
                        <a href="###" class="thumbnail">
                            <img src=""
                                 alt="商品图片描述">
                        </a>
                        <input type="file" name="itemPic" id="itemPic" accept="image/jpeg,image/png,image/gif" >
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="addItem()">
                    确认添加
                </button>
            </div>
        </div>
    </div>
</div>
<%--修改定价modal--%>
<div class="modal fade" id="priceModal" tabindex="-1" role="dialog" aria-labelledby="priceModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="priceModalLabel">
                    修改定价
                </h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <label for="clistprice">商品定价</label>
                        <div class="input-group">
                            <input id="clistprice" type="text" class="form-control" placeholder="请输入商品定价">
                            <span class="input-group-addon">.0</span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    确认修改
                </button>
            </div>
        </div>
    </div>
</div>
<%--修改库存--%>
<div class="modal fade" id="invenModal" tabindex="-1" role="dialog" aria-labelledby="invenModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="invenModalLabel">
                    修改库存
                </h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <label for="inveQuan">库存数量</label>
                        <input id="inveQuan" type="text" class="form-control" placeholder="请输入商品库存">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    确认修改
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
                <li><a href="<%=request.getContextPath()%>/catelogMg">品类</a></li>
                <li><a class="active" href="<%=request.getContextPath()%>/itemMg">商品</a></li>
            </ul>
        </div>
        <div class="main-content">
            <!--用于弹出信息-->
            <div class="" hidden="true"></div>
            <div class="content-item">
                <h4>商品列表</h4>
                <div class="ci-header-extra">
                    <a class="btn btn-success" data-toggle="modal" data-target="#iModal">添加商品</a>
                </div>
                <!--主体部分-->
                <div class="ci-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th><span>商品ID</span></th>
                            <th><span>商品名称</span></th>
                            <th><span>进价（元）</span></th>
                            <th><span>售价（元）</span></th>
                            <th><span>库存（个）</span></th>
                            <th><span>操作</span></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="bigItem" items="${bigItemList}">
                            <tr>
                                <td><span>${bigItem.item.itemId}</span></td>
                                <td><span>${bigItem.item.name}</span></td>
                                <td><span>${bigItem.item.unitcost}</span></td>
                                <td><span>${bigItem.item.listprice}</span></td>
                                <td><span>${bigItem.inventory.inveQuan}</span></td>
                                <td><span>
                                        <a class="btn btn-info" data-toggle="modal" data-target="#priceModal">修改定价</a>
                                        </span>
                                    <span>
                                        <a class="btn btn-success" data-toggle="modal" data-target="#invenModal">修改库存</a>
                                        </span>
                                    <span>
                                        <a class="btn btn-danger">删除</a>
                                        </span>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- 底部信息没有数据时显示 -->
                <div class="ci-footer">
                    <span <c:if test="${bigItemList.size() > 0}">hidden="true"</c:if>>尚未添加任何商品</span>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/admin/item.js"></script>
<script src="js/widge/alert.js"></script>
<script src="js/uploads/ajaxfileupload.js"></script>
</body>
</html>