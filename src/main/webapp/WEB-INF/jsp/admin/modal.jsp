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
                        <label for="listprice">库存数量</label>
                        <div class="input-group">
                            <input id="listprice" type="text" class="form-control" placeholder="请输入商品库存">
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