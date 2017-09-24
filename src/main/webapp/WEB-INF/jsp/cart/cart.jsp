<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/21
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/includeTop.jsp" %>
<!--我的购物车-->
<fieldset class="layui-elem-field">
    <legend>我的购物车</legend>
    <div class="layui-field-box">
        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="150">
                <col width="150">
                <col width="150">
                <col width="150">
            </colgroup>
            <thead>
            <tr>
                <th>选中</th>
                <th>商品</th>
                <th>描述</th>
                <th>单价</th>
                <th>数量</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cartitem" items="${cartitemList}">
                <tr>
                    <td><input name="choose" id="" type="checkbox"></td>
                    <td><img src="images/preview/pan-6/pink_pan2.png"></td>
                    <td>德国进口精致不锈钢奶锅</td>
                    <td>${cartitem.unitprice}</td>
                    <td>
                        <table>
                            <tr>
                                <td id="demo"><a href="#"><span id="minus"></span></a></td>
                                <td>
                                    <span id="count">${cartitem.quantity}</span>
                                </td>
                                <td id="demo2"><a href="#"><span id="add"></span></a></td>
                            </tr>
                        </table>
                    </td>
                    <td><a href="#"><span class="layui-badge layui-bg-cyan" id="modify">编辑</span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <br>
        <br>
        <div class="table">
            <table>
                <tr>
                    <td style="width: 60%"><input name="choose" id="" type="checkbox">  全选（共计：${cartitemList.size()}件）</td>
                    <td style="width: 15%">合计: </td>
                    <td style="width: 15%">
                        <button class="layui-btn layui-btn-danger">删除</button>
                        <button class="layui-btn">去结算</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</fieldset>
<script type="text/javascript">

    $(document).ready(function(){
        $("#demo").hide();
        $("#demo2").hide();
        //$(".hide").hide();
    });

    $('#modify').on('click', function(){
        //点击之后将input输入框变为不可编辑
        //$('#product_count').attr("disabled",false);
        //改变span的样式
        var content=$("#modify").text();
        if(content=="编辑")
        {
            $("#modify").attr("class", "layui-badge layui-bg-green");
            //完成字样
            $("#modify").text("完成");

            $("#demo").show();
            $("#demo2").show();
            $("#minus").text("-");
            $("#add").text("+");
        }
        else
        {
            $("#modify").attr("class", "layui-badge layui-bg-cyan");
            //完成字样
            $("#modify").text("编辑");

            $("#demo").hide();
            $("#demo2").hide();
        }


    });

    $('#demo').on('click', function(){

        var count=$('#count').text();
        if(count!=1)
        {
            count--;
        }
        $('#count').text(count);

    });

    $('#demo2').on('click', function(){

        var count=$('#count').text();
        count++;
        $('#count').text(count);

    });
</script>
</body>
</html>
