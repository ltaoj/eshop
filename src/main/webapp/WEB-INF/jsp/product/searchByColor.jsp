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
    <!--引入js文件-->
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="plugin/layui/layui.js"></script>
</head>
<body>

<style type="text/css">

    .longPic
    {
        margin-left: 50px;

    }
    .container
    {
        background-image: url(images/main/longPic.png);
        width: 12%;
        height: 1000px;
    }
    .color
    {
        position:absolute;
        right: 6%;
        top: 8%;
    }
    .product
    {
        width: 250px;
        height: 250px;
    }
    .pic
    {
        position:absolute;
        left:200px;
        top:110px;
    }
    .search
    {
        position:absolute;
        left: 20%;
        top: 8%;
    }
</style>

<div class="container">
    <div class="longPic">
        <table>
            <!--<tr><td><img src="../images/main/logo.png" ></td></tr>-->

            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td><a href="<%=request.getContextPath()%>/"><img class="icon" src="images/shape/home.png"></a></td>
            </tr>

            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td><a href="<%=request.getContextPath()%>/shapeRes"><img class="icon" src="images/shape/shape.png" /></a></td>
            </tr>

            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/colorRes"><img class="icon" src="images/shape/color.png" /></a></td></tr>

            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/viewCart"><img class="icon" src="images/shape/cart.png" /></a></td></tr>

            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td><a href="<%=request.getContextPath()%>/orderList"><img class="icon" src="images/shape/bill.png"></a>></td></tr>

            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td>&nbsp;</td></tr>
            <tr><td><a href="###"><img class="icon" src="images/shape/service.png" /></a></td></tr>

        </table>
    </div>
</div>


<!--商品搜索框-->
<div class="search">
    <table>
        <tr>
            <td> <input type="text" id="search" name="keyword" placeholder="请输入商品名称" autocomplete="off" class="layui-input" style="width: 200px"></td>
            <td>&nbsp;&nbsp;</td>
            <td><button class="layui-btn layui-btn-radius"><img onclick="searchByName()" src="images/shape/zoom.png" style="width: 24px;height: 24px"></button></td>
        </tr>
    </table>
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

<!--商品展示区-->
<div class="pic">
    <table>
        <tr>
            <td><img id="black_cup1" class="product" src="images/preview/cup-5/black_cup1.png"></td>
            <td><img class="product" src="images/preview/cup-5/black_cup2.png"></td>
            <td><img class="product" src="images/preview/bed-12/black_bed5.png"></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </table>
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