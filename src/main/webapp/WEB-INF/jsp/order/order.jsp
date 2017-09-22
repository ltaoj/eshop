<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/22
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的订单</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="plugin/layui/css/layui.css"/>
    <!--引入js文件-->
    <script src="js/jquery/jquery-3.2.1.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script src="plugin/layui/layui.js"></script>
</head>
<body>

<div class="navigation">
    <table>
        <tr>
            <td style="width: 80%"><img src="images/main/text.png"></td>

            <td style="width: 200px"><a href="/myInfo"><img src="images/main/user.png" id="login"></a></td>

            <td><img src="images/main/cart.png"></td>
        </tr>
    </table>
</div>


<fieldset class="layui-elem-field layui-field-title" >
    <legend>我的订单</legend>
</fieldset>
<br>
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this">所有订单<span class="layui-badge layui-bg-blue">99</span></li>
        <li> 待付款<span class="layui-badge layui-bg-green">2</span></li>
        <li> 已取消<span class="layui-badge">5</span></li>
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
                <tr>
                    <td>09Z16</td>
                    <td>2017-09-11</td>
                    <td><img src="images/preview/pan-6/pink_pan2.png"></td>
                    <td>德国进口精致不锈钢奶锅</td>
                    <td>189.0</td>
                    <td>1</td>
                    <td>蓝色不梦幻</td>
                    <td>18079086223</td>
                    <td>湖南省长沙市天心区铁道学院</td>
                    <td>189.0</td>
                    <td><span class="layui-badge" id="delete">删除订单</span></td>
                    <td><span class="layui-badge layui-bg-green">待付款</span></td>
                </tr>
                <!--第二行取消商品-->
                <tr>
                    <td>09Z17</td>
                    <td>2017-03-09</td>
                    <td><img src="images/preview/eyeshade&neckpillow-9/red_neckpillow1.png"></td>
                    <td>国产优质棉花填充枕颈</td>
                    <td>39.0</td>
                    <td>1</td>
                    <td>哇哈哈</td>
                    <td>13214523564</td>
                    <td>北京市朝阳区明珠花园</td>
                    <td>39.0</td>
                    <td><span class="layui-badge" id="delete">删除订单</span></td>
                    <td><span class="layui-badge">已取消</span></td>
                </tr>
                <!--第三行已付商品-->
                <tr>
                    <td>09Z1</td>
                    <td>2017-01-11</td>
                    <td><img src="images/preview/box-8/yellow_box2.png"></td>
                    <td>品质棉麻衣物收纳袋</td>
                    <td>89.0</td>
                    <td>1</td>
                    <td>忘词王</td>
                    <td>18179287293</td>
                    <td>江西省新余市大一中学</td>
                    <td>89.0</td>
                    <td><span class="layui-badge" id="delete">删除订单</span></td>
                    <td><span class="layui-badge layui-bg-blue">已付款</span></td>
                </tr>
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
                <tr>
                    <td>082g1</td>
                    <td>2017-09-11</td>
                    <td><img src="images/preview/pan-6/pink_pan2.png"></td>
                    <td>德国进口精致不锈钢奶锅</td>
                    <td>189.0</td>
                    <td>1</td>
                    <td>蓝色不梦幻</td>
                    <td>18079086223</td>
                    <td>湖南省长沙市天心区铁道学院</td>
                    <td>189.0</td>
                    <td>
                        <span class="layui-badge layui-bg-green">立即付款</span>
                        <span class="layui-badge" id="delete">取消订单</span>
                    </td>
                </tr>
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
                <tr>
                    <td>082g2</td>
                    <td>2017-09-11</td>
                    <td><img src="images/preview/pan-6/pink_pan2.png"></td>
                    <td>德国进口精致不锈钢奶锅</td>
                    <td>189.0</td>
                    <td>1</td>
                    <td>蓝色不梦幻</td>
                    <td>18079086223</td>
                    <td>湖南省长沙市天心区铁道学院</td>
                    <td>189.0</td>
                    <td><span class="layui-badge" id="delete">删除订单</span></td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>
</div>


<script type="text/javascript">
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
</script>
</table>


</body>
</html>
