<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/21
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="plugin/layui/css/layui.css"/>
<!--引入js文件-->
<script src="js/jquery/jquery-3.2.1.min.js"></script>
<script src="js/layer/layer.js"></script>
<script src="plugin/layui/layui.js"></script>

<style type="text/css">
    .text
    {
        font-size: 25px;
        font-family: sans-serif;
        color: #696969;
    }
    .description
    {
        position: absolute;
        left: 68px;
        top:50px;
    }
    .price
    {
        position: absolute;
        left: 180px;
        bottom: 50px;
    }
</style>


<div>
    <br>
    <br>
    <table>
        <tr>
            <td><img src="images/preview/cup-5/black_cup1.png"></td>
            <td style="width: 100px"></td>
            <td>数量：
                <button id="minus" class="layui-btn layui-btn-radius layui-btn-primary">-</button>

                <input type="text" name="item_count" id="count" value="1" style="width: 50px">

                <button id="add" class="layui-btn layui-btn-radius layui-btn-primary">+</button>
            </td>
        </tr>

        <tr>
            <td></td>
            <td><button class="layui-btn layui-btn-big">加入购物车</button></td>
        </tr>
    </table>

    <div class="description"><p><span class="text">德国进口黑色琉璃水晶杯</span></p></div>

    <div class="price"><p><span class="text">19.8 × </span>
        <span class="text" id="count1">1</span></p>
    </div>

</div>

<script type="text/javascript">

    $('#add').on('click', function(){
        var count  = $('#count').val();//获取初始值
        count++;
        $('#count').val(count);

    });

    $('#minus').on('click', function(){
        var count  = $('#count').val();//获取初始值
        if(count!=1)
        {
            count--;
            $('#count').val(count);

        }

    });
</script>
