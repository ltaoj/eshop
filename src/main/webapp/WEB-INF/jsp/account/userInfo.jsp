<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/21
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/includeTop.jsp" %>

<div class="layui-tab user_info">
    <ul class="layui-tab-title" >
        <li style="width: 30%"></li>
        <li class="layui-this">个人信息修改</li>
        <li></li>
        <li>收获地址</li>
        <li></li>
        <li>密码修改</li>
    </ul>
    <div class="layui-tab-content">

        <div class="layui-tab-item "></div>
        <!--信息修改-->
        <div class="layui-tab-item layui-show content">
            <br>
            <br>
            <br>
            <form class="layui-form" action="">
                <!--用户头像-->
                <div class="layui-form-item">
                    <label class="layui-form-label">头  像:</label>
                    <img src="images/user/avatar.jpg" style="width: 100px;height: 100px">
                    <button type="button" class="layui-btn" id="test1">
                        <i class="layui-icon">&#xe67c;</i>上传图片
                    </button>
                </div>
                <br>
                <!--用户ID-->
                <div class="layui-form-item">
                    <label class="layui-form-label">用户ID:</label>
                    <div class="layui-input-block">
                        <input type="text" id="user_id" value="<c:out value='${user.loginId}'/>"  autocomplete="off" class="layui-input" style="width: 300px" readonly="readonly">
                    </div>
                </div>
                <br>
                <!--昵称-->
                <div class="layui-form-item">
                    <label class="layui-form-label">昵  称:</label>
                    <div class="layui-input-block">
                        <input type="text" id="username" value="<c:out value='${user.name}'/>"  autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <br>
                <!--性别-->
                <div class="layui-form-item">
                    <label class="layui-form-label">性  别:</label>
                    <div class="layui-input-block">
                        <input type="text" id="sex" <c:if test="${user.sex == 0}">value="女"</c:if><c:if test="${user.sex == 1}">value="男"</c:if> autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <br>
                <!--邮箱-->
                <div class="layui-form-item">
                    <label class="layui-form-label">邮  箱:</label>
                    <div class="layui-input-block">
                        <input type="text" id="email" value="<c:out value='${user.email}'/>"  autocomplete="off" class="layui-input" style="width: 300px">
                    </div>
                </div>
                <br>
                <!--手机号码-->
                <div class="layui-form-item">
                    <label class="layui-form-label">手机号码:</label>
                    <div class="layui-input-block">
                        <input type="text" id="phone" value="<c:out value='${user.phone}'/>"  autocomplete="off" class="layui-input" style="width: 300px" >
                    </div>
                </div>
                <br>
                <!--保存修改-->
            </form>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" onclick="upUserInfo()">保存修改</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </div>
        <div class="layui-tab-item "></div>
        <!--收获地址-->
        <div class="layui-tab-item ">

            <br>
            <table class="layui-table">
                <colgroup>
                    <col width="70">
                    <col width="70">
                    <col width="150">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th >收货人</th>
                    <th >联系方式</th>
                    <th >地址</th>
                    <th >操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="addr" items="${addrList}">
                    <tr>
                        <td>${addr.aliasName}</td>
                        <td>${addr.phone}</td>
                        <td>${addr.province}${addr.city}${addr.district}${addr.detailAddr}</td>
                        <td>
                            <span class="layui-badge" onclick="deleteAddr(${addr.addrId})">删除</span>
                            <span class="layui-badge layui-bg-green">修改</span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <button class="layui-btn add_address" id="add_address">
                <i class="layui-icon">&#xe608;</i> 新增收货地址
            </button>
        </div>
        <div class="layui-tab-item "></div>
        <!--密码修改-->
        <div class="layui-tab-item content">
            <br>
            <br>
            <form class="layui-form" action="">
                <!--初始密码-->
                <div class="layui-form-item">
                    <label class="layui-form-label">初始密码:</label>
                    <div class="layui-input-block">
                        <input type="password" id="origin_password"  autocomplete="off" class="layui-input" style="width: 300px" placeholder="请输入初始密码">
                    </div>
                </div>
                <br>
                <!--新密码-->
                <div class="layui-form-item">
                    <label class="layui-form-label"> 新密码:</label>
                    <div class="layui-input-block">
                        <input type="password" id="new_password"  autocomplete="off" class="layui-input" style="width: 300px" placeholder="请输入新密码">
                    </div>
                </div>
                <br>
                <!--确认密码-->
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码:</label>
                    <div class="layui-input-block">
                        <input type="password" id="required_password"   autocomplete="off" class="layui-input" style="width: 300px" placeholder="请再次输入新密码">
                    </div>
                </div>
                <br>
            </form>
            <!--保存修改-->
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" onclick="changePwd()">保存修改</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    $('#add_address').on('click', function(){
        layer.open({
            type: 2, //弹出层的类型
            title: '',//弹出框的标题
            maxmin: false,//最大最小化
            shadeClose: true, //点击遮罩关闭层
            area : ['400px' , '600px'],//区域大小面积
            content: 'addressModal'//打开之后呈现的html内容
        });
    });

    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
</script>
<%--special css--%>
<link rel="stylesheet" href="css/account/userInfo.css"/>
<%--special script--%>
<script src="js/account/userInfo.js"></script>
</body>
</html>
