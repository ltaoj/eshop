/**
 * Created by lenovo on 2017/9/26.
 */
function addItem() {
    var itemId = $("#itemId").val();
    var name = $("#name").val();
    var categoryId = $("#categoryId").val();
    var listprice = $("#listprice").val();
    var unitcost = $("#unitcost").val();
    var attr1 = $("#attr1").val();
    var attr2 = $("#attr2").val();
    var json = {isStock: 0, itemId: itemId, name: name, categoryId: categoryId, listprice: listprice, unitcost: unitcost, attr1: attr1, attr2: attr2}
    $.ajaxFileUpload({
        url: 'addItem',
        secureuri: false,
        data: json,
        fileElementId: 'itemPic',
        dataType: 'json',
        success: function (data, status) {
            $("#alert").html("");
            $("#iModal").modal("hide");
            if (data.result == "success") {
                window.parent.location.reload();
            } else {
                $("#alert").html(alert("danger", "添加失败"));
            }
        },
        error: function (data, status, e) {
            $("#alert").html(alert("danger", "服务器错误"));
        }
    })
}