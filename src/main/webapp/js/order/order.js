/**
 * Created by lenovo on 2017/9/24.
 */
/**
 * 删除订单
 * @param orderId
 */
function deleteOrder(orderId) {
    $.ajax({
        url: 'delOrder?orderId=' + orderId,
        method: 'GET',
        success: function (data) {
            console.log(data);
            // 删除成功后服务器返回 {"result": "success", "object": "订单删除成功", "message": "操作成功"}
            // var msg = data.object
            // 可将此msg显示在合适的位置
            // 删除失败后服务器返回 {"code": code, "message": message}
        }
    })
}

/**
 * 取消订单
 * @param orderId
 */
function cancelOrder(orderId) {
    $.ajax({
        url: 'cancelOrder?orderId=' + orderId,
        method: 'GET',
        success: function (data) {
            console.log(data);
        }
    })
}