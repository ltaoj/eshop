<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/25
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="supplierModal" tabindex="-1" role="dialog" aria-labelledby="supplierModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="supplierModalLabel">
                    添加供货商
                </h4>
            </div>
            <div class="modal-body">
                <form role="form" class="form-inline">
                    <div class="form-group">
                        <label for="supplierId">供货商ID</label>
                        <div class="input-group">
                            <input id="supplierId" type="text" class="form-control" placeholder="请输入供货商ID">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name">姓名</label>
                        <div class="input-group">
                            <input id="name" type="text" class="form-control" placeholder="请输入姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phone">手机号</label>
                        <div class="input-group">
                            <input id="phone" type="text" class="form-control" placeholder="请输入手机号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sex">性别</label>
                        <div class="input-group">
                            <input id="sex" type="text" class="form-control" placeholder="请输入城市">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email">邮箱</label>
                        <div class="input-group">
                            <input id="email" type="text" class="form-control" placeholder="请输入邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="province">省份</label>
                        <div class="input-group">
                            <input id="province" type="text" class="form-control" placeholder="请输入省份">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="city">城市</label>
                        <div class="input-group">
                            <input id="city" type="text" class="form-control" placeholder="请输入城市">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    确认添加
                </button>
            </div>
        </div>
    </div>
</div>