/**
 * Created by lenovo on 2017/9/26.
 */
function addToCart(itemId, unitprice) {
    var quantity = $("#count1").text();
    var json = {itemId: itemId, unitprice: unitprice, quantity: quantity};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'addToCart',
        method: 'POST',
        dataType: "json",
        data: JSON.stringify(json),
        success: function (data) {
            if (data.result == "success") {
                layer.msg(data.object);
                layer.close(2);
            } else if (data.code == 15) {
                layer.msg(data.message);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if (textStatus == "302"){
                window.parent.location.href = "login";
            } else {
                layer.msg("服务器错误");
            }
        }
    })
}