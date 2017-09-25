<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/21
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>按商品颜色分类</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="plugin/layui/css/layui.css"/>
    <link rel="stylesheet" href="css/product/search.css" />
    <!--引入js文件-->
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="plugin/layui/layui.js"></script>
    <script src="js/product/searchByColor.js"></script>
    <script src="js/product/searchByName.js"></script>
</head>
<body>
<div class="mainbody">
    <div class="longPic">
        <ul>
            <!--<tr><td><img src="../images/main/logo.png" ></td></tr>-->
            <li></li>
            <li><a href="<%=request.getContextPath()%>/"><img class="icon" src="images/shape/home.png" /></a></li>
            <li><a href="<%=request.getContextPath()%>/shapeRes"><img class="icon" src="images/shape/shape.png" /></a></li>
            <li><a href="<%=request.getContextPath()%>/colorRes"><img class="icon" src="images/shape/color.png" /></a></li>
            <li><a href="<%=request.getContextPath()%>/viewCart"><img class="icon" src="images/shape/cart.png" /></a></li>
            <li><a href="<%=request.getContextPath()%>/orderList"><img class="icon" src="images/shape/bill.png" /></a></li>
            <li><a href="###"><img class="icon" src="images/shape/service.png" /></a></li>
        </ul>
    </div>

    <div class="body-right">
        <div class="br-right">
            <!--商品搜索框-->
            <div class="search">
                <ul>
                    <li><input type="text" id="search" name="keyword" placeholder="请输入商品名称" autocomplete="off" class="layui-input" style="width: 200px"></li>
                    <li><button class="layui-btn layui-btn-radius"><img onclick="searchByName()" src="images/shape/zoom.png" style="width: 24px;height: 24px"></li>
                </ul>
            </div>

            <!--按颜色分类-->
            <div class="color">
                <table>
                    <tr>
                        <td><img id="红色" onclick="searchByColor(this)" src="images/color/red.png" style="width: 40px;height: 40px"></td>
                        <td>&nbsp;</td>
                        <td><img id="粉色" onclick="searchByColor(this)" src="images/color/pink.png" style="width: 40px;height: 40px"></td>
                        <td>&nbsp;</td>
                        <td><img id="粉红色" onclick="searchByColor(this)" src="images/color/rose.png" style="width: 40px;height: 40px"></td>
                        <td>&nbsp;</td>
                        <td><img id="黄色" onclick="searchByColor(this)" src="images/color/yellow.png" style="width: 40px;height: 40px"></td>
                        <td>&nbsp;</td>
                        <td><img id="绿色" onclick="searchByColor(this)" src="images/color/green.png" style="width: 40px;height: 40px"></td>
                        <td>&nbsp;</td>
                        <td><img id="黑色" onclick="searchByColor(this)" src="images/color/black.png" style="width: 40px;height: 40px"></td>
                    </tr>
                </table>
            </div>
        </div>

        <!--商品展示区-->
        <div id="pic" class="pic">
            <img src="images/preview/cup-5/black_cup1.png" id="" class="product" onclick="itemDetail(1)"/>
            <img src="images/preview/cup-5/black_cup1.png" id="" class="product" onclick="itemDetail(1)"/>
            <img src="images/preview/cup-5/black_cup1.png" id="" class="product" onclick="itemDetail(1)"/>
            <img src="images/preview/cup-5/black_cup1.png" id="" class="product" onclick="itemDetail(1)"/>
            <img src="images/preview/cup-5/black_cup1.png" id="" class="product" onclick="itemDetail(1)"/>
            <img src="images/preview/cup-5/black_cup1.png" id="" class="product" onclick="itemDetail(1)"/>
            <img src="images/preview/cup-5/black_cup1.png" id="" class="product" onclick="itemDetail(1)"/>
            <img src="images/preview/cup-5/black_cup1.png" id="" class="product" onclick="itemDetail(1)"/>
        </div>
    </div>
</div>
<script type="text/javascript">
    $('#black_cup1').on('click', function(){
        layer.open({
            type: 2, //弹出层的类型
            title: '',//弹出框的标题
            maxmin: false,//最大最小化
            shadeClose: true, //点击遮罩关闭层
            area : ['800px' , '520px'],//区域大小面积
            content: 'itemForm.html'//打开之后呈现的html内容
        });
    });
</script>
</body>
</html>